package com.library.converter;

import com.library.dto.BookDto;
import com.library.entity.Book;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookEntityToDtoConverterTest {

    private BookEntityToDtoConverter converter = new BookEntityToDtoConverter();

    @Test
    void testEntityToDtoConverterIsWorkingAsExpected() {
        Book entity = new Book(1L, "title", "author", "isbn", null);
        BookDto dto = converter.convert(entity);
        assertThat(dto.getTitle()).isEqualTo("title");
        assertThat(dto.getAuthor()).isEqualTo("author");
        assertThat(dto.getIsbn()).isEqualTo("isbn");
    }

}