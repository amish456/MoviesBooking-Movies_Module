package com.movies.Service;

import com.movies.Dto.MovieDto;

import java.util.List;

public interface MovieService {

    public MovieDto addMovie(MovieDto movieDto);

    public List<MovieDto> getAllMovies();

    public MovieDto findMovieById(Long id);

    public MovieDto updateMovie(Long id, MovieDto movieDto);

    public void deleteMovie(Long id);
}
