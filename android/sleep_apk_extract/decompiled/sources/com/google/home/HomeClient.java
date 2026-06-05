package com.google.home;

import androidx.view.result.ActivityResultCaller;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u0010H§@¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lcom/google/home/HomeClient;", "", "Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/HomeDevice;", "devices", "()Lcom/google/home/HomeObjectsFlow;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/home/PermissionsState;", "hasPermissions", "()Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/result/ActivityResultCaller;", "Lcom/google/home/PermissionsLauncher;", "permissionsLauncher", "", "registerActivityResultCallerForPermissions", "(Landroidx/activity/result/ActivityResultCaller;)V", "", "forceLaunch", "Lcom/google/home/PermissionsResult;", "requestPermissions", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_ghp_sdk-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HomeClient {
    HomeObjectsFlow<HomeDevice> devices();

    Flow<PermissionsState> hasPermissions();

    void registerActivityResultCallerForPermissions(ActivityResultCaller permissionsLauncher);

    Object requestPermissions(boolean z, Continuation<? super PermissionsResult> continuation);
}
