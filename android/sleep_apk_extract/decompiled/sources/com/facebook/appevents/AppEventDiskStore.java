package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "kotlin.jvm.PlatformType", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "", "eventsToPersist", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppEventDiskStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    public static final AppEventDiskStore INSTANCE = new AppEventDiskStore();
    private static final String TAG = AppEventDiskStore.class.getName();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        public ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
            ObjectStreamClass classDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual(classDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                classDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual(classDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                classDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            classDescriptor.getClass();
            return classDescriptor;
        }
    }

    private AppEventDiskStore() {
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0049: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:74), block:B:24:0x0049 */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b5 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #13 {, blocks: (B:4:0x0003, B:10:0x002c, B:61:0x00b5, B:15:0x003b, B:16:0x003e, B:38:0x0068, B:41:0x0073, B:45:0x007f, B:48:0x008a, B:50:0x008d, B:54:0x009f, B:53:0x0098, B:55:0x00a0, B:58:0x00ab, B:6:0x000b, B:9:0x0029, B:37:0x0061, B:44:0x0078, B:31:0x0053, B:32:0x0056), top: B:84:0x0003, inners: #1, #2, #3, #5, #8, #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized PersistedEvents readAndClearStore() {
        PersistedEvents persistedEvents;
        ClassNotFoundException e;
        IOException e2;
        String str;
        PersistedEvents persistedEvents2;
        Throwable th;
        AppEventUtility.assertIsNotMainThread();
        Context applicationContext = FacebookSdk.getApplicationContext();
        PersistedEvents persistedEvents3 = null;
        try {
            try {
                try {
                    FileInputStream fileInputStreamOpenFileInput = applicationContext.openFileInput(PERSISTED_EVENTS_FILENAME);
                    fileInputStreamOpenFileInput.getClass();
                    MovedClassObjectInputStream movedClassObjectInputStream = new MovedClassObjectInputStream(new BufferedInputStream(fileInputStreamOpenFileInput));
                    try {
                        Object object = movedClassObjectInputStream.readObject();
                        object.getClass();
                        persistedEvents = (PersistedEvents) object;
                        try {
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(movedClassObjectInputStream, null);
                            try {
                                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                            } catch (Exception e3) {
                                e = e3;
                                str = TAG;
                                Log.w(str, "Got unexpected exception when removing events file: ", e);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                CloseableKt.closeFinally(movedClassObjectInputStream, th);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } finally {
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception e4) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", e4);
                    }
                }
            } catch (FileNotFoundException unused) {
                persistedEvents3 = persistedEvents2;
                persistedEvents = persistedEvents3;
                if (persistedEvents == null) {
                }
                return persistedEvents;
            } catch (IOException e5) {
                e2 = e5;
                Log.w(TAG, "Got unexpected exception while reading events: ", e2);
                try {
                    applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                } catch (Exception e6) {
                    e = e6;
                    str = TAG;
                    Log.w(str, "Got unexpected exception when removing events file: ", e);
                }
                if (persistedEvents == null) {
                }
                return persistedEvents;
            } catch (ClassNotFoundException e7) {
                e = e7;
                Log.w(TAG, "Got unexpected exception while reading events: ", e);
                try {
                    applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                } catch (Exception e8) {
                    e = e8;
                    str = TAG;
                    Log.w(str, "Got unexpected exception when removing events file: ", e);
                }
                if (persistedEvents == null) {
                }
                return persistedEvents;
            }
        } catch (FileNotFoundException unused2) {
            persistedEvents = persistedEvents3;
            if (persistedEvents == null) {
            }
            return persistedEvents;
        } catch (IOException e9) {
            persistedEvents = null;
            e2 = e9;
            Log.w(TAG, "Got unexpected exception while reading events: ", e2);
            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            if (persistedEvents == null) {
            }
            return persistedEvents;
        } catch (ClassNotFoundException e10) {
            persistedEvents = null;
            e = e10;
            Log.w(TAG, "Got unexpected exception while reading events: ", e);
            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            if (persistedEvents == null) {
            }
            return persistedEvents;
        }
        if (persistedEvents == null) {
            persistedEvents = new PersistedEvents();
        }
        return persistedEvents;
    }

    public static final void saveEventsToDisk$facebook_core_release(PersistedEvents eventsToPersist) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream.writeObject(eventsToPersist);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(objectOutputStream, null);
            } finally {
            }
        } catch (IOException e) {
            Log.w(TAG, "Got unexpected exception while persisting events: ", e);
            try {
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            } catch (Exception unused) {
            }
        }
    }
}
