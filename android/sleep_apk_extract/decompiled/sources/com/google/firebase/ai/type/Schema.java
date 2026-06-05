package com.google.firebase.ai.type;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.Utility;
import java.lang.annotation.Annotation;
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
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00056789:BË\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017J\r\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2J\r\u00103\u001a\u000204H\u0000¢\u0006\u0002\b5R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010-\u001a\u0004\b.\u0010,R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 ¨\u0006;"}, d2 = {"Lcom/google/firebase/ai/type/Schema;", "", "type", "", "description", "format", "nullable", "", "enum", "", "properties", "", "required", "items", "title", "minItems", "", "maxItems", "minimum", "", "maximum", "anyOf", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getDescription", "getFormat", "getNullable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnum", "()Ljava/util/List;", "getProperties", "()Ljava/util/Map;", "getRequired", "getItems", "()Lcom/google/firebase/ai/type/Schema;", "getTitle", "getMinItems", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxItems", "getMinimum", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaximum", "getAnyOf", "toInternalOpenApi", "Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "toInternalOpenApi$com_google_firebase_ai_logic_firebase_ai", "toInternalJson", "Lcom/google/firebase/ai/type/Schema$InternalJson;", "toInternalJson$com_google_firebase_ai_logic_firebase_ai", "Companion", "InternalOpenAPI", "InternalJson", "InternalJsonNonNull", "InternalJsonNullable", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Schema {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Schema> anyOf;
    private final String description;
    private final List<String> enum;
    private final String format;
    private final Schema items;
    private final Integer maxItems;
    private final Double maximum;
    private final Integer minItems;
    private final Double minimum;
    private final Boolean nullable;
    private final Map<String, Schema> properties;
    private final List<String> required;
    private final String title;
    private final String type;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007JI\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0010JI\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0014\u0010\u0010JI\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0016\u0010\u0010J;\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\b\u001aJN\u0010\u001b\u001a\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007JO\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0002\u0010%J8\u0010&\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\u0016\u0010(\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0007¨\u0006*"}, d2 = {"Lcom/google/firebase/ai/type/Schema$Companion;", "", "<init>", "()V", "boolean", "Lcom/google/firebase/ai/type/Schema;", "description", "", "nullable", "", "title", "integer", "minimum", "", "maximum", "numInt", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lcom/google/firebase/ai/type/Schema;", "long", "numLong", "double", "numDouble", "float", "numFloat", "string", "format", "Lcom/google/firebase/ai/type/StringFormat;", "str", "obj", "properties", "", "optionalProperties", "", "array", "items", "minItems", "", "maxItems", "(Lcom/google/firebase/ai/type/Schema;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/google/firebase/ai/type/Schema;", "enumeration", "values", "anyOf", "schemas", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Schema array$default(Companion companion, Schema schema, String str, boolean z, String str2, Integer num, Integer num2, int i, Object obj) {
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
            return companion.array(schema, str, z, str2, num, num2);
        }

        public static /* synthetic */ Schema boolean$default(Companion companion, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.m413boolean(str, z, str2);
        }

        public static /* synthetic */ Schema enumeration$default(Companion companion, List list, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return companion.enumeration(list, str, z, str2);
        }

        public static /* synthetic */ Schema numDouble$default(Companion companion, String str, boolean z, String str2, Double d, Double d2, int i, Object obj) {
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

        public static /* synthetic */ Schema numFloat$default(Companion companion, String str, boolean z, String str2, Double d, Double d2, int i, Object obj) {
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

        public static /* synthetic */ Schema numInt$default(Companion companion, String str, boolean z, String str2, Double d, Double d2, int i, Object obj) {
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

        public static /* synthetic */ Schema numLong$default(Companion companion, String str, boolean z, String str2, Double d, Double d2, int i, Object obj) {
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
        public static /* synthetic */ Schema obj$default(Companion companion, Map map, List list, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            List list2 = list;
            String str3 = (i & 4) != 0 ? null : str;
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.obj(map, list2, str3, z, (i & 16) != 0 ? null : str2);
        }

        public static /* synthetic */ Schema str$default(Companion companion, String str, boolean z, StringFormat stringFormat, String str2, int i, Object obj) {
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
            return companion.str(str, z, stringFormat, str2);
        }

        public final Schema anyOf(List<Schema> schemas) {
            schemas.getClass();
            return new Schema("ANYOF", null, null, null, null, null, null, null, null, null, null, null, null, schemas, 8190, null);
        }

        public final Schema array(Schema items, String description, boolean nullable, String title, Integer minItems, Integer maxItems) {
            items.getClass();
            return new Schema("ARRAY", description, null, Boolean.valueOf(nullable), null, null, null, items, title, minItems, maxItems, null, null, null, 14452, null);
        }

        /* JADX INFO: renamed from: boolean, reason: not valid java name */
        public final Schema m413boolean(String description, boolean nullable, String title) {
            return new Schema("BOOLEAN", description, null, Boolean.valueOf(nullable), null, null, null, null, title, null, null, null, null, null, 16116, null);
        }

        public final Schema enumeration(List<String> values, String description, boolean nullable, String title) {
            values.getClass();
            return new Schema("STRING", description, "enum", Boolean.valueOf(nullable), values, null, null, null, title, null, null, null, null, null, 16096, null);
        }

        public final Schema numDouble(String description, boolean nullable, String title, Double minimum, Double maximum) {
            return new Schema("NUMBER", description, null, Boolean.valueOf(nullable), null, null, null, null, title, null, null, minimum, maximum, null, 9972, null);
        }

        public final Schema numFloat(String description, boolean nullable, String title, Double minimum, Double maximum) {
            return new Schema("NUMBER", description, "float", Boolean.valueOf(nullable), null, null, null, null, title, null, null, minimum, maximum, null, 9968, null);
        }

        public final Schema numInt(String description, boolean nullable, String title, Double minimum, Double maximum) {
            return new Schema("INTEGER", description, "int32", Boolean.valueOf(nullable), null, null, null, null, title, null, null, minimum, maximum, null, 9968, null);
        }

        public final Schema numLong(String description, boolean nullable, String title, Double minimum, Double maximum) {
            return new Schema("INTEGER", description, null, Boolean.valueOf(nullable), null, null, null, null, title, null, null, minimum, maximum, null, 9972, null);
        }

        public final Schema obj(Map<String, Schema> properties, List<String> optionalProperties, String description, boolean nullable, String title) {
            properties.getClass();
            optionalProperties.getClass();
            if (!properties.keySet().containsAll(optionalProperties)) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("All optional properties must be present in properties. Missing: ", CollectionsKt___CollectionsKt.minus((Iterable) optionalProperties, (Iterable) properties.keySet()));
                return null;
            }
            return new Schema("OBJECT", description, null, Boolean.valueOf(nullable), null, properties, CollectionsKt.toList(SetsKt___SetsKt.minus((Set) properties.keySet(), (Iterable) CollectionsKt.toSet(optionalProperties))), null, title, null, null, null, null, null, 16020, null);
        }

        public final Schema str(String description, boolean nullable, StringFormat format, String title) {
            return new Schema("STRING", description, format != null ? format.getValue() : null, Boolean.valueOf(nullable), null, null, null, null, title, null, null, null, null, null, 16112, null);
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: boolean, reason: not valid java name */
        public final Schema m411boolean(String str) {
            return boolean$default(this, str, false, null, 6, null);
        }

        /* JADX INFO: renamed from: boolean, reason: not valid java name */
        public final Schema m412boolean(String str, boolean z) {
            return boolean$default(this, str, z, null, 4, null);
        }

        /* JADX INFO: renamed from: boolean, reason: not valid java name */
        public final Schema m410boolean() {
            return boolean$default(this, null, false, null, 7, null);
        }

        public final Schema numDouble(String str) {
            return numDouble$default(this, str, false, null, null, null, 30, null);
        }

        public final Schema numLong(String str) {
            return numLong$default(this, str, false, null, null, null, 30, null);
        }

        public final Schema numDouble(String str, boolean z) {
            return numDouble$default(this, str, z, null, null, null, 28, null);
        }

        public final Schema numFloat(String str) {
            return numFloat$default(this, str, false, null, null, null, 30, null);
        }

        public final Schema numInt(String str) {
            return numInt$default(this, str, false, null, null, null, 30, null);
        }

        public final Schema numLong(String str, boolean z) {
            return numLong$default(this, str, z, null, null, null, 28, null);
        }

        public final Schema numDouble(String str, boolean z, String str2) {
            return numDouble$default(this, str, z, str2, null, null, 24, null);
        }

        public final Schema numFloat(String str, boolean z) {
            return numFloat$default(this, str, z, null, null, null, 28, null);
        }

        public final Schema numInt(String str, boolean z) {
            return numInt$default(this, str, z, null, null, null, 28, null);
        }

        public final Schema numLong(String str, boolean z, String str2) {
            return numLong$default(this, str, z, str2, null, null, 24, null);
        }

        public final Schema enumeration(List<String> list, String str) {
            list.getClass();
            return enumeration$default(this, list, str, false, null, 12, null);
        }

        public final Schema numDouble(String str, boolean z, String str2, Double d) {
            return numDouble$default(this, str, z, str2, d, null, 16, null);
        }

        public final Schema numFloat(String str, boolean z, String str2) {
            return numFloat$default(this, str, z, str2, null, null, 24, null);
        }

        public final Schema numInt(String str, boolean z, String str2) {
            return numInt$default(this, str, z, str2, null, null, 24, null);
        }

        public final Schema numLong(String str, boolean z, String str2, Double d) {
            return numLong$default(this, str, z, str2, d, null, 16, null);
        }

        public final Schema array(Schema schema, String str) {
            schema.getClass();
            return array$default(this, schema, str, false, null, null, null, 60, null);
        }

        public final Schema enumeration(List<String> list, String str, boolean z) {
            list.getClass();
            return enumeration$default(this, list, str, z, null, 8, null);
        }

        public final Schema numDouble() {
            return numDouble$default(this, null, false, null, null, null, 31, null);
        }

        public final Schema numFloat(String str, boolean z, String str2, Double d) {
            return numFloat$default(this, str, z, str2, d, null, 16, null);
        }

        public final Schema numInt(String str, boolean z, String str2, Double d) {
            return numInt$default(this, str, z, str2, d, null, 16, null);
        }

        public final Schema numLong() {
            return numLong$default(this, null, false, null, null, null, 31, null);
        }

        public final Schema array(Schema schema, String str, boolean z) {
            schema.getClass();
            return array$default(this, schema, str, z, null, null, null, 56, null);
        }

        public final Schema enumeration(List<String> list) {
            list.getClass();
            return enumeration$default(this, list, null, false, null, 14, null);
        }

        public final Schema numFloat() {
            return numFloat$default(this, null, false, null, null, null, 31, null);
        }

        public final Schema numInt() {
            return numInt$default(this, null, false, null, null, null, 31, null);
        }

        public final Schema array(Schema schema, String str, boolean z, String str2) {
            schema.getClass();
            return array$default(this, schema, str, z, str2, null, null, 48, null);
        }

        public final Schema array(Schema schema, String str, boolean z, String str2, Integer num) {
            schema.getClass();
            return array$default(this, schema, str, z, str2, num, null, 32, null);
        }

        public final Schema str(String str) {
            return str$default(this, str, false, null, null, 14, null);
        }

        public final Schema array(Schema schema) {
            schema.getClass();
            return array$default(this, schema, null, false, null, null, null, 62, null);
        }

        public final Schema str(String str, boolean z) {
            return str$default(this, str, z, null, null, 12, null);
        }

        public final Schema str(String str, boolean z, StringFormat stringFormat) {
            return str$default(this, str, z, stringFormat, null, 8, null);
        }

        public final Schema str() {
            return str$default(this, null, false, null, null, 15, null);
        }

        public final Schema obj(Map<String, Schema> map, List<String> list) {
            map.getClass();
            list.getClass();
            return obj$default(this, map, list, null, false, null, 28, null);
        }

        public final Schema obj(Map<String, Schema> map, List<String> list, String str) {
            map.getClass();
            list.getClass();
            return obj$default(this, map, list, str, false, null, 24, null);
        }

        public final Schema obj(Map<String, Schema> map, List<String> list, String str, boolean z) {
            map.getClass();
            list.getClass();
            return obj$default(this, map, list, str, z, null, 16, null);
        }

        public final Schema obj(Map<String, Schema> map) {
            map.getClass();
            return obj$default(this, map, null, null, false, null, 30, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/ai/type/Schema$InternalJson;", "", "Companion", "Lcom/google/firebase/ai/type/Schema$InternalJsonNonNull;", "Lcom/google/firebase/ai/type/Schema$InternalJsonNullable;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public interface InternalJson {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Schema$InternalJson$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Schema$InternalJson;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<InternalJson> serializer() {
                return new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", Reflection.getOrCreateKotlinClass(InternalJson.class), new KClass[]{Reflection.getOrCreateKotlinClass(InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(InternalJsonNullable.class)}, new KSerializer[]{Schema$InternalJsonNonNull$$serializer.INSTANCE, Schema$InternalJsonNullable$$serializer.INSTANCE}, new Annotation[0]);
            }
        }
    }

    public /* synthetic */ Schema(String str, String str2, String str3, Boolean bool, List list, Map map, List list2, Schema schema, String str4, Integer num, Integer num2, Double d, Double d2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : map, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : schema, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : num, (i & 1024) != 0 ? null : num2, (i & 2048) != 0 ? null : d, (i & 4096) != 0 ? null : d2, (i & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : list3);
    }

    public static final Schema anyOf(List<Schema> list) {
        return INSTANCE.anyOf(list);
    }

    public static final Schema array(Schema schema, String str, boolean z, String str2, Integer num, Integer num2) {
        return INSTANCE.array(schema, str, z, str2, num, num2);
    }

    /* JADX INFO: renamed from: boolean, reason: not valid java name */
    public static final Schema m406boolean() {
        return INSTANCE.m410boolean();
    }

    public static final Schema enumeration(List<String> list) {
        return INSTANCE.enumeration(list);
    }

    public static final Schema numDouble(String str, boolean z, String str2, Double d, Double d2) {
        return INSTANCE.numDouble(str, z, str2, d, d2);
    }

    public static final Schema numFloat(String str, boolean z, String str2, Double d, Double d2) {
        return INSTANCE.numFloat(str, z, str2, d, d2);
    }

    public static final Schema numInt(String str, boolean z, String str2, Double d, Double d2) {
        return INSTANCE.numInt(str, z, str2, d, d2);
    }

    public static final Schema numLong(String str, boolean z, String str2, Double d, Double d2) {
        return INSTANCE.numLong(str, z, str2, d, d2);
    }

    public static final Schema obj(Map<String, Schema> map, List<String> list, String str, boolean z, String str2) {
        return INSTANCE.obj(map, list, str, z, str2);
    }

    public static final Schema str() {
        return INSTANCE.str();
    }

    public final List<Schema> getAnyOf() {
        return this.anyOf;
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

    public final Schema getItems() {
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

    public final Map<String, Schema> getProperties() {
        return this.properties;
    }

    public final List<String> getRequired() {
        return this.required;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final InternalJson toInternalJson$com_google_firebase_ai_logic_firebase_ai() {
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
            Map<String, Schema> map = this.properties;
            if (map != null) {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                Iterator<T> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap3.put(entry.getKey(), ((Schema) entry.getValue()).toInternalJson$com_google_firebase_ai_logic_firebase_ai());
                }
                linkedHashMap = linkedHashMap3;
            } else {
                linkedHashMap = null;
            }
            List<String> list2 = this.required;
            Schema schema = this.items;
            InternalJson internalJson$com_google_firebase_ai_logic_firebase_ai = schema != null ? schema.toInternalJson$com_google_firebase_ai_logic_firebase_ai() : null;
            String str4 = this.title;
            Integer num = this.minItems;
            Integer num2 = this.maxItems;
            List<Schema> list3 = this.anyOf;
            if (list3 != null) {
                List<Schema> list4 = list3;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                Iterator<T> it2 = list4.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((Schema) it2.next()).toInternalJson$com_google_firebase_ai_logic_firebase_ai());
                }
            }
            return new InternalJsonNonNull(str, str3, str2, list, linkedHashMap, list2, internalJson$com_google_firebase_ai_logic_firebase_ai, str4, num, num2, d3, d4, arrayList);
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
        Map<String, Schema> map2 = this.properties;
        if (map2 != null) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
            Iterator<T> it3 = map2.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it3.next();
                linkedHashMap4.put(entry2.getKey(), ((Schema) entry2.getValue()).toInternalJson$com_google_firebase_ai_logic_firebase_ai());
            }
            linkedHashMap2 = linkedHashMap4;
        } else {
            linkedHashMap2 = null;
        }
        List<String> list6 = this.required;
        Schema schema2 = this.items;
        InternalJson internalJson$com_google_firebase_ai_logic_firebase_ai2 = schema2 != null ? schema2.toInternalJson$com_google_firebase_ai_logic_firebase_ai() : null;
        String str6 = this.title;
        Integer num3 = this.minItems;
        Integer num4 = this.maxItems;
        List<Schema> list7 = this.anyOf;
        if (list7 != null) {
            List<Schema> list8 = list7;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
            Iterator<T> it4 = list8.iterator();
            while (it4.hasNext()) {
                arrayList.add(((Schema) it4.next()).toInternalJson$com_google_firebase_ai_logic_firebase_ai());
            }
        }
        return new InternalJsonNullable(listListOf, str5, str2, listBuild, linkedHashMap2, list6, internalJson$com_google_firebase_ai_logic_firebase_ai2, str6, num3, num4, d3, d4, arrayList);
    }

    public final InternalOpenAPI toInternalOpenApi$com_google_firebase_ai_logic_firebase_ai() {
        LinkedHashMap linkedHashMap;
        ArrayList arrayList = null;
        String str = Intrinsics.areEqual(this.type, "ANYOF") ? null : this.type;
        String str2 = this.description;
        String str3 = this.format;
        Boolean bool = this.nullable;
        List<String> list = this.enum;
        Map<String, Schema> map = this.properties;
        if (map != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap2.put(entry.getKey(), ((Schema) entry.getValue()).toInternalOpenApi$com_google_firebase_ai_logic_firebase_ai());
            }
            linkedHashMap = linkedHashMap2;
        } else {
            linkedHashMap = null;
        }
        List<String> list2 = this.required;
        Schema schema = this.items;
        InternalOpenAPI internalOpenApi$com_google_firebase_ai_logic_firebase_ai = schema != null ? schema.toInternalOpenApi$com_google_firebase_ai_logic_firebase_ai() : null;
        String str4 = this.title;
        Integer num = this.minItems;
        Integer num2 = this.maxItems;
        Double d = this.minimum;
        Double d2 = this.maximum;
        List<Schema> list3 = this.anyOf;
        if (list3 != null) {
            List<Schema> list4 = list3;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList.add(((Schema) it2.next()).toInternalOpenApi$com_google_firebase_ai_logic_firebase_ai());
            }
        }
        return new InternalOpenAPI(str, str2, str3, bool, list, linkedHashMap, list2, internalOpenApi$com_google_firebase_ai_logic_firebase_ai, str4, num, num2, d, d2, arrayList);
    }

    public static final Schema array(Schema schema, String str) {
        return INSTANCE.array(schema, str);
    }

    /* JADX INFO: renamed from: boolean, reason: not valid java name */
    public static final Schema m407boolean(String str) {
        return INSTANCE.m411boolean(str);
    }

    public static final Schema enumeration(List<String> list, String str) {
        return INSTANCE.enumeration(list, str);
    }

    public static final Schema numDouble(String str) {
        return INSTANCE.numDouble(str);
    }

    public static final Schema numFloat(String str) {
        return INSTANCE.numFloat(str);
    }

    public static final Schema numInt(String str) {
        return INSTANCE.numInt(str);
    }

    public static final Schema numLong(String str) {
        return INSTANCE.numLong(str);
    }

    public static final Schema obj(Map<String, Schema> map, List<String> list) {
        return INSTANCE.obj(map, list);
    }

    public static final Schema str(String str) {
        return INSTANCE.str(str);
    }

    public static final Schema array(Schema schema, String str, boolean z) {
        return INSTANCE.array(schema, str, z);
    }

    /* JADX INFO: renamed from: boolean, reason: not valid java name */
    public static final Schema m408boolean(String str, boolean z) {
        return INSTANCE.m412boolean(str, z);
    }

    public static final Schema enumeration(List<String> list, String str, boolean z) {
        return INSTANCE.enumeration(list, str, z);
    }

    public static final Schema numDouble(String str, boolean z) {
        return INSTANCE.numDouble(str, z);
    }

    public static final Schema numFloat(String str, boolean z) {
        return INSTANCE.numFloat(str, z);
    }

    public static final Schema numInt(String str, boolean z) {
        return INSTANCE.numInt(str, z);
    }

    public static final Schema numLong(String str, boolean z) {
        return INSTANCE.numLong(str, z);
    }

    public static final Schema obj(Map<String, Schema> map, List<String> list, String str) {
        return INSTANCE.obj(map, list, str);
    }

    public static final Schema str(String str, boolean z) {
        return INSTANCE.str(str, z);
    }

    public static final Schema array(Schema schema, String str, boolean z, String str2) {
        return INSTANCE.array(schema, str, z, str2);
    }

    /* JADX INFO: renamed from: boolean, reason: not valid java name */
    public static final Schema m409boolean(String str, boolean z, String str2) {
        return INSTANCE.m413boolean(str, z, str2);
    }

    public static final Schema enumeration(List<String> list, String str, boolean z, String str2) {
        return INSTANCE.enumeration(list, str, z, str2);
    }

    public static final Schema numDouble(String str, boolean z, String str2) {
        return INSTANCE.numDouble(str, z, str2);
    }

    public static final Schema numFloat(String str, boolean z, String str2) {
        return INSTANCE.numFloat(str, z, str2);
    }

    public static final Schema numInt(String str, boolean z, String str2) {
        return INSTANCE.numInt(str, z, str2);
    }

    public static final Schema numLong(String str, boolean z, String str2) {
        return INSTANCE.numLong(str, z, str2);
    }

    public static final Schema obj(Map<String, Schema> map, List<String> list, String str, boolean z) {
        return INSTANCE.obj(map, list, str, z);
    }

    public static final Schema str(String str, boolean z, StringFormat stringFormat) {
        return INSTANCE.str(str, z, stringFormat);
    }

    public static final Schema array(Schema schema, String str, boolean z, String str2, Integer num) {
        return INSTANCE.array(schema, str, z, str2, num);
    }

    public static final Schema numDouble(String str, boolean z, String str2, Double d) {
        return INSTANCE.numDouble(str, z, str2, d);
    }

    public static final Schema numFloat(String str, boolean z, String str2, Double d) {
        return INSTANCE.numFloat(str, z, str2, d);
    }

    public static final Schema numInt(String str, boolean z, String str2, Double d) {
        return INSTANCE.numInt(str, z, str2, d);
    }

    public static final Schema numLong(String str, boolean z, String str2, Double d) {
        return INSTANCE.numLong(str, z, str2, d);
    }

    public static final Schema obj(Map<String, Schema> map) {
        return INSTANCE.obj(map);
    }

    public static final Schema str(String str, boolean z, StringFormat stringFormat, String str2) {
        return INSTANCE.str(str, z, stringFormat, str2);
    }

    public static final Schema array(Schema schema) {
        return INSTANCE.array(schema);
    }

    public static final Schema numDouble() {
        return INSTANCE.numDouble();
    }

    public static final Schema numFloat() {
        return INSTANCE.numFloat();
    }

    public static final Schema numInt() {
        return INSTANCE.numInt();
    }

    public static final Schema numLong() {
        return INSTANCE.numLong();
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 M2\u00020\u0001:\u0002LMBÁ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0015B»\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00109\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010:\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010+J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003JÈ\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u000eHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001f¨\u0006N"}, d2 = {"Lcom/google/firebase/ai/type/Schema$InternalJsonNonNull;", "Lcom/google/firebase/ai/type/Schema$InternalJson;", "type", "", "description", "format", "enum", "", "properties", "", "required", "items", "title", "minItems", "", "maxItems", "minimum", "", "maximum", "anyOf", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/lang/String;", "getDescription", "getFormat", "getEnum", "()Ljava/util/List;", "getProperties", "()Ljava/util/Map;", "getRequired", "getItems", "()Lcom/google/firebase/ai/type/Schema$InternalJson;", "getTitle", "getMinItems", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxItems", "getMinimum", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaximum", "getAnyOf", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)Lcom/google/firebase/ai/type/Schema$InternalJsonNonNull;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InternalJsonNonNull implements InternalJson {
        private static final KSerializer<Object>[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<InternalJson> anyOf;
        private final String description;
        private final List<String> enum;
        private final String format;
        private final InternalJson items;
        private final Integer maxItems;
        private final Double maximum;
        private final Integer minItems;
        private final Double minimum;
        private final Map<String, InternalJson> properties;
        private final List<String> required;
        private final String title;
        private final String type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Schema$InternalJsonNonNull$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Schema$InternalJsonNonNull;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<InternalJsonNonNull> serializer() {
                return Schema$InternalJsonNonNull$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            ArrayListSerializer arrayListSerializer = new ArrayListSerializer(stringSerializer);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(InternalJson.class);
            KClass[] kClassArr = {Reflection.getOrCreateKotlinClass(InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(InternalJsonNullable.class)};
            Schema$InternalJsonNonNull$$serializer schema$InternalJsonNonNull$$serializer = Schema$InternalJsonNonNull$$serializer.INSTANCE;
            Schema$InternalJsonNullable$$serializer schema$InternalJsonNullable$$serializer = Schema$InternalJsonNullable$$serializer.INSTANCE;
            $childSerializers = new KSerializer[]{null, null, null, arrayListSerializer, new LinkedHashMapSerializer(stringSerializer, new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", orCreateKotlinClass, kClassArr, new KSerializer[]{schema$InternalJsonNonNull$$serializer, schema$InternalJsonNullable$$serializer}, new Annotation[0])), new ArrayListSerializer(stringSerializer), new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", Reflection.getOrCreateKotlinClass(InternalJson.class), new KClass[]{Reflection.getOrCreateKotlinClass(InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(InternalJsonNullable.class)}, new KSerializer[]{schema$InternalJsonNonNull$$serializer, schema$InternalJsonNullable$$serializer}, new Annotation[0]), null, null, null, null, null, new ArrayListSerializer(new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", Reflection.getOrCreateKotlinClass(InternalJson.class), new KClass[]{Reflection.getOrCreateKotlinClass(InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(InternalJsonNullable.class)}, new KSerializer[]{schema$InternalJsonNonNull$$serializer, schema$InternalJsonNullable$$serializer}, new Annotation[0]))};
        }

        public /* synthetic */ InternalJsonNonNull(String str, String str2, String str3, List list, Map map, List list2, InternalJson internalJson, String str4, Integer num, Integer num2, Double d, Double d2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : internalJson, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : d, (i & 2048) != 0 ? null : d2, (i & 4096) != 0 ? null : list3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InternalJsonNonNull copy$default(InternalJsonNonNull internalJsonNonNull, String str, String str2, String str3, List list, Map map, List list2, InternalJson internalJson, String str4, Integer num, Integer num2, Double d, Double d2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internalJsonNonNull.type;
            }
            return internalJsonNonNull.copy(str, (i & 2) != 0 ? internalJsonNonNull.description : str2, (i & 4) != 0 ? internalJsonNonNull.format : str3, (i & 8) != 0 ? internalJsonNonNull.enum : list, (i & 16) != 0 ? internalJsonNonNull.properties : map, (i & 32) != 0 ? internalJsonNonNull.required : list2, (i & 64) != 0 ? internalJsonNonNull.items : internalJson, (i & 128) != 0 ? internalJsonNonNull.title : str4, (i & 256) != 0 ? internalJsonNonNull.minItems : num, (i & 512) != 0 ? internalJsonNonNull.maxItems : num2, (i & 1024) != 0 ? internalJsonNonNull.minimum : d, (i & 2048) != 0 ? internalJsonNonNull.maximum : d2, (i & 4096) != 0 ? internalJsonNonNull.anyOf : list3);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(InternalJsonNonNull self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.description != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.description);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.format != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.format);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.enum != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.enum);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.properties != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.properties);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.required != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.required);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.items != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.items);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.minItems != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.minItems);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.maxItems != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.maxItems);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.minimum != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, DoubleSerializer.INSTANCE, self.minimum);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.maximum != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, DoubleSerializer.INSTANCE, self.maximum);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.anyOf == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 12, kSerializerArr[12], self.anyOf);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getMaxItems() {
            return this.maxItems;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Double getMinimum() {
            return this.minimum;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Double getMaximum() {
            return this.maximum;
        }

        public final List<InternalJson> component13() {
            return this.anyOf;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        public final List<String> component4() {
            return this.enum;
        }

        public final Map<String, InternalJson> component5() {
            return this.properties;
        }

        public final List<String> component6() {
            return this.required;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final InternalJson getItems() {
            return this.items;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getMinItems() {
            return this.minItems;
        }

        public final InternalJsonNonNull copy(String type, String description, String format, List<String> list, Map<String, ? extends InternalJson> properties, List<String> required, InternalJson items, String title, Integer minItems, Integer maxItems, Double minimum, Double maximum, List<? extends InternalJson> anyOf) {
            return new InternalJsonNonNull(type, description, format, list, properties, required, items, title, minItems, maxItems, minimum, maximum, anyOf);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InternalJsonNonNull)) {
                return false;
            }
            InternalJsonNonNull internalJsonNonNull = (InternalJsonNonNull) other;
            return Intrinsics.areEqual(this.type, internalJsonNonNull.type) && Intrinsics.areEqual(this.description, internalJsonNonNull.description) && Intrinsics.areEqual(this.format, internalJsonNonNull.format) && Intrinsics.areEqual(this.enum, internalJsonNonNull.enum) && Intrinsics.areEqual(this.properties, internalJsonNonNull.properties) && Intrinsics.areEqual(this.required, internalJsonNonNull.required) && Intrinsics.areEqual(this.items, internalJsonNonNull.items) && Intrinsics.areEqual(this.title, internalJsonNonNull.title) && Intrinsics.areEqual(this.minItems, internalJsonNonNull.minItems) && Intrinsics.areEqual(this.maxItems, internalJsonNonNull.maxItems) && Intrinsics.areEqual(this.minimum, internalJsonNonNull.minimum) && Intrinsics.areEqual(this.maximum, internalJsonNonNull.maximum) && Intrinsics.areEqual(this.anyOf, internalJsonNonNull.anyOf);
        }

        public final List<InternalJson> getAnyOf() {
            return this.anyOf;
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

        public final InternalJson getItems() {
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

        public final Map<String, InternalJson> getProperties() {
            return this.properties;
        }

        public final List<String> getRequired() {
            return this.required;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.type;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.format;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            List<String> list = this.enum;
            int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
            Map<String, InternalJson> map = this.properties;
            int iHashCode5 = (iHashCode4 + (map == null ? 0 : map.hashCode())) * 31;
            List<String> list2 = this.required;
            int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
            InternalJson internalJson = this.items;
            int iHashCode7 = (iHashCode6 + (internalJson == null ? 0 : internalJson.hashCode())) * 31;
            String str4 = this.title;
            int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num = this.minItems;
            int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.maxItems;
            int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Double d = this.minimum;
            int iHashCode11 = (iHashCode10 + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.maximum;
            int iHashCode12 = (iHashCode11 + (d2 == null ? 0 : d2.hashCode())) * 31;
            List<InternalJson> list3 = this.anyOf;
            return iHashCode12 + (list3 != null ? list3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("InternalJsonNonNull(type=");
            sb.append(this.type);
            sb.append(", description=");
            sb.append(this.description);
            sb.append(", format=");
            sb.append(this.format);
            sb.append(", enum=");
            sb.append(this.enum);
            sb.append(", properties=");
            sb.append(this.properties);
            sb.append(", required=");
            sb.append(this.required);
            sb.append(", items=");
            sb.append(this.items);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", minItems=");
            sb.append(this.minItems);
            sb.append(", maxItems=");
            sb.append(this.maxItems);
            sb.append(", minimum=");
            sb.append(this.minimum);
            sb.append(", maximum=");
            sb.append(this.maximum);
            sb.append(", anyOf=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.anyOf, ')');
        }

        public /* synthetic */ InternalJsonNonNull(int i, String str, String str2, String str3, List list, Map map, List list2, InternalJson internalJson, String str4, Integer num, Integer num2, Double d, Double d2, List list3, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.type = null;
            } else {
                this.type = str;
            }
            if ((i & 2) == 0) {
                this.description = null;
            } else {
                this.description = str2;
            }
            if ((i & 4) == 0) {
                this.format = null;
            } else {
                this.format = str3;
            }
            if ((i & 8) == 0) {
                this.enum = null;
            } else {
                this.enum = list;
            }
            if ((i & 16) == 0) {
                this.properties = null;
            } else {
                this.properties = map;
            }
            if ((i & 32) == 0) {
                this.required = null;
            } else {
                this.required = list2;
            }
            if ((i & 64) == 0) {
                this.items = null;
            } else {
                this.items = internalJson;
            }
            if ((i & 128) == 0) {
                this.title = null;
            } else {
                this.title = str4;
            }
            if ((i & 256) == 0) {
                this.minItems = null;
            } else {
                this.minItems = num;
            }
            if ((i & 512) == 0) {
                this.maxItems = null;
            } else {
                this.maxItems = num2;
            }
            if ((i & 1024) == 0) {
                this.minimum = null;
            } else {
                this.minimum = d;
            }
            if ((i & 2048) == 0) {
                this.maximum = null;
            } else {
                this.maximum = d2;
            }
            if ((i & 4096) == 0) {
                this.anyOf = null;
            } else {
                this.anyOf = list3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InternalJsonNonNull(String str, String str2, String str3, List<String> list, Map<String, ? extends InternalJson> map, List<String> list2, InternalJson internalJson, String str4, Integer num, Integer num2, Double d, Double d2, List<? extends InternalJson> list3) {
            this.type = str;
            this.description = str2;
            this.format = str3;
            this.enum = list;
            this.properties = map;
            this.required = list2;
            this.items = internalJson;
            this.title = str4;
            this.minItems = num;
            this.maxItems = num2;
            this.minimum = d;
            this.maximum = d2;
            this.anyOf = list3;
        }

        public InternalJsonNonNull() {
            this((String) null, (String) null, (String) null, (List) null, (Map) null, (List) null, (InternalJson) null, (String) null, (Integer) null, (Integer) null, (Double) null, (Double) null, (List) null, 8191, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 M2\u00020\u0001:\u0002LMBÇ\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015BÁ\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00109\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010:\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010+J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u0010<\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u000eHÖ\u0001J\t\u0010C\u001a\u00020\u0004HÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001b¨\u0006N"}, d2 = {"Lcom/google/firebase/ai/type/Schema$InternalJsonNullable;", "Lcom/google/firebase/ai/type/Schema$InternalJson;", "type", "", "", "description", "format", "enum", "properties", "", "required", "items", "title", "minItems", "", "maxItems", "minimum", "", "maximum", "anyOf", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getFormat", "getEnum", "getProperties", "()Ljava/util/Map;", "getRequired", "getItems", "()Lcom/google/firebase/ai/type/Schema$InternalJson;", "getTitle", "getMinItems", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxItems", "getMinimum", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaximum", "getAnyOf", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)Lcom/google/firebase/ai/type/Schema$InternalJsonNullable;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InternalJsonNullable implements InternalJson {
        private static final KSerializer<Object>[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<InternalJson> anyOf;
        private final String description;
        private final List<String> enum;
        private final String format;
        private final InternalJson items;
        private final Integer maxItems;
        private final Double maximum;
        private final Integer minItems;
        private final Double minimum;
        private final Map<String, InternalJson> properties;
        private final List<String> required;
        private final String title;
        private final List<String> type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Schema$InternalJsonNullable$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Schema$InternalJsonNullable;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<InternalJsonNullable> serializer() {
                return Schema$InternalJsonNullable$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            ArrayListSerializer arrayListSerializer = new ArrayListSerializer(stringSerializer);
            ArrayListSerializer arrayListSerializer2 = new ArrayListSerializer(stringSerializer);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(InternalJson.class);
            KClass[] kClassArr = {Reflection.getOrCreateKotlinClass(InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(InternalJsonNullable.class)};
            Schema$InternalJsonNonNull$$serializer schema$InternalJsonNonNull$$serializer = Schema$InternalJsonNonNull$$serializer.INSTANCE;
            Schema$InternalJsonNullable$$serializer schema$InternalJsonNullable$$serializer = Schema$InternalJsonNullable$$serializer.INSTANCE;
            $childSerializers = new KSerializer[]{arrayListSerializer, null, null, arrayListSerializer2, new LinkedHashMapSerializer(stringSerializer, new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", orCreateKotlinClass, kClassArr, new KSerializer[]{schema$InternalJsonNonNull$$serializer, schema$InternalJsonNullable$$serializer}, new Annotation[0])), new ArrayListSerializer(stringSerializer), new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", Reflection.getOrCreateKotlinClass(InternalJson.class), new KClass[]{Reflection.getOrCreateKotlinClass(InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(InternalJsonNullable.class)}, new KSerializer[]{schema$InternalJsonNonNull$$serializer, schema$InternalJsonNullable$$serializer}, new Annotation[0]), null, null, null, null, null, new ArrayListSerializer(new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", Reflection.getOrCreateKotlinClass(InternalJson.class), new KClass[]{Reflection.getOrCreateKotlinClass(InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(InternalJsonNullable.class)}, new KSerializer[]{schema$InternalJsonNonNull$$serializer, schema$InternalJsonNullable$$serializer}, new Annotation[0]))};
        }

        public /* synthetic */ InternalJsonNullable(List list, String str, String str2, List list2, Map map, List list3, InternalJson internalJson, String str3, Integer num, Integer num2, Double d, Double d2, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : internalJson, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : d, (i & 2048) != 0 ? null : d2, (i & 4096) != 0 ? null : list4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InternalJsonNullable copy$default(InternalJsonNullable internalJsonNullable, List list, String str, String str2, List list2, Map map, List list3, InternalJson internalJson, String str3, Integer num, Integer num2, Double d, Double d2, List list4, int i, Object obj) {
            if ((i & 1) != 0) {
                list = internalJsonNullable.type;
            }
            return internalJsonNullable.copy(list, (i & 2) != 0 ? internalJsonNullable.description : str, (i & 4) != 0 ? internalJsonNullable.format : str2, (i & 8) != 0 ? internalJsonNullable.enum : list2, (i & 16) != 0 ? internalJsonNullable.properties : map, (i & 32) != 0 ? internalJsonNullable.required : list3, (i & 64) != 0 ? internalJsonNullable.items : internalJson, (i & 128) != 0 ? internalJsonNullable.title : str3, (i & 256) != 0 ? internalJsonNullable.minItems : num, (i & 512) != 0 ? internalJsonNullable.maxItems : num2, (i & 1024) != 0 ? internalJsonNullable.minimum : d, (i & 2048) != 0 ? internalJsonNullable.maximum : d2, (i & 4096) != 0 ? internalJsonNullable.anyOf : list4);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(InternalJsonNullable self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.description != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.description);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.format != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.format);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.enum != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.enum);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.properties != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.properties);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.required != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.required);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.items != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.items);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.minItems != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.minItems);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.maxItems != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.maxItems);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.minimum != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, DoubleSerializer.INSTANCE, self.minimum);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.maximum != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, DoubleSerializer.INSTANCE, self.maximum);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.anyOf == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 12, kSerializerArr[12], self.anyOf);
        }

        public final List<String> component1() {
            return this.type;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getMaxItems() {
            return this.maxItems;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Double getMinimum() {
            return this.minimum;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Double getMaximum() {
            return this.maximum;
        }

        public final List<InternalJson> component13() {
            return this.anyOf;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        public final List<String> component4() {
            return this.enum;
        }

        public final Map<String, InternalJson> component5() {
            return this.properties;
        }

        public final List<String> component6() {
            return this.required;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final InternalJson getItems() {
            return this.items;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getMinItems() {
            return this.minItems;
        }

        public final InternalJsonNullable copy(List<String> type, String description, String format, List<String> list, Map<String, ? extends InternalJson> properties, List<String> required, InternalJson items, String title, Integer minItems, Integer maxItems, Double minimum, Double maximum, List<? extends InternalJson> anyOf) {
            return new InternalJsonNullable(type, description, format, list, properties, required, items, title, minItems, maxItems, minimum, maximum, anyOf);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InternalJsonNullable)) {
                return false;
            }
            InternalJsonNullable internalJsonNullable = (InternalJsonNullable) other;
            return Intrinsics.areEqual(this.type, internalJsonNullable.type) && Intrinsics.areEqual(this.description, internalJsonNullable.description) && Intrinsics.areEqual(this.format, internalJsonNullable.format) && Intrinsics.areEqual(this.enum, internalJsonNullable.enum) && Intrinsics.areEqual(this.properties, internalJsonNullable.properties) && Intrinsics.areEqual(this.required, internalJsonNullable.required) && Intrinsics.areEqual(this.items, internalJsonNullable.items) && Intrinsics.areEqual(this.title, internalJsonNullable.title) && Intrinsics.areEqual(this.minItems, internalJsonNullable.minItems) && Intrinsics.areEqual(this.maxItems, internalJsonNullable.maxItems) && Intrinsics.areEqual(this.minimum, internalJsonNullable.minimum) && Intrinsics.areEqual(this.maximum, internalJsonNullable.maximum) && Intrinsics.areEqual(this.anyOf, internalJsonNullable.anyOf);
        }

        public final List<InternalJson> getAnyOf() {
            return this.anyOf;
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

        public final InternalJson getItems() {
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

        public final Map<String, InternalJson> getProperties() {
            return this.properties;
        }

        public final List<String> getRequired() {
            return this.required;
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<String> getType() {
            return this.type;
        }

        public int hashCode() {
            List<String> list = this.type;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            String str = this.description;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.format;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<String> list2 = this.enum;
            int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
            Map<String, InternalJson> map = this.properties;
            int iHashCode5 = (iHashCode4 + (map == null ? 0 : map.hashCode())) * 31;
            List<String> list3 = this.required;
            int iHashCode6 = (iHashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
            InternalJson internalJson = this.items;
            int iHashCode7 = (iHashCode6 + (internalJson == null ? 0 : internalJson.hashCode())) * 31;
            String str3 = this.title;
            int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.minItems;
            int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.maxItems;
            int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Double d = this.minimum;
            int iHashCode11 = (iHashCode10 + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.maximum;
            int iHashCode12 = (iHashCode11 + (d2 == null ? 0 : d2.hashCode())) * 31;
            List<InternalJson> list4 = this.anyOf;
            return iHashCode12 + (list4 != null ? list4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("InternalJsonNullable(type=");
            sb.append(this.type);
            sb.append(", description=");
            sb.append(this.description);
            sb.append(", format=");
            sb.append(this.format);
            sb.append(", enum=");
            sb.append(this.enum);
            sb.append(", properties=");
            sb.append(this.properties);
            sb.append(", required=");
            sb.append(this.required);
            sb.append(", items=");
            sb.append(this.items);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", minItems=");
            sb.append(this.minItems);
            sb.append(", maxItems=");
            sb.append(this.maxItems);
            sb.append(", minimum=");
            sb.append(this.minimum);
            sb.append(", maximum=");
            sb.append(this.maximum);
            sb.append(", anyOf=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.anyOf, ')');
        }

        public /* synthetic */ InternalJsonNullable(int i, List list, String str, String str2, List list2, Map map, List list3, InternalJson internalJson, String str3, Integer num, Integer num2, Double d, Double d2, List list4, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.type = null;
            } else {
                this.type = list;
            }
            if ((i & 2) == 0) {
                this.description = null;
            } else {
                this.description = str;
            }
            if ((i & 4) == 0) {
                this.format = null;
            } else {
                this.format = str2;
            }
            if ((i & 8) == 0) {
                this.enum = null;
            } else {
                this.enum = list2;
            }
            if ((i & 16) == 0) {
                this.properties = null;
            } else {
                this.properties = map;
            }
            if ((i & 32) == 0) {
                this.required = null;
            } else {
                this.required = list3;
            }
            if ((i & 64) == 0) {
                this.items = null;
            } else {
                this.items = internalJson;
            }
            if ((i & 128) == 0) {
                this.title = null;
            } else {
                this.title = str3;
            }
            if ((i & 256) == 0) {
                this.minItems = null;
            } else {
                this.minItems = num;
            }
            if ((i & 512) == 0) {
                this.maxItems = null;
            } else {
                this.maxItems = num2;
            }
            if ((i & 1024) == 0) {
                this.minimum = null;
            } else {
                this.minimum = d;
            }
            if ((i & 2048) == 0) {
                this.maximum = null;
            } else {
                this.maximum = d2;
            }
            if ((i & 4096) == 0) {
                this.anyOf = null;
            } else {
                this.anyOf = list4;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InternalJsonNullable(List<String> list, String str, String str2, List<String> list2, Map<String, ? extends InternalJson> map, List<String> list3, InternalJson internalJson, String str3, Integer num, Integer num2, Double d, Double d2, List<? extends InternalJson> list4) {
            this.type = list;
            this.description = str;
            this.format = str2;
            this.enum = list2;
            this.properties = map;
            this.required = list3;
            this.items = internalJson;
            this.title = str3;
            this.minItems = num;
            this.maxItems = num2;
            this.minimum = d;
            this.maximum = d2;
            this.anyOf = list4;
        }

        public InternalJsonNullable() {
            this((List) null, (String) null, (String) null, (List) null, (Map) null, (List) null, (InternalJson) null, (String) null, (Integer) null, (Integer) null, (Double) null, (Double) null, (List) null, 8191, (DefaultConstructorMarker) null);
        }
    }

    public Schema(String str, String str2, String str3, Boolean bool, List<String> list, Map<String, Schema> map, List<String> list2, Schema schema, String str4, Integer num, Integer num2, Double d, Double d2, List<Schema> list3) {
        str.getClass();
        this.type = str;
        this.description = str2;
        this.format = str3;
        this.nullable = bool;
        this.enum = list;
        this.properties = map;
        this.required = list2;
        this.items = schema;
        this.title = str4;
        this.minItems = num;
        this.maxItems = num2;
        this.minimum = d;
        this.maximum = d2;
        this.anyOf = list3;
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 Q2\u00020\u0001:\u0002PQBÍ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017BÅ\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010!J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0017\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bHÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010>\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010?\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010@\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u00100J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\tHÆ\u0003JÔ\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u0010HÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001J%\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\bOR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010-\u001a\u0004\b.\u0010,R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u00101\u001a\u0004\b2\u00100R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$¨\u0006R"}, d2 = {"Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "", "type", "", "description", "format", "nullable", "", "enum", "", "properties", "", "required", "items", "title", "minItems", "", "maxItems", "minimum", "", "maximum", "anyOf", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/lang/String;", "getDescription", "getFormat", "getNullable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnum", "()Ljava/util/List;", "getProperties", "()Ljava/util/Map;", "getRequired", "getItems", "()Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "getTitle", "getMinItems", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxItems", "getMinimum", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaximum", "getAnyOf", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InternalOpenAPI {
        private static final KSerializer<Object>[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<InternalOpenAPI> anyOf;
        private final String description;
        private final List<String> enum;
        private final String format;
        private final InternalOpenAPI items;
        private final Integer maxItems;
        private final Double maximum;
        private final Integer minItems;
        private final Double minimum;
        private final Boolean nullable;
        private final Map<String, InternalOpenAPI> properties;
        private final List<String> required;
        private final String title;
        private final String type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Schema$InternalOpenAPI$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<InternalOpenAPI> serializer() {
                return Schema$InternalOpenAPI$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            $childSerializers = new KSerializer[]{null, null, null, null, new ArrayListSerializer(stringSerializer), null, new ArrayListSerializer(stringSerializer), null, null, null, null, null, null, null};
        }

        public /* synthetic */ InternalOpenAPI(String str, String str2, String str3, Boolean bool, List list, Map map, List list2, InternalOpenAPI internalOpenAPI, String str4, Integer num, Integer num2, Double d, Double d2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? Boolean.FALSE : bool, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : map, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : internalOpenAPI, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : num, (i & 1024) != 0 ? null : num2, (i & 2048) != 0 ? null : d, (i & 4096) != 0 ? null : d2, (i & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : list3);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(InternalOpenAPI self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.description != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.description);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.format != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.format);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.nullable, Boolean.FALSE)) {
                output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.nullable);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.enum != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.enum);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.properties != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, new LinkedHashMapSerializer(StringSerializer.INSTANCE, Schema$InternalOpenAPI$$serializer.INSTANCE), self.properties);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.required != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.required);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.items != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, Schema$InternalOpenAPI$$serializer.INSTANCE, self.items);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.minItems != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.minItems);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.maxItems != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.maxItems);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.minimum != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, DoubleSerializer.INSTANCE, self.minimum);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.maximum != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, DoubleSerializer.INSTANCE, self.maximum);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 13) && self.anyOf == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 13, new ArrayListSerializer(Schema$InternalOpenAPI$$serializer.INSTANCE), self.anyOf);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getMinItems() {
            return this.minItems;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getMaxItems() {
            return this.maxItems;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Double getMinimum() {
            return this.minimum;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Double getMaximum() {
            return this.maximum;
        }

        public final List<InternalOpenAPI> component14() {
            return this.anyOf;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getNullable() {
            return this.nullable;
        }

        public final List<String> component5() {
            return this.enum;
        }

        public final Map<String, InternalOpenAPI> component6() {
            return this.properties;
        }

        public final List<String> component7() {
            return this.required;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final InternalOpenAPI getItems() {
            return this.items;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final InternalOpenAPI copy(String type, String description, String format, Boolean nullable, List<String> list, Map<String, InternalOpenAPI> properties, List<String> required, InternalOpenAPI items, String title, Integer minItems, Integer maxItems, Double minimum, Double maximum, List<InternalOpenAPI> anyOf) {
            return new InternalOpenAPI(type, description, format, nullable, list, properties, required, items, title, minItems, maxItems, minimum, maximum, anyOf);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InternalOpenAPI)) {
                return false;
            }
            InternalOpenAPI internalOpenAPI = (InternalOpenAPI) other;
            return Intrinsics.areEqual(this.type, internalOpenAPI.type) && Intrinsics.areEqual(this.description, internalOpenAPI.description) && Intrinsics.areEqual(this.format, internalOpenAPI.format) && Intrinsics.areEqual(this.nullable, internalOpenAPI.nullable) && Intrinsics.areEqual(this.enum, internalOpenAPI.enum) && Intrinsics.areEqual(this.properties, internalOpenAPI.properties) && Intrinsics.areEqual(this.required, internalOpenAPI.required) && Intrinsics.areEqual(this.items, internalOpenAPI.items) && Intrinsics.areEqual(this.title, internalOpenAPI.title) && Intrinsics.areEqual(this.minItems, internalOpenAPI.minItems) && Intrinsics.areEqual(this.maxItems, internalOpenAPI.maxItems) && Intrinsics.areEqual(this.minimum, internalOpenAPI.minimum) && Intrinsics.areEqual(this.maximum, internalOpenAPI.maximum) && Intrinsics.areEqual(this.anyOf, internalOpenAPI.anyOf);
        }

        public final List<InternalOpenAPI> getAnyOf() {
            return this.anyOf;
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

        public final InternalOpenAPI getItems() {
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

        public final Map<String, InternalOpenAPI> getProperties() {
            return this.properties;
        }

        public final List<String> getRequired() {
            return this.required;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.type;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.format;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.nullable;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            List<String> list = this.enum;
            int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
            Map<String, InternalOpenAPI> map = this.properties;
            int iHashCode6 = (iHashCode5 + (map == null ? 0 : map.hashCode())) * 31;
            List<String> list2 = this.required;
            int iHashCode7 = (iHashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
            InternalOpenAPI internalOpenAPI = this.items;
            int iHashCode8 = (iHashCode7 + (internalOpenAPI == null ? 0 : internalOpenAPI.hashCode())) * 31;
            String str4 = this.title;
            int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num = this.minItems;
            int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.maxItems;
            int iHashCode11 = (iHashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Double d = this.minimum;
            int iHashCode12 = (iHashCode11 + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.maximum;
            int iHashCode13 = (iHashCode12 + (d2 == null ? 0 : d2.hashCode())) * 31;
            List<InternalOpenAPI> list3 = this.anyOf;
            return iHashCode13 + (list3 != null ? list3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("InternalOpenAPI(type=");
            sb.append(this.type);
            sb.append(", description=");
            sb.append(this.description);
            sb.append(", format=");
            sb.append(this.format);
            sb.append(", nullable=");
            sb.append(this.nullable);
            sb.append(", enum=");
            sb.append(this.enum);
            sb.append(", properties=");
            sb.append(this.properties);
            sb.append(", required=");
            sb.append(this.required);
            sb.append(", items=");
            sb.append(this.items);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", minItems=");
            sb.append(this.minItems);
            sb.append(", maxItems=");
            sb.append(this.maxItems);
            sb.append(", minimum=");
            sb.append(this.minimum);
            sb.append(", maximum=");
            sb.append(this.maximum);
            sb.append(", anyOf=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.anyOf, ')');
        }

        public /* synthetic */ InternalOpenAPI(int i, String str, String str2, String str3, Boolean bool, List list, Map map, List list2, InternalOpenAPI internalOpenAPI, String str4, Integer num, Integer num2, Double d, Double d2, List list3, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.type = null;
            } else {
                this.type = str;
            }
            if ((i & 2) == 0) {
                this.description = null;
            } else {
                this.description = str2;
            }
            if ((i & 4) == 0) {
                this.format = null;
            } else {
                this.format = str3;
            }
            if ((i & 8) == 0) {
                this.nullable = Boolean.FALSE;
            } else {
                this.nullable = bool;
            }
            if ((i & 16) == 0) {
                this.enum = null;
            } else {
                this.enum = list;
            }
            if ((i & 32) == 0) {
                this.properties = null;
            } else {
                this.properties = map;
            }
            if ((i & 64) == 0) {
                this.required = null;
            } else {
                this.required = list2;
            }
            if ((i & 128) == 0) {
                this.items = null;
            } else {
                this.items = internalOpenAPI;
            }
            if ((i & 256) == 0) {
                this.title = null;
            } else {
                this.title = str4;
            }
            if ((i & 512) == 0) {
                this.minItems = null;
            } else {
                this.minItems = num;
            }
            if ((i & 1024) == 0) {
                this.maxItems = null;
            } else {
                this.maxItems = num2;
            }
            if ((i & 2048) == 0) {
                this.minimum = null;
            } else {
                this.minimum = d;
            }
            if ((i & 4096) == 0) {
                this.maximum = null;
            } else {
                this.maximum = d2;
            }
            if ((i & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
                this.anyOf = null;
            } else {
                this.anyOf = list3;
            }
        }

        public InternalOpenAPI(String str, String str2, String str3, Boolean bool, List<String> list, Map<String, InternalOpenAPI> map, List<String> list2, InternalOpenAPI internalOpenAPI, String str4, Integer num, Integer num2, Double d, Double d2, List<InternalOpenAPI> list3) {
            this.type = str;
            this.description = str2;
            this.format = str3;
            this.nullable = bool;
            this.enum = list;
            this.properties = map;
            this.required = list2;
            this.items = internalOpenAPI;
            this.title = str4;
            this.minItems = num;
            this.maxItems = num2;
            this.minimum = d;
            this.maximum = d2;
            this.anyOf = list3;
        }

        public InternalOpenAPI() {
            this((String) null, (String) null, (String) null, (Boolean) null, (List) null, (Map) null, (List) null, (InternalOpenAPI) null, (String) null, (Integer) null, (Integer) null, (Double) null, (Double) null, (List) null, 16383, (DefaultConstructorMarker) null);
        }
    }
}
