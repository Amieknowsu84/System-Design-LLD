package com.llm;

public class PublicationDateSearchStrategyFactory implements SearchStrategyFactory{

    @Override
    public SearchStrategy createSearchStrategy() {
        return new PublicationDateSearchStrategy();
    }
}
