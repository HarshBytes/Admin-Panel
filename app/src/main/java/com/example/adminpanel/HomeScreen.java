package com.example.adminpanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HomeScreen extends AppCompatActivity {
    RecyclerView recommendedCycle;
    recommended_Adapter recommendedAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recommendedCycle = findViewById(R.id.recommended);
        recommendedCycle.setLayoutManager(new LinearLayoutManager(HomeScreen.this));
        FirebaseRecyclerOptions<Datamodel> options = new FirebaseRecyclerOptions.Builder<Datamodel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Recommended Products"), Datamodel.class)
                .build();
         recommendedAdapter = new recommended_Adapter(options);
        recommendedCycle.setAdapter(recommendedAdapter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        recommendedAdapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        recommendedAdapter.startListening();
    }

}