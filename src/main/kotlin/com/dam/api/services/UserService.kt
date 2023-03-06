package com.dam.api.services

import com.dam.api.models.User
import com.dam.api.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    val dao: CrudRepository<User, Long>
        get() {
            return userRepository
        }

    fun getAll(): MutableList<User> {
        val returnList: MutableList<User> = mutableListOf()
        dao.findAll().forEach { obj: User -> returnList.add(obj) }
        return returnList
    }

    fun getOneUser(id: Long): User? {
        return dao.findByIdOrNull(id)
    }

    fun insertOneUser(user: User): User {
        return dao.save(user)
    }

    fun deleteOneUser(id: Long): User? {
        dao.deleteById(id)
        return dao.findByIdOrNull(id)
    }

    fun updateUser(user: User): User {
        dao.findByIdOrNull(user.id)
        return dao.save(user)
    }

    fun getOneUserbyNick(nick: String): User? {
        val listaUser = this.getAll()
        var idUser: Long = 0

        if (listaUser != null) {
            for (user in listaUser) if (user.nick == nick) idUser = user.id
        }

        return this.getOneUser(idUser)
    }
}