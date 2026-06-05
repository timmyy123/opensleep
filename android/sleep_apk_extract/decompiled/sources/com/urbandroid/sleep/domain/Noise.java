package com.urbandroid.sleep.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Environment;
import androidx.documentfile.provider.DocumentFile;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.mic.BaseRecordingWriter;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ScienceUtil;
import j$.util.DesugarTimeZone;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Noise implements TimeRecord {
    private String comment;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private float[] f64data;
    private Date from;
    private Long id;

    @Deprecated
    private Long recordId;
    private String timezone;
    private Date to;
    private String uri;
    private boolean sync = false;
    private long syncId = 0;
    private boolean starred = false;

    public Noise(Date date, Date date2, String str, String str2, SleepRecord sleepRecord) {
        this.from = date;
        this.to = date2;
        this.uri = str;
        this.timezone = str2;
        this.recordId = Long.valueOf(sleepRecord.getFrom().getTime());
    }

    public boolean equals(Object obj) {
        return (obj instanceof Noise) && ((Noise) obj).from.getTime() == this.from.getTime();
    }

    public void filterAndSetData(float[] fArr) {
        setData(ScienceUtil.toFloatArray(SleepRecordDataFilter.getPresentationFilter(300).filter(fArr)));
    }

    public String getComment() {
        return this.comment;
    }

    public float[] getData() {
        return this.f64data;
    }

    @Override // com.urbandroid.sleep.domain.TimeRecord
    public Date getFrom() {
        return this.from;
    }

    public long getFromTime() {
        return this.from.getTime();
    }

    public String getHumanReadableTitle() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH.mm.ss");
        String str = this.timezone;
        if (str != null) {
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(str));
        }
        return "Sleep Noise " + simpleDateFormat.format(this.from);
    }

    public Long getId() {
        return this.id;
    }

    public long getLength() {
        Date date;
        if (this.from == null || (date = this.to) == null) {
            return 0L;
        }
        return date.getTime() - this.from.getTime();
    }

    public Date getNotNullTo() {
        return getTo() == null ? new Date() : getTo();
    }

    @Deprecated
    public Long getRecordId() {
        return this.recordId;
    }

    public long getSyncId() {
        return this.syncId;
    }

    public String getTagFilteredComment() {
        return Tag.filterTags(this.comment);
    }

    public Set<String> getTags() {
        return Tag.getTags(this.comment);
    }

    public String getTimezone() {
        return this.timezone;
    }

    @Override // com.urbandroid.sleep.domain.TimeRecord
    public Date getTo() {
        return this.to;
    }

    public long getToTime() {
        return getNotNullTo().getTime();
    }

    public String getUri() {
        return this.uri;
    }

    public String getUriFix(Context context) {
        int iIndexOf;
        Settings settings = new Settings(context);
        String uri = getUri();
        if (!NoiseDirectory.isContentUri(uri) || uri.lastIndexOf(BaseRecordingWriter.FILE_NAME_PREFIX) <= 0) {
            File file = new File(uri);
            if ((file.exists() && file.canRead()) || (iIndexOf = uri.indexOf(BaseRecordingWriter.RECORD_PATH)) <= 0) {
                return uri;
            }
            String strSubstring = uri.substring(iIndexOf);
            String strConcat = settings.getNoiseStoragePath().concat(strSubstring);
            File file2 = new File(strConcat);
            if (file2.exists() && file2.canRead()) {
                return strConcat;
            }
            String strConcat2 = settings.getOldNoiseStoragePath().concat(strSubstring);
            File file3 = new File(strConcat2);
            if (file3.exists() && file3.canRead()) {
                return strConcat2;
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                strConcat2 = externalFilesDir.getAbsolutePath().concat(strSubstring);
            }
            File file4 = new File(strConcat2);
            return (file4.exists() && file4.canRead()) ? strConcat2 : Environment.getExternalStorageDirectory().getAbsolutePath().concat(strSubstring);
        }
        String strSubstring2 = uri.substring(uri.lastIndexOf(BaseRecordingWriter.FILE_NAME_PREFIX));
        Logger.logInfo("Noise: getUriFix() ".concat(uri));
        try {
            DocumentFile documentFilePrepareDocumentDir = new NoiseDirectory(context).prepareDocumentDir(true);
            String string = documentFilePrepareDocumentDir.getUri().toString();
            if (!string.endsWith("%2F")) {
                string = string.concat("%2F");
            }
            String strConcat3 = string.concat(strSubstring2);
            if (NoiseDirectory.exists(context, strConcat3)) {
                Logger.logInfo("Noise: fixUri constructedUri=".concat(strConcat3));
                return strConcat3;
            }
            DocumentFile documentFileFindFile = documentFilePrepareDocumentDir.findFile(strSubstring2);
            if (documentFileFindFile == null) {
                return uri;
            }
            Logger.logInfo("Noise: findFile fallback noiseDocumentFile=" + documentFileFindFile.getUri());
            return documentFileFindFile.getUri().toString();
        } catch (IOException e) {
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Noise: Cannot find noise dir for ", uri, ", message: ");
            sbM5m.append(e.getMessage());
            Logger.logInfo(sbM5m.toString());
            return uri;
        }
    }

    public int hashCode() {
        return (int) this.from.getTime();
    }

    public boolean isStarred() {
        return this.starred;
    }

    public boolean isSync() {
        return this.sync;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setData(float[] fArr) {
        this.f64data = fArr;
    }

    public void setFrom(Date date) {
        this.from = date;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setStarred(boolean z) {
        this.starred = z;
    }

    public void setSync(boolean z) {
        this.sync = z;
        if (z) {
            this.starred = true;
        }
    }

    public void setSyncId(long j) {
        this.syncId = j;
        if (j > 1) {
            this.sync = true;
        }
        if (j > 0) {
            this.starred = true;
        }
    }

    public void setTo(Date date) {
        this.to = date;
    }

    public String toString() {
        return "Noise " + this.from + " - " + this.to + " " + this.uri;
    }

    public Noise(Date date, Date date2, String str, String str2, Long l) {
        this.from = date;
        this.to = date2;
        this.uri = str;
        this.timezone = str2;
        this.recordId = l;
    }
}
