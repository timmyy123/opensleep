package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzeh;

/* JADX INFO: loaded from: classes3.dex */
public class AdRequest {
    protected final zzeh zza;

    public AdRequest(AbstractAdRequestBuilder abstractAdRequestBuilder) {
        this.zza = new zzeh(abstractAdRequestBuilder.zza);
    }

    public final zzeh zza() {
        return this.zza;
    }

    public static class Builder extends AbstractAdRequestBuilder<Builder> {
        public AdRequest build() {
            return new AdRequest(this);
        }

        @Override // com.google.android.gms.ads.AbstractAdRequestBuilder
        public Builder self() {
            return this;
        }
    }
}
