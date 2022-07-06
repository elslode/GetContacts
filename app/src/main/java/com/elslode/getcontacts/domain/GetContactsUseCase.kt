package com.elslode.getcontacts.domain

import javax.inject.Inject

class GetContactsUseCase @Inject constructor(
   private val repository: Repository
) {
    operator fun invoke() = repository.getContacts()
}