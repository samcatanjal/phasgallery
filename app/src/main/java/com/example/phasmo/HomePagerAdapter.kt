package com.example.phasmo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    // Return the number of fragments
    override fun getItemCount(): Int {
        return 3
    }

    // Return the fragment for the given position
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GhostsFragment()
            1 -> PossessionsFragment()
            2 -> EquipmentFragment()
            else -> GhostsFragment()
        }
    }
}