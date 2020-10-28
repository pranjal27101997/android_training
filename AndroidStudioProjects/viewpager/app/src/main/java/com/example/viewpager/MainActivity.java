package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);

        int [] image={R.drawable.a1,R.drawable.a2};
    viewPager.setAdapter(new MyAdapter(image,MainActivity.this));

    }
}
class MyAdapter extends PagerAdapter{

    int[] image;
    Context context;

    public MyAdapter(int[] image, Context context) {
        this.image = image;
        this.context = context;
    }

    @Override
    public int getCount() {

        return image.length;
        // jitni image ki length hai utni baar chalega
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
        //view==object=== true return krega
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =inflater.inflate(R.layout.image_view,container,false);
        container.addView(v);

        //instantiateItem== to instantiate an item or to show abstraction
        // addView==jb swipe krte h toh ye img daal deta h container mai.
    //inflater--taking the layout XML and parsing it to create the view

        ImageView imageView=v.findViewById(R.id.imageView);
        imageView.setImageResource(image[position]);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup)object);

        //destroyItem== jb scrolling end ho jaigi mtlb image nhi h aage ab peeche chlo
    }
}

// to create a sliding UI screen