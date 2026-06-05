package com.urbandroid.sleep;

import android.os.Parcel;
import com.facebook.AuthenticationTokenClaims;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordChangeListener;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class SleepRecordTemporaryPersister implements SleepRecordChangeListener {
    private Long lastPersistTimestamp = null;

    public static void deleteLastTemporaryRecord() {
        try {
            SharedApplicationContext.getInstance().getContext().deleteFile("tmp-record-data");
        } catch (Exception e) {
            Logger.logWarning("Failed to delete temp record file.", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SleepRecord getLastTemporaryRecord() {
        Throwable th;
        FileInputStream fileInputStreamOpenFileInput;
        FileInputStream fileInputStream = null;
        try {
            try {
                fileInputStreamOpenFileInput = SharedApplicationContext.getInstance().getContext().openFileInput("tmp-record-data");
                try {
                    byte[] bArr = new byte[200000];
                    int i = fileInputStreamOpenFileInput.read(bArr);
                    if (i == 200000) {
                        Logger.logWarning("Max buffer length, cannot deserialize");
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (Exception unused) {
                        }
                        return null;
                    }
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.unmarshall(bArr, 0, i);
                    parcelObtain.setDataPosition(0);
                    SleepRecord sleepRecordCreateFromParcel = SleepRecord.CREATOR.createFromParcel(parcelObtain);
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (Exception unused2) {
                    }
                    return sleepRecordCreateFromParcel;
                } catch (FileNotFoundException unused3) {
                    if (fileInputStreamOpenFileInput == null) {
                        return null;
                    }
                    try {
                        fileInputStreamOpenFileInput.close();
                        return null;
                    } catch (Exception unused4) {
                        return null;
                    }
                } catch (Exception e) {
                    e = e;
                    Logger.logSevere(e);
                    if (fileInputStreamOpenFileInput == null) {
                        return null;
                    }
                    fileInputStreamOpenFileInput.close();
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused6) {
            fileInputStreamOpenFileInput = null;
        } catch (Exception e2) {
            e = e2;
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.domain.SleepRecordChangeListener
    public void onDataAdded(SleepRecord sleepRecord) {
        if (sleepRecord.getHistory().size() > 10) {
            Long l = this.lastPersistTimestamp;
            if (l == null || l.longValue() + AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED < System.currentTimeMillis()) {
                persist(sleepRecord);
                this.lastPersistTimestamp = Long.valueOf(System.currentTimeMillis());
            }
        }
    }

    public void persist(SleepRecord sleepRecord) {
        SharedApplicationContext.getInstance().getSleepRecordRepository().addNewSleepRecord(sleepRecord, null);
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = SharedApplicationContext.getInstance().getContext().openFileOutput("tmp-record-data", 0);
            Parcel parcelObtain = Parcel.obtain();
            sleepRecord.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            fileOutputStreamOpenFileOutput.write(parcelObtain.marshall());
            fileOutputStreamOpenFileOutput.flush();
            fileOutputStreamOpenFileOutput.close();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }
}
