package com.squareup.kotlinpoet;

import adamb.ogg.OggIO;
import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.work.Data$$ExternalSyntheticLambda0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\f\b\u0000\u0018\u0000 \u007f2\u00020\u0001:\u0001\u007fBo\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0007\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0006\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010\u001aJ\u0015\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020 ¢\u0006\u0004\b&\u0010$J#\u0010,\u001a\u00020\"2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J+\u00101\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\f2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020.0\f¢\u0006\u0004\b1\u00102J%\u00106\u001a\u00020\"2\f\u00104\u001a\b\u0012\u0004\u0012\u0002030'2\b\b\u0002\u00105\u001a\u00020\u0005¢\u0006\u0004\b6\u00107J\u001b\u0010:\u001a\u00020\"2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080'¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u00020\"2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080'¢\u0006\u0004\b<\u0010;J\u0015\u0010>\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0005¢\u0006\u0004\b>\u0010\u0018J-\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u00052\u0016\u0010B\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010A0@\"\u0004\u0018\u00010A¢\u0006\u0004\b>\u0010CJ3\u0010>\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010D\u001a\u00020*2\b\b\u0002\u0010E\u001a\u00020*2\b\b\u0002\u0010F\u001a\u00020*¢\u0006\u0004\b>\u0010GJ\u0015\u0010I\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\n¢\u0006\u0004\bI\u0010JJ\u001f\u0010L\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020*¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\"H\u0016¢\u0006\u0004\bN\u0010OJ\u001f\u0010R\u001a\u00020*2\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0002¢\u0006\u0004\bR\u0010SJ)\u0010U\u001a\u00020\"2\b\u0010T\u001a\u0004\u0018\u00010A2\u0006\u0010D\u001a\u00020*2\u0006\u0010F\u001a\u00020*H\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\"2\u0006\u0010H\u001a\u00020\nH\u0002¢\u0006\u0004\bW\u0010XJ\u0019\u0010Z\u001a\u0004\u0018\u00010\n2\u0006\u0010Y\u001a\u00020\u0005H\u0002¢\u0006\u0004\bZ\u0010[J\u001f\u0010]\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u0005H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\"H\u0002¢\u0006\u0004\b_\u0010OJ+\u0010`\u001a\u00020*2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020.0\fH\u0002¢\u0006\u0004\b`\u0010aJ!\u0010b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u0007H\u0002¢\u0006\u0004\bb\u0010cJ!\u0010d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0007H\u0002¢\u0006\u0004\bd\u0010cR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010eR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010fR&\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010fR\u0016\u0010\u0004\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010hR\u0016\u0010i\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010lR\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010eR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020\u001b0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00050q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR&\u0010u\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0'0t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010fR&\u0010v\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0'0t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010fR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00050q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010sR\u0016\u0010x\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010lR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010f\u001a\u0004\by\u0010cR\"\u0010z\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010j\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~¨\u0006\u0080\u0001"}, d2 = {"Lcom/squareup/kotlinpoet/CodeWriter;", "Ljava/io/Closeable;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "", "indent", "", "Lcom/squareup/kotlinpoet/Import;", "imports", "Lcom/squareup/kotlinpoet/ClassName;", "importedTypes", "", "Lcom/squareup/kotlinpoet/MemberName;", "importedMembers", "", "columnLimit", "<init>", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;I)V", "levels", "(I)Lcom/squareup/kotlinpoet/CodeWriter;", "unindent", "packageName", "pushPackage", "(Ljava/lang/String;)Lcom/squareup/kotlinpoet/CodeWriter;", "popPackage", "()Lcom/squareup/kotlinpoet/CodeWriter;", "Lcom/squareup/kotlinpoet/TypeSpec;", "type", "pushType", "(Lcom/squareup/kotlinpoet/TypeSpec;)Lcom/squareup/kotlinpoet/CodeWriter;", "popType", "Lcom/squareup/kotlinpoet/CodeBlock;", "codeBlock", "", "emitComment", "(Lcom/squareup/kotlinpoet/CodeBlock;)V", "kdocCodeBlock", "emitKdoc", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "", "inline", "emitAnnotations", "(Ljava/util/List;Z)V", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "implicitModifiers", "emitModifiers", "(Ljava/util/Set;Ljava/util/Set;)V", "Lcom/squareup/kotlinpoet/TypeName;", "contextReceivers", "suffix", "emitContextReceivers", "(Ljava/util/List;Ljava/lang/String;)V", "Lcom/squareup/kotlinpoet/TypeVariableName;", "typeVariables", "emitTypeVariables", "(Ljava/util/List;)V", "emitWhereBlock", "s", "emitCode", "format", "", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/CodeWriter;", "isConstantContext", "ensureTrailingNewline", "omitImplicitModifiers", "(Lcom/squareup/kotlinpoet/CodeBlock;ZZZ)Lcom/squareup/kotlinpoet/CodeWriter;", "className", "lookupName", "(Lcom/squareup/kotlinpoet/ClassName;)Ljava/lang/String;", "nonWrapping", "emit", "(Ljava/lang/String;Z)Lcom/squareup/kotlinpoet/CodeWriter;", "close", "()V", "canonical", "part", "emitStaticImportMember", "(Ljava/lang/String;Ljava/lang/String;)Z", "o", "emitLiteral", "(Ljava/lang/Object;ZZ)V", "importableType", "(Lcom/squareup/kotlinpoet/ClassName;)V", "simpleName", "resolve", "(Ljava/lang/String;)Lcom/squareup/kotlinpoet/ClassName;", "stackDepth", "stackClassName", "(ILjava/lang/String;)Lcom/squareup/kotlinpoet/ClassName;", "emitIndentation", "shouldEmitPublicModifier", "(Ljava/util/Set;Ljava/util/Set;)Z", "suggestedTypeImports", "()Ljava/util/Map;", "suggestedMemberImports", "Ljava/lang/String;", "Ljava/util/Map;", "Lcom/squareup/kotlinpoet/LineWrapper;", "Lcom/squareup/kotlinpoet/LineWrapper;", "indentLevel", "I", "kdoc", "Z", "comment", "", "typeSpecStack", "Ljava/util/List;", "", "memberImportNames", "Ljava/util/Set;", "", "importableTypes", "importableMembers", "referencedNames", "trailingNewline", "getImports", "statementLine", "getStatementLine", "()I", "setStatementLine", "(I)V", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CodeWriter implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean comment;
    private final Map<String, List<MemberName>> importableMembers;
    private final Map<String, List<ClassName>> importableTypes;
    private final Map<String, Set<MemberName>> importedMembers;
    private final Map<String, ClassName> importedTypes;
    private final Map<String, Import> imports;
    private final String indent;
    private int indentLevel;
    private boolean kdoc;
    private final Set<String> memberImportNames;
    private LineWrapper out;
    private String packageName;
    private final Set<String> referencedNames;
    private int statementLine;
    private boolean trailingNewline;
    private final List<TypeSpec> typeSpecStack;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J{\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005\"\u0004\b\u0000\u0010\u0004*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011JK\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00150\u0014\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017JI\u0010 \u001a\u00020\u001d2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00052\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u000b¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/squareup/kotlinpoet/CodeWriter$Companion;", "", "<init>", "()V", "T", "", "", "", "", "Lcom/squareup/kotlinpoet/Import;", "generatedImports", "Lkotlin/Function1;", "computeCanonicalName", "", "capitalizeAliases", "referencedNames", "generateImports", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;ZLjava/util/Set;)Ljava/util/Map;", "simpleName", "canonicalNamesToQualifiedNames", "", "Lkotlin/Pair;", "generateImportAliases", "(Ljava/lang/String;Ljava/util/Map;Z)Ljava/util/List;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "indent", "memberImports", "Lcom/squareup/kotlinpoet/CodeWriter;", "", "emitStep", "withCollectedImports", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Lcom/squareup/kotlinpoet/CodeWriter;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final <T> List<Pair<String, T>> generateImportAliases(String simpleName, Map<String, ? extends T> canonicalNamesToQualifiedNames, boolean capitalizeAliases) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(canonicalNamesToQualifiedNames.size()));
            Iterator<T> it = canonicalNamesToQualifiedNames.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                List listDropLast = CollectionsKt.dropLast(StringsKt__StringsKt.split$default((String) entry.getKey(), new char[]{'.'}, false, 0, 6, (Object) null), 1);
                ArrayList<String> arrayList = new ArrayList();
                for (T t : listDropLast) {
                    if (!Intrinsics.areEqual((String) t, "Companion")) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                for (String str : arrayList) {
                    if (str.length() > 0) {
                        str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                    }
                    arrayList2.add(str);
                }
                linkedHashMap.put(arrayList2, entry.getValue());
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            int i = 0;
            while (linkedHashMap2.size() != canonicalNamesToQualifiedNames.size()) {
                i++;
                linkedHashMap2.clear();
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    List list = (List) entry2.getKey();
                    Object value = entry2.getValue();
                    String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.takeLast(list, Math.min(i, list.size())), "", null, null, null, 62);
                    if (strJoinToString$default.length() > 0) {
                        char cCharAt = strJoinToString$default.charAt(0);
                        if (!capitalizeAliases) {
                            cCharAt = Character.toLowerCase(cCharAt);
                        }
                        strJoinToString$default = cCharAt + strJoinToString$default.substring(1);
                    }
                    linkedHashMap2.put(strJoinToString$default.concat(simpleName.length() > 0 ? Character.toUpperCase(simpleName.charAt(0)) + simpleName.substring(1) : simpleName), value);
                }
            }
            return MapsKt.toList(linkedHashMap2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final <T> Map<String, Set<T>> generateImports(Map<String, ? extends Set<? extends T>> map, Map<String, Import> map2, Function1<? super T, String> function1, boolean z, Set<String> set) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<? extends T>> entry : map.entrySet()) {
                String key = entry.getKey();
                Set<? extends T> value = entry.getValue();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(value, 10)), 16));
                for (T t : value) {
                    linkedHashMap2.put(function1.invoke(t), t);
                }
                String str = null;
                Object[] objArr = 0;
                if (linkedHashMap2.size() != 1 || set.contains(key)) {
                    Iterator<T> it = CodeWriter.INSTANCE.generateImportAliases(key, linkedHashMap2, z).iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        String str2 = (String) pair.component1();
                        OggIO oggIO = (Object) pair.component2();
                        String strEscapeAsAlias$default = UtilKt.escapeAsAlias$default(str2, false, 1, null);
                        String strInvoke = function1.invoke(oggIO);
                        map2.put(strInvoke, new Import(strInvoke, strEscapeAsAlias$default));
                        linkedHashMap.put(strEscapeAsAlias$default, SetsKt.setOf(oggIO));
                    }
                } else {
                    String str3 = (String) CollectionsKt.single(linkedHashMap2.keySet());
                    map2.put(str3, new Import(str3, str, 2, objArr == true ? 1 : 0));
                    linkedHashMap.put(key, value);
                }
            }
            return linkedHashMap;
        }

        public final CodeWriter withCollectedImports(Appendable out, String indent, Map<String, Import> memberImports, Function1<? super CodeWriter, Unit> emitStep) throws IOException {
            out.getClass();
            indent.getClass();
            memberImports.getClass();
            emitStep.getClass();
            CodeWriter codeWriter = new CodeWriter(NullAppendable.INSTANCE, indent, memberImports, null, null, Integer.MAX_VALUE, 24, null);
            emitStep.invoke(codeWriter);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map mapGenerateImports = generateImports(codeWriter.suggestedTypeImports(), linkedHashMap, new PropertyReference1Impl() { // from class: com.squareup.kotlinpoet.CodeWriter$Companion$withCollectedImports$importedTypes$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((ClassName) obj).getCanonicalName();
                }
            }, true, codeWriter.referencedNames);
            Map mapGenerateImports2 = generateImports(codeWriter.suggestedMemberImports(), linkedHashMap, new PropertyReference1Impl() { // from class: com.squareup.kotlinpoet.CodeWriter$Companion$withCollectedImports$importedMembers$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    throw FileInsert$$ExternalSyntheticOutline0.m(obj);
                }
            }, false, codeWriter.referencedNames);
            codeWriter.close();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, Import> entry : linkedHashMap.entrySet()) {
                if (!memberImports.containsKey(entry.getKey())) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            Map mapPlus = MapsKt.plus(memberImports, linkedHashMap2);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(mapGenerateImports.size()));
            for (Map.Entry entry2 : mapGenerateImports.entrySet()) {
                linkedHashMap3.put(entry2.getKey(), (ClassName) CollectionsKt.single((Iterable) entry2.getValue()));
            }
            return new CodeWriter(out, indent, mapPlus, linkedHashMap3, mapGenerateImports2, 0, 32, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CodeWriter(Appendable appendable, String str, Map<String, Import> map, Map<String, ClassName> map2, Map<String, ? extends Set<MemberName>> map3, int i) {
        appendable.getClass();
        str.getClass();
        map.getClass();
        map2.getClass();
        map3.getClass();
        this.indent = str;
        this.importedTypes = map2;
        this.importedMembers = map3;
        this.out = new LineWrapper(appendable, str, i);
        this.packageName = CodeWriterKt.NO_PACKAGE;
        this.typeSpecStack = new ArrayList();
        this.memberImportNames = new LinkedHashSet();
        this.importableTypes = MapsKt__MapWithDefaultKt.withDefaultMutable(new LinkedHashMap(), new Data$$ExternalSyntheticLambda0(22));
        this.importableMembers = MapsKt__MapWithDefaultKt.withDefaultMutable(new LinkedHashMap(), new Data$$ExternalSyntheticLambda0(23));
        this.referencedNames = new LinkedHashSet();
        Iterator<Map.Entry<String, Import>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) key, '.', 0, false, 6, (Object) null);
            if (iLastIndexOf$default >= 0) {
                this.memberImportNames.add(key.substring(0, iLastIndexOf$default));
            }
        }
        this.imports = map;
        this.statementLine = -1;
    }

    public static /* synthetic */ CodeWriter emit$default(CodeWriter codeWriter, String str, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        return codeWriter.emit(str, z);
    }

    public static /* synthetic */ CodeWriter emitCode$default(CodeWriter codeWriter, CodeBlock codeBlock, boolean z, boolean z2, boolean z3, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = false;
        }
        return codeWriter.emitCode(codeBlock, z, z2, z3);
    }

    private final void emitIndentation() throws IOException {
        int i = this.indentLevel;
        for (int i2 = 0; i2 < i; i2++) {
            LineWrapper.append$default(this.out, this.indent, 0, null, 6, null);
        }
    }

    private final void emitLiteral(Object o, boolean isConstantContext, boolean omitImplicitModifiers) throws Throwable {
        if (o instanceof TypeSpec) {
            TypeSpec.emit$kotlinpoet$default((TypeSpec) o, this, null, null, false, 12, null);
            return;
        }
        if (o instanceof AnnotationSpec) {
            ((AnnotationSpec) o).emit$kotlinpoet(this, true, isConstantContext);
            return;
        }
        if (o instanceof PropertySpec) {
            PropertySpec.emit$kotlinpoet$default((PropertySpec) o, this, SetsKt.emptySet(), false, false, false, false, 60, null);
            return;
        }
        if (o instanceof FunSpec) {
            ((FunSpec) o).emit$kotlinpoet(this, null, omitImplicitModifiers ? SetsKt.emptySet() : SetsKt.setOf(KModifier.PUBLIC), true);
        } else if (o instanceof CodeBlock) {
            emitCode$default(this, (CodeBlock) o, isConstantContext, false, false, 12, null);
        } else {
            emit$default(this, String.valueOf(o), false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void emitModifiers$default(CodeWriter codeWriter, Set set, Set set2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            set2 = SetsKt.emptySet();
        }
        codeWriter.emitModifiers(set, set2);
    }

    private final boolean emitStaticImportMember(String canonical, String part) throws IOException {
        String strSubstring = part.substring(1);
        if (strSubstring.length() != 0 && Character.isJavaIdentifierStart(strSubstring.charAt(0))) {
            Import r6 = this.imports.get(canonical + '.' + CodeWriterKt.extractMemberName(strSubstring));
            if (r6 != null) {
                if (r6.getAlias() != null) {
                    emit$default(this, StringsKt__StringsJVMKt.replaceFirst$default(strSubstring, CodeWriterKt.extractMemberName(strSubstring), r6.getAlias(), false, 4, null), false, 2, null);
                    return true;
                }
                emit$default(this, strSubstring, false, 2, null);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List importableMembers$lambda$1(String str) {
        str.getClass();
        return CollectionsKt.emptyList();
    }

    private final void importableType(ClassName className) {
        ClassName className2 = className.topLevelClassName();
        Import r1 = this.imports.get(className.getCanonicalName());
        String alias = r1 != null ? r1.getAlias() : null;
        String simpleName = alias == null ? className2.getSimpleName() : alias;
        if (this.importableMembers.containsKey(simpleName)) {
            return;
        }
        if (alias == null) {
            className = className2;
        }
        Map<String, List<ClassName>> map = this.importableTypes;
        map.put(simpleName, CollectionsKt.plus((Collection<? extends ClassName>) MapsKt.getValue(map, simpleName), className));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List importableTypes$lambda$0(String str) {
        str.getClass();
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ CodeWriter indent$default(CodeWriter codeWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return codeWriter.indent(i);
    }

    private final ClassName resolve(String simpleName) {
        int size = this.typeSpecStack.size() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                if (this.typeSpecStack.get(size).getNestedTypesSimpleNames$kotlinpoet().contains(simpleName)) {
                    return stackClassName(size, simpleName);
                }
                if (i < 0) {
                    break;
                }
                size = i;
            }
        }
        if (this.typeSpecStack.size() > 0) {
            TypeSpec typeSpec = this.typeSpecStack.get(0);
            if (Intrinsics.areEqual(typeSpec.getName(), simpleName)) {
                return new ClassName(this.packageName, simpleName);
            }
            if (typeSpec.getIsEnum() && typeSpec.getEnumConstants().keySet().contains(simpleName)) {
                String str = this.packageName;
                String name = typeSpec.getName();
                name.getClass();
                return new ClassName(str, name).nestedClass(simpleName);
            }
        }
        ClassName className = this.importedTypes.get(simpleName);
        if (className != null) {
            return className;
        }
        return null;
    }

    private final boolean shouldEmitPublicModifier(Set<? extends KModifier> modifiers, Set<? extends KModifier> implicitModifiers) {
        KModifier kModifier = KModifier.PUBLIC;
        if (modifiers.contains(kModifier)) {
            return true;
        }
        if (!(implicitModifiers.contains(kModifier) && modifiers.contains(KModifier.OVERRIDE)) && implicitModifiers.contains(kModifier)) {
            return !UtilKt.containsAnyOf(modifiers, KModifier.PRIVATE, KModifier.INTERNAL, KModifier.PROTECTED);
        }
        return false;
    }

    private final ClassName stackClassName(int stackDepth, String simpleName) {
        String str = this.packageName;
        String name = this.typeSpecStack.get(0).getName();
        name.getClass();
        ClassName className = new ClassName(str, name);
        int i = 1;
        if (1 <= stackDepth) {
            while (true) {
                String name2 = this.typeSpecStack.get(i).getName();
                name2.getClass();
                className = className.nestedClass(name2);
                if (i == stackDepth) {
                    break;
                }
                i++;
            }
        }
        return className.nestedClass(simpleName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Set<MemberName>> suggestedMemberImports() {
        Map<String, List<MemberName>> map = this.importableMembers;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), CollectionsKt.toSet((Iterable) entry.getValue()));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Set<ClassName>> suggestedTypeImports() {
        Map<String, List<ClassName>> map = this.importableTypes;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<ClassName>> entry : map.entrySet()) {
            if (!this.referencedNames.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), CollectionsKt.toSet((Iterable) entry2.getValue()));
        }
        return linkedHashMap2;
    }

    public static /* synthetic */ CodeWriter unindent$default(CodeWriter codeWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return codeWriter.unindent(i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    public final CodeWriter emit(String s, boolean nonWrapping) throws IOException {
        s.getClass();
        boolean z = true;
        for (String str : StringsKt__StringsKt.split$default(s, new char[]{'\n'}, false, 0, 6, (Object) null)) {
            if (!z) {
                if ((this.kdoc || this.comment) && this.trailingNewline) {
                    emitIndentation();
                    LineWrapper.append$default(this.out, this.kdoc ? " *" : "//", 0, null, 6, null);
                }
                this.out.newline();
                this.trailingNewline = true;
                int i = this.statementLine;
                if (i != -1) {
                    if (i == 0) {
                        indent(2);
                    }
                    this.statementLine++;
                }
            }
            if (str.length() != 0) {
                if (this.trailingNewline) {
                    emitIndentation();
                    if (this.kdoc) {
                        LineWrapper.append$default(this.out, " * ", 0, null, 6, null);
                    } else if (this.comment) {
                        LineWrapper.append$default(this.out, "// ", 0, null, 6, null);
                    }
                }
                LineWrapper lineWrapper = this.out;
                if (nonWrapping) {
                    lineWrapper.appendNonWrapping(str);
                } else {
                    boolean z2 = this.kdoc;
                    int i2 = this.indentLevel;
                    if (!z2) {
                        i2 += 2;
                    }
                    lineWrapper.append(str, i2, z2 ? " * " : "");
                }
                this.trailingNewline = false;
            }
            z = false;
        }
        return this;
    }

    public final void emitAnnotations(List<AnnotationSpec> annotations, boolean inline) throws IOException {
        annotations.getClass();
        Iterator<AnnotationSpec> it = annotations.iterator();
        while (it.hasNext()) {
            CodeWriter codeWriter = this;
            boolean z = inline;
            AnnotationSpec.emit$kotlinpoet$default(it.next(), codeWriter, z, false, 4, null);
            emit$default(codeWriter, z ? " " : "\n", false, 2, null);
            this = codeWriter;
            inline = z;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:108:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0231 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CodeWriter emitCode(CodeBlock codeBlock, boolean isConstantContext, boolean ensureTrailingNewline, boolean omitImplicitModifiers) throws Throwable {
        int i;
        codeBlock.getClass();
        ListIterator<String> listIterator = codeBlock.getFormatParts$kotlinpoet().listIterator();
        int i2 = 0;
        ClassName className = null;
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            int iHashCode = next.hashCode();
            boolean z = true;
            if (iHashCode != 171) {
                if (iHashCode != 187) {
                    if (iHashCode != 1184) {
                        if (iHashCode != 1227) {
                            if (iHashCode != 1230) {
                                if (iHashCode != 1231) {
                                    if (iHashCode != 8676) {
                                        if (iHashCode != 8677) {
                                            switch (iHashCode) {
                                                case 1223:
                                                    if (next.equals("%L")) {
                                                        i = i2 + 1;
                                                        emitLiteral(codeBlock.getArgs$kotlinpoet().get(i2), isConstantContext, omitImplicitModifiers);
                                                        i2 = i;
                                                    }
                                                    break;
                                                case 1224:
                                                    if (next.equals("%M")) {
                                                        codeBlock.getArgs$kotlinpoet().get(i2).getClass();
                                                        Events$$ExternalSyntheticBUOutline0.m();
                                                    }
                                                    break;
                                                case 1225:
                                                    if (next.equals("%N")) {
                                                        i = i2 + 1;
                                                        Object obj = codeBlock.getArgs$kotlinpoet().get(i2);
                                                        obj.getClass();
                                                        emit$default(this, (String) obj, false, 2, null);
                                                        i2 = i;
                                                    }
                                                    break;
                                            }
                                            return null;
                                        }
                                        if (next.equals("⇥")) {
                                            indent$default(this, 0, 1, null);
                                        }
                                        if (className == null) {
                                            if (StringsKt.startsWith$default(next, ".") && emitStaticImportMember(className.getCanonicalName(), next)) {
                                                className = null;
                                            } else {
                                                z = false;
                                            }
                                            if (!z) {
                                                className.getClass();
                                                className.emit$kotlinpoet(this);
                                                className = null;
                                            }
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            emit$default(this, next, false, 2, null);
                                        }
                                    } else if (next.equals("⇤")) {
                                        unindent$default(this, 0, 1, null);
                                    } else {
                                        if (className == null) {
                                        }
                                        if (z) {
                                        }
                                    }
                                } else if (next.equals("%T")) {
                                    i = i2 + 1;
                                    Object obj2 = codeBlock.getArgs$kotlinpoet().get(i2);
                                    obj2.getClass();
                                    TypeName typeNameCopy$default = (TypeName) obj2;
                                    if (typeNameCopy$default.isAnnotated()) {
                                        typeNameCopy$default.emitAnnotations$kotlinpoet(this);
                                        typeNameCopy$default = TypeName.copy$default(typeNameCopy$default, false, CollectionsKt.emptyList(), 1, null);
                                    }
                                    if ((typeNameCopy$default instanceof ClassName) && listIterator.hasNext() && !StringsKt.startsWith$default(codeBlock.getFormatParts$kotlinpoet().get(listIterator.nextIndex()), "%")) {
                                        ClassName className2 = (ClassName) typeNameCopy$default;
                                        if (this.memberImportNames.contains(className2.getCanonicalName())) {
                                            if (className != null) {
                                                Utf8$$ExternalSyntheticBUOutline0.m$3("pending type for static import?!");
                                                return null;
                                            }
                                            className = className2;
                                        }
                                        if (!z) {
                                        }
                                        typeNameCopy$default.emitNullable$kotlinpoet(this);
                                        i2 = i;
                                    } else {
                                        z = false;
                                        if (!z) {
                                            typeNameCopy$default.emit$kotlinpoet(this);
                                        }
                                        typeNameCopy$default.emitNullable$kotlinpoet(this);
                                        i2 = i;
                                    }
                                } else {
                                    if (className == null) {
                                    }
                                    if (z) {
                                    }
                                }
                            } else if (next.equals("%S")) {
                                i = i2 + 1;
                                String str = (String) codeBlock.getArgs$kotlinpoet().get(i2);
                                emit(str != null ? UtilKt.stringLiteralWithQuotes(str, false, isConstantContext) : "null", true);
                                i2 = i;
                            } else {
                                if (className == null) {
                                }
                                if (z) {
                                }
                            }
                        } else if (next.equals("%P")) {
                            i = i2 + 1;
                            Object obj3 = codeBlock.getArgs$kotlinpoet().get(i2);
                            String string$kotlinpoet = obj3 != null ? obj3 instanceof CodeBlock ? ((CodeBlock) obj3).toString$kotlinpoet(this) : (String) obj3 : null;
                            emit(string$kotlinpoet != null ? UtilKt.stringLiteralWithQuotes(string$kotlinpoet, true, isConstantContext) : "null", true);
                            i2 = i;
                        } else {
                            if (className == null) {
                            }
                            if (z) {
                            }
                        }
                    } else if (next.equals("%%")) {
                        emit$default(this, "%", false, 2, null);
                    } else {
                        if (className == null) {
                        }
                        if (z) {
                        }
                    }
                } else if (next.equals("»")) {
                    int i3 = this.statementLine;
                    if (i3 == -1) {
                        StringBuilder sb = new StringBuilder("\n            |Can't close a statement that hasn't been opened (closing » is not preceded by an\n            |opening «).\n            |Current code block:\n            |- Format parts: ");
                        List<String> formatParts$kotlinpoet = codeBlock.getFormatParts$kotlinpoet();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(formatParts$kotlinpoet, 10));
                        Iterator<T> it = formatParts$kotlinpoet.iterator();
                        while (it.hasNext()) {
                            arrayList.add(UtilKt.escapeCharacterLiterals((String) it.next()));
                        }
                        sb.append(arrayList);
                        sb.append("\n            |- Arguments: ");
                        sb.append(codeBlock.getArgs$kotlinpoet());
                        sb.append("\n            |\n            ");
                        Utf8$$ExternalSyntheticBUOutline0.m((Object) StringsKt__IndentKt.trimMargin$default(sb.toString(), null, 1, null));
                        return null;
                    }
                    if (i3 > 0) {
                        unindent(2);
                    }
                    this.statementLine = -1;
                } else {
                    if (className == null) {
                    }
                    if (z) {
                    }
                }
            } else if (!next.equals("«")) {
                if (className == null) {
                }
                if (z) {
                }
            } else {
                if (this.statementLine != -1) {
                    StringBuilder sb2 = new StringBuilder("\n            |Can't open a new statement until the current statement is closed (opening « followed\n            |by another « without a closing »).\n            |Current code block:\n            |- Format parts: ");
                    List<String> formatParts$kotlinpoet2 = codeBlock.getFormatParts$kotlinpoet();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(formatParts$kotlinpoet2, 10));
                    Iterator<T> it2 = formatParts$kotlinpoet2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(UtilKt.escapeCharacterLiterals((String) it2.next()));
                    }
                    sb2.append(arrayList2);
                    sb2.append("\n            |- Arguments: ");
                    sb2.append(codeBlock.getArgs$kotlinpoet());
                    sb2.append("\n            |\n            ");
                    Utf8$$ExternalSyntheticBUOutline0.m((Object) StringsKt__IndentKt.trimMargin$default(sb2.toString(), null, 1, null));
                    return null;
                }
                this.statementLine = 0;
            }
        }
        if (ensureTrailingNewline && this.out.getHasPendingSegments()) {
            emit$default(this, "\n", false, 2, null);
        }
        return this;
    }

    public final void emitComment(CodeBlock codeBlock) {
        codeBlock.getClass();
        this.trailingNewline = true;
        this.comment = true;
        try {
            emitCode$default(this, codeBlock, false, false, false, 14, null);
            emit$default(this, "\n", false, 2, null);
        } finally {
            this.comment = false;
        }
    }

    public final void emitContextReceivers(List<? extends TypeName> contextReceivers, String suffix) throws Throwable {
        contextReceivers.getClass();
        suffix.getClass();
        if (contextReceivers.isEmpty()) {
            return;
        }
        List<? extends TypeName> list = contextReceivers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodeBlock.INSTANCE.of("%T", (TypeName) it.next()));
        }
        emitCode$default(this, CodeBlocks.joinToCode$default(arrayList, null, "context(", ")", 1, null), false, false, false, 14, null);
        emit$default(this, suffix, false, 2, null);
    }

    public final void emitKdoc(CodeBlock kdocCodeBlock) throws IOException {
        kdocCodeBlock.getClass();
        if (kdocCodeBlock.isEmpty()) {
            return;
        }
        emit$default(this, "/**\n", false, 2, null);
        this.kdoc = true;
        try {
            emitCode$default(this, kdocCodeBlock, false, true, false, 10, null);
            this.kdoc = false;
            emit$default(this, " */\n", false, 2, null);
        } catch (Throwable th) {
            this.kdoc = false;
            throw th;
        }
    }

    public final void emitModifiers(Set<? extends KModifier> modifiers, Set<? extends KModifier> implicitModifiers) throws IOException {
        modifiers.getClass();
        implicitModifiers.getClass();
        if (shouldEmitPublicModifier(modifiers, implicitModifiers)) {
            emit$default(this, KModifier.PUBLIC.getKeyword(), false, 2, null);
            emit$default(this, " ", false, 2, null);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : modifiers) {
            if (((KModifier) obj) != KModifier.PUBLIC) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!implicitModifiers.contains((KModifier) obj2)) {
                arrayList2.add(obj2);
            }
        }
        KModifier[] kModifierArrValues = KModifier.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (KModifier kModifier : kModifierArrValues) {
            if (arrayList2.contains(kModifier)) {
                linkedHashSet.add(kModifier);
            }
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            emit$default(this, ((KModifier) it.next()).getKeyword(), false, 2, null);
            emit$default(this, " ", false, 2, null);
        }
    }

    public final void emitTypeVariables(List<TypeVariableName> typeVariables) throws Throwable {
        typeVariables.getClass();
        if (typeVariables.isEmpty()) {
            return;
        }
        emit$default(this, "<", false, 2, null);
        int i = 0;
        for (Object obj : typeVariables) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeVariableName typeVariableName = (TypeVariableName) obj;
            if (i > 0) {
                emit$default(this, ", ", false, 2, null);
            }
            if (typeVariableName.getVariance() != null) {
                emit$default(this, typeVariableName.getVariance().getKeyword() + ' ', false, 2, null);
            }
            if (typeVariableName.isReified()) {
                emit$default(this, "reified ", false, 2, null);
            }
            emitCode("%L", typeVariableName.getName());
            if (typeVariableName.getBounds().size() == 1 && !Intrinsics.areEqual(typeVariableName.getBounds().get(0), CodeWriterKt.getNULLABLE_ANY())) {
                emitCode(" : %T", typeVariableName.getBounds().get(0));
            }
            i = i2;
        }
        emit$default(this, ">", false, 2, null);
    }

    public final void emitWhereBlock(List<TypeVariableName> typeVariables) throws Throwable {
        typeVariables.getClass();
        if (typeVariables.isEmpty()) {
            return;
        }
        boolean z = true;
        for (TypeVariableName typeVariableName : typeVariables) {
            if (typeVariableName.getBounds().size() > 1) {
                for (TypeName typeName : typeVariableName.getBounds()) {
                    emitCode(!z ? ", " : " where ");
                    emitCode("%L : %T", typeVariableName.getName(), typeName);
                    z = false;
                }
            }
        }
    }

    public final Map<String, Import> getImports() {
        return this.imports;
    }

    public final int getStatementLine() {
        return this.statementLine;
    }

    public final CodeWriter indent(int levels) {
        this.indentLevel += levels;
        return this;
    }

    public final String lookupName(ClassName className) {
        className.getClass();
        ClassName classNameEnclosingClassName = className;
        boolean z = false;
        while (true) {
            if (classNameEnclosingClassName == null) {
                if (z) {
                    return className.getCanonicalName();
                }
                if (Intrinsics.areEqual(this.packageName, className.getPackageName())) {
                    Import r0 = this.imports.get(className.getCanonicalName());
                    if ((r0 != null ? r0.getAlias() : null) == null) {
                        this.referencedNames.add(className.topLevelClassName().getSimpleName());
                        return CollectionsKt.joinToString$default(className.getSimpleNames(), ".", null, null, null, 62);
                    }
                }
                if (!this.kdoc) {
                    importableType(className);
                }
                return className.getCanonicalName();
            }
            Import r2 = this.imports.get(classNameEnclosingClassName.getCanonicalName());
            String alias = r2 != null ? r2.getAlias() : null;
            String simpleName = alias == null ? classNameEnclosingClassName.getSimpleName() : alias;
            ClassName classNameResolve = resolve(simpleName);
            boolean z2 = classNameResolve != null;
            if (Intrinsics.areEqual(classNameResolve, classNameEnclosingClassName.copy(false, CollectionsKt.emptyList()))) {
                if (alias == null) {
                    this.referencedNames.add(className.topLevelClassName().getSimpleName());
                }
                return simpleName + '.' + CollectionsKt.joinToString$default(className.getSimpleNames().subList(classNameEnclosingClassName.getSimpleNames().size(), className.getSimpleNames().size()), ".", null, null, null, 62);
            }
            classNameEnclosingClassName = classNameEnclosingClassName.enclosingClassName();
            z = z2;
        }
    }

    public final CodeWriter popPackage() {
        if (this.packageName != CodeWriterKt.NO_PACKAGE) {
            this.packageName = CodeWriterKt.NO_PACKAGE;
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1("package already set: ", this.packageName);
        return null;
    }

    public final CodeWriter popType() {
        this.typeSpecStack.remove(r0.size() - 1);
        return this;
    }

    public final CodeWriter pushPackage(String packageName) {
        packageName.getClass();
        if (this.packageName == CodeWriterKt.NO_PACKAGE) {
            this.packageName = packageName;
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1("package already set: ", this.packageName);
        return null;
    }

    public final CodeWriter pushType(TypeSpec type) {
        type.getClass();
        this.typeSpecStack.add(type);
        return this;
    }

    public final void setStatementLine(int i) {
        this.statementLine = i;
    }

    public final CodeWriter unindent(int levels) {
        int i = this.indentLevel;
        if (i - levels >= 0) {
            this.indentLevel = i - levels;
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m(Fragment$$ExternalSyntheticOutline1.m65m(levels, "cannot unindent ", " from "), this.indentLevel);
        return null;
    }

    public /* synthetic */ CodeWriter(Appendable appendable, String str, Map map, Map map2, Map map3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(appendable, (i2 & 2) != 0 ? "  " : str, (i2 & 4) != 0 ? MapsKt.emptyMap() : map, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? 100 : i);
    }

    public final CodeWriter emitCode(String format, Object... args) throws Throwable {
        format.getClass();
        args.getClass();
        return emitCode$default(this, CodeBlock.INSTANCE.of(format, Arrays.copyOf(args, args.length)), false, false, false, 14, null);
    }

    public final CodeWriter emitCode(String s) throws Throwable {
        s.getClass();
        return emitCode$default(this, CodeBlock.INSTANCE.of(s, new Object[0]), false, false, false, 14, null);
    }
}
