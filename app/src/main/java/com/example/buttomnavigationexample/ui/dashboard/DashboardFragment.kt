package com.example.buttomnavigationexample.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buttomnavigationexample.R
import com.example.buttomnavigationexample.clickListener.OnClickListener
import com.example.buttomnavigationexample.data.GitResponseItem
import com.example.buttomnavigationexample.databinding.FragmentDashboardBinding
import com.example.buttomnavigationexample.ui.MainViewModel
import com.example.buttomnavigationexample.ui.details.DetailsActivity
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private var dashboardViewModel : MainViewModel? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerViewDash

       /* dashboardViewModel?.list?.observe(viewLifecycleOwner, Observer {
            gitRepoList = it
        })*/
        /*dashboardViewModel.list.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        loadData()
        return root
    }

    fun loadData(){
        lifecycleScope.launch{
                val layoutManager = LinearLayoutManager(activity)
                binding.recyclerViewDash.layoutManager = layoutManager
            dashboardViewModel?.listRepoData?.let {
                binding.recyclerViewDash.adapter = DashBoardAdapter(dashboardViewModel?.listRepoData!!, OnClickListener{
                    val intent = Intent(activity, DetailsActivity::class.java)
                    intent.putExtra("details",it)
                    startActivity(intent)
                })
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}