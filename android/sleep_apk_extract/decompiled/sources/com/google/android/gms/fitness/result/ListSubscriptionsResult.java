package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Subscription;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ListSubscriptionsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new zzg();
    private final List zza;
    private final Status zzb;

    public ListSubscriptionsResult(List list, Status status) {
        this.zza = list;
        this.zzb = status;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListSubscriptionsResult)) {
            return false;
        }
        ListSubscriptionsResult listSubscriptionsResult = (ListSubscriptionsResult) obj;
        return this.zzb.equals(listSubscriptionsResult.zzb) && Objects.equal(this.zza, listSubscriptionsResult.zza);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzb;
    }

    public List<Subscription> getSubscriptions() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.zzb).add("subscriptions", this.zza).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getSubscriptions(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
