package com.urbandroid.sleep.achievement;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.urbandroid.sleep.achievement.AchievementFragment$onCreateView$1$1", f = "AchievementFragment.kt", l = {}, m = "invokeSuspend", v = 2)
public final class AchievementFragment$onCreateView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $fragmentActivity;
    final /* synthetic */ Settings $settings;
    final /* synthetic */ RecyclerView $view;
    int label;
    final /* synthetic */ AchievementFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AchievementFragment$onCreateView$1$1(AchievementFragment achievementFragment, FragmentActivity fragmentActivity, Settings settings, RecyclerView recyclerView, Continuation<? super AchievementFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = achievementFragment;
        this.$fragmentActivity = fragmentActivity;
        this.$settings = settings;
        this.$view = recyclerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AchievementFragment$onCreateView$1$1(this.this$0, this.$fragmentActivity, this.$settings, this.$view, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AchievementFragment$onCreateView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        AchievementRecyclerViewAdapter achievementRecyclerViewAdapter = null;
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.adapter = new AchievementRecyclerViewAdapter(this.$fragmentActivity);
        List<Achievement> listLoadAchievements = this.$settings.loadAchievements();
        listLoadAchievements.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listLoadAchievements) {
            if (((Achievement) obj2).fullyCompleted()) {
                arrayList.add(obj2);
            }
        }
        if (!arrayList.isEmpty()) {
            AchievementRecyclerViewAdapter achievementRecyclerViewAdapter2 = this.this$0.adapter;
            if (achievementRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                achievementRecyclerViewAdapter2 = null;
            }
            achievementRecyclerViewAdapter2.getItems().add(new AchievementShowcaseItem(this.$fragmentActivity, CollectionsKt.reversed(arrayList)));
        }
        AchievementRecyclerViewAdapter achievementRecyclerViewAdapter3 = this.this$0.adapter;
        if (achievementRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            achievementRecyclerViewAdapter3 = null;
        }
        achievementRecyclerViewAdapter3.getItems().add(new AchievementSummaryItem(this.$fragmentActivity, listLoadAchievements));
        Achievement.Type[] typeArrValues = Achievement.Type.values();
        AchievementFragment achievementFragment = this.this$0;
        FragmentActivity fragmentActivity = this.$fragmentActivity;
        for (Achievement.Type type : typeArrValues) {
            Achievement achievement = new Achievement(type, 0);
            if (listLoadAchievements.contains(achievement)) {
                achievement.setQuantity(listLoadAchievements.get(listLoadAchievements.indexOf(new Achievement(type, 0))).getQuantity());
            }
            if (!achievement.fullyCompleted()) {
                AchievementRecyclerViewAdapter achievementRecyclerViewAdapter4 = achievementFragment.adapter;
                if (achievementRecyclerViewAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    achievementRecyclerViewAdapter4 = null;
                }
                achievementRecyclerViewAdapter4.getItems().add(new AchievementItem(fragmentActivity, achievement));
            }
        }
        RecyclerView recyclerView = this.$view;
        AchievementRecyclerViewAdapter achievementRecyclerViewAdapter5 = this.this$0.adapter;
        if (achievementRecyclerViewAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            achievementRecyclerViewAdapter = achievementRecyclerViewAdapter5;
        }
        recyclerView.setAdapter(achievementRecyclerViewAdapter);
        this.$view.setNestedScrollingEnabled(true);
        return Unit.INSTANCE;
    }
}
