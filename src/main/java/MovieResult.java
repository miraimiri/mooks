package main.java;

import java.util.List;

public class MovieResult {
    String searchType;
    String expression;
    List<main.java.MovieResultMovie> results;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<main.java.MovieResultMovie> getResults() {
        return results;
    }

    public void setResults(List<main.java.MovieResultMovie> results) {
        this.results = results;
    }
}
