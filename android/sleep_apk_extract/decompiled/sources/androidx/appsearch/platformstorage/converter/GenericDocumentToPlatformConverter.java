package androidx.appsearch.platformstorage.converter;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.appsearch.EmbeddingVector;
import android.app.appsearch.GenericDocument;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.platformstorage.util.AppSearchVersionUtil;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class GenericDocumentToPlatformConverter {

    public static class ApiHelperForB {
        public static void setJetpackPropertyEmbedding(GenericDocument.Builder<GenericDocument.Builder<?>> builder, String str, EmbeddingVector[] embeddingVectorArr) {
            androidx.appsearch.app.EmbeddingVector[] embeddingVectorArr2 = new androidx.appsearch.app.EmbeddingVector[embeddingVectorArr.length];
            for (int i = 0; i < embeddingVectorArr.length; i++) {
                embeddingVectorArr2[i] = new androidx.appsearch.app.EmbeddingVector(embeddingVectorArr[i].getValues(), embeddingVectorArr[i].getModelSignature());
            }
            builder.setPropertyEmbedding(str, embeddingVectorArr2);
        }

        public static void setPlatformPropertyEmbedding(GenericDocument.Builder<GenericDocument.Builder<?>> builder, String str, androidx.appsearch.app.EmbeddingVector[] embeddingVectorArr) {
            EmbeddingVector[] embeddingVectorArr2 = new EmbeddingVector[embeddingVectorArr.length];
            for (int i = 0; i < embeddingVectorArr.length; i++) {
                embeddingVectorArr2[i] = new EmbeddingVector(embeddingVectorArr[i].getValues(), embeddingVectorArr[i].getModelSignature());
            }
            builder.setPropertyEmbedding(str, embeddingVectorArr2);
        }
    }

    public static androidx.appsearch.app.GenericDocument toJetpackGenericDocument(android.app.appsearch.GenericDocument genericDocument) {
        Preconditions.checkNotNull(genericDocument);
        GenericDocument.Builder builder = new GenericDocument.Builder(genericDocument.getNamespace(), genericDocument.getId(), genericDocument.getSchemaType());
        builder.setScore(genericDocument.getScore()).setTtlMillis(genericDocument.getTtlMillis()).setCreationTimestampMillis(genericDocument.getCreationTimestampMillis());
        for (String str : genericDocument.getPropertyNames()) {
            Object property = genericDocument.getProperty(str);
            if (str.equals("$$__AppSearch__parentTypes")) {
                if (!(property instanceof String[])) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3(FileInsert$$ExternalSyntheticOutline0.m("Parents list must be of String[] type, but got ", property.getClass().toString()));
                    return null;
                }
                builder.setParentTypes(Arrays.asList((String[]) property));
            } else if (property instanceof String[]) {
                builder.setPropertyString(str, (String[]) property);
            } else if (property instanceof long[]) {
                builder.setPropertyLong(str, (long[]) property);
            } else if (property instanceof double[]) {
                builder.setPropertyDouble(str, (double[]) property);
            } else if (property instanceof boolean[]) {
                builder.setPropertyBoolean(str, (boolean[]) property);
            } else if (property instanceof byte[][]) {
                builder.setPropertyBytes(str, (byte[][]) property);
            } else if (property instanceof android.app.appsearch.GenericDocument[]) {
                android.app.appsearch.GenericDocument[] genericDocumentArr = (android.app.appsearch.GenericDocument[]) property;
                androidx.appsearch.app.GenericDocument[] genericDocumentArr2 = new androidx.appsearch.app.GenericDocument[genericDocumentArr.length];
                for (int i = 0; i < genericDocumentArr.length; i++) {
                    genericDocumentArr2[i] = toJetpackGenericDocument(genericDocumentArr[i]);
                }
                builder.setPropertyDocument(str, genericDocumentArr2);
            } else {
                if (!AppSearchVersionUtil.isAtLeastB() || !(property instanceof EmbeddingVector[])) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3(Fragment$$ExternalSyntheticOutline1.m("Property \"", str, "\" has unsupported value type ", property.getClass().toString()));
                    return null;
                }
                ApiHelperForB.setJetpackPropertyEmbedding(builder, str, (EmbeddingVector[]) property);
            }
        }
        return builder.build();
    }
}
