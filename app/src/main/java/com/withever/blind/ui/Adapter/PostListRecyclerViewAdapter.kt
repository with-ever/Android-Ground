package com.withever.blind.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.withever.blind.R
import com.withever.blind.ui.ViewHolder.PostListRecyclerViewHolder

class PostListRecyclerviewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_board_cell, parent, false)

        return PostListRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 14
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

}