package com.elslode.getcontacts.presentation.eventGetContact

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elslode.getcontacts.domain.Contact
import com.elslode.getcontacts.domain.GetContactsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetContactViewModel @Inject constructor(
    private val getContactsUseCase: GetContactsUseCase
) : ViewModel() {

    private val _contactsList = MutableLiveData<List<Contact>>()
    val contactsList: MutableLiveData<List<Contact>>
        get() = _contactsList

    init {
       contactsList.value = getContactsUseCase.invoke()
    }

}