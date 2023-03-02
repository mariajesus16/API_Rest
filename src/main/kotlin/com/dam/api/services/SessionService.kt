package com.dam.api.services

import com.dam.api.models.Session
import com.dam.api.repositories.SessionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SessionService {
    @Autowired
    lateinit var sessionRepository: SessionRepository

    val dao: CrudRepository<Session, Long>
        get() {
            return sessionRepository
        }

    fun getAll(): MutableList<Session> {
        val returnList: MutableList<Session> = mutableListOf()
        dao.findAll().forEach { obj: Session -> returnList.add(obj) }
        return returnList
    }

    fun getOneSession(id: Long): Session? {
        return dao.findByIdOrNull(id)
    }

    fun insertOneSession(session: Session): Session {
        return dao.save(session)
    }

    fun deleteOneSession(id: Long): Session? {
        dao.deleteById(id)
        return dao.findByIdOrNull(id)
    }

    fun updateSession(session: Session): Session {
        dao.findByIdOrNull(session.id)
        return dao.save(session)
    }
}