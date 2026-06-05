package com.squareup.kotlinpoet;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\n\u0010\u0002\u001a\u00060\u0004j\u0002`\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002R\u0014\u0010\u0002\u001a\u00060\u0004j\u0002`\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/squareup/kotlinpoet/LineWrapper;", "Ljava/io/Closeable;", "out", "Lkotlin/text/Appendable;", "Ljava/lang/Appendable;", "indent", "", "columnLimit", "", "<init>", "(Ljava/lang/Appendable;Ljava/lang/String;I)V", "Ljava/lang/Appendable;", "closed", "", "segments", "", "indentLevel", "linePrefix", "hasPendingSegments", "getHasPendingSegments", "()Z", "append", "", "s", "appendNonWrapping", "newline", "close", "emitCurrentLine", "emitSegmentRange", "startIndex", "endIndex", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LineWrapper implements Closeable {
    private static final char[] SPECIAL_CHARACTERS = {' ', '\n', 183, 9826};
    private boolean closed;
    private final int columnLimit;
    private final String indent;
    private int indentLevel;
    private String linePrefix;
    private final Appendable out;
    private final List<String> segments;

    public LineWrapper(Appendable appendable, String str, int i) {
        appendable.getClass();
        str.getClass();
        this.out = appendable;
        this.indent = str;
        this.columnLimit = i;
        this.segments = CollectionsKt.mutableListOf("");
        this.indentLevel = -1;
        this.linePrefix = "";
    }

    public static /* synthetic */ void append$default(LineWrapper lineWrapper, String str, int i, String str2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        lineWrapper.append(str, i, str2);
    }

    private final void emitCurrentLine() throws IOException {
        int i = 0;
        int length = this.segments.get(0).length();
        int size = this.segments.size();
        int i2 = 1;
        while (true) {
            List<String> list = this.segments;
            if (i2 >= size) {
                emitSegmentRange(i, list.size());
                this.segments.clear();
                this.segments.add("");
                return;
            }
            String str = list.get(i2);
            int length2 = str.length() + length + 1;
            if (length2 > this.columnLimit) {
                emitSegmentRange(i, i2);
                length = (this.indent.length() * this.indentLevel) + str.length();
                i = i2;
            } else {
                length = length2;
            }
            i2++;
        }
    }

    private final void emitSegmentRange(int startIndex, int endIndex) throws IOException {
        Appendable appendable;
        if (startIndex > 0) {
            this.out.append("\n");
            int i = this.indentLevel;
            int i2 = 0;
            while (true) {
                appendable = this.out;
                if (i2 >= i) {
                    break;
                }
                appendable.append(this.indent);
                i2++;
            }
            appendable.append(this.linePrefix);
        }
        this.out.append(this.segments.get(startIndex));
        while (true) {
            startIndex++;
            if (startIndex >= endIndex) {
                return;
            }
            this.out.append(" ");
            this.out.append(this.segments.get(startIndex));
        }
    }

    public final void append(String s, int indentLevel, String linePrefix) throws IOException {
        s.getClass();
        linePrefix.getClass();
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return;
        }
        int i = 0;
        while (i < s.length()) {
            char cCharAt = s.charAt(i);
            if (cCharAt == 9826) {
                this.indentLevel = indentLevel;
                this.linePrefix = linePrefix;
                this.segments.add("");
            } else if (cCharAt == '\n') {
                newline();
            } else if (cCharAt == ' ' || cCharAt == 183) {
                List<String> list = this.segments;
                int size = list.size() - 1;
                list.set(size, list.get(size) + ' ');
            } else {
                int iIndexOfAny$default = StringsKt__StringsKt.indexOfAny$default(s, SPECIAL_CHARACTERS, i, false, 4, null);
                if (iIndexOfAny$default == -1) {
                    iIndexOfAny$default = s.length();
                }
                List<String> list2 = this.segments;
                int size2 = list2.size() - 1;
                list2.set(size2, list2.get(size2) + s.substring(i, iIndexOfAny$default));
                i = iIndexOfAny$default;
            }
            i++;
        }
    }

    public final void appendNonWrapping(String s) {
        s.getClass();
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return;
        }
        if (StringsKt.contains$default(s, "\n")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
            return;
        }
        List<String> list = this.segments;
        int size = list.size() - 1;
        list.set(size, list.get(size) + s);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        emitCurrentLine();
        this.closed = true;
    }

    public final boolean getHasPendingSegments() {
        return this.segments.size() != 1 || this.segments.get(0).length() > 0;
    }

    public final void newline() throws IOException {
        if (this.closed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("closed");
            return;
        }
        emitCurrentLine();
        this.out.append("\n");
        this.indentLevel = -1;
    }
}
