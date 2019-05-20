package bahaso.example.bahasanews.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bahaso.example.bahasanews.R;
import bahaso.example.bahasanews.base.BaseActivity;
import bahaso.example.bahasanews.helper.ConvertTime;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.title_list)
    TextView title;
    @BindView(R.id.content_list)
    TextView content;
    @BindView(R.id.date_list)
    TextView date;
    @BindView(R.id.image_list)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setUpActionBar("");

        Bundle bundle = getIntent().getExtras();
        ConvertTime convertTime = new ConvertTime();

        title.setText(bundle.getString("title"));
        content.setText(bundle.getString("content"));
        Picasso.get().load(bundle.getString("image")).into(image);
        date.setText(convertTime.convert(bundle.getString("date")));
    }
}
