package com.example.search_word_screen.models

data class SearchWord(
    val word: String?,
    val sourceUrl: String?,
    val phonetics: List<Phonetic>?,
    val meanings: List<Meaning>
    )

data class Phonetic(
    val text: String?,
    val audio: String?,
    val sourceUrl: String?
)

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>,
    val synonyms: List<String>,
    val antonyms: List<String>
)

data class Definition(
    val definition: String,
    val synonyms: List<String>,
    val antonyms: List<String>,
    val example: String
)