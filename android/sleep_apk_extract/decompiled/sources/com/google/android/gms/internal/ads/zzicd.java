package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzicd implements Closeable {
    private final Reader zzb;
    private long zzi;
    private int zzj;
    private int[] zzk;
    private String[] zzm;
    private int[] zzn;
    private zzibl zzc = zzibl.LEGACY_STRICT;
    private final char[] zzd = new char[1024];
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = 0;
    int zza = 0;
    private int zzl = 1;

    static {
        zzibn.zza = new zzicc();
    }

    public zzicd(Reader reader) {
        int[] iArr = new int[32];
        this.zzk = iArr;
        iArr[0] = 6;
        this.zzm = new String[32];
        this.zzn = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.zzb = reader;
    }

    private final boolean zzn(char c) throws zzicg {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzt();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x013d, code lost:
    
        r3 = r1 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x013f, code lost:
    
        if (r0 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0141, code lost:
    
        r0 = new java.lang.StringBuilder(java.lang.Math.max(r3 + r3, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x014d, code lost:
    
        r0.append(r4, r2, r3);
        r11.zze = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ee, code lost:
    
        throw zzv("Malformed Unicode escape \\u".concat(new java.lang.String(r4, r11.zze, 4)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zzo(char c) throws zzicg {
        int i;
        StringBuilder sb = null;
        loop0: do {
            int i2 = this.zze;
            int i3 = this.zzf;
            int i4 = i2;
            while (true) {
                char[] cArr = this.zzd;
                if (i2 >= i3) {
                    break;
                }
                int i5 = i2 + 1;
                char c2 = cArr[i2];
                zzibl zziblVar = this.zzc;
                zzibl zziblVar2 = zzibl.STRICT;
                if (zziblVar == zziblVar2 && c2 < ' ') {
                    throw zzv("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                }
                if (c2 == c) {
                    int i6 = (i5 - i4) - 1;
                    this.zze = i5;
                    if (sb == null) {
                        return new String(cArr, i4, i6);
                    }
                    sb.append(cArr, i4, i6);
                    return sb.toString();
                }
                char c3 = '\n';
                if (c2 == '\\') {
                    int i7 = i5 - i4;
                    int i8 = i7 - 1;
                    this.zze = i5;
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i7 + i7, 16));
                    }
                    sb.append(cArr, i4, i8);
                    if (this.zze == this.zzf && !zzr(1)) {
                        throw zzv("Unterminated escape sequence");
                    }
                    int i9 = this.zze;
                    int i10 = i9 + 1;
                    this.zze = i10;
                    char c4 = cArr[i9];
                    if (c4 != '\n') {
                        if (c4 == '\"') {
                            c3 = c4;
                            sb.append(c3);
                            i4 = this.zze;
                            i3 = this.zzf;
                            i2 = i4;
                        } else {
                            if (c4 != '\'') {
                                if (c4 != '/' && c4 != '\\') {
                                    if (c4 == 'b') {
                                        c3 = '\b';
                                    } else if (c4 == 'f') {
                                        c3 = '\f';
                                    } else if (c4 != 'n') {
                                        if (c4 == 'r') {
                                            c3 = '\r';
                                        } else if (c4 == 't') {
                                            c3 = '\t';
                                        } else {
                                            if (c4 != 'u') {
                                                throw zzv("Invalid escape sequence");
                                            }
                                            if (i9 + 5 > this.zzf && !zzr(4)) {
                                                throw zzv("Unterminated escape sequence");
                                            }
                                            int i11 = this.zze;
                                            int i12 = i11 + 4;
                                            int i13 = 0;
                                            while (i11 < i12) {
                                                int i14 = i13 << 4;
                                                char c5 = cArr[i11];
                                                if (c5 >= '0' && c5 <= '9') {
                                                    i = c5 - '0';
                                                } else if (c5 >= 'a' && c5 <= 'f') {
                                                    i = c5 - 'W';
                                                } else {
                                                    if (c5 < 'A' || c5 > 'F') {
                                                        break loop0;
                                                    }
                                                    i = c5 - '7';
                                                }
                                                i13 = i + i14;
                                                i11++;
                                            }
                                            this.zze += 4;
                                            c3 = (char) i13;
                                        }
                                    }
                                }
                                sb.append(c3);
                                i4 = this.zze;
                                i3 = this.zzf;
                                i2 = i4;
                            }
                            c3 = c4;
                            sb.append(c3);
                            i4 = this.zze;
                            i3 = this.zzf;
                            i2 = i4;
                        }
                    } else {
                        if (this.zzc == zziblVar2) {
                            throw zzv("Cannot escape a newline character in strict mode");
                        }
                        this.zzg++;
                        this.zzh = i10;
                    }
                    if (this.zzc == zziblVar2) {
                        throw zzv("Invalid escaped character \"'\" in strict mode");
                    }
                    c3 = c4;
                    sb.append(c3);
                    i4 = this.zze;
                    i3 = this.zzf;
                    i2 = i4;
                } else {
                    if (c2 == '\n') {
                        this.zzg++;
                        this.zzh = i5;
                    }
                    i2 = i5;
                }
            }
        } while (zzr(1));
        throw zzv("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        zzt();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zzp() throws zzicg {
        String string;
        int i = 0;
        StringBuilder sb = null;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.zze + i2;
                if (i3 < this.zzf) {
                    char c = this.zzd[i3];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= 1024) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.zzd, this.zze, i2);
                    this.zze += i2;
                } else if (zzr(i2 + 1)) {
                }
            }
            i = i2;
            char[] cArr = this.zzd;
            if (sb != null) {
                string = new String(cArr, this.zze, i);
            } else {
                sb.append(cArr, this.zze, i);
                string = sb.toString();
            }
            this.zze += i;
            return string;
        } while (zzr(1));
        char[] cArr2 = this.zzd;
        if (sb != null) {
        }
        this.zze += i;
        return string;
    }

    private final void zzq(int i) throws zzicg {
        int i2 = this.zzl;
        if (i2 - 1 >= 1280) {
            String strZzl = zzl();
            throw new zzicg(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(strZzl.length() + 26), "Nesting limit 1280 reached", strZzl));
        }
        int[] iArr = this.zzk;
        if (i2 == iArr.length) {
            int i3 = i2 + i2;
            this.zzk = Arrays.copyOf(iArr, i3);
            this.zzn = Arrays.copyOf(this.zzn, i3);
            this.zzm = (String[]) Arrays.copyOf(this.zzm, i3);
        }
        int[] iArr2 = this.zzk;
        int i4 = this.zzl;
        this.zzl = i4 + 1;
        iArr2[i4] = i;
    }

    private final boolean zzr(int i) throws IOException {
        int i2;
        int i3 = this.zzh;
        int i4 = this.zze;
        this.zzh = i3 - i4;
        char[] cArr = this.zzd;
        int i5 = this.zzf;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.zzf = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.zzf = 0;
        }
        this.zze = 0;
        do {
            Reader reader = this.zzb;
            int i7 = this.zzf;
            int i8 = reader.read(cArr, i7, 1024 - i7);
            if (i8 == -1) {
                return false;
            }
            i2 = this.zzf + i8;
            this.zzf = i2;
            if (this.zzg == 0 && this.zzh == 0 && i2 > 0 && cArr[0] == 65279) {
                this.zze++;
                this.zzh = 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private final int zzs(boolean z) throws IOException {
        int i;
        int i2 = this.zze;
        int i3 = this.zzf;
        while (true) {
            if (i2 == i3) {
                this.zze = i2;
                if (!zzr(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(zzl()));
                    }
                    return -1;
                }
                i2 = this.zze;
                i3 = this.zzf;
            }
            char[] cArr = this.zzd;
            int i4 = i2 + 1;
            char c = cArr[i2];
            if (c == '\n') {
                this.zzg++;
                this.zzh = i4;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.zze = i4;
                    if (i4 == i3) {
                        this.zze = i2;
                        boolean zZzr = zzr(2);
                        this.zze++;
                        if (!zZzr) {
                            return 47;
                        }
                    }
                    zzt();
                    int i5 = this.zze;
                    char c2 = cArr[i5];
                    if (c2 == '*') {
                        this.zze = i5 + 1;
                        while (true) {
                            if (this.zze + 2 > this.zzf && !zzr(2)) {
                                throw zzv("Unterminated comment");
                            }
                            int i6 = this.zze;
                            if (cArr[i6] != '\n') {
                                while (true) {
                                    int i7 = this.zze;
                                    if (i >= 2) {
                                        i2 = i7 + 2;
                                        i3 = this.zzf;
                                        break;
                                    }
                                    i = cArr[i7 + i] == "*/".charAt(i) ? i + 1 : 0;
                                }
                            } else {
                                this.zzg++;
                                this.zzh = i6 + 1;
                            }
                            this.zze++;
                        }
                    } else {
                        if (c2 != '/') {
                            return 47;
                        }
                        this.zze = i5 + 1;
                        zzu();
                        i2 = this.zze;
                        i3 = this.zzf;
                    }
                } else {
                    if (c != '#') {
                        this.zze = i4;
                        return c;
                    }
                    this.zze = i4;
                    zzt();
                    zzu();
                    i2 = this.zze;
                    i3 = this.zzf;
                }
            }
            i2 = i4;
        }
    }

    private final void zzt() throws zzicg {
        if (this.zzc != zzibl.LENIENT) {
            throw zzv("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private final void zzu() {
        char c;
        do {
            if (this.zze >= this.zzf && !zzr(1)) {
                return;
            }
            char[] cArr = this.zzd;
            int i = this.zze;
            int i2 = i + 1;
            this.zze = i2;
            c = cArr[i];
            if (c == '\n') {
                this.zzg++;
                this.zzh = i2;
                return;
            }
        } while (c != '\r');
    }

    private final zzicg zzv(String str) throws zzicg {
        String strZzl = zzl();
        throw new zzicg(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str.length() + strZzl.length() + 79), str, strZzl, "\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#malformed-json"));
    }

    private final IllegalStateException zzw(String str) throws IOException {
        int iZzm = zzm();
        String strZza = zzice.zza(zzm());
        String strZzl = zzl();
        int iM = zzba$$ExternalSyntheticOutline0.m(str.length() + 18, strZzl.length(), strZza);
        String strConcat = "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(iZzm == 9 ? "adapter-not-null-safe" : "unexpected-json-structure");
        StringBuilder sb = new StringBuilder(strConcat.length() + iM + 5);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Expected ", str, " but was ", strZza);
        return new IllegalStateException(Fragment$$ExternalSyntheticOutline1.m(sb, strZzl, "\nSee ", strConcat));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza = 0;
        this.zzk[0] = 8;
        this.zzl = 1;
        this.zzb.close();
    }

    public final String toString() {
        return "zzicd".concat(zzl());
    }

    public final void zza(zzibl zziblVar) {
        Objects.requireNonNull(zziblVar);
        this.zzc = zziblVar;
    }

    public final void zzb() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 3) {
            throw zzw("BEGIN_ARRAY");
        }
        zzq(1);
        this.zzn[this.zzl - 1] = 0;
        this.zza = 0;
    }

    public final void zzc() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 4) {
            throw zzw("END_ARRAY");
        }
        int i = this.zzl;
        this.zzl = i - 1;
        int[] iArr = this.zzn;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.zza = 0;
    }

    public final void zzd() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 1) {
            throw zzw("BEGIN_OBJECT");
        }
        zzq(3);
        this.zza = 0;
    }

    public final void zze() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 2) {
            throw zzw("END_OBJECT");
        }
        int i = this.zzl;
        int i2 = i - 1;
        this.zzl = i2;
        this.zzm[i2] = null;
        int[] iArr = this.zzn;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.zza = 0;
    }

    public final boolean zzf() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        return (iZzg == 2 || iZzg == 4 || iZzg == 17) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x01dc, code lost:
    
        r23 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0235, code lost:
    
        if (zzn(r15) == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x024f, code lost:
    
        if (r3 == false) goto L179;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0298 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0342  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzg() throws IOException {
        int i;
        int i2;
        int iZzs;
        int iZzs2;
        int i3;
        String str;
        String str2;
        int i4;
        char c;
        char c2;
        char c3;
        int i5;
        int i6;
        boolean z;
        int[] iArr = this.zzk;
        int i7 = this.zzl - 1;
        int i8 = iArr[i7];
        int i9 = 3;
        boolean z2 = true;
        if (i8 != 1) {
            if (i8 == 2) {
                int iZzs3 = zzs(true);
                if (iZzs3 != 44) {
                    if (iZzs3 == 59) {
                        zzt();
                    } else {
                        if (iZzs3 != 93) {
                            throw zzv("Unterminated array");
                        }
                        i9 = 4;
                    }
                }
            } else {
                if (i8 == 3) {
                    i = 2;
                    i2 = 4;
                } else if (i8 == 5) {
                    i2 = 4;
                    i = 2;
                } else if (i8 == 4) {
                    iArr[i7] = 5;
                    int iZzs4 = zzs(true);
                    if (iZzs4 != 58) {
                        if (iZzs4 != 61) {
                            throw zzv("Expected ':'");
                        }
                        zzt();
                        if (this.zze < this.zzf || zzr(1)) {
                            char[] cArr = this.zzd;
                            int i10 = this.zze;
                            if (cArr[i10] == '>') {
                                this.zze = i10 + 1;
                            }
                        }
                    }
                } else if (i8 == 6) {
                    if (this.zzc == zzibl.LENIENT) {
                        zzs(true);
                        int i11 = this.zze;
                        this.zze = i11 - 1;
                        if (i11 + 4 <= this.zzf || zzr(5)) {
                            int i12 = this.zze;
                            char[] cArr2 = this.zzd;
                            if (cArr2[i12] == ')' && cArr2[i12 + 1] == ']' && cArr2[i12 + 2] == '}' && cArr2[i12 + 3] == '\'' && cArr2[i12 + 4] == '\n') {
                                this.zze = i12 + 5;
                            }
                        }
                    }
                    this.zzk[this.zzl - 1] = 7;
                } else if (i8 == 7) {
                    if (zzs(false) == -1) {
                        i9 = 17;
                    } else {
                        zzt();
                        this.zze--;
                    }
                } else if (i8 == 8) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("JsonReader is closed");
                    return 0;
                }
                iArr[i7] = i2;
                if (i8 != 5 || (iZzs2 = zzs(true)) == 44) {
                    iZzs = zzs(true);
                    if (iZzs != 34) {
                        i9 = 13;
                    } else {
                        if (iZzs == 39) {
                            zzt();
                            this.zza = 12;
                            return 12;
                        }
                        if (iZzs != 125) {
                            zzt();
                            this.zze--;
                            if (!zzn((char) iZzs)) {
                                throw zzv("Expected name");
                            }
                            i9 = 14;
                        } else {
                            if (i8 == 5) {
                                throw zzv("Expected name");
                            }
                            i9 = i;
                        }
                    }
                } else if (iZzs2 != 59) {
                    if (iZzs2 != 125) {
                        throw zzv("Unterminated object");
                    }
                    i9 = i;
                } else {
                    zzt();
                    iZzs = zzs(true);
                    if (iZzs != 34) {
                    }
                }
            }
            this.zza = i9;
            return i9;
        }
        iArr[i7] = 2;
        int iZzs5 = zzs(true);
        if (iZzs5 != 34) {
            if (iZzs5 == 39) {
                zzt();
                this.zza = 8;
                return 8;
            }
            if (iZzs5 == 44 || iZzs5 == 59) {
                i3 = 1;
            } else if (iZzs5 != 91) {
                if (iZzs5 == 93) {
                    i3 = 1;
                    if (i8 == 1) {
                        i9 = 4;
                    }
                } else if (iZzs5 != 123) {
                    int i13 = this.zze - 1;
                    this.zze = i13;
                    char[] cArr3 = this.zzd;
                    char c4 = cArr3[i13];
                    if (c4 == 't' || c4 == 'T') {
                        str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                        str2 = "TRUE";
                        i4 = 5;
                    } else if (c4 == 'f' || c4 == 'F') {
                        str = "false";
                        str2 = "FALSE";
                        i4 = 6;
                    } else {
                        if (c4 == 'n' || c4 == 'N') {
                            str = "null";
                            str2 = "NULL";
                            i4 = 7;
                        }
                        i4 = 0;
                        if (i4 == 0) {
                            return i4;
                        }
                        int i14 = this.zze;
                        boolean z3 = true;
                        int i15 = this.zzf;
                        int i16 = 0;
                        char c5 = 0;
                        long j = 0;
                        boolean z4 = false;
                        while (true) {
                            if (i14 + i16 == i15) {
                                if (i16 == 1024) {
                                    break;
                                }
                                if (!zzr(i16 + 1)) {
                                    i5 = i16;
                                    break;
                                }
                                i14 = this.zze;
                                i15 = this.zzf;
                                c2 = cArr3[i14 + i16];
                                if (c2 != '+') {
                                }
                            } else {
                                c2 = cArr3[i14 + i16];
                                if (c2 != '+') {
                                    c3 = 6;
                                    if (c5 != 5) {
                                        break;
                                    }
                                    c5 = c3;
                                    i16++;
                                    z2 = true;
                                } else if (c2 == 'E' || c2 == 'e') {
                                    if (c5 != 2 && c5 != 4) {
                                        break;
                                    }
                                    c5 = 5;
                                    i16++;
                                    z2 = true;
                                } else if (c2 == '-') {
                                    c3 = 6;
                                    if (c5 == 0) {
                                        c5 = 1;
                                        z4 = true;
                                        i16++;
                                        z2 = true;
                                    } else {
                                        if (c5 != 5) {
                                            break;
                                        }
                                        c5 = c3;
                                        i16++;
                                        z2 = true;
                                    }
                                } else if (c2 == '.') {
                                    if (c5 != 2) {
                                        break;
                                    }
                                    c5 = 3;
                                    i16++;
                                    z2 = true;
                                } else {
                                    if (c2 < '0' || c2 > '9') {
                                        break;
                                    }
                                    if (c5 == z2 || c5 == 0) {
                                        j = -(c2 - '0');
                                        i16 = i16;
                                        c5 = 2;
                                    } else if (c5 != 2) {
                                        int i17 = i16;
                                        if (c5 == 3) {
                                            i16 = i17;
                                            c5 = 4;
                                        } else {
                                            if (c5 == 5 || c5 == 6) {
                                                c5 = 7;
                                            }
                                            i16 = i17;
                                        }
                                    } else {
                                        if (j == 0) {
                                            break;
                                        }
                                        int i18 = i16;
                                        long j2 = (10 * j) - ((long) (c2 - '0'));
                                        z3 &= j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                                        j = j2;
                                        i16 = i18;
                                    }
                                    i16++;
                                    z2 = true;
                                }
                            }
                            if (i6 == 0) {
                                return i6;
                            }
                            if (!zzn(cArr3[this.zze])) {
                                throw zzv("Expected value");
                            }
                            zzt();
                            this.zza = 10;
                            return 10;
                        }
                        char c6 = 2;
                        if (c5 != 2) {
                            if (c5 != c6 || c5 == 4 || c5 == 7) {
                                this.zzj = i5;
                                i6 = 16;
                                this.zza = i6;
                            }
                            i6 = 0;
                        } else {
                            if (z3) {
                                if (j != Long.MIN_VALUE) {
                                    z = z4;
                                } else if (z4) {
                                    z = true;
                                }
                                if (j != 0) {
                                    if (!z) {
                                    }
                                    this.zzi = j;
                                    this.zze += i5;
                                    i6 = 15;
                                    this.zza = i6;
                                }
                                j = -j;
                                this.zzi = j;
                                this.zze += i5;
                                i6 = 15;
                                this.zza = i6;
                            }
                            c5 = 2;
                            c6 = 2;
                            if (c5 != c6) {
                            }
                            this.zzj = i5;
                            i6 = 16;
                            this.zza = i6;
                        }
                        if (i6 == 0) {
                        }
                    }
                    zzibl zziblVar = this.zzc;
                    zzibl zziblVar2 = zzibl.STRICT;
                    int i19 = 0;
                    while (true) {
                        int length = str.length();
                        int i20 = this.zze;
                        if (i19 < length) {
                            if ((i20 + i19 >= this.zzf && !zzr(i19 + 1)) || ((c = cArr3[this.zze + i19]) != str.charAt(i19) && (zziblVar == zziblVar2 || c != str2.charAt(i19)))) {
                                break;
                            }
                            i19++;
                        } else {
                            if ((i20 + length < this.zzf || zzr(length + 1)) && zzn(cArr3[this.zze + length])) {
                                break;
                            }
                            this.zze += length;
                            this.zza = i4;
                        }
                    }
                    i4 = 0;
                    if (i4 == 0) {
                    }
                } else {
                    i9 = 1;
                }
            }
            if (i8 != i3 && i8 != 2) {
                throw zzv("Unexpected value");
            }
            zzt();
            this.zze--;
            this.zza = 7;
            return 7;
        }
        i9 = 9;
        this.zza = i9;
        return i9;
    }

    public final String zzh() throws IOException {
        String strZzo;
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 14) {
            strZzo = zzp();
        } else if (iZzg == 12) {
            strZzo = zzo('\'');
        } else {
            if (iZzg != 13) {
                throw zzw("a name");
            }
            strZzo = zzo(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        this.zza = 0;
        this.zzm[this.zzl - 1] = strZzo;
        return strZzo;
    }

    public final String zzi() throws IOException {
        String string;
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 10) {
            string = zzp();
        } else if (iZzg == 8) {
            string = zzo('\'');
        } else if (iZzg == 9) {
            string = zzo(JsonFactory.DEFAULT_QUOTE_CHAR);
        } else if (iZzg == 11) {
            string = null;
        } else if (iZzg == 15) {
            string = Long.toString(this.zzi);
        } else {
            if (iZzg != 16) {
                throw zzw("a string");
            }
            String str = new String(this.zzd, this.zze, this.zzj);
            this.zze += this.zzj;
            string = str;
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i = this.zzl - 1;
        iArr[i] = iArr[i] + 1;
        return string;
    }

    public final boolean zzj() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 5) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i = this.zzl - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iZzg != 6) {
            throw zzw("a boolean");
        }
        this.zza = 0;
        int[] iArr2 = this.zzn;
        int i2 = this.zzl - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    public final void zzk() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 7) {
            throw zzw("null");
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i = this.zzl - 1;
        iArr[i] = iArr[i] + 1;
    }

    public final String zzl() {
        int i = this.zzg + 1;
        int i2 = this.zze - this.zzh;
        StringBuilder sb = new StringBuilder("$");
        for (int i3 = 0; i3 < this.zzl; i3++) {
            int i4 = this.zzk[i3];
            switch (i4) {
                case 1:
                case 2:
                    int i5 = this.zzn[i3];
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.zzm[i3];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$1((Object) zzba$$ExternalSyntheticOutline0.m(i4, "Unknown scope value: ", new StringBuilder(String.valueOf(i4).length() + 21)));
                    return null;
            }
        }
        int i6 = i2 + 1;
        String string = sb.toString();
        int length = String.valueOf(i).length();
        int length2 = String.valueOf(i6).length();
        StringBuilder sb2 = new StringBuilder(string.length() + length2 + length + 17 + 6);
        Fragment$$ExternalSyntheticOutline1.m(sb2, " at line ", i, " column ", i6);
        return FileInsert$$ExternalSyntheticOutline0.m(sb2, " path ", string);
    }

    public final int zzm() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        switch (iZzg) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }
}
