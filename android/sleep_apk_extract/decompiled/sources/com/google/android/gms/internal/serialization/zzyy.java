package com.google.android.gms.internal.serialization;

import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzzg;
import java.io.IOException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzyy<MessageType extends zzzg<MessageType, BuilderType>, BuilderType extends zzyy<MessageType, BuilderType>> extends zzvx<MessageType, BuilderType> {
    private final MessageType defaultInstance;
    protected MessageType instance;

    public zzyy(MessageType messagetype) {
        this.defaultInstance = messagetype;
        if (messagetype.isMutable()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Default instance must be immutable.");
            throw null;
        }
        this.instance = (MessageType) newMutableInstance();
    }

    private static <MessageType> void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
        zzaba.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    private MessageType newMutableInstance() {
        return (MessageType) this.defaultInstance.newMutableInstance();
    }

    @Override // com.google.android.gms.internal.serialization.zzaap
    public final MessageType build() {
        MessageType messagetype = (MessageType) buildPartial();
        if (messagetype.isInitialized()) {
            return messagetype;
        }
        throw zzvx.newUninitializedMessageException(messagetype);
    }

    @Override // com.google.android.gms.internal.serialization.zzaap
    public MessageType buildPartial() {
        boolean zIsMutable = this.instance.isMutable();
        MessageType messagetype = this.instance;
        if (!zIsMutable) {
            return messagetype;
        }
        messagetype.makeImmutable();
        return this.instance;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BuilderType m368clone() {
        BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
        buildertype.instance = (MessageType) buildPartial();
        return buildertype;
    }

    public final void copyOnWrite() {
        if (this.instance.isMutable()) {
            return;
        }
        copyOnWriteInternal();
    }

    public void copyOnWriteInternal() {
        MessageType messagetype = (MessageType) newMutableInstance();
        mergeFromInstance(messagetype, this.instance);
        this.instance = messagetype;
    }

    @Override // com.google.android.gms.internal.serialization.zzaar
    public final boolean isInitialized() {
        return zzzg.isInitialized(this.instance, false);
    }

    @Override // com.google.android.gms.internal.serialization.zzaap
    public BuilderType mergeFrom(zzwv zzwvVar, zzyp zzypVar) throws IOException {
        copyOnWrite();
        try {
            zzaba.zza().zzb(this.instance.getClass()).zzg(this.instance, zzww.zza(zzwvVar), zzypVar);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzaar
    public MessageType getDefaultInstanceForType() {
        return this.defaultInstance;
    }

    @Override // com.google.android.gms.internal.serialization.zzvx
    public BuilderType internalMergeFrom(MessageType messagetype) {
        return (BuilderType) mergeFrom((zzzg) messagetype);
    }

    public BuilderType mergeFrom(MessageType messagetype) {
        if (getDefaultInstanceForType().equals(messagetype)) {
            return this;
        }
        copyOnWrite();
        mergeFromInstance(this.instance, messagetype);
        return this;
    }
}
