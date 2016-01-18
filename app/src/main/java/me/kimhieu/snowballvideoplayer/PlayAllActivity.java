package me.kimhieu.snowballvideoplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.devbrackets.android.exomedia.EMVideoView;
import com.devbrackets.android.exomedia.listener.ExoPlayerListener;
import com.google.android.exoplayer.ExoPlayer;

/**
 * Created by kimhieu on 1/18/16.
 */
public class PlayAllActivity extends AppCompatActivity {

    EMVideoView emVideoView;
    int playListSize = AppData.videoList.size();
    int playListCurrent = 0;
    boolean alreadyPlay = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_all);

        this.emVideoView = (EMVideoView)findViewById(R.id.video_play_activity_video_view);
        this.emVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                emVideoView.start();
                alreadyPlay = true;
            }
        });
        this.emVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emVideoView.isPlaying()){
                    emVideoView.pause();
                } else {
                    emVideoView.start();
                }
            }
        });

        emVideoView.setDefaultControlsEnabled(false);

        emVideoView.setVideoURI(Uri.parse(AppData.videoList.get(playListCurrent)));


        emVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(playListCurrent < playListSize-1 && alreadyPlay) {
                    playListCurrent++;
                    Log.d("ExoMedia",String.valueOf(playListCurrent));
                    emVideoView.setPositionOffset(0);
                    emVideoView.setVideoURI(Uri.parse(AppData.videoList.get(playListCurrent)));
                    emVideoView.start();

                }
                alreadyPlay = false;
            }
        });
    }
}
