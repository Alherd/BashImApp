package com.alherd.bashimapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Olgerd on 16.06.2018.
 */
class SourceOfQuotesAdapter(list: MutableList<SourceOfQuotesAdapter>) : RecyclerView.Adapter<SourceOfQuotesAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)
        val view = layoutInflater.inflate(R.layout.source_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

}