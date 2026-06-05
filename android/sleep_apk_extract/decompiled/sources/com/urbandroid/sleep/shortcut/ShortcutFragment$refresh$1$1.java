package com.urbandroid.sleep.shortcut;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.domain.shortcut.Shortcut;
import com.urbandroid.sleep.service.Settings;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.shortcut.ShortcutFragment$refresh$1$1", f = "ShortcutFragment.kt", l = {}, m = "invokeSuspend", v = 2)
public final class ShortcutFragment$refresh$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $fragmentActivity;
    final /* synthetic */ Settings $settings;
    int label;
    final /* synthetic */ ShortcutFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortcutFragment$refresh$1$1(ShortcutFragment shortcutFragment, FragmentActivity fragmentActivity, Settings settings, Continuation<? super ShortcutFragment$refresh$1$1> continuation) {
        super(2, continuation);
        this.this$0 = shortcutFragment;
        this.$fragmentActivity = fragmentActivity;
        this.$settings = settings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortcutFragment$refresh$1$1(this.this$0, this.$fragmentActivity, this.$settings, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShortcutFragment$refresh$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ShortcutRecyclerViewAdapter shortcutRecyclerViewAdapter = null;
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.adapter = new ShortcutRecyclerViewAdapter(this.$fragmentActivity);
        List<Shortcut> listLoadShortcuts = this.$settings.loadShortcuts();
        listLoadShortcuts.getClass();
        CollectionsKt.reverse(listLoadShortcuts);
        ShortcutFragment shortcutFragment = this.this$0;
        FragmentActivity fragmentActivity = this.$fragmentActivity;
        for (Shortcut shortcut : listLoadShortcuts) {
            ShortcutRecyclerViewAdapter shortcutRecyclerViewAdapter2 = shortcutFragment.adapter;
            if (shortcutRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                shortcutRecyclerViewAdapter2 = null;
            }
            List<AbstractShortcutItem<?>> items = shortcutRecyclerViewAdapter2.getItems();
            shortcut.getClass();
            items.add(new ShortcutItem(fragmentActivity, shortcut));
        }
        RecyclerView recyclerView = this.this$0.view;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ViewHierarchyConstants.VIEW_KEY);
            recyclerView = null;
        }
        ShortcutRecyclerViewAdapter shortcutRecyclerViewAdapter3 = this.this$0.adapter;
        if (shortcutRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            shortcutRecyclerViewAdapter = shortcutRecyclerViewAdapter3;
        }
        recyclerView.setAdapter(shortcutRecyclerViewAdapter);
        return Unit.INSTANCE;
    }
}
