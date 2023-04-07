package my.tarc.mycontact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ContactViewModel (application: Application): AndroidViewModel(application) {
    //LiveData gives us updated contacts when they change
    var contactList : LiveData<List<Contact>>
    private val repository: ContactRepository

    init {
        val contactDao = ContactDatabase.getDatabase(application).contactDao()
        repository = ContactRepository(contactDao)
        contactList = repository.allContacts
    }
    //call a synchronize task
    fun insertContact(contact: Contact) = viewModelScope.launch{
         repository.insert(contact)
    }

    fun updateContact(contact: Contact) = viewModelScope.launch{
        repository.update(contact)
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch{
        repository.delete(contact)
    }
}
