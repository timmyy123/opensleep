package com.urbandroid.sleep.hr;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StringBufferPersister;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/hr/RawHrDataPersister;", "", "suffix", "", "<init>", "(Ljava/lang/String;)V", "hrPersister", "Lcom/urbandroid/util/StringBufferPersister;", "rrPersister", "spo2Persister", "addHR", "", "timestamp", "", "hr", "", "addRR", "rr", "addSPO2", "spo2", "stop", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RawHrDataPersister {
    private StringBufferPersister hrPersister;
    private StringBufferPersister rrPersister;
    private StringBufferPersister spo2Persister;

    public RawHrDataPersister(String str) {
        str.getClass();
        if (Experiments.getInstance().isRawBleHrDataPersistentExperiment()) {
            this.hrPersister = new StringBufferPersister(FileInsert$$ExternalSyntheticOutline0.m("hr_raw_", str), 1000, true);
            this.rrPersister = new StringBufferPersister(FileInsert$$ExternalSyntheticOutline0.m("rr_raw_", str), 1000, true);
            this.spo2Persister = new StringBufferPersister(FileInsert$$ExternalSyntheticOutline0.m("spo2_raw_", str), 1000, true);
        }
    }

    public final void addHR(long timestamp, float hr) {
        StringBufferPersister stringBufferPersister = this.hrPersister;
        if (stringBufferPersister != null) {
            stringBufferPersister.update(timestamp + "," + hr + "\n");
        }
    }

    public final void addRR(long timestamp, float rr) {
        StringBufferPersister stringBufferPersister = this.rrPersister;
        if (stringBufferPersister != null) {
            stringBufferPersister.update(timestamp + "," + rr + "\n");
        }
    }

    public final void addSPO2(long timestamp, float spo2) {
        StringBufferPersister stringBufferPersister = this.spo2Persister;
        if (stringBufferPersister != null) {
            stringBufferPersister.update(timestamp + "," + spo2 + "\n");
        }
    }

    public final void stop() {
        StringBufferPersister stringBufferPersister = this.hrPersister;
        if (stringBufferPersister != null) {
            stringBufferPersister.flush();
        }
        this.hrPersister = null;
        StringBufferPersister stringBufferPersister2 = this.rrPersister;
        if (stringBufferPersister2 != null) {
            stringBufferPersister2.flush();
        }
        this.rrPersister = null;
        StringBufferPersister stringBufferPersister3 = this.spo2Persister;
        if (stringBufferPersister3 != null) {
            stringBufferPersister3.flush();
        }
        this.spo2Persister = null;
    }
}
