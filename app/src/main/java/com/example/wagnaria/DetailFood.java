package com.example.wagnaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Field;

public class DetailFood extends AppCompatActivity {

    public static String name_food, detail_food, price_food, promo_food, photo;
    TextView food, detail, price, promo;
    ImageView imageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        name_food = getIntent().getStringExtra("name");
        detail_food = getIntent().getStringExtra("detail");
        price_food = getIntent().getStringExtra("price");
        promo_food = getIntent().getStringExtra("promo");
        photo = getIntent().getStringExtra("foto");

        btn = findViewById(R.id.btn_buy);
        food = findViewById(R.id.name_food);
        detail = findViewById(R.id.detail_txt);
        promo = findViewById(R.id.promo_txt);
        price = findViewById(R.id.price_tag);
        imageView = findViewById(R.id.img_food);

        Glide.with(this)
                .load(getResImg(photo,R.drawable.class))
                .centerCrop()
                .into(imageView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailFood.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(DetailFood.this,"Order Success",Toast.LENGTH_SHORT).show();
            }
        });

        food.setText(name_food);
        detail.setText(detail_food);
        promo.setText(promo_food);
        price.setText(price_food);
    }

    public static int getResImg(String res, Class<?> c){
        try{
            Field id = c.getDeclaredField(res);
            return id.getInt(id);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
