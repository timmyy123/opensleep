package com.google.home.platform.traits.automation;

import com.google.android.gms.internal.serialization.zzaaj;
import com.google.android.gms.internal.serialization.zzaak;
import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzace;
import com.google.android.gms.internal.serialization.zzwr;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzze;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzs;
import com.google.home.platform.traits.AutomationGraph;
import com.google.home.platform.traits.Trait;
import com.google.home.platform.traits.ValidationResult;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class AutomationEntityTrait extends zzzg<AutomationEntityTrait, Builder> implements zzaar {
    public static final int ACTIVE_FIELD_NUMBER = 4;
    public static final int AUTOMATION_GRAPH_FIELD_NUMBER = 3;
    public static final int CLIENT_FEATURE_GROUP_FIELD_NUMBER = 15;
    public static final int CLIENT_METADATA_FIELD_NUMBER = 11;
    private static final AutomationEntityTrait DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int IQS_AUTOMATION_ID_FIELD_NUMBER = 10;
    public static final int MANUALLY_EXECUTABLE_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile zzaay<AutomationEntityTrait> PARSER = null;
    public static final int STRUCTURE_OBJECT_ID_FIELD_NUMBER = 5;
    public static final int TRAIT_EXT_FIELD_NUMBER = 27;
    public static final int VALIDATION_RESULTS_FIELD_NUMBER = 7;
    public static final int VALID_FIELD_NUMBER = 6;
    public static final zzze<Trait, AutomationEntityTrait> traitExt;
    private boolean active_;
    private AutomationGraph automationGraph_;
    private int bitField0_;
    private boolean manuallyExecutable_;
    private boolean valid_;
    private zzaak<String, zzwr> clientMetadata_ = zzaak.zza();
    private String iqsAutomationId_ = "";
    private String structureObjectId_ = "";
    private String name_ = "";
    private String description_ = "";
    private zzzs<ValidationResult> validationResults_ = zzzg.emptyProtobufList();
    private String clientFeatureGroup_ = "";

    public static final class ClientMetadataDefaultEntryHolder {
        static final zzaaj<String, zzwr> defaultEntry = zzaaj.zza(zzace.zzi, "", zzace.zzl, zzwr.zzb);
    }

    static {
        AutomationEntityTrait automationEntityTrait = new AutomationEntityTrait();
        DEFAULT_INSTANCE = automationEntityTrait;
        zzzg.registerDefaultInstance(AutomationEntityTrait.class, automationEntityTrait);
        traitExt = zzzg.newSingularGeneratedExtension(Trait.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 27, zzace.zzk, AutomationEntityTrait.class);
    }

    private AutomationEntityTrait() {
    }

    public static AutomationEntityTrait getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private zzaak<String, zzwr> internalGetClientMetadata() {
        return this.clientMetadata_;
    }

    public static AutomationEntityTrait parseFrom(byte[] bArr) {
        return (AutomationEntityTrait) zzzg.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u000b\u0000\u0001\u0001\u000f\u000b\u0001\u0001\u0000\u0001Ȉ\u0002ለ\u0000\u0003ဉ\u0001\u0004\u0007\u0005Ȉ\u0006\u0007\u0007\u001b\b\u0007\nȈ\u000b2\u000fለ\u0002", new Object[]{"bitField0_", "name_", "description_", "automationGraph_", "active_", "structureObjectId_", "valid_", "validationResults_", ValidationResult.class, "manuallyExecutable_", "iqsAutomationId_", "clientMetadata_", ClientMetadataDefaultEntryHolder.defaultEntry, "clientFeatureGroup_"});
        }
        if (iOrdinal == 3) {
            return new AutomationEntityTrait();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new Builder(bArr);
        }
        if (iOrdinal == 5) {
            return DEFAULT_INSTANCE;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay<AutomationEntityTrait> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (AutomationEntityTrait.class) {
            try {
                zzyzVar = PARSER;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(DEFAULT_INSTANCE);
                    PARSER = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public boolean getActive() {
        return this.active_;
    }

    public AutomationGraph getAutomationGraph() {
        AutomationGraph automationGraph = this.automationGraph_;
        return automationGraph == null ? AutomationGraph.getDefaultInstance() : automationGraph;
    }

    public String getClientFeatureGroup() {
        return this.clientFeatureGroup_;
    }

    public Map<String, zzwr> getClientMetadataMap() {
        return Collections.unmodifiableMap(internalGetClientMetadata());
    }

    public String getDescription() {
        return this.description_;
    }

    public String getIqsAutomationId() {
        return this.iqsAutomationId_;
    }

    public boolean getManuallyExecutable() {
        return this.manuallyExecutable_;
    }

    public String getName() {
        return this.name_;
    }

    public String getStructureObjectId() {
        return this.structureObjectId_;
    }

    public boolean getValid() {
        return this.valid_;
    }

    public List<ValidationResult> getValidationResultsList() {
        return this.validationResults_;
    }

    public boolean hasClientFeatureGroup() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends zzyy<AutomationEntityTrait, Builder> implements zzaar {
        private Builder() {
            super(AutomationEntityTrait.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
