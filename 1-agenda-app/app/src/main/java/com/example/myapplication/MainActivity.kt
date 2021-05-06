package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.ContactAdapter
import com.example.myapplication.model.Contact
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var btn_agregar: Button
    private lateinit var txt_input: EditText
    private lateinit var rv_contacts: RecyclerView

    private var contacts = ArrayList<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val btn_agregar: Button = findViewById(R.id.btn_agregar)
        initViews()
    }

    private fun initViews() {
        btn_agregar = findViewById(R.id.btn_agregar)
        txt_input = findViewById(R.id.txt_input_name)
        rv_contacts = findViewById(R.id.rv_contacts)

        btn_agregar.setOnClickListener {
            val name:String = txt_input.text.toString()
            val contact = Contact(name)
            contacts.add(contact)
            rv_contacts.adapter?.notifyDataSetChanged()
        }

        // usando el adaptador
        val contactAdapter = ContactAdapter(contacts,this)
        rv_contacts.adapter = contactAdapter
        rv_contacts.layoutManager = LinearLayoutManager(this)

}
}