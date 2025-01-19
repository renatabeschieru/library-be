package com.library.converter;

import com.library.dto.BookDto;
import com.library.entity.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookEntityToDtoConverter implements Converter<Book, BookDto> {

    @Override
    public BookDto convert(Book entity) {
        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .publicationDate(entity.getPublicationDate())
                .build();
    }

}
