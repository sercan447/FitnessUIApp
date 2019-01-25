package sercandevops.com.fitnessuiapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sercandevops.com.fitnessuiapp.FitnessMove;
import sercandevops.com.fitnessuiapp.PopupActivity;
import sercandevops.com.fitnessuiapp.R;
import sercandevops.com.fitnessuiapp.adapter.FitnessPictureAdapter;

public class FitnessPictures extends Fragment implements FitnessPictureAdapter.MyListener {

    private FitnessPictureAdapter fitnessPictureAdapter;
    private RecyclerView recyclerView;
    private ArrayList<FitnessMove> fitnessMoves;


    public static FitnessPictures newInstance()
    {
        return new FitnessPictures();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fitness_pictures,container,false);
        fitnessPictureAdapter = new FitnessPictureAdapter((AppCompatActivity)getActivity(),this);

        fitnessMoves = fitnessPictureAdapter.getFitnessMoves();

        recyclerView = rootView.findViewById(R.id.fragment_fitness_pictures_recylerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        getFitnessMoves(fitnessMoves);

        if(isAdded()) {
            recyclerView.setAdapter(fitnessPictureAdapter);
        }
        return rootView;
    }

    private ArrayList<FitnessMove> getFitnessMoves (ArrayList<FitnessMove> fitnessMovest)
    {
        for(int i=0;i<16;i++)
        {
            fitnessMovest.add(new FitnessMove("Fitness move name "+i,
                            "http://atilsamancioglu.com/wp-content/uploads/2018/06/fitness"+i+".jpg",
                        "fitnes move descrip", 1));
        }
        return fitnessMovest;
    }

    @Override
    public void MyListener(FitnessMove fitnessMove) {

        Intent intent = PopupActivity.newIntent(getActivity(),fitnessMove);
        startActivity(intent);

    }
}
