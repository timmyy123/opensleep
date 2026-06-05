package androidx.view;

import androidx.view.OnBackCompletedFallback;
import androidx.view.OnBackPressedDispatcher;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 implements OnBackCompletedFallback {
    public final /* synthetic */ OnBackPressedDispatcher f$0;

    public /* synthetic */ OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f$0 = onBackPressedDispatcher;
    }

    public final void onBackCompletedFallback() {
        OnBackPressedDispatcher.OnBackPressedEventInput.dispatcher$lambda$0(this.f$0);
    }
}
