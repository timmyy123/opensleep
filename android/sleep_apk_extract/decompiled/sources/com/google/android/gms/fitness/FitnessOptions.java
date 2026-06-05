package com.google.android.gms.fitness;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class FitnessOptions implements GoogleSignInOptionsExtension {
    private final Set zza;

    public static final class Builder {
        private final Set zza = new HashSet();

        public /* synthetic */ Builder(byte[] bArr) {
        }

        public Builder addDataType(DataType dataType, int i) {
            boolean z;
            if (i == 0) {
                z = true;
            } else if (i == 1) {
                i = 1;
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE");
            String strZza = dataType.zza();
            String strZzb = dataType.zzb();
            if (i == 0) {
                if (strZza != null) {
                    this.zza.add(new Scope(strZza));
                    return this;
                }
            } else if (i == 1 && strZzb != null) {
                this.zza.add(new Scope(strZzb));
            }
            return this;
        }

        public FitnessOptions build() {
            return new FitnessOptions(this, null);
        }

        public final /* synthetic */ Set zza() {
            return this.zza;
        }
    }

    public /* synthetic */ FitnessOptions(Builder builder, byte[] bArr) {
        this.zza = builder.zza();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FitnessOptions) {
            return this.zza.equals(((FitnessOptions) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public int getExtensionType() {
        return 3;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public List<Scope> getImpliedScopes() {
        return new ArrayList(this.zza);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public Bundle toBundle() {
        return new Bundle();
    }
}
