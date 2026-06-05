package com.google.android.gms.fitness.result;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataReadResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
    private final List zza;
    private final Status zzb;
    private final List zzc;
    private int zzd;
    private final List zze;

    public DataReadResult(List list, Status status, List list2, int i, List list3) {
        this.zzb = status;
        this.zzd = i;
        this.zze = list3;
        this.zza = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zza.add(new DataSet((RawDataSet) it.next(), list3));
        }
        this.zzc = new ArrayList(list2.size());
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zzc.add(new Bucket((RawBucket) it2.next(), list3));
        }
    }

    private static void zzc(DataSet dataSet, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DataSet dataSet2 = (DataSet) it.next();
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                Iterator<T> it2 = dataSet.getDataPoints().iterator();
                while (it2.hasNext()) {
                    dataSet2.zza((DataPoint) it2.next());
                }
                return;
            }
        }
        list.add(dataSet);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataReadResult)) {
            return false;
        }
        DataReadResult dataReadResult = (DataReadResult) obj;
        return this.zzb.equals(dataReadResult.zzb) && Objects.equal(this.zza, dataReadResult.zza) && Objects.equal(this.zzc, dataReadResult.zzc);
    }

    public List<Bucket> getBuckets() {
        return this.zzc;
    }

    public List<DataSet> getDataSets() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zza, this.zzc);
    }

    public String toString() {
        Objects.ToStringHelper toStringHelperAdd = Objects.toStringHelper(this).add(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.zzb);
        List list = this.zza;
        int size = list.size();
        Object objM = list;
        if (size > 5) {
            int size2 = list.size();
            objM = FileInsert$$ExternalSyntheticOutline0.m(size2, " data sets", new StringBuilder(String.valueOf(size2).length() + 10));
        }
        Objects.ToStringHelper toStringHelperAdd2 = toStringHelperAdd.add("dataSets", objM);
        List list2 = this.zzc;
        int size3 = list2.size();
        Object objM2 = list2;
        if (size3 > 5) {
            int size4 = list2.size();
            objM2 = FileInsert$$ExternalSyntheticOutline0.m(size4, " buckets", new StringBuilder(String.valueOf(size4).length() + 8));
        }
        return toStringHelperAdd2.add("buckets", objM2).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        List list = this.zza;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataSet((DataSet) it.next(), this.zze));
        }
        SafeParcelWriter.writeList(parcel, 1, arrayList, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        List list2 = this.zzc;
        ArrayList arrayList2 = new ArrayList(list2.size());
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new RawBucket((Bucket) it2.next(), this.zze));
        }
        SafeParcelWriter.writeList(parcel, 3, arrayList2, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzd;
    }

    public final void zzb(DataReadResult dataReadResult) {
        Iterator<DataSet> it = dataReadResult.getDataSets().iterator();
        while (it.hasNext()) {
            zzc(it.next(), this.zza);
        }
        for (Bucket bucket : dataReadResult.getBuckets()) {
            List list = this.zzc;
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    list.add(bucket);
                    break;
                }
                Bucket bucket2 = (Bucket) it2.next();
                if (bucket2.zzb(bucket)) {
                    Iterator<DataSet> it3 = bucket.getDataSets().iterator();
                    while (it3.hasNext()) {
                        zzc(it3.next(), bucket2.getDataSets());
                    }
                }
            }
        }
    }

    public DataReadResult(List list, List list2, Status status) {
        this.zza = list;
        this.zzb = status;
        this.zzc = list2;
        this.zzd = 1;
        this.zze = new ArrayList();
    }
}
