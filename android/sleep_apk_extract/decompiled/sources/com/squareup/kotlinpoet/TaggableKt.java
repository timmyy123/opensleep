package com.squareup.kotlinpoet;

import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/TagMap;", "buildTagMap", "(Lcom/squareup/kotlinpoet/Taggable$Builder;)Ljava/util/Map;", "kotlinpoet"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TaggableKt {
    public static final Map<KClass<?>, ? extends Object> buildTagMap(Taggable$Builder<?> taggable$Builder) {
        taggable$Builder.getClass();
        return TagMap.INSTANCE.m952invokeBEeaP9Q(taggable$Builder.getTags());
    }
}
