package com.movies.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movies.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private long id;
    private String title;
    private Genre genre;
    private double length;
    private String director;
    private String actors;
    private double rating;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    private String language;
}
