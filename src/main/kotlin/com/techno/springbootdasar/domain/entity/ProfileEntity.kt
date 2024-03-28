package com.techno.springbootdasar.domain.entity

import jakarta.persistence.*
import org.w3c.dom.Text
import java.util.*

@Entity
@Table(name = "mst_profile")
data class ProfileEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "nama")
    var name:String? = null,

    @Column(name = "username")
    var username:String? = null,

    @Column(name = "email")
    var email:String? = null,

    @Column(name = "password")
    var password:String? = null,

    @Column(name = "avatar", columnDefinition = "TEXT")
    var avatar:String? = null

)
