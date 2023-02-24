package com.dam.api.controllers

import com.dam.api.models.Producto
import com.dam.api.services.ProductosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
// TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/productos"
@RequestMapping("/api/v1/productos")
@CrossOrigin("*")
class ProductosController {

    @Autowired
    lateinit var productosService: ProductosService

    // URL -> /api/v1/productos/
    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Producto>> {
        val listaProductos: MutableList<Producto> = productosService.getAll()
        return ResponseEntity(listaProductos, HttpStatus.OK)
    }

    /*
        // URL -> /api/v1/productos/cerveza
        @GetMapping("/cerveza")
        fun getCerveza(): String {
            return "Cerveza"
        }
    */

    @GetMapping("/{id}")
    fun getOneProduct(@PathVariable id: String): ResponseEntity<Producto> {
        val idProd: Long = id.toLong()
        val producto: Producto? = productosService.getOneProduct(idProd)

        return ResponseEntity<Producto>(producto, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertProducto(@RequestBody prod: Producto): ResponseEntity<String> {
        println("ID: ${prod.id}")
        println("Nombre: ${prod.nombre}")
        productosService.insertOneProduct(prod)

        return ResponseEntity<String>("IMPLEMENTED", HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteOneProduct(@PathVariable id: String): ResponseEntity<String> {
        val idProd: Long = id.toLong()
        productosService.deleteOneProduct(idProd)

        return ResponseEntity<String>("DELETED", HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateProduct(@RequestBody prod: Producto): ResponseEntity<String>{
        productosService.updateProduct(prod)
        return ResponseEntity<String>("UPDATED", HttpStatus.OK)
    }
}