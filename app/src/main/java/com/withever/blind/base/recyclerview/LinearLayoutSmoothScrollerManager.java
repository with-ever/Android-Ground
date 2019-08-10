package com.withever.blind.base.recyclerview;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class LinearLayoutSmoothScrollerManager extends LinearLayoutManager {

    private static final float MILLISECONDS_PER_INCH = 50f;
    private Context context;

    public LinearLayoutSmoothScrollerManager(Context context) {
        super(context);
        this.context = context;
    }

    public LinearLayoutSmoothScrollerManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.context = context;
    }

    public LinearLayoutSmoothScrollerManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, final int position) {

        LinearSmoothScroller smoothScroller = new LinearSmoothScroller(context) {
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return LinearLayoutSmoothScrollerManager.this.computeScrollVectorForPosition(targetPosition);
            }

            @Override
            protected float calculateSpeedPerPixel
                    (DisplayMetrics displayMetrics) {
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
            }
        };

        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

//    @Override
//    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
//        final LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {
//            private static final float MILLISECONDS_PER_INCH = 100f;
//
//            @Override
//            public PointF computeScrollVectorForPosition(int targetPosition) {
//                return LinearLayoutSmoothScrollerManager.this.computeScrollVectorForPosition(targetPosition);
//            }
//
//            @Override
//            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
//                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
//            }
//        };
//        linearSmoothScroller.setTargetPosition(position);
//        startSmoothScroll(linearSmoothScroller);
//    }


//    @Override
//    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
//        final LinearSmoothScroller linearSmoothScroller =
//                new LinearSmoothScroller(recyclerView.getContext()) {
//                    private static final float MILLISECONDS_PER_INCH = 15f;
//
//                    @Override
//                    public PointF computeScrollVectorForPosition(int targetPosition) {
//                        return super.computeScrollVectorForPosition(targetPosition);
//                    }
//
//                    @Override
//                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
//                        return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
//                    }
//                };
//        linearSmoothScroller.setTargetPosition(position);
//        startSmoothScroll(linearSmoothScroller);
//    }

}
