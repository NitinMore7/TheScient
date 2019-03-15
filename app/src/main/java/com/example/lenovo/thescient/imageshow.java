package com.example.lenovo.thescient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class imageshow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageshow);
        ImageView galleryImage=findViewById(R.id.gallery_image);
        TextView imageText=findViewById(R.id.image_name);
        Bundle bundle=getIntent().getExtras();
        String imglink=bundle.getString("imagelink");
        String imgname=bundle.getString("imagename");
        Picasso.get().load(imglink).resize(450,300).into(galleryImage);
        imageText.setText(imgname);

    }
}
