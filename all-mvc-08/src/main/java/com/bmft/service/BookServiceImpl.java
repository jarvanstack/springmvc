package com.bmft.service;

import com.bmft.dao.BookMapper;
import com.bmft.pojo.Books;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service//自动注册到bean
@Data
public class BookServiceImpl implements BookService {
    //注解注入 字段值
    @Autowired
    @Qualifier("bookMapper")
    private BookMapper bookMapper ;


    //这里应该注入 BookMapper的实现类BookMapperImpl
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int insertBook(Books books) {
        return bookMapper.insertBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Map<String, Object> map) {
        return bookMapper.updateBook(map);
    }

    @Override
    public Books getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public List<Books> getBooks() {
        return bookMapper.getBooks();
    }

    @Override
    public List<Books> searchBooks(Map<String, Object> map) {
        return bookMapper.searchBooks(map);
    }
}
