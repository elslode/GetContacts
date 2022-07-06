package com.elslode.getcontacts.data

import android.content.Context
import android.provider.ContactsContract
import com.elslode.getcontacts.domain.Contact
import com.elslode.getcontacts.domain.Repository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
   @ApplicationContext val context: Context
) : Repository {

    override fun getContacts(): List<Contact> {
        val listContact = mutableListOf<Contact>()

        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null
        )
        while (cursor?.moveToNext() == true) {
            val nameOfUser =
                cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                    ?: "unknown"

            val phoneOfUser =
                cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    ?: "+0 (000) 000 0000"
            val photoUriOfUser =
                cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))
                    ?: "NOTHING"
            val id =
                cursor.getInt(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.CONTACT_ID))
                    ?: 0
            val contactGen =
                Contact(id = id, name = nameOfUser, photoUri = photoUriOfUser, number = phoneOfUser)
            listContact.add(contactGen)
        }
        return listContact
    }

}