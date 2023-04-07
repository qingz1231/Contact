package my.tarc.mycontact

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class ContactRepository(private val contactDao: ContactDao){
    //Room execute all queries on a separate thread
    val allContacts: LiveData<List<Contact>> = contactDao.getAllContact()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(contact: Contact){
        contactDao.insert(contact)
    }

    @WorkerThread
    suspend fun update(contact:Contact){
        contactDao.update(contact)
    }

    @WorkerThread
    suspend fun retrieve(contact: Contact){
        contactDao.insert(contact)
    }
    @WorkerThread
    suspend fun delete(contact: Contact){
        contactDao.delete(contact)
    }
}