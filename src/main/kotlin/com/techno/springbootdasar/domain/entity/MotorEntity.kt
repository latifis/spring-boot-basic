package com.techno.springbootdasar.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "mst_motor")
data class MotorEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    val id:UUID? = null,

    @Column(name = "nama")
    var nama:String? = null,

    @Column(name = "merk")
    var merk:String? = null
)
