package com.urbandroid.sleep.smartlight;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.model.Gateway;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001)B)\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u001a\u0010!\u001a\u00020 8\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/urbandroid/sleep/smartlight/RecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/urbandroid/sleep/smartlight/RecyclerAdapter$GatewayHolder;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "", "Lcom/urbandroid/smartlight/common/model/Gateway;", "gateways", "Lkotlin/Function1;", "", "clickListener", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/urbandroid/sleep/smartlight/RecyclerAdapter$GatewayHolder;", "getItemCount", "()I", "holder", "position", "onBindViewHolder", "(Lcom/urbandroid/sleep/smartlight/RecyclerAdapter$GatewayHolder;I)V", "gateway", "addGateway", "(Lcom/urbandroid/smartlight/common/model/Gateway;)V", "Ljava/util/List;", "getGateways", "()Ljava/util/List;", "Lkotlin/jvm/functions/Function1;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "GatewayHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class RecyclerAdapter extends RecyclerView.Adapter<GatewayHolder> implements CoroutineScope, FeatureLogger {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final Function1<Gateway, Unit> clickListener;
    private final List<Gateway> gateways;
    private final String tag;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/smartlight/RecyclerAdapter$GatewayHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "Lkotlin/Function1;", "Lcom/urbandroid/smartlight/common/model/Gateway;", "", "clickListener", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "gateway", "bind", "(Lcom/urbandroid/smartlight/common/model/Gateway;)V", "onClick", "(Landroid/view/View;)V", "Landroid/view/View;", "Lkotlin/jvm/functions/Function1;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lcom/urbandroid/smartlight/common/model/Gateway;", "getGateway", "()Lcom/urbandroid/smartlight/common/model/Gateway;", "setGateway", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class GatewayHolder extends RecyclerView.ViewHolder implements View.OnClickListener, FeatureLogger {
        private final Function1<Gateway, Unit> clickListener;
        public Gateway gateway;
        private final String tag;
        private View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GatewayHolder(View view, Function1<? super Gateway, Unit> function1) {
            super(view);
            view.getClass();
            function1.getClass();
            this.view = view;
            this.clickListener = function1;
            this.tag = Common_smartlightKt.TAG;
            view.setOnClickListener(this);
        }

        public final void bind(Gateway gateway) {
            gateway.getClass();
            setGateway(gateway);
            String str = Logger.defaultTag;
            Logger.logInfo(str, getTag() + ": " + ("Bind gateway " + gateway), null);
            ImageView imageView = (ImageView) this.view.findViewById(R.id.bridge_image);
            TextView textView = (TextView) this.view.findViewById(R.id.bridge_title);
            TextView textView2 = (TextView) this.view.findViewById(R.id.bridge_desc);
            boolean z = gateway instanceof Gateway.Tradfri;
            imageView.setImageResource(z ? R.drawable.ic_action_bridge_round : gateway instanceof Gateway.Dirigera ? R.drawable.ic_action_bridge_dirigera : gateway instanceof Gateway.YaHue ? R.drawable.ic_action_bridge_new : R.drawable.ic_action_bridge);
            textView.setText(z ? R.string.smartlight_ikea_tradfri : gateway instanceof Gateway.YaHue ? R.string.smartlight_philips_hue_new : gateway instanceof Gateway.Dirigera ? R.string.smartlight_ikea_dirigera : R.string.smartlight_philips_hue);
            textView2.setText(gateway.getId() + "\n" + gateway.getIp());
        }

        public final Gateway getGateway() {
            Gateway gateway = this.gateway;
            if (gateway != null) {
                return gateway;
            }
            Intrinsics.throwUninitializedPropertyAccessException("gateway");
            return null;
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return this.tag;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            view.getClass();
            this.clickListener.invoke(getGateway());
        }

        public final void setGateway(Gateway gateway) {
            gateway.getClass();
            this.gateway = gateway;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.RecyclerAdapter$addGateway$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.RecyclerAdapter$addGateway$1", f = "DiscoveryActivity.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecyclerAdapter.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            RecyclerAdapter.this.notifyDataSetChanged();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerAdapter(List<Gateway> list, Function1<? super Gateway, Unit> function1) {
        list.getClass();
        function1.getClass();
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.gateways = list;
        this.clickListener = function1;
        this.tag = Common_smartlightKt.TAG;
    }

    public final void addGateway(Gateway gateway) {
        gateway.getClass();
        if (this.gateways.contains(gateway)) {
            return;
        }
        this.gateways.add(gateway);
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("Adding gateway " + gateway), null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public final List<Gateway> getGateways() {
        return this.gateways;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.gateways.size();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GatewayHolder holder, int position) {
        holder.getClass();
        holder.bind(this.gateways.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GatewayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parent.getClass();
        return new GatewayHolder(DiscoveryActivityKt.inflate$default(parent, R.layout.activity_smartlight_discovery_item, false, 2, null), this.clickListener);
    }
}
