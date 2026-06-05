package com.google.android.material.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes4.dex */
class SearchBar$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SearchBar$SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SearchBar$SavedState>() { // from class: com.google.android.material.search.SearchBar$SavedState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public SearchBar$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new SearchBar$SavedState(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public SearchBar$SavedState[] newArray(int i) {
            return new SearchBar$SavedState[i];
        }

        @Override // android.os.Parcelable.Creator
        public SearchBar$SavedState createFromParcel(Parcel parcel) {
            return new SearchBar$SavedState(parcel);
        }
    };
    String text;

    public SearchBar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.text = parcel.readString();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.text);
    }

    public SearchBar$SavedState(Parcel parcel) {
        this(parcel, null);
    }
}
