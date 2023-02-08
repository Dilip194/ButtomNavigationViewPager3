package com.example.buttomnavigationexample.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buttomnavigationexample.R
import com.example.buttomnavigationexample.clickListener.OnClickListener
import com.example.buttomnavigationexample.data.GitResponseItem
import com.example.buttomnavigationexample.databinding.DashboardContentBinding

class DashBoardAdapter(val gitResponseItem: List<GitResponseItem>, val onclick : OnClickListener) : RecyclerView.Adapter<DashBoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder {
        val itemView = DashboardContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DashBoardViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return gitResponseItem.size ?: 0
    }

    override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
        val gitRepo = gitResponseItem.get(position)
        holder.onBind(gitRepo,onclick)
    }
}