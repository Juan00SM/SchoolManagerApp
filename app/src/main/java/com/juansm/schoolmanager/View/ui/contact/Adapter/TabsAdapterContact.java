package com.juansm.schoolmanager.View.ui.contact.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.juansm.schoolmanager.View.ui.contact.Fragment.StudentFragment;
import com.juansm.schoolmanager.View.ui.contact.Fragment.TeacherFragment;

import java.util.List;

public class TabsAdapterContact extends FragmentPagerAdapter {

    private final int num_tabs;
    private final List<String> title_tabs;

    public TabsAdapterContact(@NonNull FragmentManager fm, List<String> titleTabs) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.num_tabs = titleTabs.size();
        this.title_tabs = titleTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                StudentFragment student = new StudentFragment();
                return student;
            case 1:
                TeacherFragment teacher = new TeacherFragment();
                return teacher;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.num_tabs;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return this.title_tabs.get(position);
    }
}
