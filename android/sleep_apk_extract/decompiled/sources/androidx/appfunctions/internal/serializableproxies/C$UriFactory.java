package androidx.appfunctions.internal.serializableproxies;

import android.net.Uri;
import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.AppFunctionSerializableFactory;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: renamed from: androidx.appfunctions.internal.serializableproxies.$UriFactory, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"androidx/appfunctions/internal/serializableproxies/$UriFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "Landroid/net/Uri;", "<init>", "()V", IntrospectionHelper.AppFunctionSerializableFactoryClass.FromAppFunctionDataMethod.METHOD_NAME, "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.METHOD_NAME, IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C$UriFactory implements AppFunctionSerializableFactory<Uri> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public Uri fromAppFunctionData(AppFunctionData appFunctionData) {
        appFunctionData.getClass();
        String stringOrNull = getAppFunctionDataWithSpec(appFunctionData, "android.net.Uri").getStringOrNull(ShareConstants.MEDIA_URI);
        if (stringOrNull != null) {
            return new AppFunctionUri(stringOrNull).toUri();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
        return null;
    }

    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public AppFunctionData toAppFunctionData(Uri appFunctionSerializable) {
        appFunctionSerializable.getClass();
        AppFunctionUri appFunctionUriFromUri = AppFunctionUri.INSTANCE.fromUri(appFunctionSerializable);
        AppFunctionData.Builder appFunctionDataBuilder = getAppFunctionDataBuilder("android.net.Uri");
        appFunctionDataBuilder.setString(ShareConstants.MEDIA_URI, appFunctionUriFromUri.getUri());
        return appFunctionDataBuilder.build();
    }
}
