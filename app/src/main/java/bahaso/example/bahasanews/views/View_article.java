package bahaso.example.bahasanews.views;

import java.util.List;

import bahaso.example.bahasanews.base.BaseView;
import bahaso.example.bahasanews.responses.ArticlesResponse;

public interface View_article extends BaseView {

    void onSuccess(ArticlesResponse response);

}
