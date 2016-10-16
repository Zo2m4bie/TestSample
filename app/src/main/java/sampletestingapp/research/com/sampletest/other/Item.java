package sampletestingapp.research.com.sampletest.other;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dima on 10/16/16.
 */
public class Item implements Parcelable {

    private int mId;

    private String mTitle;

    public Item(int id, String title) {
        mId = id;
        mTitle = title;
    }

    protected Item(Parcel in) {
        mId = in.readInt();
        mTitle = in.readString();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mTitle);
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
