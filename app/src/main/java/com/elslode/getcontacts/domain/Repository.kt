package com.elslode.getcontacts.domain

interface Repository {

    fun getContacts(): List<Contact>

}