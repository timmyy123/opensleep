package org.mp4parser.muxer;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.support.Matrix;

/* JADX INFO: loaded from: classes5.dex */
public class Movie {
    Matrix matrix = Matrix.ROTATE_0;
    List<Track> tracks = new LinkedList();

    public void addTrack(Track track) {
        if (getTrackByTrackId(track.getTrackMetaData().getTrackId()) != null) {
            track.getTrackMetaData().setTrackId(getNextTrackId());
        }
        this.tracks.add(track);
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public long getNextTrackId() {
        long trackId = 0;
        for (Track track : this.tracks) {
            if (trackId < track.getTrackMetaData().getTrackId()) {
                trackId = track.getTrackMetaData().getTrackId();
            }
        }
        return trackId + 1;
    }

    public Track getTrackByTrackId(long j) {
        for (Track track : this.tracks) {
            if (track.getTrackMetaData().getTrackId() == j) {
                return track;
            }
        }
        return null;
    }

    public List<Track> getTracks() {
        return this.tracks;
    }

    public String toString() {
        String string = "Movie{ ";
        for (Track track : this.tracks) {
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(string, "track_");
            sbM.append(track.getTrackMetaData().getTrackId());
            sbM.append(" (");
            sbM.append(track.getHandler());
            sbM.append(") ");
            string = sbM.toString();
        }
        return string.concat("}");
    }
}
