package com.example.lap07_roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    EditText tvName;
    Button btnAdd;
    Button btnDelete;
    Button btnCancel;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private ArrayList<User> userArrayList;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tvName);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnRemove);
        btnCancel = findViewById(R.id.btnCancel);
        recyclerView = findViewById(R.id.recView);
        userArrayList = new ArrayList<>();
        userAdapter = new UserAdapter();
        userAdapter.setData(userArrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }

        });
    }
    private void addUser() {

        String name =tvName.getText().toString().trim();
        if(name.isEmpty()){
            return;
        }
        User user= new User(name);
        UserDatabase.getInstance(this).userDao().insertAll(user);
        Toast.makeText(this, "Thanh Cong", Toast.LENGTH_SHORT).show();
        tvName.setText("");
        userArrayList= (ArrayList<User>) UserDatabase.getInstance(this).userDao().getAll();
        userAdapter.setData(userArrayList);
    }

}