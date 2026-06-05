package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbj extends zzav {
    public zzbj() {
        this.zza.add(zzbk.ASSIGN);
        this.zza.add(zzbk.CONST);
        this.zza.add(zzbk.CREATE_ARRAY);
        this.zza.add(zzbk.CREATE_OBJECT);
        this.zza.add(zzbk.EXPRESSION_LIST);
        this.zza.add(zzbk.GET);
        this.zza.add(zzbk.GET_INDEX);
        this.zza.add(zzbk.GET_PROPERTY);
        this.zza.add(zzbk.NULL);
        this.zza.add(zzbk.SET_PROPERTY);
        this.zza.add(zzbk.TYPEOF);
        this.zza.add(zzbk.UNDEFINED);
        this.zza.add(zzbk.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        String str2;
        zzbk zzbkVar = zzbk.ADD;
        int iOrdinal = zzh.zze(str).ordinal();
        int i = 0;
        if (iOrdinal == 3) {
            zzao zzaoVarZza = zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.ASSIGN, 2, list, 0));
            if (!(zzaoVarZza instanceof zzas)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Expected string for assign var. got ", zzaoVarZza.getClass().getCanonicalName()));
                return null;
            }
            if (!zzgVar.zzd(zzaoVarZza.zzc())) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Attempting to assign undefined value ", zzaoVarZza.zzc()));
                return null;
            }
            zzao zzaoVarZza2 = zzgVar.zza((zzao) list.get(1));
            zzgVar.zze(zzaoVarZza.zzc(), zzaoVarZza2);
            return zzaoVarZza2;
        }
        if (iOrdinal == 14) {
            zzh.zzb(zzbk.CONST.name(), 2, list);
            if (list.size() % 2 != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(list.size(), "CONST requires an even number of arguments, found "));
                return null;
            }
            while (i < list.size() - 1) {
                zzao zzaoVarZza3 = zzgVar.zza((zzao) list.get(i));
                if (!(zzaoVarZza3 instanceof zzas)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Expected string for const name. got ", zzaoVarZza3.getClass().getCanonicalName()));
                    return null;
                }
                zzgVar.zzg(zzaoVarZza3.zzc(), zzgVar.zza((zzao) list.get(i + 1)));
                i += 2;
            }
            return zzao.zzf;
        }
        if (iOrdinal == 24) {
            zzh.zzb(zzbk.EXPRESSION_LIST.name(), 1, list);
            zzao zzaoVarZza4 = zzao.zzf;
            while (i < list.size()) {
                zzaoVarZza4 = zzgVar.zza((zzao) list.get(i));
                if (zzaoVarZza4 instanceof zzag) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("ControlValue cannot be in an expression list");
                    return null;
                }
                i++;
            }
            return zzaoVarZza4;
        }
        if (iOrdinal == 33) {
            zzao zzaoVarZza5 = zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.GET, 1, list, 0));
            if (zzaoVarZza5 instanceof zzas) {
                return zzgVar.zzh(zzaoVarZza5.zzc());
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Expected string for get var. got ", zzaoVarZza5.getClass().getCanonicalName()));
            return null;
        }
        if (iOrdinal == 49) {
            zzh.zza(zzbk.NULL.name(), 0, list);
            return zzao.zzg;
        }
        if (iOrdinal == 58) {
            zzao zzaoVarZza6 = zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.SET_PROPERTY, 3, list, 0));
            zzao zzaoVarZza7 = zzgVar.zza((zzao) list.get(1));
            zzao zzaoVarZza8 = zzgVar.zza((zzao) list.get(2));
            if (zzaoVarZza6 == zzao.zzf || zzaoVarZza6 == zzao.zzg) {
                Utf8$$ExternalSyntheticBUOutline0.m$3(Fragment$$ExternalSyntheticOutline1.m("Can't set property ", zzaoVarZza7.zzc(), " of ", zzaoVarZza6.zzc()));
                return null;
            }
            if ((zzaoVarZza6 instanceof zzae) && (zzaoVarZza7 instanceof zzah)) {
                ((zzae) zzaoVarZza6).zzn(zzaoVarZza7.zzd().intValue(), zzaoVarZza8);
                return zzaoVarZza8;
            }
            if (!(zzaoVarZza6 instanceof zzak)) {
                return zzaoVarZza8;
            }
            ((zzak) zzaoVarZza6).zzm(zzaoVarZza7.zzc(), zzaoVarZza8);
            return zzaoVarZza8;
        }
        if (iOrdinal == 17) {
            if (list.isEmpty()) {
                return new zzae();
            }
            zzae zzaeVar = new zzae();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzao zzaoVarZza9 = zzgVar.zza((zzao) it.next());
                if (zzaoVarZza9 instanceof zzag) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Failed to evaluate array element");
                    return null;
                }
                zzaeVar.zzn(i, zzaoVarZza9);
                i++;
            }
            return zzaeVar;
        }
        if (iOrdinal == 18) {
            if (list.isEmpty()) {
                return new zzal();
            }
            if (list.size() % 2 != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(list.size(), "CREATE_OBJECT requires an even number of arguments, found "));
                return null;
            }
            zzal zzalVar = new zzal();
            while (i < list.size() - 1) {
                zzao zzaoVarZza10 = zzgVar.zza((zzao) list.get(i));
                zzao zzaoVarZza11 = zzgVar.zza((zzao) list.get(i + 1));
                if ((zzaoVarZza10 instanceof zzag) || (zzaoVarZza11 instanceof zzag)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Failed to evaluate map entry");
                    return null;
                }
                zzalVar.zzm(zzaoVarZza10.zzc(), zzaoVarZza11);
                i += 2;
            }
            return zzalVar;
        }
        if (iOrdinal == 35 || iOrdinal == 36) {
            zzao zzaoVarZza12 = zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.GET_PROPERTY, 2, list, 0));
            zzao zzaoVarZza13 = zzgVar.zza((zzao) list.get(1));
            if ((zzaoVarZza12 instanceof zzae) && zzh.zzd(zzaoVarZza13)) {
                return ((zzae) zzaoVarZza12).zzl(zzaoVarZza13.zzd().intValue());
            }
            if (zzaoVarZza12 instanceof zzak) {
                return ((zzak) zzaoVarZza12).zzk(zzaoVarZza13.zzc());
            }
            if (zzaoVarZza12 instanceof zzas) {
                if ("length".equals(zzaoVarZza13.zzc())) {
                    return new zzah(Double.valueOf(zzaoVarZza12.zzc().length()));
                }
                if (zzh.zzd(zzaoVarZza13) && zzaoVarZza13.zzd().doubleValue() < zzaoVarZza12.zzc().length()) {
                    return new zzas(String.valueOf(zzaoVarZza12.zzc().charAt(zzaoVarZza13.zzd().intValue())));
                }
            }
            return zzao.zzf;
        }
        switch (iOrdinal) {
            case 62:
                zzao zzaoVarZza14 = zzgVar.zza((zzao) zza$$ExternalSyntheticOutline0.m(zzbk.TYPEOF, 1, list, 0));
                if (zzaoVarZza14 instanceof zzat) {
                    str2 = "undefined";
                } else if (zzaoVarZza14 instanceof zzaf) {
                    str2 = "boolean";
                } else if (zzaoVarZza14 instanceof zzah) {
                    str2 = "number";
                } else if (zzaoVarZza14 instanceof zzas) {
                    str2 = "string";
                } else if (zzaoVarZza14 instanceof zzan) {
                    str2 = "function";
                } else {
                    if ((zzaoVarZza14 instanceof zzap) || (zzaoVarZza14 instanceof zzag)) {
                        Home$$ExternalSyntheticBUOutline0.m("Unsupported value type %s in typeof", new Object[]{zzaoVarZza14});
                        return null;
                    }
                    str2 = "object";
                }
                return new zzas(str2);
            case 63:
                zzh.zza(zzbk.UNDEFINED.name(), 0, list);
                return zzao.zzf;
            case 64:
                zzh.zzb(zzbk.VAR.name(), 1, list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    zzao zzaoVarZza15 = zzgVar.zza((zzao) it2.next());
                    if (!(zzaoVarZza15 instanceof zzas)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Expected string for var name. got ", zzaoVarZza15.getClass().getCanonicalName()));
                        return null;
                    }
                    zzgVar.zzf(zzaoVarZza15.zzc(), zzao.zzf);
                }
                return zzao.zzf;
            default:
                return zzb(str);
        }
    }
}
