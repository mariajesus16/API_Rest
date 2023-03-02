package com.dam.api.models

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "sessions")
class Session(
        @Column(name = "movie_id")
        var movie_id: Long,
        @Column(name = "room_id")
        var room_id: Long,
        @Column(name = "date")
        var date: Date,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
) {
}