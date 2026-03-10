import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = '/api/users';

  constructor(private http: HttpClient) { }

  register(user: any): Observable<any> {
    return this.http.post(this.apiUrl + '/register', user);
  }

  login(credentials: any): Observable<any> {
    const headers = new HttpHeaders({
      authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    });
    return this.http.get('/', { headers, responseType: 'text' as 'json' });
  }

  logout(): Observable<any> {
    return this.http.post('/logout', {}, { responseType: 'text' as 'json' });
  }
}
