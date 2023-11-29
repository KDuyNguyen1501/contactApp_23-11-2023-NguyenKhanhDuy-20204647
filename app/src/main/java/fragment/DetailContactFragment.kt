package fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.contactapp.R
import models.Contact

class DetailContactFragment(val contact: Contact, val listContact: ArrayList<Contact>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.contact_detail_layout, container, false)
        view.findViewById<TextView>(R.id.contact_id).text = contact.id.toString()
        view.findViewById<TextView>(R.id.contact_name).text = contact.name
        view.findViewById<TextView>(R.id.contact_phoneNumber).text = contact.phoneNumber
        view.findViewById<TextView>(R.id.contact_email).text = contact.email

        val back_btn = view.findViewById<Button>(R.id.back_btn)
        back_btn.setOnClickListener{
            val fragmentManager = (view.context as AppCompatActivity).supportFragmentManager

            // Start a new FragmentTransaction
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace the current fragment with the new fragment
            fragmentTransaction.replace(R.id.fragment_container, ListContactFragment(listContact))

            // Commit the FragmentTransaction
            fragmentTransaction.commit()
        }
        return view
    }


}