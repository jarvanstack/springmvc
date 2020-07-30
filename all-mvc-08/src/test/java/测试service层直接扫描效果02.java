import com.bmft.dao.BookMapper;
import com.bmft.pojo.Books;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class 测试service层直接扫描效果02 {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
        List<Books> books = bookMapper.getBooks();
        for (Books book : books) {
            System.out.println(book);
        }
    }
}
