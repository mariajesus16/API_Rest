package com.dam.api.models

import jakarta.persistence.*


@Entity
@Table(name = "productos")
class Producto(
        @Column(name = "nombre")
        var nombre: String,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
)
