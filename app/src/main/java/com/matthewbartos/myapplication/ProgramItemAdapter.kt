package com.matthewbartos.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.program_item.view.*

class ProgramItemAdapter(private val items: List<String>, private val context: Context) :
    RecyclerView.Adapter<ProgramItemAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramItemAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.program_item, parent, false))

    override fun onBindViewHolder(holder: ProgramItemAdapter.ViewHolder, position: Int) {
        holder.title.text = items[position]
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title!!
    }
}

