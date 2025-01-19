package com.library.controller;

import com.library.dto.BookDto;
import com.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
@Validated
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookDto addBook(@RequestBody @Valid BookDto dto) {
        return bookService.addBook(dto);
    }

    @GetMapping("/{bookId}")
    public BookDto getBook(@PathVariable final Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/{bookId}")
    public BookDto updateBookById(@PathVariable final Long bookId, @RequestBody BookDto updated) {
        return bookService.updateBookById(bookId, updated);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBookById(@PathVariable final Long bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/q")
    public List<BookDto> getBooksByAuthor(@RequestParam("author") String author) {
        return bookService.findBooksByAuthor(author);
    }

}
