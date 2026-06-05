package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
final class zzaoi {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzaoo zzf;
    public final String zzg;
    public final String zzh;
    public final zzaoi zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    private zzaoi(String str, String str2, long j, long j2, zzaoo zzaooVar, String[] strArr, String str3, String str4, zzaoi zzaoiVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzaooVar;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzaoiVar;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }

    public static zzaoi zza(String str) {
        return new zzaoi(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static zzaoi zzb(String str, long j, long j2, zzaoo zzaooVar, String[] strArr, String str2, String str3, zzaoi zzaoiVar) {
        return new zzaoi(str, null, j, j2, zzaooVar, strArr, str2, str3, zzaoiVar);
    }

    private final void zzi(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean zEquals = "p".equals(str);
        if (z || zEquals || ("div".equals(str) && this.zzh != null)) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzaoi zzaoiVar = (zzaoi) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !zEquals) {
                    z2 = false;
                }
                zzaoiVar.zzi(treeSet, z2);
            }
        }
    }

    private final void zzj(long j, String str, List list) {
        String str2;
        String str3 = this.zzg;
        boolean zEquals = "".equals(str3);
        boolean zZzc = zzc(j);
        if (true != zEquals) {
            str = str3;
        }
        if (zZzc && "div".equals(this.zza) && (str2 = this.zzh) != null) {
            list.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < zzf(); i++) {
            zze(i).zzj(j, str, list);
        }
    }

    private final void zzk(long j, boolean z, String str, Map map) {
        long j2;
        boolean z2;
        HashMap map2 = this.zzk;
        map2.clear();
        HashMap map3 = this.zzl;
        map3.clear();
        String str2 = this.zza;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.zzg;
        String str4 = true != "".equals(str3) ? str3 : str;
        if (this.zzc && z) {
            SpannableStringBuilder spannableStringBuilderZzl = zzl(str4, map);
            String str5 = this.zzb;
            str5.getClass();
            spannableStringBuilderZzl.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z) {
            zzl(str4, map).append('\n');
            return;
        }
        if (zzc(j)) {
            for (Map.Entry entry : map.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequenceZzb = ((zzcw) entry.getValue()).zzb();
                charSequenceZzb.getClass();
                map2.put(str6, Integer.valueOf(charSequenceZzb.length()));
            }
            boolean zEquals = "p".equals(str2);
            for (int i = 0; i < zzf(); i++) {
                zzaoi zzaoiVarZze = zze(i);
                if (z || zEquals) {
                    j2 = j;
                    z2 = true;
                } else {
                    j2 = j;
                    z2 = false;
                }
                zzaoiVarZze.zzk(j2, z2, str4, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderZzl2 = zzl(str4, map);
                int length = spannableStringBuilderZzl2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderZzl2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderZzl2.charAt(length) != '\n') {
                    spannableStringBuilderZzl2.append('\n');
                }
            }
            for (Map.Entry entry2 : map.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequenceZzb2 = ((zzcw) entry2.getValue()).zzb();
                charSequenceZzb2.getClass();
                map3.put(str7, Integer.valueOf(charSequenceZzb2.length()));
            }
        }
    }

    private static SpannableStringBuilder zzl(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcw zzcwVar = new zzcw();
            zzcwVar.zza(new SpannableStringBuilder());
            map.put(str, zzcwVar);
        }
        CharSequence charSequenceZzb = ((zzcw) map.get(str)).zzb();
        charSequenceZzb.getClass();
        return (SpannableStringBuilder) charSequenceZzb;
    }

    private final void zzm(long j, Map map, Map map2, String str, Map map3) {
        Iterator it;
        zzaoi zzaoiVar;
        zzaoo zzaooVarZza;
        int i;
        boolean z;
        int i2;
        Map map4 = map;
        if (zzc(j)) {
            String str2 = this.zzg;
            String str3 = true != "".equals(str2) ? str2 : str;
            Iterator it2 = this.zzl.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                String str4 = (String) entry.getKey();
                HashMap map5 = this.zzk;
                int iIntValue = map5.containsKey(str4) ? ((Integer) map5.get(str4)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    zzcw zzcwVar = (zzcw) map3.get(str4);
                    zzcwVar.getClass();
                    zzaom zzaomVar = (zzaom) map2.get(str3);
                    zzaomVar.getClass();
                    int i3 = zzaomVar.zzj;
                    zzaoo zzaooVarZza2 = zzaon.zza(this.zzf, this.zzj, map4);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzcwVar.zzb();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzcwVar.zza(spannableStringBuilder);
                    }
                    if (zzaooVarZza2 != null) {
                        zzaoi zzaoiVar2 = this.zzi;
                        if (zzaooVarZza2.zza() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zzaooVarZza2.zza()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaooVarZza2.zzb()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaooVarZza2.zzd()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaooVarZza2.zzl()) {
                            zzdd.zza(spannableStringBuilder, new ForegroundColorSpan(zzaooVarZza2.zzj()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaooVarZza2.zzo()) {
                            zzdd.zza(spannableStringBuilder, new BackgroundColorSpan(zzaooVarZza2.zzm()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaooVarZza2.zzh() != null) {
                            zzdd.zza(spannableStringBuilder, new TypefaceSpan(zzaooVarZza2.zzh()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaooVarZza2.zzE() != null) {
                            zzaoh zzaohVarZzE = zzaooVarZza2.zzE();
                            zzaohVarZzE.getClass();
                            int i4 = zzaohVarZzE.zza;
                            it = it2;
                            if (i4 == -1) {
                                i4 = (i3 == 2 || i3 == 1) ? 3 : 1;
                                i2 = 1;
                            } else {
                                i2 = zzaohVarZzE.zzb;
                            }
                            int i5 = zzaohVarZzE.zzc;
                            if (i5 == -2) {
                                i5 = 1;
                            }
                            zzdd.zza(spannableStringBuilder, new zzde(i4, i2, i5), iIntValue, iIntValue2, 33);
                        } else {
                            it = it2;
                        }
                        int iZzv = zzaooVarZza2.zzv();
                        if (iZzv == 2) {
                            while (true) {
                                if (zzaoiVar2 == null) {
                                    zzaoiVar2 = null;
                                    break;
                                }
                                zzaoo zzaooVarZza3 = zzaon.zza(zzaoiVar2.zzf, zzaoiVar2.zzj, map4);
                                if (zzaooVarZza3 != null && zzaooVarZza3.zzv() == 1) {
                                    break;
                                } else {
                                    zzaoiVar2 = zzaoiVar2.zzi;
                                }
                            }
                            if (zzaoiVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzaoiVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzaoiVar = null;
                                        break;
                                    }
                                    zzaoi zzaoiVar3 = (zzaoi) arrayDeque.pop();
                                    zzaoo zzaooVarZza4 = zzaon.zza(zzaoiVar3.zzf, zzaoiVar3.zzj, map4);
                                    if (zzaooVarZza4 != null && zzaooVarZza4.zzv() == 3) {
                                        zzaoiVar = zzaoiVar3;
                                        break;
                                    }
                                    for (int iZzf = zzaoiVar3.zzf() - 1; iZzf >= 0; iZzf--) {
                                        arrayDeque.push(zzaoiVar3.zze(iZzf));
                                    }
                                }
                                if (zzaoiVar != null) {
                                    if (zzaoiVar.zzf() != 1 || zzaoiVar.zze(0).zzb == null) {
                                        zzeg.zzb("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str5 = zzaoiVar.zze(0).zzb;
                                        String str6 = zzfl.zza;
                                        zzaoo zzaooVarZza5 = zzaon.zza(zzaoiVar.zzf, zzaoiVar.zzj, map4);
                                        int iZzx = zzaooVarZza5 != null ? zzaooVarZza5.zzx() : -1;
                                        if (iZzx == -1 && (zzaooVarZza = zzaon.zza(zzaoiVar2.zzf, zzaoiVar2.zzj, map4)) != null) {
                                            iZzx = zzaooVarZza.zzx();
                                        }
                                        spannableStringBuilder.setSpan(new zzdc(str5, iZzx), iIntValue, iIntValue2, 33);
                                    }
                                }
                            }
                        } else if (iZzv == 3 || iZzv == 4) {
                            spannableStringBuilder.setSpan(new zzaog(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaooVarZza2.zzC()) {
                            i = 33;
                            zzdd.zza(spannableStringBuilder, new zzdb(), iIntValue, iIntValue2, 33);
                        } else {
                            i = 33;
                        }
                        int iZzI = zzaooVarZza2.zzI();
                        if (iZzI != 1) {
                            if (iZzI == 2) {
                                zzdd.zza(spannableStringBuilder, new RelativeSizeSpan(zzaooVarZza2.zzJ()), iIntValue, iIntValue2, i);
                            } else if (iZzI == 3) {
                                zzdd.zzb(spannableStringBuilder, zzaooVarZza2.zzJ() / 100.0f, iIntValue, iIntValue2, i);
                            }
                            z = true;
                        } else {
                            z = true;
                            zzdd.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzaooVarZza2.zzJ(), true), iIntValue, iIntValue2, i);
                        }
                        if ("p".equals(this.zza)) {
                            if (zzaooVarZza2.zzq() != Float.MAX_VALUE) {
                                zzcwVar.zzp((zzaooVarZza2.zzq() * (-90.0f)) / 100.0f);
                            }
                            if (zzaooVarZza2.zzy() != null) {
                                zzcwVar.zzd(zzaooVarZza2.zzy());
                            }
                            if (zzaooVarZza2.zzA() != null) {
                                zzcwVar.zze(zzaooVarZza2.zzA());
                            }
                        }
                        it2 = it;
                    }
                }
            }
            int i6 = 0;
            while (i6 < zzf()) {
                zze(i6).zzm(j, map4, map2, str3, map3);
                i6++;
                map4 = map;
            }
        }
    }

    public final boolean zzc(long j) {
        long j2 = this.zzd;
        if (j2 == -9223372036854775807L) {
            if (this.zze == -9223372036854775807L) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        if (j2 <= j && this.zze == -9223372036854775807L) {
            return true;
        }
        if (j2 != -9223372036854775807L || j >= this.zze) {
            return j2 <= j && j < this.zze;
        }
        return true;
    }

    public final void zzd(zzaoi zzaoiVar) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzaoiVar);
    }

    public final zzaoi zze(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzaoi) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int zzf() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final long[] zzg() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzi(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public final List zzh(long j, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        String str = this.zzg;
        zzj(j, str, arrayList);
        TreeMap treeMap = new TreeMap();
        zzk(j, false, str, treeMap);
        zzm(j, map, map2, str, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str2 = (String) map3.get(pair.second);
            if (str2 != null) {
                byte[] bArrDecode = Base64.decode(str2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                zzaom zzaomVar = (zzaom) map2.get(pair.first);
                zzaomVar.getClass();
                zzcw zzcwVar = new zzcw();
                zzcwVar.zzc(bitmapDecodeByteArray);
                zzcwVar.zzi(zzaomVar.zzb);
                zzcwVar.zzj(0);
                zzcwVar.zzf(zzaomVar.zzc, 0);
                zzcwVar.zzg(zzaomVar.zze);
                zzcwVar.zzm(zzaomVar.zzf);
                zzcwVar.zzn(zzaomVar.zzg);
                zzcwVar.zzo(zzaomVar.zzj);
                arrayList2.add(zzcwVar.zzr());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzaom zzaomVar2 = (zzaom) map2.get(entry.getKey());
            zzaomVar2.getClass();
            zzcw zzcwVar2 = (zzcw) entry.getValue();
            CharSequence charSequenceZzb = zzcwVar2.zzb();
            charSequenceZzb.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequenceZzb;
            for (zzaog zzaogVar : (zzaog[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzaog.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzaogVar), spannableStringBuilder.getSpanEnd(zzaogVar), (CharSequence) "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == '\n') {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzcwVar2.zzf(zzaomVar2.zzc, zzaomVar2.zzd);
            zzcwVar2.zzg(zzaomVar2.zze);
            zzcwVar2.zzi(zzaomVar2.zzb);
            zzcwVar2.zzm(zzaomVar2.zzf);
            zzcwVar2.zzl(zzaomVar2.zzi, zzaomVar2.zzh);
            zzcwVar2.zzo(zzaomVar2.zzj);
            arrayList2.add(zzcwVar2.zzr());
        }
        return arrayList2;
    }
}
