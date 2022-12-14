import {ChangeDetectorRef, Component, OnDestroy} from '@angular/core';
import {SearchService} from "../utility/search.service";
import {Movie} from "../model/movie.model";
import {finalize, ReplaySubject, takeUntil} from "rxjs";

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnDestroy {
  query: string | undefined;
  movieResult: Movie | undefined;
  isLoadingResults = false;
  private readonly destroy$ = new ReplaySubject<boolean>();

  constructor(private readonly searchService: SearchService,
              private readonly changeDetectorRef: ChangeDetectorRef) {
  }

  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.complete();
  }

  search(query: string | undefined) {
    if (query) {
      this.isLoadingResults = true;
      this.searchService.getMovieByTitle(query)
        .pipe(
          takeUntil(this.destroy$),
          finalize(() => this.isLoadingResults = false)
        )
        .subscribe(data => {
          this.movieResult = data;
          console.log(this.movieResult)
          this.changeDetectorRef.markForCheck();
        });
    }
  }
}
