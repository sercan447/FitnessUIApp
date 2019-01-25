package sercandevops.com.fitnessuiapp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import sercandevops.com.fitnessuiapp.fragment.Details;
import sercandevops.com.fitnessuiapp.fragment.FitnessPictures;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment selectedFragment;

        switch (i)
        {
            case 0:
                selectedFragment = FitnessPictures.newInstance();
                break;
            case 1:
                selectedFragment = Details.newInstance();
                break;
                default:
                    return null;
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        CharSequence selectedTitle;

            switch (position)
            {
                case 0:
                    selectedTitle = "Fitness Pictures";
                    break;
                case 1:
                    selectedTitle = "Details";
                    break;
                default:
                    return null;
            }

        return selectedTitle;
    }
}
