package com.dam.api.models

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
class Usuario(
        @Column(name = "nombre")
        var nombre: String,

        @Column(name = "email")
        var email: String,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
) {
}