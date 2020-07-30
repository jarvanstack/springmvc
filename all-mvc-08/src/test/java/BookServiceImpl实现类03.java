import com.bmft.dao.BookMapper;
import com.bmft.pojo.Books;
import com.bmft.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookServiceImpl实现类03 {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        List<Books> books = bookService.getBooks();
        for (Books book : books) {
            System.out.println(book);
        }
    }
}
