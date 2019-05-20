package bahaso.example.bahasanews.base;

public interface BaseView {
    void onShow();
    void onHide();
    void onError(String error);
    void getHttp(String http);
}
