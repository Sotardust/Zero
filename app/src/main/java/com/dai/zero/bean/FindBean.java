package com.dai.zero.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by dai on 2018/5/8.
 */

public class FindBean implements Parcelable {

    public ArrayList<String> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    public ArrayList<String> getTitleList() {
        return titleList;
    }

    public void setTitleList(ArrayList<String> titleList) {
        this.titleList = titleList;
    }

    public ArrayList<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<String> addressList) {
        this.addressList = addressList;
    }

    private ArrayList<String> imageList;
    private ArrayList<String> titleList;
    private ArrayList<String> addressList;

    public FindBean() {

    }

    private FindBean(Parcel in) {
        imageList = in.createStringArrayList();
        titleList = in.createStringArrayList();
        addressList = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(imageList);
        dest.writeStringList(titleList);
        dest.writeStringList(addressList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FindBean> CREATOR = new Creator<FindBean>() {
        @Override
        public FindBean createFromParcel(Parcel in) {
            return new FindBean(in);
        }

        @Override
        public FindBean[] newArray(int size) {
            return new FindBean[size];
        }
    };
}
