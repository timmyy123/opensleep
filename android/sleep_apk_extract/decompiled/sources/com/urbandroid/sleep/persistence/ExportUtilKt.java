package com.urbandroid.sleep.persistence;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.async.ImportDataAsyncTask;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.persistence.Export;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\u0003*\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a9\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001e\u001a\u00020\u001d*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010!\u001a\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00190 2\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010$\u001a\u00020\u0003*\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190 ¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Ljava/util/zip/ZipOutputStream;", "Ljava/io/File;", ShareInternalUtility.STAGING_PARAM, "", "add", "(Ljava/util/zip/ZipOutputStream;Ljava/io/File;)V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "exportAlarms", "(Landroid/content/Context;)Ljava/io/File;", "Landroid/app/Activity;", "pickAndImportZipFile", "(Landroid/app/Activity;)V", "", ShareConstants.MEDIA_URI, "Lcom/urbandroid/sleep/async/ProgressContext;", "progressContext", "Ljava/lang/Runnable;", "onPostExecute", "showImportDialog", "(Landroid/app/Activity;Ljava/lang/String;Lcom/urbandroid/sleep/async/ProgressContext;Ljava/lang/Runnable;)V", "Landroid/net/Uri;", "showImportDialogUri", "(Landroid/app/Activity;Landroid/net/Uri;Lcom/urbandroid/sleep/async/ProgressContext;Ljava/lang/Runnable;)V", "", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "getAlarms", "(Landroid/content/Context;)Ljava/util/List;", "alarm", "", "isSame", "(Lcom/urbandroid/sleep/alarmclock/Alarm;Lcom/urbandroid/sleep/alarmclock/Alarm;)Z", "", "hasSame", "(Ljava/util/List;Lcom/urbandroid/sleep/alarmclock/Alarm;)Z", "alarms", "importAlarms", "(Landroid/content/Context;Ljava/util/List;)V", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ExportUtilKt {
    public static final void add(ZipOutputStream zipOutputStream, File file) throws IOException {
        zipOutputStream.getClass();
        file.getClass();
        if (!file.exists()) {
            Logger.logWarning("zip can not add " + file.getAbsolutePath() + " - not found", null);
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[8092];
            int i = 0;
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    zipOutputStream.closeEntry();
                    Logger.logInfo("Zip - added " + file.getAbsolutePath() + " size: " + i, null);
                    return;
                }
                zipOutputStream.write(bArr, 0, i2);
                i += i2;
            }
        } finally {
        }
    }

    public static final synchronized File exportAlarms(Context context) {
        context.getClass();
        try {
            File exportFile = Export.getExportFile(context, true, "alarms.json");
            ArrayList arrayList = new ArrayList();
            try {
                Cursor alarmsCursor = Alarms.getAlarmsCursor(context);
                while (alarmsCursor.moveToNext()) {
                    arrayList.add(new Alarm(alarmsCursor));
                }
                if (arrayList.isEmpty()) {
                    Logger.logWarning("export - No Alarms found", null);
                    return null;
                }
                FileWriter fileWriter = new FileWriter(exportFile);
                try {
                    new GsonBuilder().registerTypeAdapter(Uri.class, new JsonSerializer<Uri>() { // from class: com.urbandroid.sleep.persistence.ExportUtilKt$exportAlarms$1$1
                        @Override // com.google.gson.JsonSerializer
                        public JsonElement serialize(Uri src, Type typeOfSrc, JsonSerializationContext context2) {
                            return new JsonPrimitive(String.valueOf(src));
                        }
                    }).create().toJson(arrayList, fileWriter);
                    Logger.logInfo("EXPORT: exporting " + arrayList.size() + " alarms", null);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileWriter, null);
                    return exportFile;
                } finally {
                }
            } catch (Exception e) {
                Logger.logWarning("Failed to fetch alarms for export", e);
                return null;
            }
        } catch (Exception e2) {
            Logger.logSevere(null, e2);
            return null;
        }
    }

    public static final synchronized List<Alarm> getAlarms(Context context) {
        ArrayList arrayList;
        context.getClass();
        try {
            Cursor alarmsCursor = Alarms.getAlarmsCursor(context);
            arrayList = new ArrayList();
            while (alarmsCursor.moveToNext()) {
                arrayList.add(new Alarm(alarmsCursor));
            }
        } catch (Exception e) {
            Logger.logWarning("Failed to fetch all alarms ", e);
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public static final boolean hasSame(List<Alarm> list, Alarm alarm) {
        list.getClass();
        alarm.getClass();
        List<Alarm> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (isSame((Alarm) it.next(), alarm)) {
                return true;
            }
        }
        return false;
    }

    public static final void importAlarms(Context context, List<Alarm> list) {
        context.getClass();
        list.getClass();
        final String str = "IMPORT";
        final boolean z = false;
        FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.persistence.ExportUtilKt$importAlarms$$inlined$featureLog$default$1
            @Override // com.urbandroid.common.FeatureLogger
            public String getTag() {
                String str2 = str;
                boolean z2 = z;
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str2);
                String strConcat = "";
                if (z2) {
                    String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                    if (strM == null) {
                        strConcat = null;
                    } else if (!StringsKt.isBlank(strM)) {
                        strConcat = ":".concat(strM);
                    }
                }
                sbM.append(strConcat);
                return sbM.toString();
            }
        };
        List<Alarm> alarms = getAlarms(context);
        for (Alarm alarm : list) {
            if (hasSame(alarms, alarm)) {
                String str2 = Logger.defaultTag;
                Logger.logInfo(str2, featureLogger.getTag() + ": " + ("IMPORT: Alarm " + alarm + " skipping  since found in db"), null);
            } else {
                long jAddAlarm = Alarms.addAlarm(context, alarm, true);
                int i = alarm.id;
                alarm.id = (int) jAddAlarm;
                alarms.add(alarm);
                String str3 = "Adding alarm from backup " + alarm + "\timportId was " + i;
                Logger.logInfo(Logger.defaultTag, featureLogger.getTag() + ": " + str3, null);
            }
        }
    }

    public static final boolean isSame(Alarm alarm, Alarm alarm2) {
        alarm.getClass();
        alarm2.getClass();
        if (alarm.hour != alarm2.hour || alarm.minutes != alarm2.minutes) {
            return false;
        }
        Alarm.DaysOfWeek daysOfWeek = alarm.getDaysOfWeek();
        Integer numValueOf = daysOfWeek != null ? Integer.valueOf(daysOfWeek.getCoded()) : null;
        Alarm.DaysOfWeek daysOfWeek2 = alarm2.getDaysOfWeek();
        return Intrinsics.areEqual(numValueOf, daysOfWeek2 != null ? Integer.valueOf(daysOfWeek2.getCoded()) : null) && Intrinsics.areEqual(alarm.label, alarm2.label);
    }

    public static final void pickAndImportZipFile(Activity activity) {
        activity.getClass();
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/zip", "text/comma-separated-values", "text/csv", "text/plain"});
        activity.startActivityForResult(intent, 777);
    }

    public static final void showImportDialog(Activity activity, String str, ProgressContext progressContext, Runnable runnable) {
        activity.getClass();
        showImportDialogUri(activity, str != null ? Uri.parse(str) : null, progressContext, runnable);
    }

    public static /* synthetic */ void showImportDialog$default(Activity activity, String str, ProgressContext progressContext, Runnable runnable, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            progressContext = null;
        }
        if ((i & 8) != 0) {
            runnable = null;
        }
        showImportDialog(activity, str, progressContext, runnable);
    }

    public static final void showImportDialogUri(Activity activity, Uri uri, ProgressContext progressContext, Runnable runnable) {
        File exportFile;
        Activity activity2;
        activity.getClass();
        Logger.logInfo("showImportDialogUri: " + uri, null);
        if (uri == null) {
            try {
                exportFile = Export.getExportFile(activity, true, "sleep-export.zip");
            } catch (IOException e) {
                Logger.logSevere(null, e);
                Toast.makeText(activity, R.string.general_unspecified_error, 1).show();
                return;
            }
        } else {
            exportFile = File.createTempFile("sleep-export.", ".zip", activity.getCacheDir());
            exportFile.deleteOnExit();
        }
        final File file = exportFile;
        int i = 0;
        if (uri != null) {
            try {
                file.getClass();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    InputStream inputStreamOpenInputStream = activity.getContentResolver().openInputStream(uri);
                    if (inputStreamOpenInputStream != null) {
                        ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                    }
                    CloseableKt.closeFinally(fileOutputStream, null);
                } finally {
                }
            } catch (Exception e2) {
                Logger.logSevere(null, e2);
                Toast.makeText(activity, R.string.general_unspecified_error, 1).show();
                return;
            }
        }
        final ArrayList arrayList = new ArrayList();
        try {
            file.getClass();
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    activity2 = activity;
                    Uri uri2 = uri;
                    ProgressContext progressContext2 = progressContext;
                    Runnable runnable2 = runnable;
                    try {
                        Export.Type typeFindOrNull = Export.Type.findOrNull(nextEntry.getName());
                        if (typeFindOrNull != null) {
                            arrayList.add(typeFindOrNull);
                        }
                        progressContext = progressContext2;
                        activity = activity2;
                        runnable = runnable2;
                        uri = uri2;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    activity2 = activity;
                }
                Throwable th3 = th;
                try {
                    throw th3;
                } catch (Throwable th4) {
                    try {
                        CloseableKt.closeFinally(zipInputStream, th3);
                        throw th4;
                    } catch (Exception e3) {
                        e = e3;
                        Logger.logSevere(null, e);
                        Toast.makeText(activity2, R.string.general_unspecified_error, 1).show();
                        return;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipInputStream, null);
            Logger.logInfo("found import types: " + arrayList, null);
            if (arrayList.isEmpty()) {
                Logger.logWarning("no import zip entry found in " + file.getAbsolutePath(), null);
                Toast.makeText(activity, R.string.general_unspecified_error, 1).show();
                return;
            }
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(activity);
            materialAlertDialogBuilder.setTitle(R.string.menu_import);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(((Export.Type) it.next()).isDefaultOn()));
            }
            final boolean[] booleanArray = CollectionsKt.toBooleanArray(arrayList2);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList3.add(activity.getString(((Export.Type) it2.next()).getNameResource()));
            }
            materialAlertDialogBuilder.setMultiChoiceItems((CharSequence[]) arrayList3.toArray(new String[0]), booleanArray, (DialogInterface.OnMultiChoiceClickListener) new ExportUtilKt$$ExternalSyntheticLambda0(booleanArray, i));
            final Activity activity3 = activity;
            final Uri uri3 = uri;
            final ProgressContext progressContext3 = progressContext;
            final Runnable runnable3 = runnable;
            materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.persistence.ExportUtilKt$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    ExportUtilKt.showImportDialogUri$lambda$3$3(arrayList, file, progressContext3, activity3, runnable3, uri3, booleanArray, dialogInterface, i2);
                }
            });
            materialAlertDialogBuilder.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
            AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
            if (activity3.isFinishing()) {
                return;
            }
            alertDialogCreate.show();
        } catch (Exception e4) {
            e = e4;
            activity2 = activity;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showImportDialogUri$lambda$3$2(boolean[] zArr, DialogInterface dialogInterface, int i, boolean z) {
        zArr[i] = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showImportDialogUri$lambda$3$3(List list, File file, ProgressContext progressContext, Activity activity, Runnable runnable, Uri uri, boolean[] zArr, DialogInterface dialogInterface, int i) {
        if (list.isEmpty()) {
            return;
        }
        List list2 = list;
        Logger.logDebug("Backup zip: " + file.length() + " bytes Importing records - types: " + CollectionsKt.toList(list2), null);
        ImportDataAsyncTask importDataAsyncTask = new ImportDataAsyncTask(progressContext, activity, runnable);
        List list3 = CollectionsKt.toList(list2);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list3) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (zArr[i2]) {
                arrayList.add(obj);
            }
            i2 = i3;
        }
        importDataAsyncTask.withTypes(arrayList);
        if (uri != null) {
            importDataAsyncTask.withUri(file.getAbsolutePath());
        }
        importDataAsyncTask.zipped();
        importDataAsyncTask.execute(new Void[0]);
    }
}
