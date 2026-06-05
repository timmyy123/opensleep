package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.text.TextUtils;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzv {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final float zzA;
    public final int zzB;
    public final float zzC;
    public final byte[] zzD;
    public final int zzE;
    public final zzi zzF;
    public final int zzG;
    public final int zzH;
    public final int zzI;
    public final int zzJ;
    public final int zzK;
    public final int zzL;
    public final int zzM;
    public final int zzN;
    public final int zzO;
    private int zzQ;
    public final String zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final String zzk;
    public final zzap zzl;
    public final Object zzm;
    public final String zzn;
    public final String zzo;
    public final String zzp;
    public final int zzq;
    public final int zzr;
    public final List zzs;
    public final zzq zzt;
    public final long zzu;
    public final boolean zzv;
    public final int zzw;
    public final int zzx;
    public final int zzy;
    public final int zzz;

    static {
        new zzv(new zzt());
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(34, 36);
        Integer.toString(35, 36);
        Integer.toString(36, 36);
        Integer.toString(37, 36);
    }

    private zzv(zzt zztVar) {
        boolean z;
        String str;
        this.zza = zztVar.zzP();
        String strZzi = zzfl.zzi(zztVar.zzS());
        this.zzd = strZzi;
        if (zztVar.zzR().isEmpty() && zztVar.zzQ() != null) {
            this.zzc = zzgwm.zzj(new zzx(strZzi, zztVar.zzQ()));
            this.zzb = zztVar.zzQ();
        } else if (!zztVar.zzR().isEmpty() && zztVar.zzQ() == null) {
            this.zzc = zztVar.zzR();
            List listZzR = zztVar.zzR();
            Iterator it = listZzR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzx) listZzR.get(0)).zzb;
                    break;
                }
                zzx zzxVar = (zzx) it.next();
                if (TextUtils.equals(zzxVar.zza, strZzi)) {
                    str = zzxVar.zzb;
                    break;
                }
            }
            this.zzb = str;
        } else if (zztVar.zzR().isEmpty() && zztVar.zzQ() == null) {
            z = true;
            zzgtj.zzi(z);
            this.zzc = zztVar.zzR();
            this.zzb = zztVar.zzQ();
        } else {
            for (int i = 0; i < zztVar.zzR().size(); i++) {
                if (((zzx) zztVar.zzR().get(i)).zzb.equals(zztVar.zzQ())) {
                    z = true;
                    break;
                }
            }
            z = false;
            zzgtj.zzi(z);
            this.zzc = zztVar.zzR();
            this.zzb = zztVar.zzQ();
        }
        this.zze = zztVar.zzT();
        zzgtj.zzj(zztVar.zzV() == 0 || (zztVar.zzU() & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.zzf = zztVar.zzU();
        this.zzg = zztVar.zzV();
        int iZzW = zztVar.zzW();
        this.zzh = iZzW;
        int iZzX = zztVar.zzX();
        this.zzi = iZzX;
        this.zzj = iZzX != -1 ? iZzX : iZzW;
        this.zzk = zztVar.zzY();
        this.zzl = zztVar.zzZ();
        this.zzm = null;
        this.zzn = zztVar.zzaa();
        this.zzo = zztVar.zzab();
        this.zzp = zztVar.zzac();
        this.zzq = zztVar.zzad();
        this.zzr = zztVar.zzae();
        this.zzs = zztVar.zzaf() == null ? Collections.EMPTY_LIST : zztVar.zzaf();
        zzq zzqVarZzag = zztVar.zzag();
        this.zzt = zzqVarZzag;
        this.zzu = zztVar.zzah();
        this.zzv = zztVar.zzai();
        this.zzw = zztVar.zzaj();
        this.zzx = zztVar.zzak();
        this.zzy = zztVar.zzal();
        this.zzz = zztVar.zzam();
        this.zzA = zztVar.zzan();
        this.zzB = zztVar.zzao() == -1 ? 0 : zztVar.zzao();
        this.zzC = zztVar.zzap() == -1.0f ? 1.0f : zztVar.zzap();
        this.zzD = zztVar.zzaq();
        this.zzE = zztVar.zzar();
        this.zzF = zztVar.zzas();
        this.zzG = zztVar.zzat();
        this.zzH = zztVar.zzau();
        this.zzI = zztVar.zzav();
        this.zzJ = zztVar.zzaw();
        this.zzK = zztVar.zzax() == -1 ? 0 : zztVar.zzax();
        this.zzL = zztVar.zzay() != -1 ? zztVar.zzay() : 0;
        this.zzM = zztVar.zzaz();
        this.zzN = zztVar.zzaA();
        if (zztVar.zzaB() != 0 || zzqVarZzag == null) {
            this.zzO = zztVar.zzaB();
        } else {
            this.zzO = 1;
        }
    }

    public static String zze(zzv zzvVar) {
        String str;
        int i;
        int i2;
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("id=");
        sbM.append(zzvVar.zza);
        sbM.append(", mimeType=");
        sbM.append(zzvVar.zzp);
        String str2 = zzvVar.zzo;
        if (str2 != null) {
            sbM.append(", container=");
            sbM.append(str2);
        }
        String str3 = zzvVar.zzn;
        if (str3 != null) {
            sbM.append(", primaryGroupId=");
            sbM.append(str3);
        }
        int i3 = zzvVar.zzj;
        if (i3 != -1) {
            sbM.append(", bitrate=");
            sbM.append(i3);
        }
        String str4 = zzvVar.zzk;
        if (str4 != null) {
            sbM.append(", codecs=");
            sbM.append(str4);
        }
        zzq zzqVar = zzvVar.zzt;
        if (zzqVar != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i4 = 0; i4 < zzqVar.zzb; i4++) {
                UUID uuid = zzqVar.zza(i4).zza;
                if (uuid.equals(zzg.zzb)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(zzg.zzc)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(zzg.zze)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(zzg.zzd)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(zzg.zza)) {
                    linkedHashSet.add("universal");
                } else {
                    String string = uuid.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 10);
                    sb.append("unknown (");
                    sb.append(string);
                    sb.append(")");
                    linkedHashSet.add(sb.toString());
                }
            }
            sbM.append(", drm=[");
            zzgtd.zzb(sbM, linkedHashSet, ",");
            sbM.append(']');
        }
        int i5 = zzvVar.zzw;
        if (i5 != -1 && (i2 = zzvVar.zzx) != -1) {
            Fragment$$ExternalSyntheticOutline1.m(sbM, ", res=", i5, "x", i2);
        }
        int i6 = zzvVar.zzy;
        if (i6 != -1 && (i = zzvVar.zzz) != -1) {
            Fragment$$ExternalSyntheticOutline1.m(sbM, ", decRes=", i6, "x", i);
        }
        float f = zzvVar.zzC;
        int i7 = zzgzw.$r8$clinit;
        double d = f;
        if (Math.copySign((-1.0d) + d, 1.0d) > 0.001d && d != 1.0d && (!Double.isNaN(d) || !Double.isNaN(1.0d))) {
            sbM.append(", par=");
            Object[] objArr = {Float.valueOf(f)};
            String str5 = zzfl.zza;
            sbM.append(String.format(Locale.US, "%.3f", objArr));
        }
        zzi zziVar = zzvVar.zzF;
        if (zziVar != null && (zziVar.zze() || zziVar.zzf())) {
            sbM.append(", color=");
            sbM.append(zziVar.zzg());
        }
        float f2 = zzvVar.zzA;
        if (f2 != -1.0f) {
            sbM.append(", fps=");
            sbM.append(f2);
        }
        int i8 = zzvVar.zzG;
        if (i8 != -1) {
            sbM.append(", maxSubLayers=");
            sbM.append(i8);
        }
        int i9 = zzvVar.zzH;
        if (i9 != -1) {
            sbM.append(", channels=");
            sbM.append(i9);
        }
        int i10 = zzvVar.zzI;
        if (i10 != -1) {
            sbM.append(", sample_rate=");
            sbM.append(i10);
        }
        String str6 = zzvVar.zzd;
        if (str6 != null) {
            sbM.append(", language=");
            sbM.append(str6);
        }
        List list = zzvVar.zzc;
        if (!list.isEmpty()) {
            sbM.append(", labels=[");
            zzgtd.zzb(sbM, zzgxm.zzc(list, zzu.zza), ",");
            sbM.append("]");
        }
        int i11 = zzvVar.zze;
        if (i11 != 0) {
            sbM.append(", selectionFlags=[");
            String str7 = zzfl.zza;
            ArrayList arrayList = new ArrayList();
            if ((i11 & 1) != 0) {
                arrayList.add("default");
            }
            if ((i11 & 2) != 0) {
                arrayList.add("forced");
            }
            zzgtd.zzb(sbM, arrayList, ",");
            sbM.append("]");
        }
        int i12 = zzvVar.zzf;
        if (i12 != 0) {
            sbM.append(", roleFlags=[");
            int i13 = i12 & 32768;
            String str8 = zzfl.zza;
            ArrayList arrayList2 = new ArrayList();
            if ((i12 & 1) != 0) {
                arrayList2.add("main");
            }
            if ((i12 & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((i12 & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((i12 & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((i12 & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((i12 & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((i12 & 64) != 0) {
                arrayList2.add(ShareConstants.FEED_CAPTION_PARAM);
            }
            if ((i12 & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((i12 & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((i12 & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((i12 & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((i12 & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((i12 & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((i12 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                arrayList2.add("easy-read");
            }
            if ((i12 & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            if (i13 != 0) {
                arrayList2.add("auxiliary");
            }
            zzgtd.zzb(sbM, arrayList2, ",");
            sbM.append("]");
        }
        if ((i12 & 32768) != 0) {
            sbM.append(", auxiliaryTrackType=");
            int i14 = zzvVar.zzg;
            String str9 = zzfl.zza;
            if (i14 == 0) {
                str = "undefined";
            } else if (i14 == 1) {
                str = "original";
            } else if (i14 == 2) {
                str = "depth-linear";
            } else if (i14 == 3) {
                str = "depth-inverse";
            } else {
                if (i14 != 4) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Unsupported auxiliary track type");
                    return null;
                }
                str = "depth metadata";
            }
            sbM.append(str);
        }
        return sbM.toString();
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzv.class == obj.getClass()) {
            zzv zzvVar = (zzv) obj;
            int i2 = this.zzQ;
            if ((i2 == 0 || (i = zzvVar.zzQ) == 0 || i2 == i) && this.zze == zzvVar.zze && this.zzf == zzvVar.zzf && this.zzg == zzvVar.zzg && this.zzh == zzvVar.zzh && this.zzi == zzvVar.zzi && this.zzq == zzvVar.zzq && this.zzu == zzvVar.zzu && this.zzw == zzvVar.zzw && this.zzx == zzvVar.zzx && this.zzy == zzvVar.zzy && this.zzz == zzvVar.zzz && this.zzB == zzvVar.zzB && this.zzE == zzvVar.zzE && this.zzG == zzvVar.zzG && this.zzH == zzvVar.zzH && this.zzI == zzvVar.zzI && this.zzJ == zzvVar.zzJ && this.zzK == zzvVar.zzK && this.zzL == zzvVar.zzL && this.zzM == zzvVar.zzM && this.zzO == zzvVar.zzO && Float.compare(this.zzA, zzvVar.zzA) == 0 && Float.compare(this.zzC, zzvVar.zzC) == 0 && Objects.equals(this.zza, zzvVar.zza) && Objects.equals(this.zzb, zzvVar.zzb) && this.zzc.equals(zzvVar.zzc) && Objects.equals(this.zzk, zzvVar.zzk) && Objects.equals(this.zzn, zzvVar.zzn) && Objects.equals(this.zzo, zzvVar.zzo) && Objects.equals(this.zzp, zzvVar.zzp) && Objects.equals(this.zzd, zzvVar.zzd) && Arrays.equals(this.zzD, zzvVar.zzD) && Objects.equals(this.zzl, zzvVar.zzl) && Objects.equals(this.zzF, zzvVar.zzF) && Objects.equals(this.zzt, zzvVar.zzt) && zzd(zzvVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzQ;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        int iHashCode2 = this.zzc.hashCode() + zzba$$ExternalSyntheticOutline0.m(iHashCode + 527, 31, str2 == null ? 0 : str2.hashCode(), 31);
        String str3 = this.zzd;
        int iM = (((((((((zzba$$ExternalSyntheticOutline0.m(iHashCode2, 31, str3 == null ? 0 : str3.hashCode(), 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31) + this.zzi) * 31;
        String str4 = this.zzk;
        int iHashCode3 = (iM + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzap zzapVar = this.zzl;
        int iHashCode4 = iHashCode3 + (zzapVar == null ? 0 : zzapVar.hashCode());
        String str5 = this.zzn;
        int iM2 = zzba$$ExternalSyntheticOutline0.m(iHashCode4, 961, str5 == null ? 0 : str5.hashCode(), 31);
        String str6 = this.zzo;
        int iHashCode5 = (iM2 + (str6 == null ? 0 : str6.hashCode())) * 31;
        int iFloatToIntBits = ((((((((((((((((((((((Float.floatToIntBits(this.zzC) + ((((Float.floatToIntBits(this.zzA) + ((((((((((((((iHashCode5 + (this.zzp != null ? r2.hashCode() : 0)) * 31) + this.zzq) * 31) + ((int) this.zzu)) * 31) + this.zzw) * 31) + this.zzx) * 31) + this.zzy) * 31) + this.zzz) * 31)) * 31) + this.zzB) * 31)) * 31) + this.zzE) * 31) + this.zzG) * 31) + this.zzH) * 31) + this.zzI) * 31) + this.zzJ) * 31) + this.zzK) * 31) + this.zzL) * 31) + this.zzM) * 31) - 1) * 31) - 1) * 31) + this.zzO;
        this.zzQ = iFloatToIntBits;
        return iFloatToIntBits;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzF);
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzo;
        int length3 = String.valueOf(str3).length();
        String str4 = this.zzp;
        int length4 = String.valueOf(str4).length();
        String str5 = this.zzk;
        int length5 = String.valueOf(str5).length();
        int i = this.zzj;
        int length6 = String.valueOf(i).length();
        String str6 = this.zzd;
        int length7 = String.valueOf(str6).length();
        int i2 = this.zzw;
        int length8 = String.valueOf(i2).length();
        int i3 = this.zzx;
        int length9 = String.valueOf(i3).length();
        float f = this.zzA;
        int length10 = String.valueOf(f).length();
        int length11 = strValueOf.length();
        int i4 = this.zzH;
        int length12 = String.valueOf(i4).length();
        int i5 = this.zzI;
        StringBuilder sb = new StringBuilder(length + 9 + length2 + 2 + length3 + 2 + length4 + 2 + length5 + 2 + length6 + 2 + length7 + 3 + length8 + 2 + length9 + 2 + length10 + 2 + length11 + 4 + length12 + 2 + String.valueOf(i5).length() + 2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Format(", str, ", ", str2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", ", str3, ", ", str4);
        zzba$$ExternalSyntheticOutline0.m(sb, ", ", str5, ", ", i);
        zzba$$ExternalSyntheticOutline0.m(sb, ", ", str6, ", [", i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        zzba$$ExternalSyntheticOutline0.m(sb, ", ", strValueOf, "], [", i4);
        return zzba$$ExternalSyntheticOutline0.m(sb, ", ", i5, "])");
    }

    public final zzt zza() {
        return new zzt(this, null);
    }

    public final zzv zzb(int i) {
        zzt zztVar = new zzt(this, null);
        zztVar.zzN(i);
        return new zzv(zztVar);
    }

    public final int zzc() {
        int i;
        int i2 = this.zzw;
        if (i2 == -1 || (i = this.zzx) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final boolean zzd(zzv zzvVar) {
        List list = this.zzs;
        int size = list.size();
        List list2 = zzvVar.zzs;
        if (size != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ zzv(zzt zztVar, byte[] bArr) {
        this(zztVar);
    }
}
