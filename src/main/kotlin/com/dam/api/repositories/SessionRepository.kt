package com.dam.api.repositories

import com.dam.api.models.Producto
import com.dam.api.models.Session
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionRepository : CrudRepository<Session, Long> {
}