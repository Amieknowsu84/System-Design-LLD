package com.llm;

import java.util.List;

public interface SearchStrategy {

    List<Book> search(Object searchParameter);
    //List<Book> search(Object searchParameter, List<Book> books);


    void validateQueryValue(Object searchParameter);

}
