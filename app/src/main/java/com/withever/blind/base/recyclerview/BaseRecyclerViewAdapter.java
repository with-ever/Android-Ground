package com.withever.blind.base.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.withever.blind.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int TYPE_LOADING_FOOTER = 9999;
    private static final String ITEM_LOAD_MORE = "LoadMore";

    private List<Item<?>> itemList = new ArrayList<>();
    private boolean dataRemains = true;
    private boolean baseLoading = false;

    private OnRecyclerViewItemListener onRecyclerViewItemListener;

    public abstract BaseViewHolder onAbstractCreateViewHolder(ViewGroup parent, int viewType);

    @NotNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        if (baseLoading && dataRemains && viewType == TYPE_LOADING_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_footer_loading, parent, false);
            return new BaseViewHolder<Void>(view) {
                @Override
                public void onBindView(Void aVoid) {}
                @Override
                public void onInitView() {}
            };
        }
        return onAbstractCreateViewHolder(parent, viewType);
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (getItemViewType(position) != TYPE_LOADING_FOOTER) {
            if (getItem(position) != null) {
                holder.onBindView(getItem(position));
            }
        }
    }


    /**----------------------------------------------------
     * Data Management
     *----------------------------------------------------*/
    public void loadMoreStart() {
        addItem(new Item(TYPE_LOADING_FOOTER, ITEM_LOAD_MORE));
        notifyItemInserted(getItemCount() - 1);
    }

    public void loadMoreEnd() {
        remove(getItemCount() - 1);
        notifyItemRemoved(getItemCount());
    }

    public void loadMoreEnd(Item<?> result) {
        if (getItemCount() > 0) {
            if (getItemViewType(getItemCount() - 1) == TYPE_LOADING_FOOTER) {
                remove(getItemCount() - 1);
                notifyItemRemoved(getItemCount());
            }
        }

        addItem(result);
        notifyItemInserted(getItemCount());
    }


    public void loadMoreEnd(List<Item<?>> result) {
        if (getItemCount() > 0) {
            if (getItemViewType(getItemCount() - 1) == TYPE_LOADING_FOOTER) {
                remove(getItemCount() - 1);
                notifyItemRemoved(getItemCount());
            }
        }

        for (Item item : result) {
            addItem(item);
            notifyItemInserted(getItemCount());
        }
    }

    public void setBaseLoading(boolean mBaseLoading) {
        this.baseLoading = mBaseLoading;
    }

    public void setDataRemains(boolean mDataRemains) {
        this.dataRemains = mDataRemains;
    }

    @SuppressWarnings("unchecked")
    public <ITEM> ITEM getItem(int position) {
        return (ITEM) itemList.get(position).getItem();
    }

    public void addItem(Item<?> item) {
        this.itemList.add(item);
    }

    public void addItem(int position, Item<?> item) {
        this.itemList.add(position, item);
    }

    public void addItems(List<Item<?>> items) {
        this.itemList.addAll(items);
    }

    public void setItem(int position, Item<?> item) {
        this.itemList.set(position, item);
    }

    public void setItems(List<Item<?>> items) {
        this.itemList.clear();
        this.itemList.addAll(items);
    }

    public void remove(int position) {
        if (getItemCount() - 1 < position) {
            return;
        }
        this.itemList.remove(position);
    }

    public void remove(Item<?> row) {
        this.itemList.remove(row);
    }

    public void clear() {
        this.itemList.clear();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public int getRealItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 0) {
            return TYPE_LOADING_FOOTER;
        }
        return itemList.get(position).getViewType();
    }


    /**----------------------------------------------------
     * Listener
     *----------------------------------------------------*/
    public void setListener(OnRecyclerViewItemListener onRecyclerViewItemListener) {
        this.onRecyclerViewItemListener = onRecyclerViewItemListener;
    }

    public OnRecyclerViewItemListener getListener() {
        return onRecyclerViewItemListener;
    }

}
