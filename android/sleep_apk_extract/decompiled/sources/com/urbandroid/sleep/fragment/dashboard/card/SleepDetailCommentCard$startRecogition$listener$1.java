package com.urbandroid.sleep.fragment.dashboard.card;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Bundle;
import android.speech.RecognitionListener;
import com.facebook.internal.NativeProtocol;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailCommentCard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0017"}, d2 = {"com/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$startRecogition$listener$1", "Landroid/speech/RecognitionListener;", "onReadyForSpeech", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "onBeginningOfSpeech", "onRmsChanged", "rmsdB", "", "onBufferReceived", "buffer", "", "onEndOfSpeech", "onError", "error", "", "onResults", "results", "onPartialResults", "partialResults", "onEvent", "eventType", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailCommentCard$startRecogition$listener$1 implements RecognitionListener {
    final /* synthetic */ SleepDetailCommentCard.SleepRecordViewHolder $viewHolder;
    final /* synthetic */ SleepDetailCommentCard this$0;

    public SleepDetailCommentCard$startRecogition$listener$1(SleepDetailCommentCard.SleepRecordViewHolder sleepRecordViewHolder, SleepDetailCommentCard sleepDetailCommentCard) {
        this.$viewHolder = sleepRecordViewHolder;
        this.this$0 = sleepDetailCommentCard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onResults$lambda$0(String str) {
        return FileInsert$$ExternalSyntheticOutline0.m(" ", str, " ");
    }

    @Override // android.speech.RecognitionListener
    public void onBeginningOfSpeech() {
        Logger.logInfo("SleepCommentCard: speech begin");
    }

    @Override // android.speech.RecognitionListener
    public void onBufferReceived(byte[] buffer) {
    }

    @Override // android.speech.RecognitionListener
    public void onEndOfSpeech() {
        Logger.logInfo("SleepCommentCard: speech end");
    }

    @Override // android.speech.RecognitionListener
    public void onError(int error) {
        zza$$ExternalSyntheticOutline0.m(error, "SleepCommentCard: speech error ");
    }

    @Override // android.speech.RecognitionListener
    public void onEvent(int eventType, Bundle params) {
    }

    @Override // android.speech.RecognitionListener
    public void onPartialResults(Bundle partialResults) {
    }

    @Override // android.speech.RecognitionListener
    public void onReadyForSpeech(Bundle params) {
    }

    @Override // android.speech.RecognitionListener
    public void onResults(Bundle results) {
        ArrayList<String> stringArrayList = results != null ? results.getStringArrayList("results_recognition") : null;
        String strJoinToString$default = stringArrayList != null ? CollectionsKt.joinToString$default(stringArrayList, null, null, null, new AiPrompt$$ExternalSyntheticLambda0(12), 31) : null;
        zza$$ExternalSyntheticOutline0.m("SleepCommentCard: speech ", strJoinToString$default);
        this.$viewHolder.getComment().setText(((Object) this.$viewHolder.getComment().getText()) + " " + strJoinToString$default);
        this.this$0.save(this.$viewHolder, true);
    }

    @Override // android.speech.RecognitionListener
    public void onRmsChanged(float rmsdB) {
    }
}
