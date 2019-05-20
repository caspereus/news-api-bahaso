package bahaso.example.bahasanews.helper;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

public abstract class EndlessOnScrollListener extends RecyclerView.OnScrollListener {
    private int mPreviousTotal = 0;
    private boolean mLoading = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (dy >= 0){
            int visibleItemCount = recyclerView.getChildCount();
            int totalItemCount   = recyclerView.getLayoutManager().getItemCount();
            int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (mLoading) {
                if (totalItemCount > mPreviousTotal) {
                    mLoading = false;
                    mPreviousTotal = totalItemCount;
                }
            }

            if (!mLoading && totalItemCount == (visibleItemCount + firstVisibleItem)) {
                onLoadMore();
                mLoading = true;
                Log.d("NEXT","aya");
            }else{
                Log.d("next","eweh");
            }
        }
    }

    public abstract void onLoadMore();

}

