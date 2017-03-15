package com.example.islam.project_management;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public SectionsPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment tab1 = new ProjectDetailsFragment();
                return tab1;
            case 1:
                ApprovedActivtiesFragment tab2 = new ApprovedActivtiesFragment();
                return tab2;
            case 2:
                PendingActivitesFragment tab3 = new PendingActivitesFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
