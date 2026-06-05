package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.internal.Utility;
import com.google.firebase.ai.type.Schema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.JsonObject;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001:Bå\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0018\u00010\f¢\u0006\u0004\b\u0019\u0010\u001aJ\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006J\r\u00107\u001a\u000208H\u0000¢\u0006\u0002\b9R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R#\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0017\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010.\u001a\u0004\b/\u0010-R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u001d\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%¨\u0006;"}, d2 = {"Lcom/google/firebase/ai/type/JsonSchema;", "T", "", "type", "", "clazz", "Lkotlin/reflect/KClass;", "description", "format", "nullable", "", "enum", "", "properties", "", "required", "items", "title", "minItems", "", "maxItems", "minimum", "", "maximum", "anyOf", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/JsonSchema;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getClazz", "()Lkotlin/reflect/KClass;", "getDescription", "getFormat", "getNullable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnum", "()Ljava/util/List;", "getProperties", "()Ljava/util/Map;", "getRequired", "getItems", "()Lcom/google/firebase/ai/type/JsonSchema;", "getTitle", "getMinItems", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxItems", "getMinimum", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaximum", "getAnyOf", "getSerializer", "Lkotlinx/serialization/KSerializer;", "toInternalJson", "Lcom/google/firebase/ai/type/Schema$InternalJson;", "toInternalJson$com_google_firebase_ai_logic_firebase_ai", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JsonSchema<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<JsonSchema<?>> anyOf;
    private final KClass<T> clazz;
    private final String description;
    private final List<String> enum;
    private final String format;
    private final JsonSchema<?> items;
    private final Integer maxItems;
    private final Double maximum;
    private final Integer minItems;
    private final Double minimum;
    private final Boolean nullable;
    private final Map<String, JsonSchema<?>> properties;
    private final List<String> required;
    private final String title;
    private final String type;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b\u000bJO\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012JO\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0012JO\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0012JO\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u0012J<\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0007JX\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050!2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0#2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0007Jp\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H$0\u0005\"\b\b\u0001\u0010$*\u00020\u00012\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050!2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0&2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0#2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0007Jk\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H$0#0\u0005\"\b\b\u0001\u0010$*\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H$0\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0002\u0010,J>\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0#2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0007JV\u0010-\u001a\b\u0012\u0004\u0012\u0002H$0\u0005\"\b\b\u0001\u0010$*\u00020\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0&2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0007J \u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0010\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#H\u0007¨\u00061"}, d2 = {"Lcom/google/firebase/ai/type/JsonSchema$Companion;", "", "<init>", "()V", "boolean", "Lcom/google/firebase/ai/type/JsonSchema;", "", "description", "", "nullable", "title", "bool", "integer", "Ljava/lang/Integer;", "minimum", "", "maximum", "numInt", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lcom/google/firebase/ai/type/JsonSchema;", "long", "", "numLong", "double", "numDouble", "float", "", "numFloat", "string", "format", "Lcom/google/firebase/ai/type/StringFormat;", "obj", "Lkotlinx/serialization/json/JsonObject;", "properties", "", "optionalProperties", "", "T", "clazz", "Lkotlin/reflect/KClass;", "array", "items", "minItems", "", "maxItems", "(Lcom/google/firebase/ai/type/JsonSchema;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/google/firebase/ai/type/JsonSchema;", "enumeration", "values", "anyOf", "schemas", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ JsonSchema array$default(Companion companion, JsonSchema jsonSchema, String str, boolean z, String str2, Integer num, Integer num2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            if ((i & 16) != 0) {
                num = null;
            }
            if ((i & 32) != 0) {
                num2 = null;
            }
            return companion.array(jsonSchema, str, z, str2, num, num2);
        }

        public static /* synthetic */ JsonSchema bool$default(Companion companion, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.bool(str, z, str2);
        }

        public static /* synthetic */ JsonSchema enumeration$default(Companion companion, List list, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return companion.enumeration((List<String>) list, str, z, str2);
        }

        public static /* synthetic */ JsonSchema numDouble$default(Companion companion, String str, boolean z, String str2, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                d = null;
            }
            if ((i & 16) != 0) {
                d2 = null;
            }
            return companion.numDouble(str, z, str2, d, d2);
        }

        public static /* synthetic */ JsonSchema numFloat$default(Companion companion, String str, boolean z, String str2, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                d = null;
            }
            if ((i & 16) != 0) {
                d2 = null;
            }
            return companion.numFloat(str, z, str2, d, d2);
        }

        public static /* synthetic */ JsonSchema numInt$default(Companion companion, String str, boolean z, String str2, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                d = null;
            }
            if ((i & 16) != 0) {
                d2 = null;
            }
            return companion.numInt(str, z, str2, d, d2);
        }

        public static /* synthetic */ JsonSchema numLong$default(Companion companion, String str, boolean z, String str2, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                d = null;
            }
            if ((i & 16) != 0) {
                d2 = null;
            }
            return companion.numLong(str, z, str2, d, d2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JsonSchema obj$default(Companion companion, Map map, KClass kClass, List list, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            List list2 = list;
            String str3 = (i & 8) != 0 ? null : str;
            if ((i & 16) != 0) {
                z = false;
            }
            return companion.obj(map, kClass, list2, str3, z, (i & 32) != 0 ? null : str2);
        }

        public static /* synthetic */ JsonSchema string$default(Companion companion, String str, boolean z, StringFormat stringFormat, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                stringFormat = null;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return companion.string(str, z, stringFormat, str2);
        }

        public final JsonSchema<String> anyOf(List<? extends JsonSchema<?>> schemas) {
            schemas.getClass();
            return new JsonSchema<>("ANYOF", Reflection.getOrCreateKotlinClass(String.class), null, null, null, null, null, null, null, null, null, null, null, null, schemas, 16380, null);
        }

        public final <T> JsonSchema<List<T>> array(JsonSchema<T> items, String description, boolean nullable, String title, Integer minItems, Integer maxItems) {
            items.getClass();
            return new JsonSchema<>("ARRAY", Reflection.getOrCreateKotlinClass(List.class), description, null, Boolean.valueOf(nullable), null, null, null, items, title, minItems, maxItems, null, null, null, 28904, null);
        }

        public final JsonSchema<Boolean> bool(String description, boolean nullable, String title) {
            return new JsonSchema<>("BOOLEAN", Reflection.getOrCreateKotlinClass(Boolean.TYPE), description, null, Boolean.valueOf(nullable), null, null, null, null, title, null, null, null, null, null, 32232, null);
        }

        public final JsonSchema<String> enumeration(List<String> values, String description, boolean nullable, String title) {
            values.getClass();
            return new JsonSchema<>("STRING", Reflection.getOrCreateKotlinClass(String.class), description, "enum", Boolean.valueOf(nullable), values, null, null, null, title, null, null, null, null, null, 32192, null);
        }

        public final JsonSchema<Double> numDouble(String description, boolean nullable, String title, Double minimum, Double maximum) {
            return new JsonSchema<>("NUMBER", Reflection.getOrCreateKotlinClass(Double.TYPE), description, null, Boolean.valueOf(nullable), null, null, null, null, title, null, null, minimum, maximum, null, 19944, null);
        }

        public final JsonSchema<Float> numFloat(String description, boolean nullable, String title, Double minimum, Double maximum) {
            return new JsonSchema<>("NUMBER", Reflection.getOrCreateKotlinClass(Float.TYPE), description, "float", Boolean.valueOf(nullable), null, null, null, null, title, null, null, minimum, maximum, null, 19936, null);
        }

        public final JsonSchema<Integer> numInt(String description, boolean nullable, String title, Double minimum, Double maximum) {
            return new JsonSchema<>("INTEGER", Reflection.getOrCreateKotlinClass(Integer.class), description, "int32", Boolean.valueOf(nullable), null, null, null, null, title, null, null, minimum, maximum, null, 19936, null);
        }

        public final JsonSchema<Long> numLong(String description, boolean nullable, String title, Double minimum, Double maximum) {
            return new JsonSchema<>("INTEGER", Reflection.getOrCreateKotlinClass(Long.TYPE), description, null, Boolean.valueOf(nullable), null, null, null, null, title, null, null, minimum, maximum, null, 19944, null);
        }

        public final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> properties, List<String> optionalProperties, String description, boolean nullable, String title) {
            properties.getClass();
            optionalProperties.getClass();
            if (!properties.keySet().containsAll(optionalProperties)) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("All optional properties must be present in properties. Missing: ", CollectionsKt___CollectionsKt.minus((Iterable) optionalProperties, (Iterable) properties.keySet()));
                return null;
            }
            return new JsonSchema<>("OBJECT", Reflection.getOrCreateKotlinClass(JsonObject.class), description, null, Boolean.valueOf(nullable), null, properties, CollectionsKt.toList(SetsKt___SetsKt.minus((Set) properties.keySet(), (Iterable) CollectionsKt.toSet(optionalProperties))), null, title, null, null, null, null, null, 32040, null);
        }

        public final JsonSchema<String> string(String description, boolean nullable, StringFormat format, String title) {
            return new JsonSchema<>("STRING", Reflection.getOrCreateKotlinClass(String.class), description, format != null ? format.getValue() : null, Boolean.valueOf(nullable), null, null, null, null, title, null, null, null, null, null, 32224, null);
        }

        private Companion() {
        }

        public static /* synthetic */ JsonSchema enumeration$default(Companion companion, List list, KClass kClass, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            if ((i & 16) != 0) {
                str2 = null;
            }
            return companion.enumeration(list, kClass, str, z, str2);
        }

        public final JsonSchema<Boolean> bool(String str) {
            return bool$default(this, str, false, null, 6, null);
        }

        public final JsonSchema<Boolean> bool(String str, boolean z) {
            return bool$default(this, str, z, null, 4, null);
        }

        public final JsonSchema<Boolean> bool() {
            return bool$default(this, null, false, null, 7, null);
        }

        public final JsonSchema<Double> numDouble(String str) {
            return numDouble$default(this, str, false, null, null, null, 30, null);
        }

        public final JsonSchema<Long> numLong(String str) {
            return numLong$default(this, str, false, null, null, null, 30, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JsonSchema obj$default(Companion companion, Map map, List list, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            List list2 = list;
            String str3 = (i & 4) != 0 ? null : str;
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.obj((Map<String, ? extends JsonSchema<?>>) map, (List<String>) list2, str3, z, (i & 16) != 0 ? null : str2);
        }

        public final JsonSchema<Double> numDouble(String str, boolean z) {
            return numDouble$default(this, str, z, null, null, null, 28, null);
        }

        public final JsonSchema<Float> numFloat(String str) {
            return numFloat$default(this, str, false, null, null, null, 30, null);
        }

        public final JsonSchema<Integer> numInt(String str) {
            return numInt$default(this, str, false, null, null, null, 30, null);
        }

        public final JsonSchema<Long> numLong(String str, boolean z) {
            return numLong$default(this, str, z, null, null, null, 28, null);
        }

        public final JsonSchema<Double> numDouble(String str, boolean z, String str2) {
            return numDouble$default(this, str, z, str2, null, null, 24, null);
        }

        public final JsonSchema<Float> numFloat(String str, boolean z) {
            return numFloat$default(this, str, z, null, null, null, 28, null);
        }

        public final JsonSchema<Integer> numInt(String str, boolean z) {
            return numInt$default(this, str, z, null, null, null, 28, null);
        }

        public final JsonSchema<Long> numLong(String str, boolean z, String str2) {
            return numLong$default(this, str, z, str2, null, null, 24, null);
        }

        public final JsonSchema<String> enumeration(List<String> list, String str) {
            list.getClass();
            return enumeration$default(this, list, str, false, null, 12, null);
        }

        public final JsonSchema<Double> numDouble(String str, boolean z, String str2, Double d) {
            return numDouble$default(this, str, z, str2, d, null, 16, null);
        }

        public final JsonSchema<Float> numFloat(String str, boolean z, String str2) {
            return numFloat$default(this, str, z, str2, null, null, 24, null);
        }

        public final JsonSchema<Integer> numInt(String str, boolean z, String str2) {
            return numInt$default(this, str, z, str2, null, null, 24, null);
        }

        public final JsonSchema<Long> numLong(String str, boolean z, String str2, Double d) {
            return numLong$default(this, str, z, str2, d, null, 16, null);
        }

        public final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str) {
            jsonSchema.getClass();
            return array$default(this, jsonSchema, str, false, null, null, null, 60, null);
        }

        public final JsonSchema<String> enumeration(List<String> list, String str, boolean z) {
            list.getClass();
            return enumeration$default(this, list, str, z, null, 8, null);
        }

        public final JsonSchema<Double> numDouble() {
            return numDouble$default(this, null, false, null, null, null, 31, null);
        }

        public final JsonSchema<Float> numFloat(String str, boolean z, String str2, Double d) {
            return numFloat$default(this, str, z, str2, d, null, 16, null);
        }

        public final JsonSchema<Integer> numInt(String str, boolean z, String str2, Double d) {
            return numInt$default(this, str, z, str2, d, null, 16, null);
        }

        public final JsonSchema<Long> numLong() {
            return numLong$default(this, null, false, null, null, null, 31, null);
        }

        public final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str, boolean z) {
            jsonSchema.getClass();
            return array$default(this, jsonSchema, str, z, null, null, null, 56, null);
        }

        public final <T> JsonSchema<T> enumeration(List<String> list, KClass<T> kClass) {
            list.getClass();
            kClass.getClass();
            return enumeration$default(this, list, kClass, null, false, null, 28, null);
        }

        public final JsonSchema<Float> numFloat() {
            return numFloat$default(this, null, false, null, null, null, 31, null);
        }

        public final JsonSchema<Integer> numInt() {
            return numInt$default(this, null, false, null, null, null, 31, null);
        }

        public final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str, boolean z, String str2) {
            jsonSchema.getClass();
            return array$default(this, jsonSchema, str, z, str2, null, null, 48, null);
        }

        public final <T> JsonSchema<T> enumeration(List<String> list, KClass<T> kClass, String str) {
            list.getClass();
            kClass.getClass();
            return enumeration$default(this, list, kClass, str, false, null, 24, null);
        }

        public final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str, boolean z, String str2, Integer num) {
            jsonSchema.getClass();
            return array$default(this, jsonSchema, str, z, str2, num, null, 32, null);
        }

        public final <T> JsonSchema<T> enumeration(List<String> list, KClass<T> kClass, String str, boolean z) {
            list.getClass();
            kClass.getClass();
            return enumeration$default(this, list, kClass, str, z, null, 16, null);
        }

        public final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema) {
            jsonSchema.getClass();
            return array$default(this, jsonSchema, null, false, null, null, null, 62, null);
        }

        public final JsonSchema<String> enumeration(List<String> list) {
            list.getClass();
            return enumeration$default(this, list, null, false, null, 14, null);
        }

        public final JsonSchema<String> string(String str) {
            return string$default(this, str, false, null, null, 14, null);
        }

        public final <T> JsonSchema<T> enumeration(List<String> values, KClass<T> clazz, String description, boolean nullable, String title) {
            values.getClass();
            clazz.getClass();
            return new JsonSchema<>("STRING", clazz, description, "enum", Boolean.valueOf(nullable), values, null, null, null, title, null, null, null, null, null, 32192, null);
        }

        public final JsonSchema<String> string(String str, boolean z) {
            return string$default(this, str, z, null, null, 12, null);
        }

        public final JsonSchema<String> string(String str, boolean z, StringFormat stringFormat) {
            return string$default(this, str, z, stringFormat, null, 8, null);
        }

        public final JsonSchema<String> string() {
            return string$default(this, null, false, null, null, 15, null);
        }

        public final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map, List<String> list) {
            map.getClass();
            list.getClass();
            return obj$default(this, map, list, null, false, null, 28, null);
        }

        public final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map, List<String> list, String str) {
            map.getClass();
            list.getClass();
            return obj$default(this, map, list, str, false, null, 24, null);
        }

        public final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map, List<String> list, String str, boolean z) {
            map.getClass();
            list.getClass();
            return obj$default(this, map, list, str, z, null, 16, null);
        }

        public final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass) {
            map.getClass();
            kClass.getClass();
            return obj$default(this, map, kClass, null, null, false, null, 60, null);
        }

        public final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass, List<String> list) {
            map.getClass();
            kClass.getClass();
            list.getClass();
            return obj$default(this, map, kClass, list, null, false, null, 56, null);
        }

        public final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass, List<String> list, String str) {
            map.getClass();
            kClass.getClass();
            list.getClass();
            return obj$default(this, map, kClass, list, str, false, null, 48, null);
        }

        public final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass, List<String> list, String str, boolean z) {
            map.getClass();
            kClass.getClass();
            list.getClass();
            return obj$default(this, map, kClass, list, str, z, null, 32, null);
        }

        public final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map) {
            map.getClass();
            return obj$default(this, map, null, null, false, null, 30, null);
        }

        public final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> properties, KClass<T> clazz, List<String> optionalProperties, String description, boolean nullable, String title) {
            properties.getClass();
            clazz.getClass();
            optionalProperties.getClass();
            if (properties.keySet().containsAll(optionalProperties)) {
                return new JsonSchema<>("OBJECT", clazz, description, null, Boolean.valueOf(nullable), null, properties, CollectionsKt.toList(SetsKt___SetsKt.minus((Set) properties.keySet(), (Iterable) CollectionsKt.toSet(optionalProperties))), null, title, null, null, null, null, null, 32040, null);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("All optional properties must be present in properties. Missing: ", CollectionsKt___CollectionsKt.minus((Iterable) optionalProperties, (Iterable) properties.keySet()));
            return null;
        }
    }

    public /* synthetic */ JsonSchema(String str, KClass kClass, String str2, String str3, Boolean bool, List list, Map map, List list2, JsonSchema jsonSchema, String str4, Integer num, Integer num2, Double d, Double d2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, kClass, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : map, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : jsonSchema, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : num, (i & 2048) != 0 ? null : num2, (i & 4096) != 0 ? null : d, (i & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : d2, (i & 16384) != 0 ? null : list3);
    }

    public static final JsonSchema<String> anyOf(List<? extends JsonSchema<?>> list) {
        return INSTANCE.anyOf(list);
    }

    public static final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str, boolean z, String str2, Integer num, Integer num2) {
        return INSTANCE.array(jsonSchema, str, z, str2, num, num2);
    }

    public static final JsonSchema<Boolean> bool() {
        return INSTANCE.bool();
    }

    public static final <T> JsonSchema<T> enumeration(List<String> list, KClass<T> kClass, String str, boolean z, String str2) {
        return INSTANCE.enumeration(list, kClass, str, z, str2);
    }

    public static final JsonSchema<Double> numDouble(String str, boolean z, String str2, Double d, Double d2) {
        return INSTANCE.numDouble(str, z, str2, d, d2);
    }

    public static final JsonSchema<Float> numFloat(String str, boolean z, String str2, Double d, Double d2) {
        return INSTANCE.numFloat(str, z, str2, d, d2);
    }

    public static final JsonSchema<Integer> numInt(String str, boolean z, String str2, Double d, Double d2) {
        return INSTANCE.numInt(str, z, str2, d, d2);
    }

    public static final JsonSchema<Long> numLong(String str, boolean z, String str2, Double d, Double d2) {
        return INSTANCE.numLong(str, z, str2, d, d2);
    }

    public static final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass, List<String> list, String str, boolean z, String str2) {
        return INSTANCE.obj(map, kClass, list, str, z, str2);
    }

    public static final JsonSchema<String> string() {
        return INSTANCE.string();
    }

    public final List<JsonSchema<?>> getAnyOf() {
        return this.anyOf;
    }

    public final KClass<T> getClazz() {
        return this.clazz;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getEnum() {
        return this.enum;
    }

    public final String getFormat() {
        return this.format;
    }

    public final JsonSchema<?> getItems() {
        return this.items;
    }

    public final Integer getMaxItems() {
        return this.maxItems;
    }

    public final Double getMaximum() {
        return this.maximum;
    }

    public final Integer getMinItems() {
        return this.minItems;
    }

    public final Double getMinimum() {
        return this.minimum;
    }

    public final Boolean getNullable() {
        return this.nullable;
    }

    public final Map<String, JsonSchema<?>> getProperties() {
        return this.properties;
    }

    public final List<String> getRequired() {
        return this.required;
    }

    public final KSerializer<T> getSerializer() {
        KSerializer<T> kSerializerListSerializer;
        KSerializer kSerializerSerializerOrNull;
        if (StringsKt__StringsJVMKt.equals$default(this.clazz.getSimpleName(), "List", false, 2, null)) {
            JsonSchema<?> jsonSchema = this.items;
            KClass<?> kClass = jsonSchema != null ? jsonSchema.clazz : null;
            if (kClass == null || (kSerializerSerializerOrNull = SerializersKt.serializerOrNull(kClass)) == null) {
                throw new RuntimeException(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Object type "), kClass != null ? kClass.getQualifiedName() : null, " is not @Serializable"));
            }
            kSerializerListSerializer = BuiltinSerializersKt.ListSerializer(kSerializerSerializerOrNull);
        } else {
            KSerializer<T> kSerializerSerializerOrNull2 = SerializersKt.serializerOrNull(this.clazz);
            if (kSerializerSerializerOrNull2 == null) {
                throw new RuntimeException("Object type " + this.clazz.getQualifiedName() + " is not @Serializable");
            }
            kSerializerListSerializer = kSerializerSerializerOrNull2;
        }
        kSerializerListSerializer.getClass();
        return kSerializerListSerializer;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final Schema.InternalJson toInternalJson$com_google_firebase_ai_logic_firebase_ai() {
        String str;
        Pair pair;
        LinkedHashMap linkedHashMap;
        List listBuild;
        LinkedHashMap linkedHashMap2;
        ArrayList arrayList = null;
        if (Intrinsics.areEqual(this.type, "ANYOF") || (Intrinsics.areEqual(this.type, "STRING") && Intrinsics.areEqual(this.format, "enum"))) {
            str = null;
        } else {
            String lowerCase = this.type.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            str = lowerCase;
        }
        if (Intrinsics.areEqual(str, "integer") && Intrinsics.areEqual(this.format, "int32")) {
            Double d = this.minimum;
            Double dValueOf = Double.valueOf(d != null ? d.doubleValue() : -2.147483648E9d);
            Double d2 = this.maximum;
            pair = TuplesKt.to(dValueOf, Double.valueOf(d2 != null ? d2.doubleValue() : 2.147483647E9d));
        } else {
            pair = TuplesKt.to(this.minimum, this.maximum);
        }
        Double d3 = (Double) pair.component1();
        Double d4 = (Double) pair.component2();
        String str2 = ((Intrinsics.areEqual(str, "integer") && Intrinsics.areEqual(this.format, "int32")) || (Intrinsics.areEqual(str, "number") && Intrinsics.areEqual(this.format, "float")) || Intrinsics.areEqual(this.format, "enum")) ? null : this.format;
        if (!Intrinsics.areEqual(this.nullable, Boolean.TRUE)) {
            String str3 = this.description;
            List<String> list = this.enum;
            Map<String, JsonSchema<?>> map = this.properties;
            if (map != null) {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                Iterator<T> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap3.put(entry.getKey(), ((JsonSchema) entry.getValue()).toInternalJson$com_google_firebase_ai_logic_firebase_ai());
                }
                linkedHashMap = linkedHashMap3;
            } else {
                linkedHashMap = null;
            }
            List<String> list2 = this.required;
            JsonSchema<?> jsonSchema = this.items;
            Schema.InternalJson internalJson$com_google_firebase_ai_logic_firebase_ai = jsonSchema != null ? jsonSchema.toInternalJson$com_google_firebase_ai_logic_firebase_ai() : null;
            String str4 = this.title;
            Integer num = this.minItems;
            Integer num2 = this.maxItems;
            List<JsonSchema<?>> list3 = this.anyOf;
            if (list3 != null) {
                List<JsonSchema<?>> list4 = list3;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                Iterator<T> it2 = list4.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((JsonSchema) it2.next()).toInternalJson$com_google_firebase_ai_logic_firebase_ai());
                }
            }
            return new Schema.InternalJsonNonNull(str, str3, str2, list, linkedHashMap, list2, internalJson$com_google_firebase_ai_logic_firebase_ai, str4, num, num2, d3, d4, arrayList);
        }
        List listListOf = str != null ? CollectionsKt.listOf((Object[]) new String[]{str, "null"}) : null;
        String str5 = this.description;
        List<String> list5 = this.enum;
        if (list5 != null) {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.addAll(list5);
            listCreateListBuilder.add("null");
            listBuild = CollectionsKt.build(listCreateListBuilder);
        } else {
            listBuild = null;
        }
        Map<String, JsonSchema<?>> map2 = this.properties;
        if (map2 != null) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
            Iterator<T> it3 = map2.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it3.next();
                linkedHashMap4.put(entry2.getKey(), ((JsonSchema) entry2.getValue()).toInternalJson$com_google_firebase_ai_logic_firebase_ai());
            }
            linkedHashMap2 = linkedHashMap4;
        } else {
            linkedHashMap2 = null;
        }
        List<String> list6 = this.required;
        JsonSchema<?> jsonSchema2 = this.items;
        Schema.InternalJson internalJson$com_google_firebase_ai_logic_firebase_ai2 = jsonSchema2 != null ? jsonSchema2.toInternalJson$com_google_firebase_ai_logic_firebase_ai() : null;
        String str6 = this.title;
        Integer num3 = this.minItems;
        Integer num4 = this.maxItems;
        List<JsonSchema<?>> list7 = this.anyOf;
        if (list7 != null) {
            List<JsonSchema<?>> list8 = list7;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
            Iterator<T> it4 = list8.iterator();
            while (it4.hasNext()) {
                arrayList.add(((JsonSchema) it4.next()).toInternalJson$com_google_firebase_ai_logic_firebase_ai());
            }
        }
        return new Schema.InternalJsonNullable(listListOf, str5, str2, listBuild, linkedHashMap2, list6, internalJson$com_google_firebase_ai_logic_firebase_ai2, str6, num3, num4, d3, d4, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonSchema(String str, KClass<T> kClass, String str2, String str3, Boolean bool, List<String> list, Map<String, ? extends JsonSchema<?>> map, List<String> list2, JsonSchema<?> jsonSchema, String str4, Integer num, Integer num2, Double d, Double d2, List<? extends JsonSchema<?>> list3) {
        str.getClass();
        kClass.getClass();
        this.type = str;
        this.clazz = kClass;
        this.description = str2;
        this.format = str3;
        this.nullable = bool;
        this.enum = list;
        this.properties = map;
        this.required = list2;
        this.items = jsonSchema;
        this.title = str4;
        this.minItems = num;
        this.maxItems = num2;
        this.minimum = d;
        this.maximum = d2;
        this.anyOf = list3;
    }

    public static final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str) {
        return INSTANCE.array(jsonSchema, str);
    }

    public static final JsonSchema<Boolean> bool(String str) {
        return INSTANCE.bool(str);
    }

    public static final JsonSchema<String> enumeration(List<String> list, String str) {
        return INSTANCE.enumeration(list, str);
    }

    public static final JsonSchema<Double> numDouble(String str) {
        return INSTANCE.numDouble(str);
    }

    public static final JsonSchema<Float> numFloat(String str) {
        return INSTANCE.numFloat(str);
    }

    public static final JsonSchema<Integer> numInt(String str) {
        return INSTANCE.numInt(str);
    }

    public static final JsonSchema<Long> numLong(String str) {
        return INSTANCE.numLong(str);
    }

    public static final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map, List<String> list) {
        return INSTANCE.obj(map, list);
    }

    public static final JsonSchema<String> string(String str) {
        return INSTANCE.string(str);
    }

    public static final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str, boolean z) {
        return INSTANCE.array(jsonSchema, str, z);
    }

    public static final JsonSchema<Boolean> bool(String str, boolean z) {
        return INSTANCE.bool(str, z);
    }

    public static final JsonSchema<String> enumeration(List<String> list, String str, boolean z) {
        return INSTANCE.enumeration(list, str, z);
    }

    public static final JsonSchema<Double> numDouble(String str, boolean z) {
        return INSTANCE.numDouble(str, z);
    }

    public static final JsonSchema<Float> numFloat(String str, boolean z) {
        return INSTANCE.numFloat(str, z);
    }

    public static final JsonSchema<Integer> numInt(String str, boolean z) {
        return INSTANCE.numInt(str, z);
    }

    public static final JsonSchema<Long> numLong(String str, boolean z) {
        return INSTANCE.numLong(str, z);
    }

    public static final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map, List<String> list, String str) {
        return INSTANCE.obj(map, list, str);
    }

    public static final JsonSchema<String> string(String str, boolean z) {
        return INSTANCE.string(str, z);
    }

    public static final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str, boolean z, String str2) {
        return INSTANCE.array(jsonSchema, str, z, str2);
    }

    public static final JsonSchema<Boolean> bool(String str, boolean z, String str2) {
        return INSTANCE.bool(str, z, str2);
    }

    public static final JsonSchema<String> enumeration(List<String> list, String str, boolean z, String str2) {
        return INSTANCE.enumeration(list, str, z, str2);
    }

    public static final JsonSchema<Double> numDouble(String str, boolean z, String str2) {
        return INSTANCE.numDouble(str, z, str2);
    }

    public static final JsonSchema<Float> numFloat(String str, boolean z, String str2) {
        return INSTANCE.numFloat(str, z, str2);
    }

    public static final JsonSchema<Integer> numInt(String str, boolean z, String str2) {
        return INSTANCE.numInt(str, z, str2);
    }

    public static final JsonSchema<Long> numLong(String str, boolean z, String str2) {
        return INSTANCE.numLong(str, z, str2);
    }

    public static final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map, List<String> list, String str, boolean z) {
        return INSTANCE.obj(map, list, str, z);
    }

    public static final JsonSchema<String> string(String str, boolean z, StringFormat stringFormat) {
        return INSTANCE.string(str, z, stringFormat);
    }

    public static final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema, String str, boolean z, String str2, Integer num) {
        return INSTANCE.array(jsonSchema, str, z, str2, num);
    }

    public static final <T> JsonSchema<T> enumeration(List<String> list, KClass<T> kClass) {
        return INSTANCE.enumeration(list, kClass);
    }

    public static final JsonSchema<Double> numDouble(String str, boolean z, String str2, Double d) {
        return INSTANCE.numDouble(str, z, str2, d);
    }

    public static final JsonSchema<Float> numFloat(String str, boolean z, String str2, Double d) {
        return INSTANCE.numFloat(str, z, str2, d);
    }

    public static final JsonSchema<Integer> numInt(String str, boolean z, String str2, Double d) {
        return INSTANCE.numInt(str, z, str2, d);
    }

    public static final JsonSchema<Long> numLong(String str, boolean z, String str2, Double d) {
        return INSTANCE.numLong(str, z, str2, d);
    }

    public static final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map, List<String> list, String str, boolean z, String str2) {
        return INSTANCE.obj(map, list, str, z, str2);
    }

    public static final JsonSchema<String> string(String str, boolean z, StringFormat stringFormat, String str2) {
        return INSTANCE.string(str, z, stringFormat, str2);
    }

    public static final <T> JsonSchema<List<T>> array(JsonSchema<T> jsonSchema) {
        return INSTANCE.array(jsonSchema);
    }

    public static final <T> JsonSchema<T> enumeration(List<String> list, KClass<T> kClass, String str) {
        return INSTANCE.enumeration(list, kClass, str);
    }

    public static final JsonSchema<Double> numDouble() {
        return INSTANCE.numDouble();
    }

    public static final JsonSchema<Float> numFloat() {
        return INSTANCE.numFloat();
    }

    public static final JsonSchema<Integer> numInt() {
        return INSTANCE.numInt();
    }

    public static final JsonSchema<Long> numLong() {
        return INSTANCE.numLong();
    }

    public static final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass) {
        return INSTANCE.obj(map, kClass);
    }

    public static final <T> JsonSchema<T> enumeration(List<String> list, KClass<T> kClass, String str, boolean z) {
        return INSTANCE.enumeration(list, kClass, str, z);
    }

    public static final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass, List<String> list) {
        return INSTANCE.obj(map, kClass, list);
    }

    public static final JsonSchema<String> enumeration(List<String> list) {
        return INSTANCE.enumeration(list);
    }

    public static final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass, List<String> list, String str) {
        return INSTANCE.obj(map, kClass, list, str);
    }

    public static final <T> JsonSchema<T> obj(Map<String, ? extends JsonSchema<?>> map, KClass<T> kClass, List<String> list, String str, boolean z) {
        return INSTANCE.obj(map, kClass, list, str, z);
    }

    public static final JsonSchema<JsonObject> obj(Map<String, ? extends JsonSchema<?>> map) {
        return INSTANCE.obj(map);
    }
}
