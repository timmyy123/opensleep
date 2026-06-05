package kotlin.reflect.jvm.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.KotlinKProperty;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0017B)\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKMutableProperty0;", "V", "Lkotlin/reflect/jvm/internal/KotlinKProperty0;", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "signature", "rawBoundReceiver", "Lkotlin/reflect/jvm/internal/impl/km/KmProperty;", "kmProperty", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/Object;Lkotlin/metadata/KmProperty;)V", SDKConstants.PARAM_VALUE, "", "set", "(Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KotlinKMutableProperty0$Setter;", "setter$delegate", "Lkotlin/Lazy;", "getSetter", "()Lkotlin/reflect/jvm/internal/KotlinKMutableProperty0$Setter;", "setter", "Setter", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinKMutableProperty0<V> extends KotlinKProperty0<V> implements KProperty0, KMutableProperty {

    /* JADX INFO: renamed from: setter$delegate, reason: from kotlin metadata */
    private final Lazy setter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinKMutableProperty0(KDeclarationContainerImpl kDeclarationContainerImpl, String str, Object obj, KmProperty kmProperty) {
        super(kDeclarationContainerImpl, str, obj, kmProperty);
        kDeclarationContainerImpl.getClass();
        str.getClass();
        kmProperty.getClass();
        this.setter = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KotlinKMutableProperty0$$Lambda$0
            private final KotlinKMutableProperty0 arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KotlinKMutableProperty0.setter_delegate$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Setter setter_delegate$lambda$0(KotlinKMutableProperty0 kotlinKMutableProperty0) {
        return new Setter(kotlinKMutableProperty0);
    }

    @Override // kotlin.reflect.KMutableProperty
    public Setter<V> getSetter() {
        return (Setter) this.setter.getValue();
    }

    public void set(V value) {
        getSetter().call(value);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinKMutableProperty0$Setter;", "R", "Lkotlin/reflect/jvm/internal/KotlinKProperty$Setter;", "", "Lkotlin/reflect/jvm/internal/KotlinKMutableProperty0;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/KotlinKMutableProperty0;)V", SDKConstants.PARAM_VALUE, "", "invoke", "(Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KotlinKMutableProperty0;", "getProperty", "()Lkotlin/reflect/jvm/internal/KotlinKMutableProperty0;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Setter<R> extends KotlinKProperty.Setter<R> implements KMutableProperty.Setter, Function1 {
        private final KotlinKMutableProperty0<R> property;

        public Setter(KotlinKMutableProperty0<R> kotlinKMutableProperty0) {
            kotlinKMutableProperty0.getClass();
            this.property = kotlinKMutableProperty0;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public void m2468invoke(R value) {
            getProperty().set(value);
        }

        @Override // kotlin.reflect.jvm.internal.KotlinKProperty.Accessor, kotlin.reflect.KProperty.Accessor
        public KotlinKMutableProperty0<R> getProperty() {
            return this.property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2468invoke(obj);
            return Unit.INSTANCE;
        }
    }
}
