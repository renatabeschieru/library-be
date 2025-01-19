package com.library.converter;

import com.library.dto.BookDto;
import com.library.entity.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookDtoToEntityConverter implements Converter<BookDto, Book> {

    @Override
    public Book convert(BookDto source) {
        return Book.builder()
                .title(source.getTitle())
                .author(source.getAuthor())
                .isbn(source.getIsbn())
                .publicationDate(source.getPublicationDate())
                .build();
    }

}
