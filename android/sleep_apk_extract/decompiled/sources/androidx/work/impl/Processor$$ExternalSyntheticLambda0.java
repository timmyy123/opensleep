package androidx.work.impl;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Processor$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Serializable f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ Processor$$ExternalSyntheticLambda0(Processor processor, ArrayList arrayList, String str) {
        this.$r8$classId = 0;
        this.f$0 = processor;
        this.f$1 = arrayList;
        this.f$2 = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.$r8$classId;
        Serializable serializable = this.f$1;
        String str = this.f$2;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return ((Processor) obj).lambda$startWork$0((ArrayList) serializable, str);
            case 1:
                return LottieCompositionFactory.lambda$fromUrl$0((Context) obj, str, (String) serializable);
            default:
                return LottieCompositionFactory.fromAssetSync((Context) obj, str, (String) serializable);
        }
    }

    public /* synthetic */ Processor$$ExternalSyntheticLambda0(Context context, int i, String str, String str2) {
        this.$r8$classId = i;
        this.f$0 = context;
        this.f$2 = str;
        this.f$1 = str2;
    }
}
