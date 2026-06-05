package kotlin.reflect.jvm.internal.impl.resolve;

import adamb.ogg.OggIO;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes5.dex */
public abstract class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> function1) {
        collection.getClass();
        function1.getClass();
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet smartSetCreate = SmartSet.Companion.create();
        while (!linkedList.isEmpty()) {
            Object objFirst = CollectionsKt.first((List<? extends Object>) linkedList);
            final SmartSet smartSetCreate2 = SmartSet.Companion.create();
            Collection<OggIO> collectionExtractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(objFirst, linkedList, function1, new Function1(smartSetCreate2) { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$$Lambda$1
                private final SmartSet arg$0;

                {
                    this.arg$0 = smartSetCreate2;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup$lambda$0(this.arg$0, obj);
                }
            });
            collectionExtractMembersOverridableInBothWays.getClass();
            if (collectionExtractMembersOverridableInBothWays.size() == 1 && smartSetCreate2.isEmpty()) {
                Object objSingle = CollectionsKt.single(collectionExtractMembersOverridableInBothWays);
                objSingle.getClass();
                smartSetCreate.add(objSingle);
            } else {
                OggIO oggIO = (Object) OverridingUtil.selectMostSpecificMember(collectionExtractMembersOverridableInBothWays, function1);
                oggIO.getClass();
                CallableDescriptor callableDescriptorInvoke = function1.invoke(oggIO);
                for (OggIO oggIO2 : collectionExtractMembersOverridableInBothWays) {
                    oggIO2.getClass();
                    if (!OverridingUtil.isMoreSpecific(callableDescriptorInvoke, function1.invoke(oggIO2))) {
                        smartSetCreate2.add(oggIO2);
                    }
                }
                if (!smartSetCreate2.isEmpty()) {
                    smartSetCreate.addAll(smartSetCreate2);
                }
                smartSetCreate.add(oggIO);
            }
        }
        return smartSetCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectMostSpecificInEachOverridableGroup$lambda$0(SmartSet smartSet, Object obj) {
        obj.getClass();
        smartSet.add(obj);
        return Unit.INSTANCE;
    }
}
