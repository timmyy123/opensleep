package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class AudioFeaturesTracks implements Parcelable {
    public static final Parcelable.Creator<AudioFeaturesTracks> CREATOR = new Parcelable.Creator<AudioFeaturesTracks>() { // from class: kaaes.spotify.webapi.android.models.AudioFeaturesTracks.1
        @Override // android.os.Parcelable.Creator
        public AudioFeaturesTracks createFromParcel(Parcel parcel) {
            return new AudioFeaturesTracks(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AudioFeaturesTracks[] newArray(int i) {
            return new AudioFeaturesTracks[i];
        }
    };
    public List<AudioFeaturesTrack> audio_features;

    public AudioFeaturesTracks(Parcel parcel) {
        this.audio_features = parcel.createTypedArrayList(AudioFeaturesTrack.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.audio_features);
    }

    public AudioFeaturesTracks() {
    }
}
