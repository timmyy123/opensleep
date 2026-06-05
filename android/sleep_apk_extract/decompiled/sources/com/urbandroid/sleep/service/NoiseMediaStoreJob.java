package com.urbandroid.sleep.service;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import adamb.vorbis.CommentField;
import adamb.vorbis.VorbisCommentHeader;
import adamb.vorbis.VorbisIO;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.NoiseMeta;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.mic.MediaCodecWriter;
import com.urbandroid.sleep.mic.VosRecordingWriter;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StreamUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;
import org.mp4parser.Container;
import org.mp4parser.PropertyBoxParserImpl;
import org.mp4parser.muxer.FileDataSourceImpl;
import org.mp4parser.muxer.Movie;
import org.mp4parser.muxer.builder.DefaultMp4Builder;
import org.mp4parser.muxer.tracks.AACTrackImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ&\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/service/NoiseMediaStoreJob;", "Landroid/app/job/JobService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "toMediaStore", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "noiseId", "", "onStartJob", "", "param", "Landroid/app/job/JobParameters;", "onStopJob", "appendMetadataM4a", "input", "Ljava/io/InputStream;", "output", "Ljava/io/OutputStream;", "noise", "Lcom/urbandroid/sleep/domain/Noise;", "appendMetadataOgg", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoiseMediaStoreJob extends JobService implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String tag = "MediaStoreJob";

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/service/NoiseMediaStoreJob$Companion;", "", "<init>", "()V", "EXTRA_NOISE_ID", "", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "noiseId", "", "getNoiseMediaStoreUri", "Landroid/net/Uri;", "noise", "Lcom/urbandroid/sleep/domain/Noise;", "deleteNoiseFromMediaStore", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = -1;
            }
            companion.start(context, j);
        }

        public final boolean deleteNoiseFromMediaStore(Context context, Noise noise) throws Throwable {
            context.getClass();
            noise.getClass();
            Uri noiseMediaStoreUri = getNoiseMediaStoreUri(context, noise);
            if (noiseMediaStoreUri != null) {
                int iDelete = context.getContentResolver().delete(noiseMediaStoreUri, null, null);
                Logger.logInfo("delete " + iDelete, null);
                if (iDelete == 1) {
                    return true;
                }
            }
            return false;
        }

        public final Uri getNoiseMediaStoreUri(Context context, Noise noise) throws Throwable {
            Cursor cursorQuery;
            Throwable th;
            context.getClass();
            noise.getClass();
            ContentResolver contentResolver = context.getContentResolver();
            try {
                Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                cursorQuery = contentResolver.query(uri, new String[]{"_id"}, "title like ?", new String[]{noise.getHumanReadableTitle() + "%"}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            Uri uriWithAppendedId = ContentUris.withAppendedId(uri, cursorQuery.getLong(0));
                            cursorQuery.close();
                            return uriWithAppendedId;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursorQuery == null) {
                            throw th;
                        }
                        cursorQuery.close();
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (Throwable th3) {
                cursorQuery = null;
                th = th3;
            }
        }

        public final void start(Context context, long noiseId) {
            context.getClass();
            if (Experiments.getInstance().isDoMediaStoreBackup()) {
                Settings settings = new Settings(context);
                if (noiseId == -1 && !settings.isTimeForMediaStoreJob()) {
                    Logger.logInfo("MediaStoreJob: not starting next time " + new Date(settings.getNextMediaStoreJob()), null);
                    return;
                }
                JobInfo.Builder builder = new JobInfo.Builder(1017, new ComponentName(context, (Class<?>) NoiseMediaStoreJob.class));
                if (noiseId == -1) {
                    builder.setOverrideDeadline(Utils.getHoursInMillis(12));
                    builder.setMinimumLatency(Utils.getMinutesInMillis(5));
                    builder.setRequiresDeviceIdle(true);
                } else {
                    PersistableBundle persistableBundle = new PersistableBundle();
                    persistableBundle.putLong("noise_id", noiseId);
                    builder.setExtras(persistableBundle);
                    builder.setOverrideDeadline(Utils.getHoursInMillis(12));
                    builder.setMinimumLatency(Utils.getMinutesInMillis(1));
                }
                Logger.logInfo("MediaStoreJob: start job " + noiseId, null);
                Object systemService = context.getSystemService("jobscheduler");
                systemService.getClass();
                JobScheduler jobScheduler = (JobScheduler) systemService;
                jobScheduler.cancel(1017);
                jobScheduler.schedule(builder.build());
                if (noiseId == -1) {
                    long jCurrentTimeMillis = System.currentTimeMillis() + 172800000;
                    Logger.logInfo("MediaStoreJob: next full sync " + new Date(noiseId), null);
                    settings.setNextMediaStoreJob(jCurrentTimeMillis);
                }
            }
        }

        private Companion() {
        }

        public final void start(Context context) {
            context.getClass();
            start$default(this, context, 0L, 2, null);
        }
    }

    public static final boolean deleteNoiseFromMediaStore(Context context, Noise noise) {
        return INSTANCE.deleteNoiseFromMediaStore(context, noise);
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    public final void appendMetadataM4a(Context context, InputStream input, OutputStream output, Noise noise) throws IOException {
        context.getClass();
        input.getClass();
        output.getClass();
        noise.getClass();
        File fileCreateTempFile = File.createTempFile("noise1", String.valueOf(noise.getId()), context.getCacheDir());
        File fileCreateTempFile2 = File.createTempFile("noise2", String.valueOf(noise.getId()), context.getCacheDir());
        StreamUtil.Companion companion = StreamUtil.INSTANCE;
        StreamUtil.Companion.copyStreamAndClose$default(companion, input, new FileOutputStream(fileCreateTempFile), null, null, 12, null);
        try {
            Movie movie = new Movie();
            movie.addTrack(new AACTrackImpl(new FileDataSourceImpl(fileCreateTempFile)));
            Container containerBuild = new DefaultMp4Builder().build(movie);
            containerBuild.getClass();
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile2);
            containerBuild.writeContainer(fileOutputStream.getChannel());
            fileOutputStream.close();
            MetaDataInsert metaDataInsert = new MetaDataInsert();
            Properties properties = new Properties();
            PropertyBoxParserImpl.BOX_MAP_CACHE = properties;
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("isoparser2-default.properties"));
            Logger.logInfo("MediaStoreJob: " + PropertyBoxParserImpl.BOX_MAP_CACHE.getProperty(ViewHierarchyConstants.HINT_KEY));
            NoiseMeta noiseMeta = new NoiseMeta(context, noise);
            metaDataInsert.writeRandomMetadata(fileCreateTempFile2, noiseMeta.getTitle(), noiseMeta.getArtist(), noiseMeta.getAlbum(), noiseMeta.getGenre(), noiseMeta.getComment(), noiseMeta.getAlbumArt());
            StreamUtil.Companion.copyStreamAndClose$default(companion, new FileInputStream(fileCreateTempFile2), output, null, null, 12, null);
        } catch (Exception e) {
            Logger.logSevere("MediaStoreJob: Error adding M4A metadata ", e);
            StreamUtil.Companion.copyStreamAndClose$default(StreamUtil.INSTANCE, new FileInputStream(fileCreateTempFile), output, null, null, 12, null);
        }
        fileCreateTempFile.deleteOnExit();
        fileCreateTempFile2.deleteOnExit();
    }

    public final void appendMetadataOgg(Context context, InputStream input, OutputStream output, Noise noise) throws IOException {
        context.getClass();
        input.getClass();
        output.getClass();
        noise.getClass();
        File fileCreateTempFile = File.createTempFile("noise1", String.valueOf(noise.getId()), context.getCacheDir());
        StreamUtil.Companion companion = StreamUtil.INSTANCE;
        StreamUtil.Companion.copyStreamAndClose$default(companion, input, new FileOutputStream(fileCreateTempFile), null, null, 12, null);
        NoiseMeta noiseMeta = new NoiseMeta(context, noise);
        try {
            VorbisCommentHeader vorbisCommentHeader = new VorbisCommentHeader();
            vorbisCommentHeader.vendor = noiseMeta.getArtist();
            vorbisCommentHeader.fields.add(new CommentField(ShareConstants.TITLE, noiseMeta.getTitle()));
            vorbisCommentHeader.fields.add(new CommentField("ARTIST", noiseMeta.getArtist()));
            vorbisCommentHeader.fields.add(new CommentField("ALBUM", noiseMeta.getAlbum()));
            vorbisCommentHeader.fields.add(new CommentField("GENRE", noiseMeta.getGenre()));
            vorbisCommentHeader.fields.add(new CommentField("COMMENT", noiseMeta.getComment()));
            vorbisCommentHeader.fields.add(new CommentField("METADATA_BLOCK_PICTURE", "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"));
            VorbisIO.writeComments(fileCreateTempFile, vorbisCommentHeader);
            StreamUtil.Companion.copyStreamAndClose$default(companion, new FileInputStream(fileCreateTempFile), output, null, null, 12, null);
        } catch (Exception e) {
            Logger.logSevere("MediaStoreJob: Error adding OGG metadata ", e);
            StreamUtil.Companion.copyStreamAndClose$default(StreamUtil.INSTANCE, new FileInputStream(fileCreateTempFile), output, null, null, 12, null);
        }
        fileCreateTempFile.deleteOnExit();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters param) {
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        GlobalInitializator.initializeIfRequired(applicationContext);
        if (param != null) {
            long j = param.getExtras().getLong("noise_id", -1L);
            String strM = zzba$$ExternalSyntheticOutline0.m(j, "start job ");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            if (j == -1) {
                int i = 0;
                for (Noise noise : SharedApplicationContext.getInstance().getSleepRecordRepository().getNoisesToSync()) {
                    try {
                        Context applicationContext2 = getApplicationContext();
                        applicationContext2.getClass();
                        Long id = noise.getId();
                        id.getClass();
                        toMediaStore(applicationContext2, id.longValue());
                    } catch (Exception e) {
                        Logger.logSevere(Logger.defaultTag, getTag(), e);
                        i++;
                    }
                }
                float size = i / r1.size();
                String str = "error count " + i + ", rate " + size;
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
                if (size > 0.1f) {
                    SharedApplicationContext.getSettings().setNextMediaStoreJob(System.currentTimeMillis() + 604800000);
                }
            } else {
                try {
                    Context applicationContext3 = getApplicationContext();
                    applicationContext3.getClass();
                    toMediaStore(applicationContext3, j);
                } catch (Exception e2) {
                    Logger.logSevere(Logger.defaultTag, getTag(), e2);
                }
                for (Noise noise2 : SharedApplicationContext.getInstance().getSleepRecordRepository().getNoisesToSync(5)) {
                    try {
                        Context applicationContext4 = getApplicationContext();
                        applicationContext4.getClass();
                        Long id2 = noise2.getId();
                        id2.getClass();
                        toMediaStore(applicationContext4, id2.longValue());
                    } catch (Exception e3) {
                        Logger.logSevere(Logger.defaultTag, getTag(), e3);
                    }
                }
            }
            jobFinished(param, false);
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters param) {
        Logger.logInfo(Logger.defaultTag, getTag() + ": stop job", null);
        return false;
    }

    public final void toMediaStore(Context context, long noiseId) throws Exception {
        int i;
        String str;
        String str2;
        context.getClass();
        String str3 = Logger.defaultTag;
        Logger.logInfo(str3, getTag() + ": " + ("Moving noise id " + noiseId), null);
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        Noise noise = sleepRecordRepository.getNoise(Long.valueOf(noiseId));
        if (noise != null) {
            String str4 = Logger.defaultTag;
            Logger.logInfo(str4, getTag() + ": " + ("Moving noise " + noise), null);
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            NoiseMeta noiseMeta = new NoiseMeta(context, noise);
            String strM = FileInsert$$ExternalSyntheticOutline0.m("title ", noiseMeta.getTitle());
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            contentValues.put("_display_name", noiseMeta.getTitle());
            contentValues.put("title", noiseMeta.getTitle());
            String uri = noise.getUri();
            uri.getClass();
            if (StringsKt__StringsJVMKt.endsWith$default(uri, MediaCodecWriter.EXTENSION, false, 2, null)) {
                contentValues.put("mime_type", "audio/mp4");
            } else {
                String uri2 = noise.getUri();
                uri2.getClass();
                if (StringsKt__StringsJVMKt.endsWith$default(uri2, VosRecordingWriter.EXTENSION, false, 2, null)) {
                    contentValues.put("mime_type", "audio/ogg");
                }
            }
            contentValues.put("artist", noiseMeta.getArtist());
            contentValues.put("album", noiseMeta.getAlbum());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                String str5 = Logger.defaultTag;
                i = i2;
                StringBuilder sb = new StringBuilder();
                str = "updating noise ";
                sb.append(getTag());
                sb.append(": inserting pending 1");
                Logger.logInfo(str5, sb.toString(), null);
                contentValues.put("duration", Long.valueOf(noise.getLength()));
                contentValues.put("is_pending", (Integer) 1);
                contentValues.put("relative_path", Environment.DIRECTORY_MUSIC + "/Sleep/");
            } else {
                i = i2;
                str = "updating noise ";
                contentValues.put("_data", Environment.DIRECTORY_MUSIC + "/Sleep/");
            }
            Logger.logInfo(Logger.defaultTag, getTag() + ": inserting?", null);
            Uri uriInsert = contentResolver.insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (uriInsert != null) {
                String str6 = Logger.defaultTag;
                Logger.logInfo(str6, getTag() + ": " + ("inserted " + uriInsert), null);
                try {
                    String uriFix = noise.getUriFix(context);
                    noise.setStarred(true);
                    noise.setSync(true);
                    noise.setSyncId(ContentUris.parseId(uriInsert));
                    String str7 = Logger.defaultTag;
                    Logger.logInfo(str7, getTag() + ": " + ("copy from " + uriFix + " to " + uriInsert), null);
                    if (NoiseDirectory.isContentUri(uriFix)) {
                        Uri uri3 = Uri.parse(uriFix);
                        String uri4 = noise.getUri();
                        uri4.getClass();
                        if (StringsKt__StringsJVMKt.endsWith$default(uri4, MediaCodecWriter.EXTENSION, false, 2, null)) {
                            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri3);
                            inputStreamOpenInputStream.getClass();
                            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert, "w");
                            outputStreamOpenOutputStream.getClass();
                            appendMetadataM4a(context, inputStreamOpenInputStream, outputStreamOpenOutputStream, noise);
                        } else {
                            String uri5 = noise.getUri();
                            uri5.getClass();
                            if (StringsKt__StringsJVMKt.endsWith$default(uri5, VosRecordingWriter.EXTENSION, false, 2, null)) {
                                InputStream inputStreamOpenInputStream2 = contentResolver.openInputStream(uri3);
                                inputStreamOpenInputStream2.getClass();
                                OutputStream outputStreamOpenOutputStream2 = contentResolver.openOutputStream(uriInsert, "w");
                                outputStreamOpenOutputStream2.getClass();
                                appendMetadataOgg(context, inputStreamOpenInputStream2, outputStreamOpenOutputStream2, noise);
                            } else {
                                StreamUtil.Companion.copyStreamAndClose$default(StreamUtil.INSTANCE, contentResolver.openInputStream(uri3), contentResolver.openOutputStream(uriInsert, "w"), null, null, 12, null);
                            }
                        }
                    } else {
                        File file = new File(uriFix);
                        String uri6 = noise.getUri();
                        uri6.getClass();
                        if (StringsKt__StringsJVMKt.endsWith$default(uri6, MediaCodecWriter.EXTENSION, false, 2, null)) {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            OutputStream outputStreamOpenOutputStream3 = contentResolver.openOutputStream(uriInsert, "w");
                            outputStreamOpenOutputStream3.getClass();
                            appendMetadataM4a(context, fileInputStream, outputStreamOpenOutputStream3, noise);
                        } else {
                            String uri7 = noise.getUri();
                            uri7.getClass();
                            if (StringsKt__StringsJVMKt.endsWith$default(uri7, VosRecordingWriter.EXTENSION, false, 2, null)) {
                                FileInputStream fileInputStream2 = new FileInputStream(file);
                                OutputStream outputStreamOpenOutputStream4 = contentResolver.openOutputStream(uriInsert, "w");
                                outputStreamOpenOutputStream4.getClass();
                                appendMetadataOgg(context, fileInputStream2, outputStreamOpenOutputStream4, noise);
                            } else {
                                StreamUtil.Companion.copyStreamAndClose$default(StreamUtil.INSTANCE, new FileInputStream(file), contentResolver.openOutputStream(uriInsert, "w"), null, null, 12, null);
                            }
                        }
                    }
                    sleepRecordRepository.updateNoise(noise);
                    String str8 = str + noise.getUri();
                    Logger.logInfo(Logger.defaultTag, getTag() + ": " + str8, null);
                    int i3 = i;
                    if (i3 >= 29) {
                        contentValues.clear();
                        str2 = "is_pending";
                        contentValues.put(str2, (Integer) 1);
                        String str9 = "updating result " + contentResolver.update(uriInsert, contentValues, null, null);
                        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str9, null);
                    } else {
                        str2 = "is_pending";
                    }
                    contentValues.clear();
                    contentValues.put("artist", "Sleep as Android");
                    contentValues.put("album", "Sleep as Android");
                    if (i3 >= 29) {
                        contentValues.put(str2, (Integer) 0);
                    }
                    String str10 = "updating result " + contentResolver.update(uriInsert, contentValues, null, null);
                    Logger.logInfo(Logger.defaultTag, getTag() + ": " + str10, null);
                } catch (Exception e) {
                    Logger.logSevere(Logger.defaultTag, getTag(), e);
                    contentResolver.delete(uriInsert, null, null);
                    throw new Exception(e);
                }
            }
        }
    }

    public static final void start(Context context, long j) {
        INSTANCE.start(context, j);
    }
}
