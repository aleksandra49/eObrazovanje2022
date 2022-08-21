import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {

  loaded = false;
  student: any;
  id: string | null | undefined;



  constructor(private studentService: StudentService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getStudent();
  }

  getStudent() {
    this.studentService.getStudent(Number(this.id)).subscribe(res =>
      this.student = res.body);
  }

  edit(){
    this.studentService.editStudent(this.student).subscribe(
      () => window.location.reload()
    )
  }

  


}

