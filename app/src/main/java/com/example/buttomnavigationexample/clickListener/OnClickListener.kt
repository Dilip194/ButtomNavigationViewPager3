package com.example.buttomnavigationexample.clickListener

import com.example.buttomnavigationexample.data.GitResponseItem

open class OnClickListener(val clickListener: (gitResponseItem : GitResponseItem) -> Unit) {
    fun onClick(gitResponseItem : GitResponseItem) = clickListener(gitResponseItem)
}