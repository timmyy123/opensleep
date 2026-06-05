package com.google.firebase.ai;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceGenerativeModelFactory;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/google/firebase/ai/FirebaseAIMultiResourceComponent;", "", "Lcom/google/firebase/FirebaseApp;", "app", "Lkotlin/coroutines/CoroutineContext;", "blockingDispatcher", "Lcom/google/firebase/inject/Provider;", "Lcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;", "appCheckProvider", "Lcom/google/firebase/auth/internal/InternalAuthProvider;", "internalAuthProvider", "Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceGenerativeModelFactory;", "onDeviceFactoryProvider", "<init>", "(Lcom/google/firebase/FirebaseApp;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/inject/Provider;Lcom/google/firebase/inject/Provider;Lcom/google/firebase/inject/Provider;)V", "Lcom/google/firebase/ai/InstanceKey;", SDKConstants.PARAM_KEY, "Lcom/google/firebase/ai/FirebaseAI;", "get", "(Lcom/google/firebase/ai/InstanceKey;)Lcom/google/firebase/ai/FirebaseAI;", "Lcom/google/firebase/FirebaseApp;", "Lkotlin/coroutines/CoroutineContext;", "getBlockingDispatcher", "()Lkotlin/coroutines/CoroutineContext;", "Lcom/google/firebase/inject/Provider;", "", "instances", "Ljava/util/Map;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FirebaseAIMultiResourceComponent {
    private final FirebaseApp app;
    private final Provider<InteropAppCheckTokenProvider> appCheckProvider;
    private final CoroutineContext blockingDispatcher;
    private final Map<InstanceKey, FirebaseAI> instances;
    private final Provider<InternalAuthProvider> internalAuthProvider;
    private final Provider<FirebaseAIOnDeviceGenerativeModelFactory> onDeviceFactoryProvider;

    public FirebaseAIMultiResourceComponent(FirebaseApp firebaseApp, @Blocking CoroutineContext coroutineContext, Provider<InteropAppCheckTokenProvider> provider, Provider<InternalAuthProvider> provider2, Provider<FirebaseAIOnDeviceGenerativeModelFactory> provider3) {
        firebaseApp.getClass();
        coroutineContext.getClass();
        provider.getClass();
        provider2.getClass();
        provider3.getClass();
        this.app = firebaseApp;
        this.blockingDispatcher = coroutineContext;
        this.appCheckProvider = provider;
        this.internalAuthProvider = provider2;
        this.onDeviceFactoryProvider = provider3;
        this.instances = new LinkedHashMap();
    }

    public final FirebaseAI get(InstanceKey key) {
        FirebaseAI firebaseAI;
        key.getClass();
        synchronized (this) {
            try {
                Map<InstanceKey, FirebaseAI> map = this.instances;
                FirebaseAI firebaseAI2 = map.get(key);
                if (firebaseAI2 == null) {
                    FirebaseAI firebaseAI3 = new FirebaseAI(this.app, key.getBackend(), this.blockingDispatcher, this.appCheckProvider, this.internalAuthProvider, this.onDeviceFactoryProvider, key.getUseLimitedUseAppCheckTokens());
                    map.put(key, firebaseAI3);
                    firebaseAI2 = firebaseAI3;
                }
                firebaseAI = firebaseAI2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseAI;
    }
}
