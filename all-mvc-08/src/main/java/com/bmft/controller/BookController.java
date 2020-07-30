package com.bmft.controller;

import com.bmft.pojo.Books;
import com.bmft.service.BookService;
import jdk.nashorn.internal.runtime.Logging;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@Data
//@RestController("")//父请求 请求拼装,写到子类下，用的时候才会提示
public class BookController {
    //1.导入正确的包 创建全局longer对象
    static Logger logger = Logger.getLogger(Logging.class);
    @Qualifier("bookServiceImpl")//注解注入字段值
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/book/allBooks")
    public String allBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "allBooks";
    }

    @GetMapping("/book/toAddBook")
    public String toAddBook(Model model) {

        return "addBook";
    }

    @PostMapping("/book/addBook")
    public String addBook(Model model, Books books) {
        System.out.println("===book:" + books);
        int i = bookService.insertBook(books);
        if (i > 0) {
            logger.info("【添加书籍成功】");
            model.addAttribute("message", "【添加书籍成功】");
        } else {
            logger.info("【添加书籍失败】");
            model.addAttribute("message", "【添加书籍失败】");
        }
        //返回页面，给出提示.
        model.addAttribute("books", bookService.getBooks());
        return "allBooks";
    }

    @GetMapping("/book/toUpdateBook")
    public String toUpdateBook(Model model, @RequestParam("id") int id) {

        Books bookById = bookService.getBookById(id);
        model.addAttribute("book", bookById);
        //跳转到书籍修改页面

        return "updateBook";
    }

    @PostMapping("/book/updateBook")
    public String updateBook(Model model, Books book) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("bookId", book.getBookID());
        //这里可以添加判断之类的，这里不赘述
        map.put("bookName", book.getBookName());
        map.put("bookCounts", book.getBookCounts());
        map.put("detail", book.getDetail());
        int i = bookService.updateBook(map);
        if (i > 0) {
            model.addAttribute("message", "修改成功");
        } else {
            model.addAttribute("message", "修改失败");

        }
        //跳转书籍页面
        model.addAttribute("books", bookService.getBooks());
        return "allBooks";
    }

    //删除书使用restFul风格,其实应该用表单post提交，但是这里就功能展示，RestFull.
    @GetMapping("/book/deleteBook/{id}")
    public String deleteBook(Model model, @PathVariable("id") int id) {
        int i = bookService.deleteBookById(id);
        if (i > 0) {
            model.addAttribute("message", "删除成功");
        } else {
            model.addAttribute("message", "删除失败");

        }
        //跳转书籍页面
        model.addAttribute("books", bookService.getBooks());
        return "allBooks";
    }
    @PostMapping("/book/searchBooks")
    public String searchBooks(Model model, Books books) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("bookName","%"+books.getBookName()+"%");
        System.err.println(map);
        //跳转书籍页面
        model.addAttribute("books", bookService.searchBooks(map));
        return "allBooks";
    }


}
