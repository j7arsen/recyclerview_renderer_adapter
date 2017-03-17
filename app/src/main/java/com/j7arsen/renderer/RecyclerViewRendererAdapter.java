package com.j7arsen.renderer;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arsen on 17.03.17.
 */

public class RecyclerViewRendererAdapter extends RecyclerView.Adapter {

    private ArrayList<RecyclerViewModel> mItems = new ArrayList<>();
    private SparseArray<RecyclerViewRenderer> mRendererList = new SparseArray<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final RecyclerViewRenderer renderer = mRendererList.get(viewType);
        if (renderer != null) {
            return renderer.createViewHolder(parent);
        }

        throw new RuntimeException("Not supported Item View Type: " + viewType);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final RecyclerViewModel item = getItem(position);

        final RecyclerViewRenderer renderer = mRendererList.get(item.getViewType());
        if (renderer != null) {
            renderer.bindView(holder, item, position);
        } else {
            throw new RuntimeException("Not supported View Holder: " + holder);
        }
    }

    @Override
    public int getItemViewType(final int position) {
        final RecyclerViewModel item = getItem(position);
        return item.getViewType();
    }

    public <T extends RecyclerViewModel> T getItem(final int position) {
        return (T) mItems.get(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(final List<? extends RecyclerViewModel> items) {
        mItems.clear();
        mItems.addAll(items);
    }

    public void addItems(final List<? extends RecyclerViewModel> items) {
        mItems.addAll(items);
    }


    public void registerRenderer(final RecyclerViewRenderer renderer) {
        final int type = renderer.getType();
        if (mRendererList.get(type) == null) {
            mRendererList.put(type, renderer);
        } else {
            throw new RuntimeException("ViewRenderer already exist with this type: " + type);
        }
    }

}
