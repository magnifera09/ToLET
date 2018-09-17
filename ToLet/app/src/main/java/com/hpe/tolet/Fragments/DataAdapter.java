package com.hpe.tolet.Fragments;

/**
 * Created by pc on 12-07-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hpe.tolet.R;
import com.hpe.tolet.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private LayoutInflater inflater;
    List<GetSet> data = Collections.emptyList();

    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public DataAdapter(Context context, List<GetSet> data) {
        this.context = context;

        this.data = data;


    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_fish, parent, false);
        MyHolder holder = new MyHolder(view, data, context);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        final MyHolder myHolder = (MyHolder) holder;
      final   GetSet   current = data.get(position);
        myHolder.location.setText("Location:" + current.getPaddress());
        myHolder.price.setText("Price: " + current.getPpricerange() + ".Rs");
        myHolder.type.setText("PlotType: " + current.getTopr());
        myHolder.owner.setText("Owner:" + current.getPownername());

        myHolder.roommates.setText("Roommates: " + current.getSelectedPermissionsRadio());

        Picasso.with(holder.itemView.getContext()).load(current.getImagepath1())
                .resize(90, 90)
                .error(R.drawable.ic_image_error)
                .into(myHolder.iv);

        //click event
        ((MyHolder) holder).imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ItemDetailView.class);
           // Log.d("TAG",current.paddress+""+current.pownername);
                intent.putExtra("top", current.getTop());
                intent.putExtra("topr", current.getTopr());
                intent.putExtra("loc", current.getPaddress());
                intent.putExtra("price", current.getPpricerange());
                intent.putExtra("own", current.getPownername());
                intent.putExtra("roomm", current.getSelectedPermissionsRadio());
                intent.putExtra("detail", current.getPdetails());
                intent.putExtra("mob", current.getPphoneno());
                intent.putExtra("imagepath", current.getImagepath1());

                v.getContext().startActivity(intent);
            }
        });
//
        ((DataAdapter.MyHolder) holder).wishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DataAdapter.MyHolder) holder).wishButton.setVisibility(View.INVISIBLE);
                ((DataAdapter.MyHolder) holder).wishButton2.setVisibility(View.VISIBLE);
                SharedPreference sharedPreference=new SharedPreference();
                sharedPreference.addFavorite(context,data.get(position));

//
                Log.d("Tag","wish"+ current.getPownername() +""+ current.getPphoneno() +""+ current.getPaddress() +"image"+ current.getImagepath1());

            }
        });

    }


    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView location, price, type, owner, roommates;
        ImageView iv;
        ImageButton wishButton,wishButton2;
        Context ctx;
        ImageButton imageButton;
        RelativeLayout rv;
        List<GetSet> data = Collections.emptyList();


        // create constructor to get widget reference
        public MyHolder(View itemView, List<GetSet> data, Context ctx) {
            super(itemView);

            this.data = data;
            this.ctx = context;
            Log.d("TAG", "onClick: ");
            location = itemView.findViewById(R.id.txtlocation);
            price = itemView.findViewById(R.id.txtplotPrice);
            type = itemView.findViewById(R.id.txtplotType);
            owner = itemView.findViewById(R.id.txtowner);
            roommates = itemView.findViewById(R.id.txtroommates);
            iv = itemView.findViewById(R.id.ivImage);
            rv = itemView.findViewById(R.id.relv);
            imageButton = itemView.findViewById(R.id.next);

            wishButton=itemView.findViewById(R.id.wish);
            wishButton2=itemView.findViewById(R.id.wish2);

        }

    }



}








