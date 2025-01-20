package com.library.converter;

import com.library.dto.BookDto;
import com.library.entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookDtoToEntityConverterTest {

    private BookDtoToEntityConverter converter = new BookDtoToEntityConverter();

    @Test
    public void testDtoToEntityConverterIsWorkingAsExpected() {
        BookDto dto = new BookDto(null, "title", "author", "isbn", null);
        Book entity = converter.convert(dto);
        assertEquals("title", entity.getTitle());
        assertEquals("author", entity.getAuthor());
        assertEquals("isbn", entity.getIsbn());
    }

}