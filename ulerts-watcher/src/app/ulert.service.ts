import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { Ulert } from './ulert';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UlertService {
  private ulertUrl = ''; // API URL

  constructor(
    private http: HttpClient) { }

  // Get Ulert by phone
  getUlertByPhone<Data>(phone: number): Observable<Ulert> {
    const url = `${this.ulertUrl}/?phone=${phone}`;
    return this.http.get<Ulert>(url).pipe(
      map(ulerts => ulerts[0]),
      tap(u => {
        const message = u ? `returned` : `not found`;
        this.log(`ulert with ${phone} was ${message}`);
      }),
      catchError(this.handleError<Ulert>(`getUlert phone=${phone}`))
    );
  }

  // Add Ulert
  addUlert(ulert: Ulert): Observable<Ulert> {
     return this.http.post<Ulert>(this.ulertUrl, ulert, httpOptions).pipe(
      tap((ulert: Ulert) => this.log(`added ulert with id=${ulert.id}`)),
      catchError(this.handleError<Ulert>('addUlert'))
    );
  }
   getUlert(): Observable<Ulert[]> {
    return this.http.get<Ulert[]>(this.ulertUrl)
      .pipe(
        tap(ulerts => this.log(`fetched ulerts`)),
        catchError(this.handleError('getUlerts', []))
      );
  }
  updateUlert(ulert: Ulert): Observable<any> {
    return this.http.put(this.ulertUrl, ulert, httpOptions).pipe(
      tap(_ => this.log(`ulert with id ${ulert.id} updated`)),
      catchError(this.handleError<any>('updateUlert'))
    );
  }


  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  private log(message: string) {
    // implement message service
  }
}
