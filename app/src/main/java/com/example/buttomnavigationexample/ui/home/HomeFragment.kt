package com.example.buttomnavigationexample.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.buttomnavigationexample.R
import com.example.buttomnavigationexample.clickListener.OnClickListener
import com.example.buttomnavigationexample.data.GitResponseItem
import com.example.buttomnavigationexample.databinding.FragmentHomeBinding
import com.example.buttomnavigationexample.ui.MainViewModel
import com.example.buttomnavigationexample.ui.adapter.GitAdapter
import com.example.buttomnavigationexample.ui.details.DetailsActivity
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var gitAdapter: GitAdapter
    private var homeViewModel: MainViewModel? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        gitAdapter = GitAdapter(this.context,OnClickListener{
            val intent = Intent(activity,DetailsActivity::class.java)
            intent.putExtra("details",it)
            startActivity(intent)
        })

        setupRecyclerView()
        loadData()
        getListItem()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        //gitAdapter = GitAdapter()
        binding.recyclerView.apply {
            adapter = gitAdapter
            layoutManager = StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }
    }

    private fun loadData() {
        lifecycleScope.launch {
            homeViewModel.let {
                homeViewModel!!.listData.collect {
                    Log.d("aaa", "load: $it")
                    gitAdapter.submitData(it)
                }
            }

        }
    }
    fun getListItem(){
        homeViewModel?.listRepoData = gitAdapter.snapshot().items
        Log.d("aaa", "git: ${homeViewModel?.listRepoData}")
    }
}