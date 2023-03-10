package com.dam.api.controllers

import com.dam.api.models.Session
import com.dam.api.models.User
import com.dam.api.services.SessionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

@RestController
@RequestMapping("/sessions")
@CrossOrigin("*")
class SessionController {
    @Autowired
    lateinit var sessionService: SessionService

    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Session>> {
        val listaSessiones: MutableList<Session> = sessionService.getAll()
        return ResponseEntity(listaSessiones, HttpStatus.OK)
    }

    //url "/sessions/sincetoday"
    @GetMapping("/sincetoday")
    fun getSinceToday():ResponseEntity<MutableList<Session>> {
        val hoy = LocalDateTime.now()
        val date = LocalDate.of(hoy.year, hoy.month, hoy.dayOfMonth)
        var listaSessions: MutableList<Session>? = mutableListOf()
        var listaSessionsToday: MutableList<Session>? = mutableListOf()
        listaSessions = sessionService.getAll()
        if (listaSessions != null) {
            for (i in 0..listaSessions.size-1) {
                val fecha = listaSessions[i].date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                if (fecha.year > date.year) {
                    listaSessionsToday?.add(listaSessions[i])
                }
                if(fecha.year == date.year && fecha.monthValue > date.monthValue){
                    listaSessionsToday?.add(listaSessions[i])
                }
                if(fecha.year == date.year && fecha.monthValue == date.monthValue && fecha.dayOfMonth > date.dayOfMonth){
                    listaSessionsToday?.add(listaSessions[i])
                }
                if(fecha.year == date.year && fecha.monthValue == date.monthValue && fecha.dayOfMonth == date.dayOfMonth){
                    listaSessionsToday?.add(listaSessions[i])
                }
            }
        }
        return ResponseEntity(listaSessionsToday, HttpStatus.OK)
    }

    //url "/sessions/today"
    @GetMapping("/today")
    fun getToday():ResponseEntity<MutableList<Session>>{
        val hoy = LocalDateTime.now()
        val date = LocalDate.of(hoy.year, hoy.month, hoy.dayOfMonth)
        var listaSessions:MutableList<Session>? = mutableListOf()
        var listaSessionsToday:MutableList<Session>? = mutableListOf()
        listaSessions = sessionService.getAll()
        if (listaSessions != null) {
            for (i in 0..listaSessions.size-1){
                val fecha = listaSessions[i].date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                if (fecha.year == date.year && fecha.monthValue == date.monthValue && fecha.dayOfMonth == date.dayOfMonth){
                    listaSessionsToday?.add(listaSessions[i])
                }
            }
        }
        return ResponseEntity(listaSessionsToday, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertUser(@RequestBody session: Session): ResponseEntity<String> {
        sessionService.insertOneSession(session)

        return ResponseEntity<String>("IMPLEMENTED", HttpStatus.OK)
    }
}