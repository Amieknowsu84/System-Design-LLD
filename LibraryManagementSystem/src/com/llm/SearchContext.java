package com.llm;

import java.util.List;

public class SearchContext {

    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> executeSearch(String query) {
        return strategy.search(query);
    }

}
