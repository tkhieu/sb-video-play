package me.kimhieu.snowballvideoplayer.adapters;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devbrackets.android.exomedia.EMVideoView;

import java.util.List;

import me.kimhieu.snowballvideoplayer.R;

/**
 * Created by kimhieu on 1/18/16.
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {
    private List<String> mDataset;

    public VideoListAdapter(List<String> videoList) {
        this.mDataset = videoList;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        EMVideoView emVideoView;


        public ViewHolder(View v) {
            super(v);
            this.emVideoView = (EMVideoView)v.findViewById(R.id.video_play_activity_video_view);
            this.emVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
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
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public VideoListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_card_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.emVideoView.setVideoURI(Uri.parse(mDataset.get(position)));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}