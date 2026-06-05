package com.samsung.android.sdk.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult;

/* JADX INFO: loaded from: classes4.dex */
public interface HealthResultHolder<T extends BaseResult> {

    public interface ResultListener<T extends BaseResult> {
        void onResult(T t);
    }

    T await();

    void cancel();

    void setResultListener(ResultListener<T> resultListener);

    public static class BaseResult implements Parcelable {
        public static final Parcelable.Creator<BaseResult> CREATOR = new Parcelable.Creator<BaseResult>() { // from class: com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BaseResult createFromParcel(Parcel parcel) {
                return new BaseResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ BaseResult[] newArray(int i) {
                return new BaseResult[i];
            }
        };
        protected final boolean mCached;
        protected final int mCount;
        protected final int mStatus;

        public BaseResult(Parcel parcel) {
            this.mStatus = parcel.readInt();
            this.mCount = parcel.readInt();
            this.mCached = parcel.readInt() == 1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getCount() {
            return this.mCount;
        }

        public int getStatus() {
            return this.mStatus;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mStatus);
            parcel.writeInt(this.mCount);
            parcel.writeInt(this.mCached ? 1 : 0);
        }

        public BaseResult(int i, int i2) {
            this.mStatus = i;
            this.mCount = i2;
            this.mCached = true;
        }
    }
}
