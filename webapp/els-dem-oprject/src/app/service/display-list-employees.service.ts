import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { retry } from 'rxjs/operator/retry';
import 'rxjs/add/operator/map';
import { Employee } from './Employee';
@Injectable({
  providedIn: 'root'
})
export class DisplayListEmployeesService {

  constructor(private http: Http) {
    //constructor
   }

  getAllEmployees(){
    return this.http.get("http://localhost:8080/api/listAllEmployee").map(
      u=>{
    let employser:Employee[] =u.json() as Employee[] 
    console.log('Employee:' + employser);
    return employser;
    }
   );
 }
 getAllEmployeesWithoutDeplicat(uCriteria : any) {
 return  	this.http.get("http://localhost:8080/api/listEmployee?uCreteria="+uCriteria)
   .map(
     u=>{
    let employser:Employee[] =u.json() as Employee[] ;
    console.log('Employee:' + employser);
    return employser;
   }
  );
   
    

   
   }
}
