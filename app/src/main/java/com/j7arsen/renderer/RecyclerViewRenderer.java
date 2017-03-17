package com.j7arsen.renderer;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by arsen on 17.03.17.
 */

public abstract class RecyclerViewRenderer<T extends RecyclerViewModel, V extends RecyclerView.ViewHolder> {

    private final Context mContext;
    private final int mViewType;


    public RecyclerViewRenderer(final Context context, final int viewType) {
        this.mContext = context;
        this.mViewType = viewType;
    }

    public abstract void bindView(V holder, T model, int position);

    @NonNull
    public abstract V createViewHolder(ViewGroup parent);


    public int getType() {
        return mViewType;
    }

    protected Context getContext() {
        return mContext;
    }

    @NonNull
    protected View inflate(@LayoutRes final int layout, @Nullable final ViewGroup parent, final boolean attachToRoot) {
        return LayoutInflater.from(getContext()).inflate(layout, parent, attachToRoot);
    }

    @NonNull
    protected View inflate(@LayoutRes final int layout, final @Nullable ViewGroup parent) {
        return inflate(layout, parent, false);
    }

}
