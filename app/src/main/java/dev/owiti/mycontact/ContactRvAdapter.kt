package dev.owiti.mycontact

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.owiti.mycontact.databinding.ActivityMainBinding
import dev.owiti.mycontact.databinding.ContactListItemBinding


class ContactRvAdapter(var contactList:List<Contact>): RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
            var itemView = LayoutInflater.from(parent.context)
        .inflate(R.layout.contact_list_item, parent, false)
        var binding=ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var contactViewHolder=ContactViewHolder(binding)
        return contactViewHolder
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact=contactList.get(position)
    holder.binding.tvName.text=currentContact.name
    holder.binding.tvEmail.text=currentContact.email
    holder.binding.tvNumber.text=currentContact.number
    holder.binding.tvAddress.text=currentContact.address
        Picasso.get()
        .load(currentContact.image)
        .placeholder(R.drawable.ic_baseline_person_24)
        .error(R.drawable.ic_baseline_error_outline_24)
        .resize(350,350)
        .centerCrop()
        .into(holder.binding.ivContact)

        var context=holder.itemView.context
        holder.binding.ivContact.setOnClickListener{
            Toast.makeText(context,"You have clicked on ${currentContact.name}'s image",Toast.LENGTH_SHORT).show()
        }
        holder.binding.cvContact.setOnClickListener{
            var intent=Intent(context,ViewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("EMAIL",currentContact.email)
            intent.putExtra("PHONE-NUMBER",currentContact.number)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}

class ContactViewHolder(var binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root)

