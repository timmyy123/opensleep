package com.urbandroid.sleep.domain.shortcut;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.smartlight.common.ConfigurationKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b&\u0018\u0000 '2\u00020\u0001:\u0002('B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/urbandroid/sleep/domain/shortcut/Shortcut;", "Ljava/io/Serializable;", "<init>", "()V", "Lcom/urbandroid/sleep/domain/shortcut/Shortcut$Type;", "getType", "()Lcom/urbandroid/sleep/domain/shortcut/Shortcut$Type;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "execute", "(Landroid/content/Context;)V", "", "getIcon", "(Landroid/content/Context;)I", "getIconSmall", "", "getDisplayName", "(Landroid/content/Context;)Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "name", "Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "starred", "Z", "getStarred", "()Z", "setStarred", "(Z)V", "Companion", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Shortcut implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_NAME = "shortcut";
    private static final String EXTRA_SHORTCUT = "shortcut";
    private String name = DEFAULT_NAME;
    private boolean starred;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/domain/shortcut/Shortcut$Companion;", "", "<init>", "()V", "DEFAULT_NAME", "", "getDEFAULT_NAME", "()Ljava/lang/String;", "EXTRA_SHORTCUT", "getEXTRA_SHORTCUT", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getDEFAULT_NAME() {
            return Shortcut.DEFAULT_NAME;
        }

        public final String getEXTRA_SHORTCUT() {
            return Shortcut.EXTRA_SHORTCUT;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbandroid/sleep/domain/shortcut/Shortcut$Type;", "", "<init>", "(Ljava/lang/String;I)V", "SLEEP", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type SLEEP = new Type("SLEEP", 0);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{SLEEP};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shortcut)) {
            return false;
        }
        Shortcut shortcut = (Shortcut) other;
        return Intrinsics.areEqual(this.name, shortcut.name) && this.starred == shortcut.starred;
    }

    public abstract void execute(Context context);

    public abstract String getDisplayName(Context context);

    public abstract int getIcon(Context context);

    public abstract int getIconSmall(Context context);

    public final String getName() {
        return this.name;
    }

    public abstract Type getType();

    public int hashCode() {
        return Boolean.hashCode(this.starred) + (this.name.hashCode() * 31);
    }

    public final void setName(String str) {
        str.getClass();
        this.name = str;
    }

    public final void setStarred(boolean z) {
        this.starred = z;
    }

    public String toString() {
        return getType() + ";;;" + StringsKt.replace$default(StringsKt.replace$default(this.name, ";;;", ""), ConfigurationKt.DELIMITER, "") + ";;;" + this.starred;
    }
}
