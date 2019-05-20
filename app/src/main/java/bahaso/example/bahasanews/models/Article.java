package bahaso.example.bahasanews.models;

import com.google.gson.annotations.SerializedName;

public class Article {
    public class Source{

        String id,name;

        public Source(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    String author,title,description,url,urlToImage,publishedAt,content;
    @SerializedName("source")
    Source source;

    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content, Source source) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public Source getSource() {
        return source;
    }
}
