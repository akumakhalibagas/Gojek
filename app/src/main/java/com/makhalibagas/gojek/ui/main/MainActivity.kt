package com.makhalibagas.gojek.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.makhalibagas.gojek.R
import com.makhalibagas.gojek.databinding.ActivityMainBinding
import com.makhalibagas.gojek.databinding.ItemsTabsBinding
import com.makhalibagas.gojek.ui.chat.ChatsFragment
import com.makhalibagas.gojek.ui.home.HomeFragment
import com.makhalibagas.gojek.ui.promos.PromosFragment

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter : TabsAdapter by lazy {
        TabsAdapter(this, arrayListOf(PromosFragment(), HomeFragment(), ChatsFragment()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupAdapter()
    }


    private fun setupAdapter() {
        binding.pager.adapter = adapter
        TabLayoutMediator(binding.tab, binding.pager) { tab, position ->
            when (position) {
                0 -> { tab.customView = getTabLayout(getString(R.string.title_promos), R.drawable.ic_promos) }
                1 -> { tab.customView = getTabLayout(getString(R.string.title_home), R.drawable.ic_home) }
                2 -> { tab.customView = getTabLayout(getString(R.string.title_chats), R.drawable.ic_chats) }
            }
        }.attach()
        binding.pager.setCurrentItem(0, true)
    }

    private fun getTabLayout(title: String, icon: Int): View {
        val tabBinding = ItemsTabsBinding.inflate(layoutInflater)
        tabBinding.title.text = title
        tabBinding.icon.setImageResource(icon)
        return tabBinding.root
    }
}