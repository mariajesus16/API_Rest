package com.dam.api.services

import com.dam.api.models.Producto
import com.dam.api.repositories.ProductosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductosService {

    @Autowired
    lateinit var productosRepository: ProductosRepository

    val dao: CrudRepository<Producto, Long>
        get() {
            return productosRepository
        }

    fun getAll(): MutableList<Producto> {
        // definimos la lista que vamos a devolver
        val returnList: MutableList<Producto> = mutableListOf()
        dao.findAll().forEach { obj: Producto -> returnList.add(obj) }
        return returnList
    }

    fun getOneProduct(id: Long): Producto? {
        return dao.findByIdOrNull(id)
    }

    fun insertOneProduct(prod: Producto): Producto {
        return dao.save(prod)
    }

    fun deleteOneProduct(id: Long): Producto? {
        dao.deleteById(id)
        return dao.findByIdOrNull(id)
    }

    fun updateProduct(prod: Producto): Producto {
        dao.findByIdOrNull(prod.id)
        return dao.save(prod)
    }
}