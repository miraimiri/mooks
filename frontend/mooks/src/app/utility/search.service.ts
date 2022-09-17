import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Movie} from "../model/movie.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SearchService{

  API_URL = 'http://localhost:8080/';

  constructor(private readonly http: HttpClient) { }

  getPopularMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.API_URL + 'movies/popular');
  }

  getMovieByTitle(query: string): Observable<Movie> {
    return this.http.get<Movie>(this.API_URL + 'movie/title/' + query);
  }

}
