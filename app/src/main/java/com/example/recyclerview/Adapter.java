package com.example.recyclerview;

import android.app.DownloadManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ProgrammingViewHolder> {

    Context context;
RequestManager glide;
    ArrayList<ModelFeed> modelFeedArrayList= new ArrayList<>();
    public Adapter(Context context,ArrayList<ModelFeed>modelFeedArrayList){

        this.context=context;
        this.modelFeedArrayList=modelFeedArrayList;
        glide= Glide.with(context);

    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.instagram_feed, parent, false);
        ProgrammingViewHolder viewHolder=new ProgrammingViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {

        final ModelFeed modelFeed=modelFeedArrayList.get(position);
        holder.uploder_name.setText(modelFeed.getName());
        holder.time.setText(modelFeed.getTime());
        holder.liker_nam.setText(String.valueOf(modelFeed.getLike()));
        holder.add_com.setText(modelFeed.getComment()+ "comments");

        glide.load(modelFeed.getProfile()).into(holder.profile);
        if (modelFeed.getPost()==0){
            holder.post_pic.setVisibility(View.GONE);
        }else{
            holder.post_pic.setVisibility(View.VISIBLE);
            glide.load(modelFeed.getPost()).into(holder.post_pic);
        }

    }

    @Override
    public int getItemCount() {
        return modelFeedArrayList.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{

        TextView uploder_name, time,liker_nam,like_by,add_com;
        ImageView profile,post_pic,liker_prof;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            profile=(ImageView) itemView.findViewById(R.id.pro_pic);
            post_pic=(ImageView) itemView.findViewById(R.id.post_pic);
            liker_prof=(ImageView) itemView.findViewById(R.id.liker_pic);


            uploder_name=(TextView) itemView.findViewById(R.id.uploader_name);
            time=(TextView) itemView.findViewById(R.id.timee);
            liker_nam=(TextView) itemView.findViewById(R.id.lik);
            like_by=(TextView) itemView.findViewById(R.id.likeby);
            add_com=(TextView) itemView.findViewById(R.id.addcom);

        }
    }
}
