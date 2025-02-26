package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.author) LIKE CONCAT('%', LOWER(:author), '%')")
    List<Book> findByAuthor(@Param("author") String author);

    @Query("SELECT COUNT(b) FROM Book b WHERE LOWER(b.author) LIKE CONCAT('%', LOWER(:author), '%')")
    int countByAuthor(String author);
}
