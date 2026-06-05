package com.squareup.kotlinpoet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a+\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u001a\u0010\u000e\u001a\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "part", "extractMemberName", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/squareup/kotlinpoet/CodeWriter;", "codeWriter", "Lkotlin/Function1;", "", "builderAction", "buildCodeString", "(Lcom/squareup/kotlinpoet/CodeWriter;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "NO_PACKAGE", "Ljava/lang/String;", "Lcom/squareup/kotlinpoet/TypeName;", "NULLABLE_ANY", "Lcom/squareup/kotlinpoet/TypeName;", "getNULLABLE_ANY", "()Lcom/squareup/kotlinpoet/TypeName;", "kotlinpoet"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class CodeWriterKt {
    private static final String NO_PACKAGE = new String();
    private static final TypeName NULLABLE_ANY = TypeName.copy$default(TypeNames.ANY, true, null, 2, null);

    public static final String buildCodeString(CodeWriter codeWriter, Function1<? super CodeWriter, Unit> function1) {
        codeWriter.getClass();
        function1.getClass();
        StringBuilder sb = new StringBuilder();
        LineWrapper lineWrapper = new LineWrapper(sb, "  ", Integer.MAX_VALUE);
        try {
            LineWrapper lineWrapper2 = codeWriter.out;
            codeWriter.out = lineWrapper;
            function1.invoke(codeWriter);
            codeWriter.out = lineWrapper2;
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(lineWrapper, null);
            return sb.toString();
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractMemberName(String str) {
        if (!Character.isJavaIdentifierStart(str.charAt(0))) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) "not an identifier: ".concat(str));
            return null;
        }
        int length = str.length();
        if (1 <= length) {
            int i = 1;
            while (UtilKt.isIdentifier(str.substring(0, i))) {
                if (i != length) {
                    i++;
                }
            }
            return str.substring(0, i - 1);
        }
        return str;
    }

    public static final TypeName getNULLABLE_ANY() {
        return NULLABLE_ANY;
    }
}
