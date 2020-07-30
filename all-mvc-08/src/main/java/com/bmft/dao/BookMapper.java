package com.bmft.dao;

import com.bmft.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository//使用注解配置bean 我们可以使用bookMapper直接访问，整合Mybatis后
//可以直接 访问到数据库么，测试一下
//但是我们在 spring-dao.xml 4 点中的操作直接 生成了booKMapper 的实现类
//所以这里的 bean的注解可以不需要了
public interface BookMapper {
    //增
    int insertBook(Books books);

    //删
    int deleteBookById(@Param("bookId") int bookId);

    //改
    int updateBook(Map<String, Object> map);

    //查
    Books getBookById(@Param("bookId") int bookId);
    List<Books> getBooks();
    //搜索书本
    List<Books> searchBooks(Map<String, Object> map);
}
