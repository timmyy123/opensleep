package io.rebble.pebblekit2.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Bundle;
import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import io.rebble.pebblekit2.common.model.TransmissionResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$Companion;", "Landroid/os/Bundle;", "bundle", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "fromBundle", "(Lio/rebble/pebblekit2/common/model/TransmissionResult$Companion;Landroid/os/Bundle;)Lio/rebble/pebblekit2/common/model/TransmissionResult;", "common_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class TransmissionResultSerializationKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final TransmissionResult fromBundle(TransmissionResult.Companion companion, Bundle bundle) {
        companion.getClass();
        bundle.getClass();
        String string = bundle.getString("TYPE");
        if (string != null) {
            switch (string.hashCode()) {
                case -1710171764:
                    if (string.equals("FAILED_WATCH_NACKED")) {
                        return TransmissionResult.FailedWatchNacked.INSTANCE;
                    }
                    break;
                case -1149187101:
                    if (string.equals("SUCCESS")) {
                        return TransmissionResult.Success.INSTANCE;
                    }
                    break;
                case -65962549:
                    if (string.equals("FAILED_WATCH_NOT_CONNECTED")) {
                        return TransmissionResult.FailedWatchNotConnected.INSTANCE;
                    }
                    break;
                case 433141802:
                    if (string.equals("UNKNOWN")) {
                        return new TransmissionResult.Unknown(bundle.getString("MESSAGE"));
                    }
                    break;
                case 1237721712:
                    if (string.equals("FAILED_DIFFERENT_APP_OPEN")) {
                        return TransmissionResult.FailedDifferentAppOpen.INSTANCE;
                    }
                    break;
                case 1318656808:
                    if (string.equals("FAILED_NO_PERMISSIONS")) {
                        return TransmissionResult.FailedNoPermissions.INSTANCE;
                    }
                    break;
                case 1517976383:
                    if (string.equals("FAILED_TIMEOUT")) {
                        return TransmissionResult.FailedTimeout.INSTANCE;
                    }
                    break;
            }
        }
        Logger loggerWithTag = Logger.INSTANCE.withTag("PebbleKit");
        String tag = loggerWithTag.getTag();
        Severity severity = Severity.Error;
        if (loggerWithTag.getConfig().get_minSeverity().compareTo(severity) <= 0) {
            loggerWithTag.processLog(severity, tag, null, FileInsert$$ExternalSyntheticOutline0.m("Got unknown type ", string == null ? "null" : string, " while decoding TransmissionResult"));
        }
        return new TransmissionResult.Unknown(string);
    }
}
