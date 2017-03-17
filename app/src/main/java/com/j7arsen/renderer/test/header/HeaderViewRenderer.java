package com.j7arsen.renderer.test.header;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.j7arsen.renderer.R;
import com.j7arsen.renderer.RecyclerViewRenderer;

/**
 * Created by arsen on 17.03.17.
 */

public class HeaderViewRenderer extends RecyclerViewRenderer<HeaderModel, HeaderViewHolder> {

    public HeaderViewRenderer(Context context, int viewType) {
        super(context, viewType);
    }

    @Override
    public void bindView(HeaderViewHolder holder, HeaderModel model, int position) {
        holder.mTvHeaderTest.setText(model.getHeaderTest());
    }

    @NonNull
    @Override
    public HeaderViewHolder createViewHolder(ViewGroup parent) {
        return new HeaderViewHolder(inflate(R.layout.row_header, parent));
    }
}
