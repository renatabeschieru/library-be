package com.library.service;

import com.library.converter.BookDtoToEntityConverter;
import com.library.converter.BookEntityToDtoConverter;
import com.library.dto.BookDto;
import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository repository;

    @Mock
    private BookDtoToEntityConverter dtoToEntityConverter;

    @Mock
    private BookEntityToDtoConverter entityToDtoConverter;

    @InjectMocks
    private BookService service;

    @Test
    public void testAddBook() {
        // Arrange
        BookDto inputDto = new BookDto(1L,"Title", "Author", "isbn", new Date());
        Book bookEntity = new Book(1L, "Title", "Author", "isbn", new Date());
        BookDto outputDto = new BookDto(1L, "Title", "Author", "isbn", new Date());

        when(dtoToEntityConverter.convert(inputDto)).thenReturn(bookEntity);
        when(repository.save(bookEntity)).thenReturn(bookEntity);
        when(entityToDtoConverter.convert(bookEntity)).thenReturn(outputDto);

        // Act
        BookDto result = service.addBook(inputDto);

        // Assert
        assertEquals(outputDto, result);
        verify(repository, times(1)).save(bookEntity);
    }
}