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

class AddContactFragment(var listContact: ArrayList<Contact>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.add_contact_layout, container, false)


        val back_btn = view.findViewById<Button>(R.id.back_btn_add_layout)
        back_btn.setOnClickListener {
            val fragmentManager = (view.context as AppCompatActivity).supportFragmentManager

            // Start a new FragmentTransaction
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace the current fragment with the new fragment
            fragmentTransaction.replace(R.id.fragment_container, ListContactFragment(listContact))

            // Commit the FragmentTransaction
            fragmentTransaction.commit()
        }

        val add_btn = view.findViewById<Button>(R.id.confirm_add_contact)
        add_btn.setOnClickListener {
            val nameField = view.findViewById<TextView>(R.id.contact_name_field)
            val phoneNumberFiled = view.findViewById<TextView>(R.id.contact_phoneNumber_field)
            val emailField = view.findViewById<TextView>(R.id.contact_email_field)
            listContact.add(
                Contact(
                    listContact.size + 1,
                    nameField.text.toString(),
                    phoneNumberFiled.text.toString(),
                    emailField.text.toString()
                )
            )
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