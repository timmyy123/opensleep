package com.facebook.ads.redexgen.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RC implements Parcelable.ClassLoaderCreator<RecyclerView$SavedState> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final RecyclerView$SavedState createFromParcel(Parcel parcel) {
        return new RecyclerView$SavedState(parcel, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final RecyclerView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView$SavedState(parcel, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final RecyclerView$SavedState[] newArray(int i) {
        return new RecyclerView$SavedState[i];
    }
}
