package androidx.appfunctions.internal.serializableproxies;

import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.AppFunctionSerializableFactory;
import j$.time.LocalDateTime;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: renamed from: androidx.appfunctions.internal.serializableproxies.$LocalDateTimeFactory, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/appfunctions/internal/serializableproxies/$LocalDateTimeFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "j$/time/LocalDateTime", "<init>", "()V", "Landroidx/appfunctions/AppFunctionData;", "appFunctionData", IntrospectionHelper.AppFunctionSerializableFactoryClass.FromAppFunctionDataMethod.METHOD_NAME, "(Landroidx/appfunctions/AppFunctionData;)Lj$/time/LocalDateTime;", IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME, IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.METHOD_NAME, "(Lj$/time/LocalDateTime;)Landroidx/appfunctions/AppFunctionData;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C$LocalDateTimeFactory implements AppFunctionSerializableFactory<LocalDateTime> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public LocalDateTime fromAppFunctionData(AppFunctionData appFunctionData) {
        appFunctionData.getClass();
        AppFunctionData appFunctionDataWithSpec = getAppFunctionDataWithSpec(appFunctionData, "java.time.LocalDateTime");
        Integer intOrNull = appFunctionDataWithSpec.getIntOrNull("year");
        if (intOrNull == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        int iIntValue = intOrNull.intValue();
        Integer intOrNull2 = appFunctionDataWithSpec.getIntOrNull("month");
        if (intOrNull2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        int iIntValue2 = intOrNull2.intValue();
        Integer intOrNull3 = appFunctionDataWithSpec.getIntOrNull("dayOfMonth");
        if (intOrNull3 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        int iIntValue3 = intOrNull3.intValue();
        Integer intOrNull4 = appFunctionDataWithSpec.getIntOrNull("hour");
        if (intOrNull4 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        int iIntValue4 = intOrNull4.intValue();
        Integer intOrNull5 = appFunctionDataWithSpec.getIntOrNull("minute");
        if (intOrNull5 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        int iIntValue5 = intOrNull5.intValue();
        Integer intOrNull6 = appFunctionDataWithSpec.getIntOrNull("second");
        if (intOrNull6 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        int iIntValue6 = intOrNull6.intValue();
        Integer intOrNull7 = appFunctionDataWithSpec.getIntOrNull("nanoOfSecond");
        if (intOrNull7 != null) {
            return new AppFunctionLocalDateTime(iIntValue, iIntValue2, iIntValue3, iIntValue4, iIntValue5, iIntValue6, intOrNull7.intValue()).toLocalDateTime();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
        return null;
    }

    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public AppFunctionData toAppFunctionData(LocalDateTime appFunctionSerializable) {
        appFunctionSerializable.getClass();
        AppFunctionLocalDateTime appFunctionLocalDateTimeFromLocalDateTime = AppFunctionLocalDateTime.INSTANCE.fromLocalDateTime(appFunctionSerializable);
        AppFunctionData.Builder appFunctionDataBuilder = getAppFunctionDataBuilder("java.time.LocalDateTime");
        appFunctionDataBuilder.setInt("year", appFunctionLocalDateTimeFromLocalDateTime.getYear());
        appFunctionDataBuilder.setInt("month", appFunctionLocalDateTimeFromLocalDateTime.getMonth());
        appFunctionDataBuilder.setInt("dayOfMonth", appFunctionLocalDateTimeFromLocalDateTime.getDayOfMonth());
        appFunctionDataBuilder.setInt("hour", appFunctionLocalDateTimeFromLocalDateTime.getHour());
        appFunctionDataBuilder.setInt("minute", appFunctionLocalDateTimeFromLocalDateTime.getMinute());
        appFunctionDataBuilder.setInt("second", appFunctionLocalDateTimeFromLocalDateTime.getSecond());
        appFunctionDataBuilder.setInt("nanoOfSecond", appFunctionLocalDateTimeFromLocalDateTime.getNanoOfSecond());
        return appFunctionDataBuilder.build();
    }
}
