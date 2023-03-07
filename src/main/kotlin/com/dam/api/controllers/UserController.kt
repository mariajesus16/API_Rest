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

    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<User>> {
        val listaUsers: MutableList<User> = userService.getAll()
        return ResponseEntity(listaUsers, HttpStatus.OK)
    }

    @GetMapping("/{nick}")
    fun getOneUser(@PathVariable nick: String): ResponseEntity<Any> {
        val user: User? = userService.getOneUserbyNick(nick)

        return if (user == null) {
            ResponseEntity<Any>("USER NOT FOUND", HttpStatus.NOT_FOUND)
        } else return ResponseEntity<Any>(user, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertUser(@RequestBody user: User): ResponseEntity<String> {
        userService.insertOneUser(user)

        return ResponseEntity<String>("IMPLEMENTED", HttpStatus.OK)
    }

    @DeleteMapping("/{nick}")
    fun deleteOneUser(@PathVariable nick: String): Any? {
        val user: User? = userService.getOneUserbyNick(nick)
        val idUser = user?.id

        return if (user != null) {
            userService.deleteOneUser(idUser!!)
        } else return ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND)
    }

    @PutMapping("/{nick}")
    fun updateUser(@PathVariable nick: String, @RequestBody updateUser: User): Any {
        val user: User? = userService.getOneUserbyNick(nick)

        return if (user != null) {
            userService.updateUser(updateUser)
        } else return ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND)
    }
}