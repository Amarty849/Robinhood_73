package com.example.todolistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTask;
    Button btnAdd;
    ListView listView;
    ArrayList<String> taskList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTask = findViewById(R.id.editTask);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTask.getText().toString();
                if (!task.isEmpty()) {
                    taskList.add(task);
                    adapter.notifyDataSetChanged();
                    editTask.setText("");
                }
            }
        });
    }
}
