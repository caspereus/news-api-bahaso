package bahaso.example.bahasanews.connection;

import bahaso.example.bahasanews.responses.ArticlesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Endpoint {

    @GET("v2/everything/")
    Call<ArticlesResponse> get_everythings(@Query("q") String q,
                                          @Query("from") String from,
                                          @Query("apiKey") String apikey
    );

    @GET("v2/top-headlines/")
    Call<ArticlesResponse> get_headlines(@Query("country") String country,
                                         @Query("apiKey") String apikey,
                                         @Query("page") int page,
                                         @Query("q") String q
    );

}
