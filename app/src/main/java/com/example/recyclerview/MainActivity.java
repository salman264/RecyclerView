package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelFeed> modelFeedArrayList=new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new Adapter(this,modelFeedArrayList);
        recyclerView.setAdapter(adapter);

        populateRecyclerView();
    }
        public void populateRecyclerView(){

        ModelFeed modelFeed=new ModelFeed(1,2,3,R.drawable.user1,R.drawable.post1,
                "Salman", "2 hours");
        modelFeedArrayList.add(modelFeed);


             modelFeed=new ModelFeed(2,22,33,R.drawable.user2,R.drawable.post2,
                    "Ali", "3 hours");
            modelFeedArrayList.add(modelFeed);


            modelFeed=new ModelFeed(3,24,34,R.drawable.user3,R.drawable.post3,
                    "Ahmed", "50 minutes");
            modelFeedArrayList.add(modelFeed);

            modelFeed=new ModelFeed(4,23,31,R.drawable.user4,R.drawable.post4,
                    "Saim", "9 hours");
            modelFeedArrayList.add(modelFeed);

            adapter.notifyDataSetChanged();

        }
}
