package bahaso.example.bahasanews.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import bahaso.example.bahasanews.R;
import bahaso.example.bahasanews.activities.DetailActivity;
import bahaso.example.bahasanews.helper.ConvertTime;
import bahaso.example.bahasanews.models.Article;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.Holder> {

    Context context;
    List<Article> articles = new ArrayList<>();

    public ArticleAdapter(Context context) {
        this.context = context;
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_list)
        TextView title;
        @BindView(R.id.content_list)
        TextView content;
        @BindView(R.id.date_list)
        TextView date;
        @BindView(R.id.image_list)
        ImageView image;
        @BindView(R.id.card_click)
        CardView card_click;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.list_contents,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ConvertTime convertTime = new ConvertTime();
        final Article article = articles.get(position);
        holder.title.setText(article.getTitle());
        holder.content.setText(article.getDescription());
        Picasso.get().load(article.getUrlToImage()).into(holder.image);
        holder.date.setText(convertTime.convert(article.getPublishedAt()));
        holder.card_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailActivity.class)
                        .putExtra("title",article.getTitle())
                        .putExtra("content",article.getContent())
                        .putExtra("image",article.getUrlToImage())
                        .putExtra("date",article.getPublishedAt())
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void replace(List<Article> articles)
    {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public void load_more(List<Article> articles)
    {
        for (int i = 0;i< articles.size();i++)
        {
            this.articles.add(articles.get(i));
        }

        notifyDataSetChanged();
    }
}
