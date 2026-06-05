package retrofit.android;

import android.util.Log;
import retrofit.RestAdapter;

/* JADX INFO: loaded from: classes5.dex */
public class AndroidLog implements RestAdapter.Log {
    private final String tag;

    public AndroidLog(String str) {
        this.tag = str;
    }

    public String getTag() {
        return this.tag;
    }

    @Override // retrofit.RestAdapter.Log
    public final void log(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 4000;
            logChunk(str.substring(i, Math.min(length, i2)));
            i = i2;
        }
    }

    public void logChunk(String str) {
        Log.d(getTag(), str);
    }
}
