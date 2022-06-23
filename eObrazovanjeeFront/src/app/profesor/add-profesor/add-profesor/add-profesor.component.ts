import { Component, OnInit } from '@angular/core';
import { ProfesorService } from '../../profesor.service';

@Component({
  selector: 'app-add-profesor',
  templateUrl: './add-profesor.component.html',
  styleUrls: ['./add-profesor.component.css']
})
export class AddProfesorComponent implements OnInit {
    ime = '';
    prezime = '';
    password = '';
    user = '';

  constructor(private profesorService: ProfesorService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log('ime', this.ime);
    console.log('prezime', this.prezime);
    console.log('password', this.password);
    console.log('user', this.user);

    this.profesorService.saveProfesor()
      .subscribe(data => {
        console.log('data', data);
      })
  }

}
