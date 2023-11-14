package com.llm;

public class ISBNSearchStrategyFactory implements SearchStrategyFactory{

    @Override
    public SearchStrategy createSearchStrategy() {
        return new ISBNSearchStrategy();
    }
}
