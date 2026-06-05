package com.google.android.datatransport.runtime.backends;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class AutoValue_CreationContext extends CreationContext {
    private final Context applicationContext;
    private final String backendName;
    private final Clock monotonicClock;
    private final Clock wallClock;

    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Null applicationContext");
            throw null;
        }
        this.applicationContext = context;
        if (clock == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Null wallClock");
            throw null;
        }
        this.wallClock = clock;
        if (clock2 == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Null monotonicClock");
            throw null;
        }
        this.monotonicClock = clock2;
        if (str != null) {
            this.backendName = str;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Null backendName");
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreationContext) {
            CreationContext creationContext = (CreationContext) obj;
            if (this.applicationContext.equals(creationContext.getApplicationContext()) && this.wallClock.equals(creationContext.getWallClock()) && this.monotonicClock.equals(creationContext.getMonotonicClock()) && this.backendName.equals(creationContext.getBackendName())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Context getApplicationContext() {
        return this.applicationContext;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public String getBackendName() {
        return this.backendName;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock getMonotonicClock() {
        return this.monotonicClock;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock getWallClock() {
        return this.wallClock;
    }

    public int hashCode() {
        return this.backendName.hashCode() ^ ((((((this.applicationContext.hashCode() ^ 1000003) * 1000003) ^ this.wallClock.hashCode()) * 1000003) ^ this.monotonicClock.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.applicationContext);
        sb.append(", wallClock=");
        sb.append(this.wallClock);
        sb.append(", monotonicClock=");
        sb.append(this.monotonicClock);
        sb.append(", backendName=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.backendName, "}");
    }
}
