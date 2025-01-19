package com.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    @Size(max = 255, message = "Author name must not exceed 255 characters")
    private String author;

    @NotBlank(message = "ISBN cannot be blank")
    @Size(max = 13, message = "ISBN must not exceed 13 characters")
    private String isbn;

    @NotNull(message = "Publication date cannot be null")
    @PastOrPresent(message = "Publication date must be in the past or present")
    private Date publicationDate;

}
