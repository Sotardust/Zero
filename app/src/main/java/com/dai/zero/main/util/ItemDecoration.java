package com.dai.zero.main.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.dai.zero.R;

/**
 * Created by dai on 2018/4/3.
 */

public class ItemDecoration extends RecyclerView.ItemDecoration implements View.OnClickListener {

    private static final String TAG = "ItemDecoration";

    private View decorView;

    public ItemDecoration() {

    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public OnClickListener onClickListener;


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        decorView = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_decoration, parent, false);
        outRect.right = 5;
        outRect.bottom = 5;
        if (parent.getChildLayoutPosition(view) % 6 < 3) {
            outRect.top = 60;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getMinimumWidth();

        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            final int position = ((RecyclerView.LayoutParams) child.getLayoutParams()).getViewLayoutPosition();
            int bottom = child.getTop();
            int top = child.getTop() - (decorView.getHeight());
            Rect rect = new Rect(left, top, decorView.getRight(), bottom);
            if (position % 6 < 3) {
                if (position % 6 == 0) {
                    TextView title = ((TextView) decorView.findViewById(R.id.item_title));
                    title.setText("歌单" + (position / 6));
                    title.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            System.out.println("(position / 6) = " + (position / 6));
                        }
                    });

                }
                c.drawBitmap(convertViewToBitmap(decorView), null, rect, null);
//                c.setBitmap();
            }
        }

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: ");
    }

    public Bitmap convertViewToBitmap(View view) {
        view.destroyDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        return view.getDrawingCache(true);
    }

    public interface OnClickListener {
        void onClick();
    }

}
