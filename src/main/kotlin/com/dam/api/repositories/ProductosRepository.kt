package com.dam.api.repositories

import com.dam.api.models.Producto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductosRepository : CrudRepository<Producto, Long> {
}