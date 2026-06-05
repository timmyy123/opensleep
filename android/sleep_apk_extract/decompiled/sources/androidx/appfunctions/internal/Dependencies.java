package androidx.appfunctions.internal;

import android.util.Log;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/appfunctions/internal/Dependencies;", "", "<init>", "()V", "translatorSelector", "Landroidx/appfunctions/internal/TranslatorSelector;", "getTranslatorSelector", "()Landroidx/appfunctions/internal/TranslatorSelector;", "translatorSelector$delegate", "Lkotlin/Lazy;", "schemaAppFunctionInventory", "Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "getSchemaAppFunctionInventory$appfunctions", "()Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "schemaAppFunctionInventory$delegate", "aggregatedAppFunctionInventory", "Landroidx/appfunctions/internal/AggregatedAppFunctionInventory;", "getAggregatedAppFunctionInventory", "()Landroidx/appfunctions/internal/AggregatedAppFunctionInventory;", "aggregatedAppFunctionInventory$delegate", "appFunctionInventory", "Landroidx/appfunctions/internal/AppFunctionInventory;", "getAppFunctionInventory$appfunctions", "()Landroidx/appfunctions/internal/AppFunctionInventory;", "appFunctionInventory$delegate", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Dependencies {
    public static final Dependencies INSTANCE = new Dependencies();

    /* JADX INFO: renamed from: translatorSelector$delegate, reason: from kotlin metadata */
    private static final Lazy translatorSelector = LazyKt.lazy(new Tool$$ExternalSyntheticLambda0(2));

    /* JADX INFO: renamed from: schemaAppFunctionInventory$delegate, reason: from kotlin metadata */
    private static final Lazy schemaAppFunctionInventory = LazyKt.lazy(new Tool$$ExternalSyntheticLambda0(3));

    /* JADX INFO: renamed from: aggregatedAppFunctionInventory$delegate, reason: from kotlin metadata */
    private static final Lazy aggregatedAppFunctionInventory = LazyKt.lazy(new Tool$$ExternalSyntheticLambda0(4));

    /* JADX INFO: renamed from: appFunctionInventory$delegate, reason: from kotlin metadata */
    private static final Lazy appFunctionInventory = LazyKt.lazy(new Tool$$ExternalSyntheticLambda0(5));

    private Dependencies() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AggregatedAppFunctionInventory aggregatedAppFunctionInventory_delegate$lambda$0() {
        try {
            return (AggregatedAppFunctionInventory) ClassUtilsKt.findImpl(AggregatedAppFunctionInventory.class, "$", "_Impl");
        } catch (Exception e) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Cannot find AggregatedAppFunctionInventory implementation", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionInventory appFunctionInventory_delegate$lambda$0() {
        Dependencies dependencies = INSTANCE;
        return dependencies.getAggregatedAppFunctionInventory() != null ? dependencies.getAggregatedAppFunctionInventory() : dependencies.getSchemaAppFunctionInventory$appfunctions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchemaAppFunctionInventory schemaAppFunctionInventory_delegate$lambda$0() {
        try {
            return (SchemaAppFunctionInventory) ClassUtilsKt.findImpl(SchemaAppFunctionInventory.class, "$", "_Impl");
        } catch (Exception unused) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Cannot find SchemaAppFunctionInventory implementation");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TranslatorSelector translatorSelector_delegate$lambda$0() {
        try {
            return (TranslatorSelector) ClassUtilsKt.findImpl(TranslatorSelector.class, "", "Impl");
        } catch (Exception unused) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Cannot find TranslatorSelectorImpl");
            return new NullTranslatorSelector();
        }
    }

    public final AggregatedAppFunctionInventory getAggregatedAppFunctionInventory() {
        return (AggregatedAppFunctionInventory) aggregatedAppFunctionInventory.getValue();
    }

    public final AppFunctionInventory getAppFunctionInventory$appfunctions() {
        return (AppFunctionInventory) appFunctionInventory.getValue();
    }

    public final SchemaAppFunctionInventory getSchemaAppFunctionInventory$appfunctions() {
        return (SchemaAppFunctionInventory) schemaAppFunctionInventory.getValue();
    }

    public final TranslatorSelector getTranslatorSelector() {
        return (TranslatorSelector) translatorSelector.getValue();
    }
}
