package Adapters

import Fragments.DummyFragment
import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import Fragments.MapFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { MapFragment() }
            1 -> { DummyFragment() }
            else -> {throw Resources.NotFoundException("Position not found")}
        }
    }
}