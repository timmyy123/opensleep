package com.google.home.matter;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.serialization.TraitElementPayload;
import com.google.home.CommandDescriptor;
import com.google.home.EventFactory;
import com.google.home.InternalTraitFactory;
import com.google.home.Trait;
import com.google.home.matter.MatterTrait;
import com.google.home.matter.serialization.BitmapAdapter;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.serialization.EnumAdapter;
import com.google.home.matter.serialization.StructAdapter;
import com.google.home.matter.serialization.codec.factory.SerializationCodecFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u009d\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\n\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\n\u0012\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\n\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\n¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J%\u0010'\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0012¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010.R'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\n8\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b0\u00101R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\n8\u0006¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b2\u00101R/\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u00103\u001a\u0004\b4\u00105R'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010/\u001a\u0004\b6\u00101R#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b7\u00101R\u0014\u00109\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u001b¨\u0006:"}, d2 = {"Lcom/google/home/matter/MatterTraitFactory;", "Lcom/google/home/matter/MatterTrait;", "T", "", "A", "Lcom/google/home/InternalTraitFactory;", "Lcom/google/home/matter/serialization/ClusterId;", "clusterId", "Lcom/google/home/matter/serialization/StructAdapter;", "adapter", "", "", "Lcom/google/home/matter/serialization/EnumAdapter;", "enumAdapters", "Lcom/google/home/matter/serialization/BitmapAdapter;", "bitmapAdapters", "Lkotlin/Function3;", "Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/matter/MatterTraitClient;", "creator", "Lcom/google/home/EventFactory;", "supportedEvents", "Lcom/google/home/CommandDescriptor;", "commands", "<init>", "(Lcom/google/home/matter/serialization/ClusterId;Lcom/google/home/matter/serialization/StructAdapter;Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function3;Ljava/util/Map;Ljava/util/Map;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "payload", "metadata", "client", "createTrait", "(Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;)Lcom/google/home/matter/MatterTrait;", "Lcom/google/home/matter/serialization/ClusterId;", "getClusterId", "()Lcom/google/home/matter/serialization/ClusterId;", "Lcom/google/home/matter/serialization/StructAdapter;", "getAdapter", "()Lcom/google/home/matter/serialization/StructAdapter;", "Ljava/util/Map;", "getEnumAdapters", "()Ljava/util/Map;", "getBitmapAdapters", "Lkotlin/jvm/functions/Function3;", "getCreator", "()Lkotlin/jvm/functions/Function3;", "getSupportedEvents", "getCommands", "getTraitId", "traitId", "java.com.google.home.matter_matter-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MatterTraitFactory<T extends MatterTrait, A> implements InternalTraitFactory<T> {
    private final StructAdapter<A> adapter;
    private final Map<String, BitmapAdapter<?>> bitmapAdapters;
    private final ClusterId clusterId;
    private final Map<String, CommandDescriptor> commands;
    private final Function3<Trait.TraitMetadata, MatterTraitClient, A, T> creator;
    private final Map<String, EnumAdapter<?>> enumAdapters;
    private final Map<String, EventFactory<?>> supportedEvents;

    /* JADX WARN: Multi-variable type inference failed */
    public MatterTraitFactory(ClusterId clusterId, StructAdapter<A> structAdapter, Map<String, ? extends EnumAdapter<?>> map, Map<String, ? extends BitmapAdapter<?>> map2, Function3<? super Trait.TraitMetadata, ? super MatterTraitClient, ? super A, ? extends T> function3, Map<String, ? extends EventFactory<?>> map3, Map<String, ? extends CommandDescriptor> map4) {
        clusterId.getClass();
        structAdapter.getClass();
        map.getClass();
        map2.getClass();
        function3.getClass();
        map3.getClass();
        map4.getClass();
        this.clusterId = clusterId;
        this.adapter = structAdapter;
        this.enumAdapters = map;
        this.bitmapAdapters = map2;
        this.creator = function3;
        this.supportedEvents = map3;
        this.commands = map4;
    }

    public final T createTrait(TraitElementPayload traitElementPayload, Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient) {
        traitElementPayload.getClass();
        traitMetadata.getClass();
        matterTraitClient.getClass();
        return this.creator.invoke(traitMetadata, matterTraitClient, (A) SerializationCodecFactory.INSTANCE.createReader(traitElementPayload, matterTraitClient.strictOperationValidation()).read(this.adapter));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MatterTraitFactory) && Intrinsics.areEqual(this.clusterId, ((MatterTraitFactory) other).clusterId);
    }

    public final Map<String, BitmapAdapter<?>> getBitmapAdapters() {
        return this.bitmapAdapters;
    }

    public final ClusterId getClusterId() {
        return this.clusterId;
    }

    public final Map<String, CommandDescriptor> getCommands() {
        return this.commands;
    }

    public final Map<String, EnumAdapter<?>> getEnumAdapters() {
        return this.enumAdapters;
    }

    public final Map<String, EventFactory<?>> getSupportedEvents() {
        return this.supportedEvents;
    }

    @Override // com.google.home.InternalTraitFactory
    public String getTraitId() {
        return this.clusterId.getTraitId();
    }

    public int hashCode() {
        return this.clusterId.hashCode();
    }

    public String toString() {
        return this.clusterId.toString();
    }
}
