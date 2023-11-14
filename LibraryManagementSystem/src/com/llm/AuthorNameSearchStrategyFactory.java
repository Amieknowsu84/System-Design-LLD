package com.llm;

public class AuthorNameSearchStrategyFactory implements SearchStrategyFactory{

    @Override
    public SearchStrategy createSearchStrategy() {
        return new AuthorNameSearchStrategy();
    }
}
