package io.veradiego31.elfm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by Produccion on 07/08/2015.
 */
public class ItemOffSetDecoration extends RecyclerView.ItemDecoration {
    //la medida en pixeles del espaciado
    private int mItemOffset;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }

    public ItemOffSetDecoration(Context context, @IntegerRes int integerResId){
        int itemOffsetDp = context.getResources().getInteger(integerResId);
        mItemOffset = convertToPx(itemOffsetDp, context.getResources().getDisplayMetrics());



    }

    public int convertToPx(int offsetDp, DisplayMetrics metrics){
        return offsetDp * (metrics.densityDpi / 160);

    }

}
