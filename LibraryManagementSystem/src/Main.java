import com.llm.AuthorNameSearchStrategy;
import com.llm.SearchStrategy;
import com.llm.ISBNSearchStrategy;

public class Main {
    public static void main(String[] args) {

        String authour = " asdad";
        SearchStrategy catalog = new AuthorNameSearchStrategy();
        String isbn = "isbn";
        SearchStrategy isbnCatalog = new ISBNSearchStrategy();
        System.out.println("Hello world!");
    }
}