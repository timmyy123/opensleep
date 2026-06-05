package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import kotlin.Metadata;
import kotlinx.serialization.StringFormat;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/serialization/Configuration;", "Lio/ktor/http/ContentType;", "contentType", "Lkotlinx/serialization/StringFormat;", "format", "", "serialization", "(Lio/ktor/serialization/Configuration;Lio/ktor/http/ContentType;Lkotlinx/serialization/StringFormat;)V", "ktor-serialization-kotlinx"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class KotlinxSerializationConverterKt {
    public static final void serialization(Configuration configuration, ContentType contentType, StringFormat stringFormat) {
        configuration.getClass();
        contentType.getClass();
        stringFormat.getClass();
        Configuration.DefaultImpls.register$default(configuration, contentType, new KotlinxSerializationConverter(stringFormat), null, 4, null);
    }
}
