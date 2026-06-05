package com.polar.sdk.api;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.impl.BDBleApiImpl;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/polar/sdk/api/PolarBleApiDefaultImpl;", "", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;", "features", "Lcom/polar/sdk/impl/BDBleApiImpl;", "defaultImplementation", "(Landroid/content/Context;Ljava/util/Set;)Lcom/polar/sdk/impl/BDBleApiImpl;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PolarBleApiDefaultImpl {
    public static final PolarBleApiDefaultImpl INSTANCE = new PolarBleApiDefaultImpl();

    private PolarBleApiDefaultImpl() {
    }

    public static final BDBleApiImpl defaultImplementation(Context context, Set<? extends PolarBleApi.PolarBleSdkFeature> features) {
        context.getClass();
        features.getClass();
        return BDBleApiImpl.INSTANCE.getInstance(context, features);
    }
}
