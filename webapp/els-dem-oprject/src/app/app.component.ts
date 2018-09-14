import { Component } from '@angular/core';
import { DisplayListEmployeesService }      from './service/display-list-employees.service';
import { Employee } from './service/Employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  selecteCriteria: string = '';
  title = 'els-dem-oprject';
  listEmployees: Employee[];
  constructor(private displayListEmployeesService: DisplayListEmployeesService,) { }

  ngOnInit() {
  }

  //event handler for the select element's change event
  selectChangeHandler (event: any) {
   
    //update the ui
    this.selecteCriteria = event.target.value;
    console.log('selecteCriteria'+this.selecteCriteria);
    if( this.selecteCriteria == "All"){
        this.displayListEmployeesService.getAllEmployees().subscribe(emp => {
          console.log(emp);
          this.listEmployees = [];
          this.listEmployees =emp;
        });
    }else{
        this.displayListEmployeesService.getAllEmployeesWithoutDeplicat(this.selecteCriteria).subscribe(emp => {
          console.log(emp);
          this.listEmployees = [];
          this.listEmployees = emp;
        });
    }
  }
}
