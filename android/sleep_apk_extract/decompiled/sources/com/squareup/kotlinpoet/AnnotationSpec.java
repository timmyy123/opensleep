package com.squareup.kotlinpoet;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareInternalUtility;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u0003564B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010)\u001a\u0004\u0018\u00010(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00100\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001bR\u001b\u00103\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u000302\u0012\u0004\u0012\u00020\u0001018\u0016X\u0096\u0005¨\u00067"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec;", "", "Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "builder", "Lcom/squareup/kotlinpoet/TagMap;", "tagMap", "<init>", "(Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;Ljava/util/Map;)V", "Lcom/squareup/kotlinpoet/CodeWriter;", "codeWriter", "", "inline", "asParameter", "", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;ZZ)V", "emit", "toBuilder", "()Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/Map;", "Lcom/squareup/kotlinpoet/TypeName;", "typeName", "Lcom/squareup/kotlinpoet/TypeName;", "getTypeName", "()Lcom/squareup/kotlinpoet/TypeName;", "", "Lcom/squareup/kotlinpoet/CodeBlock;", "members", "Ljava/util/List;", "getMembers", "()Ljava/util/List;", "Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "useSiteTarget", "Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "getUseSiteTarget", "()Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "cachedString$delegate", "Lkotlin/Lazy;", "getCachedString", "cachedString", "", "Lkotlin/reflect/KClass;", "tags", "Companion", "UseSiteTarget", "Builder", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnnotationSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: cachedString$delegate, reason: from kotlin metadata */
    private final Lazy cachedString;
    private final List<CodeBlock> members;
    private final Map<KClass<?>, ? extends Object> tagMap;
    private final TypeName typeName;
    private final UseSiteTarget useSiteTarget;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec$Companion;", "", "<init>", "()V", "Lcom/squareup/kotlinpoet/ClassName;", "type", "Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "builder", "(Lcom/squareup/kotlinpoet/ClassName;)Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "Lkotlin/reflect/KClass;", "", "(Lkotlin/reflect/KClass;)Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder(KClass<? extends Annotation> type) {
            type.getClass();
            return builder(ClassNames.get(type));
        }

        private Companion() {
        }

        public final Builder builder(ClassName type) {
            type.getClass();
            return new Builder(type);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "", "keyword", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKeyword$kotlinpoet", "()Ljava/lang/String;", "FILE", "PROPERTY", "FIELD", "GET", "SET", "RECEIVER", "PARAM", "SETPARAM", "DELEGATE", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UseSiteTarget {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UseSiteTarget[] $VALUES;
        private final String keyword;
        public static final UseSiteTarget FILE = new UseSiteTarget("FILE", 0, ShareInternalUtility.STAGING_PARAM);
        public static final UseSiteTarget PROPERTY = new UseSiteTarget("PROPERTY", 1, "property");
        public static final UseSiteTarget FIELD = new UseSiteTarget("FIELD", 2, "field");
        public static final UseSiteTarget GET = new UseSiteTarget("GET", 3, "get");
        public static final UseSiteTarget SET = new UseSiteTarget("SET", 4, "set");
        public static final UseSiteTarget RECEIVER = new UseSiteTarget("RECEIVER", 5, "receiver");
        public static final UseSiteTarget PARAM = new UseSiteTarget("PARAM", 6, "param");
        public static final UseSiteTarget SETPARAM = new UseSiteTarget("SETPARAM", 7, "setparam");
        public static final UseSiteTarget DELEGATE = new UseSiteTarget("DELEGATE", 8, "delegate");

        private static final /* synthetic */ UseSiteTarget[] $values() {
            return new UseSiteTarget[]{FILE, PROPERTY, FIELD, GET, SET, RECEIVER, PARAM, SETPARAM, DELEGATE};
        }

        static {
            UseSiteTarget[] useSiteTargetArr$values = $values();
            $VALUES = useSiteTargetArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(useSiteTargetArr$values);
        }

        private UseSiteTarget(String str, int i, String str2) {
            this.keyword = str2;
        }

        public static UseSiteTarget valueOf(String str) {
            return (UseSiteTarget) Enum.valueOf(UseSiteTarget.class, str);
        }

        public static UseSiteTarget[] values() {
            return (UseSiteTarget[]) $VALUES.clone();
        }

        /* JADX INFO: renamed from: getKeyword$kotlinpoet, reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }
    }

    private AnnotationSpec(Builder builder, Map<KClass<?>, ? extends Object> map) {
        this.tagMap = map;
        this.typeName = builder.getTypeName();
        this.members = UtilKt.toImmutableList(builder.getMembers());
        this.useSiteTarget = builder.getUseSiteTarget();
        this.cachedString = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Url$$ExternalSyntheticLambda0(this, 10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String cachedString_delegate$lambda$1(AnnotationSpec annotationSpec) {
        annotationSpec.getClass();
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            annotationSpec.emit$kotlinpoet(codeWriter, true, false);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            return sb.toString();
        } finally {
        }
    }

    public static /* synthetic */ void emit$kotlinpoet$default(AnnotationSpec annotationSpec, CodeWriter codeWriter, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        annotationSpec.emit$kotlinpoet(codeWriter, z, z2);
    }

    private final String getCachedString() {
        return (String) this.cachedString.getValue();
    }

    public final void emit$kotlinpoet(CodeWriter codeWriter, boolean inline, boolean asParameter) {
        codeWriter.getClass();
        if (!asParameter) {
            CodeWriter.emit$default(codeWriter, "@", false, 2, null);
        }
        if (this.useSiteTarget != null) {
            CodeWriter.emit$default(codeWriter, this.useSiteTarget.getKeyword() + ':', false, 2, null);
        }
        codeWriter.emitCode("%T", this.typeName);
        if (!this.members.isEmpty() || asParameter) {
            String str = inline ? "" : "\n";
            String str2 = inline ? ", " : ",\n";
            String str3 = (inline || this.members.size() <= 1) ? "" : ",";
            CodeWriter.emit$default(codeWriter, "(", false, 2, null);
            if (this.members.size() > 1) {
                CodeWriter.emit$default(codeWriter, str, false, 2, null).indent(1);
            }
            List<CodeBlock> list = this.members;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CodeBlock codeBlockReplaceAll$kotlinpoet : list) {
                if (inline) {
                    codeBlockReplaceAll$kotlinpoet = codeBlockReplaceAll$kotlinpoet.replaceAll$kotlinpoet("[⇥|⇤]", "");
                }
                arrayList.add(codeBlockReplaceAll$kotlinpoet);
            }
            CodeWriter.emitCode$default(codeWriter, CodeBlocks.joinToCode$default(arrayList, str2, null, str3, 2, null), true, false, false, 12, null);
            if (this.members.size() > 1) {
                CodeWriter.emit$default(codeWriter.unindent(1), str, false, 2, null);
            }
            CodeWriter.emit$default(codeWriter, ")", false, 2, null);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(AnnotationSpec.class, other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public final UseSiteTarget getUseSiteTarget() {
        return this.useSiteTarget;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final Builder toBuilder() {
        Builder builder = new Builder(this.typeName);
        CollectionsKt__MutableCollectionsKt.addAll(builder.getMembers(), this.members);
        builder.setUseSiteTarget$kotlinpoet(this.useSiteTarget);
        builder.getTags().putAll(this.tagMap);
        return builder;
    }

    public String toString() {
        return getCachedString();
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u001d\"\u00020\u0016¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0010J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010 \u001a\u00020!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "typeName", "Lcom/squareup/kotlinpoet/TypeName;", "<init>", "(Lcom/squareup/kotlinpoet/TypeName;)V", "getTypeName$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "useSiteTarget", "Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "getUseSiteTarget$kotlinpoet", "()Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "setUseSiteTarget$kotlinpoet", "(Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;)V", "members", "", "Lcom/squareup/kotlinpoet/CodeBlock;", "getMembers", "()Ljava/util/List;", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "addMember", "format", "", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "codeBlock", InAppPurchaseConstants.METHOD_BUILD, "Lcom/squareup/kotlinpoet/AnnotationSpec;", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder implements Taggable$Builder<Builder> {
        private final List<CodeBlock> members;
        private final Map<KClass<?>, Object> tags;
        private final TypeName typeName;
        private UseSiteTarget useSiteTarget;

        public Builder(TypeName typeName) {
            typeName.getClass();
            this.typeName = typeName;
            this.members = new ArrayList();
            this.tags = new LinkedHashMap();
        }

        public final Builder addMember(String format, Object... args) {
            format.getClass();
            args.getClass();
            return addMember(CodeBlock.INSTANCE.of(format, Arrays.copyOf(args, args.length)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final AnnotationSpec build() {
            return new AnnotationSpec(this, null, 2, 0 == true ? 1 : 0);
        }

        public final List<CodeBlock> getMembers() {
            return this.members;
        }

        @Override // com.squareup.kotlinpoet.Taggable$Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        /* JADX INFO: renamed from: getTypeName$kotlinpoet, reason: from getter */
        public final TypeName getTypeName() {
            return this.typeName;
        }

        /* JADX INFO: renamed from: getUseSiteTarget$kotlinpoet, reason: from getter */
        public final UseSiteTarget getUseSiteTarget() {
            return this.useSiteTarget;
        }

        public final void setUseSiteTarget$kotlinpoet(UseSiteTarget useSiteTarget) {
            this.useSiteTarget = useSiteTarget;
        }

        public final Builder useSiteTarget(UseSiteTarget useSiteTarget) {
            this.useSiteTarget = useSiteTarget;
            return this;
        }

        public final Builder addMember(CodeBlock codeBlock) {
            codeBlock.getClass();
            this.members.add(codeBlock);
            return this;
        }
    }

    public /* synthetic */ AnnotationSpec(Builder builder, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : map);
    }
}
