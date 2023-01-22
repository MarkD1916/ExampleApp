package com.example.core.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Word(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val word: String,
    val translate: String
)
