package com.npi.cursoretrofit.adapter;


import static com.npi.cursoretrofit.MethodUtils.getTitle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.npi.cursoretrofit.AlertHandler;
import com.npi.cursoretrofit.R;
import com.npi.cursoretrofit.response.ArticleData;
import com.npi.cursoretrofit.response.Titles;
import com.squareup.picasso.Picasso;

public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleRecyclerViewAdapter.ArticleViewHolder> {

    private Context context;
    private ArticleData articleData;
    private AlertHandler alertHandler;

    public ArticleRecyclerViewAdapter(Context context, ArticleData articleData){
        this.context = context;
        this.articleData = articleData;
        alertHandler = new AlertHandler(context);
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_articles,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.articleTitle.setText(getTitle(articleData.getData().get(position).getAttributes().getTitles()));

        Picasso.get().load(articleData.getData().get(position).getAttributes().getPosterImage().getSmall()).into(holder.articleImage);

        holder.articleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,holder.articleTitle.getText().toString(),Toast.LENGTH_SHORT).show();
                alertHandler.showArticleDetailAlert(articleData,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleData.getData().size();
    }

    /*private String getTitle(Titles titles){
        String title = "No title found";

        if (titles.getEnUs() != null){
            title = titles.getEnUs();
        } else if (titles.getEn() != null){
            title = titles.getEn();
        } else if (titles.getEnJp() != null){
            title = titles.getEnJp();
        }

        if (title.isEmpty()){
            title = "No title found";
        }
        return title;
    }*/

    public class ArticleViewHolder extends RecyclerView.ViewHolder{

        private ImageView articleImage;
        private TextView articleTitle;
        private CardView articleCardView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            articleImage = itemView.findViewById(R.id.item_article_image);
            articleTitle = itemView.findViewById(R.id.item_article_title);
            articleCardView = itemView.findViewById(R.id.item_card_view);
        }
    }
}
