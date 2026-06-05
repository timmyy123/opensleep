package com.urbandroid.sleep.media;

import android.net.Uri;
import com.urbandroid.common.util.RandUtil;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MultipleMediaUriUtil {
    public static Uri decodePosition(Uri uri, long j) {
        if (!isMultipleUri(uri)) {
            return uri;
        }
        String[] strArrDecodeUris = decodeUris(uri);
        if (strArrDecodeUris == null || strArrDecodeUris.length == 0) {
            return null;
        }
        return Uri.parse(strArrDecodeUris[(int) (j % ((long) strArrDecodeUris.length))]);
    }

    public static String[] decodeUris(Uri uri) {
        if (isMultipleUri(uri)) {
            return (String[]) uri.getQueryParameters("s").toArray(new String[0]);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Uri ", uri, " not having the multiple scheme");
        return null;
    }

    public static boolean hasSpotify(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (!isMultipleUri(uri)) {
            return ISpotifyPlayer.INSTANCE.isSpotifyUri(uri);
        }
        for (String str : decodeUris(uri)) {
            if (ISpotifyPlayer.INSTANCE.isSpotifyUri(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMultipleUri(String str) {
        if (str != null) {
            try {
                if ("multiple".equals(Uri.parse(str).getScheme())) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Uri parse(String[] strArr) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("multiple");
        builder.appendPath("multiple");
        for (String str : strArr) {
            builder.appendQueryParameter("s", str);
        }
        return builder.build();
    }

    public static Uri randomUriIfMultiple(Uri uri) {
        if (!isMultipleUri(uri)) {
            return uri;
        }
        String[] strArrDecodeUris = decodeUris(uri);
        if (strArrDecodeUris == null || strArrDecodeUris.length == 0) {
            return null;
        }
        return Uri.parse(strArrDecodeUris[RandUtil.range(0, strArrDecodeUris.length - 1)]);
    }

    public static Uri shuffle(Uri uri) {
        if (!isMultipleUri(uri)) {
            return uri;
        }
        List listAsList = Arrays.asList(decodeUris(uri));
        Collections.shuffle(listAsList);
        return parse((String[]) listAsList.toArray(new String[0]));
    }

    public static int size(Uri uri) {
        if (uri == null) {
            return 0;
        }
        if (isMultipleUri(uri)) {
            return uri.getQueryParameters("s").size();
        }
        return 1;
    }

    public static boolean isMultipleUri(Uri uri) {
        return uri != null && "multiple".equals(uri.getScheme());
    }

    public static int size(String str) {
        try {
            return size(Uri.parse(str));
        } catch (Exception unused) {
            return 0;
        }
    }
}
