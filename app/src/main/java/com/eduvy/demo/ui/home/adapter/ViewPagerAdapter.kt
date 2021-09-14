package com.eduvy.demo.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.eduvy.demo.ui.home.fragment.FragmentCourses
import com.eduvy.demo.ui.home.fragment.FragmentInstitution

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position == 0) {
            fragment = FragmentInstitution()
        } else if (position == 1) {
            fragment = FragmentCourses()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0) {
            title = "Institution"
        } else if (position == 1) {
            title = "Courses"
        }
        return title
    }
}