package com.makhalibagas.gojek.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.makhalibagas.gojek.databinding.BottomSheetBinding
import com.makhalibagas.gojek.databinding.FragmentHomeBinding
import com.makhalibagas.gojek.ui.home.adapter.*

class HomeFragment : Fragment() {

    private val binding : FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val viewModel : HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomSheet()
        setupBottomSheetMenu()
        setupAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }
    private fun setupBottomSheet() {
        val behavior: BottomSheetBehavior<LinearLayout> = BottomSheetBehavior.from(binding.bottomSheet)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun setupBottomSheetMenu(){
        val behavior : BottomSheetBehavior<LinearLayout> = BottomSheetBehavior.from(binding.includeBottomSheet.bottomSheetMenu)
        binding.viewBottomSheet.setOnClickListener {
            if (behavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }
    }

    private fun setupAdapter() {

        binding.include.rvContent.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        viewModel.setContent()
        viewModel.getContent().observe(viewLifecycleOwner,{
            binding.include.rvContent.adapter = ContentAdapter(it)
        })

        binding.include.rvForyou.layoutManager = LinearLayoutManager(context)
        viewModel.setImage()
        viewModel.getImage().observe(viewLifecycleOwner, {
            binding.include.rvForyou.adapter = ForyouAdapter(it)
        })

        binding.include.rvGocar.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        viewModel.setGocar()
        viewModel.getGocar().observe(viewLifecycleOwner,{
            binding.include.rvGocar.adapter = GocarAdapter(it)
        })


        binding.include.rvGoride.layoutManager = LinearLayoutManager(context)
        viewModel.setGoride()
        viewModel.getGoride().observe(viewLifecycleOwner,{
            binding.include.rvGoride.adapter = GorideAdapter(it)
        })

        binding.include.rvGofood.layoutManager = GridLayoutManager(context, 2)
        viewModel.setGofood()
        viewModel.getGofood().observe(viewLifecycleOwner,{
            binding.include.rvGofood.adapter = GofoodrAdapter(it)
        })
    }


}