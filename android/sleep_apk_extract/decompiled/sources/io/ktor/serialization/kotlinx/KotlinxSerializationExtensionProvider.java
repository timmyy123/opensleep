package io.ktor.serialization.kotlinx;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlinx.serialization.SerialFormat;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxSerializationExtensionProvider;", "", "Lkotlinx/serialization/SerialFormat;", "format", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", ShareConstants.MEDIA_EXTENSION, "(Lkotlinx/serialization/SerialFormat;)Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "ktor-serialization-kotlinx"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface KotlinxSerializationExtensionProvider {
    KotlinxSerializationExtension extension(SerialFormat format);
}
