package com.wedapp.sud.myapp2;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class InfoTabFragment extends Fragment {
private int [] sliderImg;
    private int currentimageindex = 0;
    View view;
    Context context;
    public InfoTabFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_infotab_fragment, container, false);
        context = container.getContext();
        sliderImg = getArguments().getIntArray("slideImg");
        String info = getArguments().getString("info");
        TextView infoTab = (TextView) view.findViewById(R.id.infoTab);
        infoTab.setText(info);
        final Handler mHandler = new Handler();
        final Runnable slideShow = new Runnable() {
            @Override
            public void run() {
                AnimateSlideShow();
            }
        };
        int delay = 1000; // delay for 1 sec.
        int period = 3600; // repeat every 4 sec.
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                mHandler.post(slideShow);
            }
        }, delay, period);

        return view;
    }
    private void AnimateSlideShow(){
        ImageView imageView = (ImageView) view.findViewById(R.id.slide_img);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(sliderImg[currentimageindex%sliderImg.length]);
        currentimageindex ++;
        Animation rotateimage = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        imageView.startAnimation(rotateimage);
    }
}
