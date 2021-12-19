package com.example.dreambuilders.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emon.raihan.messmanagement.R
import com.example.dreambuilders.model.Members
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MyAdpterMember(list: ArrayList<Members>) :
    RecyclerView.Adapter<MyAdpterMember.BlogViewHolder>() {
    var listArry: ArrayList<Members>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val data: Members = listArry[position]
        holder.profilename.setText(data.member_name)
        holder.profilemobile.setText(data.mobile)
        holder.profileemail.setText(data.email)

       Picasso.get()
            .load(data.prolink)
            .placeholder(R.drawable.ic_user)
            .into(holder.profilepic)

      /*  holder.profilepic.loadImage(
            data.prolink, getProgressDrawable(holder.profilepic.context)
        )*/
    }

    override fun getItemCount(): Int {
        return listArry.size
    }

    inner class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profilename: TextView
        var profilemobile: TextView
        var profileemail: TextView
        var profilepic: CircleImageView

        init {
            profilename = itemView.findViewById<View>(R.id.profilename) as TextView
            profilemobile = itemView.findViewById<View>(R.id.profilemobile) as TextView
            profileemail = itemView.findViewById<View>(R.id.profileemail) as TextView
            profilepic = itemView.findViewById<View>(R.id.profilepic) as CircleImageView
        }
    }

    init {
        listArry = list
    }
}