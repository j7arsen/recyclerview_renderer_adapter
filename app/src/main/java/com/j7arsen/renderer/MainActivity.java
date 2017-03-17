package com.j7arsen.renderer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.j7arsen.renderer.test.header.HeaderModel;
import com.j7arsen.renderer.test.header.HeaderViewRenderer;
import com.j7arsen.renderer.test.item.ItemModel;
import com.j7arsen.renderer.test.item.ItemViewRenderer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemViewRenderer.OnTestClickListener{

    private RecyclerView mRvTest;
    private RecyclerViewRendererAdapter mRecyclerViewRendererAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvTest = (RecyclerView) findViewById(R.id.rv_test);

        mRecyclerViewRendererAdapter = new RecyclerViewRendererAdapter();
        mRecyclerViewRendererAdapter.registerRenderer(new HeaderViewRenderer(this, HeaderModel.HEADER_TYPE));
        mRecyclerViewRendererAdapter.registerRenderer(new ItemViewRenderer(this, ItemModel.ITEM_TYPE, this));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvTest.setLayoutManager(linearLayoutManager);
        mRvTest.setAdapter(mRecyclerViewRendererAdapter);

        mRecyclerViewRendererAdapter.setItems(getTestItems());
        mRecyclerViewRendererAdapter.notifyDataSetChanged();

    }

    private ArrayList<RecyclerViewModel> getTestItems() {
        final ArrayList<RecyclerViewModel> items = new ArrayList<>();
        items.add(new HeaderModel("header"));
        for (int j = 0; j < 12; j++) {
            items.add(new ItemModel("content " + (j + 1)));
        }

        return items;
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "OnItemClick" + position, Toast.LENGTH_SHORT).show();
        Log.i("OnItemClick", "OnItemClick = " + position);
    }

    @Override
    public void onBtnClick(ItemModel itemModel, int position) {
        Toast.makeText(this, "OnBtnClick" + position, Toast.LENGTH_SHORT).show();
        Log.i("OnBtnClick", "OnBtnClick = " + position);
    }
}
