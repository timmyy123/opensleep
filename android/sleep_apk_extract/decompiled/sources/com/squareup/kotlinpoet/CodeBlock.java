package com.squareup.kotlinpoet;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0002#$B'\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J\u0006\u0010!\u001a\u00020\"R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006%"}, d2 = {"Lcom/squareup/kotlinpoet/CodeBlock;", "", "formatParts", "", "", "args", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getFormatParts$kotlinpoet", "()Ljava/util/List;", "getArgs$kotlinpoet", "isEmpty", "", "isNotEmpty", "withoutPrefix", "prefix", "withoutPrefix$kotlinpoet", "trim", "trim$kotlinpoet", "replaceAll", "oldValue", "newValue", "replaceAll$kotlinpoet", "hasStatements", "hasStatements$kotlinpoet", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "toString$kotlinpoet", "toBuilder", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "Builder", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CodeBlock {
    private final List<Object> args;
    private final List<String> formatParts;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex NAMED_ARGUMENT = new Regex("%([\\w_]+):([\\w]).*");
    private static final Regex LOWERCASE = new Regex("[a-z]+[\\w_]*");
    private static final Set<String> NO_ARG_PLACEHOLDERS = SetsKt.setOf((Object[]) new String[]{"⇥", "⇤", "«", "»"});
    private static final CodeBlock EMPTY = new CodeBlock(CollectionsKt.emptyList(), CollectionsKt.emptyList());

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0014\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0019\u0010\"\u001a\u00020\b*\u00020\f2\u0006\u0010#\u001a\u00020\bH\u0000¢\u0006\u0002\b$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u00020\u0019*\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u001f\u001a\u00020\u0019*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/squareup/kotlinpoet/CodeBlock$Companion;", "", "<init>", "()V", "NAMED_ARGUMENT", "Lkotlin/text/Regex;", "LOWERCASE", "ARG_NAME", "", "TYPE_NAME", "NO_ARG_PLACEHOLDERS", "", "", "EMPTY", "Lcom/squareup/kotlinpoet/CodeBlock;", "getEMPTY$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock;", "of", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/CodeBlock;", "builder", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "isMultiCharNoArgPlaceholder", "", "", "isMultiCharNoArgPlaceholder$kotlinpoet", "(C)Z", "isSingleCharNoArgPlaceholder", "isSingleCharNoArgPlaceholder$kotlinpoet", "isPlaceholder", "isPlaceholder$kotlinpoet", "(Ljava/lang/String;)Z", "nextPotentialPlaceholderPosition", "startIndex", "nextPotentialPlaceholderPosition$kotlinpoet", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder() {
            return new Builder();
        }

        public final CodeBlock getEMPTY$kotlinpoet() {
            return CodeBlock.EMPTY;
        }

        public final boolean isMultiCharNoArgPlaceholder$kotlinpoet(char c) {
            return c == '%';
        }

        public final boolean isPlaceholder$kotlinpoet(String str) {
            str.getClass();
            return (str.length() == 1 && isSingleCharNoArgPlaceholder$kotlinpoet(StringsKt.first(str))) || (str.length() == 2 && isMultiCharNoArgPlaceholder$kotlinpoet(StringsKt.first(str)));
        }

        public final boolean isSingleCharNoArgPlaceholder$kotlinpoet(char c) {
            return UtilKt.isOneOf$default(Character.valueOf(c), (char) 8677, (char) 8676, (char) 171, (char) 187, null, null, 48, null);
        }

        public final int nextPotentialPlaceholderPosition$kotlinpoet(String str, int i) {
            str.getClass();
            return StringsKt__StringsKt.indexOfAny$default(str, new char[]{'%', 171, 187, 8677, 8676}, i, false, 4, null);
        }

        public final CodeBlock of(String format, Object... args) {
            format.getClass();
            args.getClass();
            return new Builder().add(format, Arrays.copyOf(args, args.length)).build();
        }

        private Companion() {
        }
    }

    private CodeBlock(List<String> list, List<? extends Object> list2) {
        this.formatParts = list;
        this.args = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toString$lambda$5(CodeBlock codeBlock, CodeWriter codeWriter) throws Throwable {
        codeBlock.getClass();
        codeWriter.getClass();
        CodeWriter.emitCode$default(codeWriter, codeBlock, false, false, false, 14, null);
        return Unit.INSTANCE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(CodeBlock.class, other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public final List<Object> getArgs$kotlinpoet() {
        return this.args;
    }

    public final List<String> getFormatParts$kotlinpoet() {
        return this.formatParts;
    }

    public final boolean hasStatements$kotlinpoet() {
        List<String> list = this.formatParts;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((String) it.next(), "«")) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final boolean isEmpty() {
        return this.formatParts.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final CodeBlock replaceAll$kotlinpoet(String oldValue, String newValue) {
        oldValue.getClass();
        newValue.getClass();
        List<String> list = this.formatParts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.replace$default((String) it.next(), oldValue, newValue));
        }
        return new CodeBlock(arrayList, this.args);
    }

    public final Builder toBuilder() {
        Builder builder = new Builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder.getFormatParts$kotlinpoet(), this.formatParts);
        builder.getArgs$kotlinpoet().addAll(this.args);
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            CodeWriter.emitCode$default(codeWriter, this, false, false, false, 14, null);
            try {
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(codeWriter, null);
                return sb.toString();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(codeWriter, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            codeWriter = codeWriter;
        }
    }

    public final String toString$kotlinpoet(CodeWriter codeWriter) {
        codeWriter.getClass();
        return CodeWriterKt.buildCodeString(codeWriter, new CodecsKt$$ExternalSyntheticLambda2(this, 5));
    }

    public final CodeBlock trim$kotlinpoet() {
        int size = this.formatParts.size();
        int i = 0;
        while (i < size && NO_ARG_PLACEHOLDERS.contains(this.formatParts.get(i))) {
            i++;
        }
        while (i < size && NO_ARG_PLACEHOLDERS.contains(this.formatParts.get(size - 1))) {
            size--;
        }
        return (i > 0 || size < this.formatParts.size()) ? new CodeBlock(this.formatParts.subList(i, size), this.args) : this;
    }

    public final CodeBlock withoutPrefix$kotlinpoet(CodeBlock prefix) {
        prefix.getClass();
        if (this.formatParts.size() >= prefix.formatParts.size() && this.args.size() >= prefix.args.size()) {
            int i = 0;
            int i2 = 0;
            String strSubstring = null;
            for (Object obj : prefix.formatParts) {
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                if (Intrinsics.areEqual(this.formatParts.get(i), str)) {
                    if (!StringsKt.startsWith$default(str, "%") && !INSTANCE.isMultiCharNoArgPlaceholder$kotlinpoet(str.charAt(1))) {
                        if (Intrinsics.areEqual(this.args.get(i2), prefix.args.get(i2))) {
                            i2++;
                        }
                    }
                    i = i3;
                } else if (i == prefix.formatParts.size() - 1 && StringsKt.startsWith$default(this.formatParts.get(i), str)) {
                    strSubstring = this.formatParts.get(i).substring(str.length());
                    if (!StringsKt.startsWith$default(str, "%")) {
                    }
                    i = i3;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            int size = this.formatParts.size();
            for (int size2 = prefix.formatParts.size(); size2 < size; size2++) {
                arrayList.add(this.formatParts.get(size2));
            }
            ArrayList arrayList2 = new ArrayList();
            int size3 = this.args.size();
            for (int size4 = prefix.args.size(); size4 < size3; size4++) {
                arrayList2.add(this.args.get(size4));
            }
            return new CodeBlock(arrayList, arrayList2);
        }
        return null;
    }

    public /* synthetic */ CodeBlock(List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2);
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010\u001eJ'\u0010\"\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030 ¢\u0006\u0004\b\"\u0010#J-\u0010&\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b&\u0010'J-\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u00042\u0016\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b)\u0010'J\r\u0010*\u001a\u00020\u0000¢\u0006\u0004\b*\u0010+J-\u0010,\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010$\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b,\u0010'J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b&\u0010/J\r\u00100\u001a\u00020\u0000¢\u0006\u0004\b0\u0010+J\r\u00101\u001a\u00020\u0000¢\u0006\u0004\b1\u0010+J\r\u00102\u001a\u00020-¢\u0006\u0004\b2\u00103R \u00105\u001a\b\u0012\u0004\u0012\u00020\u0004048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u00106\u001a\u0004\b9\u00108¨\u0006:"}, d2 = {"Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "", "<init>", "()V", "", "format", "", "c", "arg", "", "addArgument", "(Ljava/lang/String;CLjava/lang/Object;)V", "o", "argToName", "(Ljava/lang/Object;)Ljava/lang/String;", "argToLiteral", "(Ljava/lang/Object;)Ljava/lang/Object;", "argToString", "", "formatNumericValue", "(Ljava/lang/Number;)Ljava/lang/Object;", "logDeprecationWarning", "(Ljava/lang/Object;)V", "Lcom/squareup/kotlinpoet/TypeName;", "argToType", "(Ljava/lang/Object;)Lcom/squareup/kotlinpoet/TypeName;", "withOpeningBrace", "(Ljava/lang/String;)Ljava/lang/String;", "", "isEmpty", "()Z", "isNotEmpty", "", "arguments", "addNamed", "(Ljava/lang/String;Ljava/util/Map;)Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "", "args", "add", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "controlFlow", "beginControlFlow", "endControlFlow", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "addStatement", "Lcom/squareup/kotlinpoet/CodeBlock;", "codeBlock", "(Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "indent", "unindent", InAppPurchaseConstants.METHOD_BUILD, "()Lcom/squareup/kotlinpoet/CodeBlock;", "", "formatParts", "Ljava/util/List;", "getFormatParts$kotlinpoet", "()Ljava/util/List;", "getArgs$kotlinpoet", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private final List<String> formatParts = new ArrayList();
        private final List<Object> args = new ArrayList();

        private final void addArgument(String format, char c, Object arg) {
            if (c == 'N') {
                this.args.add(UtilKt.escapeIfNecessary$default(argToName(arg), false, 1, null));
                return;
            }
            if (c == 'L') {
                this.args.add(argToLiteral(arg));
                return;
            }
            if (c == 'S') {
                this.args.add(argToString(arg));
                return;
            }
            if (c == 'P') {
                List<Object> list = this.args;
                if (!(arg instanceof CodeBlock)) {
                    arg = argToString(arg);
                }
                list.add(arg);
                return;
            }
            if (c == 'T') {
                this.args.add(argToType(arg));
            } else if (c == 'M') {
                this.args.add(arg);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Home$$ExternalSyntheticBUOutline0.m("invalid format string: '%s'", Arrays.copyOf(new Object[]{format}, 1));
            }
        }

        private final Object argToLiteral(Object o) {
            return o instanceof Number ? formatNumericValue((Number) o) : o;
        }

        private final String argToName(Object o) {
            if (o instanceof CharSequence) {
                return o.toString();
            }
            if (o instanceof ParameterSpec) {
                return ((ParameterSpec) o).getName();
            }
            if (o instanceof PropertySpec) {
                return ((PropertySpec) o).getName();
            }
            if (o instanceof FunSpec) {
                return ((FunSpec) o).getName();
            }
            if (!(o instanceof TypeSpec)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m("expected name but was ", o));
                return null;
            }
            String name = ((TypeSpec) o).getName();
            name.getClass();
            return name;
        }

        private final String argToString(Object o) {
            if (o != null) {
                return o.toString();
            }
            return null;
        }

        private final TypeName argToType(Object o) {
            if (o instanceof TypeName) {
                return (TypeName) o;
            }
            if (o instanceof TypeMirror) {
                logDeprecationWarning(o);
                return TypeNames.get((TypeMirror) o);
            }
            if (o instanceof Element) {
                logDeprecationWarning(o);
                TypeMirror typeMirrorAsType = ((Element) o).asType();
                typeMirrorAsType.getClass();
                return TypeNames.get(typeMirrorAsType);
            }
            if (o instanceof Type) {
                return TypeNames.get((Type) o);
            }
            if (o instanceof KClass) {
                return TypeNames.get((KClass<?>) o);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m("expected type but was ", o));
            return null;
        }

        private final Object formatNumericValue(Number o) {
            String str;
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormatSymbols.setGroupingSeparator('_');
            decimalFormatSymbols.setMinusSign('-');
            boolean z = o instanceof Float;
            int iMax = 0;
            if (z) {
                BigDecimal bigDecimal = new BigDecimal(String.valueOf(o.floatValue()));
                iMax = Math.max((bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros()).scale(), 1);
            } else if (o instanceof Double) {
                BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(o.doubleValue()));
                iMax = Math.max((bigDecimal2.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal2.stripTrailingZeros()).scale(), 1);
            }
            if (z || (o instanceof Double)) {
                str = "###,##0.0" + StringsKt__StringsJVMKt.repeat("#", iMax - 1);
            } else {
                str = "###,##0";
            }
            return new DecimalFormat(str, decimalFormatSymbols).format(o);
        }

        private final void logDeprecationWarning(Object o) {
            System.out.println((Object) ("Deprecation warning: converting " + o + " to TypeName. Conversion of TypeMirror and TypeElement is deprecated in KotlinPoet, use kotlin-metadata APIs instead."));
        }

        private final String withOpeningBrace(String str) {
            int length = str.length();
            do {
                length--;
                if (-1 >= length) {
                    break;
                }
                if (str.charAt(length) == '{') {
                    return str.concat("\n");
                }
            } while (str.charAt(length) != '}');
            return str.concat(" {\n");
        }

        public final Builder add(String format, Object... args) {
            int i;
            format.getClass();
            args.getClass();
            int[] iArr = new int[args.length];
            int i2 = 0;
            boolean z = false;
            int i3 = 0;
            boolean z2 = false;
            while (i2 < format.length()) {
                Companion companion = CodeBlock.INSTANCE;
                if (companion.isSingleCharNoArgPlaceholder$kotlinpoet(format.charAt(i2))) {
                    this.formatParts.add(String.valueOf(format.charAt(i2)));
                    i2++;
                } else {
                    if (format.charAt(i2) == '%') {
                        int i4 = i2 + 1;
                        int i5 = i4;
                        while (i5 < format.length()) {
                            int i6 = i5 + 1;
                            char cCharAt = format.charAt(i5);
                            if ('0' > cCharAt || cCharAt >= ':') {
                                if (!CodeBlock.INSTANCE.isMultiCharNoArgPlaceholder$kotlinpoet(cCharAt)) {
                                    if (i4 < i5) {
                                        int i7 = Integer.parseInt(format.substring(i4, i5)) - 1;
                                        if (args.length != 0) {
                                            int length = i7 % args.length;
                                            iArr[length] = iArr[length] + 1;
                                        }
                                        int i8 = i3;
                                        i3 = i7;
                                        i = i8;
                                        z2 = true;
                                    } else {
                                        i = i3 + 1;
                                        z = true;
                                    }
                                    if (i3 < 0 || i3 >= args.length) {
                                        StringBuilder sb = new StringBuilder("index ");
                                        sb.append(i3 + 1);
                                        sb.append(" for '");
                                        sb.append(format.substring(i2, i6));
                                        sb.append("' not in range (received ");
                                        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(args.length, " arguments)", sb));
                                        return null;
                                    }
                                    if (z2 && z) {
                                        Utf8$$ExternalSyntheticBUOutline0.m$2("cannot mix indexed and positional parameters");
                                        return null;
                                    }
                                    addArgument(format, cCharAt, args[i3]);
                                    this.formatParts.add("%" + cCharAt);
                                    i3 = i;
                                } else {
                                    if (i4 != i5) {
                                        Utf8$$ExternalSyntheticBUOutline0.m$2("%% may not have an index");
                                        return null;
                                    }
                                    this.formatParts.add("%" + cCharAt);
                                }
                                i2 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) Fragment$$ExternalSyntheticOutline1.m('\'', "dangling format characters in '", format));
                        return null;
                    }
                    int iNextPotentialPlaceholderPosition$kotlinpoet = companion.nextPotentialPlaceholderPosition$kotlinpoet(format, i2 + 1);
                    if (iNextPotentialPlaceholderPosition$kotlinpoet == -1) {
                        iNextPotentialPlaceholderPosition$kotlinpoet = format.length();
                    }
                    this.formatParts.add(format.substring(i2, iNextPotentialPlaceholderPosition$kotlinpoet));
                    i2 = iNextPotentialPlaceholderPosition$kotlinpoet;
                }
            }
            if (z && i3 < args.length) {
                Utf8$$ExternalSyntheticBUOutline0.m(Fragment$$ExternalSyntheticOutline1.m65m(i3, "unused arguments: expected ", ", received "), args.length);
                return null;
            }
            if (z2) {
                ArrayList arrayList = new ArrayList();
                int length2 = args.length;
                for (int i9 = 0; i9 < length2; i9++) {
                    if (iArr[i9] == 0) {
                        arrayList.add("%" + (i9 + 1));
                    }
                }
                String str = arrayList.size() == 1 ? "" : "s";
                if (!arrayList.isEmpty()) {
                    Utf8$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m5m("unused argument", str, ": "), CollectionsKt.joinToString$default(arrayList, ", ", null, null, null, 62));
                    return null;
                }
            }
            return this;
        }

        public final Builder addNamed(String format, Map<String, ?> arguments) {
            int i;
            format.getClass();
            arguments.getClass();
            for (String str : arguments.keySet()) {
                if (!CodeBlock.LOWERCASE.matches(str)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m("argument '", str, "' must start with a lowercase character"));
                    return null;
                }
            }
            int last = 0;
            while (last < format.length()) {
                Companion companion = CodeBlock.INSTANCE;
                int iNextPotentialPlaceholderPosition$kotlinpoet = companion.nextPotentialPlaceholderPosition$kotlinpoet(format, last);
                if (iNextPotentialPlaceholderPosition$kotlinpoet == -1) {
                    this.formatParts.add(format.substring(last, format.length()));
                    return this;
                }
                if (last != iNextPotentialPlaceholderPosition$kotlinpoet) {
                    this.formatParts.add(format.substring(last, iNextPotentialPlaceholderPosition$kotlinpoet));
                    last = iNextPotentialPlaceholderPosition$kotlinpoet;
                }
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) format, ':', last, false, 4, (Object) null);
                MatchResult matchResultMatchEntire = iIndexOf$default != -1 ? CodeBlock.NAMED_ARGUMENT.matchEntire(format.substring(last, RangesKt.coerceAtMost(iIndexOf$default + 2, format.length()))) : null;
                if (matchResultMatchEntire != null) {
                    String str2 = matchResultMatchEntire.getGroupValues().get(1);
                    if (!arguments.containsKey(str2)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m("Missing named argument for %", str2));
                        return null;
                    }
                    char cFirst = StringsKt.first(matchResultMatchEntire.getGroupValues().get(2));
                    addArgument(format, cFirst, arguments.get(str2));
                    this.formatParts.add("%" + cFirst);
                    last += matchResultMatchEntire.getRange().getLast() + 1;
                } else {
                    if (companion.isSingleCharNoArgPlaceholder$kotlinpoet(format.charAt(last))) {
                        i = last + 1;
                        this.formatParts.add(format.substring(last, i));
                    } else {
                        if (last >= format.length() - 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$2("dangling % at end");
                            return null;
                        }
                        int i2 = last + 1;
                        if (!companion.isMultiCharNoArgPlaceholder$kotlinpoet(format.charAt(i2))) {
                            throw new IllegalArgumentException(("unknown format %" + format.charAt(i2) + " at " + i2 + " in '" + format + '\'').toString());
                        }
                        i = last + 2;
                        this.formatParts.add(format.substring(last, i));
                    }
                    last = i;
                }
            }
            return this;
        }

        public final Builder addStatement(String format, Object... args) {
            format.getClass();
            args.getClass();
            add("«", new Object[0]);
            add(format, Arrays.copyOf(args, args.length));
            add("\n»", new Object[0]);
            return this;
        }

        public final Builder beginControlFlow(String controlFlow, Object... args) {
            controlFlow.getClass();
            args.getClass();
            add(withOpeningBrace(controlFlow), Arrays.copyOf(args, args.length));
            indent();
            return this;
        }

        public final CodeBlock build() {
            return new CodeBlock(UtilKt.toImmutableList(this.formatParts), UtilKt.toImmutableList(this.args), null);
        }

        public final Builder endControlFlow() {
            unindent();
            add("}\n", new Object[0]);
            return this;
        }

        public final List<Object> getArgs$kotlinpoet() {
            return this.args;
        }

        public final List<String> getFormatParts$kotlinpoet() {
            return this.formatParts;
        }

        public final Builder indent() {
            this.formatParts.add("⇥");
            return this;
        }

        public final boolean isEmpty() {
            return this.formatParts.isEmpty();
        }

        public final boolean isNotEmpty() {
            return !isEmpty();
        }

        public final Builder unindent() {
            this.formatParts.add("⇤");
            return this;
        }

        public final Builder add(CodeBlock codeBlock) {
            codeBlock.getClass();
            CollectionsKt__MutableCollectionsKt.addAll(this.formatParts, codeBlock.getFormatParts$kotlinpoet());
            this.args.addAll(codeBlock.getArgs$kotlinpoet());
            return this;
        }
    }
}
