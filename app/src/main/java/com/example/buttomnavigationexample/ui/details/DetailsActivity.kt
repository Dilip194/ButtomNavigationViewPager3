package com.example.buttomnavigationexample.ui.details

import android.content.ContentResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.buttomnavigationexample.R
import com.example.buttomnavigationexample.data.GitResponseItem
import com.example.buttomnavigationexample.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Details"

        binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        val args = intent.getSerializableExtra("details") as GitResponseItem
        binding.repo = args
    }
}