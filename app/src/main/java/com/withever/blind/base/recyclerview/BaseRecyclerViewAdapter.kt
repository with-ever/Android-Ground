package com.withever.blind.base.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.withever.blind.R

abstract class BaseRecyclerViewAdapter : RecyclerView.Adapter<BaseViewHolder<*>>(){

    private val itemList = ArrayList<Item<*>>()
    private var dataRemains:Boolean = true
    private var baseLoading:Boolean = false

    private var onRecyclerViewItemListener : OnRecyclerViewItemListener? = null

    abstract fun onAbstractCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*>{
        if(baseLoading && dataRemains && viewType == TYPE_LOADING_FOOTER) {
            var view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_recycler_footer_loading, parent, false)

            return object : BaseViewHolder<Void>(view) {
                override fun onBindView(avoid: Void?) {}
                override fun onInitView() {}
            }
        }
        return onAbstractCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int){
        if(getItemViewType(position) != TYPE_LOADING_FOOTER){
            if(getItem<Any>(position) != null){
                holder.onBindView(getItem(position))
            }
        }
    }


    /**----------------------------------------------------
     * Data Management
     *----------------------------------------------------*/
    fun loadMoreStart(){
        addItem(Item(TYPE_LOADING_FOOTER, ITEM_LOAD_MORE))
        notifyItemInserted(itemCount - 1)
    }

    fun loadMoreEnd(){
        remove(itemCount -1)
        notifyItemRemoved(itemCount)
    }

    fun loadMoreEnd(result: Item<*>){
        if(itemCount > 0){
            if(getItemViewType(itemCount - 1) == TYPE_LOADING_FOOTER){
                remove(itemCount - 1)
                notifyItemRemoved(itemCount)
            }

            addItem(result)
            notifyItemInserted(itemCount)
        }
    }

    fun loadMoreEnd(result: ArrayList<Item<*>>){
        if(itemCount > 0){
            if(getItemViewType(itemCount - 1) == TYPE_LOADING_FOOTER){
                remove(itemCount - 1)
                notifyItemRemoved(itemCount)
            }
        }

        for(item in result){
            addItem(item)
            notifyItemInserted(itemCount)
        }
    }

    fun setBaseLoading(mBaseLoading: Boolean) { this.baseLoading = mBaseLoading }

    fun setDataRemains(mDataRemains: Boolean) { this.dataRemains = mDataRemains }

    fun <ITEM> getItem(position: Int): ITEM? { return itemList[position].item as ITEM }

    fun addItem(item: Item<*>) { this.itemList.add(item) }
    fun addItem(position: Int, item: Item<*>) { this.itemList.add(position, item) }
    fun additem(items: ArrayList<Item<*>>) { this.itemList.addAll(items) }

    fun setItem(position: Int, item: Item<*>) { this.itemList[position] = item }
    fun setItem(items: ArrayList<Item<*>>){
        this.itemList.clear()
        this.itemList.addAll(items)
    }

    fun remove(position: Int){
        if(itemCount - 1 < position){
            return
        }
        this.itemList.removeAt(position)
    }

    fun remove(row: Item<*>) { this.itemList.remove(row) }

    fun clear() { this.itemList.clear() }

    override fun getItemCount(): Int { return itemList.size }

    fun getRealItemCount(): Int { return itemList.size }

    override fun getItemViewType(position: Int): Int{
        return if(position < 0){
            return TYPE_LOADING_FOOTER
        }
        else itemList[position].viewType
    }

    /**----------------------------------------------------
     * Listener
     *----------------------------------------------------*/
    fun setListener(onRecyclerViewItemListener: OnRecyclerViewItemListener?){
        this.onRecyclerViewItemListener = onRecyclerViewItemListener
    }

    fun getListener() : OnRecyclerViewItemListener? { return onRecyclerViewItemListener }

    companion object{
        private val TYPE_LOADING_FOOTER = 9999
        private val ITEM_LOAD_MORE = "LoadMore"
    }
}