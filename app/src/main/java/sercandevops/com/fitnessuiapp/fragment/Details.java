package sercandevops.com.fitnessuiapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import sercandevops.com.fitnessuiapp.R;

public class Details extends Fragment {

        CardView cardView;
        SeekBar radiusSeekbar;
        SeekBar elevationseekBar;


    public static Details newInstance()
    {
        return new Details();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_details,container,false);

            cardView = (CardView)rootView.findViewById(R.id.cardviewis);
            radiusSeekbar = (SeekBar)rootView.findViewById(R.id.details_fragment_seekbar_radius);
            elevationseekBar = (SeekBar)rootView.findViewById(R.id.details_fragment_seekbar_elevation);


            radiusSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    Log.i("TAGLAR",""+progress);
                    cardView.setRadius(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            elevationseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    cardView.setElevation(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        return rootView;
    }
}
