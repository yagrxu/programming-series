import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from './../environments/environment';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private http: HttpClient) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': 'localhost'
      })
    };
    const that: any = this;
    this.http.get(environment.apiUrl, httpOptions).subscribe((res) => {
      that.persons = res;
      console.log(that.persons);
    });
  }
  title = 'angular-demo';
  persons = [{
    firstName: 'Yagr',
    lastName: 'Xu'
  }];
}
