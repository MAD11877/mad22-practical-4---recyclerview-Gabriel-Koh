package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import android.content.DialogInterface;
import android.content.Intent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    User user;
    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (int i = 0 ; i < 20; i++){
            user = new User(
                    "Name " + new Random().nextInt(),
                    "Description" + new Random().nextInt(),
                    i,
                    new Random().nextBoolean()
            );
            userList.add(user);
        }

        RecyclerView recyclerViewUser = findViewById(R.id.recyclerView);
        MyAdapter mAdapter = new MyAdapter(userList);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(sLayoutManager);
        recyclerViewUser.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUser.setAdapter(mAdapter);
    }
}