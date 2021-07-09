package com.example.birdsgridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private ArrayList<Bird> birdList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        buildRecyclerViewData();
        serRecyclerViewAdapter();
    }

    private void serRecyclerViewAdapter() {
        BirdAdapter birdAdapter = new BirdAdapter(birdList,this);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(birdAdapter);

    }

    private void buildRecyclerViewData() {
        birdList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if( i%4 ==0 )
            {
                Bird bird = new Bird("Peacock", R.drawable.pecoke);
                Bird bird1 = new Bird("Mandarin duck ", R.drawable.mandrain);
                birdList.add(bird);
                birdList.add(bird1);

            } else if(i% 4 ==1 ) {
                Bird bird2 = new Bird("Rainbow Lorikeet", R.drawable.rainbow);
                Bird bird3 = new Bird("Keel-Billed Toucan", R.drawable.keel);

                birdList.add(bird2);
                birdList.add(bird3);            }


        }
    }

    @Override
    public void onClickedItem(int position , Bird bird) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Hey this is the Data")
                .setMessage("Name of the bird - "+
                        bird.getName()

                ).
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        show();

    }
}
