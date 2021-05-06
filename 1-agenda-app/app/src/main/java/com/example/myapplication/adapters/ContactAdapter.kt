package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Contact

class ContactAdapter(val listContacts: ArrayList<Contact>, val context: Context): RecyclerView.Adapter<ContactAdapter.ContactItem>(){

    inner class ContactItem(itemView: View): RecyclerView.ViewHolder(itemView) {

        private lateinit var cv_txt_name: TextView
        private lateinit var cv_img_delete: ImageButton

        fun bindTo(contact: Contact) {
            cv_txt_name = itemView.findViewById(R.id.cv_txt_name)
            cv_img_delete = itemView.findViewById(R.id.cv_img_delete)

            cv_txt_name.text = contact.name
            cv_img_delete.setOnClickListener{
                listContacts.remove(contact)
                notifyDataSetChanged()
            }
        }
    }

    // crear la vista por cada fila de acuerdo al diseño del prototipo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItem {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ContactItem(view)
    }

    // Informacion a mostrar en cada vista
    override fun onBindViewHolder(holder: ContactItem, position: Int) {
        holder.bindTo(listContacts[position])
    }

    // cantidad de elementos del recyclerView
    override fun getItemCount(): Int {
        return listContacts.size
    }


}