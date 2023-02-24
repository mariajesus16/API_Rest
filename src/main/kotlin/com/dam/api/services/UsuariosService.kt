package com.dam.api.services

import com.dam.api.models.Producto
import com.dam.api.models.Usuario
import com.dam.api.repositories.ProductosRepository
import com.dam.api.repositories.UsuariosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UsuariosService {
    @Autowired
    lateinit var usuariosRepository: UsuariosRepository

    val dao: CrudRepository<Usuario, Long>
        get() {
            return usuariosRepository
        }

    fun getAll(): MutableList<Usuario> {
        // definimos la lista que vamos a devolver
        val returnList: MutableList<Usuario> = mutableListOf()
        dao.findAll().forEach { obj: Usuario -> returnList.add(obj) }
        return returnList
    }

    fun getOneUser(id: Long): Usuario? {
        return dao.findByIdOrNull(id)
    }

    fun insertOneUser(user: Usuario): Usuario {
        return dao.save(user)
    }

    fun deleteOneUser(id: Long): Usuario? {
        dao.deleteById(id)
        return dao.findByIdOrNull(id)
    }

    fun updateUser(user: Usuario): Usuario {
        dao.findByIdOrNull(user.id)
        return dao.save(user)
    }
}