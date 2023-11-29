package fragment

import adaptors.ContactAdaptor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.R
import models.Contact


class ListContactFragment(var listContact: ArrayList<Contact>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_contact_fragment, container, false)
        val back_btn = view.findViewById<Button>(R.id.add_contact_btn)
        back_btn.setOnClickListener{
            val fragmentManager = (view.context as AppCompatActivity).supportFragmentManager

            // Start a new FragmentTransaction
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace the current fragment with the new fragment
            fragmentTransaction.replace(R.id.fragment_container, AddContactFragment(listContact))

            // Commit the FragmentTransaction
            fragmentTransaction.commit()
        }
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listContactWidget = view.findViewById<RecyclerView>(R.id.list_contact)
        listContactWidget.layoutManager = LinearLayoutManager(context)


        listContactWidget.adapter = ContactAdaptor(listContact)
    }

}