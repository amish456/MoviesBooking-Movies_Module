package com.movies.Service.impl;

import com.movies.Dto.MovieDto;
import com.movies.Entity.Movie;
import com.movies.Reepository.MovieRepository;
import com.movies.Service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = mapToEntity(movieDto);
        Movie saveMovie = movieRepository.save(movie);
        return mapToDto(saveMovie);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public MovieDto findMovieById(Long id) {
        Movie movie = movieRepository.findById(id).get();
        return mapToDto(movie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto) {
        Movie movie = movieRepository.findById(id).get();
        if (movieDto.getDirector().equals(null)){
            movieDto.setDirector(movie.getDirector());
        }
        if (movieDto.getActors().equals(null)){
            movieDto.setActors(movie.getActors());
        }
        if (movieDto.getLength() == 0){
            movieDto.setLength(movie.getLength());
        }
        if (movieDto.getTitle().equals(null)){
            movieDto.setTitle(movie.getTitle());
        }
        if (movieDto.getGenre().equals(null)){
            movieDto.setGenre(movie.getGenre());
        }
        if (movieDto.getRating() == 0){
            movieDto.setRating(movie.getRating());
        }
        if (movieDto.getReleaseDate().equals(null)){
            movieDto.setReleaseDate(movie.getReleaseDate());
        }
        if (movieDto.getLanguage().equals(null)){
            movieDto.setLanguage(movie.getLanguage());
        }
        Movie updatedMovie = movieRepository.save(mapToEntity(movieDto));
        return mapToDto(updatedMovie);
    }

    @Override
    public void deleteMovie(Long id) {

        Movie movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);

    }

    private MovieDto mapToDto(Movie movie){
        return mapper.map(movie, MovieDto.class);
    }

    private Movie mapToEntity(MovieDto movieDto){
        return mapper.map(movieDto, Movie.class);
    }
}
