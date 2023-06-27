package com.example.adminpanel;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class recommended_Adapter extends FirebaseRecyclerAdapter<Datamodel,recommended_Adapter.viewholder> {

    public recommended_Adapter(@NonNull FirebaseRecyclerOptions<Datamodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull Datamodel model) {
        Log.d("Adapter", "Data received: " + model.toString());  // Log the data received from Firebase
    holder.textView.setText(model.getProductName());
    holder.price.setText(model.getProductPrice());

        String imageURL = model.getProductURL();
        Glide.with(holder.img.getContext())
                .load(imageURL)
                .into(holder.img);

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_row,parent,false);
        return new viewholder(view);
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textView,price;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.food_image);
            textView=itemView.findViewById(R.id.food_name);
            price=itemView.findViewById(R.id.food_price);
        }
    }
}
