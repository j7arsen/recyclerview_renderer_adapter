package com.j7arsen.renderer.test.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.j7arsen.renderer.R;

/**
 * Created by arsen on 17.03.17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView mItemTest;
    public Button mBtnItemTest;

    public ItemViewHolder(View itemView) {
        super(itemView);
        mItemTest = (TextView) itemView.findViewById(R.id.tv_item_test);
        mBtnItemTest = (Button) itemView.findViewById(R.id.btn_item_test);
    }
}
