package com.dam.api.controllers

import com.dam.api.models.Producto
import com.dam.api.models.Usuario
import com.dam.api.services.ProductosService
import com.dam.api.services.UsuariosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
// TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/productos"
@RequestMapping("/api/v1/usuarios")
@CrossOrigin("*")
class UsuariosController {
    @Autowired
    lateinit var usuariosService: UsuariosService

    // URL -> /api/v1/productos/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Usuario>> {
        val listaUsuarios: MutableList<Usuario> = usuariosService.getAll()
        return ResponseEntity(listaUsuarios, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getOneUser(@PathVariable id: String): ResponseEntity<Usuario> {
        val idUser: Long = id.toLong()
        val usuario: Usuario? = usuariosService.getOneUser(idUser)

        return ResponseEntity<Usuario>(usuario, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertUsuario(@RequestBody user: Usuario): ResponseEntity<String> {
        println("ID: ${user.id}")
        println("Nombre: ${user.nombre}")
        usuariosService.insertOneUser(user)

        return ResponseEntity<String>("IMPLEMENTED", HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteOneUsuario(@PathVariable id: String): ResponseEntity<String> {
        val idUser: Long = id.toLong()
        usuariosService.deleteOneUser(idUser)

        return ResponseEntity<String>("DELETED", HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateUsuario(@RequestBody user: Usuario): ResponseEntity<String> {
        usuariosService.updateUser(user)
        return ResponseEntity<String>("UPDATED", HttpStatus.OK)
    }
}