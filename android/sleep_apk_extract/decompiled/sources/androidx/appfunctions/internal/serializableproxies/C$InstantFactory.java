package androidx.appfunctions.internal.serializableproxies;

import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.AppFunctionSerializableFactory;
import j$.time.Instant;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: renamed from: androidx.appfunctions.internal.serializableproxies.$InstantFactory, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/appfunctions/internal/serializableproxies/$InstantFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "j$/time/Instant", "<init>", "()V", "Landroidx/appfunctions/AppFunctionData;", "appFunctionData", IntrospectionHelper.AppFunctionSerializableFactoryClass.FromAppFunctionDataMethod.METHOD_NAME, "(Landroidx/appfunctions/AppFunctionData;)Lj$/time/Instant;", IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME, IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.METHOD_NAME, "(Lj$/time/Instant;)Landroidx/appfunctions/AppFunctionData;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C$InstantFactory implements AppFunctionSerializableFactory<Instant> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public Instant fromAppFunctionData(AppFunctionData appFunctionData) {
        appFunctionData.getClass();
        AppFunctionData appFunctionDataWithSpec = getAppFunctionDataWithSpec(appFunctionData, "java.time.Instant");
        Long longOrNull = appFunctionDataWithSpec.getLongOrNull("epochSecond");
        if (longOrNull == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        long jLongValue = longOrNull.longValue();
        Integer intOrNull = appFunctionDataWithSpec.getIntOrNull("nanoAdjustment");
        if (intOrNull != null) {
            return new AppFunctionInstant(jLongValue, intOrNull.intValue()).toInstant();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
        return null;
    }

    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public AppFunctionData toAppFunctionData(Instant appFunctionSerializable) {
        appFunctionSerializable.getClass();
        AppFunctionInstant appFunctionInstantFromInstant = AppFunctionInstant.INSTANCE.fromInstant(appFunctionSerializable);
        AppFunctionData.Builder appFunctionDataBuilder = getAppFunctionDataBuilder("java.time.Instant");
        appFunctionDataBuilder.setLong("epochSecond", appFunctionInstantFromInstant.getEpochSecond());
        appFunctionDataBuilder.setInt("nanoAdjustment", appFunctionInstantFromInstant.getNanoAdjustment());
        return appFunctionDataBuilder.build();
    }
}
