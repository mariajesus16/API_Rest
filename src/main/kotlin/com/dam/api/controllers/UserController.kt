package com.dam.api.controllers

import com.dam.api.models.User
import com.dam.api.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping("")
    fun getAll(): ResponseEntity<MutableList<User>> {
        val listaUsers: MutableList<User> = userService.getAll()
        return ResponseEntity(listaUsers, HttpStatus.OK)
    }

    @GetMapping("/{nick}")
    fun getOneUser(@PathVariable nick: String): ResponseEntity<User> {
        val idProd: Long = nick.toLong()
        val user: User? = userService.getOneUser(idProd)

        return ResponseEntity<User>(user, HttpStatus.OK)
    }

    @PostMapping("")
    fun insertUser(@RequestBody user: User): ResponseEntity<String> {
        userService.insertOneUser(user)

        return ResponseEntity<String>("IMPLEMENTED", HttpStatus.OK)
    }

    @DeleteMapping("/{nick}")
    fun deleteOneUser(@PathVariable id: String): ResponseEntity<String> {
        val idProd: Long = id.toLong()
        userService.deleteOneUser(idProd)

        return ResponseEntity<String>("DELETED", HttpStatus.OK)
    }

    @PutMapping("/{nick}")
    fun updateUser(@RequestBody user: User): ResponseEntity<String> {
        userService.updateUser(user)
        return ResponseEntity<String>("UPDATED", HttpStatus.OK)
    }
}