import { Directive, EventEmitter, HostListener, Input, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { FilesUploadComponent } from './files-upload.component';

@Directive({
  selector: '[appFilesUpload]'
})
export class FilesUploadDirective {

  @Input() multiple!:boolean; //si se puede subir mas de un archvio
  @Input() crop!:boolean; //administrar la edicion de la imagen

  @Output() changed = new EventEmitter<string | string[]>();

  //dialog es el pop up para subir imagenes
  constructor(private dialog: MatDialog) { }

  //metodo decorator de angular que es usado para escuchar y manjear eventos del dom
  @HostListener('click', ['evente']) onClick(){
    this.openDialog();
  }


  private openDialog(): void {

    const dialogRef = this.dialog.open(FilesUploadComponent, {
      width: '550px',
      height: '500px'
    });

    dialogRef.afterClosed().subscribe(result => {
      this.changed.emit(result || null);
    });

  }

}
