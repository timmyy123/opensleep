package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzicf implements Closeable, Flushable {
    private static final Pattern zza = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] zzb = new String[128];
    private static final String[] zzc;
    private final Writer zzd;
    private int[] zze = new int[32];
    private int zzf = 0;
    private final zzibe zzg;
    private final String zzh;
    private String zzi;
    private final boolean zzj;
    private zzibl zzk;
    private String zzl;

    static {
        for (int i = 0; i <= 31; i++) {
            zzb[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = zzb;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        zzc = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public zzicf(Writer writer) {
        boolean z = false;
        zzm(6);
        this.zzk = zzibl.LEGACY_STRICT;
        Objects.requireNonNull(writer, "out == null");
        this.zzd = writer;
        zzibe zzibeVar = zzibe.zza;
        Objects.requireNonNull(zzibeVar);
        this.zzg = zzibeVar;
        this.zzi = ",";
        if (zzibeVar.zzc()) {
            this.zzh = ": ";
            if (zzibeVar.zza().isEmpty()) {
                this.zzi = ", ";
            }
        } else {
            this.zzh = ":";
        }
        if (zzibeVar.zza().isEmpty() && zzibeVar.zzb().isEmpty()) {
            z = true;
        }
        this.zzj = z;
    }

    private final zzicf zzk(int i, char c) throws IOException {
        zzs();
        zzm(i);
        this.zzd.write(c);
        return this;
    }

    private final zzicf zzl(int i, int i2, char c) throws IOException {
        int iZzn = zzn();
        if (iZzn != i2 && iZzn != i) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Nesting problem.");
            return null;
        }
        String str = this.zzl;
        if (str != null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Dangling name: ".concat(str));
            return null;
        }
        this.zzf--;
        if (iZzn == i2) {
            zzr();
        }
        this.zzd.write(c);
        return this;
    }

    private final void zzm(int i) {
        int i2 = this.zzf;
        int[] iArr = this.zze;
        if (i2 == iArr.length) {
            this.zze = Arrays.copyOf(iArr, i2 + i2);
        }
        int[] iArr2 = this.zze;
        int i3 = this.zzf;
        this.zzf = i3 + 1;
        iArr2[i3] = i;
    }

    private final int zzn() {
        int i = this.zzf;
        if (i != 0) {
            return this.zze[i - 1];
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("JsonWriter is closed.");
        return 0;
    }

    private final void zzo(int i) {
        this.zze[this.zzf - 1] = i;
    }

    private final void zzp() throws IOException {
        if (this.zzl != null) {
            int iZzn = zzn();
            if (iZzn == 5) {
                this.zzd.write(this.zzi);
            } else if (iZzn != 3) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Nesting problem.");
                return;
            }
            zzr();
            zzo(4);
            zzq(this.zzl);
            this.zzl = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzq(String str) throws IOException {
        String str2;
        Writer writer = this.zzd;
        String[] strArr = zzb;
        writer.write(34);
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i2 < i) {
                        writer.write(str, i2, i - i2);
                    }
                    writer.write(str2);
                    i2 = i3;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                writer.write(str2);
                i2 = i3;
            }
            i = i3;
        }
        if (i2 < length) {
            writer.write(str, i2, length - i2);
        }
        writer.write(34);
    }

    private final void zzr() throws IOException {
        if (this.zzj) {
            return;
        }
        Writer writer = this.zzd;
        zzibe zzibeVar = this.zzg;
        writer.write(zzibeVar.zza());
        int i = this.zzf;
        for (int i2 = 1; i2 < i; i2++) {
            writer.write(zzibeVar.zzb());
        }
    }

    private final void zzs() throws IOException {
        int iZzn = zzn();
        if (iZzn == 1) {
            zzo(2);
            zzr();
            return;
        }
        if (iZzn == 2) {
            this.zzd.append((CharSequence) this.zzi);
            zzr();
            return;
        }
        if (iZzn == 4) {
            this.zzd.append((CharSequence) this.zzh);
            zzo(5);
            return;
        }
        if (iZzn != 6) {
            if (iZzn != 7) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Nesting problem.");
                return;
            } else if (this.zzk != zzibl.LENIENT) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("JSON must have only one top-level value.");
                return;
            }
        }
        zzo(7);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzd.close();
        int i = this.zzf;
        if (i > 1 || (i == 1 && this.zze[0] != 7)) {
            OggIO$$ExternalSyntheticBUOutline0.m("Incomplete document");
        } else {
            this.zzf = 0;
        }
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.zzf != 0) {
            this.zzd.flush();
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("JsonWriter is closed.");
        }
    }

    public final void zza(zzibl zziblVar) {
        Objects.requireNonNull(zziblVar);
        this.zzk = zziblVar;
    }

    public final zzicf zzb() {
        zzp();
        zzk(1, '[');
        return this;
    }

    public final zzicf zzc() {
        zzl(1, 2, ']');
        return this;
    }

    public final zzicf zzd() {
        zzp();
        zzk(3, '{');
        return this;
    }

    public final zzicf zze() {
        zzl(3, 5, '}');
        return this;
    }

    public final zzicf zzf(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.zzl != null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Already wrote a name, expecting a value.");
            return null;
        }
        int iZzn = zzn();
        if (iZzn == 3 || iZzn == 5) {
            this.zzl = str;
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Please begin an object before writing a name.");
        return null;
    }

    public final zzicf zzg(String str) {
        if (str == null) {
            zzj();
            return this;
        }
        zzp();
        zzs();
        zzq(str);
        return this;
    }

    public final zzicf zzh(boolean z) {
        zzp();
        zzs();
        this.zzd.write(true != z ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return this;
    }

    public final zzicf zzi(Number number) {
        if (number == null) {
            zzj();
            return this;
        }
        zzp();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.zzk != zzibl.LENIENT) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Numeric values must be finite, but was ".concat(string));
                    return null;
                }
            } else if (cls != Float.class && cls != Double.class && !zza.matcher(string).matches()) {
                String strValueOf = String.valueOf(cls);
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strValueOf.length() + 47 + string.length()), "String created by ", strValueOf, " is not a valid JSON number: ", string));
                return null;
            }
        }
        zzs();
        this.zzd.append((CharSequence) string);
        return this;
    }

    public final zzicf zzj() {
        if (this.zzl != null) {
            zzp();
        }
        zzs();
        this.zzd.write("null");
        return this;
    }
}
