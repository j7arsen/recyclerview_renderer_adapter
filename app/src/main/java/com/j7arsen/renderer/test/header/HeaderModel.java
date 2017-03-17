package com.j7arsen.renderer.test.header;

import android.os.Parcel;
import android.os.Parcelable;

import com.j7arsen.renderer.RecyclerViewModel;

/**
 * Created by arsen on 17.03.17.
 */

public class HeaderModel implements RecyclerViewModel, Parcelable {

    public static final int HEADER_TYPE = 0;

    private String mHeaderTest;

    public HeaderModel(String mHeaderTest) {
        this.mHeaderTest = mHeaderTest;
    }

    @Override
    public int getViewType() {
        return HEADER_TYPE;
    }

    public String getHeaderTest() {
        return mHeaderTest;
    }

    public void setHeaderTest(String mHeaderTest) {
        this.mHeaderTest = mHeaderTest;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mHeaderTest);
    }

    protected HeaderModel(Parcel in) {
        this.mHeaderTest = in.readString();
    }

    public static final Creator<HeaderModel> CREATOR = new Creator<HeaderModel>() {
        @Override
        public HeaderModel createFromParcel(Parcel source) {
            return new HeaderModel(source);
        }

        @Override
        public HeaderModel[] newArray(int size) {
            return new HeaderModel[size];
        }
    };

}
