package com.google.home.google;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.serialization.TraitElementPayload;
import com.google.android.gms.internal.serialization.zzvo;
import com.google.home.CommandDescriptor;
import com.google.home.EventFactory;
import com.google.home.InternalTraitFactory;
import com.google.home.Trait;
import com.google.home.google.PlatformTrait;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u0089\u0001\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b\u0012\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u000b\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J%\u0010%\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0010¢\u0006\u0004\b%\u0010&R\u001e\u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u0019R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010+R'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b-\u0010.R/\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u000e8\u0006¢\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b0\u00101R'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b2\u0010.R#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u000b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b3\u0010.¨\u00064"}, d2 = {"Lcom/google/home/google/PlatformTraitFactory;", "Lcom/google/home/google/PlatformTrait;", "T", "", "A", "Lcom/google/home/InternalTraitFactory;", "", "Lcom/google/home/google/TraitId;", "traitId", "Lcom/google/home/google/Parser;", "parser", "", "Lcom/google/home/google/PlatformEnumAdapter;", "enumAdapters", "Lkotlin/Function3;", "Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/google/PlatformTraitClient;", "creator", "Lcom/google/home/EventFactory;", "supportedEvents", "Lcom/google/home/CommandDescriptor;", "commands", "<init>", "(Ljava/lang/String;Lcom/google/home/google/Parser;Ljava/util/Map;Lkotlin/jvm/functions/Function3;Ljava/util/Map;Ljava/util/Map;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "payload", "metadata", "client", "createTrait", "(Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/google/PlatformTraitClient;)Lcom/google/home/google/PlatformTrait;", "Ljava/lang/String;", "getTraitId", "Lcom/google/home/google/Parser;", "getParser", "()Lcom/google/home/google/Parser;", "Ljava/util/Map;", "getEnumAdapters", "()Ljava/util/Map;", "Lkotlin/jvm/functions/Function3;", "getCreator", "()Lkotlin/jvm/functions/Function3;", "getSupportedEvents", "getCommands", "java.com.google.home.whdm.src.com.google.home.google_whdm-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformTraitFactory<T extends PlatformTrait, A> implements InternalTraitFactory<T> {
    private final Map<String, CommandDescriptor> commands;
    private final Function3<Trait.TraitMetadata, PlatformTraitClient, A, T> creator;
    private final Map<String, PlatformEnumAdapter<?>> enumAdapters;
    private final Parser<A> parser;
    private final Map<String, EventFactory<?>> supportedEvents;
    private final String traitId;

    /* JADX WARN: Multi-variable type inference failed */
    public PlatformTraitFactory(String str, Parser<A> parser, Map<String, ? extends PlatformEnumAdapter<?>> map, Function3<? super Trait.TraitMetadata, ? super PlatformTraitClient, ? super A, ? extends T> function3, Map<String, ? extends EventFactory<?>> map2, Map<String, ? extends CommandDescriptor> map3) {
        str.getClass();
        parser.getClass();
        map.getClass();
        function3.getClass();
        map2.getClass();
        map3.getClass();
        this.traitId = str;
        this.parser = parser;
        this.enumAdapters = map;
        this.creator = function3;
        this.supportedEvents = map2;
        this.commands = map3;
    }

    public final T createTrait(TraitElementPayload traitElementPayload, Trait.TraitMetadata traitMetadata, PlatformTraitClient platformTraitClient) {
        traitElementPayload.getClass();
        traitMetadata.getClass();
        platformTraitClient.getClass();
        return this.creator.invoke(traitMetadata, platformTraitClient, this.parser.parseFrom(zzvo.zza(traitElementPayload.getZzd())));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PlatformTraitFactory) {
            return Intrinsics.areEqual(getTraitId(), ((PlatformTraitFactory) other).getTraitId());
        }
        return false;
    }

    public final Map<String, CommandDescriptor> getCommands() {
        return this.commands;
    }

    public final Map<String, PlatformEnumAdapter<?>> getEnumAdapters() {
        return this.enumAdapters;
    }

    public final Map<String, EventFactory<?>> getSupportedEvents() {
        return this.supportedEvents;
    }

    @Override // com.google.home.InternalTraitFactory
    public String getTraitId() {
        return this.traitId;
    }

    public int hashCode() {
        return getTraitId().hashCode();
    }

    public String toString() {
        return getTraitId();
    }

    public /* synthetic */ PlatformTraitFactory(String str, Parser parser, Map map, Function3 function3, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, parser, map, function3, (i & 16) != 0 ? MapsKt.emptyMap() : map2, (i & 32) != 0 ? MapsKt.emptyMap() : map3);
    }
}
