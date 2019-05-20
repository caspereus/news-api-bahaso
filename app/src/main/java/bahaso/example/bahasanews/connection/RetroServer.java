package bahaso.example.bahasanews.connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer
{

    Retrofit retrofit;

    public Retrofit getClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}
