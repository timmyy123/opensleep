package flepsik.github.com.progress_ring;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
class ProgressRingView$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ProgressRingView$SavedState> CREATOR = new Parcelable.Creator<ProgressRingView$SavedState>() { // from class: flepsik.github.com.progress_ring.ProgressRingView$SavedState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProgressRingView$SavedState createFromParcel(Parcel parcel) {
            return new ProgressRingView$SavedState(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProgressRingView$SavedState[] newArray(int i) {
            return new ProgressRingView$SavedState[i];
        }
    };
    float progress;

    private ProgressRingView$SavedState(Parcel parcel) {
        super(parcel);
        this.progress = parcel.readFloat();
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.progress);
    }

    public /* synthetic */ ProgressRingView$SavedState(Parcel parcel, ProgressRingView$1 progressRingView$1) {
        this(parcel);
    }
}
