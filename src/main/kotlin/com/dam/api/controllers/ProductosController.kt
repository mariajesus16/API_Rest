package com.dam.api.controllers

import com.dam.api.services.ProductosService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
// TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/productos"
@RequestMapping("/api/v1/productos")
@CrossOrigin("*")
class ProductosController {

    companion object {
        var productosService: ProductosService = ProductosService()
    }

    // URL -> /api/v1/productos/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<String>> {
        var listaProductos: MutableList<String> = mutableListOf()
        listaProductos = productosService.getAll()
        return ResponseEntity(listaProductos, HttpStatus.OK)
    }

    /*
        // URL -> /api/v1/productos/cerveza
        @GetMapping("/cerveza")
        fun getCerveza(): String {
            return "Cerveza"
        }

        // URL -> /api/v1/productos/agua
        @GetMapping("/agua")
        fun getAgua(): String {
            return "Agua"
        }

        // URL -> /api/v1/productos/cafe
        @GetMapping("/cafe")
        fun getCafe(): String {
            return "Café"
        }
    */

    @GetMapping("/{prod}")
    fun getProducto(@PathVariable prod: String): String {
        return productosService.getProducto(prod)
    }

    @PostMapping("/{prod}")
    fun insertProducto(@PathVariable prod: String): ResponseEntity<String> {
        return ResponseEntity<String>("NOT_IMPLEMENTED", HttpStatus.IM_USED)
    }
}