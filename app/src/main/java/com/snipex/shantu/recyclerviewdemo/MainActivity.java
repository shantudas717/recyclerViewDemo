package com.snipex.shantu.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button button1, button2, button3;
    private LinearLayout layout1, layout2, layout3;
    private TextView tv1, tv2, tv3;
    private ArrayList<Model> arrayList;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private int selectedButton;
    private int cunt1 = 0, cunt2 = 0, cunt3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this, arrayList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Log.d(TAG, "onPositionClicked: position " + position);

                switch (selectedButton) {
                    case 1:
                        cunt1 += 1;
                        tv1.setText(String.valueOf(cunt1));
                        break;
                    case 2:
                        cunt2 += 1;
                        tv2.setText(String.valueOf(cunt2));
                        break;
                    case 3:
                        cunt3 += 1;
                        tv3.setText(String.valueOf(cunt3));
                        break;
                }
            }

            @Override
            public void onLongClicked(int position) {

            }
        });
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                arrayList.clear();
                selectedButton = 1;
                getData();
                break;
            case R.id.button2:
                arrayList.clear();
                selectedButton = 2;
                getData();
                break;
            case R.id.button3:
                arrayList.clear();
                selectedButton = 3;
                getData();
                break;
        }
    }

    private void getData() {
        Model model = new Model("This is dummy title");
        arrayList.add(model);

        model = new Model("This is new dummy title");
        arrayList.add(model);

        adapter.notifyDataSetChanged();
    }
}
