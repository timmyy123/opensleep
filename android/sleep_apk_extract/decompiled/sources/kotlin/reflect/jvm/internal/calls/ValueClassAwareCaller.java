package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectKCallable;
import kotlin.reflect.jvm.internal.ReflectKCallableKt;
import kotlin.reflect.jvm.internal.ReflectKFunction;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.CallerImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001!B7\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016¢\u0006\u0002\u0010 R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "callable", "Lkotlin/reflect/jvm/internal/ReflectKCallable;", "caller", "isDefault", "", "forbidUnboxingForIndices", "", "", "<init>", "(Lkotlin/reflect/jvm/internal/ReflectKCallable;Lkotlin/reflect/jvm/internal/calls/Caller;ZLjava/util/List;)V", "member", "getMember", "()Ljava/lang/reflect/Member;", "returnType", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "parameterTypes", "getParameterTypes", "()Ljava/util/List;", "isBoundInstanceCallWithValueClasses", "()Z", "data", "Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$BoxUnboxData;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ValueClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unboxParameters", "", "Ljava/lang/reflect/Method;", "box", "<init>", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getUnboxParameters", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "getBox", "()Ljava/lang/reflect/Method;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unboxParameters;

        public BoxUnboxData(IntRange intRange, Method[] methodArr, Method method) {
            intRange.getClass();
            methodArr.getClass();
            this.argumentRange = intRange;
            this.unboxParameters = methodArr;
            this.box = method;
        }

        public final IntRange getArgumentRange() {
            return this.argumentRange;
        }

        public final Method getBox() {
            return this.box;
        }

        public final Method[] getUnboxParameters() {
            return this.unboxParameters;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b A[EDGE_INSN: B:103:0x006b->B:27:0x006b BREAK  A[LOOP:3: B:34:0x0085->B:105:?]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0157 A[LOOP:1: B:79:0x0151->B:81:0x0157, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ValueClassAwareCaller(ReflectKCallable<?> reflectKCallable, Caller<? extends M> caller, boolean z, List<Integer> list) {
        Class<?> inlineClass;
        int size;
        int size2;
        Method[] methodArr;
        int i;
        Iterator<T> it;
        BoxUnboxData boxUnboxData;
        Member memberMo2469getMember;
        Class<?> inlineClass2;
        KType kTypeUnsubstitutedUnderlyingType;
        reflectKCallable.getClass();
        caller.getClass();
        list.getClass();
        this.caller = caller;
        this.isDefault = z;
        KType returnType = reflectKCallable.getReturnType();
        boolean z2 = reflectKCallable instanceof ReflectKFunction;
        Method boxMethod = ((z2 && ((ReflectKFunction) reflectKCallable).isSuspend() && (kTypeUnsubstitutedUnderlyingType = UtilKt.unsubstitutedUnderlyingType(returnType)) != null && ValueClassAwareCallerKt.isPrimitiveType(kTypeUnsubstitutedUnderlyingType)) || (inlineClass = ValueClassAwareCallerKt.toInlineClass(returnType)) == null) ? null : ValueClassAwareCallerKt.getBoxMethod(inlineClass, reflectKCallable);
        if (ValueClassAwareCallerKt.isGetterOfUnderlyingPropertyOfValueClass(reflectKCallable)) {
            boxUnboxData = new BoxUnboxData(IntRange.INSTANCE.getEMPTY(), new Method[0], boxMethod);
        } else {
            int i2 = -1;
            if (!(caller instanceof CallerImpl.Method.BoundStatic) || ((CallerImpl.Method.BoundStatic) caller).getIsCallByToValueClassMangledMethod()) {
                if (!ReflectKCallableKt.isConstructor(reflectKCallable)) {
                    List<KParameter> parameters = reflectKCallable.getParameters();
                    if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                        Iterator<T> it2 = parameters.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            if (((KParameter) it2.next()).getKind() == KParameter.Kind.INSTANCE) {
                                KDeclarationContainerImpl container = reflectKCallable.getContainer();
                                KClassImpl kClassImpl = container instanceof KClassImpl ? (KClassImpl) container : null;
                                if (kClassImpl == null || !kClassImpl.isValue()) {
                                    i2 = 1;
                                }
                            }
                        }
                        i2 = 0;
                    }
                } else if (!(caller instanceof BoundCaller)) {
                    i2 = 0;
                }
            }
            List listMakeKotlinParameterTypes = ValueClassAwareCallerKt.makeKotlinParameterTypes(reflectKCallable, this.caller.mo2469getMember());
            List<KParameter> allParameters = reflectKCallable.getAllParameters();
            if ((allParameters instanceof Collection) && allParameters.isEmpty()) {
                size = listMakeKotlinParameterTypes.size();
                if (z2) {
                    size2 = listMakeKotlinParameterTypes.size() + i2 + (!this.isDefault ? ((size + 31) / 32) + 1 : 0) + ((z2 || !((ReflectKFunction) reflectKCallable).isSuspend()) ? 0 : 1);
                    ValueClassAwareCallerKt.checkParametersSize(this, size2, reflectKCallable, this.isDefault);
                    IntRange intRangeUntil = RangesKt.until(Math.max(i2, 0), listMakeKotlinParameterTypes.size() + i2);
                    methodArr = new Method[size2];
                    i = 0;
                    while (i < size2) {
                    }
                    it = list.iterator();
                    while (it.hasNext()) {
                    }
                    ClassBasedDeclarationContainer container2 = reflectKCallable.getContainer();
                    if (!ReflectKCallableKt.isConstructor(reflectKCallable)) {
                        methodArr[0] = null;
                    }
                    boxUnboxData = new BoxUnboxData(intRangeUntil, methodArr, boxMethod);
                }
            } else {
                Iterator<T> it3 = allParameters.iterator();
                while (it3.hasNext()) {
                    if (((KParameter) it3.next()).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                        size = listMakeKotlinParameterTypes.size() - 1;
                        break;
                    }
                }
                size = listMakeKotlinParameterTypes.size();
                size2 = listMakeKotlinParameterTypes.size() + i2 + (!this.isDefault ? ((size + 31) / 32) + 1 : 0) + ((z2 || !((ReflectKFunction) reflectKCallable).isSuspend()) ? 0 : 1);
                ValueClassAwareCallerKt.checkParametersSize(this, size2, reflectKCallable, this.isDefault);
                IntRange intRangeUntil2 = RangesKt.until(Math.max(i2, 0), listMakeKotlinParameterTypes.size() + i2);
                methodArr = new Method[size2];
                i = 0;
                while (i < size2) {
                    methodArr[i] = (i > intRangeUntil2.getLast() || intRangeUntil2.getFirst() > i || (inlineClass2 = ValueClassAwareCallerKt.toInlineClass((KType) listMakeKotlinParameterTypes.get(i - i2))) == null) ? null : ValueClassAwareCallerKt.getInlineClassUnboxMethod(inlineClass2, reflectKCallable);
                    i++;
                }
                it = list.iterator();
                while (it.hasNext()) {
                    methodArr[((Number) it.next()).intValue()] = null;
                }
                ClassBasedDeclarationContainer container22 = reflectKCallable.getContainer();
                if (!ReflectKCallableKt.isConstructor(reflectKCallable) && (container22 instanceof KClass) && ((KClass) container22).isValue() && (memberMo2469getMember = mo2469getMember()) != null && ValueClassAwareCallerKt.acceptsBoxedReceiverParameter(memberMo2469getMember)) {
                    methodArr[0] = null;
                }
                boxUnboxData = new BoxUnboxData(intRangeUntil2, methodArr, boxMethod);
            }
        }
        this.data = boxUnboxData;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] args) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        Method method;
        args.getClass();
        IntRange argumentRange = this.data.getArgumentRange();
        Method[] unboxParameters = this.data.getUnboxParameters();
        Method box = this.data.getBox();
        int length = args.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            Object objDefaultPrimitiveValue = args[i];
            int first = argumentRange.getFirst();
            if (i <= argumentRange.getLast() && first <= i && (method = unboxParameters[i]) != null) {
                if (objDefaultPrimitiveValue != null) {
                    objDefaultPrimitiveValue = method.invoke(objDefaultPrimitiveValue, null);
                } else {
                    Class<?> returnType = method.getReturnType();
                    returnType.getClass();
                    objDefaultPrimitiveValue = UtilKt.defaultPrimitiveValue(returnType);
                }
            }
            objArr[i] = objDefaultPrimitiveValue;
        }
        Object objCall = this.caller.call(objArr);
        return (objCall == IntrinsicsKt.getCOROUTINE_SUSPENDED() || box == null || (objInvoke = box.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public M mo2469getMember() {
        return (M) this.caller.mo2469getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public boolean isBoundInstanceCallWithValueClasses() {
        return this.caller instanceof CallerImpl.Method.BoundInstance;
    }
}
