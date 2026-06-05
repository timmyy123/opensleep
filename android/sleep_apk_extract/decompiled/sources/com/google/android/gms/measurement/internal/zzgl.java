package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgl extends zzg {
    private static final String[] zza = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    private final zzgj zzb;
    private boolean zzc;

    public zzgl(zzic zzicVar) {
        super(zzicVar);
        Context contextZzaZ = this.zzu.zzaZ();
        this.zzu.zzc();
        this.zzb = new zzgj(this, contextZzaZ, "google_app_measurement_local.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5 A[Catch: SQLiteException -> 0x009a, SQLiteDatabaseLockedException -> 0x00a1, SQLiteFullException -> 0x00a5, all -> 0x0167, TRY_ENTER, TryCatch #3 {all -> 0x0167, blocks: (B:30:0x008f, B:32:0x0095, B:43:0x00b5, B:45:0x00da, B:47:0x00e4, B:49:0x00ec, B:59:0x0106, B:73:0x012e, B:75:0x0134, B:76:0x0137, B:93:0x016e, B:83:0x0157), top: B:107:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0163 A[PHI: r8 r10 r17
      0x0163: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:79:0x014f, B:96:0x0185, B:87:0x0161] A[DONT_GENERATE, DONT_INLINE]
      0x0163: PHI (r10v8 android.database.sqlite.SQLiteDatabase) = 
      (r10v6 android.database.sqlite.SQLiteDatabase)
      (r10v7 android.database.sqlite.SQLiteDatabase)
      (r10v9 android.database.sqlite.SQLiteDatabase)
     binds: [B:79:0x014f, B:96:0x0185, B:87:0x0161] A[DONT_GENERATE, DONT_INLINE]
      0x0163: PHI (r17v7 boolean) = (r17v4 boolean), (r17v5 boolean), (r17v8 boolean) binds: [B:79:0x014f, B:96:0x0185, B:87:0x0161] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzs(int i, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseZzp;
        boolean z;
        boolean z2;
        Cursor cursorRawQuery;
        zzg();
        boolean z3 = false;
        z3 = false;
        if (!this.zzc) {
            zzic zzicVar = this.zzu;
            zzal zzalVarZzc = zzicVar.zzc();
            zzfx zzfxVar = zzfy.zzaW;
            Cursor cursor = null;
            cursor = null;
            zzr zzrVarZzh = zzalVarZzc.zzp(null, zzfxVar) ? this.zzu.zzv().zzh(null) : null;
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("entry", bArr);
            if (zzicVar.zzc().zzp(null, zzfxVar) && zzrVarZzh != null) {
                contentValues.put("app_version", zzrVarZzh.zzc);
                contentValues.put("app_version_int", Long.valueOf(zzrVarZzh.zzj));
            }
            zzicVar.zzc();
            int i2 = 0;
            int i3 = 5;
            for (int i4 = 5; i2 < i4; i4 = 5) {
                try {
                    sQLiteDatabaseZzp = zzp();
                } catch (SQLiteDatabaseLockedException unused) {
                    z = z3 ? 1 : 0;
                    sQLiteDatabaseZzp = null;
                    cursorRawQuery = null;
                } catch (SQLiteFullException e) {
                    e = e;
                    z = z3 ? 1 : 0;
                    sQLiteDatabaseZzp = null;
                    cursorRawQuery = null;
                } catch (SQLiteException e2) {
                    e = e2;
                    z = z3 ? 1 : 0;
                    z2 = true;
                    sQLiteDatabaseZzp = null;
                    cursorRawQuery = null;
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabaseZzp = null;
                }
                if (sQLiteDatabaseZzp == null) {
                    this.zzc = true;
                } else {
                    try {
                        sQLiteDatabaseZzp.beginTransaction();
                        cursorRawQuery = sQLiteDatabaseZzp.rawQuery("select count(1) from messages", null);
                        long j = 0;
                        if (cursorRawQuery == null) {
                            if (j < 100000) {
                            }
                            sQLiteDatabaseZzp.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabaseZzp.setTransactionSuccessful();
                            sQLiteDatabaseZzp.endTransaction();
                            if (cursorRawQuery != null) {
                            }
                            sQLiteDatabaseZzp.close();
                            return z2;
                        }
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                j = cursorRawQuery.getLong(z3 ? 1 : 0);
                            }
                            if (j < 100000) {
                                zzicVar.zzaW().zzb().zza("Data loss, local db full");
                                long j2 = 100001 - j;
                                long jDelete = sQLiteDatabaseZzp.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                                if (jDelete != j2) {
                                    zzgs zzgsVarZzb = zzicVar.zzaW().zzb();
                                    z = z3 ? 1 : 0;
                                    try {
                                        try {
                                            z2 = true;
                                        } catch (SQLiteDatabaseLockedException unused2) {
                                            SystemClock.sleep(i3);
                                            i3 += 20;
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            if (sQLiteDatabaseZzp == null) {
                                                sQLiteDatabaseZzp.close();
                                            }
                                            i2++;
                                            z3 = z;
                                        }
                                        try {
                                            zzgsVarZzb.zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                                        } catch (SQLiteFullException e3) {
                                            e = e3;
                                            this.zzu.zzaW().zzb().zzb("Error writing entry; local database full", e);
                                            this.zzc = true;
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            if (sQLiteDatabaseZzp != null) {
                                            }
                                            i2++;
                                            z3 = z;
                                        } catch (SQLiteException e4) {
                                            e = e4;
                                            if (sQLiteDatabaseZzp != null) {
                                                try {
                                                    if (sQLiteDatabaseZzp.inTransaction()) {
                                                        sQLiteDatabaseZzp.endTransaction();
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    cursor = cursorRawQuery;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    if (sQLiteDatabaseZzp != null) {
                                                        sQLiteDatabaseZzp.close();
                                                    }
                                                    throw th;
                                                }
                                            }
                                            this.zzu.zzaW().zzb().zzb("Error writing entry to local database", e);
                                            this.zzc = z2;
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            if (sQLiteDatabaseZzp != null) {
                                            }
                                            i2++;
                                            z3 = z;
                                        }
                                    } catch (SQLiteFullException e5) {
                                        e = e5;
                                        this.zzu.zzaW().zzb().zzb("Error writing entry; local database full", e);
                                        this.zzc = true;
                                        if (cursorRawQuery != null) {
                                        }
                                        if (sQLiteDatabaseZzp != null) {
                                        }
                                        i2++;
                                        z3 = z;
                                    } catch (SQLiteException e6) {
                                        e = e6;
                                        z2 = true;
                                        if (sQLiteDatabaseZzp != null) {
                                        }
                                        this.zzu.zzaW().zzb().zzb("Error writing entry to local database", e);
                                        this.zzc = z2;
                                        if (cursorRawQuery != null) {
                                        }
                                        if (sQLiteDatabaseZzp != null) {
                                        }
                                        i2++;
                                        z3 = z;
                                    }
                                } else {
                                    z = z3 ? 1 : 0;
                                    z2 = true;
                                }
                            }
                            sQLiteDatabaseZzp.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabaseZzp.setTransactionSuccessful();
                            sQLiteDatabaseZzp.endTransaction();
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            sQLiteDatabaseZzp.close();
                            return z2;
                        } catch (SQLiteDatabaseLockedException unused3) {
                            z = z3 ? 1 : 0;
                            SystemClock.sleep(i3);
                            i3 += 20;
                            if (cursorRawQuery != null) {
                            }
                            if (sQLiteDatabaseZzp == null) {
                            }
                            i2++;
                            z3 = z;
                        } catch (SQLiteFullException e7) {
                            e = e7;
                            z = z3 ? 1 : 0;
                            this.zzu.zzaW().zzb().zzb("Error writing entry; local database full", e);
                            this.zzc = true;
                            if (cursorRawQuery != null) {
                            }
                            if (sQLiteDatabaseZzp != null) {
                            }
                            i2++;
                            z3 = z;
                        } catch (SQLiteException e8) {
                            e = e8;
                            z = z3 ? 1 : 0;
                            z2 = true;
                            if (sQLiteDatabaseZzp != null) {
                            }
                            this.zzu.zzaW().zzb().zzb("Error writing entry to local database", e);
                            this.zzc = z2;
                            if (cursorRawQuery != null) {
                            }
                            if (sQLiteDatabaseZzp != null) {
                            }
                            i2++;
                            z3 = z;
                        }
                    } catch (SQLiteDatabaseLockedException unused4) {
                        z = z3 ? 1 : 0;
                        cursorRawQuery = null;
                    } catch (SQLiteFullException e9) {
                        e = e9;
                        z = z3 ? 1 : 0;
                        cursorRawQuery = null;
                    } catch (SQLiteException e10) {
                        e = e10;
                        z = z3 ? 1 : 0;
                        z2 = true;
                        cursorRawQuery = null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabaseZzp != null) {
                        }
                        throw th;
                    }
                    i2++;
                    z3 = z;
                }
            }
            boolean z4 = z3 ? 1 : 0;
            this.zzu.zzaW().zzk().zza("Failed to write entry to local database");
            return z4;
        }
        return z3;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return false;
    }

    public final void zzh() {
        int iDelete;
        zzg();
        try {
            SQLiteDatabase sQLiteDatabaseZzp = zzp();
            if (sQLiteDatabaseZzp == null || (iDelete = sQLiteDatabaseZzp.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzu.zzaW().zzk().zzb("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzi(zzbh zzbhVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzbi.zza(zzbhVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzs(0, bArrMarshall);
        }
        this.zzu.zzaW().zzc().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzj(zzpl zzplVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzpm.zza(zzplVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzs(1, bArrMarshall);
        }
        this.zzu.zzaW().zzc().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzk(zzah zzahVar) {
        zzic zzicVar = this.zzu;
        byte[] bArrZzah = zzicVar.zzk().zzah(zzahVar);
        if (bArrZzah.length <= 131072) {
            return zzs(2, bArrZzah);
        }
        zzicVar.zzaW().zzc().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzl(zzbf zzbfVar) {
        zzic zzicVar = this.zzu;
        byte[] bArrZzah = zzicVar.zzk().zzah(zzbfVar);
        if (bArrZzah == null) {
            zzicVar.zzaW().zzc().zza("Null default event parameters; not writing to database");
            return false;
        }
        if (bArrZzah.length <= 131072) {
            return zzs(4, bArrZzah);
        }
        zzicVar.zzaW().zzc().zza("Default event parameters too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:186:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x036b A[PHI: r6 r11 r13 r17 r19 r21
      0x036b: PHI (r6v14 int) = (r6v7 int), (r6v10 int), (r6v15 int) binds: [B:187:0x0352, B:204:0x0390, B:195:0x0369] A[DONT_GENERATE, DONT_INLINE]
      0x036b: PHI (r11v3 int) = (r11v1 int), (r11v1 int), (r11v4 int) binds: [B:187:0x0352, B:204:0x0390, B:195:0x0369] A[DONT_GENERATE, DONT_INLINE]
      0x036b: PHI (r13v9 ??) = (r13v5 ??), (r13v7 ??), (r13v10 ??) binds: [B:187:0x0352, B:204:0x0390, B:195:0x0369] A[DONT_GENERATE, DONT_INLINE]
      0x036b: PHI (r17v8 java.lang.String) = (r17v3 java.lang.String), (r17v5 java.lang.String), (r17v9 java.lang.String) binds: [B:187:0x0352, B:204:0x0390, B:195:0x0369] A[DONT_GENERATE, DONT_INLINE]
      0x036b: PHI (r19v8 java.lang.String) = (r19v3 java.lang.String), (r19v5 java.lang.String), (r19v9 java.lang.String) binds: [B:187:0x0352, B:204:0x0390, B:195:0x0369] A[DONT_GENERATE, DONT_INLINE]
      0x036b: PHI (r21v8 java.lang.String) = (r21v3 java.lang.String), (r21v5 java.lang.String), (r21v9 java.lang.String) binds: [B:187:0x0352, B:204:0x0390, B:195:0x0369] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0334 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0393 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0393 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0393 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [android.database.sqlite.SQLiteClosable, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r15v5, types: [com.google.android.gms.measurement.internal.zzal] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v16, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r17v43 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzm(int i) {
        Cursor cursor;
        ?? r13;
        String str;
        String str2;
        String str3;
        int i2;
        ?? Zzp;
        Cursor cursorQuery;
        Cursor cursorQuery2;
        long j;
        long j2;
        ?? r17;
        ?? r16;
        int i3;
        zzfx zzfxVar;
        int i4;
        int i5;
        int i6;
        zzic zzicVar;
        long j3;
        String string;
        zzic zzicVar2;
        zzbh zzbhVarCreateFromParcel;
        int i7;
        int i8;
        zzbf zzbfVarCreateFromParcel;
        zzah zzahVarCreateFromParcel;
        zzpl zzplVarCreateFromParcel;
        String str4 = "entry";
        String str5 = "type";
        String str6 = "rowid";
        zzg();
        ?? r6 = 0;
        if (this.zzc) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!zzq()) {
            return arrayList;
        }
        int i9 = 0;
        int i10 = 5;
        int i11 = 0;
        for (int i12 = 5; i11 < i12; i12 = 5) {
            try {
                Zzp = zzp();
                try {
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    r13 = Zzp;
                    if (cursor != null) {
                    }
                    if (r13 != 0) {
                    }
                    throw th;
                }
            } catch (SQLiteDatabaseLockedException unused) {
                str = str4;
                str2 = str5;
                str3 = str6;
                i2 = i9;
                Zzp = 0;
            } catch (SQLiteFullException e) {
                e = e;
                str = str4;
                str2 = str5;
                str3 = str6;
                i2 = i9;
                Zzp = 0;
            } catch (SQLiteException e2) {
                e = e2;
                str = str4;
                str2 = str5;
                str3 = str6;
                i2 = i9;
                Zzp = 0;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                r13 = 0;
            }
            if (Zzp == 0) {
                this.zzc = true;
                return r6;
            }
            try {
                Zzp.beginTransaction();
                try {
                    cursorQuery2 = Zzp.query("messages", new String[]{str6}, "type=?", new String[]{"3"}, null, null, "rowid desc", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    try {
                        j = -1;
                        if (cursorQuery2.moveToFirst()) {
                            j2 = cursorQuery2.getLong(i9);
                            cursorQuery2.close();
                        } else {
                            cursorQuery2.close();
                            j2 = -1;
                        }
                        if (j2 != -1) {
                            String[] strArr = new String[1];
                            strArr[i9] = String.valueOf(j2);
                            r16 = "rowid<?";
                            r17 = strArr;
                        } else {
                            ?? r162 = r6;
                            r17 = r162;
                            r16 = r162;
                        }
                        String[] strArr2 = {str6, str5, str4};
                        zzic zzicVar3 = this.zzu;
                        ?? Zzc = zzicVar3.zzc();
                        i3 = 1;
                        zzfxVar = zzfy.zzaW;
                        boolean zZzp = Zzc.zzp(r6, zzfxVar);
                        i4 = 4;
                        i5 = 3;
                        i6 = 2;
                        if (zZzp) {
                            strArr2 = new String[i12];
                            strArr2[i9] = str6;
                            strArr2[1] = str5;
                            strArr2[2] = str4;
                            strArr2[3] = "app_version";
                            strArr2[4] = "app_version_int";
                        }
                        String[] strArr3 = strArr2;
                        zzicVar = zzicVar3;
                        cursorQuery = Zzp.query("messages", strArr3, r16, r17, null, null, "rowid asc", Integer.toString(100));
                    } catch (Throwable th3) {
                        th = th3;
                        str = str4;
                        str2 = str5;
                        str3 = str6;
                        i2 = i9;
                        if (cursorQuery2 != null) {
                            try {
                                cursorQuery2.close();
                            } catch (SQLiteDatabaseLockedException unused2) {
                                cursorQuery = null;
                                SystemClock.sleep(i10);
                                i10 += 20;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (Zzp == 0) {
                                    Zzp.close();
                                }
                                i11++;
                                i9 = i2;
                                str4 = str;
                                str5 = str2;
                                str6 = str3;
                                r6 = 0;
                            } catch (SQLiteFullException e3) {
                                e = e3;
                                Zzp = Zzp;
                                cursorQuery = null;
                                this.zzu.zzaW().zzb().zzb("Error reading entries from local database", e);
                                this.zzc = true;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (Zzp == 0) {
                                }
                                i11++;
                                i9 = i2;
                                str4 = str;
                                str5 = str2;
                                str6 = str3;
                                r6 = 0;
                            } catch (SQLiteException e4) {
                                e = e4;
                                Zzp = Zzp;
                                cursorQuery = null;
                                if (Zzp != 0) {
                                    try {
                                        if (Zzp.inTransaction()) {
                                            Zzp.endTransaction();
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        cursor = cursorQuery;
                                        r13 = Zzp;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (r13 != 0) {
                                            r13.close();
                                        }
                                        throw th;
                                    }
                                }
                                this.zzu.zzaW().zzb().zzb("Error reading entries from local database", e);
                                this.zzc = true;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (Zzp == 0) {
                                }
                                i11++;
                                i9 = i2;
                                str4 = str;
                                str5 = str2;
                                str6 = str3;
                                r6 = 0;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str = str4;
                    str2 = str5;
                    str3 = str6;
                    i2 = i9;
                    cursorQuery2 = null;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                str = str4;
                str2 = str5;
                str3 = str6;
                i2 = i9;
            } catch (SQLiteFullException e5) {
                e = e5;
                str = str4;
                str2 = str5;
                str3 = str6;
                i2 = i9;
                Zzp = Zzp;
            } catch (SQLiteException e6) {
                e = e6;
                str = str4;
                str2 = str5;
                str3 = str6;
                i2 = i9;
                Zzp = Zzp;
            }
            while (cursorQuery.moveToNext()) {
                try {
                    j = cursorQuery.getLong(i9);
                    int i13 = cursorQuery.getInt(i3);
                    byte[] blob = cursorQuery.getBlob(i6);
                    try {
                        if (zzicVar.zzc().zzp(null, zzfxVar)) {
                            string = cursorQuery.getString(i5);
                            j3 = cursorQuery.getLong(i4);
                        } else {
                            j3 = 0;
                            string = null;
                        }
                        String str7 = str4;
                        long j4 = j3;
                        str2 = str5;
                        if (i13 == 0) {
                            try {
                                Parcel parcelObtain = Parcel.obtain();
                                zzicVar2 = zzicVar;
                                try {
                                    str3 = str6;
                                    try {
                                        try {
                                            parcelObtain.unmarshall(blob, 0, blob.length);
                                            parcelObtain.setDataPosition(0);
                                            zzbhVarCreateFromParcel = zzbh.CREATOR.createFromParcel(parcelObtain);
                                        } catch (Throwable th6) {
                                            th = th6;
                                            throw th;
                                        }
                                    } catch (SafeParcelReader.ParseException unused4) {
                                        this.zzu.zzaW().zzb().zza("Failed to load event from local database");
                                        parcelObtain.recycle();
                                    }
                                } catch (SafeParcelReader.ParseException unused5) {
                                    str3 = str6;
                                } catch (Throwable th7) {
                                    th = th7;
                                }
                                try {
                                    if (zzbhVarCreateFromParcel != null) {
                                        arrayList.add(new zzgk(zzbhVarCreateFromParcel, string, j4));
                                    }
                                    str = str7;
                                    i8 = 2;
                                    i7 = 3;
                                    i2 = 0;
                                    i5 = i7;
                                    i9 = i2;
                                    str4 = str;
                                    str5 = str2;
                                    str6 = str3;
                                    i3 = 1;
                                    i4 = 4;
                                    i6 = i8;
                                    zzicVar = zzicVar2;
                                } catch (SQLiteDatabaseLockedException unused6) {
                                    str = str7;
                                    i2 = 0;
                                    SystemClock.sleep(i10);
                                    i10 += 20;
                                    if (cursorQuery != null) {
                                    }
                                    if (Zzp == 0) {
                                    }
                                    i11++;
                                    i9 = i2;
                                    str4 = str;
                                    str5 = str2;
                                    str6 = str3;
                                    r6 = 0;
                                } catch (SQLiteFullException e7) {
                                    e = e7;
                                    str = str7;
                                    i2 = 0;
                                    this.zzu.zzaW().zzb().zzb("Error reading entries from local database", e);
                                    this.zzc = true;
                                    if (cursorQuery != null) {
                                    }
                                    if (Zzp == 0) {
                                    }
                                    i11++;
                                    i9 = i2;
                                    str4 = str;
                                    str5 = str2;
                                    str6 = str3;
                                    r6 = 0;
                                } catch (SQLiteException e8) {
                                    e = e8;
                                    str = str7;
                                    i2 = 0;
                                    if (Zzp != 0) {
                                    }
                                    this.zzu.zzaW().zzb().zzb("Error reading entries from local database", e);
                                    this.zzc = true;
                                    if (cursorQuery != null) {
                                    }
                                    if (Zzp == 0) {
                                    }
                                    i11++;
                                    i9 = i2;
                                    str4 = str;
                                    str5 = str2;
                                    str6 = str3;
                                    r6 = 0;
                                }
                            } catch (SQLiteDatabaseLockedException unused7) {
                                str3 = str6;
                            } catch (SQLiteFullException e9) {
                                e = e9;
                                str3 = str6;
                            } catch (SQLiteException e10) {
                                e = e10;
                                str3 = str6;
                            }
                        } else {
                            zzicVar2 = zzicVar;
                            str3 = str6;
                            if (i13 == 1) {
                                Parcel parcelObtain2 = Parcel.obtain();
                                try {
                                    try {
                                        parcelObtain2.unmarshall(blob, 0, blob.length);
                                        parcelObtain2.setDataPosition(0);
                                        zzplVarCreateFromParcel = zzpl.CREATOR.createFromParcel(parcelObtain2);
                                    } finally {
                                        parcelObtain2.recycle();
                                    }
                                } catch (SafeParcelReader.ParseException unused8) {
                                    this.zzu.zzaW().zzb().zza("Failed to load user property from local database");
                                    parcelObtain2.recycle();
                                    zzplVarCreateFromParcel = null;
                                }
                                if (zzplVarCreateFromParcel != null) {
                                    arrayList.add(new zzgk(zzplVarCreateFromParcel, string, j4));
                                }
                                str = str7;
                                i8 = 2;
                                i7 = 3;
                                i2 = 0;
                                i5 = i7;
                                i9 = i2;
                                str4 = str;
                                str5 = str2;
                                str6 = str3;
                                i3 = 1;
                                i4 = 4;
                                i6 = i8;
                                zzicVar = zzicVar2;
                            } else {
                                i8 = 2;
                                if (i13 == 2) {
                                    Parcel parcelObtain3 = Parcel.obtain();
                                    try {
                                        str = str7;
                                        try {
                                            try {
                                                parcelObtain3.unmarshall(blob, 0, blob.length);
                                                parcelObtain3.setDataPosition(0);
                                                zzahVarCreateFromParcel = zzah.CREATOR.createFromParcel(parcelObtain3);
                                            } catch (SafeParcelReader.ParseException unused9) {
                                                this.zzu.zzaW().zzb().zza("Failed to load conditional user property from local database");
                                                parcelObtain3.recycle();
                                                zzahVarCreateFromParcel = null;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            throw th;
                                        }
                                    } catch (SafeParcelReader.ParseException unused10) {
                                        str = str7;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        str = str7;
                                    }
                                    try {
                                        if (zzahVarCreateFromParcel != null) {
                                            arrayList.add(new zzgk(zzahVarCreateFromParcel, string, j4));
                                        }
                                        i7 = 3;
                                        i2 = 0;
                                        i5 = i7;
                                        i9 = i2;
                                        str4 = str;
                                        str5 = str2;
                                        str6 = str3;
                                        i3 = 1;
                                        i4 = 4;
                                        i6 = i8;
                                        zzicVar = zzicVar2;
                                    } catch (SQLiteDatabaseLockedException unused11) {
                                        i2 = 0;
                                        SystemClock.sleep(i10);
                                        i10 += 20;
                                        if (cursorQuery != null) {
                                        }
                                        if (Zzp == 0) {
                                        }
                                        i11++;
                                        i9 = i2;
                                        str4 = str;
                                        str5 = str2;
                                        str6 = str3;
                                        r6 = 0;
                                    } catch (SQLiteFullException e11) {
                                        e = e11;
                                        i2 = 0;
                                        this.zzu.zzaW().zzb().zzb("Error reading entries from local database", e);
                                        this.zzc = true;
                                        if (cursorQuery != null) {
                                        }
                                        if (Zzp == 0) {
                                        }
                                        i11++;
                                        i9 = i2;
                                        str4 = str;
                                        str5 = str2;
                                        str6 = str3;
                                        r6 = 0;
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                        i2 = 0;
                                        if (Zzp != 0) {
                                        }
                                        this.zzu.zzaW().zzb().zzb("Error reading entries from local database", e);
                                        this.zzc = true;
                                        if (cursorQuery != null) {
                                        }
                                        if (Zzp == 0) {
                                        }
                                        i11++;
                                        i9 = i2;
                                        str4 = str;
                                        str5 = str2;
                                        str6 = str3;
                                        r6 = 0;
                                    }
                                } else {
                                    str = str7;
                                    if (i13 == 4) {
                                        Parcel parcelObtain4 = Parcel.obtain();
                                        try {
                                            i2 = 0;
                                            try {
                                                try {
                                                    parcelObtain4.unmarshall(blob, 0, blob.length);
                                                    parcelObtain4.setDataPosition(0);
                                                    zzbfVarCreateFromParcel = zzbf.CREATOR.createFromParcel(parcelObtain4);
                                                } catch (SafeParcelReader.ParseException unused12) {
                                                    this.zzu.zzaW().zzb().zza("Failed to load default event parameters from local database");
                                                    parcelObtain4.recycle();
                                                    zzbfVarCreateFromParcel = null;
                                                }
                                            } catch (Throwable th10) {
                                                th = th10;
                                                throw th;
                                            }
                                        } catch (SafeParcelReader.ParseException unused13) {
                                            i2 = 0;
                                        } catch (Throwable th11) {
                                            th = th11;
                                        }
                                        try {
                                            if (zzbfVarCreateFromParcel != null) {
                                                arrayList.add(new zzgk(zzbfVarCreateFromParcel, string, j4));
                                            }
                                            i7 = 3;
                                        } catch (SQLiteDatabaseLockedException unused14) {
                                            SystemClock.sleep(i10);
                                            i10 += 20;
                                            if (cursorQuery != null) {
                                            }
                                            if (Zzp == 0) {
                                            }
                                            i11++;
                                            i9 = i2;
                                            str4 = str;
                                            str5 = str2;
                                            str6 = str3;
                                            r6 = 0;
                                        } catch (SQLiteFullException e13) {
                                            e = e13;
                                            this.zzu.zzaW().zzb().zzb("Error reading entries from local database", e);
                                            this.zzc = true;
                                            if (cursorQuery != null) {
                                            }
                                            if (Zzp == 0) {
                                            }
                                            i11++;
                                            i9 = i2;
                                            str4 = str;
                                            str5 = str2;
                                            str6 = str3;
                                            r6 = 0;
                                        } catch (SQLiteException e14) {
                                            e = e14;
                                            if (Zzp != 0) {
                                            }
                                            this.zzu.zzaW().zzb().zzb("Error reading entries from local database", e);
                                            this.zzc = true;
                                            if (cursorQuery != null) {
                                            }
                                            if (Zzp == 0) {
                                            }
                                            i11++;
                                            i9 = i2;
                                            str4 = str;
                                            str5 = str2;
                                            str6 = str3;
                                            r6 = 0;
                                        }
                                    } else {
                                        i2 = 0;
                                        zzic zzicVar4 = this.zzu;
                                        i7 = 3;
                                        if (i13 == 3) {
                                            zzicVar4.zzaW().zzk().zza("Skipping app launch break");
                                        } else {
                                            zzicVar4.zzaW().zzb().zza("Unknown record type in local database");
                                        }
                                    }
                                    i5 = i7;
                                    i9 = i2;
                                    str4 = str;
                                    str5 = str2;
                                    str6 = str3;
                                    i3 = 1;
                                    i4 = 4;
                                    i6 = i8;
                                    zzicVar = zzicVar2;
                                }
                            }
                        }
                    } catch (SQLiteDatabaseLockedException unused15) {
                        str = str4;
                        str2 = str5;
                        str3 = str6;
                    } catch (SQLiteFullException e15) {
                        e = e15;
                        str = str4;
                        str2 = str5;
                        str3 = str6;
                    } catch (SQLiteException e16) {
                        e = e16;
                        str = str4;
                        str2 = str5;
                        str3 = str6;
                    }
                } catch (SQLiteDatabaseLockedException unused16) {
                    str = str4;
                    str2 = str5;
                    str3 = str6;
                    i2 = i9;
                } catch (SQLiteFullException e17) {
                    e = e17;
                    str = str4;
                    str2 = str5;
                    str3 = str6;
                    i2 = i9;
                } catch (SQLiteException e18) {
                    e = e18;
                    str = str4;
                    str2 = str5;
                    str3 = str6;
                    i2 = i9;
                }
                i11++;
                i9 = i2;
                str4 = str;
                str5 = str2;
                str6 = str3;
                r6 = 0;
            }
            if (Zzp.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                this.zzu.zzaW().zzb().zza("Fewer entries removed from local database than expected");
            }
            Zzp.setTransactionSuccessful();
            Zzp.endTransaction();
            cursorQuery.close();
            Zzp.close();
            return arrayList;
        }
        this.zzu.zzaW().zze().zza("Failed to read events from database in reasonable time");
        return null;
    }

    public final boolean zzn() {
        return zzs(3, new byte[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0068 A[PHI: r4
      0x0068: PHI (r4v4 int) = (r4v2 int), (r4v1 int), (r4v1 int) binds: [B:28:0x0066, B:25:0x005f, B:32:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzo() {
        zzg();
        if (!this.zzc && zzq()) {
            int i = 5;
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    this.zzu.zzaW().zze().zza("Error deleting app launch break from local database in reasonable time");
                    break;
                }
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        try {
                            SQLiteDatabase sQLiteDatabaseZzp = zzp();
                            if (sQLiteDatabaseZzp != null) {
                                sQLiteDatabaseZzp.beginTransaction();
                                sQLiteDatabaseZzp.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                sQLiteDatabaseZzp.setTransactionSuccessful();
                                sQLiteDatabaseZzp.endTransaction();
                                sQLiteDatabaseZzp.close();
                                return true;
                            }
                            this.zzc = true;
                        } catch (SQLiteFullException e) {
                            this.zzu.zzaW().zzb().zzb("Error deleting app launch break from local database", e);
                            this.zzc = true;
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                        }
                    } catch (SQLiteException e2) {
                        if (0 != 0) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        this.zzu.zzaW().zzb().zzb("Error deleting app launch break from local database", e2);
                        this.zzc = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                            i2++;
                        } else {
                            i2++;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i);
                    i += 20;
                    if (0 != 0) {
                    }
                    i2++;
                }
                i2++;
            }
        }
        return false;
    }

    public final SQLiteDatabase zzp() {
        if (this.zzc) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzb.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzc = true;
        return null;
    }

    public final boolean zzq() {
        zzic zzicVar = this.zzu;
        Context contextZzaZ = zzicVar.zzaZ();
        zzicVar.zzc();
        return contextZzaZ.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
