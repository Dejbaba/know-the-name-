package com.dejman.deji.knowthename;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;

public class MenuActivity extends BaseGameActivity implements OnClickListener {


    private AdView mAdView;
    //Button Startbtn, Rate, Share;
    ImageButton leaderboard, rate, playbutton, share;
    String highscore;

    MediaPlayer sound;
    private String TAG = "OrientationDemo";
    //RelativeLayout rL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        loadSavedPreferences();

        findViewById(R.id.sign_in_button).setOnClickListener(this);
        findViewById(R.id.sign_out_button).setOnClickListener(this);

        MobileAds.initialize(this, "ca-app-pub-9884126874121857~6016182321");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                //.addTestDevice("7F3FC1BDD7BB75005B7F823B325F2A08")
                .build();
        mAdView.loadAd(adRequest);




        Log.e(TAG, "running oncreate()");
        /*Startbtn = (Button) findViewById(R.id.startbtn);
        Share = (Button) findViewById(R.id.share);
        Rate = (Button) findViewById(R.id.rate);*/
       // play = (ImageButton) findViewById(R.id.img_play);
        leaderboard = (ImageButton) findViewById(R.id.img_leaderboard);
        rate= (ImageButton) findViewById(R.id.img_rate);
        playbutton = (ImageButton) findViewById(R.id.img_playbutton);
        share = (ImageButton) findViewById(R.id.img_share);
        //rL = (RelativeLayout) findViewById(R.id.rL_menu);

        //rL.setBackgroundColor(Color.BLACK);

        /*AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        switch (am.getRingerMode()) {
            case AudioManager.RINGER_MODE_SILENT:
                Log.e(TAG, "Silent mode");

                am.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                am.setStreamMute(AudioManager.STREAM_ALARM, true);
                am.setStreamMute(AudioManager.STREAM_MUSIC, true);
                am.setStreamMute(AudioManager.STREAM_RING, true);
                am.setStreamMute(AudioManager.STREAM_SYSTEM, true);

                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                Log.e(TAG, "Vibrate mode");
               *//* am.setRingerMode(1);*//*
                *//*Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                mVibrator.vibrate(300);*//*

                break;
            case AudioManager.RINGER_MODE_NORMAL:
                Log.e(TAG, "Normal mode");

                
                am.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                am.setStreamMute(AudioManager.STREAM_ALARM, false);
                am.setStreamMute(AudioManager.STREAM_MUSIC, false);
                am.setStreamMute(AudioManager.STREAM_RING, false);
                am.setStreamMute(AudioManager.STREAM_SYSTEM, false);

                break;
        }*/


     /*   Startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Rate.setEnabled(false);
                Share.setEnabled(false);


                *//*sound = MediaPlayer.create(MenuActivity.this, R.raw.buttonsound);
                sound.start();*//*
                Intent start = new Intent(MenuActivity.this, MainActivity.class);


                Rate.setEnabled(true);
                Share.setEnabled(true);
                startActivity(start);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                finish();
            }
        });*/

        playbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rate.setEnabled(false);
                share.setEnabled(false);
                leaderboard.setEnabled(false);
                playbutton.setEnabled(false);


                /*sound = MediaPlayer.create(MenuActivity.this, R.raw.buttonsound);
                sound.start();*/
                Intent start = new Intent(MenuActivity.this, MainActivity.class);


                rate.setEnabled(true);
                share.setEnabled(true);
                leaderboard.setEnabled(true);
                playbutton.setEnabled(true);
                startActivity(start);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                finish();
            }
        });

        /*Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Startbtn.setEnabled(false);
                Share.setEnabled(false);


               *//* sound = MediaPlayer.create(MenuActivity.this, R.raw.buttonsound);
                sound.start();*//*
                Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                Startbtn.setEnabled(true);
                Share.setEnabled(true);

                try{
                    startActivity(goToMarket);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("htt://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));

                }

            }
        });*/

        rate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                playbutton.setEnabled(false);
                share.setEnabled(false);
                leaderboard.setEnabled(false);
                rate.setEnabled(false);


               /* sound = MediaPlayer.create(MenuActivity.this, R.raw.buttonsound);
                sound.start();*/
                Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                playbutton.setEnabled(true);
                share.setEnabled(true);
                leaderboard.setEnabled(true);
                rate.setEnabled(true);

                try{
                    startActivity(goToMarket);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("htt://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));

                }
            }
        });

        /*Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Rate.setEnabled(false);
                Startbtn.setEnabled(false);


               *//* sound = MediaPlayer.create(MenuActivity.this, R.raw.buttonsound);
                sound.start();*//*
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                Rate.setEnabled(true);
                Startbtn.setEnabled(true);

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey Buddy, trust Me you'd Want To Play This Awesome New Game 'Know The Name?' download at https://play.google.com/store/apps/details?id=com.dejman.deji.knowthename");

                startActivity(Intent.createChooser(shareIntent, "Spread The Word"));

            }
        });*/

       share.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rate.setEnabled(false);
                playbutton.setEnabled(false);
                leaderboard.setEnabled(false);
                share.setEnabled(false);


                /*sound = MediaPlayer.create(MenuActivity.this, R.raw.buttonsound);
                sound.start();*/
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                playbutton.setEnabled(true);
                rate.setEnabled(true);
                leaderboard.setEnabled(true);
                share.setEnabled(true);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey Buddy, trust Me you'd Want To Play This Awesome New Game 'Know The Name?' download at https://play.google.com/store/apps/details?id=com.dejman.deji.knowthename");

                startActivity(Intent.createChooser(shareIntent, "Spread The Word"));
            }
        });
       leaderboard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rate.setEnabled(false);
                share.setEnabled(false);
                leaderboard.setEnabled(false);
                playbutton.setEnabled(false);


                if(getApiClient().isConnected()){

                    Games.Leaderboards.submitScore(getApiClient(),
                            getString(R.string.ktn_leaderboard),
                            Integer.parseInt(highscore));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Failed",
                            Toast.LENGTH_LONG).show();
                }
                startActivityForResult(Games.Leaderboards.getLeaderboardIntent(
                        getApiClient(), getString(R.string.ktn_leaderboard)),
                        2);



                rate.setEnabled(true);
                share.setEnabled(true);
                leaderboard.setEnabled(true);
                playbutton.setEnabled(true);

            }
        });








    }

    public void onBackPressed(){

        super.onBackPressed();
        Log.e(TAG, "this is working");
        finish();

    }
    @Override
    public void onSignInFailed() {
        findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
        findViewById(R.id.sign_out_button).setVisibility(View.GONE);
        findViewById(R.id.img_leaderboard).setVisibility(View.GONE);

    }

    @Override
    public void onSignInSucceeded() {
        findViewById(R.id.sign_in_button).setVisibility(View.GONE);
        findViewById(R.id.sign_out_button).setVisibility(View.VISIBLE);
        findViewById(R.id.img_leaderboard).setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sign_in_button) {
            beginUserInitiatedSignIn();
        }
        else if (view.getId() == R.id.sign_out_button) {
            signOut();
            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
            findViewById(R.id.sign_out_button).setVisibility(View.GONE);
            findViewById(R.id.img_leaderboard).setVisibility(View.GONE);
        }
    }
    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        highscore = sharedPreferences.getString("improve", "0");
    }




}
