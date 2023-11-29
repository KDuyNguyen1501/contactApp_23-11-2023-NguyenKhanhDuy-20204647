package adaptors

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.R
import fragment.DetailContactFragment
import models.Contact

class ContactAdaptor(val contacts: ArrayList<Contact>) : RecyclerView.Adapter<ContactAdaptor.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactAvt = view.findViewById<TextView>(R.id.contact_avt)
        val contactName = view.findViewById<TextView>(R.id.contact_name)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.contactAvt.text = contact.name[0].toString()
        holder.contactName.text = contact.name

        holder.itemView.setOnClickListener{
//            onContactClick(contact)
            val fragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager

            // Start a new FragmentTransaction
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace the current fragment with the new fragment
            fragmentTransaction.replace(R.id.fragment_container, DetailContactFragment(contact, contacts))

            // Commit the FragmentTransaction
            fragmentTransaction.commit()
        }

        holder.itemView.setOnLongClickListener{

           val callIntent = Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+contact.phoneNumber));
//            val chooserIntent = Intent.createChooser(
//                    callIntent, "Select app to share");
            holder.itemView.context.startActivity(callIntent)
            true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.contact_item_layout, parent, false)
        return ViewHolder(view)
    }
}