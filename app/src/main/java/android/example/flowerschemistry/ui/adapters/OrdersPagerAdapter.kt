package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.ui.fragments.ActiveOrdersFragment
import android.example.flowerschemistry.ui.fragments.CompletedOrdersFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OrdersPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ActiveOrdersFragment()
            1 -> return CompletedOrdersFragment()
        }
        return CompletedOrdersFragment()
    }

    companion object{
        const val NUM_TABS =2
    }
}