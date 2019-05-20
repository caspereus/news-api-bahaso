package bahaso.example.bahasanews.base;

import bahaso.example.bahasanews.connection.Endpoint;
import bahaso.example.bahasanews.connection.RetroServer;

public class BasePresenter {
    public static String apikey = "889fcaadf4534f56a7d0914c3496b26b";
    public Endpoint endpoint = new RetroServer().getClient().create(Endpoint.class);
}
