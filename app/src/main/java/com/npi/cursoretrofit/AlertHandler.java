package com.npi.cursoretrofit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.npi.cursoretrofit.response.ArticleData;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class AlertHandler {

    private Context context;
    private Dialog alertDialog;

    public AlertHandler(Context context){
        this.context = context;
    }

    public void showArticleDetailAlert(ArticleData articleData, int position){
        alertDialog = new Dialog(context,R.style.Theme_Dialog_Translucent);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setCancelable(true);
        alertDialog.setContentView(R.layout.alert_article_detail);

        ImageView articleClose = alertDialog.findViewById(R.id.alert_clese);
        ImageView articleImage = alertDialog.findViewById(R.id.alert_article_image);
        TextView articleTitle = alertDialog.findViewById(R.id.alert_article_title);
        TextView articleDescription = alertDialog.findViewById(R.id.alert_article_description);
        FloatingActionButton articleFabShare = alertDialog.findViewById(R.id.alert_fab_share);

        articleClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        Picasso.get().load(articleData.getData().get(position).getAttributes().getPosterImage().getSmall()).into(articleImage);

        articleTitle.setText(MethodUtils.getTitle(articleData.getData().get(position).getAttributes().getTitles()));
        articleDescription.setText(articleData.getData().get(position).getAttributes().getSynopsis());

        articleFabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,articleTitle.getText().toString());
                context.startActivity(Intent.createChooser(shareIntent,"Compartir con..."));
            }
        });

        alertDialog.show();

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(Objects.requireNonNull(alertDialog.getWindow()).getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        alertDialog.getWindow().setAttributes(layoutParams);

    }
}
