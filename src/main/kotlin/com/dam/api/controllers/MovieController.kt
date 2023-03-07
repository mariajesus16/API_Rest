package com.dam.api.controllers

import com.dam.api.models.Movie
import com.dam.api.services.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
class MovieController {
    @Autowired
    lateinit var movieService: MovieService

    @GetMapping("")
    fun getAll(): ResponseEntity<MutableList<Movie>> {
        val listaMovies: MutableList<Movie> = movieService.getAll()
        return ResponseEntity(listaMovies, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getOneMovie(@PathVariable id: String): ResponseEntity<Movie> {
        val idMovie: Long = id.toLong()
        val movie: Movie? = movieService.getOneMovie(idMovie)

        return ResponseEntity<Movie>(movie, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertMovie(@RequestBody movie: Movie): ResponseEntity<String> {
        movieService.insertOneMovie(movie)

        return ResponseEntity<String>("IMPLEMENTED", HttpStatus.OK)
    }
}