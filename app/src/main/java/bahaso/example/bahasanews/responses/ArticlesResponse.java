package bahaso.example.bahasanews.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import bahaso.example.bahasanews.models.Article;

public class ArticlesResponse {

    String status;
    int totalResults;

    @SerializedName("articles")
    List<Article> articles;

    public ArticlesResponse(String status, int totalResults, List<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
