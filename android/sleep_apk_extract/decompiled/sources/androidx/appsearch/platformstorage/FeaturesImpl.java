package androidx.appsearch.platformstorage;

import android.content.Context;
import androidx.appsearch.app.Features;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class FeaturesImpl implements Features {
    private final Context mContext;

    public FeaturesImpl(Context context) {
        this.mContext = (Context) Preconditions.checkNotNull(context);
    }
}
