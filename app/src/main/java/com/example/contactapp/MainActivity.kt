package com.example.contactapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fragment.ListContactFragment
import models.Contact

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        replaceFragment(ListContactFragment())
        // Get a reference to the FragmentManager
        val fragmentManager = supportFragmentManager

        // Start a new FragmentTransaction
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Replace the current fragment with the new fragment
        fragmentTransaction.replace(R.id.fragment_container, ListContactFragment(ArrayList<Contact>()))

        // Commit the FragmentTransaction
        fragmentTransaction.commit()
    }


}
