package com.example.wagnaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String name, detail, price, promo, foto;
    private RecyclerView rvImg;
    private ArrayList<FoodDataset> list = new ArrayList<>();
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        animation = AnimationUtils.loadAnimation(this,R.anim.zoom_in);

        rvImg = findViewById(R.id.grid_view);
        rvImg.setHasFixedSize(true);

        list.addAll(FoodDataStore.getListData());
        showRecycleGrid();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this,About.class);
            startActivity(intent);
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecycleGrid(){
        rvImg.setLayoutManager(new GridLayoutManager(this, 2));
        GridAdapter gridAdapter = new GridAdapter(list);
        rvImg.setAdapter(gridAdapter);
        gridAdapter.setOnListClick(new GridAdapter.OnListClick() {
            @Override
            public void onItemClick(FoodDataset foodDataset) {
                showDetailFood(foodDataset);
            }
        });
    }

    private void showDetailFood(FoodDataset foodDataset){
        name = foodDataset.getFood();
        detail = foodDataset.getDetail();
        promo = foodDataset.getPromo();
        price = foodDataset.getPrice();
        foto = foodDataset.getPhoto();
        Intent intent = new Intent(this,DetailFood.class);
        intent.putExtra("name",name);
        intent.putExtra("detail",detail);
        intent.putExtra("promo",promo);
        intent.putExtra("foto",foto);
        intent.putExtra("price",price);
        startActivity(intent);

    }

}
