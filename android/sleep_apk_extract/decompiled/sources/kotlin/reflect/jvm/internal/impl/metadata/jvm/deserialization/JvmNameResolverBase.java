package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = new Companion(null);
    private static final List<String> PREDEFINED_STRINGS;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f100kotlin;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, null, 62);
        f100kotlin = strJoinToString$default;
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Any"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Nothing"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Unit"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Throwable"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Number"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Byte"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Double"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Float"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Int"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Long"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Short"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Boolean"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Char"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/CharSequence"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/String"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Comparable"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Enum"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Array"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/ByteArray"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/DoubleArray"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/FloatArray"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/IntArray"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/LongArray"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/ShortArray"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/BooleanArray"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/CharArray"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Cloneable"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/Annotation"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/Iterable"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/MutableIterable"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/Collection"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/MutableCollection"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/List"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/MutableList"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/Set"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/MutableSet"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/Map"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/MutableMap"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/Map.Entry"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/MutableMap.MutableEntry"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/Iterator"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/MutableIterator"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/ListIterator"), FileInsert$$ExternalSyntheticOutline0.m$1(strJoinToString$default, "/collections/MutableListIterator")});
        PREDEFINED_STRINGS = listListOf;
        Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(listListOf);
        LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m(iterableWithIndex, 10, 16));
        for (IndexedValue indexedValue : iterableWithIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }

    public JvmNameResolverBase(String[] strArr, Set<Integer> set, List<JvmProtoBuf.StringTableTypes.Record> list) {
        strArr.getClass();
        set.getClass();
        list.getClass();
        this.strings = strArr;
        this.localNameIndices = set;
        this.records = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getString(int i) {
        String strReplace$default;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i);
        if (record.hasString()) {
            strReplace$default = record.getString();
        } else if (record.hasPredefinedIndex()) {
            List<String> list = PREDEFINED_STRINGS;
            int size = list.size();
            int predefinedIndex = record.getPredefinedIndex();
            strReplace$default = (predefinedIndex < 0 || predefinedIndex >= size) ? this.strings[i] : list.get(record.getPredefinedIndex());
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            substringIndexList.getClass();
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            if (num.intValue() >= 0 && num.intValue() <= num2.intValue() && num2.intValue() <= strReplace$default.length()) {
                strReplace$default = strReplace$default.substring(num.intValue(), num2.intValue());
            }
        }
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            replaceCharList.getClass();
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            strReplace$default.getClass();
            strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, (char) num3.intValue(), (char) num4.intValue(), false, 4, (Object) null);
        }
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                strReplace$default.getClass();
                strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, '$', '.', false, 4, (Object) null);
            } else {
                if (i2 != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                if (strReplace$default.length() >= 2) {
                    strReplace$default = Fragment$$ExternalSyntheticOutline1.m(1, 1, strReplace$default);
                }
                strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, '$', '.', false, 4, (Object) null);
            }
        }
        strReplace$default.getClass();
        return strReplace$default;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(Integer.valueOf(i));
    }
}
