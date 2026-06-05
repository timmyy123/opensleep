package com.squareup.kotlinpoet;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081@\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B!\b\u0002\u0012\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0088\u0001\u0004\u0092\u0001\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/squareup/kotlinpoet/TagMap;", "", "", "Lkotlin/reflect/KClass;", "tags", "constructor-impl", "(Ljava/util/Map;)Ljava/util/Map;", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TagMap {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0086\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/squareup/kotlinpoet/TagMap$Companion;", "", "<init>", "()V", "invoke", "Lcom/squareup/kotlinpoet/TagMap;", "tags", "", "Lkotlin/reflect/KClass;", "invoke-BEeaP9Q", "(Ljava/util/Map;)Ljava/util/Map;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: invoke-BEeaP9Q, reason: not valid java name */
        public final Map<KClass<?>, ? extends Object> m952invokeBEeaP9Q(Map<KClass<?>, ? extends Object> tags) {
            tags.getClass();
            return TagMap.m951constructorimpl(UtilKt.toImmutableMap(tags));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Map<KClass<?>, ? extends Object> m951constructorimpl(Map<KClass<?>, ? extends Object> map) {
        return map;
    }
}
