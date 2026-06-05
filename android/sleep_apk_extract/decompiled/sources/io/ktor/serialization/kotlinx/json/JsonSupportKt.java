package io.ktor.serialization.kotlinx.json;

import io.ktor.http.ContentType;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a%\u0010\u0002\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0002\u0010\u0006\"\u0017\u0010\u0007\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/serialization/Configuration;", "Lkotlinx/serialization/json/Json;", "json", "Lio/ktor/http/ContentType;", "contentType", "", "(Lio/ktor/serialization/Configuration;Lkotlinx/serialization/json/Json;Lio/ktor/http/ContentType;)V", "DefaultJson", "Lkotlinx/serialization/json/Json;", "getDefaultJson", "()Lkotlinx/serialization/json/Json;", "ktor-serialization-kotlinx-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class JsonSupportKt {
    private static final Json DefaultJson = JsonKt.Json$default(null, new URLUtilsKt$$ExternalSyntheticLambda0(25), 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultJson$lambda$0(JsonBuilder jsonBuilder) {
        jsonBuilder.getClass();
        jsonBuilder.setEncodeDefaults(true);
        jsonBuilder.setLenient(true);
        jsonBuilder.setAllowSpecialFloatingPointValues(true);
        jsonBuilder.setAllowStructuredMapKeys(true);
        jsonBuilder.setPrettyPrint(false);
        jsonBuilder.setUseArrayPolymorphism(false);
        return Unit.INSTANCE;
    }

    public static final void json(Configuration configuration, Json json, ContentType contentType) {
        configuration.getClass();
        json.getClass();
        contentType.getClass();
        KotlinxSerializationConverterKt.serialization(configuration, contentType, json);
    }

    public static /* synthetic */ void json$default(Configuration configuration, Json json, ContentType contentType, int i, Object obj) {
        if ((i & 1) != 0) {
            json = DefaultJson;
        }
        if ((i & 2) != 0) {
            contentType = ContentType.Application.INSTANCE.getJson();
        }
        json(configuration, json, contentType);
    }
}
