package com.cgmdev.springbootmicroserviceapigateway.security.jwt;

import com.cgmdev.springbootmicroserviceapigateway.entity.User;
import com.cgmdev.springbootmicroserviceapigateway.security.UserPrincipal;
import com.cgmdev.springbootmicroserviceapigateway.utils.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtProviderImp implements JwtProvider{

    @Value("${app.jwt.secret}")
    private String JWT_SECRET;

    @Value("${app.jwt.expiration-in-ms}")
    private Long JWT_SECRET_IN_MS;

    @Override
    public String generateToken(UserPrincipal auth){
        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        Key key = Keys.hmacShaKeyFor((JWT_SECRET.getBytes(StandardCharsets.UTF_8)));

        return Jwts.builder()
                .setSubject(auth.getUsername())
                .claim("roles", authorities)//propiedad dentro de un token
                .claim("userId", auth.getId())
                .setExpiration(new Date(System.currentTimeMillis()+ JWT_SECRET_IN_MS))
                .signWith(key, SignatureAlgorithm.HS512)//algoritmo para descriptar
                .compact();

    }

    @Override
    //polimorfismo podemos sobrecargar metodos con diferentes parametros
    public String generateToken(User user){
        Key key = Keys.hmacShaKeyFor((JWT_SECRET.getBytes(StandardCharsets.UTF_8)));

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("roles", user.getRole())//propiedad dentro de un token
                .claim("userId", user.getId())
                .setExpiration(new Date(System.currentTimeMillis()+ JWT_SECRET_IN_MS))
                .signWith(key, SignatureAlgorithm.HS512)//algoritmo para descriptar
                .compact();

    }

    @Override
    public Authentication getAuthentication(HttpServletRequest request){
        Claims claims = extractClaims(request);
        if(claims == null){
            return null;
        }

        String username = claims.getSubject();//este es el username ya que lo init en la generacion del token
        Long userId = claims.get("userId", Long.class);
        Set<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SecurityUtils::convertToAuthority)
                .collect(Collectors.toSet());

        UserDetails userDetails = UserPrincipal.builder()
                .username(username)
                .authorities(authorities)
                .id(userId)
                .build();

        if(username == null) return null;

        return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
    }

    @Override
    public boolean isTokenValid(HttpServletRequest request){
        Claims claims = extractClaims(request);

        if(claims == null){
            return false;
        }

        return !claims.getExpiration().before(new Date());
    }


    private Claims extractClaims(HttpServletRequest request){
        String token = SecurityUtils.extractAuthTokenFromRequest(request);

        if(token == null){
            return null;
        }

        Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        //retorno todos los valores del token
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
