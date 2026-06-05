package com.google.android.gms.measurement.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaeh;
import com.google.android.gms.internal.measurement.zzagr;
import com.google.android.gms.internal.measurement.zzahh;
import com.google.android.gms.internal.measurement.zzahk;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.internal.measurement.zzair;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.home.platform.traits.ValidationIssue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpg implements zzjg {
    private static volatile zzpg zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzlu zzG;
    private String zzH;
    private zzaz zzI;
    private long zzJ;
    long zza;
    private final zzht zzc;
    private final zzgz zzd;
    private zzaw zze;
    private zzhb zzf;
    private zzok zzg;
    private zzad zzh;
    private final zzpk zzi;
    private zzlp zzj;
    private zznn zzk;
    private final zzou zzl;
    private zzhk zzm;
    private final zzic zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzpo zzK = new zzpb(this);

    public zzpg(zzph zzphVar, zzic zzicVar) {
        Preconditions.checkNotNull(zzphVar);
        this.zzn = zzic.zzy(zzphVar.zza, null, null, null);
        this.zzB = -1L;
        this.zzl = new zzou(this);
        zzpk zzpkVar = new zzpk(this);
        zzpkVar.zzaz();
        this.zzi = zzpkVar;
        zzgz zzgzVar = new zzgz(this);
        zzgzVar.zzaz();
        this.zzd = zzgzVar;
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzaz();
        this.zzc = zzhtVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaX().zzj(new zzov(this, zzphVar));
    }

    public static zzpg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpg.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzpg((zzph) Preconditions.checkNotNull(new zzph(context)), null);
                    }
                } finally {
                }
            }
        }
        return zzb;
    }

    public static final void zzaB(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i, String str) {
        List listZza = zzhrVar.zza();
        for (int i2 = 0; i2 < listZza.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i2)).zzb())) {
                return;
            }
        }
        zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb("_err");
        zzhvVarZzn.zzf(i);
        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd();
        zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn2.zzb("_ev");
        zzhvVarZzn2.zzd(str);
        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbd();
        zzhrVar.zzf(zzhwVar);
        zzhrVar.zzf(zzhwVar2);
    }

    public static final void zzaC(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List listZza = zzhrVar.zza();
        for (int i = 0; i < listZza.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i)).zzb())) {
                zzhrVar.zzj(i);
                return;
            }
        }
    }

    private final int zzaD(String str, zzan zzanVar) {
        zzjk zzjkVar;
        zzji zzjiVarZzB;
        zzht zzhtVar = this.zzc;
        if (zzhtVar.zzy(str) == null) {
            zzanVar.zzc(zzjk.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null && zze.zzc(zzhVarZzu.zzaH()).zza() == zzji.POLICY && (zzjiVarZzB = zzhtVar.zzB(str, (zzjkVar = zzjk.AD_PERSONALIZATION))) != zzji.UNINITIALIZED) {
            zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
            return zzjiVarZzB == zzji.GRANTED ? 0 : 1;
        }
        zzjk zzjkVar2 = zzjk.AD_PERSONALIZATION;
        zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
        return zzhtVar.zzw(str, zzjkVar2) ? 0 : 1;
    }

    private final Map zzaE(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap map = new HashMap();
        zzp();
        for (Map.Entry entry : zzpk.zzL(zzhsVar, "gad_").entrySet()) {
            map.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    private final zzaz zzaF() {
        if (this.zzI == null) {
            this.zzI = new zzoy(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public final void zzaw() {
        zzaX().zzg();
        if (this.zzr.isEmpty() || zzaF().zzc()) {
            return;
        }
        long jMax = Math.max(0L, ((long) ((Integer) zzfy.zzaA.zzb(null)).intValue()) - (zzba().elapsedRealtime() - this.zzJ));
        zzaW().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(jMax));
        zzaF().zzb(jMax);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0465 A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x047d A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05aa A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x05c6 A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05d4 A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0738 A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0a71 A[Catch: all -> 0x0aa2, TryCatch #0 {all -> 0x0aa2, blocks: (B:306:0x0971, B:307:0x0984, B:309:0x098a, B:409:0x0c42, B:338:0x0a26, B:345:0x0a57, B:347:0x0a71, B:348:0x0a79, B:350:0x0a7f, B:352:0x0a91, B:360:0x0aac, B:362:0x0ac0, B:363:0x0ae3, B:365:0x0aef, B:367:0x0b05, B:370:0x0b4a, B:376:0x0b66, B:378:0x0b71, B:380:0x0b75, B:382:0x0b79, B:384:0x0b7d, B:385:0x0b89, B:386:0x0b93, B:388:0x0b99, B:390:0x0baf, B:391:0x0bb4, B:408:0x0c3f, B:393:0x0bcb, B:395:0x0bcf, B:399:0x0bf1, B:401:0x0c11, B:402:0x0c18, B:405:0x0c2f, B:396:0x0bd9, B:410:0x0c4c, B:412:0x0c57, B:413:0x0c5d, B:414:0x0c65, B:416:0x0c6b, B:418:0x0c80, B:420:0x0c90, B:440:0x0d11, B:421:0x0ca8, B:423:0x0cae, B:425:0x0cb8, B:427:0x0cbf, B:433:0x0ccf, B:435:0x0cd6, B:437:0x0d02, B:439:0x0d09, B:438:0x0d06, B:434:0x0cd3, B:426:0x0cbc), top: B:485:0x0971 }] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0aaa A[PHI: r8
      0x0aaa: PHI (r8v6 java.lang.String) = (r8v5 java.lang.String), (r8v20 java.lang.String) binds: [B:346:0x0a6f, B:539:0x0aaa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0ac0 A[Catch: all -> 0x0aa2, TryCatch #0 {all -> 0x0aa2, blocks: (B:306:0x0971, B:307:0x0984, B:309:0x098a, B:409:0x0c42, B:338:0x0a26, B:345:0x0a57, B:347:0x0a71, B:348:0x0a79, B:350:0x0a7f, B:352:0x0a91, B:360:0x0aac, B:362:0x0ac0, B:363:0x0ae3, B:365:0x0aef, B:367:0x0b05, B:370:0x0b4a, B:376:0x0b66, B:378:0x0b71, B:380:0x0b75, B:382:0x0b79, B:384:0x0b7d, B:385:0x0b89, B:386:0x0b93, B:388:0x0b99, B:390:0x0baf, B:391:0x0bb4, B:408:0x0c3f, B:393:0x0bcb, B:395:0x0bcf, B:399:0x0bf1, B:401:0x0c11, B:402:0x0c18, B:405:0x0c2f, B:396:0x0bd9, B:410:0x0c4c, B:412:0x0c57, B:413:0x0c5d, B:414:0x0c65, B:416:0x0c6b, B:418:0x0c80, B:420:0x0c90, B:440:0x0d11, B:421:0x0ca8, B:423:0x0cae, B:425:0x0cb8, B:427:0x0cbf, B:433:0x0ccf, B:435:0x0cd6, B:437:0x0d02, B:439:0x0d09, B:438:0x0d06, B:434:0x0cd3, B:426:0x0cbc), top: B:485:0x0971 }] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0ae3 A[Catch: all -> 0x0aa2, TryCatch #0 {all -> 0x0aa2, blocks: (B:306:0x0971, B:307:0x0984, B:309:0x098a, B:409:0x0c42, B:338:0x0a26, B:345:0x0a57, B:347:0x0a71, B:348:0x0a79, B:350:0x0a7f, B:352:0x0a91, B:360:0x0aac, B:362:0x0ac0, B:363:0x0ae3, B:365:0x0aef, B:367:0x0b05, B:370:0x0b4a, B:376:0x0b66, B:378:0x0b71, B:380:0x0b75, B:382:0x0b79, B:384:0x0b7d, B:385:0x0b89, B:386:0x0b93, B:388:0x0b99, B:390:0x0baf, B:391:0x0bb4, B:408:0x0c3f, B:393:0x0bcb, B:395:0x0bcf, B:399:0x0bf1, B:401:0x0c11, B:402:0x0c18, B:405:0x0c2f, B:396:0x0bd9, B:410:0x0c4c, B:412:0x0c57, B:413:0x0c5d, B:414:0x0c65, B:416:0x0c6b, B:418:0x0c80, B:420:0x0c90, B:440:0x0d11, B:421:0x0ca8, B:423:0x0cae, B:425:0x0cb8, B:427:0x0cbf, B:433:0x0ccf, B:435:0x0cd6, B:437:0x0d02, B:439:0x0d09, B:438:0x0d06, B:434:0x0cd3, B:426:0x0cbc), top: B:485:0x0971 }] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0b5d  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0b61  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0b66 A[Catch: all -> 0x0aa2, TryCatch #0 {all -> 0x0aa2, blocks: (B:306:0x0971, B:307:0x0984, B:309:0x098a, B:409:0x0c42, B:338:0x0a26, B:345:0x0a57, B:347:0x0a71, B:348:0x0a79, B:350:0x0a7f, B:352:0x0a91, B:360:0x0aac, B:362:0x0ac0, B:363:0x0ae3, B:365:0x0aef, B:367:0x0b05, B:370:0x0b4a, B:376:0x0b66, B:378:0x0b71, B:380:0x0b75, B:382:0x0b79, B:384:0x0b7d, B:385:0x0b89, B:386:0x0b93, B:388:0x0b99, B:390:0x0baf, B:391:0x0bb4, B:408:0x0c3f, B:393:0x0bcb, B:395:0x0bcf, B:399:0x0bf1, B:401:0x0c11, B:402:0x0c18, B:405:0x0c2f, B:396:0x0bd9, B:410:0x0c4c, B:412:0x0c57, B:413:0x0c5d, B:414:0x0c65, B:416:0x0c6b, B:418:0x0c80, B:420:0x0c90, B:440:0x0d11, B:421:0x0ca8, B:423:0x0cae, B:425:0x0cb8, B:427:0x0cbf, B:433:0x0ccf, B:435:0x0cd6, B:437:0x0d02, B:439:0x0d09, B:438:0x0d06, B:434:0x0cd3, B:426:0x0cbc), top: B:485:0x0971 }] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0b93 A[Catch: all -> 0x0aa2, TryCatch #0 {all -> 0x0aa2, blocks: (B:306:0x0971, B:307:0x0984, B:309:0x098a, B:409:0x0c42, B:338:0x0a26, B:345:0x0a57, B:347:0x0a71, B:348:0x0a79, B:350:0x0a7f, B:352:0x0a91, B:360:0x0aac, B:362:0x0ac0, B:363:0x0ae3, B:365:0x0aef, B:367:0x0b05, B:370:0x0b4a, B:376:0x0b66, B:378:0x0b71, B:380:0x0b75, B:382:0x0b79, B:384:0x0b7d, B:385:0x0b89, B:386:0x0b93, B:388:0x0b99, B:390:0x0baf, B:391:0x0bb4, B:408:0x0c3f, B:393:0x0bcb, B:395:0x0bcf, B:399:0x0bf1, B:401:0x0c11, B:402:0x0c18, B:405:0x0c2f, B:396:0x0bd9, B:410:0x0c4c, B:412:0x0c57, B:413:0x0c5d, B:414:0x0c65, B:416:0x0c6b, B:418:0x0c80, B:420:0x0c90, B:440:0x0d11, B:421:0x0ca8, B:423:0x0cae, B:425:0x0cb8, B:427:0x0cbf, B:433:0x0ccf, B:435:0x0cd6, B:437:0x0d02, B:439:0x0d09, B:438:0x0d06, B:434:0x0cd3, B:426:0x0cbc), top: B:485:0x0971 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0194 A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x025a A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0271 A[Catch: all -> 0x00fb, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02af A[Catch: all -> 0x00fb, TRY_LEAVE, TryCatch #4 {all -> 0x00fb, blocks: (B:3:0x0018, B:5:0x002f, B:8:0x0039, B:9:0x004f, B:12:0x0065, B:15:0x008d, B:17:0x00c4, B:20:0x00d5, B:22:0x00df, B:229:0x0700, B:27:0x010d, B:30:0x0123, B:32:0x0129, B:34:0x012f, B:36:0x0142, B:40:0x014f, B:42:0x015a, B:44:0x0166, B:46:0x016c, B:50:0x0178, B:51:0x0186, B:53:0x0194, B:56:0x01b4, B:58:0x01ba, B:60:0x01ca, B:62:0x01d8, B:64:0x01e8, B:65:0x01f5, B:66:0x01f8, B:68:0x0205, B:70:0x020f, B:71:0x021f, B:73:0x023c, B:75:0x0246, B:77:0x025a, B:78:0x0266, B:81:0x0271, B:82:0x027b, B:85:0x0284, B:88:0x0295, B:89:0x0298, B:91:0x02af, B:142:0x0496, B:143:0x0499, B:145:0x04a5, B:148:0x04b6, B:150:0x04c7, B:152:0x04d3, B:185:0x059d, B:187:0x05aa, B:189:0x05b0, B:191:0x05b6, B:193:0x05c6, B:194:0x05c9, B:195:0x05ce, B:197:0x05d4, B:198:0x05e0, B:200:0x05e6, B:202:0x05f6, B:204:0x0600, B:205:0x0611, B:207:0x0617, B:208:0x0632, B:210:0x0638, B:211:0x0656, B:212:0x0665, B:216:0x068e, B:213:0x066d, B:215:0x067b, B:217:0x0696, B:218:0x06ae, B:220:0x06b4, B:222:0x06c7, B:223:0x06d4, B:224:0x06d8, B:226:0x06de, B:228:0x06ec, B:156:0x04f6, B:158:0x0506, B:161:0x0519, B:163:0x052a, B:165:0x0536, B:168:0x054a, B:171:0x0558, B:173:0x0562, B:175:0x056c, B:178:0x0577, B:180:0x057d, B:182:0x058d, B:183:0x0598, B:99:0x02d5, B:102:0x02df, B:104:0x02ed, B:108:0x0330, B:105:0x0308, B:107:0x0316, B:111:0x0337, B:114:0x036a, B:115:0x0394, B:117:0x03cb, B:119:0x03d1, B:122:0x03dd, B:124:0x0414, B:125:0x042f, B:127:0x0435, B:129:0x0443, B:133:0x0457, B:130:0x044b, B:136:0x045e, B:139:0x0465, B:140:0x047d, B:232:0x0719, B:234:0x0727, B:236:0x0730, B:247:0x0762, B:237:0x0738, B:239:0x0741, B:241:0x0747, B:244:0x0753, B:246:0x075d, B:248:0x0765, B:249:0x0771, B:252:0x0779, B:254:0x078b, B:255:0x0796, B:257:0x079e, B:261:0x07c4, B:263:0x07de, B:265:0x07f3, B:267:0x080d, B:269:0x0822, B:270:0x0830, B:272:0x0836, B:274:0x0846, B:275:0x084d, B:277:0x0859, B:278:0x0860, B:279:0x0863, B:281:0x08a5, B:283:0x08ab, B:289:0x08d2, B:291:0x08da, B:292:0x08e3, B:294:0x08e9, B:295:0x08ef, B:297:0x0904, B:299:0x0914, B:301:0x0924, B:303:0x092c, B:304:0x092f, B:312:0x09a5, B:314:0x09be, B:316:0x09d4, B:318:0x09d9, B:320:0x09dd, B:322:0x09e1, B:324:0x09eb, B:326:0x09f4, B:328:0x09f8, B:330:0x09fe, B:332:0x0a09, B:334:0x0a17, B:340:0x0a3c, B:343:0x0a42, B:284:0x08b9, B:286:0x08bf, B:288:0x08c5, B:268:0x081f, B:264:0x07f0, B:258:0x07a4, B:260:0x07aa), top: B:492:0x0018, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02cb  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [com.google.android.gms.internal.measurement.zzadp, com.google.android.gms.internal.measurement.zzhr] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [com.google.android.gms.internal.measurement.zzadp, com.google.android.gms.internal.measurement.zzhr] */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v136 */
    /* JADX WARN: Type inference failed for: r2v137 */
    /* JADX WARN: Type inference failed for: r2v138 */
    /* JADX WARN: Type inference failed for: r2v139 */
    /* JADX WARN: Type inference failed for: r2v140 */
    /* JADX WARN: Type inference failed for: r2v141 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r30v0 */
    /* JADX WARN: Type inference failed for: r30v1 */
    /* JADX WARN: Type inference failed for: r30v2 */
    /* JADX WARN: Type inference failed for: r30v3 */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r30v6 */
    /* JADX WARN: Type inference failed for: r30v7 */
    /* JADX WARN: Type inference failed for: r30v8 */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r32v1 */
    /* JADX WARN: Type inference failed for: r32v10 */
    /* JADX WARN: Type inference failed for: r32v11 */
    /* JADX WARN: Type inference failed for: r32v12 */
    /* JADX WARN: Type inference failed for: r32v13 */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r32v3 */
    /* JADX WARN: Type inference failed for: r32v4 */
    /* JADX WARN: Type inference failed for: r32v5 */
    /* JADX WARN: Type inference failed for: r32v6 */
    /* JADX WARN: Type inference failed for: r32v7 */
    /* JADX WARN: Type inference failed for: r32v8 */
    /* JADX WARN: Type inference failed for: r32v9 */
    /* JADX WARN: Type inference failed for: r5v25, types: [com.google.android.gms.internal.measurement.zzadp, com.google.android.gms.internal.measurement.zzhr] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.measurement.zzadp, com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r6v14, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v24, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v54 */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r6v57 */
    /* JADX WARN: Type inference failed for: r6v58 */
    /* JADX WARN: Type inference failed for: r6v59 */
    /* JADX WARN: Type inference failed for: r6v60 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v84 */
    /* JADX WARN: Type inference failed for: r9v85 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzaH(String str, long j) throws Throwable {
        ?? r2;
        boolean z;
        ?? r22;
        int i;
        Long l;
        Long l2;
        long j2;
        String str2;
        int iZzn;
        Long l3;
        long j3;
        SecureRandom secureRandom;
        long j4;
        int i2;
        long jZzam;
        Long l4;
        int i3;
        zzh zzhVarZzu;
        ?? r30;
        int i4;
        int i5;
        ?? r302;
        zzal zzalVarZzd;
        zzfx zzfxVar;
        boolean zZzk;
        ?? r32;
        String str3;
        ?? r322;
        ?? r6;
        int i6;
        int i7;
        ?? r17;
        ?? r16;
        ?? r172;
        ?? r62;
        ?? r162;
        ?? r63;
        String str4;
        String str5;
        int i8;
        int i9;
        String str6;
        long jZzE;
        ?? r323;
        ?? r173;
        ?? r163;
        ?? r64;
        ?? r1 = this;
        ?? r23 = "_ai";
        String str7 = "purchase";
        String str8 = "items";
        Long l5 = 1L;
        r1.zzj().zzb();
        try {
            zzpc zzpcVar = new zzpc(r1, null);
            r1.zzj().zzav(str, j, r1.zzB, zzpcVar);
            List list = zzpcVar.zzc;
            try {
                if (list == null || list.isEmpty()) {
                    ?? r24 = r1;
                    r24.zzj().zzc();
                    z = false;
                    r22 = r24;
                } else {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzpcVar.zza.zzco();
                    zzicVar.zzi();
                    ?? r164 = 0;
                    ?? r174 = 0;
                    int i10 = -1;
                    int i11 = -1;
                    int i12 = 0;
                    int i13 = 0;
                    boolean z2 = false;
                    boolean z3 = false;
                    ?? r25 = "_ai";
                    ?? r9 = zzicVar;
                    while (true) {
                        i = i13;
                        l = l5;
                        if (i12 >= zzpcVar.zzc.size()) {
                            break;
                        }
                        ?? r5 = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzpcVar.zzc.get(i12)).zzco();
                        boolean z4 = z2;
                        if (r1.zzh().zzj(zzpcVar.zza.zzA(), r5.zzk())) {
                            int i14 = i12;
                            r1.zzaW().zze().zzc("Dropping blocked raw event. appId", zzgu.zzl(zzpcVar.zza.zzA()), r1.zzn.zzl().zza(r5.zzk()));
                            if (!r1.zzh().zzo(zzpcVar.zza.zzA()) && !r1.zzh().zzp(zzpcVar.zza.zzA()) && !"_err".equals(r5.zzk())) {
                                r1.zzt().zzP(r1.zzK, zzpcVar.zza.zzA(), 11, "_ev", r5.zzk(), 0);
                            }
                            i13 = i;
                            r323 = r25;
                            str4 = str7;
                            str5 = str8;
                            r64 = r9;
                            i8 = i14;
                            r163 = r164;
                            r173 = r174;
                        } else {
                            int i15 = i12;
                            String strZzk = r5.zzk();
                            String str9 = str8;
                            if (strZzk.equals(str7) || strZzk.equals("_iap") || strZzk.equals("ecommerce_purchase")) {
                                r30 = r9;
                                i4 = i10;
                                i5 = i11;
                            } else {
                                i5 = i11;
                                ?? r303 = r9;
                                i4 = i10;
                                r302 = r303;
                                if (r1.zzd().zzp(null, zzfy.zzbf)) {
                                    r302 = r303;
                                    if (strZzk.equals("in_app_purchase")) {
                                        r30 = r303;
                                    }
                                }
                                if (r5.zzk().equals(zzjm.zza(r25))) {
                                    r5.zzl(r25);
                                    r1.zzaW().zzk().zza("Renaming ad_impression to _ai");
                                    if (Log.isLoggable(r1.zzaW().zzn(), 5)) {
                                        for (int i16 = 0; i16 < r5.zzb(); i16++) {
                                            if ("ad_platform".equals(r5.zzc(i16).zzb()) && !r5.zzc(i16).zzd().isEmpty() && "admob".equalsIgnoreCase(r5.zzc(i16).zzd())) {
                                                r1.zzaW().zzh().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                            }
                                        }
                                    }
                                }
                                zzalVarZzd = r1.zzd();
                                zzfxVar = zzfy.zzbf;
                                if (zzalVarZzd.zzp(null, zzfxVar) && r5.zzk().equals("in_app_purchase")) {
                                    r5.zzl("_iap");
                                    r1.zzaW().zzk().zza("Renaming in_app_purchase to _iap");
                                }
                                zZzk = r1.zzh().zzk(zzpcVar.zza.zzA(), r5.zzk());
                                if (r1.zzd().zzp(null, zzfxVar) && "_iap".equals(r5.zzk())) {
                                    zZzk = r1.zzV(r5);
                                    String strZzA = zzpcVar.zza.zzA();
                                    if ("_iap".equals(r5.zzk())) {
                                        r1.zzaK(r5, SDKConstants.PARAM_VALUE, strZzA);
                                        r1.zzaK(r5, "price", strZzA);
                                    }
                                    if (!"_iap".equals(r5.zzk())) {
                                        ArrayList arrayList = new ArrayList(r5.zza());
                                        int i17 = 0;
                                        while (true) {
                                            if (i17 >= arrayList.size()) {
                                                zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                zzhvVarZzn.zzb("quantity");
                                                zzhvVarZzn.zzf(1L);
                                                r5.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
                                                break;
                                            }
                                            if ("quantity".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i17)).zzb())) {
                                                break;
                                            }
                                            i17++;
                                        }
                                    }
                                }
                                if (zZzk) {
                                    r1.zzp();
                                    String strZzk2 = r5.zzk();
                                    Preconditions.checkNotEmpty(strZzk2);
                                    if (strZzk2.hashCode() == 95027 && strZzk2.equals("_ui")) {
                                        boolean z5 = false;
                                        boolean z6 = false;
                                        for (int i18 = 0; i18 < r5.zzb(); i18++) {
                                            if ("_c".equals(r5.zzc(i18).zzb())) {
                                                zzhv zzhvVar = (zzhv) r5.zzc(i18).zzco();
                                                zzhvVar.zzf(1L);
                                                r5.zzd(i18, (com.google.android.gms.internal.measurement.zzhw) zzhvVar.zzbd());
                                                z5 = true;
                                            } else if ("_r".equals(r5.zzc(i18).zzb())) {
                                                zzhv zzhvVar2 = (zzhv) r5.zzc(i18).zzco();
                                                zzhvVar2.zzf(1L);
                                                r5.zzd(i18, (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zzbd());
                                                z6 = true;
                                            }
                                        }
                                        if (z5 || !zZzk) {
                                            r32 = r25;
                                            str3 = str7;
                                        } else {
                                            r32 = r25;
                                            r1.zzaW().zzk().zzb("Marking event as conversion", r1.zzn.zzl().zza(r5.zzk()));
                                            zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzhvVarZzn2.zzb("_c");
                                            str3 = str7;
                                            zzhvVarZzn2.zzf(1L);
                                            r5.zzg(zzhvVarZzn2);
                                        }
                                        if (!z6) {
                                            r1.zzaW().zzk().zzb("Marking event as real-time", r1.zzn.zzl().zza(r5.zzk()));
                                            zzhv zzhvVarZzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzhvVarZzn3.zzb("_r");
                                            zzhvVarZzn3.zzf(1L);
                                            r5.zzg(zzhvVarZzn3);
                                        }
                                        if (r1.zzj().zzw(r1.zzC(), zzpcVar.zza.zzA(), false, false, false, false, true, false, false).zze > r1.zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzo)) {
                                            zzaC(r5, "_r");
                                        } else {
                                            z3 = true;
                                        }
                                        r322 = r32;
                                        r322 = r32;
                                        if (zzpp.zzh(r5.zzk()) && zZzk) {
                                            r322 = r32;
                                            if (r1.zzj().zzw(r1.zzC(), zzpcVar.zza.zzA(), false, false, true, false, false, false, false).zzc > r1.zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzn)) {
                                                r1.zzaW().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgu.zzl(zzpcVar.zza.zzA()));
                                                boolean z7 = false;
                                                zzhv zzhvVar3 = null;
                                                int i19 = -1;
                                                for (int i20 = 0; i20 < r5.zzb(); i20++) {
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVarZzc = r5.zzc(i20);
                                                    if ("_c".equals(zzhwVarZzc.zzb())) {
                                                        zzhvVar3 = (zzhv) zzhwVarZzc.zzco();
                                                        i19 = i20;
                                                    } else if ("_err".equals(zzhwVarZzc.zzb())) {
                                                        z7 = true;
                                                    }
                                                }
                                                if (z7) {
                                                    if (zzhvVar3 != null) {
                                                        r5.zzj(i19);
                                                        r322 = r32;
                                                    } else {
                                                        zzhvVar3 = null;
                                                        if (zzhvVar3 == null) {
                                                        }
                                                    }
                                                } else if (zzhvVar3 == null) {
                                                    zzhv zzhvVar4 = (zzhv) zzhvVar3.clone();
                                                    zzhvVar4.zzb("_err");
                                                    zzhvVar4.zzf(10L);
                                                    r5.zzd(i19, (com.google.android.gms.internal.measurement.zzhw) zzhvVar4.zzbd());
                                                    r322 = r32;
                                                } else {
                                                    r1.zzaW().zzb().zzb("Did not find conversion parameter. appId", zzgu.zzl(zzpcVar.zza.zzA()));
                                                    r322 = r32;
                                                }
                                            }
                                        }
                                    } else {
                                        r322 = r25;
                                        str3 = str7;
                                        zZzk = false;
                                    }
                                    if (zZzk) {
                                        r1.zzV(r5);
                                    }
                                    if ("_e".equals(r5.zzk())) {
                                        r1.zzp();
                                        if (zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) r5.zzbd(), "_fr") != null) {
                                            r6 = r302;
                                            i6 = i4;
                                            i7 = i5;
                                            i10 = i6;
                                            r62 = r6;
                                            r16 = r164;
                                            r172 = r174;
                                        } else if (r174 == 0 || Math.abs(r174.zzn() - r5.zzn()) > 1000) {
                                            r63 = r302;
                                            r162 = r5;
                                            i10 = i4;
                                            i11 = i;
                                            r17 = r174;
                                            if (r1.zzd().zzp(null, zzfy.zzbe) && r5.zzu() && !r5.zzs()) {
                                                jZzE = r1.zzp().zzE(r5.zzv());
                                                if (jZzE != 0) {
                                                    r5.zzt(jZzE);
                                                }
                                                r5.zzw(0L);
                                            }
                                            if (r5.zzb() == 0) {
                                                r1.zzp();
                                                Bundle bundleZzH = zzpk.zzH(r5.zza());
                                                int i21 = 0;
                                                while (i21 < r5.zzb()) {
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVarZzc2 = r5.zzc(i21);
                                                    String str10 = str9;
                                                    if (!zzhwVarZzc2.zzb().equals(str10) || zzhwVarZzc2.zzl().isEmpty()) {
                                                        i9 = i21;
                                                        str6 = str3;
                                                        if (!zzhwVarZzc2.zzb().equals(str10)) {
                                                            r1.zzU(r5.zzk(), (zzhv) zzhwVarZzc2.zzco(), bundleZzH, zzpcVar.zza.zzA());
                                                        }
                                                    } else {
                                                        String strZzA2 = zzpcVar.zza.zzA();
                                                        List listZzl = zzhwVarZzc2.zzl();
                                                        Bundle[] bundleArr = new Bundle[listZzl.size()];
                                                        int i22 = 0;
                                                        while (i22 < listZzl.size()) {
                                                            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) listZzl.get(i22);
                                                            r1.zzp();
                                                            int i23 = i21;
                                                            Bundle bundleZzH2 = zzpk.zzH(zzhwVar.zzl());
                                                            Iterator it = zzhwVar.zzl().iterator();
                                                            while (it.hasNext()) {
                                                                r1.zzU(r5.zzk(), (zzhv) ((com.google.android.gms.internal.measurement.zzhw) it.next()).zzco(), bundleZzH2, strZzA2);
                                                                listZzl = listZzl;
                                                                str3 = str3;
                                                            }
                                                            bundleArr[i22] = bundleZzH2;
                                                            i22++;
                                                            i21 = i23;
                                                            listZzl = listZzl;
                                                            str3 = str3;
                                                        }
                                                        i9 = i21;
                                                        str6 = str3;
                                                        bundleZzH.putParcelableArray(str10, bundleArr);
                                                    }
                                                    i21 = i9 + 1;
                                                    str9 = str10;
                                                    str3 = str6;
                                                }
                                                str4 = str3;
                                                str5 = str9;
                                                r5.zzi();
                                                zzpk zzpkVarZzp = r1.zzp();
                                                ArrayList arrayList2 = new ArrayList();
                                                for (String str11 : bundleZzH.keySet()) {
                                                    zzhv zzhvVarZzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                    zzhvVarZzn4.zzb(str11);
                                                    Object obj = bundleZzH.get(str11);
                                                    if (obj != null) {
                                                        zzpkVarZzp.zzd(zzhvVarZzn4, obj);
                                                        arrayList2.add((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn4.zzbd());
                                                    }
                                                }
                                                Iterator it2 = arrayList2.iterator();
                                                while (it2.hasNext()) {
                                                    r5.zzf((com.google.android.gms.internal.measurement.zzhw) it2.next());
                                                }
                                            } else {
                                                str4 = str3;
                                                str5 = str9;
                                            }
                                            i8 = i15;
                                            zzpcVar.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhs) r5.zzbd());
                                            r63.zzg(r5);
                                            i13 = i + 1;
                                            r64 = r63;
                                            r163 = r162;
                                            r173 = r17;
                                            r323 = r322;
                                        } else {
                                            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) r174.clone();
                                            if (r1.zzaJ(r5, zzhrVar)) {
                                                ?? r65 = r302;
                                                int i24 = i4;
                                                r65.zzf(i24, zzhrVar);
                                                i10 = i24;
                                                i11 = i5;
                                                r162 = 0;
                                                r17 = 0;
                                                r63 = r65;
                                            }
                                            if (r1.zzd().zzp(null, zzfy.zzbe)) {
                                                jZzE = r1.zzp().zzE(r5.zzv());
                                                if (jZzE != 0) {
                                                }
                                                r5.zzw(0L);
                                            }
                                            if (r5.zzb() == 0) {
                                            }
                                            i8 = i15;
                                            zzpcVar.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhs) r5.zzbd());
                                            r63.zzg(r5);
                                            i13 = i + 1;
                                            r64 = r63;
                                            r163 = r162;
                                            r173 = r17;
                                            r323 = r322;
                                        }
                                    } else {
                                        r6 = r302;
                                        i6 = i4;
                                        if ("_vs".equals(r5.zzk())) {
                                            r1.zzp();
                                            r6 = r6;
                                            if (zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) r5.zzbd(), "_et") == null) {
                                                if (r164 != 0 && Math.abs(r164.zzn() - r5.zzn()) <= 1000) {
                                                    com.google.android.gms.internal.measurement.zzhr zzhrVar2 = (com.google.android.gms.internal.measurement.zzhr) r164.clone();
                                                    if (r1.zzaJ(zzhrVar2, r5)) {
                                                        i7 = i5;
                                                        r6.zzf(i7, zzhrVar2);
                                                        i10 = i6;
                                                        r16 = 0;
                                                        r172 = 0;
                                                        r62 = r6;
                                                    }
                                                }
                                                i10 = i;
                                                i11 = i5;
                                                r17 = r5;
                                                r63 = r6;
                                                r162 = r164;
                                                if (r1.zzd().zzp(null, zzfy.zzbe)) {
                                                }
                                                if (r5.zzb() == 0) {
                                                }
                                                i8 = i15;
                                                zzpcVar.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhs) r5.zzbd());
                                                r63.zzg(r5);
                                                i13 = i + 1;
                                                r64 = r63;
                                                r163 = r162;
                                                r173 = r17;
                                                r323 = r322;
                                            }
                                            i7 = i5;
                                            i10 = i6;
                                            r62 = r6;
                                            r16 = r164;
                                            r172 = r174;
                                        } else {
                                            i7 = i5;
                                            if (("_f".equals(r5.zzk()) || "_v".equals(r5.zzk())) && ("_f".equals(r5.zzk()) || "_v".equals(r5.zzk()))) {
                                                int i25 = 0;
                                                while (true) {
                                                    if (i25 >= r5.zzb()) {
                                                        break;
                                                    }
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVarZzc3 = r5.zzc(i25);
                                                    if ("_elt".equals(zzhwVarZzc3.zzb())) {
                                                        r5.zzr(zzhwVarZzc3.zzf());
                                                        r5.zzj(i25);
                                                        break;
                                                    }
                                                    i25++;
                                                }
                                            }
                                            i10 = i6;
                                            r62 = r6;
                                            r16 = r164;
                                            r172 = r174;
                                        }
                                    }
                                    i11 = i7;
                                    r63 = r62;
                                    r162 = r16;
                                    r17 = r172;
                                    if (r1.zzd().zzp(null, zzfy.zzbe)) {
                                    }
                                    if (r5.zzb() == 0) {
                                    }
                                    i8 = i15;
                                    zzpcVar.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhs) r5.zzbd());
                                    r63.zzg(r5);
                                    i13 = i + 1;
                                    r64 = r63;
                                    r163 = r162;
                                    r173 = r17;
                                    r323 = r322;
                                }
                            }
                            zzhv zzhvVarZzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn5.zzb("_ct");
                            if (!z4) {
                                String strZzA3 = zzpcVar.zza.zzA();
                                String str12 = (r1.zzaQ(strZzA3, str7) && r1.zzaQ(strZzA3, "_iap") && r1.zzaQ(strZzA3, "ecommerce_purchase")) ? "new" : "returning";
                                zzhvVarZzn5.zzd(str12);
                                r5.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn5.zzbd());
                                z4 = true;
                                r302 = r30;
                                if (r5.zzk().equals(zzjm.zza(r25))) {
                                }
                                zzalVarZzd = r1.zzd();
                                zzfxVar = zzfy.zzbf;
                                if (zzalVarZzd.zzp(null, zzfxVar)) {
                                    r5.zzl("_iap");
                                    r1.zzaW().zzk().zza("Renaming in_app_purchase to _iap");
                                }
                                zZzk = r1.zzh().zzk(zzpcVar.zza.zzA(), r5.zzk());
                                if (r1.zzd().zzp(null, zzfxVar)) {
                                    zZzk = r1.zzV(r5);
                                    String strZzA4 = zzpcVar.zza.zzA();
                                    if ("_iap".equals(r5.zzk())) {
                                    }
                                    if (!"_iap".equals(r5.zzk())) {
                                    }
                                }
                                if (zZzk) {
                                }
                            }
                        }
                        z2 = z4;
                        i12 = i8 + 1;
                        r9 = r64;
                        str8 = str5;
                        l5 = l;
                        str7 = str4;
                        r25 = r323;
                        r164 = r163;
                        r174 = r173;
                    }
                    ?? r66 = r9;
                    int i26 = i;
                    int i27 = 0;
                    long jLongValue = 0;
                    while (i27 < i26) {
                        com.google.android.gms.internal.measurement.zzhs zzhsVarZzd = r66.zzd(i27);
                        if ("_e".equals(zzhsVarZzd.zzd())) {
                            r1.zzp();
                            if (zzpk.zzI(zzhsVarZzd, "_fr") != null) {
                                r66.zzj(i27);
                                i26--;
                                i27--;
                            } else {
                                r1.zzp();
                                com.google.android.gms.internal.measurement.zzhw zzhwVarZzI = zzpk.zzI(zzhsVarZzd, "_et");
                                if (zzhwVarZzI != null) {
                                    Long lValueOf = zzhwVarZzI.zze() ? Long.valueOf(zzhwVarZzI.zzf()) : null;
                                    if (lValueOf != null && lValueOf.longValue() > 0) {
                                        jLongValue += lValueOf.longValue();
                                    }
                                }
                            }
                        }
                        i27++;
                    }
                    r1.zzaI(r66, jLongValue, false);
                    Iterator it3 = r66.zzb().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it3.next()).zzd())) {
                            r1.zzj().zzk(r66.zzK(), "_se");
                            break;
                        }
                    }
                    if (zzpk.zzx(r66, "_sid") >= 0) {
                        r1.zzaI(r66, jLongValue, true);
                    } else {
                        int iZzx = zzpk.zzx(r66, "_se");
                        if (iZzx >= 0) {
                            r66.zzr(iZzx);
                            r1.zzaW().zzb().zzb("Session engagement user property is in the bundle without session ID. appId", zzgu.zzl(zzpcVar.zza.zzA()));
                        }
                    }
                    String strZzA5 = zzpcVar.zza.zzA();
                    r1.zzaX().zzg();
                    r1.zzu();
                    zzh zzhVarZzu2 = r1.zzj().zzu(strZzA5);
                    if (zzhVarZzu2 == null) {
                        r1.zzaW().zzb().zzb("Cannot fix consent fields without appInfo. appId", zzgu.zzl(strZzA5));
                    } else {
                        r1.zzI(zzhVarZzu2, r66);
                    }
                    String strZzA6 = zzpcVar.zza.zzA();
                    r1.zzaX().zzg();
                    r1.zzu();
                    zzh zzhVarZzu3 = r1.zzj().zzu(strZzA6);
                    if (zzhVarZzu3 == null) {
                        r1.zzaW().zze().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzgu.zzl(strZzA6));
                    } else {
                        r1.zzJ(zzhVarZzu3, r66);
                    }
                    r66.zzv(Long.MAX_VALUE);
                    r66.zzx(Long.MIN_VALUE);
                    for (int i28 = 0; i28 < r66.zzc(); i28++) {
                        com.google.android.gms.internal.measurement.zzhs zzhsVarZzd2 = r66.zzd(i28);
                        if (zzhsVarZzd2.zzf() < r66.zzu()) {
                            r66.zzv(zzhsVarZzd2.zzf());
                        }
                        if (zzhsVarZzd2.zzf() > r66.zzw()) {
                            r66.zzx(zzhsVarZzd2.zzf());
                        }
                    }
                    r66.zzak();
                    zzjl zzjlVar = zzjl.zza;
                    zzjl zzjlVarZzs = r1.zzB(zzpcVar.zza.zzA()).zzs(zzjl.zzf(zzpcVar.zza.zzaf(), 100));
                    zzjl zzjlVarZzaf = r1.zzj().zzaf(zzpcVar.zza.zzA());
                    r1.zzj().zzae(zzpcVar.zza.zzA(), zzjlVarZzs);
                    zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                    if (!zzjlVarZzs.zzo(zzjkVar) && zzjlVarZzaf.zzo(zzjkVar)) {
                        r1.zzj().zzi(zzpcVar.zza.zzA());
                    } else if (zzjlVarZzs.zzo(zzjkVar) && !zzjlVarZzaf.zzo(zzjkVar)) {
                        r1.zzj().zzj(zzpcVar.zza.zzA());
                    }
                    zzjk zzjkVar2 = zzjk.AD_STORAGE;
                    if (!zzjlVarZzs.zzo(zzjkVar2)) {
                        r66.zzR();
                        r66.zzU();
                        r66.zzan();
                    }
                    if (!zzjlVarZzs.zzo(zzjkVar)) {
                        r66.zzX();
                        r66.zzav();
                    }
                    zzaif.zza();
                    if (r1.zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaO) && r1.zzt().zzZ(zzpcVar.zza.zzA()) && r1.zzB(zzpcVar.zza.zzA()).zzo(zzjkVar2) && zzpcVar.zza.zzak()) {
                        r1.zzT(r66, zzpcVar);
                    }
                    r66.zzag();
                    r66.zzaf(r1.zzm().zzb(r66.zzK(), r66.zzb(), r66.zzk(), Long.valueOf(r66.zzu()), Long.valueOf(r66.zzw()), !zzjlVarZzs.zzo(zzjkVar)));
                    if (r1.zzd().zzD(zzpcVar.zza.zzA())) {
                        try {
                            HashMap map = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom secureRandomZzf = r1.zzt().zzf();
                            int i29 = 0;
                            r1 = r1;
                            while (i29 < r66.zzc()) {
                                com.google.android.gms.internal.measurement.zzhr zzhrVar3 = (com.google.android.gms.internal.measurement.zzhr) r66.zzd(i29).zzco();
                                String str13 = "_efs";
                                if (zzhrVar3.zzk().equals("_ep")) {
                                    r1.zzp();
                                    String str14 = (String) zzpk.zzM((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd(), "_en");
                                    zzbd zzbdVarZzf = (zzbd) map.get(str14);
                                    if (zzbdVarZzf == null && (zzbdVarZzf = r1.zzj().zzf(zzpcVar.zza.zzA(), (String) Preconditions.checkNotNull(str14))) != null) {
                                        map.put(str14, zzbdVarZzf);
                                    }
                                    if (zzbdVarZzf == null || zzbdVarZzf.zzi != null) {
                                        l2 = l;
                                    } else {
                                        Long l6 = zzbdVarZzf.zzj;
                                        if (l6 != null && l6.longValue() > 1) {
                                            r1.zzp();
                                            zzpk.zzF(zzhrVar3, "_sr", l6);
                                        }
                                        Boolean bool = zzbdVarZzf.zzk;
                                        if (bool == null || !bool.booleanValue()) {
                                            l2 = l;
                                        } else {
                                            r1.zzp();
                                            l2 = l;
                                            zzpk.zzF(zzhrVar3, "_efs", l2);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                    }
                                    r66.zzf(i29, zzhrVar3);
                                } else {
                                    l2 = l;
                                    zzht zzhtVarZzh = r1.zzh();
                                    String strZzA7 = zzpcVar.zza.zzA();
                                    String strZza = zzhtVarZzh.zza(strZzA7, "measurement.account.time_zone_offset_minutes");
                                    if (TextUtils.isEmpty(strZza)) {
                                        j2 = 0;
                                        long jZzam2 = r1.zzt().zzam(zzhrVar3.zzn(), j2);
                                        com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd();
                                        if (TextUtils.isEmpty("_dbg")) {
                                        }
                                    } else {
                                        try {
                                            j2 = Long.parseLong(strZza);
                                        } catch (NumberFormatException e) {
                                            zzhtVarZzh.zzu.zzaW().zze().zzc("Unable to parse timezone offset. appId", zzgu.zzl(strZzA7), e);
                                            j2 = 0;
                                        }
                                        long jZzam22 = r1.zzt().zzam(zzhrVar3.zzn(), j2);
                                        com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd();
                                        if (TextUtils.isEmpty("_dbg")) {
                                            for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : zzhsVar2.zza()) {
                                                str2 = str13;
                                                if (!"_dbg".equals(zzhwVar2.zzb())) {
                                                    str13 = str2;
                                                } else if (l2.equals(Long.valueOf(zzhwVar2.zzf()))) {
                                                    iZzn = 1;
                                                    if (iZzn > 0) {
                                                    }
                                                } else {
                                                    iZzn = zzh().zzn(zzpcVar.zza.zzA(), zzhrVar3.zzk());
                                                    if (iZzn > 0) {
                                                        zzaW().zze().zzc("Sample rate must be positive. event, rate", zzhrVar3.zzk(), Integer.valueOf(iZzn));
                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                                        r66.zzf(i29, zzhrVar3);
                                                    } else {
                                                        zzbd zzbdVarZzc = (zzbd) map.get(zzhrVar3.zzk());
                                                        if (zzbdVarZzc == null) {
                                                            l3 = l2;
                                                            zzbdVarZzc = zzj().zzf(zzpcVar.zza.zzA(), zzhrVar3.zzk());
                                                            if (zzbdVarZzc == null) {
                                                                j3 = j2;
                                                                zzaW().zze().zzc("Event being bundled has no eventAggregate. appId, eventName", zzpcVar.zza.zzA(), zzhrVar3.zzk());
                                                                zzbdVarZzc = new zzbd(zzpcVar.zza.zzA(), zzhrVar3.zzk(), 1L, 1L, 1L, zzhrVar3.zzn(), 0L, null, null, null, null);
                                                            }
                                                            zzp();
                                                            Long l7 = (Long) zzpk.zzM((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd(), "_eid");
                                                            boolean z8 = l7 == null;
                                                            if (iZzn != 1) {
                                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                                                if (z8 && (zzbdVarZzc.zzi != null || zzbdVarZzc.zzj != null || zzbdVarZzc.zzk != null)) {
                                                                    map.put(zzhrVar3.zzk(), zzbdVarZzc.zzc(null, null, null));
                                                                }
                                                                r66.zzf(i29, zzhrVar3);
                                                                secureRandom = secureRandomZzf;
                                                                i3 = i29;
                                                                l4 = l3;
                                                            } else {
                                                                if (secureRandomZzf.nextInt(iZzn) == 0) {
                                                                    zzp();
                                                                    Long lValueOf2 = Long.valueOf(iZzn);
                                                                    zzpk.zzF(zzhrVar3, "_sr", lValueOf2);
                                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                                                    if (z8) {
                                                                        zzbdVarZzc = zzbdVarZzc.zzc(null, lValueOf2, null);
                                                                    }
                                                                    map.put(zzhrVar3.zzk(), zzbdVarZzc.zzb(zzhrVar3.zzn(), jZzam22));
                                                                    secureRandom = secureRandomZzf;
                                                                    i3 = i29;
                                                                    l4 = l3;
                                                                } else {
                                                                    Long l8 = zzbdVarZzc.zzh;
                                                                    if (l8 != null) {
                                                                        jZzam = l8.longValue();
                                                                        secureRandom = secureRandomZzf;
                                                                        j4 = jZzam22;
                                                                        i2 = i29;
                                                                    } else {
                                                                        secureRandom = secureRandomZzf;
                                                                        j4 = jZzam22;
                                                                        i2 = i29;
                                                                        jZzam = zzt().zzam(zzhrVar3.zzp(), j3);
                                                                    }
                                                                    if (jZzam != j4) {
                                                                        zzp();
                                                                        l4 = l3;
                                                                        zzpk.zzF(zzhrVar3, str2, l4);
                                                                        zzp();
                                                                        Long lValueOf3 = Long.valueOf(iZzn);
                                                                        zzpk.zzF(zzhrVar3, "_sr", lValueOf3);
                                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                                                        if (z8) {
                                                                            zzbdVarZzc = zzbdVarZzc.zzc(null, lValueOf3, Boolean.TRUE);
                                                                        }
                                                                        map.put(zzhrVar3.zzk(), zzbdVarZzc.zzb(zzhrVar3.zzn(), j4));
                                                                        i3 = i2;
                                                                    } else {
                                                                        l4 = l3;
                                                                        if (z8) {
                                                                            map.put(zzhrVar3.zzk(), zzbdVarZzc.zzc(l7, null, null));
                                                                        }
                                                                        i3 = i2;
                                                                        r66.zzf(i3, zzhrVar3);
                                                                    }
                                                                }
                                                                r66.zzf(i3, zzhrVar3);
                                                            }
                                                        } else {
                                                            l3 = l2;
                                                        }
                                                        j3 = j2;
                                                        zzp();
                                                        Long l72 = (Long) zzpk.zzM((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd(), "_eid");
                                                        if (l72 == null) {
                                                        }
                                                        if (iZzn != 1) {
                                                        }
                                                    }
                                                }
                                            }
                                            str2 = str13;
                                            iZzn = zzh().zzn(zzpcVar.zza.zzA(), zzhrVar3.zzk());
                                            if (iZzn > 0) {
                                            }
                                        } else {
                                            str2 = str13;
                                            iZzn = zzh().zzn(zzpcVar.zza.zzA(), zzhrVar3.zzk());
                                            if (iZzn > 0) {
                                            }
                                        }
                                    }
                                    i29 = i3 + 1;
                                    r1 = this;
                                    l = l4;
                                    secureRandomZzf = secureRandom;
                                }
                                secureRandom = secureRandomZzf;
                                i3 = i29;
                                l4 = l2;
                                i29 = i3 + 1;
                                r1 = this;
                                l = l4;
                                secureRandomZzf = secureRandom;
                            }
                            z = true;
                            if (arrayList3.size() < r66.zzc()) {
                                r66.zzi();
                                r66.zzh(arrayList3);
                            }
                            Iterator it4 = map.entrySet().iterator();
                            while (it4.hasNext()) {
                                zzj().zzh((zzbd) ((Map.Entry) it4.next()).getValue());
                            }
                        } catch (Throwable th) {
                            th = th;
                            r2 = this;
                            r2.zzj().zzd();
                            throw th;
                        }
                    } else {
                        z = true;
                    }
                    String strZzA8 = zzpcVar.zza.zzA();
                    zzh zzhVarZzu4 = zzj().zzu(strZzA8);
                    if (zzhVarZzu4 == null) {
                        zzaW().zzb().zzb("Bundling raw events w/o app info. appId", zzgu.zzl(zzpcVar.zza.zzA()));
                    } else if (r66.zzc() > 0) {
                        long jZzp = zzhVarZzu4.zzp();
                        if (jZzp != 0) {
                            r66.zzA(jZzp);
                        } else {
                            r66.zzB();
                        }
                        long jZzn = zzhVarZzu4.zzn();
                        if (jZzn != 0) {
                            jZzp = jZzn;
                        }
                        if (jZzp != 0) {
                            r66.zzy(jZzp);
                        } else {
                            r66.zzz();
                        }
                        zzhVarZzu4.zzM(r66.zzc());
                        r66.zzaJ((int) zzhVarZzu4.zzaF());
                        r66.zzZ((int) zzhVarZzu4.zzG());
                        zzhVarZzu4.zzo(r66.zzu());
                        zzhVarZzu4.zzq(r66.zzw());
                        String strZzaa = zzhVarZzu4.zzaa();
                        if (strZzaa != null) {
                            r66.zzaa(strZzaa);
                        } else {
                            r66.zzab();
                        }
                        zzj().zzv(zzhVarZzu4, false, false);
                    }
                    if (r66.zzc() > 0) {
                        zzpg zzpgVar = this;
                        zzpgVar.zzn.zzaV();
                        if (zzpgVar.zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzbj)) {
                            String strZzK = r66.zzK();
                            if (!TextUtils.isEmpty(strZzK) && (zzhVarZzu = zzpgVar.zzj().zzu(strZzK)) != null) {
                                long jCurrentTimeMillis = zzpgVar.zzba().currentTimeMillis();
                                if (jCurrentTimeMillis - zzhVarZzu.zzaN() >= zzpgVar.zzd().zzl(strZzK, zzfy.zzaB)) {
                                    List listZzac = zzpgVar.zzj().zzac("");
                                    if (!listZzac.isEmpty()) {
                                        r66.zzaR(listZzac);
                                    }
                                    List listZzac2 = zzpgVar.zzj().zzac(strZzK);
                                    if (!listZzac2.isEmpty()) {
                                        r66.zzaR(listZzac2);
                                    }
                                    zzhVarZzu.zzaM(jCurrentTimeMillis);
                                    zzpgVar.zzj().zzv(zzhVarZzu, false, false);
                                }
                            }
                        }
                        com.google.android.gms.internal.measurement.zzgl zzglVarZzb = zzpgVar.zzh().zzb(zzpcVar.zza.zzA());
                        if (zzglVarZzb != null && zzglVarZzb.zza()) {
                            r66.zzal(zzglVarZzb.zzb());
                        } else if (zzpcVar.zza.zzP().isEmpty()) {
                            r66.zzal(-1L);
                        } else {
                            zzpgVar.zzaW().zze().zzb("Did not find measurement config or missing version info. appId", zzgu.zzl(zzpcVar.zza.zzA()));
                        }
                        zzpgVar.zzj().zzz((com.google.android.gms.internal.measurement.zzid) r66.zzbd(), z3);
                        r23 = zzpgVar;
                    } else {
                        r23 = this;
                    }
                    r23.zzj().zzS(zzpcVar.zzb);
                    zzaw zzawVarZzj = r23.zzj();
                    try {
                        zzawVarZzj.zze().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strZzA8, strZzA8});
                    } catch (SQLiteException e2) {
                        zzawVarZzj.zzu.zzaW().zzb().zzc("Failed to remove unused event metadata. appId", zzgu.zzl(strZzA8), e2);
                    }
                    r23.zzj().zzc();
                    r22 = r23;
                }
                r22.zzj().zzd();
                return z;
            } catch (Throwable th2) {
                th = th2;
                r2 = r23;
                r2.zzj().zzd();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            r2 = r1;
            r2.zzj().zzd();
            throw th;
        }
    }

    private final void zzaI(com.google.android.gms.internal.measurement.zzic zzicVar, long j, boolean z) {
        Object obj;
        String str = true != z ? "_lte" : "_se";
        zzpn zzpnVarZzm = zzj().zzm(zzicVar.zzK(), str);
        zzpn zzpnVar = (zzpnVarZzm == null || (obj = zzpnVarZzm.zze) == null) ? new zzpn(zzicVar.zzK(), "auto", str, zzba().currentTimeMillis(), Long.valueOf(j)) : new zzpn(zzicVar.zzK(), "auto", str, zzba().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
        zzitVarZzm.zzb(str);
        zzitVarZzm.zza(zzba().currentTimeMillis());
        Object obj2 = zzpnVar.zze;
        zzitVarZzm.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd();
        int iZzx = zzpk.zzx(zzicVar, str);
        if (iZzx >= 0) {
            zzicVar.zzn(iZzx, zziuVar);
        } else {
            zzicVar.zzo(zziuVar);
        }
        if (j > 0) {
            zzj().zzl(zzpnVar);
            zzaW().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean zzaJ(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_sc");
        String strZzd = zzhwVarZzI == null ? null : zzhwVarZzI.zzd();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI2 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_pc");
        String strZzd2 = zzhwVarZzI2 != null ? zzhwVarZzI2.zzd() : null;
        if (strZzd2 == null || !strZzd2.equals(strZzd)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI3 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_et");
        if (zzhwVarZzI3 == null || !zzhwVarZzI3.zze() || zzhwVarZzI3.zzf() <= 0) {
            return true;
        }
        long jZzf = zzhwVarZzI3.zzf();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI4 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_et");
        if (zzhwVarZzI4 != null && zzhwVarZzI4.zzf() > 0) {
            jZzf += zzhwVarZzI4.zzf();
        }
        zzp();
        zzpk.zzF(zzhrVar2, "_et", Long.valueOf(jZzf));
        zzp();
        zzpk.zzF(zzhrVar, "_fr", 1L);
        return true;
    }

    private final void zzaK(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, String str2) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzb())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        double dZzk = zzhrVar.zzc(i).zzk() * 1000000.0d;
        if (dZzk == 0.0d) {
            dZzk = zzhrVar.zzc(i).zzf() * 1000000.0d;
        }
        if (dZzk > 9.223372036854776E18d || dZzk < -9.223372036854776E18d) {
            zzaW().zze().zzc(FileInsert$$ExternalSyntheticOutline0.m("Data lost. Purchase ", str, " is too big. appId"), zzgu.zzl(str2), Double.valueOf(dZzk));
            return;
        }
        zzhrVar.zzj(i);
        zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb(str);
        zzhvVarZzn.zzf(Math.round(dZzk));
        zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
    }

    private final boolean zzaL() {
        zzaX().zzg();
        zzu();
        return zzj().zzP() || !TextUtils.isEmpty(zzj().zzF());
    }

    private final void zzaM() {
        long jMax;
        long jMax2;
        zzaX().zzg();
        zzu();
        if (this.zza > 0) {
            long jAbs = 3600000 - Math.abs(zzba().elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzaW().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzk().zzb();
                zzl().zzf();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzH() || !zzaL()) {
            zzaW().zzk().zza("Nothing to upload or uploading impossible");
            zzk().zzb();
            zzl().zzf();
            return;
        }
        long jCurrentTimeMillis = zzba().currentTimeMillis();
        zzd();
        long jMax3 = Math.max(0L, ((Long) zzfy.zzO.zzb(null)).longValue());
        boolean z = true;
        if (!zzj().zzR() && !zzj().zzG()) {
            z = false;
        }
        if (z) {
            String strZzA = zzd().zzA();
            if (TextUtils.isEmpty(strZzA) || ".none.".equals(strZzA)) {
                zzd();
                jMax = Math.max(0L, ((Long) zzfy.zzI.zzb(null)).longValue());
            } else {
                zzd();
                jMax = Math.max(0L, ((Long) zzfy.zzJ.zzb(null)).longValue());
            }
        } else {
            zzd();
            jMax = Math.max(0L, ((Long) zzfy.zzH.zzb(null)).longValue());
        }
        long jZza = this.zzk.zzd.zza();
        long jZza2 = this.zzk.zze.zza();
        long j = 0;
        boolean z2 = z;
        long jMax4 = Math.max(zzj().zzM(), zzj().zzO());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            jMax2 = jMax3 + jAbs2;
            long jMax5 = Math.max(jAbs3, jAbs4);
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            if (!zzp().zzs(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    zzd();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzfy.zzQ.zzb(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    zzd();
                    jMax2 += Math.max(j, ((Long) zzfy.zzP.zzb(null)).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                    i++;
                    j = 0;
                }
            }
            j = 0;
        }
        if (jMax2 == j) {
            zzaW().zzk().zza("Next upload time is 0");
            zzk().zzb();
            zzl().zzf();
            return;
        }
        if (!zzi().zzb()) {
            zzaW().zzk().zza("No network");
            zzk().zza();
            zzl().zzf();
            return;
        }
        long jZza3 = this.zzk.zzc.zza();
        zzd();
        long jMax6 = Math.max(0L, ((Long) zzfy.zzF.zzb(null)).longValue());
        if (!zzp().zzs(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzk().zzb();
        long jCurrentTimeMillis2 = jMax2 - zzba().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzd();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzfy.zzK.zzb(null)).longValue());
            this.zzk.zzd.zzb(zzba().currentTimeMillis());
        }
        zzaW().zzk().zzb("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzl().zzd(jCurrentTimeMillis2);
    }

    private final void zzaN() {
        zzaX().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaW().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaW().zzk().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final Boolean zzaO(zzh zzhVar) {
        try {
            long jZzt = zzhVar.zzt();
            zzic zzicVar = this.zzn;
            if (jZzt != -2147483648L) {
                if (zzhVar.zzt() == Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionName;
                String strZzr = zzhVar.zzr();
                if (strZzr != null && strZzr.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr zzaP(String str) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu == null || TextUtils.isEmpty(zzhVarZzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzaO = zzaO(zzhVarZzu);
        if (boolZzaO == null || boolZzaO.booleanValue()) {
            return new zzr(str, zzhVarZzu.zzf(), zzhVarZzu.zzr(), zzhVarZzu.zzt(), zzhVarZzu.zzv(), zzhVarZzu.zzx(), zzhVarZzu.zzz(), (String) null, zzhVarZzu.zzD(), false, zzhVarZzu.zzl(), 0L, 0, zzhVarZzu.zzac(), false, zzhVarZzu.zzae(), zzhVarZzu.zzB(), zzhVarZzu.zzag(), zzB(str).zzl(), "", (String) null, zzhVarZzu.zzai(), zzhVarZzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzhVarZzu.zzao(), zzhVarZzu.zzaw(), zzhVarZzu.zzay(), zzhVarZzu.zzaH(), 0L, zzhVarZzu.zzaL(), 0L);
        }
        zzaW().zzb().zzb("App version does not match; dropping. appId", zzgu.zzl(str));
        return null;
    }

    private final boolean zzaQ(String str, String str2) {
        zzbd zzbdVarZzf = zzj().zzf(str, str2);
        return zzbdVarZzf == null || zzbdVarZzf.zzc < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaR(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean zzaS(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    private static final zzos zzaT(zzos zzosVar) {
        if (zzosVar == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Upload Component not created");
            return null;
        }
        if (zzosVar.zzax()) {
            return zzosVar;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Component not initialized: ".concat(String.valueOf(zzosVar.getClass())));
        return null;
    }

    private static final Boolean zzaU(zzr zzrVar) {
        Boolean bool = zzrVar.zzp;
        String str = zzrVar.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzji zzjiVarZza = zze.zzc(str).zza();
            zzji zzjiVar = zzji.UNINITIALIZED;
            int iOrdinal = zzjiVarZza.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return Boolean.TRUE;
            }
            if (iOrdinal == 3) {
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    public final void zzA(String str, zzjl zzjlVar) {
        zzaX().zzg();
        zzu();
        this.zzC.put(str, zzjlVar);
        zzj().zzaa(str, zzjlVar);
    }

    public final zzjl zzB(String str) {
        zzjl zzjlVar = zzjl.zza;
        zzaX().zzg();
        zzu();
        zzjl zzjlVarZzY = (zzjl) this.zzC.get(str);
        if (zzjlVarZzY == null) {
            zzjlVarZzY = zzj().zzY(str);
            if (zzjlVarZzY == null) {
                zzjlVarZzY = zzjl.zza;
            }
            zzA(str, zzjlVarZzY);
        }
        return zzjlVarZzY;
    }

    public final long zzC() {
        long jCurrentTimeMillis = zzba().currentTimeMillis();
        zznn zznnVar = this.zzk;
        zznnVar.zzay();
        zznnVar.zzg();
        zzhe zzheVar = zznnVar.zzf;
        long jZza = zzheVar.zza();
        if (jZza == 0) {
            jZza = ((long) zznnVar.zzu.zzk().zzf().nextInt(86400000)) + 1;
            zzheVar.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    public final void zzD(zzbh zzbhVar, String str) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu == null || TextUtils.isEmpty(zzhVarZzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzaO = zzaO(zzhVarZzu);
        if (boolZzaO == null) {
            if (!"_ui".equals(zzbhVar.zza)) {
                zzaW().zze().zzb("Could not find package. appId", zzgu.zzl(str));
            }
        } else if (!boolZzaO.booleanValue()) {
            zzaW().zzb().zzb("App version does not match; dropping event. appId", zzgu.zzl(str));
            return;
        }
        zzE(zzbhVar, new zzr(str, zzhVarZzu.zzf(), zzhVarZzu.zzr(), zzhVarZzu.zzt(), zzhVarZzu.zzv(), zzhVarZzu.zzx(), zzhVarZzu.zzz(), (String) null, zzhVarZzu.zzD(), false, zzhVarZzu.zzl(), 0L, 0, zzhVarZzu.zzac(), false, zzhVarZzu.zzae(), zzhVarZzu.zzB(), zzhVarZzu.zzag(), zzB(str).zzl(), "", (String) null, zzhVarZzu.zzai(), zzhVarZzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzhVarZzu.zzao(), zzhVarZzu.zzaw(), zzhVarZzu.zzay(), zzhVarZzu.zzaH(), 0L, zzhVarZzu.zzaL(), 0L));
    }

    public final void zzE(zzbh zzbhVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgv zzgvVarZza = zzgv.zza(zzbhVar);
        zzt().zzK(zzgvVarZza.zze, zzj().zzV(str));
        zzt().zzI(zzgvVarZza, zzd().zzd(str));
        zzbh zzbhVarZzb = zzgvVarZza.zzb();
        if (!zzd().zzp(null, zzfy.zzaZ) && "_cmp".equals(zzbhVarZzb.zza)) {
            zzbf zzbfVar = zzbhVarZzb.zzb;
            if ("referrer API v2".equals(zzbfVar.zzd("_cis"))) {
                String strZzd = zzbfVar.zzd("gclid");
                if (!TextUtils.isEmpty(strZzd)) {
                    zzad(new zzpl("_lgclid", zzbhVarZzb.zzd, strZzd, "auto"), zzrVar);
                }
            }
        }
        zzF(zzbhVarZzb, zzrVar);
    }

    public final void zzF(zzbh zzbhVar, zzr zzrVar) {
        long j;
        List<zzah> listZzt;
        List listZzt2;
        List<zzah> listZzt3;
        long j2;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        zzu();
        long j3 = zzbhVar.zzd;
        long j4 = zzbhVar.zze;
        zzgv zzgvVarZza = zzgv.zza(zzbhVar);
        zzaX().zzg();
        zzlu zzluVar = this.zzG;
        if (zzluVar == null || (str = this.zzH) == null || !str.equals(str2)) {
            zzluVar = null;
        }
        zzpp.zzay(zzluVar, zzgvVarZza.zze, false);
        zzbh zzbhVarZzb = zzgvVarZza.zzb();
        zzp();
        if (zzpk.zzG(zzbhVarZzb, zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            List list = zzrVar.zzr;
            if (list != null) {
                String str3 = zzbhVarZzb.zza;
                if (!list.contains(str3)) {
                    zzaW().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, str3, zzbhVarZzb.zzc);
                    return;
                }
                Bundle bundleZzf = zzbhVarZzb.zzb.zzf();
                j = j3;
                bundleZzf.putLong("ga_safelisted", 1L);
                zzbhVarZzb = new zzbh(str3, new zzbf(bundleZzf), zzbhVarZzb.zzc, zzbhVarZzb.zzd, zzbhVarZzb.zze);
            } else {
                j = j3;
            }
            zzj().zzb();
            try {
                String str4 = zzbhVarZzb.zza;
                if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzbhVarZzb.zzb.zzb("_sid").longValue() != 0) {
                    if (zzj().zzQ(str2, "_f") || zzj().zzQ(str2, "_v")) {
                        zzj().zzX(str2, null, "_sid", zzG(str2, zzbhVarZzb));
                    } else {
                        zzj().zzX(str2, Long.valueOf(zzba().currentTimeMillis() - 15000), "_sid", zzG(str2, zzbhVarZzb));
                    }
                }
                zzaw zzawVarZzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzawVarZzj.zzg();
                zzawVarZzj.zzay();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    zzawVarZzj.zzu.zzaW().zze().zzc("Invalid time querying timed out conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    listZzt = Collections.EMPTY_LIST;
                } else {
                    listZzt = zzawVarZzj.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzah zzahVar : listZzt) {
                    if (zzahVar != null) {
                        zzaW().zzk().zzd("User property timed out", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb), zzahVar.zzc.zza());
                        zzbh zzbhVar2 = zzahVar.zzg;
                        if (zzbhVar2 != null) {
                            j2 = j;
                            zzH(new zzbh(zzbhVar2, j2, j4), zzrVar);
                        } else {
                            j2 = j;
                        }
                        zzj().zzr(str2, zzahVar.zzc.zzb);
                        j = j2;
                    }
                }
                long j5 = j;
                zzaw zzawVarZzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzawVarZzj2.zzg();
                zzawVarZzj2.zzay();
                if (i < 0) {
                    zzawVarZzj2.zzu.zzaW().zze().zzc("Invalid time querying expired conditional properties", zzgu.zzl(str2), Long.valueOf(j5));
                    listZzt2 = Collections.EMPTY_LIST;
                } else {
                    listZzt2 = zzawVarZzj2.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j5)});
                }
                ArrayList arrayList = new ArrayList(listZzt2.size());
                Iterator it = listZzt2.iterator();
                while (it.hasNext()) {
                    zzah zzahVar2 = (zzah) it.next();
                    if (zzahVar2 != null) {
                        Iterator it2 = it;
                        int i2 = i;
                        zzaW().zzk().zzd("User property expired", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                        zzj().zzk(str2, zzahVar2.zzc.zzb);
                        zzbh zzbhVar3 = zzahVar2.zzk;
                        if (zzbhVar3 != null) {
                            arrayList.add(zzbhVar3);
                        }
                        zzj().zzr(str2, zzahVar2.zzc.zzb);
                        it = it2;
                        i = i2;
                    }
                }
                int i3 = i;
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    zzH(new zzbh((zzbh) it3.next(), j5, j4), zzrVar);
                    j4 = j4;
                }
                long j6 = j4;
                zzaw zzawVarZzj3 = zzj();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzawVarZzj3.zzg();
                zzawVarZzj3.zzay();
                if (i3 < 0) {
                    zzic zzicVar = zzawVarZzj3.zzu;
                    zzicVar.zzaW().zze().zzd("Invalid time querying triggered conditional properties", zzgu.zzl(str2), zzicVar.zzl().zza(str4), Long.valueOf(j5));
                    listZzt3 = Collections.EMPTY_LIST;
                } else {
                    listZzt3 = zzawVarZzj3.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j5)});
                }
                ArrayList arrayList2 = new ArrayList(listZzt3.size());
                for (zzah zzahVar3 : listZzt3) {
                    if (zzahVar3 != null) {
                        zzpl zzplVar = zzahVar3.zzc;
                        long j7 = j5;
                        zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzplVar.zzb, j7, Preconditions.checkNotNull(zzplVar.zza()));
                        j5 = j7;
                        if (zzj().zzl(zzpnVar)) {
                            zzaW().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        } else {
                            zzaW().zzb().zzd("Too many active user properties, ignoring", zzgu.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        }
                        zzbh zzbhVar4 = zzahVar3.zzi;
                        if (zzbhVar4 != null) {
                            arrayList2.add(zzbhVar4);
                        }
                        zzahVar3.zzc = new zzpl(zzpnVar);
                        zzahVar3.zze = true;
                        zzj().zzp(zzahVar3);
                    }
                }
                zzH(zzbhVarZzb, zzrVar);
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    long j8 = j6;
                    zzH(new zzbh((zzbh) it4.next(), j5, j8), zzrVar);
                    j6 = j8;
                }
                zzj().zzc();
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    public final Bundle zzG(String str, zzbh zzbhVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.zzb("_sid").longValue());
        zzpn zzpnVarZzm = zzj().zzm(str, "_sno");
        if (zzpnVarZzm != null) {
            Object obj = zzpnVarZzm.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0361 A[Catch: all -> 0x0179, TryCatch #2 {all -> 0x0179, blocks: (B:36:0x0156, B:39:0x0166, B:41:0x016f, B:47:0x017c, B:89:0x02ed, B:98:0x0320, B:100:0x0361, B:102:0x0366, B:103:0x037d, B:105:0x0388, B:107:0x03a1, B:109:0x03a6, B:110:0x03bd, B:113:0x03df, B:117:0x0402, B:118:0x0419, B:120:0x0425, B:123:0x0442, B:124:0x0456, B:126:0x045e, B:128:0x046a, B:130:0x0470, B:131:0x0477, B:132:0x0484, B:138:0x04c7, B:139:0x04dc, B:141:0x0506, B:144:0x051d, B:146:0x0527, B:149:0x0562, B:151:0x058d, B:153:0x05c5, B:154:0x05c8, B:156:0x05d0, B:157:0x05d3, B:159:0x05db, B:160:0x05de, B:162:0x05e6, B:163:0x05e9, B:165:0x05f2, B:166:0x05f6, B:168:0x0604, B:169:0x0607, B:171:0x0639, B:173:0x0643, B:177:0x065a, B:182:0x0667, B:215:0x06de, B:217:0x06e4, B:218:0x06e7, B:220:0x06fb, B:221:0x0705, B:223:0x0712, B:225:0x071c, B:226:0x071f, B:228:0x073b, B:230:0x073f, B:233:0x0753, B:235:0x075e, B:236:0x0767, B:238:0x0773, B:240:0x077f, B:242:0x0789, B:244:0x078f, B:246:0x07a1, B:248:0x07bf, B:250:0x07c5, B:251:0x07ce, B:254:0x07e3, B:256:0x081d, B:258:0x0827, B:259:0x082a, B:261:0x0834, B:263:0x0850, B:264:0x0859, B:266:0x088f, B:268:0x0897, B:270:0x08a1, B:271:0x08ae, B:273:0x08b8, B:274:0x08c5, B:275:0x08ce, B:277:0x08d4, B:279:0x0910, B:281:0x091a, B:283:0x092c, B:287:0x0937, B:288:0x097c, B:289:0x0988, B:290:0x0995, B:292:0x099b, B:301:0x09e6, B:302:0x0a3e, B:304:0x0a4f, B:318:0x0ab0, B:309:0x0a67, B:310:0x0a6a, B:295:0x09a7, B:297:0x09d3, B:315:0x0a83, B:316:0x0a9a, B:317:0x0a9b, B:185:0x0670, B:189:0x067d, B:193:0x068b, B:197:0x0699, B:201:0x06a7, B:205:0x06b5, B:209:0x06c1, B:213:0x06cf, B:150:0x057f, B:135:0x04ae, B:92:0x0301, B:93:0x0308, B:95:0x030e, B:97:0x031a, B:53:0x0190, B:56:0x01a1, B:58:0x01b6, B:64:0x01d2, B:69:0x0206, B:71:0x020c, B:73:0x021a, B:75:0x0228, B:78:0x0238, B:86:0x02b6, B:88:0x02c0, B:80:0x025d, B:81:0x0276, B:85:0x029e, B:84:0x028a, B:67:0x01de, B:68:0x01fc), top: B:327:0x0156, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x07e0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018c A[PHI: r27 r28
      0x018c: PHI (r27v2 java.lang.String) = (r27v0 java.lang.String), (r27v0 java.lang.String), (r27v3 java.lang.String) binds: [B:70:0x020a, B:72:0x0218, B:51:0x0188] A[DONT_GENERATE, DONT_INLINE]
      0x018c: PHI (r28v6 java.lang.String) = (r28v1 java.lang.String), (r28v1 java.lang.String), (r28v7 java.lang.String) binds: [B:70:0x020a, B:72:0x0218, B:51:0x0188] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a1 A[Catch: all -> 0x0179, TRY_ENTER, TryCatch #2 {all -> 0x0179, blocks: (B:36:0x0156, B:39:0x0166, B:41:0x016f, B:47:0x017c, B:89:0x02ed, B:98:0x0320, B:100:0x0361, B:102:0x0366, B:103:0x037d, B:105:0x0388, B:107:0x03a1, B:109:0x03a6, B:110:0x03bd, B:113:0x03df, B:117:0x0402, B:118:0x0419, B:120:0x0425, B:123:0x0442, B:124:0x0456, B:126:0x045e, B:128:0x046a, B:130:0x0470, B:131:0x0477, B:132:0x0484, B:138:0x04c7, B:139:0x04dc, B:141:0x0506, B:144:0x051d, B:146:0x0527, B:149:0x0562, B:151:0x058d, B:153:0x05c5, B:154:0x05c8, B:156:0x05d0, B:157:0x05d3, B:159:0x05db, B:160:0x05de, B:162:0x05e6, B:163:0x05e9, B:165:0x05f2, B:166:0x05f6, B:168:0x0604, B:169:0x0607, B:171:0x0639, B:173:0x0643, B:177:0x065a, B:182:0x0667, B:215:0x06de, B:217:0x06e4, B:218:0x06e7, B:220:0x06fb, B:221:0x0705, B:223:0x0712, B:225:0x071c, B:226:0x071f, B:228:0x073b, B:230:0x073f, B:233:0x0753, B:235:0x075e, B:236:0x0767, B:238:0x0773, B:240:0x077f, B:242:0x0789, B:244:0x078f, B:246:0x07a1, B:248:0x07bf, B:250:0x07c5, B:251:0x07ce, B:254:0x07e3, B:256:0x081d, B:258:0x0827, B:259:0x082a, B:261:0x0834, B:263:0x0850, B:264:0x0859, B:266:0x088f, B:268:0x0897, B:270:0x08a1, B:271:0x08ae, B:273:0x08b8, B:274:0x08c5, B:275:0x08ce, B:277:0x08d4, B:279:0x0910, B:281:0x091a, B:283:0x092c, B:287:0x0937, B:288:0x097c, B:289:0x0988, B:290:0x0995, B:292:0x099b, B:301:0x09e6, B:302:0x0a3e, B:304:0x0a4f, B:318:0x0ab0, B:309:0x0a67, B:310:0x0a6a, B:295:0x09a7, B:297:0x09d3, B:315:0x0a83, B:316:0x0a9a, B:317:0x0a9b, B:185:0x0670, B:189:0x067d, B:193:0x068b, B:197:0x0699, B:201:0x06a7, B:205:0x06b5, B:209:0x06c1, B:213:0x06cf, B:150:0x057f, B:135:0x04ae, B:92:0x0301, B:93:0x0308, B:95:0x030e, B:97:0x031a, B:53:0x0190, B:56:0x01a1, B:58:0x01b6, B:64:0x01d2, B:69:0x0206, B:71:0x020c, B:73:0x021a, B:75:0x0228, B:78:0x0238, B:86:0x02b6, B:88:0x02c0, B:80:0x025d, B:81:0x0276, B:85:0x029e, B:84:0x028a, B:67:0x01de, B:68:0x01fc), top: B:327:0x0156, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fc A[Catch: all -> 0x0179, TryCatch #2 {all -> 0x0179, blocks: (B:36:0x0156, B:39:0x0166, B:41:0x016f, B:47:0x017c, B:89:0x02ed, B:98:0x0320, B:100:0x0361, B:102:0x0366, B:103:0x037d, B:105:0x0388, B:107:0x03a1, B:109:0x03a6, B:110:0x03bd, B:113:0x03df, B:117:0x0402, B:118:0x0419, B:120:0x0425, B:123:0x0442, B:124:0x0456, B:126:0x045e, B:128:0x046a, B:130:0x0470, B:131:0x0477, B:132:0x0484, B:138:0x04c7, B:139:0x04dc, B:141:0x0506, B:144:0x051d, B:146:0x0527, B:149:0x0562, B:151:0x058d, B:153:0x05c5, B:154:0x05c8, B:156:0x05d0, B:157:0x05d3, B:159:0x05db, B:160:0x05de, B:162:0x05e6, B:163:0x05e9, B:165:0x05f2, B:166:0x05f6, B:168:0x0604, B:169:0x0607, B:171:0x0639, B:173:0x0643, B:177:0x065a, B:182:0x0667, B:215:0x06de, B:217:0x06e4, B:218:0x06e7, B:220:0x06fb, B:221:0x0705, B:223:0x0712, B:225:0x071c, B:226:0x071f, B:228:0x073b, B:230:0x073f, B:233:0x0753, B:235:0x075e, B:236:0x0767, B:238:0x0773, B:240:0x077f, B:242:0x0789, B:244:0x078f, B:246:0x07a1, B:248:0x07bf, B:250:0x07c5, B:251:0x07ce, B:254:0x07e3, B:256:0x081d, B:258:0x0827, B:259:0x082a, B:261:0x0834, B:263:0x0850, B:264:0x0859, B:266:0x088f, B:268:0x0897, B:270:0x08a1, B:271:0x08ae, B:273:0x08b8, B:274:0x08c5, B:275:0x08ce, B:277:0x08d4, B:279:0x0910, B:281:0x091a, B:283:0x092c, B:287:0x0937, B:288:0x097c, B:289:0x0988, B:290:0x0995, B:292:0x099b, B:301:0x09e6, B:302:0x0a3e, B:304:0x0a4f, B:318:0x0ab0, B:309:0x0a67, B:310:0x0a6a, B:295:0x09a7, B:297:0x09d3, B:315:0x0a83, B:316:0x0a9a, B:317:0x0a9b, B:185:0x0670, B:189:0x067d, B:193:0x068b, B:197:0x0699, B:201:0x06a7, B:205:0x06b5, B:209:0x06c1, B:213:0x06cf, B:150:0x057f, B:135:0x04ae, B:92:0x0301, B:93:0x0308, B:95:0x030e, B:97:0x031a, B:53:0x0190, B:56:0x01a1, B:58:0x01b6, B:64:0x01d2, B:69:0x0206, B:71:0x020c, B:73:0x021a, B:75:0x0228, B:78:0x0238, B:86:0x02b6, B:88:0x02c0, B:80:0x025d, B:81:0x0276, B:85:0x029e, B:84:0x028a, B:67:0x01de, B:68:0x01fc), top: B:327:0x0156, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020c A[Catch: all -> 0x0179, TryCatch #2 {all -> 0x0179, blocks: (B:36:0x0156, B:39:0x0166, B:41:0x016f, B:47:0x017c, B:89:0x02ed, B:98:0x0320, B:100:0x0361, B:102:0x0366, B:103:0x037d, B:105:0x0388, B:107:0x03a1, B:109:0x03a6, B:110:0x03bd, B:113:0x03df, B:117:0x0402, B:118:0x0419, B:120:0x0425, B:123:0x0442, B:124:0x0456, B:126:0x045e, B:128:0x046a, B:130:0x0470, B:131:0x0477, B:132:0x0484, B:138:0x04c7, B:139:0x04dc, B:141:0x0506, B:144:0x051d, B:146:0x0527, B:149:0x0562, B:151:0x058d, B:153:0x05c5, B:154:0x05c8, B:156:0x05d0, B:157:0x05d3, B:159:0x05db, B:160:0x05de, B:162:0x05e6, B:163:0x05e9, B:165:0x05f2, B:166:0x05f6, B:168:0x0604, B:169:0x0607, B:171:0x0639, B:173:0x0643, B:177:0x065a, B:182:0x0667, B:215:0x06de, B:217:0x06e4, B:218:0x06e7, B:220:0x06fb, B:221:0x0705, B:223:0x0712, B:225:0x071c, B:226:0x071f, B:228:0x073b, B:230:0x073f, B:233:0x0753, B:235:0x075e, B:236:0x0767, B:238:0x0773, B:240:0x077f, B:242:0x0789, B:244:0x078f, B:246:0x07a1, B:248:0x07bf, B:250:0x07c5, B:251:0x07ce, B:254:0x07e3, B:256:0x081d, B:258:0x0827, B:259:0x082a, B:261:0x0834, B:263:0x0850, B:264:0x0859, B:266:0x088f, B:268:0x0897, B:270:0x08a1, B:271:0x08ae, B:273:0x08b8, B:274:0x08c5, B:275:0x08ce, B:277:0x08d4, B:279:0x0910, B:281:0x091a, B:283:0x092c, B:287:0x0937, B:288:0x097c, B:289:0x0988, B:290:0x0995, B:292:0x099b, B:301:0x09e6, B:302:0x0a3e, B:304:0x0a4f, B:318:0x0ab0, B:309:0x0a67, B:310:0x0a6a, B:295:0x09a7, B:297:0x09d3, B:315:0x0a83, B:316:0x0a9a, B:317:0x0a9b, B:185:0x0670, B:189:0x067d, B:193:0x068b, B:197:0x0699, B:201:0x06a7, B:205:0x06b5, B:209:0x06c1, B:213:0x06cf, B:150:0x057f, B:135:0x04ae, B:92:0x0301, B:93:0x0308, B:95:0x030e, B:97:0x031a, B:53:0x0190, B:56:0x01a1, B:58:0x01b6, B:64:0x01d2, B:69:0x0206, B:71:0x020c, B:73:0x021a, B:75:0x0228, B:78:0x0238, B:86:0x02b6, B:88:0x02c0, B:80:0x025d, B:81:0x0276, B:85:0x029e, B:84:0x028a, B:67:0x01de, B:68:0x01fc), top: B:327:0x0156, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0301 A[Catch: all -> 0x0179, TryCatch #2 {all -> 0x0179, blocks: (B:36:0x0156, B:39:0x0166, B:41:0x016f, B:47:0x017c, B:89:0x02ed, B:98:0x0320, B:100:0x0361, B:102:0x0366, B:103:0x037d, B:105:0x0388, B:107:0x03a1, B:109:0x03a6, B:110:0x03bd, B:113:0x03df, B:117:0x0402, B:118:0x0419, B:120:0x0425, B:123:0x0442, B:124:0x0456, B:126:0x045e, B:128:0x046a, B:130:0x0470, B:131:0x0477, B:132:0x0484, B:138:0x04c7, B:139:0x04dc, B:141:0x0506, B:144:0x051d, B:146:0x0527, B:149:0x0562, B:151:0x058d, B:153:0x05c5, B:154:0x05c8, B:156:0x05d0, B:157:0x05d3, B:159:0x05db, B:160:0x05de, B:162:0x05e6, B:163:0x05e9, B:165:0x05f2, B:166:0x05f6, B:168:0x0604, B:169:0x0607, B:171:0x0639, B:173:0x0643, B:177:0x065a, B:182:0x0667, B:215:0x06de, B:217:0x06e4, B:218:0x06e7, B:220:0x06fb, B:221:0x0705, B:223:0x0712, B:225:0x071c, B:226:0x071f, B:228:0x073b, B:230:0x073f, B:233:0x0753, B:235:0x075e, B:236:0x0767, B:238:0x0773, B:240:0x077f, B:242:0x0789, B:244:0x078f, B:246:0x07a1, B:248:0x07bf, B:250:0x07c5, B:251:0x07ce, B:254:0x07e3, B:256:0x081d, B:258:0x0827, B:259:0x082a, B:261:0x0834, B:263:0x0850, B:264:0x0859, B:266:0x088f, B:268:0x0897, B:270:0x08a1, B:271:0x08ae, B:273:0x08b8, B:274:0x08c5, B:275:0x08ce, B:277:0x08d4, B:279:0x0910, B:281:0x091a, B:283:0x092c, B:287:0x0937, B:288:0x097c, B:289:0x0988, B:290:0x0995, B:292:0x099b, B:301:0x09e6, B:302:0x0a3e, B:304:0x0a4f, B:318:0x0ab0, B:309:0x0a67, B:310:0x0a6a, B:295:0x09a7, B:297:0x09d3, B:315:0x0a83, B:316:0x0a9a, B:317:0x0a9b, B:185:0x0670, B:189:0x067d, B:193:0x068b, B:197:0x0699, B:201:0x06a7, B:205:0x06b5, B:209:0x06c1, B:213:0x06cf, B:150:0x057f, B:135:0x04ae, B:92:0x0301, B:93:0x0308, B:95:0x030e, B:97:0x031a, B:53:0x0190, B:56:0x01a1, B:58:0x01b6, B:64:0x01d2, B:69:0x0206, B:71:0x020c, B:73:0x021a, B:75:0x0228, B:78:0x0238, B:86:0x02b6, B:88:0x02c0, B:80:0x025d, B:81:0x0276, B:85:0x029e, B:84:0x028a, B:67:0x01de, B:68:0x01fc), top: B:327:0x0156, inners: #0, #1, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzH(zzbh zzbhVar, zzr zzrVar) {
        String strZzd;
        String str;
        String str2;
        long jLongValue;
        zzbh zzbhVar2;
        zzpn zzpnVar;
        zzbf zzbfVar;
        long length;
        long jZzH;
        long j;
        int i;
        long jDelete;
        zzbc zzbcVar;
        zzbd zzbdVar;
        long j2;
        zzbc zzbcVar2;
        String str3;
        zzjk zzjkVar;
        long j3;
        int i2;
        int i3;
        String str4;
        boolean z;
        zzh zzhVarZzu;
        List listZzm;
        zzpn zzpnVarZzm;
        Preconditions.checkNotNull(zzrVar);
        String str5 = zzrVar.zza;
        Preconditions.checkNotEmpty(str5);
        long jNanoTime = System.nanoTime();
        zzaX().zzg();
        zzu();
        zzp();
        if (zzpk.zzG(zzbhVar, zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzht zzhtVarZzh = zzh();
            String str6 = zzbhVar.zza;
            if (zzhtVarZzh.zzj(str5, str6)) {
                zzaW().zze().zzc("Dropping blocked event. appId", zzgu.zzl(str5), this.zzn.zzl().zza(str6));
                if (!zzh().zzo(str5) && !zzh().zzp(str5)) {
                    if ("_err".equals(str6)) {
                        return;
                    }
                    zzt().zzP(this.zzK, str5, 11, "_ev", str6, 0);
                    return;
                }
                zzh zzhVarZzu2 = zzj().zzu(str5);
                if (zzhVarZzu2 != null) {
                    long jAbs = Math.abs(zzba().currentTimeMillis() - Math.max(zzhVarZzu2.zzJ(), zzhVarZzu2.zzH()));
                    zzd();
                    if (jAbs > ((Long) zzfy.zzN.zzb(null)).longValue()) {
                        zzaW().zzj().zza("Fetching config for blocked app");
                        zzX(zzhVarZzu2);
                        return;
                    }
                    return;
                }
                return;
            }
            zzgv zzgvVarZza = zzgv.zza(zzbhVar);
            zzt().zzI(zzgvVarZza, zzd().zzd(str5));
            int iZzn = zzd().zzn(str5, zzfy.zzaf, 10, 35);
            Bundle bundle = zzgvVarZza.zze;
            for (String str7 : new TreeSet(bundle.keySet())) {
                if ("items".equals(str7)) {
                    zzt().zzJ(bundle.getParcelableArray(str7), iZzn);
                }
            }
            zzbh zzbhVarZzb = zzgvVarZza.zzb();
            if (Log.isLoggable(zzaW().zzn(), 2)) {
                zzaW().zzk().zzb("Logging event", this.zzn.zzl().zzd(zzbhVarZzb));
            }
            zzj().zzb();
            try {
                zzap(zzrVar);
                String str8 = zzbhVarZzb.zza;
                boolean z2 = "ecommerce_purchase".equals(str8) || "purchase".equals(str8) || "refund".equals(str8);
                if ("_iap".equals(str8)) {
                    zzbf zzbfVar2 = zzbhVarZzb.zzb;
                    strZzd = zzbfVar2.zzd("currency");
                    str = "metadata_fingerprint";
                    if (z2) {
                        str2 = "app_id";
                        jLongValue = zzbfVar2.zzb(SDKConstants.PARAM_VALUE).longValue();
                    } else {
                        double dDoubleValue = zzbfVar2.zzc(SDKConstants.PARAM_VALUE).doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            str2 = "app_id";
                            dDoubleValue = zzbfVar2.zzb(SDKConstants.PARAM_VALUE).longValue() * 1000000.0d;
                        } else {
                            str2 = "app_id";
                        }
                        if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            zzaW().zze().zzc("Data lost. Currency value is too big. appId", zzgu.zzl(str5), Double.valueOf(dDoubleValue));
                            zzj().zzc();
                        } else {
                            jLongValue = Math.round(dDoubleValue);
                            if ("refund".equals(str8)) {
                                jLongValue = -jLongValue;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(strZzd)) {
                        String upperCase = strZzd.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String strConcat = "_ltv_".concat(upperCase);
                            zzpn zzpnVarZzm2 = zzj().zzm(str5, strConcat);
                            if (zzpnVarZzm2 != null) {
                                Object obj = zzpnVarZzm2.zze;
                                if (obj instanceof Long) {
                                    zzbhVar2 = zzbhVarZzb;
                                    zzpnVar = new zzpn(str5, zzbhVarZzb.zzc, strConcat, zzba().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + jLongValue));
                                    str5 = str5;
                                } else {
                                    long j4 = jLongValue;
                                    zzbhVar2 = zzbhVarZzb;
                                    zzaw zzawVarZzj = zzj();
                                    int iZzm = zzd().zzm(str5, zzfy.zzT) - 1;
                                    Preconditions.checkNotEmpty(str5);
                                    zzawVarZzj.zzg();
                                    zzawVarZzj.zzay();
                                    try {
                                        zzawVarZzj.zze().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str5, str5, String.valueOf(iZzm)});
                                    } catch (SQLiteException e) {
                                        zzawVarZzj.zzu.zzaW().zzb().zzc("Error pruning currencies. appId", zzgu.zzl(str5), e);
                                    }
                                    zzpnVar = new zzpn(str5, zzbhVar2.zzc, strConcat, zzba().currentTimeMillis(), Long.valueOf(j4));
                                    str5 = str5;
                                }
                                zzpn zzpnVar2 = zzpnVar;
                                if (!zzj().zzl(zzpnVar2)) {
                                    zzaW().zzb().zzd("Too many unique user properties are set. Ignoring user property. appId", zzgu.zzl(str5), this.zzn.zzl().zzc(zzpnVar2.zzc), zzpnVar2.zze);
                                    zzt().zzP(this.zzK, str5, 9, null, null, 0);
                                }
                            }
                        } else {
                            zzbhVar2 = zzbhVarZzb;
                        }
                        String str9 = zzbhVar2.zza;
                        boolean zZzh = zzpp.zzh(str9);
                        boolean zEquals = "_err".equals(str9);
                        zzt();
                        zzbfVar = zzbhVar2.zzb;
                        if (zzbfVar != null) {
                            length = 0;
                        } else {
                            zzbe zzbeVar = new zzbe(zzbfVar);
                            length = 0;
                            while (zzbeVar.hasNext()) {
                                Object objZza = zzbfVar.zza(zzbeVar.next());
                                if (objZza instanceof Parcelable[]) {
                                    length += (long) ((Parcelable[]) objZza).length;
                                }
                            }
                        }
                        String str10 = str5;
                        zzbh zzbhVar3 = zzbhVar2;
                        zzar zzarVarZzx = zzj().zzx(zzC(), str10, length + 1, true, zZzh, false, zEquals, false, false, false);
                        long j5 = zzarVarZzx.zzb;
                        zzd();
                        jZzH = j5 - zzal.zzH();
                        if (jZzH <= 0) {
                            if (jZzH % 1000 == 1) {
                                zzaW().zzb().zzc("Data loss. Too many events logged. appId, count", zzgu.zzl(str10), Long.valueOf(zzarVarZzx.zzb));
                            }
                            zzj().zzc();
                        } else if (zZzh) {
                            long j6 = zzarVarZzx.zza;
                            zzd();
                            long jIntValue = j6 - ((long) ((Integer) zzfy.zzm.zzb(null)).intValue());
                            if (jIntValue <= 0) {
                                if (zEquals) {
                                    j = 1;
                                    i = 0;
                                    long jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(1000000, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                                    if (jMax > 0) {
                                        if (jMax == 1) {
                                            zzaW().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str10), Long.valueOf(zzarVarZzx.zzd));
                                        }
                                        zzj().zzc();
                                    }
                                } else {
                                    j = 1;
                                    i = 0;
                                }
                                Bundle bundleZzf = zzbfVar.zzf();
                                zzt().zzO(bundleZzf, "_o", zzbhVar3.zzc);
                                if (zzt().zzad(str10, zzrVar.zzB)) {
                                    zzpp zzppVarZzt = zzt();
                                    Long lValueOf = Long.valueOf(j);
                                    zzppVarZzt.zzO(bundleZzf, "_dbg", lValueOf);
                                    zzt().zzO(bundleZzf, "_r", lValueOf);
                                }
                                if ("_s".equals(str9) && (zzpnVarZzm = zzj().zzm(zzrVar.zza, "_sno")) != null) {
                                    Object obj2 = zzpnVarZzm.zze;
                                    if (obj2 instanceof Long) {
                                        zzt().zzO(bundleZzf, "_sno", obj2);
                                    }
                                }
                                zzaw zzawVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str10);
                                zzawVarZzj2.zzg();
                                zzawVarZzj2.zzay();
                                try {
                                    jDelete = zzawVarZzj2.zze().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str10, String.valueOf(Math.max(i, Math.min(1000000, zzawVarZzj2.zzu.zzc().zzm(str10, zzfy.zzp))))});
                                } catch (SQLiteException e2) {
                                    zzawVarZzj2.zzu.zzaW().zzb().zzc("Error deleting over the limit events. appId", zzgu.zzl(str10), e2);
                                    jDelete = 0;
                                }
                                if (jDelete > 0) {
                                    zzaW().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str10), Long.valueOf(jDelete));
                                }
                                zzic zzicVar = this.zzn;
                                zzbc zzbcVar3 = new zzbc(zzicVar, zzbhVar3.zzc, str10, zzbhVar3.zza, zzbhVar3.zzd, zzbhVar3.zze, 0L, bundleZzf);
                                zzaw zzawVarZzj3 = zzj();
                                String str11 = zzbcVar3.zzb;
                                zzbd zzbdVarZzf = zzawVarZzj3.zzf(str10, str11);
                                if (zzbdVarZzf != null) {
                                    zzbc zzbcVarZza = zzbcVar3.zza(zzicVar, zzbdVarZzf.zzf);
                                    zzbd zzbdVarZza = zzbdVarZzf.zza(zzbcVarZza.zzd);
                                    zzbcVar = zzbcVarZza;
                                    zzbdVar = zzbdVarZza;
                                } else if (zzj().zzT(str10) < zzd().zzh(str10) || !zZzh || zzt().zzq(str11)) {
                                    zzbdVar = new zzbd(str10, str11, 0L, 0L, 0L, zzbcVar3.zzd, 0L, null, null, null, null);
                                    zzbcVar = zzbcVar3;
                                } else {
                                    zzaW().zzb().zzd("Too many event names used, ignoring event. appId, name, supported count", zzgu.zzl(str10), zzicVar.zzl().zza(str11), Integer.valueOf(zzd().zzh(str10)));
                                    zzt().zzP(this.zzK, str10, 8, null, null, 0);
                                }
                                zzj().zzh(zzbdVar);
                                zzaX().zzg();
                                zzu();
                                Preconditions.checkNotNull(zzbcVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str12 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str12);
                                String str13 = zzrVar.zza;
                                Preconditions.checkArgument(str12.equals(str13));
                                com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                zzicVarZzaE.zza(1);
                                zzicVarZzaE.zzC("android");
                                if (!TextUtils.isEmpty(str13)) {
                                    zzicVarZzaE.zzL(str13);
                                }
                                String str14 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str14)) {
                                    zzicVarZzaE.zzJ(str14);
                                }
                                String str15 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str15)) {
                                    zzicVarZzaE.zzM(str15);
                                }
                                String str16 = zzrVar.zzu;
                                if (!TextUtils.isEmpty(str16)) {
                                    zzicVarZzaE.zzau(str16);
                                }
                                long j7 = zzrVar.zzj;
                                if (j7 != -2147483648L) {
                                    zzicVarZzaE.zzaj((int) j7);
                                }
                                long j8 = zzrVar.zze;
                                zzicVarZzaE.zzN(j8);
                                String str17 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str17)) {
                                    zzicVarZzaE.zzad(str17);
                                }
                                zzjl zzjlVarZzB = zzB((String) Preconditions.checkNotNull(str13));
                                String str18 = zzrVar.zzs;
                                String str19 = str16;
                                zzjl zzjlVarZzs = zzjlVarZzB.zzs(zzjl.zzf(str18, 100));
                                zzicVarZzaE.zzat(zzjlVarZzs.zzk());
                                zzaif.zza();
                                if (zzd().zzp(str13, zzfy.zzaO) && zzt().zzZ(str13)) {
                                    zzicVarZzaE.zzaH(zzrVar.zzz);
                                    j2 = j8;
                                    long j9 = zzrVar.zzA;
                                    if (!zzjlVarZzs.zzo(zzjk.AD_STORAGE) && j9 != 0) {
                                        j9 = (j9 & (-2)) | 32;
                                    }
                                    zzicVarZzaE.zzaz(j9 == j);
                                    if (j9 != 0) {
                                        com.google.android.gms.internal.measurement.zzhd zzhdVarZzi = com.google.android.gms.internal.measurement.zzhe.zzi();
                                        zzhdVarZzi.zza((j9 & j) != 0);
                                        zzhdVarZzi.zzb((j9 & 2) != 0);
                                        zzhdVarZzi.zzc((j9 & 4) != 0);
                                        zzhdVarZzi.zzd((j9 & 8) != 0);
                                        zzhdVarZzi.zze((j9 & 16) != 0);
                                        zzhdVarZzi.zzf((j9 & 32) != 0);
                                        zzhdVarZzi.zzg((j9 & 64) != 0);
                                        zzicVarZzaE.zzaI((com.google.android.gms.internal.measurement.zzhe) zzhdVarZzi.zzbd());
                                    }
                                } else {
                                    j2 = j8;
                                }
                                long j10 = zzrVar.zzf;
                                if (j10 != 0) {
                                    zzicVarZzaE.zzY(j10);
                                }
                                long j11 = zzrVar.zzq;
                                zzicVarZzaE.zzar(j11);
                                if (zzd().zzp(null, zzfy.zzaU)) {
                                    zzd();
                                    zzicVarZzaE.zzaQ(zzagr.zza());
                                }
                                if (zzd().zzp(null, zzfy.zzaV) && (listZzm = zzh().zzm(str13)) != null) {
                                    zzicVarZzaE.zzaq(listZzm);
                                }
                                zzjl zzjlVarZzs2 = zzB((String) Preconditions.checkNotNull(str13)).zzs(zzjl.zzf(str18, 100));
                                zzjk zzjkVar2 = zzjk.AD_STORAGE;
                                if (zzjlVarZzs2.zzo(zzjkVar2) && (z = zzrVar.zzn)) {
                                    Pair pairZzc = this.zzk.zzc(zzrVar, zzjlVarZzs2);
                                    if (!TextUtils.isEmpty((CharSequence) pairZzc.first) && z) {
                                        zzicVarZzaE.zzQ((String) pairZzc.first);
                                        Object obj3 = pairZzc.second;
                                        if (obj3 != null) {
                                            zzicVarZzaE.zzT(((Boolean) obj3).booleanValue());
                                        }
                                        zzbcVar2 = zzbcVar;
                                        if (!zzbcVar.zzb.equals("_fx") && !((String) pairZzc.first).equals("00000000-0000-0000-0000-000000000000") && (zzhVarZzu = zzj().zzu(str13)) != null && zzhVarZzu.zzaq()) {
                                            zzR(str13, false, null, null);
                                            Bundle bundle2 = new Bundle();
                                            Long lZzas = zzhVarZzu.zzas();
                                            if (lZzas != null) {
                                                j3 = j11;
                                                str3 = str15;
                                                zzjkVar = zzjkVar2;
                                                bundle2.putLong("_pfo", Math.max(0L, lZzas.longValue()));
                                            } else {
                                                str3 = str15;
                                                zzjkVar = zzjkVar2;
                                                j3 = j11;
                                            }
                                            Long lZzau = zzhVarZzu.zzau();
                                            if (lZzau != null) {
                                                bundle2.putLong("_uwa", lZzau.longValue());
                                            }
                                            bundle2.putLong("_r", j);
                                            this.zzK.zza(str13, "_fx", bundle2);
                                        }
                                    }
                                    str3 = str15;
                                    zzjkVar = zzjkVar2;
                                    j3 = j11;
                                } else {
                                    zzbcVar2 = zzbcVar;
                                    str3 = str15;
                                    zzjkVar = zzjkVar2;
                                    j3 = j11;
                                }
                                zzicVar.zzu().zzw();
                                zzicVarZzaE.zzF(Build.MODEL);
                                zzicVar.zzu().zzw();
                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                zzicVarZzaE.zzI((int) zzicVar.zzu().zzb());
                                zzicVarZzaE.zzH(zzicVar.zzu().zzc());
                                zzicVarZzaE.zzay(zzrVar.zzw);
                                if (zzicVar.zzB()) {
                                    zzicVarZzaE.zzK();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzicVarZzaE.zzam(null);
                                    }
                                }
                                zzh zzhVarZzu3 = zzj().zzu(str13);
                                if (zzhVarZzu3 == null) {
                                    zzhVarZzu3 = new zzh(zzicVar, str13);
                                    zzhVarZzu3.zze(zzK(zzjlVarZzs2));
                                    zzhVarZzu3.zzm(zzrVar.zzk);
                                    zzhVarZzu3.zzg(str17);
                                    if (zzjlVarZzs2.zzo(zzjkVar)) {
                                        zzhVarZzu3.zzk(this.zzk.zzf(zzrVar, zzjlVarZzs2));
                                    }
                                    zzhVarZzu3.zzF(0L);
                                    zzhVarZzu3.zzo(0L);
                                    zzhVarZzu3.zzq(0L);
                                    zzhVarZzu3.zzs(str3);
                                    zzhVarZzu3.zzu(j7);
                                    zzhVarZzu3.zzw(str14);
                                    zzhVarZzu3.zzy(j2);
                                    zzhVarZzu3.zzA(j10);
                                    zzhVarZzu3.zzE(zzrVar.zzh);
                                    zzhVarZzu3.zzC(j3);
                                    i2 = 0;
                                    zzj().zzv(zzhVarZzu3, false, false);
                                } else {
                                    i2 = 0;
                                }
                                if (zzjlVarZzs2.zzo(zzjk.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzhVarZzu3.zzd())) {
                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu3.zzd()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzu3.zzl())) {
                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu3.zzl()));
                                }
                                List listZzn = zzj().zzn(str13);
                                int i4 = i2;
                                while (i4 < listZzn.size()) {
                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
                                    zzitVarZzm.zzb(((zzpn) listZzn.get(i4)).zzc);
                                    zzitVarZzm.zza(((zzpn) listZzn.get(i4)).zzd);
                                    zzp().zzc(zzitVarZzm, ((zzpn) listZzn.get(i4)).zze);
                                    zzicVarZzaE.zzp(zzitVarZzm);
                                    if (!"_sid".equals(((zzpn) listZzn.get(i4)).zzc) || zzhVarZzu3.zzam() == 0) {
                                        str4 = str19;
                                    } else {
                                        str4 = str19;
                                        if (zzp().zzu(str4) != zzhVarZzu3.zzam()) {
                                            zzicVarZzaE.zzav();
                                        }
                                    }
                                    i4++;
                                    str19 = str4;
                                }
                                try {
                                    zzaw zzawVarZzj4 = zzj();
                                    com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbd();
                                    zzawVarZzj4.zzg();
                                    zzawVarZzj4.zzay();
                                    Preconditions.checkNotNull(zzidVar);
                                    Preconditions.checkNotEmpty(zzidVar.zzA());
                                    byte[] bArrZzcd = zzidVar.zzcd();
                                    long jZzt = zzawVarZzj4.zzg.zzp().zzt(bArrZzcd);
                                    ContentValues contentValues = new ContentValues();
                                    String str20 = str2;
                                    contentValues.put(str20, zzidVar.zzA());
                                    String str21 = str;
                                    contentValues.put(str21, Long.valueOf(jZzt));
                                    contentValues.put("metadata", bArrZzcd);
                                    try {
                                        zzawVarZzj4.zze().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                                        zzaw zzawVarZzj5 = zzj();
                                        zzbc zzbcVar4 = zzbcVar2;
                                        zzbe zzbeVar2 = new zzbe(zzbcVar4.zzg);
                                        while (true) {
                                            if (zzbeVar2.hasNext()) {
                                                if ("_r".equals(zzbeVar2.next())) {
                                                    break;
                                                }
                                            } else {
                                                zzht zzhtVarZzh2 = zzh();
                                                String str22 = zzbcVar4.zza;
                                                boolean zZzk = zzhtVarZzh2.zzk(str22, zzbcVar4.zzb);
                                                zzar zzarVarZzw = zzj().zzw(zzC(), str22, false, false, false, false, false, false, false);
                                                if (!zZzk || zzarVarZzw.zze >= zzd().zzm(str22, zzfy.zzo)) {
                                                    i3 = i2;
                                                }
                                            }
                                        }
                                        i3 = 1;
                                        zzawVarZzj5.zzg();
                                        zzawVarZzj5.zzay();
                                        Preconditions.checkNotNull(zzbcVar4);
                                        String str23 = zzbcVar4.zza;
                                        Preconditions.checkNotEmpty(str23);
                                        byte[] bArrZzcd2 = zzawVarZzj5.zzg.zzp().zzh(zzbcVar4).zzcd();
                                        ContentValues contentValues2 = new ContentValues();
                                        contentValues2.put(str20, str23);
                                        contentValues2.put("name", zzbcVar4.zzb);
                                        contentValues2.put("timestamp", Long.valueOf(zzbcVar4.zzd));
                                        contentValues2.put(str21, Long.valueOf(jZzt));
                                        contentValues2.put("data", bArrZzcd2);
                                        contentValues2.put("realtime", Integer.valueOf(i3));
                                        contentValues2.put("elapsed_time", Long.valueOf(zzbcVar4.zze));
                                        try {
                                            if (zzawVarZzj5.zze().insert("raw_events", null, contentValues2) == -1) {
                                                zzawVarZzj5.zzu.zzaW().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str23));
                                            } else {
                                                this.zza = 0L;
                                            }
                                        } catch (SQLiteException e3) {
                                            zzawVarZzj5.zzu.zzaW().zzb().zzc("Error storing raw event. appId", zzgu.zzl(zzbcVar4.zza), e3);
                                        }
                                    } catch (SQLiteException e4) {
                                        zzawVarZzj4.zzu.zzaW().zzb().zzc("Error storing raw event metadata. appId", zzgu.zzl(zzidVar.zzA()), e4);
                                        throw e4;
                                    }
                                } catch (IOException e5) {
                                    zzaW().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", zzgu.zzl(zzicVarZzaE.zzK()), e5);
                                }
                                zzj().zzc();
                                zzj().zzd();
                                zzaM();
                                zzaW().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            if (jIntValue % 1000 == 1) {
                                zzaW().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgu.zzl(str10), Long.valueOf(zzarVarZzx.zza));
                            }
                            zzt().zzP(this.zzK, str10, 16, "_ev", zzbhVar3.zza, 0);
                            zzj().zzc();
                        }
                    }
                } else if (z2) {
                    z2 = true;
                    zzbf zzbfVar22 = zzbhVarZzb.zzb;
                    strZzd = zzbfVar22.zzd("currency");
                    str = "metadata_fingerprint";
                    if (z2) {
                    }
                    if (TextUtils.isEmpty(strZzd)) {
                    }
                } else {
                    str = "metadata_fingerprint";
                    str2 = "app_id";
                    zzbhVar2 = zzbhVarZzb;
                    String str92 = zzbhVar2.zza;
                    boolean zZzh2 = zzpp.zzh(str92);
                    boolean zEquals2 = "_err".equals(str92);
                    zzt();
                    zzbfVar = zzbhVar2.zzb;
                    if (zzbfVar != null) {
                    }
                    String str102 = str5;
                    zzbh zzbhVar32 = zzbhVar2;
                    zzar zzarVarZzx2 = zzj().zzx(zzC(), str102, length + 1, true, zZzh2, false, zEquals2, false, false, false);
                    long j52 = zzarVarZzx2.zzb;
                    zzd();
                    jZzH = j52 - zzal.zzH();
                    if (jZzH <= 0) {
                    }
                }
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    public final void zzI(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        zzaX().zzg();
        zzu();
        zzan zzanVarZzd = zzan.zzd(zzicVar.zzaA());
        String strZzc = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzjl zzjlVarZzB = zzB(strZzc);
        zzji zzjiVar = zzji.UNINITIALIZED;
        int iOrdinal = zzjlVarZzB.zzp().ordinal();
        if (iOrdinal == 1) {
            zzanVarZzd.zzc(zzjk.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            zzanVarZzd.zzb(zzjk.AD_STORAGE, zzjlVarZzB.zzb());
        } else {
            zzanVarZzd.zzc(zzjk.AD_STORAGE, zzam.FAILSAFE);
        }
        int iOrdinal2 = zzjlVarZzB.zzq().ordinal();
        if (iOrdinal2 == 1) {
            zzanVarZzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            zzanVarZzd.zzb(zzjk.ANALYTICS_STORAGE, zzjlVarZzB.zzb());
        } else {
            zzanVarZzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String strZzc2 = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzba zzbaVarZzz = zzz(strZzc2, zzx(strZzc2), zzB(strZzc2), zzanVarZzd);
        zzicVar.zzaD(((Boolean) Preconditions.checkNotNull(zzbaVarZzz.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzbaVarZzz.zzk())) {
            zzicVar.zzaF(zzbaVarZzz.zzk());
        }
        zzaX().zzg();
        zzu();
        Iterator it = zzicVar.zzk().iterator();
        while (true) {
            if (it.hasNext()) {
                zziuVar = (com.google.android.gms.internal.measurement.zziu) it.next();
                if ("_npa".equals(zziuVar.zzc())) {
                    break;
                }
            } else {
                zziuVar = null;
                break;
            }
        }
        if (zziuVar != null) {
            zzjk zzjkVar = zzjk.AD_PERSONALIZATION;
            if (zzanVarZzd.zza(zzjkVar) == zzam.UNSET) {
                zzpn zzpnVarZzm = zzj().zzm(zzhVar.zzc(), "_npa");
                if (zzpnVarZzm != null) {
                    String str = zzpnVarZzm.zzb;
                    if ("tcf".equals(str)) {
                        zzanVarZzd.zzc(zzjkVar, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzanVarZzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzanVarZzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean boolZzae = zzhVar.zzae();
                    if (boolZzae == null || ((boolZzae.booleanValue() && zziuVar.zzh() != 1) || !(boolZzae.booleanValue() || zziuVar.zzh() == 0))) {
                        zzanVarZzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzanVarZzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int iZzaD = zzaD(zzhVar.zzc(), zzanVarZzd);
            com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
            zzitVarZzm.zzb("_npa");
            zzitVarZzm.zza(zzba().currentTimeMillis());
            zzitVarZzm.zze(iZzaD);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd());
            zzaW().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(iZzaD));
        }
        zzicVar.zzaB(zzanVarZzd.toString());
        boolean zZzz = this.zzc.zzz(zzhVar.zzc());
        List listZzb = zzicVar.zzb();
        int i = 0;
        for (int i2 = 0; i2 < listZzb.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i2)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i2)).zzco();
                List listZza = zzhrVar.zza();
                int i3 = 0;
                while (true) {
                    if (i3 >= listZza.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzb())) {
                        String strZzd = ((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzd();
                        if (zZzz && strZzd.length() > 4) {
                            char[] charArray = strZzd.toCharArray();
                            int i4 = 1;
                            while (true) {
                                if (i4 >= 64) {
                                    break;
                                }
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                }
                                i4++;
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            strZzd = String.valueOf(charArray);
                        }
                        zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzhvVarZzn.zzb("_tcfd");
                        zzhvVarZzn.zzd(strZzd);
                        zzhrVar.zze(i3, zzhvVarZzn);
                    } else {
                        i3++;
                    }
                }
                zzicVar.zzf(i2, zzhrVar);
                return;
            }
        }
    }

    public final void zzJ(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzaX().zzg();
        zzu();
        com.google.android.gms.internal.measurement.zzgx zzgxVarZzt = com.google.android.gms.internal.measurement.zzha.zzt();
        byte[] bArrZzaJ = zzhVar.zzaJ();
        if (bArrZzaJ != null) {
            try {
                zzgxVarZzt = (com.google.android.gms.internal.measurement.zzgx) zzpk.zzw(zzgxVarZzt, bArrZzaJ);
            } catch (zzaeh unused) {
                zzaW().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgu.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals("_cmp")) {
                String str = (String) zzpk.zzN(zzhsVar, "gclid", "");
                String str2 = (String) zzpk.zzN(zzhsVar, "gbraid", "");
                String str3 = (String) zzpk.zzN(zzhsVar, "gad_source", "");
                String str4 = (String) zzpk.zzN(zzhsVar, "deep_link_url", "");
                String[] strArrSplit = ((String) zzfy.zzbb.zzb(null)).split(",");
                zzp();
                if (!zzpk.zzK(zzhsVar, strArrSplit).isEmpty()) {
                    long jLongValue = ((Long) zzpk.zzN(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpk.zzM(zzhsVar, "_cis"))) {
                        if (jLongValue > zzgxVarZzt.zzo()) {
                            if (str.isEmpty()) {
                                zzgxVarZzt.zzj();
                            } else {
                                zzgxVarZzt.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzgxVarZzt.zzl();
                            } else {
                                zzgxVarZzt.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzgxVarZzt.zzn();
                            } else {
                                zzgxVarZzt.zzm(str3);
                            }
                            zzgxVarZzt.zzp(jLongValue);
                            zzgxVarZzt.zzs();
                            zzgxVarZzt.zzt(zzaE(zzhsVar));
                        }
                    } else if (jLongValue > zzgxVarZzt.zzg()) {
                        if (str.isEmpty()) {
                            zzgxVarZzt.zzb();
                        } else {
                            zzgxVarZzt.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzgxVarZzt.zzd();
                        } else {
                            zzgxVarZzt.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzgxVarZzt.zzf();
                        } else {
                            zzgxVarZzt.zze(str3);
                        }
                        if (zzd().zzp(null, zzfy.zzba)) {
                            if (str4.isEmpty()) {
                                zzgxVarZzt.zzv();
                            } else {
                                zzgxVarZzt.zzu(str4);
                            }
                        }
                        zzgxVarZzt.zzh(jLongValue);
                        zzgxVarZzt.zzq();
                        zzgxVarZzt.zzr(zzaE(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd()).equals(com.google.android.gms.internal.measurement.zzha.zzu())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd());
        }
        zzhVar.zzaI(((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd()).zzcd());
        if (zzhVar.zza()) {
            zzj().zzv(zzhVar, false, false);
        }
        if (zzd().zzp(null, zzfy.zzba)) {
            for (int i = 0; i < zzicVar.zzc(); i++) {
                com.google.android.gms.internal.measurement.zzhs zzhsVarZzd = zzicVar.zzd(i);
                if ("_cmp".equals(zzhsVarZzd.zzd())) {
                    com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVarZzd.zzco();
                    List listZza = zzhrVar.zza();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= listZza.size()) {
                            break;
                        }
                        if ("deep_link_url".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i2)).zzb())) {
                            zzhrVar.zzj(i2);
                            zzicVar.zzf(i, zzhrVar);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        if (zzd().zzp(null, zzfy.zzaZ)) {
            zzj().zzk(zzhVar.zzc(), "_lgclid");
        }
    }

    public final String zzK(zzjl zzjlVar) {
        if (!zzjlVar.zzo(zzjk.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzt().zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final void zzL(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaW().zzb().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.database.Cursor] */
    public final void zzM() {
        zzaw zzawVarZzj;
        long jZzF;
        SQLiteException e;
        zzh zzhVarZzu;
        zzaX().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaV();
            Boolean boolZzJ = zzicVar.zzt().zzJ();
            if (boolZzJ == null) {
                zzaW().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzJ.booleanValue()) {
                zzaW().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaM();
            } else {
                zzaX().zzg();
                if (this.zzz != null) {
                    zzaW().zzk().zza("Uploading requested multiple times");
                } else if (zzi().zzb()) {
                    ?? CurrentTimeMillis = zzba().currentTimeMillis();
                    ?? r7 = 0;
                    cursorRawQuery = null;
                    Cursor cursorRawQuery = null;
                    string = null;
                    string = null;
                    String string = null;
                    int iZzm = zzd().zzm(null, zzfy.zzah);
                    zzd();
                    long jZzF2 = CurrentTimeMillis - zzal.zzF();
                    for (int i = 0; i < iZzm && zzaH(null, jZzF2); i++) {
                    }
                    zzaif.zza();
                    zzaX().zzg();
                    zzaw();
                    long jZza = this.zzk.zzd.zza();
                    if (jZza != 0) {
                        zzaW().zzj().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(CurrentTimeMillis - jZza)));
                    }
                    String strZzF = zzj().zzF();
                    long j = -1;
                    if (TextUtils.isEmpty(strZzF)) {
                        try {
                            this.zzB = -1L;
                            zzawVarZzj = zzj();
                            zzd();
                            jZzF = CurrentTimeMillis - zzal.zzF();
                            zzawVarZzj.zzg();
                            zzawVarZzj.zzay();
                        } catch (Throwable th) {
                            th = th;
                            r7 = CurrentTimeMillis;
                        }
                        try {
                            CurrentTimeMillis = zzawVarZzj.zze().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jZzF)});
                            try {
                                if (CurrentTimeMillis.moveToFirst()) {
                                    string = CurrentTimeMillis.getString(0);
                                } else {
                                    zzawVarZzj.zzu.zzaW().zzk().zza("No expired configs for apps with pending events");
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                CurrentTimeMillis = CurrentTimeMillis;
                                zzawVarZzj.zzu.zzaW().zzb().zzb("Error selecting expired configs", e);
                                if (CurrentTimeMillis != 0) {
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    zzX(zzhVarZzu);
                                }
                                this.zzw = false;
                                zzaN();
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            CurrentTimeMillis = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            if (r7 == 0) {
                                throw th;
                            }
                            throw th;
                        }
                        CurrentTimeMillis.close();
                        if (!TextUtils.isEmpty(string) && (zzhVarZzu = zzj().zzu(string)) != null) {
                            zzX(zzhVarZzu);
                        }
                    } else {
                        if (this.zzB == -1) {
                            zzaw zzawVarZzj2 = zzj();
                            try {
                                try {
                                    cursorRawQuery = zzawVarZzj2.zze().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    if (cursorRawQuery.moveToFirst()) {
                                        j = cursorRawQuery.getLong(0);
                                    }
                                } finally {
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                }
                            } catch (SQLiteException e4) {
                                zzawVarZzj2.zzu.zzaW().zzb().zzb("Error querying raw events", e4);
                                if (cursorRawQuery != null) {
                                }
                                this.zzB = j;
                                zzN(strZzF, CurrentTimeMillis);
                                this.zzw = false;
                                zzaN();
                            }
                            cursorRawQuery.close();
                            this.zzB = j;
                        }
                        zzN(strZzF, CurrentTimeMillis);
                    }
                } else {
                    zzaW().zzk().zza("Network not connected, ignoring upload request");
                    zzaM();
                }
            }
            this.zzw = false;
            zzaN();
        } catch (Throwable th3) {
            this.zzw = false;
            zzaN();
            throw th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
    
        r22 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0466 A[PHI: r10 r16 r23
      0x0466: PHI (r10v39 java.util.List) = (r10v75 java.util.List), (r10v76 java.util.List) binds: [B:184:0x048c, B:176:0x0464] A[DONT_GENERATE, DONT_INLINE]
      0x0466: PHI (r16v6 java.util.List) = (r16v18 java.util.List), (r16v19 java.util.List) binds: [B:184:0x048c, B:176:0x0464] A[DONT_GENERATE, DONT_INLINE]
      0x0466: PHI (r23v11 android.database.Cursor) = (r23v12 android.database.Cursor), (r23v22 android.database.Cursor) binds: [B:184:0x048c, B:176:0x0464] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[PHI: r0 r10 r23
      0x006f: PHI (r0v117 java.util.List) = (r0v8 java.util.List), (r0v141 java.util.List) binds: [B:108:0x022e, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r10v57 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v59 android.database.Cursor) binds: [B:108:0x022e, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r23v28 long) = (r23v2 long), (r23v29 long) binds: [B:108:0x022e, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0a10  */
    /* JADX WARN: Removed duplicated region for block: B:475:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:476:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzN(String str, long j) throws Throwable {
        long j2;
        Cursor cursor;
        Cursor cursorQuery;
        List list;
        List<Pair> list2;
        List listSubList;
        boolean z;
        Object objZzi;
        String string;
        zzot zzotVar;
        boolean z2;
        List list3;
        boolean z3;
        int i;
        String strZzG;
        List list4;
        List list5;
        Cursor cursor2;
        Cursor cursor3;
        List list6;
        List list7;
        List list8;
        List list9;
        Iterator it;
        List list10;
        int i2;
        int i3;
        SQLiteDatabase sQLiteDatabaseZze;
        long jCurrentTimeMillis;
        Cursor cursorQuery2;
        Cursor cursor4;
        byte[] byteArray;
        com.google.android.gms.internal.measurement.zzid zzidVar;
        long jZzh;
        long j3;
        long jZzh2;
        int iZzm = zzd().zzm(str, zzfy.zzg);
        int i4 = 0;
        int iMax = Math.max(0, zzd().zzm(str, zzfy.zzh));
        zzaw zzawVarZzj = zzj();
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        int i5 = 1;
        Preconditions.checkArgument(iZzm > 0);
        Preconditions.checkArgument(iMax > 0);
        Preconditions.checkNotEmpty(str);
        try {
            try {
                j2 = -1;
                try {
                    cursorQuery = zzawVarZzj.zze().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(iZzm));
                    try {
                    } catch (SQLiteException e) {
                        e = e;
                        cursor4 = cursorQuery;
                    } catch (Throwable th) {
                        th = th;
                        cursor4 = cursorQuery;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursorQuery = null;
                    try {
                        zzawVarZzj.zzu.zzaW().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                        list = Collections.EMPTY_LIST;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        list2 = list;
                        if (list2.isEmpty()) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } catch (SQLiteException e3) {
            e = e3;
            j2 = -1;
        }
        if (cursorQuery.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            int length = 0;
            while (true) {
                long j4 = cursorQuery.getLong(i4);
                try {
                    byte[] blob = cursorQuery.getBlob(i5);
                    zzpk zzpkVarZzp = zzawVarZzj.zzg.zzp();
                    try {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i6 = gZIPInputStream.read(bArr);
                            if (i6 <= 0) {
                                break;
                            }
                            cursor4 = cursorQuery;
                            try {
                                try {
                                    byteArrayOutputStream.write(bArr, 0, i6);
                                    cursorQuery = cursor4;
                                } catch (IOException e4) {
                                    e = e4;
                                    try {
                                        zzpkVarZzp.zzu.zzaW().zzb().zzb("Failed to ungzip content", e);
                                        throw e;
                                    } catch (IOException e5) {
                                        e = e5;
                                        zzawVarZzj.zzu.zzaW().zzb().zzc("Failed to unzip queued bundle. appId", zzgu.zzl(str), e);
                                        if (cursor4.moveToNext()) {
                                            break;
                                        } else {
                                            break;
                                        }
                                        cursor4.close();
                                        list2 = arrayList;
                                        if (list2.isEmpty()) {
                                        }
                                    }
                                }
                            } catch (SQLiteException e6) {
                                e = e6;
                                cursorQuery = cursor4;
                                zzawVarZzj.zzu.zzaW().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                                list = Collections.EMPTY_LIST;
                                if (cursorQuery != null) {
                                }
                                list2 = list;
                                if (list2.isEmpty()) {
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                cursor = cursor4;
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        }
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        byteArray = byteArrayOutputStream.toByteArray();
                    } catch (IOException e7) {
                        e = e7;
                        cursor4 = cursorQuery;
                    }
                } catch (IOException e8) {
                    e = e8;
                    cursor4 = cursorQuery;
                }
                if (!arrayList.isEmpty() && byteArray.length + length > iMax) {
                    break;
                }
                try {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), byteArray);
                    if (!arrayList.isEmpty()) {
                        com.google.android.gms.internal.measurement.zzid zzidVar2 = (com.google.android.gms.internal.measurement.zzid) ((Pair) arrayList.get(0)).first;
                        com.google.android.gms.internal.measurement.zzid zzidVar3 = (com.google.android.gms.internal.measurement.zzid) zzicVar.zzbd();
                        if (!zzidVar2.zzaf().equals(zzidVar3.zzaf()) || !zzidVar2.zzam().equals(zzidVar3.zzam()) || zzidVar2.zzao() != zzidVar3.zzao() || !zzidVar2.zzaq().equals(zzidVar3.zzaq())) {
                            break;
                        }
                        Iterator it2 = zzidVar2.zzf().iterator();
                        while (true) {
                            Iterator it3 = it2;
                            if (!it2.hasNext()) {
                                zzidVar = zzidVar3;
                                jZzh = -1;
                                break;
                            }
                            com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it3.next();
                            zzidVar = zzidVar3;
                            if ("_npa".equals(zziuVar.zzc())) {
                                jZzh = zziuVar.zzh();
                                break;
                            } else {
                                it2 = it3;
                                zzidVar3 = zzidVar;
                            }
                        }
                        Iterator it4 = zzidVar.zzf().iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                j3 = jZzh;
                                jZzh2 = -1;
                                break;
                            }
                            com.google.android.gms.internal.measurement.zziu zziuVar2 = (com.google.android.gms.internal.measurement.zziu) it4.next();
                            j3 = jZzh;
                            if ("_npa".equals(zziuVar2.zzc())) {
                                jZzh2 = zziuVar2.zzh();
                                break;
                            }
                            jZzh = j3;
                        }
                        if (j3 != jZzh2) {
                            break;
                        }
                    }
                    if (!cursorQuery.isNull(2)) {
                        zzicVar.zzao(cursorQuery.getInt(2));
                    }
                    length += byteArray.length;
                    arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbd(), Long.valueOf(j4)));
                } catch (IOException e9) {
                    zzawVarZzj.zzu.zzaW().zzb().zzc("Failed to merge queued bundle. appId", zzgu.zzl(str), e9);
                }
                cursor4 = cursorQuery;
                if (cursor4.moveToNext() || length > iMax) {
                    break;
                    break;
                } else {
                    cursorQuery = cursor4;
                    i4 = 0;
                    i5 = 1;
                }
            }
            cursor4.close();
            list2 = arrayList;
            if (list2.isEmpty()) {
            }
        } else {
            list = Collections.EMPTY_LIST;
            cursorQuery.close();
            list2 = list;
            if (list2.isEmpty()) {
                return;
            }
            zzahh.zza();
            zzal zzalVarZzd = zzd();
            zzfx zzfxVar = zzfy.zzbc;
            if (zzalVarZzd.zzp(null, zzfxVar)) {
                zzahh.zza();
                if (!zzd().zzp(null, zzfxVar)) {
                    list4 = list2;
                } else if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE) || !zzh().zzC(str)) {
                    ArrayList arrayList2 = new ArrayList(list2.size());
                    zzaw zzawVarZzj2 = zzj();
                    Preconditions.checkNotEmpty(str);
                    zzawVarZzj2.zzg();
                    zzawVarZzj2.zzay();
                    ArrayList arrayList3 = new ArrayList();
                    try {
                        try {
                            sQLiteDatabaseZze = zzawVarZzj2.zze();
                            jCurrentTimeMillis = zzawVarZzj2.zzu.zzba().currentTimeMillis();
                            cursorQuery2 = sQLiteDatabaseZze.query("no_data_mode_events", new String[]{"data"}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(jCurrentTimeMillis)}, null, null, "rowid", null);
                            list5 = list2;
                        } catch (Throwable th5) {
                            th = th5;
                            cursor2 = null;
                        }
                        try {
                        } catch (SQLiteException e10) {
                            e = e10;
                            cursor3 = cursorQuery2;
                        } catch (Throwable th6) {
                            th = th6;
                            cursor3 = cursorQuery2;
                            cursor2 = cursor3;
                            if (cursor2 != null) {
                            }
                            throw th;
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        list5 = list2;
                    }
                    if (cursorQuery2.moveToFirst()) {
                        while (true) {
                            try {
                                arrayList3.add((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzp(), cursorQuery2.getBlob(0))).zzbd());
                                cursor3 = cursorQuery2;
                            } catch (zzaeh e12) {
                                cursor3 = cursorQuery2;
                                try {
                                    try {
                                        zzawVarZzj2.zzu.zzaW().zzh().zzc("Failed to parse stored NO_DATA mode event, appId", zzgu.zzl(str), e12);
                                    } catch (SQLiteException e13) {
                                        e = e13;
                                        zzawVarZzj2.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                        List list11 = Collections.EMPTY_LIST;
                                        list9 = list11;
                                        list8 = list5;
                                        list7 = list11;
                                        list6 = list5;
                                        if (cursor3 != null) {
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    cursor2 = cursor3;
                                    if (cursor2 != null) {
                                    }
                                    throw th;
                                }
                            }
                            if (!cursor3.moveToNext()) {
                                break;
                            } else {
                                cursorQuery2 = cursor3;
                            }
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                        cursor3.close();
                        try {
                            int iDelete = sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(jCurrentTimeMillis)});
                            zzgs zzgsVarZzk = zzawVarZzj2.zzu.zzaW().zzk();
                            StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 34);
                            sb.append("Pruned ");
                            sb.append(iDelete);
                            sb.append(" NO_DATA mode events. appId");
                            zzgsVarZzk.zzb(sb.toString(), str);
                            list9 = arrayList3;
                            list8 = list5;
                        } catch (SQLiteException e14) {
                            e = e14;
                            cursor3 = null;
                            zzawVarZzj2.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                            List list112 = Collections.EMPTY_LIST;
                            list9 = list112;
                            list8 = list5;
                            list7 = list112;
                            list6 = list5;
                            if (cursor3 != null) {
                            }
                        }
                        it = list8.iterator();
                        boolean z4 = true;
                        List list12 = list9;
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) pair.first).zzco();
                            if (z4 && !list12.isEmpty()) {
                                List listZzb = zzicVar2.zzb();
                                zzicVar2.zzi();
                                zzicVar2.zzh(list12);
                                zzicVar2.zzh(listZzb);
                                z4 = false;
                            }
                            com.google.android.gms.internal.measurement.zzhh zzhhVarZzb = com.google.android.gms.internal.measurement.zzho.zzb();
                            com.google.android.gms.internal.measurement.zzgf zzgfVarZzy = zzh().zzy(str);
                            ArrayList arrayList4 = new ArrayList();
                            if (zzgfVarZzy != null) {
                                list12 = list12;
                                for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarZzy.zza()) {
                                    com.google.android.gms.internal.measurement.zzhk zzhkVarZza = com.google.android.gms.internal.measurement.zzhl.zza();
                                    int iZzb = zzfuVar.zzb();
                                    zzji zzjiVar = zzji.UNINITIALIZED;
                                    Iterator it5 = it;
                                    int i7 = iZzb - 1;
                                    boolean z5 = z4;
                                    if (i7 == 1) {
                                        list10 = list12;
                                        i2 = 3;
                                        i3 = 2;
                                    } else if (i7 != 2) {
                                        List list13 = list12;
                                        i2 = 3;
                                        if (i7 == 3) {
                                            i3 = 4;
                                            list10 = list13;
                                        } else if (i7 != 4) {
                                            i3 = 1;
                                            list10 = list13;
                                        } else {
                                            i3 = 5;
                                            list10 = list13;
                                        }
                                    } else {
                                        list10 = list12;
                                        i2 = 3;
                                        i3 = 3;
                                    }
                                    zzhkVarZza.zza(i3);
                                    int iZzd = zzfuVar.zzd() - 1;
                                    if (iZzd == 1) {
                                        i2 = 2;
                                    } else if (iZzd != 2) {
                                        i2 = 1;
                                    }
                                    zzhkVarZza.zzb(i2);
                                    arrayList4.add((com.google.android.gms.internal.measurement.zzhl) zzhkVarZza.zzbd());
                                    z4 = z5;
                                    it = it5;
                                    list12 = list10;
                                }
                            }
                            Iterator it6 = it;
                            boolean z6 = z4;
                            List list14 = list12;
                            zzhhVarZzb.zza(arrayList4);
                            zzicVar2.zzaP(zzhhVarZzb);
                            arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbd(), (Long) pair.second));
                            z4 = z6;
                            it = it6;
                            list12 = list14;
                        }
                        list4 = arrayList2;
                    } else {
                        cursor3 = cursorQuery2;
                        list7 = arrayList3;
                        list6 = list5;
                        cursor3.close();
                        list9 = list7;
                        list8 = list6;
                        it = list8.iterator();
                        boolean z42 = true;
                        List list122 = list9;
                        while (it.hasNext()) {
                        }
                        list4 = arrayList2;
                    }
                    zzawVarZzj2.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                    List list1122 = Collections.EMPTY_LIST;
                    list9 = list1122;
                    list8 = list5;
                    list7 = list1122;
                    list6 = list5;
                    if (cursor3 != null) {
                        cursor3.close();
                        list9 = list7;
                        list8 = list6;
                    }
                    it = list8.iterator();
                    boolean z422 = true;
                    List list1222 = list9;
                    while (it.hasNext()) {
                    }
                    list4 = arrayList2;
                } else {
                    List listAsList = Arrays.asList(((String) zzfy.zzbd.zzb(null)).split(","));
                    for (Pair pair2 : list2) {
                        try {
                            zzj().zzH(((Long) pair2.second).longValue());
                            for (com.google.android.gms.internal.measurement.zzhs zzhsVar : ((com.google.android.gms.internal.measurement.zzid) pair2.first).zzc()) {
                                if (listAsList.contains(zzhsVar.zzd())) {
                                    if (zzhsVar.zzd().equals("_f") || zzhsVar.zzd().equals("_v")) {
                                        com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzco();
                                        zzp();
                                        zzpk.zzF(zzhrVar, "_dac", 1L);
                                        zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd();
                                    }
                                    zzaw zzawVarZzj3 = zzj();
                                    zzawVarZzj3.zzg();
                                    zzawVarZzj3.zzay();
                                    Preconditions.checkNotNull(zzhsVar);
                                    Preconditions.checkNotEmpty(str);
                                    zzic zzicVar3 = zzawVarZzj3.zzu;
                                    zzicVar3.zzaW().zzk().zzb("Caching events in NO_DATA mode", zzhsVar);
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("app_id", str);
                                    contentValues.put("name", zzhsVar.zzd());
                                    contentValues.put("data", zzhsVar.zzcd());
                                    contentValues.put("timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                                    try {
                                        if (zzawVarZzj3.zze().insert("no_data_mode_events", null, contentValues) == j2) {
                                            zzicVar3.zzaW().zzb().zzb("Failed to insert NO_DATA mode event (got -1). appId", zzgu.zzl(str));
                                        }
                                    } catch (SQLiteException e15) {
                                        zzawVarZzj3.zzu.zzaW().zzb().zzc("Error storing NO_DATA mode event. appId", zzgu.zzl(str), e15);
                                    }
                                }
                            }
                        } catch (SQLiteException unused) {
                            zzaW().zzh().zzb("Failed handling NO_DATA mode bundles. appId", str);
                        }
                    }
                    list4 = Collections.EMPTY_LIST;
                }
                boolean zIsEmpty = list4.isEmpty();
                listSubList = list4;
                if (zIsEmpty) {
                    return;
                }
            } else {
                listSubList = list2;
            }
            zzjl zzjlVarZzB = zzB(str);
            zzjk zzjkVar = zzjk.AD_STORAGE;
            if (zzjlVarZzB.zzo(zzjkVar)) {
                Iterator it7 = listSubList.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        strZzG = null;
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzid zzidVar4 = (com.google.android.gms.internal.measurement.zzid) ((Pair) it7.next()).first;
                    if (!zzidVar4.zzG().isEmpty()) {
                        strZzG = zzidVar4.zzG();
                        break;
                    }
                }
                if (strZzG != null) {
                    int i8 = 0;
                    while (true) {
                        if (i8 >= listSubList.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzid zzidVar5 = (com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(i8)).first;
                        if (!zzidVar5.zzG().isEmpty() && !zzidVar5.zzG().equals(strZzG)) {
                            listSubList = listSubList.subList(0, i8);
                            break;
                        }
                        i8++;
                    }
                }
            }
            com.google.android.gms.internal.measurement.zzhz zzhzVarZzi = com.google.android.gms.internal.measurement.zzib.zzi();
            int size = listSubList.size();
            ArrayList arrayList5 = new ArrayList(listSubList.size());
            boolean z7 = zzd().zzC(str) && zzB(str).zzo(zzjkVar);
            boolean zZzo = zzB(str).zzo(zzjkVar);
            boolean zZzo2 = zzB(str).zzo(zzjk.ANALYTICS_STORAGE);
            zzair.zza();
            boolean zZzp = zzd().zzp(str, zzfy.zzaM);
            zzou zzouVar = this.zzl;
            zzot zzotVarZza = zzouVar.zza(str);
            int i9 = 0;
            List list15 = listSubList;
            while (i9 < size) {
                boolean z8 = zZzo;
                com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) ((Pair) list15.get(i9)).first).zzco();
                int i10 = size;
                arrayList5.add((Long) ((Pair) list15.get(i9)).second);
                zzd().zzi();
                boolean z9 = z7;
                boolean z10 = zZzo2;
                zzicVar4.zzO(161000L);
                zzicVar4.zzs(j);
                this.zzn.zzaV();
                zzicVar4.zzae(false);
                if (!z9) {
                    zzicVar4.zzan();
                }
                if (!z8) {
                    zzicVar4.zzR();
                    zzicVar4.zzU();
                }
                if (!z10) {
                    zzicVar4.zzX();
                }
                zzS(str, zzicVar4);
                if (!zZzp) {
                    zzicVar4.zzav();
                }
                if (!z10) {
                    zzicVar4.zzag();
                }
                String strZzP = zzicVar4.zzP();
                if (TextUtils.isEmpty(strZzP) || strZzP.equals("00000000-0000-0000-0000-000000000000")) {
                    ArrayList arrayList6 = new ArrayList(zzicVar4.zzb());
                    Iterator it8 = arrayList6.iterator();
                    z2 = z9;
                    Long lValueOf = null;
                    Long lValueOf2 = null;
                    boolean z11 = false;
                    boolean z12 = false;
                    while (it8.hasNext()) {
                        List list16 = list15;
                        com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) it8.next();
                        boolean z13 = zZzp;
                        int i11 = i9;
                        if ("_fx".equals(zzhsVar2.zzd())) {
                            it8.remove();
                            zZzp = z13;
                            list15 = list16;
                            i9 = i11;
                            z11 = true;
                        } else if ("_f".equals(zzhsVar2.zzd())) {
                            zzp();
                            com.google.android.gms.internal.measurement.zzhw zzhwVarZzI = zzpk.zzI(zzhsVar2, "_pfo");
                            if (zzhwVarZzI != null) {
                                lValueOf = Long.valueOf(zzhwVarZzI.zzf());
                            }
                            zzp();
                            com.google.android.gms.internal.measurement.zzhw zzhwVarZzI2 = zzpk.zzI(zzhsVar2, "_uwa");
                            if (zzhwVarZzI2 != null) {
                                lValueOf2 = Long.valueOf(zzhwVarZzI2.zzf());
                            }
                            zZzp = z13;
                            list15 = list16;
                            i9 = i11;
                        } else {
                            zZzp = z13;
                            list15 = list16;
                            i9 = i11;
                        }
                        z12 = true;
                    }
                    list3 = list15;
                    z3 = zZzp;
                    i = i9;
                    if (z11) {
                        zzicVar4.zzi();
                        zzicVar4.zzh(arrayList6);
                    }
                    if (z12) {
                        zzR(zzicVar4.zzK(), true, lValueOf, lValueOf2);
                    }
                } else {
                    z2 = z9;
                    list3 = list15;
                    z3 = zZzp;
                    i = i9;
                }
                if (zzicVar4.zzc() != 0) {
                    if (zzd().zzp(str, zzfy.zzaC)) {
                        zzicVar4.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar4.zzbd()).zzcd()));
                    }
                    com.google.android.gms.internal.measurement.zzis zzisVarZzd = zzotVarZza.zzd();
                    if (zzisVarZzd != null) {
                        zzicVar4.zzaN(zzisVarZzd);
                    }
                    zzhzVarZzi.zze(zzicVar4);
                }
                i9 = i + 1;
                zZzo2 = z10;
                zZzo = z8;
                size = i10;
                z7 = z2;
                zZzp = z3;
                list15 = list3;
            }
            if (zzhzVarZzi.zzb() == 0) {
                zzL(arrayList5);
                zzW(false, ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, null, null, str, Collections.EMPTY_LIST, null);
                return;
            }
            com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbd();
            ArrayList arrayList7 = new ArrayList();
            boolean z14 = zzotVarZza.zzc() == zzls.SGTM_CLIENT;
            if (zzotVarZza.zzc() == zzls.SGTM) {
                z = z14;
            } else {
                if (!z14) {
                    objZzi = null;
                    if (zzi().zzb()) {
                        return;
                    }
                    if (Log.isLoggable(zzaW().zzn(), 2)) {
                        objZzi = zzp().zzi(zzibVar);
                    }
                    zzp();
                    byte[] bArrZzcd = zzibVar.zzcd();
                    zzL(arrayList5);
                    this.zzk.zze.zzb(j);
                    zzaW().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(bArrZzcd.length), objZzi);
                    this.zzv = true;
                    zzi().zzc(str, zzotVarZza, zzibVar, new zzow(this, str, arrayList7));
                    return;
                }
                z = true;
            }
            Iterator it9 = ((com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbd()).zza().iterator();
            while (true) {
                if (it9.hasNext()) {
                    if (((com.google.android.gms.internal.measurement.zzid) it9.next()).zzY()) {
                        string = UUID.randomUUID().toString();
                        break;
                    }
                } else {
                    string = null;
                    break;
                }
            }
            com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbd();
            zzaX().zzg();
            zzu();
            com.google.android.gms.internal.measurement.zzhz zzhzVarZzj = com.google.android.gms.internal.measurement.zzib.zzj(zzibVar2);
            if (!TextUtils.isEmpty(string)) {
                zzhzVarZzj.zzi(string);
            }
            String strZzc = zzh().zzc(str);
            if (!TextUtils.isEmpty(strZzc)) {
                zzhzVarZzj.zzj(strZzc);
            }
            ArrayList arrayList8 = new ArrayList();
            Iterator it10 = zzibVar2.zza().iterator();
            while (it10.hasNext()) {
                com.google.android.gms.internal.measurement.zzic zzicVarZzaF = com.google.android.gms.internal.measurement.zzid.zzaF((com.google.android.gms.internal.measurement.zzid) it10.next());
                zzicVarZzaF.zzan();
                arrayList8.add((com.google.android.gms.internal.measurement.zzid) zzicVarZzaF.zzbd());
            }
            zzhzVarZzj.zzg();
            zzhzVarZzj.zzf(arrayList8);
            zzaW().zzk().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(string) ? "null" : zzhzVarZzj.zzh());
            com.google.android.gms.internal.measurement.zzib zzibVar3 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzj.zzbd();
            if (TextUtils.isEmpty(string)) {
                objZzi = null;
            } else {
                com.google.android.gms.internal.measurement.zzib zzibVar4 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbd();
                zzaX().zzg();
                zzu();
                com.google.android.gms.internal.measurement.zzhz zzhzVarZzi2 = com.google.android.gms.internal.measurement.zzib.zzi();
                zzaW().zzk().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", string);
                zzhzVarZzi2.zzi(string);
                for (com.google.android.gms.internal.measurement.zzid zzidVar6 : zzibVar4.zza()) {
                    com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                    zzicVarZzaE.zzam(zzidVar6.zzZ());
                    zzicVarZzaE.zzaJ(zzidVar6.zzav());
                    zzhzVarZzi2.zze(zzicVarZzaE);
                }
                com.google.android.gms.internal.measurement.zzib zzibVar5 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi2.zzbd();
                String strZzc2 = zzouVar.zzg.zzh().zzc(str);
                if (TextUtils.isEmpty(strZzc2)) {
                    objZzi = null;
                    zzotVar = new zzot((String) zzfy.zzr.zzb(null), Collections.EMPTY_MAP, z ? zzls.GOOGLE_SIGNAL_PENDING : zzls.GOOGLE_SIGNAL, null);
                } else {
                    Uri uri = Uri.parse((String) zzfy.zzr.zzb(null));
                    Uri.Builder builderBuildUpon = uri.buildUpon();
                    String authority = uri.getAuthority();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strZzc2).length() + 1 + String.valueOf(authority).length());
                    sb2.append(strZzc2);
                    sb2.append(".");
                    sb2.append(authority);
                    builderBuildUpon.authority(sb2.toString());
                    objZzi = null;
                    zzotVar = new zzot(builderBuildUpon.build().toString(), Collections.EMPTY_MAP, z ? zzls.GOOGLE_SIGNAL_PENDING : zzls.GOOGLE_SIGNAL, null);
                }
                arrayList7.add(Pair.create(zzibVar5, zzotVar));
            }
            if (z) {
                com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzibVar3.zzco();
                for (int i12 = 0; i12 < zzibVar3.zzb(); i12++) {
                    com.google.android.gms.internal.measurement.zzic zzicVar5 = (com.google.android.gms.internal.measurement.zzic) zzibVar3.zzc(i12).zzco();
                    zzicVar5.zzt();
                    zzicVar5.zzaO(j);
                    zzhzVar.zzd(i12, zzicVar5);
                }
                arrayList7.add(Pair.create((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbd(), zzotVarZza));
                zzL(arrayList5);
                zzW(false, ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, null, null, str, arrayList7, null);
                if (zzO(str, zzotVarZza.zza())) {
                    zzaW().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                    intent.setPackage(str);
                    zzaR(this.zzn.zzaZ(), intent);
                    return;
                }
                return;
            }
            zzibVar = zzibVar3;
            if (zzi().zzb()) {
            }
        }
    }

    public final boolean zzO(String str, String str2) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null && zzt().zzad(str, zzhVarZzu.zzay())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpe zzpeVar = (zzpe) this.zzF.get(str2);
        if (zzpeVar == null) {
            return true;
        }
        return zzpeVar.zzb();
    }

    public final void zzP(String str) {
        com.google.android.gms.internal.measurement.zzib zzibVarZzd;
        zzaX().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaV();
            Boolean boolZzJ = zzicVar.zzt().zzJ();
            if (boolZzJ == null) {
                zzaW().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzJ.booleanValue()) {
                zzaW().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaM();
            } else if (!zzi().zzb()) {
                zzaW().zzk().zza("Network not connected, ignoring upload request");
                zzaM();
            } else if (zzj().zzD(str)) {
                zzaw zzawVarZzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzawVarZzj.zzg();
                zzawVarZzj.zzay();
                List listZzC = zzawVarZzj.zzC(str, zzoo.zza(zzls.GOOGLE_SIGNAL), 1);
                zzpj zzpjVar = listZzC.isEmpty() ? null : (zzpj) listZzC.get(0);
                if (zzpjVar != null && (zzibVarZzd = zzpjVar.zzd()) != null) {
                    zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpjVar.zzf(), zzpjVar.zze());
                    byte[] bArrZzcd = zzibVarZzd.zzcd();
                    if (Log.isLoggable(zzaW().zzn(), 2)) {
                        zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrZzcd.length), zzp().zzi(zzibVarZzd));
                    }
                    zzot zzotVarZza = zzpjVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zzotVarZza, zzibVarZzd, new zzox(this, str, zzpjVar));
                }
            } else {
                zzaW().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            }
            this.zzw = false;
            zzaN();
        } catch (Throwable th) {
            this.zzw = false;
            zzaN();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:19:0x005a, B:22:0x0080, B:13:0x001e, B:15:0x0048, B:17:0x0052, B:18:0x0056), top: B:27:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzQ(String str, int i, Throwable th, byte[] bArr, zzpj zzpjVar) {
        zzaX().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaN();
                throw th2;
            }
        }
        if (i != 200) {
            if (i == 204) {
                i = 204;
                if (th != null) {
                }
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            String strSubstring = str2.substring(0, Math.min(32, str2.length()));
            zzgs zzgsVarZzh = zzaW().zzh();
            Integer numValueOf = Integer.valueOf(i);
            Object obj = th;
            if (th == null) {
            }
            zzgsVarZzh.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf, obj);
            zzj().zzK(Long.valueOf(zzpjVar.zzc()));
            zzaM();
        } else if (th != null) {
            zzj().zzE(Long.valueOf(zzpjVar.zzc()));
            zzaW().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
            if (zzi().zzb() && zzj().zzD(str)) {
                zzP(str);
            } else {
                zzaM();
            }
        } else {
            String str22 = new String(bArr, StandardCharsets.UTF_8);
            String strSubstring2 = str22.substring(0, Math.min(32, str22.length()));
            zzgs zzgsVarZzh2 = zzaW().zzh();
            Integer numValueOf2 = Integer.valueOf(i);
            Object obj2 = th;
            if (th == null) {
                obj2 = strSubstring2;
            }
            zzgsVarZzh2.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf2, obj2);
            zzj().zzK(Long.valueOf(zzpjVar.zzc()));
            zzaM();
        }
        this.zzv = false;
        zzaN();
    }

    public final void zzR(String str, boolean z, Long l, Long l2) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null) {
            zzhVarZzu.zzar(z);
            zzhVarZzu.zzat(l);
            zzhVarZzu.zzav(l2);
            if (zzhVarZzu.zza()) {
                zzj().zzv(zzhVarZzu, false, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzS(String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        int iZzx;
        int iIndexOf;
        Set setZzl = zzh().zzl(str);
        if (setZzl != null) {
            zzicVar.zzaw(setZzl);
        }
        if (zzh().zzq(str)) {
            zzicVar.zzG();
        }
        if (zzh().zzr(str)) {
            String strZzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
                zzicVar.zzE(strZzD.substring(0, iIndexOf));
            }
        }
        if (zzh().zzs(str) && (iZzx = zzpk.zzx(zzicVar, "_id")) != -1) {
            zzicVar.zzr(iZzx);
        }
        if (zzh().zzt(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzu(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpd zzpdVar = (zzpd) map.get(str);
                if (zzpdVar != null) {
                    if (zzd().zzl(str, zzfy.zzaj) + zzpdVar.zzb < zzba().elapsedRealtime()) {
                        zzpdVar = new zzpd(this, (byte[]) null);
                        map.put(str, zzpdVar);
                    }
                    zzicVar.zzax(zzpdVar.zza);
                }
            }
        }
        if (zzh().zzv(str)) {
            zzicVar.zzav();
        }
    }

    public final void zzT(com.google.android.gms.internal.measurement.zzic zzicVar, zzpc zzpcVar) {
        for (int i = 0; i < zzicVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i).zzco();
            Iterator it = zzhrVar.zza().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it.next()).zzb())) {
                    if (zzpcVar.zza.zzar() >= zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzak)) {
                        int iZzm = zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzax);
                        String strZzaz = null;
                        if (iZzm <= 0) {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                strZzaz = zzt().zzaz();
                                zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb("_tu");
                                zzhvVarZzn.zzd(strZzaz);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
                            }
                            zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn2.zzb("_tr");
                            zzhvVarZzn2.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbd());
                            zzoh zzohVarZzf = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, strZzaz);
                            if (zzohVarZzf != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzohVarZzf.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzohVarZzf);
                                Deque deque = this.zzr;
                                if (!deque.contains(zzpcVar.zza.zzA())) {
                                    deque.add(zzpcVar.zza.zzA());
                                }
                            }
                        } else if (zzj().zzw(zzC(), zzpcVar.zza.zzA(), false, false, false, false, false, false, true).zzg > iZzm) {
                            zzhv zzhvVarZzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn3.zzb("_tnr");
                            zzhvVarZzn3.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn3.zzbd());
                        } else {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                strZzaz = zzt().zzaz();
                                zzhv zzhvVarZzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn4.zzb("_tu");
                                zzhvVarZzn4.zzd(strZzaz);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn4.zzbd());
                            }
                            zzhv zzhvVarZzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn5.zzb("_tr");
                            zzhvVarZzn5.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn5.zzbd());
                            zzoh zzohVarZzf2 = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, strZzaz);
                            if (zzohVarZzf2 != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzohVarZzf2.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzohVarZzf2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzpcVar.zza.zzA())) {
                                    deque2.add(zzpcVar.zza.zzA());
                                }
                            }
                        }
                    }
                    zzicVar.zze(i, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd());
                }
            }
        }
    }

    public final void zzU(String str, zzhv zzhvVar, Bundle bundle, String str2) {
        List listListOf = zzd().zzp(str2, zzfy.zzba) ? CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si", "deep_link_url"}) : CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        long jZzf = (zzpp.zzac(zzhvVar.zza()) || zzpp.zzac(str)) ? zzd().zzf(str2, true) : zzd().zze(str2, true);
        long jCodePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpp zzppVarZzt = zzt();
        String strZza = zzhvVar.zza();
        zzd();
        String strZzE = zzppVarZzt.zzE(strZza, 40, true);
        if (jCodePointCount <= jZzf || listListOf.contains(zzhvVar.zza())) {
            return;
        }
        if ("_ev".equals(zzhvVar.zza())) {
            bundle.putString("_ev", zzt().zzE(zzhvVar.zzc(), zzd().zzf(str2, true), true));
            return;
        }
        zzaW().zzh().zzc("Param value is too long; discarded. Name, value length", strZzE, Long.valueOf(jCodePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strZzE);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(zzhvVar.zza());
    }

    public final boolean zzV(com.google.android.gms.internal.measurement.zzhr zzhrVar) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (SDKConstants.PARAM_VALUE.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i = i3;
            } else if ("currency".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i2 = i3;
            }
        }
        if (i == -1) {
            if (!zzd().zzp(null, zzfy.zzbf) || !"_iap".equals(zzhrVar.zzk())) {
                return true;
            }
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, SDKConstants.PARAM_VALUE);
            return false;
        }
        if (!((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zze() && !((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzj()) {
            zzaW().zzh().zza("Value must be specified with a numeric type.");
            zzhrVar.zzj(i);
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, SDKConstants.PARAM_VALUE);
            return false;
        }
        if (i2 != -1) {
            String strZzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i2)).zzd();
            if (strZzd.length() == 3) {
                int iCharCount = 0;
                while (iCharCount < strZzd.length()) {
                    int iCodePointAt = strZzd.codePointAt(iCharCount);
                    if (Character.isLetter(iCodePointAt)) {
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return true;
            }
        }
        zzaW().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
        zzhrVar.zzj(i);
        zzaC(zzhrVar, "_c");
        zzaB(zzhrVar, 19, "currency");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0086 A[Catch: all -> 0x0016, TryCatch #1 {all -> 0x0016, blocks: (B:4:0x0013, B:8:0x001b, B:10:0x0028, B:11:0x0031, B:19:0x0049, B:24:0x0095, B:23:0x0086, B:25:0x00a1, B:27:0x00b8, B:30:0x00cb, B:32:0x00d9, B:34:0x00f9, B:76:0x0234, B:78:0x0247, B:80:0x0251, B:88:0x0271, B:82:0x0257, B:84:0x0261, B:86:0x0267, B:87:0x026b, B:89:0x0274, B:90:0x027b, B:33:0x00ec, B:91:0x027c), top: B:97:0x0013, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1 A[Catch: all -> 0x0016, PHI: r0
      0x00a1: PHI (r0v2 int) = (r0v0 int), (r0v37 int) binds: [B:12:0x003c, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {all -> 0x0016, blocks: (B:4:0x0013, B:8:0x001b, B:10:0x0028, B:11:0x0031, B:19:0x0049, B:24:0x0095, B:23:0x0086, B:25:0x00a1, B:27:0x00b8, B:30:0x00cb, B:32:0x00d9, B:34:0x00f9, B:76:0x0234, B:78:0x0247, B:80:0x0251, B:88:0x0271, B:82:0x0257, B:84:0x0261, B:86:0x0267, B:87:0x026b, B:89:0x0274, B:90:0x027b, B:33:0x00ec, B:91:0x027c), top: B:97:0x0013, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9 A[Catch: all -> 0x0016, SQLiteException -> 0x00c8, TryCatch #0 {SQLiteException -> 0x00c8, blocks: (B:27:0x00b8, B:30:0x00cb, B:32:0x00d9, B:34:0x00f9, B:76:0x0234, B:78:0x0247, B:80:0x0251, B:88:0x0271, B:82:0x0257, B:84:0x0261, B:86:0x0267, B:87:0x026b, B:89:0x0274, B:90:0x027b, B:33:0x00ec), top: B:96:0x00b8, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ec A[Catch: all -> 0x0016, SQLiteException -> 0x00c8, TryCatch #0 {SQLiteException -> 0x00c8, blocks: (B:27:0x00b8, B:30:0x00cb, B:32:0x00d9, B:34:0x00f9, B:76:0x0234, B:78:0x0247, B:80:0x0251, B:88:0x0271, B:82:0x0257, B:84:0x0261, B:86:0x0267, B:87:0x026b, B:89:0x0274, B:90:0x027b, B:33:0x00ec), top: B:96:0x00b8, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0111 A[Catch: all -> 0x016a, TryCatch #3 {all -> 0x016a, blocks: (B:35:0x0100, B:36:0x0109, B:38:0x0111, B:40:0x0128, B:44:0x0152, B:46:0x015c, B:50:0x016d, B:51:0x0172, B:53:0x0178, B:55:0x018f, B:57:0x01b4, B:59:0x01cf, B:61:0x01f2, B:62:0x0203, B:63:0x0207, B:65:0x020d, B:66:0x0214, B:69:0x0221, B:71:0x0225, B:74:0x022c, B:75:0x022d), top: B:100:0x0100, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0178 A[Catch: all -> 0x016a, TryCatch #3 {all -> 0x016a, blocks: (B:35:0x0100, B:36:0x0109, B:38:0x0111, B:40:0x0128, B:44:0x0152, B:46:0x015c, B:50:0x016d, B:51:0x0172, B:53:0x0178, B:55:0x018f, B:57:0x01b4, B:59:0x01cf, B:61:0x01f2, B:62:0x0203, B:63:0x0207, B:65:0x020d, B:66:0x0214, B:69:0x0221, B:71:0x0225, B:74:0x022c, B:75:0x022d), top: B:100:0x0100, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cf A[Catch: all -> 0x016a, TryCatch #3 {all -> 0x016a, blocks: (B:35:0x0100, B:36:0x0109, B:38:0x0111, B:40:0x0128, B:44:0x0152, B:46:0x015c, B:50:0x016d, B:51:0x0172, B:53:0x0178, B:55:0x018f, B:57:0x01b4, B:59:0x01cf, B:61:0x01f2, B:62:0x0203, B:63:0x0207, B:65:0x020d, B:66:0x0214, B:69:0x0221, B:71:0x0225, B:74:0x022c, B:75:0x022d), top: B:100:0x0100, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020d A[Catch: all -> 0x016a, TRY_LEAVE, TryCatch #3 {all -> 0x016a, blocks: (B:35:0x0100, B:36:0x0109, B:38:0x0111, B:40:0x0128, B:44:0x0152, B:46:0x015c, B:50:0x016d, B:51:0x0172, B:53:0x0178, B:55:0x018f, B:57:0x01b4, B:59:0x01cf, B:61:0x01f2, B:62:0x0203, B:63:0x0207, B:65:0x020d, B:66:0x0214, B:69:0x0221, B:71:0x0225, B:74:0x022c, B:75:0x022d), top: B:100:0x0100, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0257 A[Catch: all -> 0x0016, SQLiteException -> 0x00c8, TryCatch #0 {SQLiteException -> 0x00c8, blocks: (B:27:0x00b8, B:30:0x00cb, B:32:0x00d9, B:34:0x00f9, B:76:0x0234, B:78:0x0247, B:80:0x0251, B:88:0x0271, B:82:0x0257, B:84:0x0261, B:86:0x0267, B:87:0x026b, B:89:0x0274, B:90:0x027b, B:33:0x00ec), top: B:96:0x00b8, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x026b A[Catch: all -> 0x0016, SQLiteException -> 0x00c8, TryCatch #0 {SQLiteException -> 0x00c8, blocks: (B:27:0x00b8, B:30:0x00cb, B:32:0x00d9, B:34:0x00f9, B:76:0x0234, B:78:0x0247, B:80:0x0251, B:88:0x0271, B:82:0x0257, B:84:0x0261, B:86:0x0267, B:87:0x026b, B:89:0x0274, B:90:0x027b, B:33:0x00ec), top: B:96:0x00b8, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzW(boolean z, int i, Throwable th, byte[] bArr, String str, List list, Map map) {
        byte[] bArr2;
        Iterator it;
        Iterator it2;
        List listZzC;
        int i2 = i;
        zzaX().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaN();
                throw th2;
            }
        } else {
            bArr2 = bArr;
        }
        if (zzd().zzp(null, zzfy.zzbe)) {
            zzp().zzD(map);
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        if (!z) {
            zzgs zzgsVarZzk = zzaW().zzk();
            Integer numValueOf = Integer.valueOf(i2);
            zzgsVarZzk.zzc("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
            if (z) {
                try {
                    this.zzk.zzd.zzb(zzba().currentTimeMillis());
                    this.zzk.zze.zzb(0L);
                    zzaM();
                    if (z) {
                        zzaW().zzk().zza("Purged empty bundles");
                    } else {
                        zzaW().zzk().zzc("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
                    }
                    zzj().zzb();
                    try {
                        HashMap map2 = new HashMap();
                        it = list.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) pair.first;
                            zzot zzotVar = (zzot) pair.second;
                            if (zzotVar.zzc() != zzls.SGTM_CLIENT) {
                                long jZzA = zzj().zzA(str, zzibVar, zzotVar.zza(), zzotVar.zzb(), zzotVar.zzc(), null);
                                if (zzotVar.zzc() == zzls.GOOGLE_SIGNAL_PENDING && jZzA != -1 && !zzibVar.zze().isEmpty()) {
                                    map2.put(zzibVar.zze(), Long.valueOf(jZzA));
                                }
                            }
                        }
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            Pair pair2 = (Pair) it2.next();
                            com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) pair2.first;
                            zzot zzotVar2 = (zzot) pair2.second;
                            if (zzotVar2.zzc() == zzls.SGTM_CLIENT) {
                                zzj().zzA(str, zzibVar2, zzotVar2.zza(), zzotVar2.zzb(), zzotVar2.zzc(), (Long) map2.get(zzibVar2.zze()));
                            }
                        }
                        listZzC = zzj().zzC(str, zzoo.zza(zzls.SGTM_CLIENT), 1);
                        if (!listZzC.isEmpty()) {
                            long jZzg = ((zzpj) listZzC.get(0)).zzg();
                            if (zzba().currentTimeMillis() > ((Long) zzfy.zzE.zzb(null)).longValue() + jZzg) {
                                zzaW().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(jZzg));
                            }
                        }
                        for (Long l : list2) {
                            try {
                                zzj().zzH(l.longValue());
                            } catch (SQLiteException e) {
                                List list3 = this.zzA;
                                if (list3 == null || !list3.contains(l)) {
                                    throw e;
                                }
                            }
                        }
                        zzj().zzc();
                        zzj().zzd();
                        this.zzA = null;
                        if (!zzi().zzb() && zzj().zzD(str)) {
                            zzP(str);
                        } else if (zzi().zzb() || !zzaL()) {
                            this.zzB = -1L;
                            zzaM();
                        } else {
                            zzM();
                        }
                        this.zza = 0L;
                    } catch (Throwable th3) {
                        zzj().zzd();
                        throw th3;
                    }
                } catch (SQLiteException e2) {
                    zzaW().zzb().zzb("Database error while trying to delete uploaded bundles", e2);
                    this.zza = zzba().elapsedRealtime();
                    zzaW().zzk().zzb("Disable upload, time", Long.valueOf(this.zza));
                }
            } else {
                this.zzk.zze.zzb(0L);
                zzaM();
                if (z) {
                }
                zzj().zzb();
                HashMap map22 = new HashMap();
                it = list.iterator();
                while (it.hasNext()) {
                }
                it2 = list.iterator();
                while (it2.hasNext()) {
                }
                listZzC = zzj().zzC(str, zzoo.zza(zzls.SGTM_CLIENT), 1);
                if (!listZzC.isEmpty()) {
                }
                while (r2.hasNext()) {
                }
                zzj().zzc();
                zzj().zzd();
                this.zzA = null;
                if (!zzi().zzb()) {
                    if (zzi().zzb()) {
                        this.zzB = -1L;
                        zzaM();
                        this.zza = 0L;
                    }
                }
            }
        } else if (i2 != 200) {
            if (i2 == 204) {
                i2 = 204;
                if (th == null) {
                }
            }
            String str2 = new String(bArr2, StandardCharsets.UTF_8);
            zzaW().zzh().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str2.substring(0, Math.min(32, str2.length())));
            this.zzk.zze.zzb(zzba().currentTimeMillis());
            if (i2 != 503) {
                this.zzk.zzc.zzb(zzba().currentTimeMillis());
                zzj().zzJ(list2);
                zzaM();
            }
        } else if (th == null) {
            String str22 = new String(bArr2, StandardCharsets.UTF_8);
            zzaW().zzh().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str22.substring(0, Math.min(32, str22.length())));
            this.zzk.zze.zzb(zzba().currentTimeMillis());
            if (i2 != 503 || i2 == 429) {
                this.zzk.zzc.zzb(zzba().currentTimeMillis());
            }
            zzj().zzJ(list2);
            zzaM();
        }
        this.zzv = false;
        zzaN();
    }

    public final void zzX(zzh zzhVar) {
        zzaX().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzY((String) Preconditions.checkNotNull(zzhVar.zzc()), ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzc());
        zzaW().zzk().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgl zzglVarZzb = zzh().zzb(str);
        String strZzd = zzh().zzd(str);
        ArrayMap arrayMap = null;
        if (zzglVarZzb != null) {
            if (!TextUtils.isEmpty(strZzd)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", strZzd);
            }
            String strZze = zzh().zze(str);
            if (!TextUtils.isEmpty(strZze)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put("If-None-Match", strZze);
            }
        }
        this.zzu = true;
        zzi().zzd(zzhVar, arrayMap, new zzgw() { // from class: com.google.android.gms.measurement.internal.zzpf
            @Override // com.google.android.gms.measurement.internal.zzgw
            public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.zzY(str2, i, th, bArr, map);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzY(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzaN();
                throw th2;
            }
        }
        zzgs zzgsVarZzk = zzaW().zzk();
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzgsVarZzk.zzb("onConfigFetched. Response size", numValueOf);
        if (zzd().zzp(null, zzfy.zzbe)) {
            zzp().zzD(map);
        }
        zzj().zzb();
        try {
            zzh zzhVarZzu = zzj().zzu(str);
            if (i == 200 || i == 204) {
                z = th != null;
            } else {
                if (i == 304) {
                    i = 304;
                    if (th != null) {
                    }
                }
            }
            if (zzhVarZzu == null) {
                zzaW().zze().zzb("App does not exist in onConfigFetched. appId", zzgu.zzl(str));
            } else if (z || i == 404) {
                zzp();
                String strZzJ = zzpk.zzJ(map, "Last-Modified");
                zzp();
                String strZzJ2 = zzpk.zzJ(map, "ETag");
                if (i != 404 && i != 304) {
                    zzh().zzi(str, bArr, strZzJ, strZzJ2);
                } else if (zzh().zzb(str) == null) {
                    zzh().zzi(str, null, null, null);
                }
                zzhVarZzu.zzI(zzba().currentTimeMillis());
                zzj().zzv(zzhVarZzu, false, false);
                if (i == 404) {
                    zzaW().zzh().zzb("Config not found. Using empty config. appId", str);
                } else {
                    zzaW().zzk().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), numValueOf);
                }
                if (zzi().zzb() && zzaL()) {
                    zzM();
                } else if (zzi().zzb() && zzj().zzD(zzhVarZzu.zzc())) {
                    zzP(zzhVarZzu.zzc());
                } else {
                    zzaM();
                }
            } else {
                zzhVarZzu.zzK(zzba().currentTimeMillis());
                zzj().zzv(zzhVarZzu, false, false);
                zzaW().zzk().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzh().zzf(str);
                this.zzk.zze.zzb(zzba().currentTimeMillis());
                if (i == 503 || i == 429) {
                    this.zzk.zzc.zzb(zzba().currentTimeMillis());
                }
                zzaM();
            }
            zzj().zzc();
            zzj().zzd();
            this.zzu = false;
            zzaN();
        } catch (Throwable th3) {
            zzj().zzd();
            throw th3;
        }
    }

    public final void zzZ(Runnable runnable) {
        zzaX().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    public final /* synthetic */ void zzaA(long j) {
        this.zzJ = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaV() {
        return this.zzn.zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaW() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaX() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaX();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaZ() {
        return this.zzn.zzaZ();
    }

    public final void zzaa() {
        zzaX().zzg();
        zzu();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzab()) {
            FileChannel fileChannel = this.zzy;
            zzaX().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaW().zzb().zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i2 = fileChannel.read(byteBufferAllocate);
                    if (i2 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                    } else if (i2 != -1) {
                        zzaW().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(i2));
                    }
                } catch (IOException e) {
                    zzaW().zzb().zzb("Failed to read from channel", e);
                }
            }
            int iZzm = this.zzn.zzv().zzm();
            zzaX().zzg();
            if (i > iZzm) {
                zzaW().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
                return;
            }
            if (i < iZzm) {
                FileChannel fileChannel2 = this.zzy;
                zzaX().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaW().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iZzm);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
                        return;
                    } catch (IOException e2) {
                        zzaW().zzb().zzb("Failed to write to channel", e2);
                    }
                }
                zzaW().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
            }
        }
    }

    public final boolean zzab() {
        zzaX().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaW().zzk().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzc();
        File filesDir = this.zzn.zzaZ().getFilesDir();
        com.google.android.gms.internal.measurement.zzby.zza();
        int i = com.google.android.gms.internal.measurement.zzcd.$r8$clinit;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzx = fileLockTryLock;
            if (fileLockTryLock != null) {
                zzaW().zzk().zza("Storage concurrent access okay");
                return true;
            }
            zzaW().zzb().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaW().zzb().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaW().zzb().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzaW().zze().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    public final void zzac(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzaw zzawVarZzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZze.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZze.delete("events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseZze.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZze.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZze.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZze.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZze.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseZze.delete("upload_queue", "app_id=?", strArr);
            zzahh.zza();
            zzic zzicVar = zzawVarZzj.zzu;
            if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                iDelete += sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            int iDelete2 = iDelete + sQLiteDatabaseZze.delete("diagnostic_signals", "app_id=?", strArr);
            if (iDelete2 > 0) {
                zzicVar.zzaW().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(iDelete2));
            }
        } catch (SQLiteException e) {
            zzawVarZzj.zzu.zzaW().zzb().zzc("Error resetting analytics data. appId, error", zzgu.zzl(str), e);
        }
        if (zzrVar.zzh) {
            zzai(zzrVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzad(zzpl zzplVar, zzr zzrVar) {
        zzpn zzpnVarZzm;
        long jLongValue;
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzpp zzppVarZzt = zzt();
            String str = zzplVar.zzb;
            int iZzs = zzppVarZzt.zzs(str);
            if (iZzs != 0) {
                zzpp zzppVarZzt2 = zzt();
                zzd();
                zzt().zzP(this.zzK, zzrVar.zza, iZzs, "_ev", zzppVarZzt2.zzE(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int iZzM = zzt().zzM(str, zzplVar.zza());
            if (iZzM != 0) {
                zzpp zzppVarZzt3 = zzt();
                zzd();
                String strZzE = zzppVarZzt3.zzE(str, 24, true);
                Object objZza = zzplVar.zza();
                if (objZza != null && ((objZza instanceof String) || (objZza instanceof CharSequence))) {
                    length = objZza.toString().length();
                }
                zzt().zzP(this.zzK, zzrVar.zza, iZzM, "_ev", strZzE, length);
                return;
            }
            Object objZzN = zzt().zzN(str, zzplVar.zza());
            if (objZzN != null) {
                if ("_sid".equals(str)) {
                    long j = zzplVar.zzc;
                    String str2 = zzplVar.zzf;
                    String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzpn zzpnVarZzm2 = zzj().zzm(str3, "_sno");
                    if (zzpnVarZzm2 != null) {
                        Object obj = zzpnVarZzm2.zze;
                        if (obj instanceof Long) {
                            jLongValue = ((Long) obj).longValue();
                        } else {
                            if (zzpnVarZzm2 != null) {
                                zzaW().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzpnVarZzm2.zze);
                            }
                            zzbd zzbdVarZzf = zzj().zzf(str3, "_s");
                            if (zzbdVarZzf != null) {
                                zzgs zzgsVarZzk = zzaW().zzk();
                                long j2 = zzbdVarZzf.zzc;
                                zzgsVarZzk.zzb("Backfill the session number. Last used session number", Long.valueOf(j2));
                                jLongValue = j2;
                            } else {
                                jLongValue = 0;
                            }
                        }
                        zzad(new zzpl("_sno", j, Long.valueOf(jLongValue + 1), str2), zzrVar);
                    }
                }
                String str4 = zzrVar.zza;
                zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(str4), (String) Preconditions.checkNotNull(zzplVar.zzf), str, zzplVar.zzc, objZzN);
                zzgs zzgsVarZzk2 = zzaW().zzk();
                zzic zzicVar = this.zzn;
                String str5 = zzpnVar.zzc;
                zzgsVarZzk2.zzc("Setting user property", zzicVar.zzl().zzc(str5), objZzN);
                zzj().zzb();
                try {
                    if ("_id".equals(str5) && (zzpnVarZzm = zzj().zzm(str4, "_id")) != null && !zzpnVar.zze.equals(zzpnVarZzm.zze)) {
                        zzj().zzk(str4, "_lair");
                    }
                    zzap(zzrVar);
                    boolean zZzl = zzj().zzl(zzpnVar);
                    if ("_sid".equals(str)) {
                        long jZzu = zzp().zzu(zzrVar.zzu);
                        zzh zzhVarZzu = zzj().zzu(str4);
                        if (zzhVarZzu != null) {
                            zzhVarZzu.zzan(jZzu);
                            if (zzhVarZzu.zza()) {
                                zzj().zzv(zzhVarZzu, false, false);
                            }
                        }
                    }
                    zzj().zzc();
                    if (!zZzl) {
                        zzaW().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzicVar.zzl().zzc(str5), zzpnVar.zze);
                        zzt().zzP(this.zzK, str4, 9, null, null, 0);
                    }
                    zzj().zzd();
                } catch (Throwable th) {
                    zzj().zzd();
                    throw th;
                }
            }
        }
    }

    public final void zzae(String str, zzr zzrVar) {
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            Boolean boolZzaU = zzaU(zzrVar);
            if ("_npa".equals(str) && boolZzaU != null) {
                zzaW().zzj().zza("Falling back to manifest metadata value for ad personalization");
                zzad(new zzpl("_npa", zzba().currentTimeMillis(), Long.valueOf(true != boolZzaU.booleanValue() ? 0L : 1L), "auto"), zzrVar);
                return;
            }
            zzgs zzgsVarZzj = zzaW().zzj();
            zzic zzicVar = this.zzn;
            zzgsVarZzj.zzb("Removing user property", zzicVar.zzl().zzc(str));
            zzj().zzb();
            try {
                zzap(zzrVar);
                if ("_id".equals(str)) {
                    zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                }
                zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
                zzj().zzc();
                zzaW().zzj().zzb("User property removed", zzicVar.zzl().zzc(str));
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    public final void zzaf() {
        this.zzs++;
    }

    public final void zzag() {
        this.zzt++;
    }

    public final zzic zzah() {
        return this.zzn;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x035c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzai(zzr zzrVar) {
        long j;
        zzbd zzbdVarZzf;
        boolean z;
        String str;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j2;
        boolean z2;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        if (zzaS(zzrVar)) {
            zzh zzhVarZzu = zzj().zzu(str2);
            if (zzhVarZzu != null && TextUtils.isEmpty(zzhVarZzu.zzf()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzhVarZzu.zzI(0L);
                zzj().zzv(zzhVarZzu, false, false);
                zzh().zzh(str2);
            }
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            long jCurrentTimeMillis = zzrVar.zzl;
            zzal zzalVarZzd = zzd();
            zzfx zzfxVar = zzfy.zzbe;
            long jElapsedRealtime = zzalVarZzd.zzp(null, zzfxVar) ? zzrVar.zzF : 0L;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = zzba().currentTimeMillis();
                jElapsedRealtime = zzd().zzp(null, zzfxVar) ? zzba().elapsedRealtime() : 0L;
            }
            long j3 = jElapsedRealtime;
            long j4 = jCurrentTimeMillis;
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaW().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgu.zzl(str2), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzb();
            try {
                zzpn zzpnVarZzm = zzj().zzm(str2, "_npa");
                Boolean boolZzaU = zzaU(zzrVar);
                int i2 = i;
                if (zzpnVarZzm != null && !"auto".equals(zzpnVarZzm.zzb)) {
                    j = j4;
                } else if (boolZzaU != null) {
                    zzpl zzplVar = new zzpl("_npa", j4, Long.valueOf(true != boolZzaU.booleanValue() ? 0L : 1L), "auto");
                    j = j4;
                    if (zzpnVarZzm == null || !zzpnVarZzm.zze.equals(zzplVar.zzd)) {
                        zzad(zzplVar, zzrVar);
                    }
                } else {
                    j = j4;
                    if (zzpnVarZzm != null) {
                        zzae("_npa", zzrVar);
                    }
                }
                if (zzd().zzp(null, zzfy.zzaW)) {
                    zzao(zzrVar, zzrVar.zzD);
                } else {
                    zzao(zzrVar, j);
                }
                zzap(zzrVar);
                if (i2 == 0) {
                    zzbdVarZzf = zzj().zzf(str2, "_f");
                    z = false;
                } else {
                    zzbdVarZzf = zzj().zzf(str2, "_v");
                    z = true;
                }
                if (zzbdVarZzf == null) {
                    long j5 = ((j / 3600000) + 1) * 3600000;
                    if (z) {
                        long j6 = j;
                        zzad(new zzpl("_fvt", j6, Long.valueOf(j5), "auto"), zzrVar);
                        zzaX().zzg();
                        zzu();
                        Bundle bundle = new Bundle();
                        bundle.putLong("_c", 1L);
                        bundle.putLong("_r", 1L);
                        bundle.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle.putLong("_dac", 1L);
                        }
                        bundle.putLong("_elt", zzba().currentTimeMillis());
                        zzE(new zzbh("_v", new zzbf(bundle), "auto", j6, j3), zzrVar);
                    } else {
                        Long lValueOf = Long.valueOf(j5);
                        long j7 = j;
                        zzad(new zzpl("_fot", j7, lValueOf, "auto"), zzrVar);
                        zzaX().zzg();
                        zzhk zzhkVar = (zzhk) Preconditions.checkNotNull(this.zzm);
                        if (str2 == null || str2.isEmpty()) {
                            str = "_elt";
                            zzhkVar.zza.zzaW().zzf().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzic zzicVar = zzhkVar.zza;
                            zzicVar.zzaX().zzg();
                            if (zzhkVar.zza()) {
                                zzhj zzhjVar = new zzhj(zzhkVar, str2);
                                zzicVar.zzaX().zzg();
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                str = "_elt";
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzicVar.zzaZ().getPackageManager();
                                if (packageManager == null) {
                                    zzicVar.zzaW().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzhkVar.zza.zzaW().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                                        if (serviceInfo != null) {
                                            String str3 = serviceInfo.packageName;
                                            if (serviceInfo.name != null && "com.android.vending".equals(str3) && zzhkVar.zza()) {
                                                try {
                                                    zzicVar.zzaW().zzk().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzicVar.zzaZ(), new Intent(intent), zzhjVar, 1) ? "available" : "not available");
                                                } catch (RuntimeException e) {
                                                    zzhkVar.zza.zzaW().zzb().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                }
                                            } else {
                                                zzhkVar.zza.zzaW().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzicVar.zzaW().zzi().zza("Install Referrer Reporter is not available");
                                str = "_elt";
                            }
                        }
                        zzaX().zzg();
                        zzu();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong("_pfo", 0L);
                        bundle2.putLong("_sys", 0L);
                        bundle2.putLong("_sysu", 0L);
                        bundle2.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle2.putLong("_dac", 1L);
                        }
                        String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                        zzaw zzawVarZzj = zzj();
                        Preconditions.checkNotEmpty(str4);
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzay();
                        long jZzN = zzawVarZzj.zzN(str4, "first_open_count");
                        zzic zzicVar2 = this.zzn;
                        if (zzicVar2.zzaZ().getPackageManager() == null) {
                            zzaW().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgu.zzl(str4));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(zzicVar2.zzaZ()).getPackageInfo(str4, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                zzaW().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e2);
                                packageInfo = null;
                            }
                            if (packageInfo != null) {
                                long j8 = packageInfo.firstInstallTime;
                                if (j8 != 0) {
                                    if (j8 != packageInfo.lastUpdateTime) {
                                        applicationInfo = null;
                                        if (!zzd().zzp(null, zzfy.zzaI)) {
                                            bundle2.putLong("_uwa", 1L);
                                        } else if (jZzN == 0) {
                                            bundle2.putLong("_uwa", 1L);
                                            jZzN = 0;
                                        }
                                        z2 = false;
                                    } else {
                                        applicationInfo = null;
                                        z2 = true;
                                    }
                                    zzad(new zzpl("_fi", j7, Long.valueOf(true != z2 ? 0L : 1L), "auto"), zzrVar);
                                } else {
                                    applicationInfo = null;
                                }
                                try {
                                    applicationInfo2 = Wrappers.packageManager(this.zzn.zzaZ()).getApplicationInfo(str4, 0);
                                } catch (PackageManager.NameNotFoundException e3) {
                                    zzaW().zzb().zzc("Application info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e3);
                                    applicationInfo2 = applicationInfo;
                                }
                                if (applicationInfo2 != null) {
                                    if ((applicationInfo2.flags & 1) != 0) {
                                        j2 = 1;
                                        bundle2.putLong("_sys", 1L);
                                    } else {
                                        j2 = 1;
                                    }
                                    if ((applicationInfo2.flags & 128) != 0) {
                                        bundle2.putLong("_sysu", j2);
                                    }
                                }
                            }
                        }
                        if (jZzN >= 0) {
                            bundle2.putLong("_pfo", jZzN);
                        }
                        bundle2.putLong(str, zzba().currentTimeMillis());
                        zzE(new zzbh("_f", new zzbf(bundle2), "auto", j7, j3), zzrVar);
                    }
                } else {
                    long j9 = j;
                    if (zzrVar.zzi) {
                        zzE(new zzbh("_cd", new zzbf(new Bundle()), "auto", j9, 0L), zzrVar);
                    }
                }
                zzj().zzc();
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    public final void zzaj(zzr zzrVar) throws Throwable {
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp(null, zzfy.zzay)) {
            long jCurrentTimeMillis = zzba().currentTimeMillis();
            int iZzm = zzd().zzm(null, zzfy.zzah);
            zzd();
            long jZzF = jCurrentTimeMillis - zzal.zzF();
            while (i < iZzm && zzaH(null, jZzF)) {
                i++;
            }
        } else {
            zzd();
            long jZzH = zzal.zzH();
            while (i < jZzH && zzaH(str, 0L)) {
                i++;
            }
        }
        if (zzd().zzp(null, zzfy.zzaz)) {
            zzaX().zzg();
            zzaw();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaW().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzba().currentTimeMillis());
        }
    }

    public final void zzak(zzah zzahVar) {
        zzr zzrVarZzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzrVarZzaP != null) {
            zzal(zzahVar, zzrVarZzaP);
        }
    }

    public final void zzal(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzah zzahVar2 = new zzah(zzahVar);
            boolean z = false;
            zzahVar2.zze = false;
            zzj().zzb();
            try {
                zzah zzahVarZzq = zzj().zzq((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzc.zzb);
                if (zzahVarZzq != null && !zzahVarZzq.zzb.equals(zzahVar2.zzb)) {
                    zzaW().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzb, zzahVarZzq.zzb);
                }
                if (zzahVarZzq != null && zzahVarZzq.zze) {
                    zzahVar2.zzb = zzahVarZzq.zzb;
                    zzahVar2.zzd = zzahVarZzq.zzd;
                    zzahVar2.zzh = zzahVarZzq.zzh;
                    zzahVar2.zzf = zzahVarZzq.zzf;
                    zzahVar2.zzi = zzahVarZzq.zzi;
                    zzahVar2.zze = true;
                    zzpl zzplVar = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar.zzb, zzahVarZzq.zzc.zzc, zzplVar.zza(), zzahVarZzq.zzc.zzf);
                } else if (TextUtils.isEmpty(zzahVar2.zzf)) {
                    zzpl zzplVar2 = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar2.zzb, zzahVar2.zzd, zzplVar2.zza(), zzahVar2.zzc.zzf);
                    zzahVar2.zze = true;
                    z = true;
                }
                if (zzahVar2.zze) {
                    zzpl zzplVar3 = zzahVar2.zzc;
                    zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzb, zzplVar3.zzb, zzplVar3.zzc, Preconditions.checkNotNull(zzplVar3.zza()));
                    if (zzj().zzl(zzpnVar)) {
                        zzaW().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    } else {
                        zzaW().zzb().zzd("(2)Too many active user properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    }
                    if (z && zzahVar2.zzi != null) {
                        zzH(new zzbh(zzahVar2.zzi, zzahVar2.zzd, 0L), zzrVar);
                    }
                }
                if (zzj().zzp(zzahVar2)) {
                    zzaW().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                } else {
                    zzaW().zzb().zzd("Too many conditional properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                }
                zzj().zzc();
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    public final void zzam(zzah zzahVar) {
        zzr zzrVarZzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzrVarZzaP != null) {
            zzan(zzahVar, zzrVarZzaP);
        }
    }

    public final void zzan(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzj().zzb();
            try {
                zzap(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzahVar.zza);
                zzah zzahVarZzq = zzj().zzq(str, zzahVar.zzc.zzb);
                if (zzahVarZzq != null) {
                    zzaW().zzj().zzc("Removing conditional user property", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                    zzj().zzr(str, zzahVar.zzc.zzb);
                    if (zzahVarZzq.zze) {
                        zzj().zzk(str, zzahVar.zzc.zzb);
                    }
                    zzbh zzbhVar = zzahVar.zzk;
                    if (zzbhVar != null) {
                        zzbf zzbfVar = zzbhVar.zzb;
                        zzH((zzbh) Preconditions.checkNotNull(zzt().zzaf(str, ((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, zzbfVar != null ? zzbfVar.zzf() : null, zzahVarZzq.zzb, zzbhVar.zzd, zzbhVar.zze, true, true)), zzrVar);
                    }
                } else {
                    zzaW().zze().zzc("Conditional user property doesn't exist", zzgu.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                }
                zzj().zzc();
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    public final void zzao(zzr zzrVar, long j) {
        zzh zzhVarZzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzhVarZzu != null && zzt().zzD(zzrVar.zzb, zzhVarZzu.zzf())) {
            zzaW().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgu.zzl(zzhVarZzu.zzc()));
            zzaw zzawVarZzj = zzj();
            String strZzc = zzhVarZzu.zzc();
            zzawVarZzj.zzay();
            zzawVarZzj.zzg();
            Preconditions.checkNotEmpty(strZzc);
            try {
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
                String[] strArr = {strZzc};
                int iDelete = sQLiteDatabaseZze.delete("events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZze.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZze.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZze.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZze.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZze.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZze.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseZze.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseZze.delete("diagnostic_signals", "app_id=?", strArr);
                zzahh.zza();
                zzic zzicVar = zzawVarZzj.zzu;
                if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                    iDelete += sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (iDelete > 0) {
                    zzicVar.zzaW().zzk().zzc("Deleted application data. app, records", strZzc, Integer.valueOf(iDelete));
                }
            } catch (SQLiteException e) {
                zzawVarZzj.zzu.zzaW().zzb().zzc("Error deleting application data. appId, error", zzgu.zzl(strZzc), e);
            }
            zzhVarZzu = null;
        }
        if (zzhVarZzu != null) {
            boolean z = (zzhVarZzu.zzt() == -2147483648L || zzhVarZzu.zzt() == zzrVar.zzj) ? false : true;
            String strZzr = zzhVarZzu.zzr();
            if (z || ((zzhVarZzu.zzt() != -2147483648L || strZzr == null || strZzr.equals(zzrVar.zzc)) ? false : true)) {
                zzbh zzbhVar = new zzbh("_au", new zzbf(zzba$$ExternalSyntheticOutline0.m("_pv", strZzr)), "auto", j, 0L);
                if (zzd().zzp(null, zzfy.zzaX)) {
                    zzE(zzbhVar, zzrVar);
                } else {
                    zzF(zzbhVar, zzrVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzap(zzr zzrVar) {
        boolean z;
        String str;
        long j;
        String str2;
        String str3;
        String str4;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str5 = zzrVar.zza;
        Preconditions.checkNotEmpty(str5);
        String str6 = zzrVar.zzt;
        byte[] bArr = null;
        if (!str6.isEmpty()) {
            this.zzE.put(str5, new zzpd(this, str6, bArr));
        }
        zzh zzhVarZzu = zzj().zzu(str5);
        zzjl zzjlVarZzs = zzB(str5).zzs(zzjl.zzf(zzrVar.zzs, 100));
        String strZzf = this.zzk.zzf(zzrVar, zzjlVarZzs);
        boolean z2 = true;
        if (zzhVarZzu == null) {
            zzh zzhVar = new zzh(this.zzn, str5);
            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzhVar.zze(zzK(zzjlVarZzs));
            }
            if (zzjlVarZzs.zzo(zzjk.AD_STORAGE)) {
                zzhVar.zzk(strZzf);
            }
            zzhVarZzu = zzhVar;
        } else if (zzjlVarZzs.zzo(zzjk.AD_STORAGE) && strZzf != null && !strZzf.equals(zzhVarZzu.zzj())) {
            boolean zIsEmpty = TextUtils.isEmpty(zzhVarZzu.zzj());
            zzhVarZzu.zzk(strZzf);
            if (zzrVar.zzn && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzc(zzrVar, zzjlVarZzs).first) && !zIsEmpty) {
                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                    z = false;
                } else {
                    z = true;
                }
                if (zzj().zzm(str5, "_id") != null && zzj().zzm(str5, "_lair") == null) {
                    zzj().zzl(new zzpn(str5, "auto", "_lair", zzba().currentTimeMillis(), 1L));
                }
                zzhVarZzu.zzg(zzrVar.zzb);
                str = zzrVar.zzk;
                if (!TextUtils.isEmpty(str)) {
                    zzhVarZzu.zzm(str);
                }
                j = zzrVar.zze;
                if (j != 0) {
                    zzhVarZzu.zzy(j);
                }
                str2 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str2)) {
                    zzhVarZzu.zzs(str2);
                }
                zzhVarZzu.zzu(zzrVar.zzj);
                str3 = zzrVar.zzd;
                if (str3 != null) {
                    zzhVarZzu.zzw(str3);
                }
                zzhVarZzu.zzA(zzrVar.zzf);
                zzhVarZzu.zzE(zzrVar.zzh);
                str4 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str4)) {
                    zzhVarZzu.zzab(str4);
                }
                zzhVarZzu.zzad(zzrVar.zzn);
                zzhVarZzu.zzaf(zzrVar.zzp);
                zzhVarZzu.zzC(zzrVar.zzq);
                zzhVarZzu.zzi(zzrVar.zzu);
                zzahk.zza();
                if (zzd().zzp(null, zzfy.zzaL)) {
                    zzahk.zza();
                    if (zzd().zzp(null, zzfy.zzaK)) {
                        zzhVarZzu.zzah(null);
                    }
                } else {
                    zzhVarZzu.zzah(zzrVar.zzr);
                }
                zzhVarZzu.zzaj(zzrVar.zzv);
                zzhVarZzu.zzaz(zzrVar.zzB);
                zzaif.zza();
                if (zzd().zzp(null, zzfy.zzaO)) {
                    zzhVarZzu.zzap(zzrVar.zzz);
                }
                zzhVarZzu.zzal(zzrVar.zzw);
                zzhVarZzu.zzaG(zzrVar.zzC);
                zzhVarZzu.zzaK(zzrVar.zzE);
                if (!zzhVarZzu.zza()) {
                    z2 = z;
                } else if (!z) {
                    return zzhVarZzu;
                }
                zzj().zzv(zzhVarZzu, z2, false);
                return zzhVarZzu;
            }
            if (TextUtils.isEmpty(zzhVarZzu.zzd()) && zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzhVarZzu.zze(zzK(zzjlVarZzs));
            }
        } else if (TextUtils.isEmpty(zzhVarZzu.zzd()) && zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
            zzhVarZzu.zze(zzK(zzjlVarZzs));
        }
        z = false;
        zzhVarZzu.zzg(zzrVar.zzb);
        str = zzrVar.zzk;
        if (!TextUtils.isEmpty(str)) {
        }
        j = zzrVar.zze;
        if (j != 0) {
        }
        str2 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str2)) {
        }
        zzhVarZzu.zzu(zzrVar.zzj);
        str3 = zzrVar.zzd;
        if (str3 != null) {
        }
        zzhVarZzu.zzA(zzrVar.zzf);
        zzhVarZzu.zzE(zzrVar.zzh);
        str4 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str4)) {
        }
        zzhVarZzu.zzad(zzrVar.zzn);
        zzhVarZzu.zzaf(zzrVar.zzp);
        zzhVarZzu.zzC(zzrVar.zzq);
        zzhVarZzu.zzi(zzrVar.zzu);
        zzahk.zza();
        if (zzd().zzp(null, zzfy.zzaL)) {
        }
        zzhVarZzu.zzaj(zzrVar.zzv);
        zzhVarZzu.zzaz(zzrVar.zzB);
        zzaif.zza();
        if (zzd().zzp(null, zzfy.zzaO)) {
        }
        zzhVarZzu.zzal(zzrVar.zzw);
        zzhVarZzu.zzaG(zzrVar.zzC);
        zzhVarZzu.zzaK(zzrVar.zzE);
        if (!zzhVarZzu.zza()) {
        }
        zzj().zzv(zzhVarZzu, z2, false);
        return zzhVarZzu;
    }

    public final String zzaq(zzr zzrVar) {
        try {
            return (String) zzaX().zzh(new zzoz(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaW().zzb().zzc("Failed to get app instance id. appId", zzgu.zzl(zzrVar.zza), e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    public final List zzar(zzr zzrVar, Bundle bundle) {
        zzaX().zzg();
        zzaif.zza();
        zzal zzalVarZzd = zzd();
        String str = zzrVar.zza;
        if (!zzalVarZzd.zzp(str, zzfy.zzaO) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzaW().zzb().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzaw zzawVarZzj = zzj();
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzay();
                        try {
                            int iDelete = zzawVarZzj.zze().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            zzgs zzgsVarZzk = zzawVarZzj.zzu.zzaW().zzk();
                            StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(iDelete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            zzgsVarZzk.zzd(sb.toString(), str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzawVarZzj.zzu.zzaW().zzb().zzc("Error pruning trigger URIs. appId", zzgu.zzl(str), e);
                        }
                    }
                }
            }
        }
        zzaw zzawVarZzj2 = zzj();
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzawVarZzj2.zzg();
        zzawVarZzj2.zzay();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zzawVarZzj2.zze().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", ShareConstants.FEED_SOURCE_PARAM}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new zzoh(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                    } while (cursorQuery.moveToNext());
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            zzawVarZzj2.zzu.zzaW().zzb().zzc("Error querying trigger uris. appId", zzgu.zzl(str2), e2);
            arrayList = Collections.EMPTY_LIST;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    public final void zzas(String str, zzaf zzafVar) {
        zzaX().zzg();
        zzu();
        zzaw zzawVarZzj = zzj();
        long j = zzafVar.zza;
        zzpj zzpjVarZzB = zzawVarZzj.zzB(j);
        if (zzpjVarZzB == null) {
            zzaW().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String strZze = zzpjVarZzB.zze();
        if (zzafVar.zzb != zzlr.SUCCESS.zza()) {
            if (zzafVar.zzb == zzlr.BACKOFF.zza()) {
                Map map = this.zzF;
                zzpe zzpeVar = (zzpe) map.get(strZze);
                if (zzpeVar == null) {
                    zzpeVar = new zzpe(this);
                    map.put(strZze, zzpeVar);
                } else {
                    zzpeVar.zza();
                }
                zzaW().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, strZze, Long.valueOf((zzpeVar.zzc() - zzba().currentTimeMillis()) / 1000));
            }
            zzaw zzawVarZzj2 = zzj();
            Long lValueOf = Long.valueOf(zzafVar.zza);
            zzawVarZzj2.zzK(lValueOf);
            zzaW().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, lValueOf);
            return;
        }
        Map map2 = this.zzF;
        if (map2.containsKey(strZze)) {
            map2.remove(strZze);
        }
        zzaw zzawVarZzj3 = zzj();
        Long lValueOf2 = Long.valueOf(j);
        zzawVarZzj3.zzE(lValueOf2);
        zzaW().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, lValueOf2);
        long j2 = zzafVar.zzc;
        if (j2 > 0) {
            zzaw zzawVarZzj4 = zzj();
            zzawVarZzj4.zzg();
            zzawVarZzj4.zzay();
            Long lValueOf3 = Long.valueOf(j2);
            Preconditions.checkNotNull(lValueOf3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("upload_type", Integer.valueOf(zzls.GOOGLE_SIGNAL.zza()));
            zzic zzicVar = zzawVarZzj4.zzu;
            contentValues.put("creation_timestamp", Long.valueOf(zzicVar.zzba().currentTimeMillis()));
            try {
                if (zzawVarZzj4.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzls.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                    zzicVar.zzaW().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, lValueOf3);
                }
                zzaW().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.zzc));
                zzP(str);
            } catch (SQLiteException e) {
                zzawVarZzj4.zzu.zzaW().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                throw e;
            }
        }
    }

    public final void zzat(boolean z) {
        zzaM();
    }

    public final void zzau(String str, zzlu zzluVar) {
        zzaX().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzluVar != null) {
            this.zzH = str;
            this.zzG = zzluVar;
        }
    }

    public final /* synthetic */ void zzav(zzph zzphVar) {
        zzaX().zzg();
        this.zzm = new zzhk(this);
        zzaw zzawVar = new zzaw(this);
        zzawVar.zzaz();
        this.zze = zzawVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznn zznnVar = new zznn(this);
        zznnVar.zzaz();
        this.zzk = zznnVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzaz();
        this.zzh = zzadVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzaz();
        this.zzj = zzlpVar;
        zzok zzokVar = new zzok(this);
        zzokVar.zzaz();
        this.zzg = zzokVar;
        this.zzf = new zzhb(this);
        if (this.zzs != this.zzt) {
            zzaW().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaW().zzk().zza("UploadController is now fully initialized");
    }

    public final /* synthetic */ zzic zzay() {
        return this.zzn;
    }

    public final /* synthetic */ Deque zzaz() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzba() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzba();
    }

    public final void zzc() {
        zzaX().zzg();
        zzj().zzI();
        zzaw zzawVarZzj = zzj();
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        if (zzawVarZzj.zzai()) {
            zzfx zzfxVar = zzfy.zzau;
            if (((Long) zzfxVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
                zzic zzicVar = zzawVarZzj.zzu;
                int iDelete = sQLiteDatabaseZze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzba().currentTimeMillis()), String.valueOf(zzfxVar.zzb(null))});
                if (iDelete > 0) {
                    zzicVar.zzaW().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(iDelete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzba().currentTimeMillis());
        }
        zzaM();
    }

    public final zzal zzd() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzou zzf() {
        return this.zzl;
    }

    public final zzht zzh() {
        zzht zzhtVar = this.zzc;
        zzaT(zzhtVar);
        return zzhtVar;
    }

    public final zzgz zzi() {
        zzgz zzgzVar = this.zzd;
        zzaT(zzgzVar);
        return zzgzVar;
    }

    public final zzaw zzj() {
        zzaw zzawVar = this.zze;
        zzaT(zzawVar);
        return zzawVar;
    }

    public final zzhb zzk() {
        zzhb zzhbVar = this.zzf;
        if (zzhbVar != null) {
            return zzhbVar;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Network broadcast receiver not created");
        return null;
    }

    public final zzok zzl() {
        zzok zzokVar = this.zzg;
        zzaT(zzokVar);
        return zzokVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaT(zzadVar);
        return zzadVar;
    }

    public final zzlp zzn() {
        zzlp zzlpVar = this.zzj;
        zzaT(zzlpVar);
        return zzlpVar;
    }

    public final zzpk zzp() {
        zzpk zzpkVar = this.zzi;
        zzaT(zzpkVar);
        return zzpkVar;
    }

    public final zznn zzq() {
        return this.zzk;
    }

    public final zzgn zzs() {
        return this.zzn.zzl();
    }

    public final zzpp zzt() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzk();
    }

    public final void zzu() {
        if (this.zzo.get()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("UploadController is not initialized");
    }

    public final void zzv(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjl zzjlVarZzf = zzjl.zzf(zzrVar.zzs, zzrVar.zzx);
        zzB(str);
        zzaW().zzk().zzc("Setting storage consent for package", str, zzjlVarZzf);
        zzA(str, zzjlVarZzf);
    }

    public final void zzw(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zzbaVarZzg = zzba.zzg(zzrVar.zzy);
        zzaW().zzk().zzc("Setting DMA consent for package", str, zzbaVarZzg);
        zzaX().zzg();
        zzu();
        zzji zzjiVarZzc = zzba.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzbaVarZzg);
        zzj().zzad(str, zzbaVarZzg);
        zzji zzjiVarZzc2 = zzba.zzh(zzy(str), 100).zzc();
        zzaX().zzg();
        zzu();
        zzji zzjiVar = zzji.DENIED;
        boolean z = zzjiVarZzc == zzjiVar && zzjiVarZzc2 == zzji.GRANTED;
        boolean z2 = zzjiVarZzc == zzji.GRANTED && zzjiVarZzc2 == zzjiVar;
        if (z || z2) {
            zzaW().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfy.zzal)) {
                bundle.putLong("_r", 1L);
                zzaW().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    public final zzba zzx(String str) {
        zzaX().zzg();
        zzu();
        Map map = this.zzD;
        zzba zzbaVar = (zzba) map.get(str);
        if (zzbaVar != null) {
            return zzbaVar;
        }
        zzba zzbaVarZzab = zzj().zzab(str);
        map.put(str, zzbaVarZzab);
        return zzbaVarZzab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final Bundle zzy(String str) {
        zzaX().zzg();
        zzu();
        if (zzh().zzy(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjl zzjlVarZzB = zzB(str);
        bundle.putAll(zzjlVarZzB.zzn());
        bundle.putAll(zzz(str, zzx(str), zzjlVarZzB, new zzan()).zzf());
        zzpn zzpnVarZzm = zzj().zzm(str, "_npa");
        bundle.putString("ad_personalization", 1 != (zzpnVarZzm != null ? zzpnVarZzm.zze.equals(1L) : zzaD(str, new zzan())) ? "granted" : "denied");
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzba zzz(String str, zzba zzbaVar, zzjl zzjlVar, zzan zzanVar) {
        zzji zzjiVar;
        int iZzb = 90;
        if (zzh().zzy(str) == null) {
            if (zzbaVar.zzc() == zzji.DENIED) {
                iZzb = zzbaVar.zzb();
                zzanVar.zzb(zzjk.AD_USER_DATA, iZzb);
            } else {
                zzanVar.zzc(zzjk.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzba(Boolean.FALSE, iZzb, Boolean.TRUE, "-");
        }
        zzji zzjiVarZzc = zzbaVar.zzc();
        zzji zzjiVar2 = zzji.GRANTED;
        if (zzjiVarZzc == zzjiVar2 || zzjiVarZzc == (zzjiVar = zzji.DENIED)) {
            iZzb = zzbaVar.zzb();
            zzanVar.zzb(zzjk.AD_USER_DATA, iZzb);
        } else if (zzjiVarZzc == zzji.POLICY) {
            zzht zzhtVar = this.zzc;
            zzjk zzjkVar = zzjk.AD_USER_DATA;
            zzji zzjiVarZzB = zzhtVar.zzB(str, zzjkVar);
            if (zzjiVarZzB != zzji.UNINITIALIZED) {
                zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
                zzjiVarZzc = zzjiVarZzB;
            } else {
                zzht zzhtVar2 = this.zzc;
                zzjk zzjkVar2 = zzjk.AD_USER_DATA;
                zzjk zzjkVarZzx = zzhtVar2.zzx(str, zzjkVar2);
                zzji zzjiVarZzp = zzjlVar.zzp();
                boolean z = zzjiVarZzp == zzjiVar2 || zzjiVarZzp == zzjiVar;
                if (zzjkVarZzx == zzjk.AD_STORAGE && z) {
                    zzanVar.zzc(zzjkVar2, zzam.REMOTE_DELEGATION);
                    zzjiVarZzc = zzjiVarZzp;
                } else {
                    zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
                    zzjiVarZzc = true != zzhtVar2.zzw(str, zzjkVar2) ? zzjiVar : zzjiVar2;
                }
            }
        }
        boolean zZzz = this.zzc.zzz(str);
        SortedSet sortedSetZzA = zzh().zzA(str);
        if (zzjiVarZzc == zzji.DENIED || sortedSetZzA.isEmpty()) {
            return new zzba(Boolean.FALSE, iZzb, Boolean.valueOf(zZzz), "-");
        }
        return new zzba(Boolean.TRUE, iZzb, Boolean.valueOf(zZzz), zZzz ? TextUtils.join("", sortedSetZzA) : "");
    }
}
