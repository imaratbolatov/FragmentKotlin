package com.marat.bolatov.fragmentkotlin


import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.marat.bolatov.fragmentkotlin.fragments.ScreenSlidePageFragment

private const val NUM_PAGES = 5

class ScreenSlidePageActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_slide_page)
        viewPager = findViewById(R.id.pager)
        val pagerAdapter = ScreenSlidePageAdapter(this)
        viewPager.adapter = pagerAdapter
    }



    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        }
        else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private inner class ScreenSlidePageAdapter(fragmentActivity : FragmentActivity): FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = ScreenSlidePageFragment()
    }
}