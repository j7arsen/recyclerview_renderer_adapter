package com.j7arsen.renderer.test.item;

import android.os.Parcel;
import android.os.Parcelable;

import com.j7arsen.renderer.RecyclerViewModel;

/**
 * Created by arsen on 17.03.17.
 */

public class ItemModel implements RecyclerViewModel, Parcelable {

    public static final int ITEM_TYPE = 1;

    private String mItemTest;

    public ItemModel(String mItemTest) {
        this.mItemTest = mItemTest;
    }

    public String getItemTest() {
        return mItemTest;
    }

    public void setItemTest(String mItemTest) {
        this.mItemTest = mItemTest;
    }

    @Override
    public int getViewType() {
        return ITEM_TYPE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mItemTest);
    }

    public ItemModel() {
    }

    protected ItemModel(Parcel in) {
        this.mItemTest = in.readString();
    }

    public static final Parcelable.Creator<ItemModel> CREATOR = new Parcelable.Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel source) {
            return new ItemModel(source);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };
}
