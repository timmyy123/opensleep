package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzyh implements zzabz, zzwz {
    final /* synthetic */ zzyq zza;
    private final long zzb;
    private final Uri zzc;
    private final zzim zzd;
    private final zzyd zze;
    private final zzagb zzf;
    private final zzds zzg;
    private final zzagy zzh;
    private volatile boolean zzi;
    private boolean zzj;
    private long zzk;
    private zzht zzl;
    private zzahk zzm;
    private boolean zzn;

    public zzyh(zzyq zzyqVar, Uri uri, zzhp zzhpVar, zzyd zzydVar, zzagb zzagbVar, zzds zzdsVar) {
        Objects.requireNonNull(zzyqVar);
        this.zza = zzyqVar;
        this.zzc = uri;
        this.zzd = new zzim(zzhpVar);
        this.zze = zzydVar;
        this.zzf = zzagbVar;
        this.zzg = zzdsVar;
        this.zzh = new zzagy();
        this.zzj = true;
        this.zzb = zzxb.zza();
        this.zzl = zzi(0L, null);
    }

    private final zzht zzi(long j, String str) {
        Map mapZzd = zzyq.zzb;
        if (str != null && !str.startsWith("W/")) {
            zzgwo zzgwoVar = new zzgwo();
            zzgwoVar.zzb(mapZzd.entrySet());
            zzgwoVar.zza("If-Range", str);
            mapZzd = zzgwoVar.zzd();
        }
        zzhs zzhsVar = new zzhs();
        zzhsVar.zza(this.zzc);
        zzhsVar.zzc(j);
        zzhsVar.zzd(6);
        zzhsVar.zzb(mapZzd);
        return zzhsVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzet zzetVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(this.zza.zzI(true), this.zzk);
        int iZzd = zzetVar.zzd();
        zzahk zzahkVar = this.zzm;
        zzahkVar.getClass();
        zzahkVar.zzc(zzetVar, iZzd);
        zzahkVar.zze(jMax, 1, iZzd, 0, null);
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzb() {
        this.zzi = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x020e A[EDGE_INSN: B:140:0x020e->B:99:0x020e BREAK  A[LOOP:1: B:86:0x01d5->B:143:0x01d5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0114 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0131 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0171 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0187 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c0 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c7 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d3  */
    @Override // com.google.android.gms.internal.ads.zzabz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc() throws Throwable {
        int i;
        long j;
        int i2;
        long j2;
        zzim zzimVar;
        long jZzb;
        int i3;
        int i4;
        boolean z;
        List list;
        String str;
        List list2;
        String str2;
        List list3;
        String str3;
        List list4;
        boolean zEquals;
        List list5;
        int i5;
        zzim zzimVar2;
        zzyq zzyqVar;
        zzj zzjVar;
        int iZzf;
        int i6;
        int i7 = 0;
        String str4 = null;
        for (int i8 = 0; i8 == 0 && !this.zzi; i8 = iZzf) {
            try {
                j2 = this.zzh.zza;
                zzht zzhtVarZzi = zzi(j2, str4);
                this.zzl = zzhtVarZzi;
                zzimVar = this.zzd;
                jZzb = zzimVar.zzb(zzhtVarZzi);
            } catch (Throwable th) {
                th = th;
                i = i7;
                j = -1;
            }
            if (this.zzi) {
                zzyd zzydVar = this.zze;
                if (zzydVar.zzd() != -1) {
                    this.zzh.zza = zzydVar.zzd();
                }
                zzhr.zza(this.zzd);
                return;
            }
            List list6 = (List) zzimVar.zzj().get("ETag");
            str4 = (list6 == null || list6.isEmpty()) ? null : (String) list6.get(i7);
            if (jZzb != -1) {
                jZzb += j2;
                this.zza.zzH();
            }
            long j3 = jZzb;
            zzyq zzyqVar2 = this.zza;
            Map mapZzj = zzimVar.zzj();
            List list7 = (List) mapZzj.get("icy-br");
            j = -1;
            if (list7 != null) {
                try {
                    String str5 = (String) list7.get(i7);
                    try {
                        i3 = Integer.parseInt(str5) * 1000;
                    } catch (NumberFormatException unused) {
                        i3 = -1;
                    }
                    if (i3 > 0) {
                        i4 = i3;
                        z = true;
                        list = (List) mapZzj.get("icy-genre");
                        if (list != null) {
                            str = (String) list.get(0);
                            z = true;
                        } else {
                            str = null;
                        }
                        list2 = (List) mapZzj.get("icy-name");
                        if (list2 != null) {
                            str2 = (String) list2.get(0);
                            z = true;
                        } else {
                            str2 = null;
                        }
                        list3 = (List) mapZzj.get("icy-url");
                        if (list3 != null) {
                            str3 = (String) list3.get(0);
                            z = true;
                        } else {
                            str3 = null;
                        }
                        list4 = (List) mapZzj.get("icy-pub");
                        if (list4 != null) {
                            zEquals = ((String) list4.get(0)).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                            z = true;
                        } else {
                            zEquals = false;
                        }
                        list5 = (List) mapZzj.get("icy-metaint");
                        if (list5 != null) {
                            String str6 = (String) list5.get(0);
                            try {
                                i6 = Integer.parseInt(str6);
                            } catch (NumberFormatException unused2) {
                                i6 = -1;
                            }
                            if (i6 > 0) {
                                i5 = i6;
                                z = true;
                                zzyqVar2.zzP(z ? new zzajd(i4, str, str2, str3, zEquals, i5) : null);
                                zzimVar2 = this.zzd;
                                zzyqVar = this.zza;
                                if (zzyqVar.zzO() == null || zzyqVar.zzO().zzf == -1) {
                                    zzjVar = zzimVar2;
                                } else {
                                    zzxa zzxaVar = new zzxa(zzimVar2, zzyqVar.zzO().zzf, this);
                                    zzahk zzahkVarZzx = zzyqVar.zzx();
                                    this.zzm = zzahkVarZzx;
                                    zzahkVarZzx.zzA(zzyq.zzc);
                                    zzjVar = zzxaVar;
                                }
                                zzyd zzydVar2 = this.zze;
                                zzydVar2.zza(zzjVar, this.zzc, zzimVar2.zzj(), j2, j3, this.zzf);
                                if (zzyqVar.zzO() != null) {
                                    zzydVar2.zzc();
                                }
                                if (this.zzj) {
                                    i = 0;
                                } else {
                                    zzydVar2.zze(j2, this.zzk);
                                    i = 0;
                                    try {
                                        this.zzj = false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        i2 = i;
                                    }
                                }
                                iZzf = i;
                                while (true) {
                                    if (iZzf == 0) {
                                        break;
                                    }
                                    try {
                                        if (this.zzi) {
                                            iZzf = i;
                                            break;
                                        }
                                        try {
                                            zzds zzdsVar = this.zzg;
                                            zzdsVar.zzc();
                                            iZzf = zzydVar2.zzf(this.zzh);
                                            long jZzd = zzydVar2.zzd();
                                            if (jZzd > zzyqVar.zzL() + j2) {
                                                zzdsVar.zzb();
                                                zzyqVar.zzN().post(zzyqVar.zzM());
                                                j2 = jZzd;
                                            }
                                        } catch (InterruptedException unused3) {
                                            throw new InterruptedIOException();
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        i2 = iZzf;
                                    }
                                }
                                if (iZzf != 1) {
                                    iZzf = i;
                                } else if (zzydVar2.zzd() != -1) {
                                    this.zzh.zza = zzydVar2.zzd();
                                }
                                zzhr.zza(zzimVar2);
                                i7 = i;
                            } else {
                                try {
                                    StringBuilder sb = new StringBuilder(String.valueOf(str6).length() + 27);
                                    sb.append("Invalid metadata interval: ");
                                    sb.append(str6);
                                    zzeg.zzc("IcyHeaders", sb.toString());
                                    i5 = -1;
                                } catch (NumberFormatException unused4) {
                                    zzeg.zzc("IcyHeaders", "Invalid metadata interval: ".concat(String.valueOf(str6)));
                                    i5 = i6;
                                }
                                zzyqVar2.zzP(z ? new zzajd(i4, str, str2, str3, zEquals, i5) : null);
                                zzimVar2 = this.zzd;
                                zzyqVar = this.zza;
                                if (zzyqVar.zzO() == null) {
                                    zzjVar = zzimVar2;
                                    zzyd zzydVar22 = this.zze;
                                    zzydVar22.zza(zzjVar, this.zzc, zzimVar2.zzj(), j2, j3, this.zzf);
                                    if (zzyqVar.zzO() != null) {
                                    }
                                    if (this.zzj) {
                                    }
                                    iZzf = i;
                                    while (true) {
                                        if (iZzf == 0) {
                                        }
                                    }
                                    if (iZzf != 1) {
                                    }
                                    zzhr.zza(zzimVar2);
                                    i7 = i;
                                }
                            }
                        } else {
                            i5 = -1;
                            zzyqVar2.zzP(z ? new zzajd(i4, str, str2, str3, zEquals, i5) : null);
                            zzimVar2 = this.zzd;
                            zzyqVar = this.zza;
                            if (zzyqVar.zzO() == null) {
                            }
                        }
                    } else {
                        try {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 17);
                            sb2.append("Invalid bitrate: ");
                            sb2.append(str5);
                            zzeg.zzc("IcyHeaders", sb2.toString());
                            z = false;
                            i4 = -1;
                        } catch (NumberFormatException unused5) {
                            zzeg.zzc("IcyHeaders", "Invalid bitrate header: ".concat(String.valueOf(str5)));
                            i4 = i3;
                            z = false;
                        }
                        list = (List) mapZzj.get("icy-genre");
                        if (list != null) {
                        }
                        list2 = (List) mapZzj.get("icy-name");
                        if (list2 != null) {
                        }
                        list3 = (List) mapZzj.get("icy-url");
                        if (list3 != null) {
                        }
                        list4 = (List) mapZzj.get("icy-pub");
                        if (list4 != null) {
                        }
                        list5 = (List) mapZzj.get("icy-metaint");
                        if (list5 != null) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    i = 0;
                    i2 = i;
                    if (i2 != 1) {
                    }
                    zzhr.zza(this.zzd);
                    throw th;
                }
            } else {
                z = false;
                i4 = -1;
                list = (List) mapZzj.get("icy-genre");
                if (list != null) {
                }
                list2 = (List) mapZzj.get("icy-name");
                if (list2 != null) {
                }
                list3 = (List) mapZzj.get("icy-url");
                if (list3 != null) {
                }
                list4 = (List) mapZzj.get("icy-pub");
                if (list4 != null) {
                }
                list5 = (List) mapZzj.get("icy-metaint");
                if (list5 != null) {
                }
            }
            if (i2 != 1) {
                zzyd zzydVar3 = this.zze;
                if (zzydVar3.zzd() != j) {
                    this.zzh.zza = zzydVar3.zzd();
                }
            }
            zzhr.zza(this.zzd);
            throw th;
        }
    }

    public final /* synthetic */ void zzd(long j, long j2) {
        this.zzh.zza = j;
        this.zzk = j2;
        this.zzj = true;
        this.zzn = false;
    }

    public final /* synthetic */ long zze() {
        return this.zzb;
    }

    public final /* synthetic */ zzim zzf() {
        return this.zzd;
    }

    public final /* synthetic */ long zzg() {
        return this.zzk;
    }

    public final /* synthetic */ zzht zzh() {
        return this.zzl;
    }
}
