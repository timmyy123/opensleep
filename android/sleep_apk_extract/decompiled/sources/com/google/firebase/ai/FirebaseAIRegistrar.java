package com.google.firebase.ai;

import com.google.firebase.FirebaseApp;
import com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceGenerativeModelFactory;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a0\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0014\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00060\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/FirebaseAIRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "", "kotlin.jvm.PlatformType", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FirebaseAIRegistrar implements ComponentRegistrar {
    private static final Companion Companion = new Companion(null);
    private static final String LIBRARY_NAME = "fire-ai";
    private static final Qualified<InteropAppCheckTokenProvider> appCheckInterop;
    private static final Qualified<CoroutineDispatcher> blockingDispatcher;
    private static final Qualified<FirebaseApp> firebaseApp;
    private static final Qualified<InternalAuthProvider> internalAuthProvider;
    private static final Qualified<FirebaseAIOnDeviceGenerativeModelFactory> ondeviceInterop;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000b0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\r0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00110\u00110\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/ai/FirebaseAIRegistrar$Companion;", "", "<init>", "()V", "LIBRARY_NAME", "", "firebaseApp", "Lcom/google/firebase/components/Qualified;", "Lcom/google/firebase/FirebaseApp;", "kotlin.jvm.PlatformType", "appCheckInterop", "Lcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;", "internalAuthProvider", "Lcom/google/firebase/auth/internal/InternalAuthProvider;", "ondeviceInterop", "Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceGenerativeModelFactory;", "blockingDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Qualified<FirebaseApp> qualifiedUnqualified = Qualified.unqualified(FirebaseApp.class);
        qualifiedUnqualified.getClass();
        firebaseApp = qualifiedUnqualified;
        Qualified<InteropAppCheckTokenProvider> qualifiedUnqualified2 = Qualified.unqualified(InteropAppCheckTokenProvider.class);
        qualifiedUnqualified2.getClass();
        appCheckInterop = qualifiedUnqualified2;
        Qualified<InternalAuthProvider> qualifiedUnqualified3 = Qualified.unqualified(InternalAuthProvider.class);
        qualifiedUnqualified3.getClass();
        internalAuthProvider = qualifiedUnqualified3;
        Qualified<FirebaseAIOnDeviceGenerativeModelFactory> qualifiedUnqualified4 = Qualified.unqualified(FirebaseAIOnDeviceGenerativeModelFactory.class);
        qualifiedUnqualified4.getClass();
        ondeviceInterop = qualifiedUnqualified4;
        Qualified<CoroutineDispatcher> qualified = Qualified.qualified(Blocking.class, CoroutineDispatcher.class);
        qualified.getClass();
        blockingDispatcher = qualified;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseAIMultiResourceComponent getComponents$lambda$0(ComponentContainer componentContainer) {
        Object obj = componentContainer.get(firebaseApp);
        obj.getClass();
        Object obj2 = componentContainer.get(blockingDispatcher);
        obj2.getClass();
        Provider provider = componentContainer.getProvider(appCheckInterop);
        provider.getClass();
        Provider provider2 = componentContainer.getProvider(internalAuthProvider);
        provider2.getClass();
        Provider provider3 = componentContainer.getProvider(ondeviceInterop);
        provider3.getClass();
        return new FirebaseAIMultiResourceComponent((FirebaseApp) obj, (CoroutineContext) obj2, provider, provider2, provider3);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<? extends Object>> getComponents() {
        return CollectionsKt.listOf((Object[]) new Component[]{Component.builder(FirebaseAIMultiResourceComponent.class).name(LIBRARY_NAME).add(Dependency.required(firebaseApp)).add(Dependency.required(blockingDispatcher)).add(Dependency.optionalProvider(appCheckInterop)).add(Dependency.optionalProvider(internalAuthProvider)).add(Dependency.optionalProvider(ondeviceInterop)).factory(new FirebaseAIRegistrar$$ExternalSyntheticLambda0(0)).build(), LibraryVersionComponent.create(LIBRARY_NAME, "17.10.1")});
    }
}
