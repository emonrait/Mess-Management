package com.example.dreambuilders.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emon.raihan.messmanagement.R
import com.example.dreambuilders.model.Transaction

class MyAdpterAllTxnList(private var trnlist: ArrayList<Transaction>) :
    RecyclerView.Adapter<MyAdpterAllTxnList.BlogViewHolder>(), Filterable {
    var listArry: ArrayList<Transaction>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_statement_listviewall, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val data: Transaction = listArry[position]
        holder.tv_txnid.setText(data.id)
        holder.tv_invoiceno.setText(data.invoiceno)
        holder.tv_date.setText(data.date)
        holder.tv_amount.setText(data.amount)
        holder.tv_email.setText(data.email)
    }

    override fun getItemCount(): Int {
        return listArry.size
    }

    inner class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_txnid: TextView
        var tv_invoiceno: TextView
        var tv_date: TextView
        var tv_amount: TextView
        var tv_email: TextView

        init {
            tv_txnid = itemView.findViewById<View>(R.id.tv_txnid) as TextView
            tv_invoiceno = itemView.findViewById<View>(R.id.tv_invoiceno) as TextView
            tv_date = itemView.findViewById<View>(R.id.tv_date) as TextView
            tv_amount = itemView.findViewById<View>(R.id.tv_amount) as TextView
            tv_email = itemView.findViewById<View>(R.id.tv_email) as TextView
        }
    }

    init {
        listArry = trnlist
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                if (constraint.toString().isEmpty()) {
                    listArry = trnlist
                } else {

                    val resultList = java.util.ArrayList<Transaction>()
                    for (row in trnlist) {
                        if (
                            row.email.toString().toLowerCase()
                                ?.contains(constraint.toString().toLowerCase())
                        ) {
                            resultList.add(row)
                        }
                    }
                    listArry = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = listArry
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listArry = results?.values as java.util.ArrayList<Transaction>
                notifyDataSetChanged()
            }

        }
    }
}