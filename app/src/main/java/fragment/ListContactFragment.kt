package fragment

import adaptors.ContactAdaptor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.R
import models.Contact
import kotlin.random.Random


class ListContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_contact_fragment, container, false)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listContact = view.findViewById<RecyclerView>(R.id.list_contact)
        listContact.layoutManager = LinearLayoutManager(context)

        val contacts = ArrayList<Contact>()
        val alphabet = "ABCDEFGHIGKLMNOPQRSTUVWXYZ"
        for (i in 1..20) {
            contacts.add(Contact(i, alphabet[Random.nextInt(alphabet.length)] + "ame", "0987654321",alphabet[Random.nextInt(alphabet.length)] + "email@gmail.com"))
        }

        listContact.adapter = ContactAdaptor(contacts)
    }

}