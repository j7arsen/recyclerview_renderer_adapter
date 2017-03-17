package com.j7arsen.renderer.test.header;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.j7arsen.renderer.R;

/**
 * Created by arsen on 17.03.17.
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder{

    public TextView mTvHeaderTest;

    public HeaderViewHolder(View itemView){
        super(itemView);
        mTvHeaderTest = (TextView) itemView.findViewById(R.id.tv_header_test);
    }

}
