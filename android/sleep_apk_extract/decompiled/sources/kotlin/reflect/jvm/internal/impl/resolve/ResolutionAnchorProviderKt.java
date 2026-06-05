package kotlin.reflect.jvm.internal.impl.resolve;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ResolutionAnchorProviderKt {
    private static final ModuleCapability<Object> RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new ModuleCapability<>("ResolutionAnchorProvider");

    public static final ModuleDescriptor getResolutionAnchorIfAny(ModuleDescriptor moduleDescriptor) {
        moduleDescriptor.getClass();
        if (moduleDescriptor.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
