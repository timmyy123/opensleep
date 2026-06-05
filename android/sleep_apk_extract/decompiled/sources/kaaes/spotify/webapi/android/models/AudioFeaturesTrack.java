package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class AudioFeaturesTrack implements Parcelable {
    public static final Parcelable.Creator<AudioFeaturesTrack> CREATOR = new Parcelable.Creator<AudioFeaturesTrack>() { // from class: kaaes.spotify.webapi.android.models.AudioFeaturesTrack.1
        @Override // android.os.Parcelable.Creator
        public AudioFeaturesTrack createFromParcel(Parcel parcel) {
            return new AudioFeaturesTrack(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AudioFeaturesTrack[] newArray(int i) {
            return new AudioFeaturesTrack[i];
        }
    };
    public float acousticness;
    public String analysis_url;
    public float danceability;
    public int duration_ms;
    public float energy;
    public String id;
    public float instrumentalness;
    public int key;
    public float liveness;
    public float loudness;
    public int mode;
    public float speechiness;
    public float tempo;
    public int time_signature;
    public String track_href;
    public String type;
    public String uri;
    public float valence;

    public AudioFeaturesTrack(Parcel parcel) {
        this.acousticness = parcel.readFloat();
        this.analysis_url = parcel.readString();
        this.danceability = parcel.readFloat();
        this.duration_ms = parcel.readInt();
        this.energy = parcel.readFloat();
        this.id = parcel.readString();
        this.instrumentalness = parcel.readFloat();
        this.key = parcel.readInt();
        this.liveness = parcel.readFloat();
        this.loudness = parcel.readFloat();
        this.mode = parcel.readInt();
        this.speechiness = parcel.readFloat();
        this.tempo = parcel.readFloat();
        this.time_signature = parcel.readInt();
        this.track_href = parcel.readString();
        this.type = parcel.readString();
        this.uri = parcel.readString();
        this.valence = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.acousticness);
        parcel.writeString(this.analysis_url);
        parcel.writeFloat(this.danceability);
        parcel.writeInt(this.duration_ms);
        parcel.writeFloat(this.energy);
        parcel.writeString(this.id);
        parcel.writeFloat(this.instrumentalness);
        parcel.writeInt(this.key);
        parcel.writeFloat(this.liveness);
        parcel.writeFloat(this.loudness);
        parcel.writeInt(this.mode);
        parcel.writeFloat(this.speechiness);
        parcel.writeFloat(this.tempo);
        parcel.writeInt(this.time_signature);
        parcel.writeString(this.track_href);
        parcel.writeString(this.type);
        parcel.writeString(this.uri);
        parcel.writeFloat(this.valence);
    }

    public AudioFeaturesTrack() {
    }
}
