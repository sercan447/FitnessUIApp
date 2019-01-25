package sercandevops.com.fitnessuiapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sercandevops.com.fitnessuiapp.FitnessMove;
import sercandevops.com.fitnessuiapp.FitnessPictureViewHolder;
import sercandevops.com.fitnessuiapp.R;

public class FitnessPictureAdapter extends RecyclerView.Adapter<FitnessPictureViewHolder> implements View.OnClickListener {

    private ArrayList<FitnessMove> fitnessMoves;
    private LayoutInflater layoutInflater;
    private AppCompatActivity appCompatActivity;
    private MyListener myListener;


    public FitnessPictureAdapter(AppCompatActivity appCompatActivity,MyListener myListener) {

        this.appCompatActivity = appCompatActivity;
        this.myListener = myListener;
        layoutInflater = appCompatActivity.getLayoutInflater();
        fitnessMoves = new ArrayList<>();

    }

    public ArrayList<FitnessMove> getFitnessMoves() {
        return fitnessMoves;
    }

    @NonNull
    @Override
    public FitnessPictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View listvie = layoutInflater.inflate(R.layout.recylerview_fitness_picture_list,viewGroup,false);
        listvie.setOnClickListener(this);


        return new FitnessPictureViewHolder(listvie);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessPictureViewHolder fitnessPictureViewHolder, int i) {
        fitnessPictureViewHolder.getMoves(appCompatActivity,fitnessMoves.get(i));
    }

    @Override
    public int getItemCount() {
        return fitnessMoves.size();
    }


    @Override
    public void onClick(View v) {

        if (v.getTag() instanceof FitnessMove) {

            FitnessMove fitnessMove = (FitnessMove) v.getTag();
            myListener.MyListener(fitnessMove);

        }
    }

    public interface MyListener
    {
        public void MyListener(FitnessMove fitnessMove);

    }//INTERFACE
}
