package com.example.mvvmarch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.textView);
        Button button=findViewById(R.id.button);

        mainActivityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);

        //Getting the initail count
        //textView.setText("You have clicked me: "+mainActivityViewModel.getInitialCounter());

        // Using live data to get the counter
        LiveData<Integer> count= mainActivityViewModel.getInitialCounter();
        count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText("You clicked  me: "+integer+ " times.");
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityViewModel.getCounter();
            }
        });
    }
}