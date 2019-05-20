package bahaso.example.bahasanews.activities;

import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bahaso.example.bahasanews.R;
import bahaso.example.bahasanews.adapters.ArticleAdapter;
import bahaso.example.bahasanews.base.BaseActivity;
import bahaso.example.bahasanews.helper.EndlessOnScrollListener;
import bahaso.example.bahasanews.models.Article;
import bahaso.example.bahasanews.presenters.Presenter_article;
import bahaso.example.bahasanews.responses.ArticlesResponse;
import bahaso.example.bahasanews.views.View_article;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View_article {

    Presenter_article presenter;
    ArticleAdapter adapter;
    @BindView(R.id.exception_page)
    LinearLayout exception_page;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipe_layout;
    @BindView(R.id.recycler_article)
    RecyclerView recycler_article;
    int page = 1;

    private void init()
    {
        adapter   = new ArticleAdapter(this);
        presenter = new Presenter_article(this);
        presenter.get_headlines("id",page,"");

        recycler_article.setLayoutManager(new LinearLayoutManager(this));
        recycler_article.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Top Headline");


        recycler_article.addOnScrollListener(new EndlessOnScrollListener() {
            @Override
            public void onLoadMore() {
                page++;
                presenter.get_headlines("id",page,"");
            }
        });

        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                presenter.get_headlines("id",page,"");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchViewAndroidActionBar.clearFocus();
                page = 1;
                presenter.get_headlines("id",page,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return true;
    }

    @Override
    public void onSuccess(ArticlesResponse response) {
        if (response.getTotalResults() > 0)
        {
            exception_page.setVisibility(View.GONE);
            if (page > 1)
            {
                adapter.load_more(response.getArticles());
            }else{
                adapter.replace(response.getArticles());
            }
        }else{
            List<Article> articles = new ArrayList<>();
            adapter.replace(articles);
            exception_page.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onShow() {
        swipe_layout.setRefreshing(true);
    }

    @Override
    public void onHide() {
        swipe_layout.setRefreshing(false);
    }

    @Override
    public void onError(String error) {
        super.showError(error);
    }

    @Override
    public void getHttp(String http) {
        super.showHttp(http);
    }
}
