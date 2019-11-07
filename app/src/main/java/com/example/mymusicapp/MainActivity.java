package com.example.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    TextView textView;
    int pausePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        play = (Button)findViewById(R.id.play);
        pause = (Button)findViewById(R.id.pause);
        stop = (Button)findViewById(R.id.stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play:
            if(mediaPlayer==null) {
                textView.setText("Playing: Fort Minor - Remember the Name");
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song);
                mediaPlayer.start();
            }
            else if(!mediaPlayer.isPlaying()) {
                textView.setText("Playing: Fort Minor - Remember the Name");
                mediaPlayer.seekTo(pausePosition);
                mediaPlayer.start();
            }
                break;
            case R.id.pause:
            if(mediaPlayer!=null) {
                textView.setText("Paused: Fort Minor - Remember the Name");
                mediaPlayer.pause();
                pausePosition = mediaPlayer.getCurrentPosition();

            }
                break;
            case R.id.stop:
                if(mediaPlayer!=null) {
                    textView.setText("Stopped: Fort Minor - Remember the Name");
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;
        }
    }
}
