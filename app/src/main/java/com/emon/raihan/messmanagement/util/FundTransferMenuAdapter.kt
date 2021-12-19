package com.emon.raihan.messmanagement.util


import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.emon.raihan.messmanagement.R
import com.emon.raihan.messmanagement.model.Menu_Model


class FundTransferMenuAdapter (private var activity: Activity, private var items: ArrayList<Menu_Model>) :  BaseAdapter(){
    private class ViewHolder(row: View) {

        var menu_name: TextView? = null
        var menu_soft_code: TextView? = null
        var menu_icon: ImageView? = null
        init {

            this.menu_name = row?.findViewById(R.id.menu_name)
            this.menu_soft_code = row?.findViewById(R.id.menu_soft_code)
            this.menu_icon = row?.findViewById(R.id.menu_icon)

            //typeface_regular.ty

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.row_fundtransfer_menu, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }



        var item = items[position]
        viewHolder.menu_name?.text = item.menuName
        viewHolder.menu_soft_code?.text = item.softcode
        item.imageId?.let { viewHolder.menu_icon?.setImageResource(it)}

       // viewHolder.menu_name?.typeface = typeface_regular
        return view as View
    }
    override fun getItem(i: Int): Menu_Model {
        return items[i]
    }
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }
    override fun getCount(): Int {
        return items.size
    }
}