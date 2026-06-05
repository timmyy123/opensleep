package com.google.android.gms.wearable;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class AppTheme extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AppTheme> CREATOR = new zzc();
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private Icon zzf;
    private Headline zzg;
    private Description zzh;
    private CallToAction zzi;

    public AppTheme(int i, int i2, int i3, int i4, int i5, Icon icon, Headline headline, Description description, CallToAction callToAction) {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = new Icon();
        this.zzg = new Headline();
        this.zzh = new Description();
        this.zzi = new CallToAction();
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = icon == null ? new Icon() : icon;
        this.zzg = headline == null ? new Headline() : headline;
        this.zzh = description == null ? new Description() : description;
        this.zzi = callToAction == null ? new CallToAction() : callToAction;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppTheme)) {
            return false;
        }
        AppTheme appTheme = (AppTheme) obj;
        return zzd() == appTheme.zzd() && zzc() == appTheme.zzc() && zzb() == appTheme.zzb() && zza() == appTheme.zza() && this.zze == appTheme.zze && Objects.equals(this.zzf, appTheme.zzf) && Objects.equals(this.zzg, appTheme.zzg) && Objects.equals(this.zzh, appTheme.zzh) && Objects.equals(this.zzi, appTheme.zzi);
    }

    public final int hashCode() {
        return ((((((((((zza() + ((zzb() + ((zzc() + (zzd() * 31)) * 31)) * 31)) * 31) + this.zze) * 31) + Objects.hashCode(this.zzf)) * 31) + Objects.hashCode(this.zzg)) * 31) + Objects.hashCode(this.zzh)) * 31) + Objects.hashCode(this.zzi);
    }

    public final String toString() {
        int i = this.zze;
        int iZzc = zzc();
        int iZzd = zzd();
        int iZza = zza();
        int iZzb = zzb();
        String strValueOf = String.valueOf(this.zzf);
        String strValueOf2 = String.valueOf(this.zzg);
        String strValueOf3 = String.valueOf(this.zzh);
        String strValueOf4 = String.valueOf(this.zzi);
        int length = String.valueOf(i).length();
        int length2 = String.valueOf(iZzc).length();
        int length3 = String.valueOf(iZzd).length();
        int length4 = String.valueOf(iZza).length();
        int length5 = String.valueOf(iZzb).length();
        int length6 = strValueOf.length();
        int length7 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 42 + length2 + 16 + length3 + 19 + length4 + 19 + length5 + 8 + length6 + 12 + length7 + 15 + strValueOf3.length() + 16 + strValueOf4.length() + 1);
        Fragment$$ExternalSyntheticOutline1.m(sb, "AppTheme {deviceExperience =", i, ", colorTheme =", iZzc);
        Fragment$$ExternalSyntheticOutline1.m(sb, ", dynamicColor =", iZzd, ", screenItemsSize =", iZza);
        zzba$$ExternalSyntheticOutline0.m(sb, ", screenAlignment =", iZzb, ", icon =", strValueOf);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", headline =", strValueOf2, ", description =", strValueOf3);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", callToAction =", strValueOf4, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, zzc());
        SafeParcelWriter.writeInt(parcel, 2, zzd());
        SafeParcelWriter.writeInt(parcel, 3, zzb());
        SafeParcelWriter.writeInt(parcel, 4, zza());
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        int i = this.zzd;
        if (i == 0) {
            return 3;
        }
        return i;
    }

    public final int zzb() {
        int i = this.zzc;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final int zzc() {
        int i = this.zza;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final int zzd() {
        int i = this.zzb;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static class Icon extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Icon> CREATOR = new zzp();
        private final int zza;

        public Icon() {
            this.zza = 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.zza == ((Icon) obj).zza;
        }

        public final int hashCode() {
            return Integer.valueOf(this.zza).hashCode();
        }

        public final String toString() {
            int i = this.zza;
            return zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 28), "Icon { componentAlignment=", i, " }");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zza);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public Icon(int i) {
            this.zza = i;
        }
    }

    public static class Description extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Description> CREATOR = new zzm();
        private final int zza;
        private final int zzb;

        public Description() {
            this.zza = 0;
            this.zzb = 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Description description = (Description) obj;
                if (this.zza == description.zza && this.zzb == description.zzb) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
        }

        public final String toString() {
            int i = this.zza;
            int length = String.valueOf(i).length();
            int i2 = this.zzb;
            StringBuilder sb = new StringBuilder(length + 39 + String.valueOf(i2).length() + 2);
            Fragment$$ExternalSyntheticOutline1.m(sb, "Description { textAlignment=", i, ", textSize=", i2);
            sb.append(" }");
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zza);
            SafeParcelWriter.writeInt(parcel, 2, this.zzb);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public Description(int i, int i2) {
            this.zza = i;
            this.zzb = i2;
        }
    }

    public static class CallToAction extends AbstractSafeParcelable {
        public static final Parcelable.Creator<CallToAction> CREATOR = new zze();
        private final int zza;
        private final int zzb;
        private final int zzc;

        public CallToAction() {
            this.zza = 0;
            this.zzb = 0;
            this.zzc = 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                CallToAction callToAction = (CallToAction) obj;
                if (this.zza == callToAction.zza && this.zzb == callToAction.zzb && this.zzc == callToAction.zzc) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
        }

        public final String toString() {
            int i = this.zza;
            int length = String.valueOf(i).length();
            int i2 = this.zzb;
            int length2 = String.valueOf(i2).length();
            int i3 = this.zzc;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 37, length2, 15, String.valueOf(i3).length()) + 2);
            Fragment$$ExternalSyntheticOutline1.m(sb, "CallToAction { textSize=", i, ", buttonSize=", i2);
            return zzba$$ExternalSyntheticOutline0.m(sb, ", cornerRadius=", i3, " }");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zza);
            SafeParcelWriter.writeInt(parcel, 2, this.zzb);
            SafeParcelWriter.writeInt(parcel, 3, this.zzc);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public CallToAction(int i, int i2, int i3) {
            this.zza = i;
            this.zzb = i2;
            this.zzc = i3;
        }
    }

    public static class Headline extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Headline> CREATOR = new zzo();
        private final int zza;
        private final int zzb;
        private final int zzc;

        public Headline() {
            this.zza = 0;
            this.zzb = 0;
            this.zzc = 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Headline headline = (Headline) obj;
                if (this.zza == headline.zza && this.zzb == headline.zzb && this.zzc == headline.zzc) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
        }

        public final String toString() {
            int i = this.zza;
            int length = String.valueOf(i).length();
            int i2 = this.zzb;
            int length2 = String.valueOf(i2).length();
            int i3 = this.zzc;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 38, length2, 11, String.valueOf(i3).length()) + 2);
            Fragment$$ExternalSyntheticOutline1.m(sb, "Headline { textAlignment=", i, ", textWeight=", i2);
            return zzba$$ExternalSyntheticOutline0.m(sb, ", textSize=", i3, " }");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zza);
            SafeParcelWriter.writeInt(parcel, 2, this.zzb);
            SafeParcelWriter.writeInt(parcel, 3, this.zzc);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public Headline(int i, int i2, int i3) {
            this.zza = i;
            this.zzb = i2;
            this.zzc = i3;
        }
    }
}
