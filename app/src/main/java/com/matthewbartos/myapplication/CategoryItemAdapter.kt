package com.matthewbartos.myapplication

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.program_item.view.*

class CategoryItemAdapter(private val items: List<String>, private val context: Context) :
    RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>() {
    val currentPosition: MutableLiveData<Int> = MutableLiveData()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item, parent, false))

    override fun onBindViewHolder(holder: CategoryItemAdapter.ViewHolder, position: Int) {
        holder.title.text = items[position]

        holder.itemView.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                currentPosition.value = position
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title!!
    }
}

