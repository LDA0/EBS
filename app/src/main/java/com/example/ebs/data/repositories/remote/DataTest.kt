package com.example.ebs.data.repositories.remote

import kotlinx.serialization.Serializable

/**
 * Data class that defines an amphibian which includes a name, type, description, and image URL.
 */
@Serializable
data class DataTest(
    val status: String,
    val data: BookData
)

@Serializable
data class BookData(
    val book: Book
)

@Serializable
data class Book(
    val id: String,
    val name: String,
    val year: Int,
    val author: String,
    val summary: String,
    val publisher: String,
    val pageCount: Int,
    val readPage: Int,
    val finished: Boolean,
    val reading: Boolean,
    val insertedAt: String,
    val updatedAt: String
    //    @SerialName("img_src") val imgSrc: String
)
