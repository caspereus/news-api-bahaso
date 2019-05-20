package bahaso.example.bahasanews.presenters;

import bahaso.example.bahasanews.base.BasePresenter;
import bahaso.example.bahasanews.responses.ArticlesResponse;
import bahaso.example.bahasanews.views.View_article;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter_article<view extends View_article> extends BasePresenter {

    view view_article;

    public Presenter_article(view view_article) {
        this.view_article = view_article;
    }

    public void get_headlines(String country,int page,String q)
    {
        view_article.onShow();
        endpoint.get_headlines(
                country,apikey,page,q
        ).enqueue(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(Call<ArticlesResponse> call, Response<ArticlesResponse> response) {
                view_article.getHttp(Integer.toString(response.code()));
                view_article.onSuccess(response.body());
                view_article.onHide();
            }

            @Override
            public void onFailure(Call<ArticlesResponse> call, Throwable t) {
                view_article.onHide();
                view_article.onError(t.getMessage());
            }
        });
    }

    public void get_everythings(String q,String from)
    {
        view_article.onShow();
        endpoint.get_everythings(
                q,from,apikey
        ).enqueue(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(Call<ArticlesResponse> call, Response<ArticlesResponse> response) {
                view_article.getHttp(Integer.toString(response.code()));
                view_article.onSuccess(response.body());
                view_article.onHide();
            }

            @Override
            public void onFailure(Call<ArticlesResponse> call, Throwable t) {
                view_article.onHide();
                view_article.onError(t.getMessage());
            }
        });
    }
}
