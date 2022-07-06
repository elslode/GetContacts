package com.elslode.getcontacts.domain

data class Contact(
    val id: Int,
    val name: String? = null,
    val number: String? = null,
    val photoUri: String? = null
)