package com.library.service;

import com.library.converter.BookDtoToEntityConverter;
import com.library.converter.BookEntityToDtoConverter;
import com.library.dto.BookDto;
import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookDtoToEntityConverter dtoToEntityConverter;

    @Autowired
    private BookEntityToDtoConverter entityToDtoConverter;

    public BookDto addBook(BookDto dto) {
        Book entity = dtoToEntityConverter.convert(dto);
        var saved  = repository.save(entity);
        return entityToDtoConverter.convert(saved);
    }

    public BookDto getBookById(Long id) {
        var book = repository.findById(id).orElseThrow();
        return entityToDtoConverter.convert(book);
    }

    public List<BookDto> getAllBooks() {
        return repository.findAll().stream()
                .map(entityToDtoConverter::convert)
                .toList();
    }

    public BookDto updateBookById(Long id, BookDto updatedDto) {
        Book updated = repository.findById(id).map(book -> {
            book.setId(book.getId());
            book.setTitle(updatedDto.getTitle());
            book.setAuthor(updatedDto.getAuthor());
            book.setIsbn(updatedDto.getIsbn());
            book.setPublicationDate(updatedDto.getPublicationDate());
            return repository.save(book);
        }).orElseThrow();
        return entityToDtoConverter.convert(updated);
    }

    public void deleteBookById(Long bookId) {
        repository.deleteById(bookId);
    }

    public List<BookDto> findBooksByAuthor(String author) {
        return repository.findByAuthor(author)
                .stream()
                .map(entityToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public Integer countBooksByAuthor(String author) {
        return repository.countByAuthor(author);
    }

}