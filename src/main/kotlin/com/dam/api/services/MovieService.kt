package com.dam.api.services

import com.dam.api.models.Movie
import com.dam.api.models.User
import com.dam.api.repositories.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MovieService {
    @Autowired
    lateinit var movieRepository: MovieRepository

    val dao: CrudRepository<Movie, Long>
        get() {
            return movieRepository
        }

    fun getAll(): MutableList<Movie> {
        val returnList: MutableList<Movie> = mutableListOf()
        dao.findAll().forEach { obj: Movie -> returnList.add(obj) }
        return returnList
    }

    fun getOneMovie(id: Long): Movie? {
        return dao.findByIdOrNull(id)
    }

    fun insertOneMovie(movie: Movie): Movie {
        return dao.save(movie)
    }
}