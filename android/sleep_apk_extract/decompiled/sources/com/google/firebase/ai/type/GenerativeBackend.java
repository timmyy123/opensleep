package com.google.firebase.ai.type;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/ai/type/GenerativeBackend;", "", "location", "", "backend", "Lcom/google/firebase/ai/type/GenerativeBackendEnum;", "<init>", "(Ljava/lang/String;Lcom/google/firebase/ai/type/GenerativeBackendEnum;)V", "getLocation$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/String;", "getBackend$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/GenerativeBackendEnum;", "equals", "", "other", "hashCode", "", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GenerativeBackend {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GenerativeBackendEnum backend;
    private final String location;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/GenerativeBackend$Companion;", "", "<init>", "()V", "googleAI", "Lcom/google/firebase/ai/type/GenerativeBackend;", "vertexAI", "location", "", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GenerativeBackend vertexAI$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "us-central1";
            }
            return companion.vertexAI(str);
        }

        public final GenerativeBackend googleAI() {
            return new GenerativeBackend("", GenerativeBackendEnum.GOOGLE_AI);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final GenerativeBackend vertexAI(String location) {
            location.getClass();
            if (StringsKt.isBlank(location) || StringsKt.contains$default(location, MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                throw new InvalidLocationException(location, null, 2, 0 == true ? 1 : 0);
            }
            return new GenerativeBackend(location, GenerativeBackendEnum.VERTEX_AI);
        }

        private Companion() {
        }

        public final GenerativeBackend vertexAI() {
            return vertexAI$default(this, null, 1, null);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GenerativeBackendEnum.values().length];
            try {
                iArr[GenerativeBackendEnum.GOOGLE_AI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GenerativeBackendEnum.VERTEX_AI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GenerativeBackend(String str, GenerativeBackendEnum generativeBackendEnum) {
        str.getClass();
        generativeBackendEnum.getClass();
        this.location = str;
        this.backend = generativeBackendEnum;
    }

    public static final GenerativeBackend googleAI() {
        return INSTANCE.googleAI();
    }

    public static final GenerativeBackend vertexAI() {
        return INSTANCE.vertexAI();
    }

    public boolean equals(Object other) {
        if (other instanceof GenerativeBackend) {
            GenerativeBackend generativeBackend = (GenerativeBackend) other;
            int i = WhenMappings.$EnumSwitchMapping$0[generativeBackend.backend.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return generativeBackend.backend == this.backend && Intrinsics.areEqual(generativeBackend.location, this.location);
                }
                Home$$ExternalSyntheticBUOutline0.m();
                return false;
            }
            if (generativeBackend.backend == this.backend) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: getBackend$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final GenerativeBackendEnum getBackend() {
        return this.backend;
    }

    /* JADX INFO: renamed from: getLocation$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public int hashCode() {
        return Objects.hash(this.backend, this.location);
    }

    public static final GenerativeBackend vertexAI(String str) {
        return INSTANCE.vertexAI(str);
    }
}
