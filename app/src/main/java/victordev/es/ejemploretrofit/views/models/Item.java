package victordev.es.ejemploretrofit.views.models;

/**
 * Created by victor on 18/9/16.
 */

public class Item {
    private int mID;
    private String mName;
    private String mEmail;
    private String mBody;

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }

    @Override
    public String toString() {
        return "Item{" +
                "mID=" + mID +
                ", mName='" + mName + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mBody='" + mBody + '\'' +
                '}';
    }
}
