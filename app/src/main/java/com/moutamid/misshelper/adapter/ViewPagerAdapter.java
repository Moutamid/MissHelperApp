package com.moutamid.misshelper.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.moutamid.misshelper.fragments.ContactUsFragment;
import com.moutamid.misshelper.fragments.FaqFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FaqFragment();
        } else {
            return new ContactUsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
