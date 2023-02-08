package com.example.buttomnavigationexample.ui.dashboard

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.buttomnavigationexample.clickListener.OnClickListener
import com.example.buttomnavigationexample.data.GitResponseItem
import com.example.buttomnavigationexample.databinding.DashboardContentBinding

class DashBoardViewHolder(val view : DashboardContentBinding) : RecyclerView.ViewHolder(view.root) {


    fun onBind(gitRepo: GitResponseItem, onclick: OnClickListener) {
        view.tvDescription.text = gitRepo.id.toString()
        view.cardView.setOnClickListener{
            onclick.onClick(gitRepo)
        }
    }

}