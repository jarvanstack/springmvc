package com.bmft.service;

import com.bmft.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface BookService {
    //增
    int insertBook(Books books);

    //删
    int deleteBookById(int id);

    //改
    int updateBook(Map<String, Object> map);

    //查
    Books getBookById(int id);

    List<Books> getBooks();

    //搜索书本
    List<Books> searchBooks(Map<String, Object> map);
}
