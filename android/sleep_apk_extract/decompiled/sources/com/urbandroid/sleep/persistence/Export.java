package com.urbandroid.sleep.persistence;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.preference.PreferenceManager;
import com.facebook.appevents.AppEventsConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.InputStreamUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.gui.NoiseFilter;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.prefs.backup.preference.XmlPreferencesBuilder;
import com.urbandroid.sleep.prefs.backup.preference.XmlPreferencesParser;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.DecimalFormatUtil;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StreamUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class Export {

    public interface ProgressListener {
        void recordProcessed(int i, SleepRecord sleepRecord);
    }

    public static File getExportFile(Context context, boolean z, String str, boolean z2) throws IOException {
        String str2;
        String str3 = context.getFilesDir().getAbsolutePath() + "/sleep-data/" + str;
        Logger.logInfo("getExportFile: app dir ".concat(str3));
        if (!Experiments.getInstance().isScopedStorageExperiment()) {
            File externalPublicWriteableStorage = Environment.getExternalPublicWriteableStorage();
            Logger.logInfo("getExportFile: external directory " + externalPublicWriteableStorage);
            if (!Environment.isWritable(externalPublicWriteableStorage) || z2) {
                Logger.logInfo("getExportFile: external NOT writable ");
                str2 = str3;
            } else {
                str2 = externalPublicWriteableStorage.getAbsolutePath() + "/sleep-data/" + str;
                Logger.logInfo("getExportFile: external IS writable ");
            }
            try {
                new FileWriter(externalPublicWriteableStorage);
                str3 = str2;
            } catch (Exception unused) {
                Logger.logInfo("getExportFile: cannot create FileWriter " + externalPublicWriteableStorage + " using fallback " + str3);
            }
        }
        Logger.logInfo("getExportFile: selected path ".concat(str3));
        File file = new File(str3);
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            if (!z2) {
                return getExportFile(context, z, str, true);
            }
            OggIO$$ExternalSyntheticBUOutline0.m("getExportFile: Path to file could not be created.");
            return null;
        }
        if (!z || file.exists() || file.createNewFile()) {
            return file;
        }
        if (!z2) {
            return getExportFile(context, true, str, true);
        }
        OggIO$$ExternalSyntheticBUOutline0.m("New file cannot be created.");
        return null;
    }

    public static String getExportFilePath(Context context) {
        try {
            return getExportFile(context, false, "sleep-export.csv").getAbsolutePath();
        } catch (Exception e) {
            Logger.logSevere(e);
            return "ERROR: " + e.getMessage();
        }
    }

    public static String getExportZipFilePath(Context context) {
        try {
            return getExportFile(context, false, "sleep-export.zip").getAbsolutePath();
        } catch (Exception e) {
            Logger.logSevere(e);
            return "ERROR: " + e.getMessage();
        }
    }

    public static synchronized boolean importPrefs(Context context) {
        try {
            File exportFile = getExportFile(context, true, "prefs.xml");
            if (!exportFile.exists()) {
                return false;
            }
            return importPrefsFromReader(context, new FileReader(exportFile));
        } catch (IOException e) {
            Logger.logSevere(e);
            return false;
        }
    }

    public static synchronized boolean importPrefsFromReader(Context context, Reader reader) {
        try {
            new XmlPreferencesParser().importPrefs(reader, PreferenceManager.getDefaultSharedPreferences(context));
        } catch (Exception e) {
            Logger.logSevere(e);
            return false;
        }
        return true;
    }

    private InputStream uriToInputStream(Context context, String str) {
        return str.startsWith("content") ? context.getContentResolver().openInputStream(Uri.parse(str)) : new FileInputStream(str);
    }

    public synchronized int countRecords(Context context, String str, boolean z) {
        ZipEntry nextEntry;
        String name;
        Type typeFindOrNull;
        File file;
        try {
            if (!z) {
                if (str == null) {
                    file = getExportFile(context, false, "sleep-export.csv");
                    if (!file.exists()) {
                        Logger.logInfo("Falling back to KitKat unsafe path.");
                        file = getExportFile(context, true, "sleep-export.csv");
                    }
                } else {
                    file = new File(str);
                }
                Logger.logInfo("Using import path: " + file.getAbsolutePath());
                return countRecords(context, file);
            }
            File exportFile = str == null ? getExportFile(context, false, "sleep-export.zip") : new File(str);
            Logger.logInfo("Count records: zipFile: " + exportFile.getAbsolutePath() + " uri: " + str);
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(exportFile));
            do {
                try {
                    nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        return 0;
                    }
                    name = nextEntry.getName();
                    Logger.logInfo("Count records: Zip entry: " + name);
                    typeFindOrNull = Type.findOrNull(name);
                } catch (Throwable th) {
                    try {
                        zipInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } while (typeFindOrNull != Type.Records);
            Logger.logInfo("Count records: Unzipping: " + name);
            try {
                int iCountRecords = typeFindOrNull.countRecords(context, new InputStreamReader(zipInputStream));
                zipInputStream.close();
                return iCountRecords;
            } catch (Exception e) {
                Logger.logSevere("import " + nextEntry.getName() + " failure", e);
                zipInputStream.close();
                return -1;
            }
        } catch (Exception e2) {
            Logger.logSevere(e2);
            return 0;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01bf A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000f, B:5:0x0022, B:6:0x0026, B:12:0x004b, B:16:0x005d, B:18:0x006b, B:20:0x0071, B:22:0x0088, B:23:0x009a, B:24:0x00c5, B:26:0x00cb, B:28:0x00d3, B:29:0x00da, B:30:0x00e2, B:33:0x0109, B:35:0x0145, B:37:0x0150, B:41:0x015b, B:43:0x0171, B:45:0x0176, B:48:0x01a1, B:50:0x01bf, B:88:0x0235, B:90:0x028f, B:92:0x02c0, B:96:0x02d6, B:94:0x02c6, B:97:0x02f0, B:98:0x0314, B:47:0x019e, B:15:0x0055, B:11:0x0046, B:51:0x01c6, B:87:0x0232, B:84:0x022e, B:83:0x022b), top: B:104:0x000f, inners: #1, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void exportData(Context context, ProgressListener progressListener, boolean z) {
        int iCountRecords;
        File exportFile;
        File exportFile2;
        String preferences;
        int length;
        int length2;
        Logger.logInfo("Doing export");
        List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(0, -1, false);
        try {
            iCountRecords = countRecords(context);
        } catch (IOException unused) {
            iCountRecords = 0;
        }
        try {
            Logger.logInfo("Export: records stored " + iCountRecords + " to store " + sleepRecords.size());
        } catch (IOException unused2) {
            Logger.logInfo("Export: Cannot count records");
        }
        StringBuilder sb = new StringBuilder("Exporting ");
        sb.append(sleepRecords == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : Integer.valueOf(sleepRecords.size()));
        Logger.logInfo(sb.toString());
        File exportFile3 = null;
        if (sleepRecords == null || sleepRecords.size() < 1) {
            exportFile = null;
            exportFile2 = null;
        } else {
            exportFile = getExportFile(context, true, "sleep-export.csv");
            exportFile2 = getExportFile(context, true, "sleep-export.backup.csv");
            if (iCountRecords - sleepRecords.size() > 20) {
                StreamUtil.copyStreamAndClose(exportFile, exportFile2);
                Logger.logInfo("Export: making backup file " + exportFile2);
            }
            Logger.logInfo("Exporting to " + exportFile);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd. MM. yyyy H:mm");
            FileWriter fileWriter = new FileWriter(exportFile);
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i = 0;
            for (SleepRecord sleepRecord : sleepRecords) {
                if (progressListener != null) {
                    progressListener.recordProcessed(i, sleepRecord);
                    i++;
                }
                fileWriter.write(SleepRecordCsvMapper.sleepRecordToCsv(sleepRecord, simpleDateFormat2, simpleDateFormat));
            }
            fileWriter.flush();
            fileWriter.close();
            Logger.logInfo("Export data: time " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
        try {
            exportFile3 = getExportFile(context, true, "prefs.xml");
            XmlPreferencesBuilder xmlPreferencesBuilder = new XmlPreferencesBuilder();
            xmlPreferencesBuilder.addAllPrefs(PreferenceManager.getDefaultSharedPreferences(context));
            preferences = xmlPreferencesBuilder.build().getPreferences();
            length = preferences.split("\n").length;
            Logger.logInfo("Export: PREFS new count " + length);
            if (exportFile3.exists()) {
                String str = InputStreamUtil.read(new FileInputStream(exportFile3));
                length2 = str != null ? str.split("\n").length : 0;
                Logger.logInfo("Export: PREFS old count " + length2);
            } else {
                length2 = 0;
            }
        } catch (IOException e) {
            Logger.logSevere(e);
        }
        if (length - length2 > -5) {
            Logger.logInfo("Export: PREFS writing " + length + " prefs.");
            FileWriter fileWriter2 = new FileWriter(exportFile3);
            fileWriter2.write(preferences);
            fileWriter2.flush();
            fileWriter2.close();
            File fileExportNoise = exportNoise(context);
            File fileExportAlarms = ExportUtilKt.exportAlarms(context);
            Logger.logInfo("export to zip: " + z);
            if (z) {
                File exportFile4 = getExportFile(context, false, "sleep-export.zip");
                try {
                    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(exportFile4));
                    if (exportFile != null) {
                        try {
                            ExportUtilKt.add(zipOutputStream, exportFile);
                            if (exportFile2.exists() && exportFile2.length() > 0) {
                                ExportUtilKt.add(zipOutputStream, exportFile2);
                            }
                        } finally {
                        }
                    }
                    if (exportFile3 != null && exportFile3.exists() && exportFile3.length() > 0) {
                        ExportUtilKt.add(zipOutputStream, exportFile3);
                    }
                    if (fileExportNoise != null && fileExportNoise.exists() && fileExportNoise.length() > 0) {
                        ExportUtilKt.add(zipOutputStream, fileExportNoise);
                    }
                    if (fileExportAlarms != null && fileExportAlarms.exists() && fileExportAlarms.length() > 0) {
                        ExportUtilKt.add(zipOutputStream, fileExportAlarms);
                    }
                    zipOutputStream.close();
                    Logger.logInfo("exported to " + exportFile4.getAbsolutePath() + " size: " + exportFile4.length());
                    Logger.logInfo("exporting a copy to " + SharedApplicationContext.getSettings().hasBackupDirUri() + " " + SharedApplicationContext.getSettings().getBackupDirUri());
                    if (SharedApplicationContext.getSettings().hasBackupDirUri()) {
                        Logger.logInfo("exporting has dir " + SharedApplicationContext.getSettings().getBackupDirUri());
                        DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(context, SharedApplicationContext.getSettings().getBackupDirUri());
                        DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile("sleep-export.zip");
                        if (documentFileFindFile == null || !documentFileFindFile.exists()) {
                            Logger.logInfo("export creating new document");
                            documentFileFindFile = documentFileFromTreeUri.createFile("application/zip", "sleep-export.zip");
                        }
                        if (documentFileFindFile != null) {
                            Logger.logInfo("export copying");
                            StreamUtil.copyStreamAndClose(new FileInputStream(exportFile4), context.getContentResolver().openOutputStream(documentFileFindFile.getUri()));
                        }
                    }
                } finally {
                    Logger.logInfo("exported to " + exportFile4.getAbsolutePath() + " size: " + exportFile4.length());
                }
            }
        } else {
            File fileExportNoise2 = exportNoise(context);
            File fileExportAlarms2 = ExportUtilKt.exportAlarms(context);
            Logger.logInfo("export to zip: " + z);
            if (z) {
            }
        }
    }

    public synchronized File exportNoise(Context context) {
        try {
            File exportFile = getExportFile(context, true, "noise.json");
            List<Noise> noises = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoises(2000, new NoiseFilter(null, true, -1L, -1L), true);
            if (noises != null && noises.size() > 0) {
                Gson gsonCreate = new GsonBuilder().setDateFormat("MMM d, yyyy HH:mm:ss").create();
                FileWriter fileWriter = new FileWriter(exportFile);
                try {
                    gsonCreate.toJson(noises, fileWriter);
                    Logger.logInfo("EXPORT: exporting " + noises.size() + " noises");
                    fileWriter.close();
                    return exportFile;
                } catch (Throwable th) {
                    fileWriter.close();
                    throw th;
                }
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        return null;
    }

    public synchronized void importNoise(Context context) {
        try {
            try {
                File exportFile = getExportFile(context, true, "noise.json");
                StringBuilder sb = new StringBuilder("IMPORT: Noise ");
                sb.append(exportFile);
                sb.append(" exists ");
                sb.append(exportFile != null ? Boolean.valueOf(exportFile.exists()) : "false");
                Logger.logInfo(sb.toString());
                Type.Noises.importData(context, new FileReader(exportFile), null);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void importRecordCsvData(Context context, String str, ProgressListener progressListener) {
        Reader inputStreamReader;
        try {
            try {
                if (str == null) {
                    File exportFile = getExportFile(context, false, "sleep-export.csv");
                    Logger.logInfo("Using import path: " + exportFile.getAbsolutePath());
                    inputStreamReader = new FileReader(exportFile);
                } else {
                    inputStreamReader = new InputStreamReader(uriToInputStream(context, str));
                }
                Type.Records.importData(context, inputStreamReader, progressListener);
            } catch (Exception e) {
                Logger.logSevere(e);
                throw new IOException(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean importZipData(Context context, String str, List<Type> list, ProgressListener progressListener) {
        boolean z;
        try {
            Logger.logInfo("Using import uri: " + str + " types: " + list);
            ZipInputStream zipInputStream = new ZipInputStream(str != null ? uriToInputStream(context, str) : new FileInputStream(getExportZipFilePath(context)));
            z = true;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        Logger.logInfo("Zip entry: " + name);
                        Type typeFindOrNull = Type.findOrNull(name);
                        if (typeFindOrNull != null && list.contains(typeFindOrNull)) {
                            Logger.logInfo("Unzipping: " + name);
                            try {
                                typeFindOrNull.importData(context, new InputStreamReader(zipInputStream), progressListener);
                            } catch (Exception e) {
                                Logger.logSevere("import " + nextEntry.getName() + " failure", e);
                                z = false;
                            }
                        }
                    } else {
                        zipInputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        zipInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            Logger.logSevere(e2);
            throw new IOException(e2);
        } finally {
        }
        return z;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static class Type {
        private final boolean defaultOn;
        private final String fileName;
        private final int nameResource;
        public static final Type Records = new AnonymousClass1();
        public static final Type Alarms = new AnonymousClass2();
        public static final Type Noises = new AnonymousClass3();
        public static final Type Preferences = new AnonymousClass4();
        private static final /* synthetic */ Type[] $VALUES = $values();

        /* JADX INFO: renamed from: com.urbandroid.sleep.persistence.Export$Type$1, reason: invalid class name */
        public enum AnonymousClass1 extends Type {
            public /* synthetic */ AnonymousClass1() {
                this("Records", 0, "sleep-export.csv", R.string.graphs, true);
            }

            @Override // com.urbandroid.sleep.persistence.Export.Type
            public int countRecords(Context context, Reader reader) throws IOException {
                long jCurrentTimeMillis = System.currentTimeMillis();
                BufferedReader bufferedReader = new BufferedReader(reader);
                int i = 0;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Record count in file: ", " took ");
                        sbM65m.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
                        sbM65m.append(" ms");
                        Logger.logInfo(sbM65m.toString());
                        return i;
                    }
                    if (line.startsWith("Id,Tz,From")) {
                        i++;
                    }
                }
            }

            @Override // com.urbandroid.sleep.persistence.Export.Type
            public synchronized boolean importData(Context context, Reader reader, ProgressListener progressListener) throws IOException {
                long j;
                SleepRecord sleepRecordFromCsv;
                BufferedReader bufferedReader = new BufferedReader(reader);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd. MM. yyyy h:mm aa");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd. MM. yyyy H:mm");
                DecimalFormat decimalFormat = DecimalFormatUtil.getLong();
                DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
                Set<Long> sleepRecordIds = sleepRecordRepository.getSleepRecordIds();
                long jCurrentTimeMillis = System.currentTimeMillis();
                String line = bufferedReader.readLine();
                int i = 0;
                boolean zContains = false;
                boolean zContains2 = false;
                boolean zContains3 = false;
                boolean zContains4 = false;
                int i2 = 0;
                boolean z = false;
                int i3 = 0;
                int i4 = 0;
                boolean z2 = true;
                SimpleDateFormat simpleDateFormat3 = simpleDateFormat;
                while (line != null) {
                    try {
                        if (line.startsWith("Id") || line.startsWith("\"Id")) {
                            j = jCurrentTimeMillis;
                            zContains = line.contains("Cycles");
                            zContains2 = line.contains("DeepSleep");
                            zContains3 = line.contains("LenAdjust");
                            zContains4 = line.contains("Geo");
                            line = bufferedReader.readLine();
                        } else {
                            j = jCurrentTimeMillis;
                            try {
                                try {
                                    sleepRecordFromCsv = SleepRecordCsvMapper.parseSleepRecordFromCsv(decimalFormat, simpleDateFormat3, simpleDateFormat2, zContains, zContains2, zContains3, zContains4, line);
                                    if (!zContains3) {
                                        try {
                                            sleepRecordFromCsv.computeLenAdjust();
                                        } catch (IllegalArgumentException e) {
                                            e = e;
                                            Logger.logSevere(e);
                                            if (z) {
                                                Logger.logSevere("Incompatible format");
                                                throw e;
                                            }
                                            simpleDateFormat3 = new SimpleDateFormat("dd. MM. yyyy H:mm");
                                            z = true;
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    Logger.logSevere(e);
                                    int i5 = i3;
                                    boolean z3 = z2;
                                    int i6 = i4;
                                    Logger.logInfo("Import data: time " + (System.currentTimeMillis() - j) + " ms");
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Created records ");
                                    sb.append(i5);
                                    Logger.logInfo(sb.toString());
                                    Logger.logInfo("Imported lines " + i);
                                    Logger.logInfo("Duplicate while importing " + i6);
                                    Logger.logInfo("Result success " + z3);
                                    return z3;
                                }
                            } catch (IllegalArgumentException e3) {
                                e = e3;
                                sleepRecordFromCsv = null;
                            }
                            String line2 = bufferedReader.readLine();
                            if (line2 != null && !line2.startsWith("Id") && !line2.startsWith("\"Id")) {
                                SleepRecordCsvMapper.parseNoiseLineFromCsv(sleepRecordFromCsv, line2);
                                line2 = bufferedReader.readLine();
                            }
                            String str = line2;
                            if (sleepRecordIds.contains(Long.valueOf(sleepRecordFromCsv.getFrom().getTime()))) {
                                i4++;
                                if (progressListener != null) {
                                    int i7 = i2 + 1;
                                    progressListener.recordProcessed(i2, sleepRecordFromCsv);
                                    i2 = i7;
                                }
                            } else {
                                try {
                                    sleepRecordRepository.addNewSleepRecord(sleepRecordFromCsv, null);
                                    i3++;
                                } catch (Exception e4) {
                                    Logger.logSevere(e4);
                                    z2 = false;
                                }
                                if (progressListener != null) {
                                    progressListener.recordProcessed(i2, sleepRecordFromCsv);
                                    i2++;
                                }
                                i++;
                            }
                            line = str;
                        }
                        jCurrentTimeMillis = j;
                    } catch (Exception e5) {
                        e = e5;
                        j = jCurrentTimeMillis;
                    }
                }
                j = jCurrentTimeMillis;
                int i52 = i3;
                boolean z32 = z2;
                int i62 = i4;
                Logger.logInfo("Import data: time " + (System.currentTimeMillis() - j) + " ms");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Created records ");
                sb2.append(i52);
                Logger.logInfo(sb2.toString());
                Logger.logInfo("Imported lines " + i);
                Logger.logInfo("Duplicate while importing " + i62);
                Logger.logInfo("Result success " + z32);
                return z32;
            }

            private AnonymousClass1(String str, int i, String str2, int i2, boolean z) {
                super(str, i, i2, 0, str2, z);
            }
        }

        /* JADX INFO: renamed from: com.urbandroid.sleep.persistence.Export$Type$2, reason: invalid class name */
        /* JADX INFO: loaded from: classes.dex */
        public enum AnonymousClass2 extends Type {
            public /* synthetic */ AnonymousClass2() {
                this("Alarms", 1, "alarms.json", R.string.alarm_list_title, false);
            }

            @Override // com.urbandroid.sleep.persistence.Export.Type
            public boolean importData(Context context, Reader reader, ProgressListener progressListener) {
                try {
                    Logger.logInfo("IMPORT: Alarms " + getFileName());
                    List list = (List) new GsonBuilder().registerTypeAdapter(Uri.class, new JsonDeserializer<Uri>() { // from class: com.urbandroid.sleep.persistence.Export.Type.2.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.google.gson.JsonDeserializer
                        public Uri deserialize(JsonElement jsonElement, java.lang.reflect.Type type, JsonDeserializationContext jsonDeserializationContext) {
                            return Uri.parse(jsonElement.getAsString());
                        }
                    }).create().fromJson(reader, new TypeToken<List<Alarm>>() { // from class: com.urbandroid.sleep.persistence.Export.Type.2.2
                    }.getType());
                    if (list == null || list.isEmpty()) {
                        return true;
                    }
                    ExportUtilKt.importAlarms(context, list);
                    return true;
                } catch (Exception e) {
                    Logger.logSevere(e);
                    return false;
                }
            }

            private AnonymousClass2(String str, int i, String str2, int i2, boolean z) {
                super(str, i, i2, 0, str2, z);
            }
        }

        /* JADX INFO: renamed from: com.urbandroid.sleep.persistence.Export$Type$3, reason: invalid class name */
        public enum AnonymousClass3 extends Type {
            public /* synthetic */ AnonymousClass3() {
                this("Noises", 2, "noise.json", R.string.noise, false);
            }

            @Override // com.urbandroid.sleep.persistence.Export.Type
            public synchronized boolean importData(Context context, Reader reader, ProgressListener progressListener) {
                try {
                    try {
                        Logger.logInfo("IMPORT: Noise " + getFileName());
                        List<Noise> list = (List) new GsonBuilder().setDateFormat("MMM d, yyyy HH:mm:ss").create().fromJson(reader, new TypeToken<List<Noise>>() { // from class: com.urbandroid.sleep.persistence.Export.Type.3.1
                        }.getType());
                        Logger.logInfo("IMPORT: Noises " + list);
                        if (list != null) {
                            for (Noise noise : list) {
                                if (SharedApplicationContext.getInstance().getSleepRecordRepository().getNoise(noise.getId()) != null || (noise.getSyncId() == 0 && !NoiseDirectory.exists(context, noise.getUriFix(context)))) {
                                    Logger.logInfo("IMPORT: Noise " + noise.getFromTime() + " skipping " + noise.getUriFix(context));
                                }
                                SharedApplicationContext.getInstance().getSleepRecordRepository().addNoise(noise);
                                Logger.logInfo("IMPORT: Adding noise from backup " + noise.getFromTime());
                            }
                        }
                    } catch (Exception e) {
                        Logger.logSevere(e);
                        return false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
                return true;
            }

            private AnonymousClass3(String str, int i, String str2, int i2, boolean z) {
                super(str, i, i2, 0, str2, z);
            }
        }

        /* JADX INFO: renamed from: com.urbandroid.sleep.persistence.Export$Type$4, reason: invalid class name */
        /* JADX INFO: loaded from: classes.dex */
        public enum AnonymousClass4 extends Type {
            public /* synthetic */ AnonymousClass4() {
                this("Preferences", 3, "prefs.xml", R.string.settings, false);
            }

            @Override // com.urbandroid.sleep.persistence.Export.Type
            public boolean importData(Context context, Reader reader, ProgressListener progressListener) {
                Logger.logInfo("IMPORT: Prefs " + getFileName());
                return Export.importPrefsFromReader(context, reader);
            }

            private AnonymousClass4(String str, int i, String str2, int i2, boolean z) {
                super(str, i, i2, 0, str2, z);
            }
        }

        private static /* synthetic */ Type[] $values() {
            return new Type[]{Records, Alarms, Noises, Preferences};
        }

        private Type(String str, int i, String str2, int i2, boolean z) {
            this.fileName = str2;
            this.nameResource = i2;
            this.defaultOn = z;
        }

        public static Type findOrNull(String str) {
            for (Type type : values()) {
                if (type.fileName.equals(str)) {
                    return type;
                }
            }
            return null;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public int countRecords(Context context, Reader reader) {
            return -1;
        }

        public String getFileName() {
            return this.fileName;
        }

        public int getNameResource() {
            return this.nameResource;
        }

        public abstract boolean importData(Context context, Reader reader, ProgressListener progressListener);

        public boolean isDefaultOn() {
            return this.defaultOn;
        }

        public /* synthetic */ Type(String str, int i, int i2, int i3, String str2, boolean z) {
            this(str, i, str2, i2, z);
        }
    }

    public static File getExportFile(Context context, boolean z, String str) {
        return getExportFile(context, z, str, false);
    }

    public synchronized int countRecords(Context context) {
        return countRecords(context, null, false);
    }

    public synchronized int countRecords(Context context, File file) {
        if (!file.exists()) {
            return -1;
        }
        FileReader fileReader = new FileReader(file);
        try {
            int iCountRecords = Type.Records.countRecords(context, fileReader);
            fileReader.close();
            return iCountRecords;
        } finally {
        }
    }
}
