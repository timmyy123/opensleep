package com.urbandroid.sleep.persistence;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.appevents.AppEventsConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class ExportContentProvider extends ContentProvider {
    private static AtomicBoolean RUNNING = new AtomicBoolean(false);
    private UriMatcher uriMatcher;

    /* JADX INFO: loaded from: classes4.dex */
    public static class TransferThread extends Thread {
        private Context context;
        private OutputStream out;

        public TransferThread(Context context, OutputStream outputStream) {
            this.out = outputStream;
            this.context = context;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedWriter] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            BufferedWriter bufferedWriter;
            List<SleepRecord> sleepRecords;
            ?? r1 = 0;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.out));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(0, -1, false);
                StringBuilder sb = new StringBuilder("ExportContentProvider: Exporting ");
                sb.append(sleepRecords == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : Integer.valueOf(sleepRecords.size()));
                Logger.logInfo(sb.toString());
            } catch (Exception e2) {
                e = e2;
                bufferedWriter2 = bufferedWriter;
                Logger.logSevere(e);
                try {
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    r1 = bufferedWriter2;
                } catch (IOException e3) {
                    e = e3;
                    Logger.logSevere(e);
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = bufferedWriter;
                try {
                    r1.flush();
                    r1.close();
                } catch (IOException e4) {
                    Logger.logSevere(e4);
                }
                ExportContentProvider.releaseLock();
                throw th;
            }
            if (sleepRecords != null && sleepRecords.size() >= 1) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd. MM. yyyy H:mm");
                Iterator<SleepRecord> it = sleepRecords.iterator();
                while (it.hasNext()) {
                    bufferedWriter.write(SleepRecordCsvMapper.sleepRecordToCsv(it.next(), simpleDateFormat2, simpleDateFormat));
                }
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    r1 = simpleDateFormat2;
                } catch (IOException e5) {
                    e = e5;
                    Logger.logSevere(e);
                }
                ExportContentProvider.releaseLock();
                return;
            }
            try {
                bufferedWriter.close();
            } catch (IOException unused) {
            }
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e6) {
                Logger.logSevere(e6);
            }
            ExportContentProvider.releaseLock();
        }
    }

    private static synchronized boolean acquireLock() {
        if (RUNNING.get()) {
            return false;
        }
        RUNNING.set(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void releaseLock() {
        RUNNING.set(false);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.uriMatcher = uriMatcher;
        uriMatcher.addURI("com.urbandroid.sleep.export", "*", 1);
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Logger.logInfo("ExportContentProvider: open file " + uri);
        GlobalInitializator.initializeIfRequired(getContext());
        TransferThread transferThread = null;
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            if (acquireLock()) {
                TransferThread transferThread2 = new TransferThread(getContext(), new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]));
                try {
                    transferThread2.start();
                } catch (IOException e) {
                    e = e;
                    transferThread = transferThread2;
                    if (transferThread != null) {
                        try {
                            transferThread.interrupt();
                        } catch (Exception unused) {
                        }
                    }
                    Logger.logSevere("Exception opening pipe", e);
                    throw new FileNotFoundException("Could not open pipe for: " + uri.toString());
                }
            }
            return parcelFileDescriptorArrCreatePipe[0];
        } catch (IOException e2) {
            e = e2;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
