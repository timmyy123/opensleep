package com.google.android.gms.internal.aicore;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.common.collect.ImmutableMap;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzag();
    private final byte[] zzA;
    private final int zzB;
    private final int zzC;
    private final long zzD;
    private final long zzE;
    private final int zzF;
    private final int zzG;
    private final int zzH;
    private final int zzI;
    private final int zzJ;
    private final int zzK;
    private final int zzL;
    private final int zzM;
    private final long zzN;
    private final int[] zzO;
    private final int zza;
    private final long zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final long zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final long zzj;
    private final long zzk;
    private final long zzl;
    private final long zzm;
    private final long zzn;
    private final long zzo;
    private final int zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final boolean zzt;
    private final int zzu;
    private final long zzv;
    private final double zzw;
    private final double zzx;
    private final int zzy;
    private final float zzz;

    public zzae(int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, long j2, long j3, long j4, long j5, long j6, long j7, int i8, int i9, int i10, int i11, boolean z, int i12, long j8, double d, double d2, int i13, float f, byte[] bArr, int i14, int i15, long j9, long j10, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, long j11, long j12, int[] iArr) {
        this.zza = i;
        this.zzb = j12;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = j;
        this.zzg = i5;
        this.zzh = i6;
        this.zzi = i7;
        this.zzj = j2;
        this.zzk = j3;
        this.zzl = j4;
        this.zzm = j5;
        this.zzn = j6;
        this.zzo = j7;
        this.zzp = i8;
        this.zzq = i9;
        this.zzr = i10;
        this.zzs = i11;
        this.zzt = z;
        this.zzu = i12;
        this.zzv = j8;
        this.zzw = d;
        this.zzx = d2;
        this.zzy = i13;
        this.zzz = f;
        this.zzA = bArr;
        this.zzB = i14;
        this.zzC = i15;
        this.zzD = j9;
        this.zzE = j10;
        this.zzF = i16;
        this.zzG = i17;
        this.zzH = i18;
        this.zzI = i19;
        this.zzJ = i20;
        this.zzK = i21;
        this.zzL = i22;
        this.zzM = i23;
        this.zzN = j11;
        this.zzO = iArr;
    }

    public final String toString() {
        zzdm zzdmVarZzg;
        ImmutableMap.Builder builderPut = new ImmutableMap.Builder().put("customerId", Integer.valueOf(this.zza)).put("callingUserId", Long.valueOf(this.zzb)).put("featureType", Integer.valueOf(this.zzc)).put("featureVariant", Integer.valueOf(this.zzd)).put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, Integer.valueOf(this.zze)).put("inferenceLatencyTotalMillis", Long.valueOf(this.zzf)).put("numInputTokens", Integer.valueOf(this.zzg)).put("numOutputTokens", Integer.valueOf(this.zzh)).put("numDecodeSteps", Integer.valueOf(this.zzi)).put("inferenceServiceStartLatencyMillis", Long.valueOf(this.zzj)).put("inferenceApiCallHandlingLatencyMillis", Long.valueOf(this.zzk)).put("inferenceInputSafetyCheckLatencyMillis", Long.valueOf(this.zzl)).put("inferenceInputEncodingLatencyMillis", Long.valueOf(this.zzm)).put("inferenceOverallOutputLatencyMillis", Long.valueOf(this.zzn)).put("inferenceOutputSafetyCheckLatencyMillis", Long.valueOf(this.zzo)).put("inputSafetyCheckPolicyViolationType", Integer.valueOf(this.zzp)).put("inputSafetyCheckSuggestedActionType", Integer.valueOf(this.zzq)).put("outputSafetyCheckPolicyViolationType", Integer.valueOf(this.zzr)).put("outputSafetyCheckSuggestedActionType", Integer.valueOf(this.zzs)).put("isModelLoaded", Boolean.valueOf(this.zzt)).put("featureId", Integer.valueOf(this.zzu)).put("featureVersion", Integer.valueOf(this.zzM)).put("modelInferenceLatencyMillis", Long.valueOf(this.zzv)).put("outputTokensPerSecond", Double.valueOf(this.zzw)).put("inputTokensPerSecond", Double.valueOf(this.zzx)).put("numSamples", Integer.valueOf(this.zzy)).put("cannedResponsesRatio", Float.valueOf(this.zzz));
        try {
            zzdmVarZzg = zzdm.zzf(this.zzA, zzek.zza());
        } catch (zzfi e) {
            Log.e("InferenceEventTraceResult", "Failed to parse SpeculativeDecodeStatistics proto", e);
            zzdmVarZzg = zzdm.zzg();
        }
        return "InferenceEventTraceResult\n".concat(String.valueOf(builderPut.put("speculativeDecodeStatistics", "{drafter_id: " + zzdmVarZzg.zza() + ", drafter_time: " + zzdmVarZzg.zzc().zza() + ", acceptance_rate: " + zzdmVarZzg.zze() + ", drafter_guesses_per_position: " + ((String) zzdmVarZzg.zzb().stream().map(zzaf.zza).collect(Collectors.joining(", "))) + "}").put("numSuffixScoreFiltered", Integer.valueOf(this.zzB)).put("numPostDeduped", Integer.valueOf(this.zzC)).put("inferenceStatefulSuspensionLatencyMillis", Long.valueOf(this.zzD)).put("inferenceStatelessSuspensionLatencyMillis", Long.valueOf(this.zzE)).put("topCannedResponseIndex", Integer.valueOf(this.zzF)).put("inferenceStatefulSuspensionCount", Integer.valueOf(this.zzG)).put("inferenceStatefulResumptionCount", Integer.valueOf(this.zzH)).put("inferenceStatelessSuspensionCount", Integer.valueOf(this.zzI)).put("inferenceStatelessResumptionCount", Integer.valueOf(this.zzJ)).put("requestKind", Integer.valueOf(this.zzK)).put("initialQueuePosition", Integer.valueOf(this.zzL)).put("inferenceStartTimestampMillis", Long.valueOf(this.zzN)).put("auxiliaryFileTypes", this.zzO).buildOrThrow()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeLong(parcel, 5, this.zzf);
        SafeParcelWriter.writeInt(parcel, 6, this.zzg);
        SafeParcelWriter.writeInt(parcel, 7, this.zzh);
        SafeParcelWriter.writeInt(parcel, 8, this.zzi);
        SafeParcelWriter.writeLong(parcel, 9, this.zzj);
        SafeParcelWriter.writeLong(parcel, 10, this.zzk);
        SafeParcelWriter.writeLong(parcel, 11, this.zzl);
        SafeParcelWriter.writeLong(parcel, 12, this.zzm);
        SafeParcelWriter.writeLong(parcel, 13, this.zzn);
        SafeParcelWriter.writeLong(parcel, 14, this.zzo);
        SafeParcelWriter.writeInt(parcel, 15, this.zzp);
        SafeParcelWriter.writeInt(parcel, 16, this.zzq);
        SafeParcelWriter.writeInt(parcel, 17, this.zzr);
        SafeParcelWriter.writeInt(parcel, 18, this.zzs);
        SafeParcelWriter.writeBoolean(parcel, 19, this.zzt);
        SafeParcelWriter.writeInt(parcel, 20, this.zzu);
        SafeParcelWriter.writeLong(parcel, 21, this.zzv);
        SafeParcelWriter.writeDouble(parcel, 22, this.zzw);
        SafeParcelWriter.writeDouble(parcel, 23, this.zzx);
        SafeParcelWriter.writeInt(parcel, 24, this.zzy);
        SafeParcelWriter.writeFloat(parcel, 25, this.zzz);
        SafeParcelWriter.writeByteArray(parcel, 26, this.zzA, false);
        SafeParcelWriter.writeInt(parcel, 27, this.zzB);
        SafeParcelWriter.writeInt(parcel, 28, this.zzC);
        SafeParcelWriter.writeLong(parcel, 29, this.zzD);
        SafeParcelWriter.writeLong(parcel, 30, this.zzE);
        SafeParcelWriter.writeInt(parcel, 31, this.zzF);
        SafeParcelWriter.writeInt(parcel, 32, this.zzG);
        SafeParcelWriter.writeInt(parcel, 33, this.zzH);
        SafeParcelWriter.writeInt(parcel, 34, this.zzI);
        SafeParcelWriter.writeInt(parcel, 35, this.zzJ);
        SafeParcelWriter.writeInt(parcel, 36, this.zzK);
        SafeParcelWriter.writeInt(parcel, 37, this.zzL);
        SafeParcelWriter.writeInt(parcel, 38, this.zzM);
        SafeParcelWriter.writeLong(parcel, 39, this.zzN);
        SafeParcelWriter.writeLong(parcel, 40, this.zzb);
        SafeParcelWriter.writeIntArray(parcel, 41, this.zzO, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
