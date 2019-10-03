package com.withever.blind.base.recyclerview;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolderJava<ITEM> extends RecyclerView.ViewHolder {

    protected Context context;
    private int viewType;
    private OnRecyclerViewItemListener onRecyclerViewItemListener;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public OnRecyclerViewItemListener getOnRecyclerViewItemListener() {
        return onRecyclerViewItemListener;
    }

    public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener onRecyclerViewItemListener) {
        this.onRecyclerViewItemListener = onRecyclerViewItemListener;
    }

    public BaseViewHolderJava(View view) {
        super(view);

        context = view.getContext();

        onInitView();
    }

    public abstract void onBindView(ITEM item);
    public abstract void onInitView();
}
