package com.alherd.bashimapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alherd.bashimapp.data.SourceOfQuotes
import kotlinx.android.synthetic.main.source_item.view.*

class SourceOfQuotesAdapter(list: MutableList<SourceOfQuotes>) : RecyclerView.Adapter<SourceOfQuotesAdapter.ViewHolder>() {

    private val mItems: MutableList<SourceOfQuotes> = list
    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mItems[position]
        holder.title.text = item.desc
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)
        val view = layoutInflater.inflate(R.layout.source_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.text!!
    }

}