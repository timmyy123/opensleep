package com.tbuonomo.viewpagerdotsindicator.attacher;

import com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.attacher.DotsIndicatorAttacher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH&¢\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/attacher/DotsIndicatorAttacher;", "Attachable", "Adapter", "", "()V", "buildPager", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "attachable", "adapter", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "getAdapterFromAttachable", "(Ljava/lang/Object;)Ljava/lang/Object;", "registerAdapterDataChangedObserver", "", "onChanged", "Lkotlin/Function0;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "setup", "baseDotsIndicator", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator;", "(Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator;Ljava/lang/Object;)V", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DotsIndicatorAttacher<Attachable, Adapter> {
    public abstract BaseDotsIndicator.Pager buildPager(Attachable attachable, Adapter adapter);

    public abstract Adapter getAdapterFromAttachable(Attachable attachable);

    public abstract void registerAdapterDataChangedObserver(Attachable attachable, Adapter adapter, Function0<Unit> onChanged);

    public final void setup(BaseDotsIndicator baseDotsIndicator, Attachable attachable) {
        baseDotsIndicator.getClass();
        Adapter adapterFromAttachable = getAdapterFromAttachable(attachable);
        if (adapterFromAttachable == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Please set an adapter to the view pager (1 or 2) or the recycler before initializing the dots indicator");
            return;
        }
        registerAdapterDataChangedObserver(attachable, adapterFromAttachable, new AnonymousClass1(baseDotsIndicator));
        baseDotsIndicator.setPager(buildPager(attachable, adapterFromAttachable));
        baseDotsIndicator.refreshDots();
    }

    /* JADX INFO: renamed from: com.tbuonomo.viewpagerdotsindicator.attacher.DotsIndicatorAttacher$setup$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Attachable", "Adapter", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ BaseDotsIndicator $baseDotsIndicator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BaseDotsIndicator baseDotsIndicator) {
            super(0);
            this.$baseDotsIndicator = baseDotsIndicator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(BaseDotsIndicator baseDotsIndicator) {
            baseDotsIndicator.getClass();
            baseDotsIndicator.refreshDots();
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final BaseDotsIndicator baseDotsIndicator = this.$baseDotsIndicator;
            baseDotsIndicator.post(new Runnable() { // from class: com.tbuonomo.viewpagerdotsindicator.attacher.DotsIndicatorAttacher$setup$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DotsIndicatorAttacher.AnonymousClass1.invoke$lambda$0(baseDotsIndicator);
                }
            });
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }
}
