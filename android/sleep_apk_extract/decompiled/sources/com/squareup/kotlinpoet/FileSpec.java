package com.squareup.kotlinpoet;

import androidx.work.Data$$ExternalSyntheticLambda0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.squareup.kotlinpoet.AnnotationSpec;
import com.squareup.kotlinpoet.CodeBlock;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u00012\u00020\u00012\u00020\u00012\u00020\u0001:\u0002MLB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R \u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R \u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b)\u0010#R \u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010#R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00102\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0017R\u0017\u00105\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b5\u00103\u001a\u0004\b6\u0010\u0017R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\u001e8\u0006¢\u0006\f\n\u0004\b7\u0010!\u001a\u0004\b8\u0010#R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0015098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b>\u0010/\u001a\u0004\b?\u00101R\u0017\u0010@\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b@\u0010BR \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020D0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010\u001dR\u0014\u0010F\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00103R\u0014\u0010G\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u00103R\u0017\u0010H\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\bH\u00103\u001a\u0004\bI\u0010\u0017R\u001b\u0010K\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030J\u0012\u0004\u0012\u00020\u00010C8\u0016X\u0096\u0005¨\u0006N"}, d2 = {"Lcom/squareup/kotlinpoet/FileSpec;", "", "Lcom/squareup/kotlinpoet/FileSpec$Builder;", "builder", "Lcom/squareup/kotlinpoet/TagMap;", "tagMap", "<init>", "(Lcom/squareup/kotlinpoet/FileSpec$Builder;Ljava/util/Map;)V", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "", "writeTo", "(Ljava/lang/Appendable;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/squareup/kotlinpoet/CodeWriter;", "codeWriter", "collectingImports", "emit", "(Lcom/squareup/kotlinpoet/CodeWriter;Z)V", "Ljava/util/Map;", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "Lcom/squareup/kotlinpoet/TypeSpec;", "typeSpecs", "getTypeSpecs", "Lcom/squareup/kotlinpoet/PropertySpec;", "propertySpecs", "getPropertySpecs", "Lcom/squareup/kotlinpoet/FunSpec;", "funSpecs", "getFunSpecs", "Lcom/squareup/kotlinpoet/CodeBlock;", "comment", "Lcom/squareup/kotlinpoet/CodeBlock;", "getComment", "()Lcom/squareup/kotlinpoet/CodeBlock;", "packageName", "Ljava/lang/String;", "getPackageName", "name", "getName", "members", "getMembers", "", "defaultImports", "Ljava/util/Set;", "getDefaultImports", "()Ljava/util/Set;", SDKConstants.PARAM_A2U_BODY, "getBody", "isScript", "Z", "()Z", "", "Lcom/squareup/kotlinpoet/Import;", "memberImports", "indent", ShareConstants.MEDIA_EXTENSION, "relativePath", "getRelativePath", "Lkotlin/reflect/KClass;", "tags", "Companion", "Builder", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;
    private final CodeBlock body;
    private final CodeBlock comment;
    private final Set<String> defaultImports;
    private final String extension;
    private final List<FunSpec> funSpecs;
    private final String indent;
    private final boolean isScript;
    private final Map<String, Import> memberImports;
    private final List<Object> members;
    private final String name;
    private final String packageName;
    private final List<PropertySpec> propertySpecs;
    private final String relativePath;
    private final Map<KClass<?>, ? extends Object> tagMap;
    private final List<TypeSpec> typeSpecs;

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u0003B!\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\b\u0010\u001bR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010/R*\u00102\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u000301\u0012\u0004\u0012\u00020\u0003008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u0004068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0006¢\u0006\f\n\u0004\b;\u0010\u001e\u001a\u0004\b<\u0010 R\u001a\u0010=\u001a\u00020!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b=\u0010#\u001a\u0004\b>\u0010%¨\u0006?"}, d2 = {"Lcom/squareup/kotlinpoet/FileSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/Annotatable$Builder;", "", "", "packageName", "name", "", "isScript", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotationSpec", "addAnnotation", "(Lcom/squareup/kotlinpoet/AnnotationSpec;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "Lcom/squareup/kotlinpoet/TypeSpec;", "typeSpec", "addType", "(Lcom/squareup/kotlinpoet/TypeSpec;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "Lcom/squareup/kotlinpoet/FileSpec;", InAppPurchaseConstants.METHOD_BUILD, "()Lcom/squareup/kotlinpoet/FileSpec;", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "getName", "Z", "()Z", "", "annotations", "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "comment", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getComment$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "Ljava/util/TreeSet;", "Lcom/squareup/kotlinpoet/Import;", "memberImports", "Ljava/util/TreeSet;", "getMemberImports$kotlinpoet", "()Ljava/util/TreeSet;", "indent", "getIndent$kotlinpoet", "setIndent$kotlinpoet", "(Ljava/lang/String;)V", "", "Lkotlin/reflect/KClass;", "tags", "Ljava/util/Map;", "getTags", "()Ljava/util/Map;", "", "defaultImports", "Ljava/util/Set;", "getDefaultImports", "()Ljava/util/Set;", "members", "getMembers", SDKConstants.PARAM_A2U_BODY, "getBody$kotlinpoet", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder implements Taggable$Builder<Builder>, Annotatable$Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private final CodeBlock.Builder body;
        private final CodeBlock.Builder comment;
        private final Set<String> defaultImports;
        private String indent;
        private final boolean isScript;
        private final TreeSet<Import> memberImports;
        private final List<Object> members;
        private final String name;
        private final String packageName;
        private final Map<KClass<?>, Object> tags;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationSpec.UseSiteTarget.values().length];
                try {
                    iArr[AnnotationSpec.UseSiteTarget.FILE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Builder(String str, String str2, boolean z) {
            str.getClass();
            str2.getClass();
            this.packageName = str;
            this.name = str2;
            this.isScript = z;
            this.annotations = new ArrayList();
            CodeBlock.Companion companion = CodeBlock.INSTANCE;
            this.comment = companion.builder();
            this.memberImports = SetsKt.sortedSetOf(new Import[0]);
            this.indent = "  ";
            this.tags = new LinkedHashMap();
            this.defaultImports = new LinkedHashSet();
            this.members = new ArrayList();
            this.body = companion.builder();
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public Builder addAnnotation(AnnotationSpec annotationSpec) {
            annotationSpec.getClass();
            AnnotationSpec.UseSiteTarget useSiteTarget = annotationSpec.getUseSiteTarget();
            int i = useSiteTarget == null ? -1 : WhenMappings.$EnumSwitchMapping$0[useSiteTarget.ordinal()];
            if (i == -1) {
                annotationSpec = annotationSpec.toBuilder().useSiteTarget(AnnotationSpec.UseSiteTarget.FILE).build();
            } else if (i != 1) {
                throw new IllegalStateException(("Use-site target " + annotationSpec.getUseSiteTarget() + " not supported for file annotations.").toString());
            }
            getAnnotations().add(annotationSpec);
            return this;
        }

        public Builder addType(TypeSpec typeSpec) {
            typeSpec.getClass();
            if (this.isScript) {
                this.body.add("%L", typeSpec);
                return this;
            }
            this.members.add(typeSpec);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final FileSpec build() {
            for (AnnotationSpec annotationSpec : getAnnotations()) {
                if (annotationSpec.getUseSiteTarget() != AnnotationSpec.UseSiteTarget.FILE) {
                    throw new IllegalStateException(("Use-site target " + annotationSpec.getUseSiteTarget() + " not supported for file annotations.").toString());
                }
            }
            return new FileSpec(this, null, 2, 0 == true ? 1 : 0);
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        /* JADX INFO: renamed from: getBody$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getBody() {
            return this.body;
        }

        /* JADX INFO: renamed from: getComment$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getComment() {
            return this.comment;
        }

        public final Set<String> getDefaultImports() {
            return this.defaultImports;
        }

        /* JADX INFO: renamed from: getIndent$kotlinpoet, reason: from getter */
        public final String getIndent() {
            return this.indent;
        }

        public final TreeSet<Import> getMemberImports$kotlinpoet() {
            return this.memberImports;
        }

        public final List<Object> getMembers() {
            return this.members;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        @Override // com.squareup.kotlinpoet.Taggable$Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        /* JADX INFO: renamed from: isScript, reason: from getter */
        public final boolean getIsScript() {
            return this.isScript;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/squareup/kotlinpoet/FileSpec$Companion;", "", "<init>", "()V", "", "packageName", "fileName", "Lcom/squareup/kotlinpoet/FileSpec$Builder;", "builder", "(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/kotlinpoet/FileSpec$Builder;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder(String packageName, String fileName) {
            packageName.getClass();
            fileName.getClass();
            return new Builder(packageName, fileName, false);
        }

        private Companion() {
        }
    }

    private FileSpec(Builder builder, Map<KClass<?>, ? extends Object> map) {
        List listEmptyList;
        this.tagMap = map;
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
        List<Object> members = builder.getMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : members) {
            if (obj instanceof TypeSpec) {
                arrayList.add(obj);
            }
        }
        this.typeSpecs = UtilKt.toImmutableList(arrayList);
        List<Object> members2 = builder.getMembers();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : members2) {
            if (obj2 instanceof PropertySpec) {
                arrayList2.add(obj2);
            }
        }
        this.propertySpecs = UtilKt.toImmutableList(arrayList2);
        List<Object> members3 = builder.getMembers();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : members3) {
            if (obj3 instanceof FunSpec) {
                arrayList3.add(obj3);
            }
        }
        this.funSpecs = UtilKt.toImmutableList(arrayList3);
        this.comment = builder.getComment().build();
        this.packageName = builder.getPackageName();
        this.name = builder.getName();
        this.members = CollectionsKt.toList(builder.getMembers());
        this.defaultImports = CollectionsKt.toSet(builder.getDefaultImports());
        this.body = builder.getBody().build();
        this.isScript = builder.getIsScript();
        TreeSet<Import> memberImports$kotlinpoet = builder.getMemberImports$kotlinpoet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(memberImports$kotlinpoet, 10)), 16));
        for (Object obj4 : memberImports$kotlinpoet) {
            linkedHashMap.put(((Import) obj4).getQualifiedName(), obj4);
        }
        this.memberImports = linkedHashMap;
        this.indent = builder.getIndent();
        this.extension = this.isScript ? "kts" : "kt";
        StringBuilder sb = new StringBuilder();
        List listSplit$default = StringsKt__StringsKt.split$default(this.packageName, new char[]{'.'}, false, 0, 6, (Object) null);
        if (listSplit$default.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listSplit$default.listIterator(listSplit$default.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit$default, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append('/');
        }
        sb.append(this.name);
        sb.append('.');
        sb.append(this.extension);
        this.relativePath = sb.toString();
    }

    private final void emit(CodeWriter codeWriter, boolean collectingImports) throws Throwable {
        CodeWriter codeWriter2 = codeWriter;
        if (this.comment.isNotEmpty()) {
            codeWriter2.emitComment(this.comment);
        }
        if (!getAnnotations().isEmpty()) {
            codeWriter2.emitAnnotations(getAnnotations(), false);
            CodeWriter.emit$default(codeWriter2, "\n", false, 2, null);
        }
        codeWriter2.pushPackage(this.packageName);
        String strEscapeSegmentsIfNecessary$default = UtilKt.escapeSegmentsIfNecessary$default(this.packageName, (char) 0, 1, null);
        if (strEscapeSegmentsIfNecessary$default.length() > 0) {
            codeWriter2.emitCode("package %L\n", strEscapeSegmentsIfNecessary$default);
            CodeWriter.emit$default(codeWriter2, "\n", false, 2, null);
        }
        Function1 data$$ExternalSyntheticLambda0 = new Data$$ExternalSyntheticLambda0(24);
        if (!collectingImports && !this.defaultImports.isEmpty()) {
            Set<String> set = this.defaultImports;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(UtilKt.escapeSegmentsIfNecessary$default((String) it.next(), (char) 0, 1, null));
            }
            data$$ExternalSyntheticLambda0 = new CodecsKt$$ExternalSyntheticLambda2(arrayList, 7);
        }
        Collection<Import> collectionValues = codeWriter2.getImports().values();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Import) obj).getAlias() != null) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair = new Pair(arrayList2, arrayList3);
        List list = (List) pair.component1();
        SortedSet sortedSet = SequencesKt.toSortedSet(SequencesKt.filterNot(SequencesKt.map(CollectionsKt.asSequence((List) pair.component2()), new Data$$ExternalSyntheticLambda0(25)), data$$ExternalSyntheticLambda0));
        List list2 = list;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((Import) it2.next()).getImportString());
        }
        Set setPlus = SetsKt.plus((Set) sortedSet, (Iterable) CollectionsKt___CollectionsJvmKt.toSortedSet(arrayList4));
        if (!setPlus.isEmpty()) {
            Iterator it3 = setPlus.iterator();
            while (it3.hasNext()) {
                codeWriter2.emitCode("import %L", (String) it3.next());
                CodeWriter.emit$default(codeWriter2, "\n", false, 2, null);
            }
            CodeWriter.emit$default(codeWriter2, "\n", false, 2, null);
        }
        if (this.isScript) {
            CodeWriter.emitCode$default(codeWriter, this.body, false, false, true, 6, null);
        } else {
            int i = 0;
            for (Object obj2 : this.members) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (i > 0) {
                    CodeWriter.emit$default(codeWriter2, "\n", false, 2, null);
                }
                if (obj2 instanceof TypeSpec) {
                    TypeSpec.emit$kotlinpoet$default((TypeSpec) obj2, codeWriter2, null, null, false, 12, null);
                } else if (obj2 instanceof FunSpec) {
                    ((FunSpec) obj2).emit$kotlinpoet(codeWriter2, null, SetsKt.setOf(KModifier.PUBLIC), true);
                } else {
                    if (!(obj2 instanceof PropertySpec)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$1();
                        return;
                    }
                    PropertySpec.emit$kotlinpoet$default((PropertySpec) obj2, codeWriter2, SetsKt.setOf(KModifier.PUBLIC), false, false, false, false, 60, null);
                }
                codeWriter2 = codeWriter;
                i = i2;
            }
        }
        codeWriter.popPackage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String emit$lambda$10(Import r0) {
        r0.getClass();
        return r0.getImportString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean emit$lambda$7(String str) {
        str.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean emit$lambda$8(List list, String str) {
        list.getClass();
        str.getClass();
        return list.contains(StringsKt__StringsKt.substringBeforeLast$default(str, ".", (String) null, 2, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeTo$lambda$2(FileSpec fileSpec, CodeWriter codeWriter) throws Throwable {
        fileSpec.getClass();
        codeWriter.getClass();
        fileSpec.emit(codeWriter, true);
        return Unit.INSTANCE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(FileSpec.class, other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() throws Throwable {
        StringBuilder sb = new StringBuilder();
        writeTo(sb);
        return sb.toString();
    }

    public final void writeTo(Appendable out) throws Throwable {
        out.getClass();
        CodeWriter codeWriterWithCollectedImports = CodeWriter.INSTANCE.withCollectedImports(out, this.indent, this.memberImports, new CodecsKt$$ExternalSyntheticLambda2(this, 6));
        emit(codeWriterWithCollectedImports, false);
        codeWriterWithCollectedImports.close();
    }

    public /* synthetic */ FileSpec(Builder builder, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : map);
    }
}
