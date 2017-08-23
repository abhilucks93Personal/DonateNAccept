package com.donatenaccept.dna._profile;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;


/**
 * Created by Pawan on 3/9/2017.
 */

public class ProfilePagerAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount = 2;
    private final SparseArray<Fragment> registeredFragments = new SparseArray<>();

    Fragment frag;


    //Constructor to the class
    public ProfilePagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs

        switch (position) {

            case 0:

                return new AboutMeFragment();

            case 1:

                return new MembersFragment();


            default:
                return null;
        }
    }

    //Overridden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 0:
                return "More About Me";

            case 1:
                return "Members";

            default:
                return null;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    public SparseArray<Fragment> getRegisteredFragments() {
        return registeredFragments;
    }
}