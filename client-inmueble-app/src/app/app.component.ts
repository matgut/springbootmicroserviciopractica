import { Component } from '@angular/core';
import { environment } from '@src/environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  showSpinner = false;
  title = 'client-inmueble-app';

  onToggleSpinner() : void {
    this.showSpinner  = !this.showSpinner;
  }
}
