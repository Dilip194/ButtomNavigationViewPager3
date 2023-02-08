package com.example.buttomnavigationexample.ui.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.buttomnavigationexample.clickListener.OnClickListener
import com.example.buttomnavigationexample.data.GitResponse
import com.example.buttomnavigationexample.data.GitResponseItem
import com.example.buttomnavigationexample.databinding.CharacterLayoutBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch
import java.net.URL

class GitAdapter(val context : Context?, private val onClickListener: OnClickListener) : PagingDataAdapter<GitResponseItem,GitViewHolder>(diffCallBack){


companion object{

    val diffCallBack = object : DiffUtil.ItemCallback<GitResponseItem>(){
        override fun areItemsTheSame(oldItem: GitResponseItem, newItem: GitResponseItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitResponseItem, newItem: GitResponseItem): Boolean {
            return oldItem == newItem
        }
    }}

    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
                tvDescription.text = "${currChar?.login}"
                val imageLink = currChar?.avatar_url

                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
            }


            holder.itemView.setOnClickListener {
                if (currChar != null) {
                    onClickListener.onClick(currChar)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitViewHolder {
        return GitViewHolder(
            CharacterLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }
}