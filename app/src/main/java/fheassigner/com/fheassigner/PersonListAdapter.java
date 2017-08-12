package fheassigner.com.fheassigner;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;

import java.util.ArrayList;

import model.Model;
import person.Person;

/**
 * Created by Aaron on 8/8/2017.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder> {
    private ArrayList<Person> mPeople;
    private static View mView;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mPersonText;
        public ImageView mImageView;
        public ViewHolder(View v){
            super(v);
            mView = v;
            mPersonText = (TextView)v.findViewById(R.id.person_info_text);
            mImageView = (ImageView)v.findViewById(R.id.person_card_image);
        }
    }

    public PersonListAdapter(ArrayList<Person> people){
        mPeople = people;
    }

    @Override
    public PersonListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_card, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position){
        mPeople = Model.getInstance().getPeople();
        Person person = mPeople.get(position);
        holder.mPersonText.setText(person.getName());
        //holder.mImageView.setImageResource(R.mipmap.person_profile);
        Drawable icon = new IconDrawable(mView.getContext(), Iconify.IconValue.fa_male).color(R.color.colorPrimary);
        holder.mImageView.setImageDrawable(icon);
    }

    @Override
    public int getItemCount(){
        return mPeople.size();
    }
}
