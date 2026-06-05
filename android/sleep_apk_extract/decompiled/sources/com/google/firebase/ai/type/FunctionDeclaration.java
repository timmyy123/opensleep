package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.Schema;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/google/firebase/ai/type/FunctionDeclaration;", "", "name", "", "description", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "", "Lcom/google/firebase/ai/type/Schema;", "optionalParameters", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getName$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/String;", "getDescription$com_google_firebase_ai_logic_firebase_ai", "getParameters$com_google_firebase_ai_logic_firebase_ai", "()Ljava/util/Map;", "getOptionalParameters$com_google_firebase_ai_logic_firebase_ai", "()Ljava/util/List;", "schema", "getSchema$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/Schema;", "toInternal", "Lcom/google/firebase/ai/type/FunctionDeclaration$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunctionDeclaration {
    private final String description;
    private final String name;
    private final List<String> optionalParameters;
    private final Map<String, Schema> parameters;
    private final Schema schema;

    public FunctionDeclaration(String str, String str2, Map<String, Schema> map, List<String> list) {
        str.getClass();
        str2.getClass();
        map.getClass();
        list.getClass();
        this.name = str;
        this.description = str2;
        this.parameters = map;
        this.optionalParameters = list;
        this.schema = Schema.Companion.obj$default(Schema.INSTANCE, map, list, null, false, null, 20, null);
    }

    /* JADX INFO: renamed from: getDescription$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: getName$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<String> getOptionalParameters$com_google_firebase_ai_logic_firebase_ai() {
        return this.optionalParameters;
    }

    public final Map<String, Schema> getParameters$com_google_firebase_ai_logic_firebase_ai() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: getSchema$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Schema getSchema() {
        return this.schema;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        return new Internal(this.name, this.description, this.schema.toInternalOpenApi$com_google_firebase_ai_logic_firebase_ai(), null, null);
    }

    public /* synthetic */ FunctionDeclaration(String str, String str2, Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 -2\u00020\u0001:\u0002,-B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\rHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006."}, d2 = {"Lcom/google/firebase/ai/type/FunctionDeclaration$Internal;", "", "name", "", "description", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "parametersJsonSchema", "Lcom/google/firebase/ai/type/Schema$InternalJson;", "responseJsonSchema", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;Lcom/google/firebase/ai/type/Schema$InternalJson;Lcom/google/firebase/ai/type/Schema$InternalJson;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;Lcom/google/firebase/ai/type/Schema$InternalJson;Lcom/google/firebase/ai/type/Schema$InternalJson;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getDescription", "getParameters", "()Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "getParametersJsonSchema", "()Lcom/google/firebase/ai/type/Schema$InternalJson;", "getResponseJsonSchema", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private static final KSerializer<Object>[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String description;
        private final String name;
        private final Schema.InternalOpenAPI parameters;
        private final Schema.InternalJson parametersJsonSchema;
        private final Schema.InternalJson responseJsonSchema;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FunctionDeclaration$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FunctionDeclaration$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return FunctionDeclaration$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Schema.InternalJson.class);
            KClass[] kClassArr = {Reflection.getOrCreateKotlinClass(Schema.InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(Schema.InternalJsonNullable.class)};
            Schema$InternalJsonNonNull$$serializer schema$InternalJsonNonNull$$serializer = Schema$InternalJsonNonNull$$serializer.INSTANCE;
            Schema$InternalJsonNullable$$serializer schema$InternalJsonNullable$$serializer = Schema$InternalJsonNullable$$serializer.INSTANCE;
            $childSerializers = new KSerializer[]{null, null, null, new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", orCreateKotlinClass, kClassArr, new KSerializer[]{schema$InternalJsonNonNull$$serializer, schema$InternalJsonNullable$$serializer}, new Annotation[0]), new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", Reflection.getOrCreateKotlinClass(Schema.InternalJson.class), new KClass[]{Reflection.getOrCreateKotlinClass(Schema.InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(Schema.InternalJsonNullable.class)}, new KSerializer[]{schema$InternalJsonNonNull$$serializer, schema$InternalJsonNullable$$serializer}, new Annotation[0])};
        }

        public /* synthetic */ Internal(int i, String str, String str2, Schema.InternalOpenAPI internalOpenAPI, Schema.InternalJson internalJson, Schema.InternalJson internalJson2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, FunctionDeclaration$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.name = str;
            this.description = str2;
            if ((i & 4) == 0) {
                this.parameters = null;
            } else {
                this.parameters = internalOpenAPI;
            }
            if ((i & 8) == 0) {
                this.parametersJsonSchema = null;
            } else {
                this.parametersJsonSchema = internalJson;
            }
            if ((i & 16) == 0) {
                this.responseJsonSchema = null;
            } else {
                this.responseJsonSchema = internalJson2;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, String str, String str2, Schema.InternalOpenAPI internalOpenAPI, Schema.InternalJson internalJson, Schema.InternalJson internalJson2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internal.name;
            }
            if ((i & 2) != 0) {
                str2 = internal.description;
            }
            if ((i & 4) != 0) {
                internalOpenAPI = internal.parameters;
            }
            if ((i & 8) != 0) {
                internalJson = internal.parametersJsonSchema;
            }
            if ((i & 16) != 0) {
                internalJson2 = internal.responseJsonSchema;
            }
            Schema.InternalJson internalJson3 = internalJson2;
            Schema.InternalOpenAPI internalOpenAPI2 = internalOpenAPI;
            return internal.copy(str, str2, internalOpenAPI2, internalJson, internalJson3);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.name);
            output.encodeStringElement(serialDesc, 1, self.description);
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.parameters != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, Schema$InternalOpenAPI$$serializer.INSTANCE, self.parameters);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.parametersJsonSchema != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.parametersJsonSchema);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.responseJsonSchema == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.responseJsonSchema);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Schema.InternalOpenAPI getParameters() {
            return this.parameters;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Schema.InternalJson getParametersJsonSchema() {
            return this.parametersJsonSchema;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Schema.InternalJson getResponseJsonSchema() {
            return this.responseJsonSchema;
        }

        public final Internal copy(String name, String description, Schema.InternalOpenAPI parameters, Schema.InternalJson parametersJsonSchema, Schema.InternalJson responseJsonSchema) {
            name.getClass();
            description.getClass();
            return new Internal(name, description, parameters, parametersJsonSchema, responseJsonSchema);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.name, internal.name) && Intrinsics.areEqual(this.description, internal.description) && Intrinsics.areEqual(this.parameters, internal.parameters) && Intrinsics.areEqual(this.parametersJsonSchema, internal.parametersJsonSchema) && Intrinsics.areEqual(this.responseJsonSchema, internal.responseJsonSchema);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getName() {
            return this.name;
        }

        public final Schema.InternalOpenAPI getParameters() {
            return this.parameters;
        }

        public final Schema.InternalJson getParametersJsonSchema() {
            return this.parametersJsonSchema;
        }

        public final Schema.InternalJson getResponseJsonSchema() {
            return this.responseJsonSchema;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.name.hashCode() * 31, 31, this.description);
            Schema.InternalOpenAPI internalOpenAPI = this.parameters;
            int iHashCode = (iM + (internalOpenAPI == null ? 0 : internalOpenAPI.hashCode())) * 31;
            Schema.InternalJson internalJson = this.parametersJsonSchema;
            int iHashCode2 = (iHashCode + (internalJson == null ? 0 : internalJson.hashCode())) * 31;
            Schema.InternalJson internalJson2 = this.responseJsonSchema;
            return iHashCode2 + (internalJson2 != null ? internalJson2.hashCode() : 0);
        }

        public String toString() {
            return "Internal(name=" + this.name + ", description=" + this.description + ", parameters=" + this.parameters + ", parametersJsonSchema=" + this.parametersJsonSchema + ", responseJsonSchema=" + this.responseJsonSchema + ')';
        }

        public Internal(String str, String str2, Schema.InternalOpenAPI internalOpenAPI, Schema.InternalJson internalJson, Schema.InternalJson internalJson2) {
            str.getClass();
            str2.getClass();
            this.name = str;
            this.description = str2;
            this.parameters = internalOpenAPI;
            this.parametersJsonSchema = internalJson;
            this.responseJsonSchema = internalJson2;
        }

        public /* synthetic */ Internal(String str, String str2, Schema.InternalOpenAPI internalOpenAPI, Schema.InternalJson internalJson, Schema.InternalJson internalJson2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : internalOpenAPI, (i & 8) != 0 ? null : internalJson, (i & 16) != 0 ? null : internalJson2);
        }
    }
}
