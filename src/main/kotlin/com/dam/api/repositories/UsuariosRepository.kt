package com.dam.api.repositories

import com.dam.api.models.Usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuariosRepository : CrudRepository<Usuario, Long> {
}