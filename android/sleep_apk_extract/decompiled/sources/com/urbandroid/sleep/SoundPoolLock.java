package com.urbandroid.sleep;

import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class SoundPoolLock {
    private Context context;
    private SoundPool pool;
    private boolean held = false;
    private int streamid = -1;
    private int soundid = -1;
    private Handler h = new Handler();

    public SoundPoolLock(Context context) {
        this.context = context;
    }

    private void acquire(boolean z) {
        if (!z) {
            init();
            this.pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.urbandroid.sleep.SoundPoolLock.1
                @Override // android.media.SoundPool.OnLoadCompleteListener
                public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                    if (SoundPoolLock.this.pool != null) {
                        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "SoundPoolLock held ", " streamid ");
                        sbM65m.append(SoundPoolLock.this.streamid);
                        sbM65m.append(" status ");
                        sbM65m.append(i2);
                        Logger.logInfo(sbM65m.toString());
                        SoundPoolLock soundPoolLock = SoundPoolLock.this;
                        soundPoolLock.streamid = soundPoolLock.pool.play(SoundPoolLock.this.soundid, 0.0f, 0.0f, 1, -1, 1.0f);
                        SoundPoolLock.this.held = true;
                    }
                }
            });
        }
        try {
            this.soundid = this.pool.load(this.context, R.raw.lock_loop, 1);
            Logger.logInfo("SoundPoolLock acquiring " + this.soundid + " streamid " + this.streamid);
        } catch (Exception e) {
            Logger.logSevere("SoundPoolLock acquiring failed", e);
            this.pool = null;
        }
    }

    private void init() {
        if (this.pool == null) {
            this.pool = new SoundPool(1, 3, 0);
        }
    }

    public boolean isHeld() {
        return this.held;
    }

    public void release() {
        if (this.pool != null) {
            StringBuilder sb = new StringBuilder("SoundPoolLock: Sound pool release, streamid ");
            sb.append(this.streamid);
            sb.append(" soundid ");
            zza$$ExternalSyntheticOutline0.m(sb, this.soundid);
            int i = this.streamid;
            if (i != -1) {
                this.pool.stop(i);
            }
            int i2 = this.soundid;
            if (i2 != -1) {
                this.pool.unload(i2);
            }
            this.streamid = -1;
            this.pool.setOnLoadCompleteListener(null);
            this.pool.release();
            this.held = false;
            this.pool = null;
        }
    }

    public void acquire() {
        acquire(false);
    }
}
