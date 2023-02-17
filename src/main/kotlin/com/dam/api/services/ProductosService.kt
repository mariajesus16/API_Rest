package com.dam.api.services

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.CrossOrigin

@Service
class ProductosService {

    private var listaProductos: MutableList<String> = mutableListOf("cerveza", "agua", "cafe")

    fun getAll(): MutableList<String> {
        return listaProductos
    }

    fun getProducto(prod: String): String {
        val listProducto = listOf("cafe", "agua", "cerveza")
        var producto = ""
        for (element in listProducto) {
            if (prod == element) {
                producto = prod
            } else {
                producto = "Error 404"
            }
        }
        return producto
    }
}