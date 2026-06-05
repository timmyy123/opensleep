package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.FunctionCallingConfig;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000bB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/google/firebase/ai/type/ToolConfig;", "", "functionCallingConfig", "Lcom/google/firebase/ai/type/FunctionCallingConfig;", "<init>", "(Lcom/google/firebase/ai/type/FunctionCallingConfig;)V", "getFunctionCallingConfig$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/FunctionCallingConfig;", "toInternal", "Lcom/google/firebase/ai/type/ToolConfig$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToolConfig {
    private final FunctionCallingConfig functionCallingConfig;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FunctionCallingConfig.Mode.values().length];
            try {
                iArr[FunctionCallingConfig.Mode.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FunctionCallingConfig.Mode.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FunctionCallingConfig.Mode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ToolConfig(FunctionCallingConfig functionCallingConfig) {
        this.functionCallingConfig = functionCallingConfig;
    }

    /* JADX INFO: renamed from: getFunctionCallingConfig$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final FunctionCallingConfig getFunctionCallingConfig() {
        return this.functionCallingConfig;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        FunctionCallingConfig.Internal.Mode mode;
        FunctionCallingConfig functionCallingConfig = this.functionCallingConfig;
        FunctionCallingConfig.Internal internal = null;
        if (functionCallingConfig != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[functionCallingConfig.getMode().ordinal()];
            if (i == 1) {
                mode = FunctionCallingConfig.Internal.Mode.ANY;
            } else if (i == 2) {
                mode = FunctionCallingConfig.Internal.Mode.AUTO;
            } else {
                if (i != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                mode = FunctionCallingConfig.Internal.Mode.NONE;
            }
            internal = new FunctionCallingConfig.Internal(mode, functionCallingConfig.getAllowedFunctionNames$com_google_firebase_ai_logic_firebase_ai());
        }
        return new Internal(internal);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/google/firebase/ai/type/ToolConfig$Internal;", "", "functionCallingConfig", "Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal;", "<init>", "(Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/FunctionCallingConfig$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFunctionCallingConfig$annotations", "()V", "getFunctionCallingConfig", "()Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal;", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final FunctionCallingConfig.Internal functionCallingConfig;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ToolConfig$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ToolConfig$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return ToolConfig$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, FunctionCallingConfig.Internal internal, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ToolConfig$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.functionCallingConfig = internal;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, FunctionCallingConfig.Internal internal2, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.functionCallingConfig;
            }
            return internal.copy(internal2);
        }

        @SerialName("function_calling_config")
        public static /* synthetic */ void getFunctionCallingConfig$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FunctionCallingConfig.Internal getFunctionCallingConfig() {
            return this.functionCallingConfig;
        }

        public final Internal copy(FunctionCallingConfig.Internal functionCallingConfig) {
            return new Internal(functionCallingConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Internal) && Intrinsics.areEqual(this.functionCallingConfig, ((Internal) other).functionCallingConfig);
        }

        public final FunctionCallingConfig.Internal getFunctionCallingConfig() {
            return this.functionCallingConfig;
        }

        public int hashCode() {
            FunctionCallingConfig.Internal internal = this.functionCallingConfig;
            if (internal == null) {
                return 0;
            }
            return internal.hashCode();
        }

        public String toString() {
            return "Internal(functionCallingConfig=" + this.functionCallingConfig + ')';
        }

        public Internal(FunctionCallingConfig.Internal internal) {
            this.functionCallingConfig = internal;
        }
    }
}
