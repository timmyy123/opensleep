package com.urbandroid.sleep.trial;

import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.sleep.trial.JavaBilling;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Billing$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Billing$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String str = (String) obj;
        switch (this.$r8$classId) {
            case 0:
                return Billing.acknowledge$lambda$0$0(str);
            case 1:
                return Billing.C22152.invokeSuspend$lambda$0$1$0(str);
            case 2:
                return Billing.C22202.invokeSuspend$lambda$0$0$0(str);
            case 3:
                return Billing.C22202.invokeSuspend$lambda$0$2$0(str);
            case 4:
                return Billing.C22202.invokeSuspend$lambda$0$5$0(str);
            case 5:
                return JavaBilling.C22251.invokeSuspend$lambda$0$0(str);
            case 6:
                return JavaBilling.C22251.invokeSuspend$lambda$1(str);
            case 7:
                return Billing.acknowledge$lambda$1(str);
            default:
                return Billing.acknowledge$lambda$2(str);
        }
    }
}
