package com.example.lenovo.thescient;

public class Slide_Objects {
    int mImageId;
    String mTitle;
    String mCaption;

    public Slide_Objects(int ImageId, String Title, String Caption) {
        mImageId = ImageId;
        mCaption = Caption;
        mTitle = Title;
    }

    public int getmImageId() {
        return mImageId;
    }

    public String getmCaption() {
        return mCaption;
    }

    public String getmTitle() {
        return mTitle;
    }
}
