import {Component, Input} from '@angular/core';
import { Movie } from '../model/movie.model';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss']
})
export class MovieComponent  {
  @Input() movie: Movie | undefined;
}
