package com.j7arsen.renderer.test.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.j7arsen.renderer.R;
import com.j7arsen.renderer.RecyclerViewRenderer;

/**
 * Created by arsen on 17.03.17.
 */

public class ItemViewRenderer extends RecyclerViewRenderer<ItemModel, ItemViewHolder>{

    private OnTestClickListener mOnTestClickListener;

    public ItemViewRenderer(Context context, int viewType, OnTestClickListener onTestClickListener) {
        super(context, viewType);
        this.mOnTestClickListener = onTestClickListener;
    }

    @Override
    public void bindView(ItemViewHolder holder, final ItemModel model, final int position) {
        holder.mItemTest.setText(model.getItemTest());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnTestClickListener != null){
                    mOnTestClickListener.onItemClick(position);
                }
            }
        });
        holder.mBtnItemTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnTestClickListener != null){
                    mOnTestClickListener.onBtnClick(model, position);
                }
            }
        });
    }

    @NonNull
    @Override
    public ItemViewHolder createViewHolder(ViewGroup parent) {
        return new ItemViewHolder(inflate(R.layout.row_item, parent));
    }

    public interface OnTestClickListener{
        void onItemClick(int position);
        void onBtnClick(ItemModel itemModel, int position);
    }

}
