package bahaso.example.bahasanews.base;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    public void setUpActionBar(String title)
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    public void setHideActionBar()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void showError(String error)
    {
        Log.e("HTTP ERROR : ",error);
    }

    public void showHttp(String http)
    {
        Log.d("HTTP STATUS : ",http);
    }

    public void showLoading()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Now loading..");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void dismissLoading()
    {
        progressDialog.dismiss();
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
