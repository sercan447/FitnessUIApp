package sercandevops.com.fitnessuiapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.security.PublicKey;

import sercandevops.com.fitnessuiapp.FitnessMove;
import sercandevops.com.fitnessuiapp.R;

public class PopupFragment extends Fragment {

    TextView nameText;
    TextView descriptionText;
    TextView caloriText;
    ImageView imageView;
    ProgressBar progressBar;

    private FitnessMove fitnessMove;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_popup,container,false);

        nameText = view.findViewById(R.id.tv_fragment_POPup_Nametext);
        descriptionText = view.findViewById(R.id.tv_fragment_POPup_Descrip);
        caloriText = view.findViewById(R.id.tv_fragment_POPup_Calori);
        imageView = view.findViewById(R.id.img_recylerview_fitness_pictures_popup);
        progressBar = view.findViewById(R.id.prg_recylerview_fitness_pictures_list_popup);

        nameText.setText(fitnessMove.getFitnessName());
        descriptionText.setText(fitnessMove.getFitnessDescription());
        caloriText.setText(""+fitnessMove.getFitnessCalories());

        Picasso.get().load(fitnessMove.getFitnessPicture()).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
        return view;
    }


    public static PopupFragment newInstance()
    {
        return new PopupFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fitnessMove = getActivity().getIntent().getParcelableExtra("INFO");

    }
}
