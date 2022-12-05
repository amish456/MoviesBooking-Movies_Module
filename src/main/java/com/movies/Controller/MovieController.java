package com.movies.Controller;

import com.movies.Dto.MovieDto;
import com.movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("addMovie")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieService.addMovie(movieDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id){
        return new ResponseEntity<>(movieService.findMovieById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("movie deleted successfully", HttpStatus.OK);
    }

    @PutMapping("updateMovie/{id}")
    public ResponseEntity<MovieDto> updatemovie(@PathVariable Long id, @RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieService.updateMovie(id, movieDto), HttpStatus.OK);
    }
}
