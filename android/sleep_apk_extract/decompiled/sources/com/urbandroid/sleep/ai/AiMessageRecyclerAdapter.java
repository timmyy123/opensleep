package com.urbandroid.sleep.ai;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiMessageRecyclerAdapter;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004DEFGB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\u0012J\u001f\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001d\u00109\u001a\b\u0012\u0004\u0012\u000208078\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010=\u001a\u0004\bB\u0010?\"\u0004\bC\u0010A¨\u0006H"}, d2 = {"Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/view/View;", "viewPrompt", "viewFollowUp", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/view/View;)V", "", "showFollowUp", "()V", "hideFollowUp", "", "getMessagePosition", "()I", "", "text", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$MessageType;", "type", "addMessage", "(Ljava/lang/String;Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$MessageType;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "getItemViewType", "(I)I", "getItemCount", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "getH", "()Landroid/os/Handler;", "Landroid/speech/tts/TextToSpeech;", "tts", "Landroid/speech/tts/TextToSpeech;", "getTts", "()Landroid/speech/tts/TextToSpeech;", "setTts", "(Landroid/speech/tts/TextToSpeech;)V", "", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$Message;", "messages", "Ljava/util/List;", "getMessages", "()Ljava/util/List;", "Landroid/view/View;", "getViewPrompt", "()Landroid/view/View;", "setViewPrompt", "(Landroid/view/View;)V", "getViewFollowUp", "setViewFollowUp", "MessageType", "Message", "MessageHolder", "NonMessageHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AiMessageRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final Handler h;
    private final List<Message> messages;
    private final RecyclerView recycler;
    private TextToSpeech tts;
    private View viewFollowUp;
    private View viewPrompt;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$Message;", "", "", "text", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$MessageType;", "type", "<init>", "(Ljava/lang/String;Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$MessageType;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$MessageType;", "getType", "()Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$MessageType;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Message {
        private final String text;
        private final MessageType type;

        public Message(String str, MessageType messageType) {
            str.getClass();
            messageType.getClass();
            this.text = str;
            this.type = messageType;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Message)) {
                return false;
            }
            Message message = (Message) other;
            return Intrinsics.areEqual(this.text, message.text) && this.type == message.type;
        }

        public final String getText() {
            return this.text;
        }

        public final MessageType getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode() + (this.text.hashCode() * 31);
        }

        public String toString() {
            return "Message(text=" + this.text + ", type=" + this.type + ")";
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014JE\u0010\u001d\u001a\u00020\f*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJM\u0010$\u001a\u00020\f*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010#\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$MessageHolder;", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$NonMessageHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/view/View;", "itemView", "Landroid/speech/tts/TextToSpeech;", "tts", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroid/speech/tts/TextToSpeech;)V", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$Message;", "message", "", "bind", "(Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$Message;)V", "Landroid/widget/TextView;", ViewHierarchyConstants.VIEW_KEY, "", "text", "setMarkdownText", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Landroid/text/SpannableStringBuilder;", "pattern", "", "drawableRes", "textView", "", "isFullWidth", "topSpacingDp", "applyDrawableStyle", "(Landroid/text/SpannableStringBuilder;Ljava/lang/String;ILandroid/content/Context;Landroid/widget/TextView;ZI)V", "isBold", "colorRes", "", "sizeScale", "removeMarkers", "applyStyle", "(Landroid/text/SpannableStringBuilder;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Float;ZLandroid/content/Context;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/speech/tts/TextToSpeech;", "getTts", "()Landroid/speech/tts/TextToSpeech;", "messageText", "Landroid/widget/TextView;", "getMessageText", "()Landroid/widget/TextView;", "setMessageText", "(Landroid/widget/TextView;)V", "Landroidx/cardview/widget/CardView;", "messageCard", "Landroidx/cardview/widget/CardView;", "getMessageCard", "()Landroidx/cardview/widget/CardView;", "setMessageCard", "(Landroidx/cardview/widget/CardView;)V", "Lcom/google/android/material/button/MaterialButton;", "ttsButton", "Lcom/google/android/material/button/MaterialButton;", "getTtsButton", "()Lcom/google/android/material/button/MaterialButton;", "setTtsButton", "(Lcom/google/android/material/button/MaterialButton;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class MessageHolder extends NonMessageHolder {
        private final Context context;
        private CardView messageCard;
        private TextView messageText;
        private final TextToSpeech tts;
        private MaterialButton ttsButton;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHolder(Context context, View view, TextToSpeech textToSpeech) {
            super(view);
            context.getClass();
            view.getClass();
            this.context = context;
            this.tts = textToSpeech;
            View viewFindViewById = view.findViewById(R.id.message);
            viewFindViewById.getClass();
            this.messageText = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.message_card);
            viewFindViewById2.getClass();
            this.messageCard = (CardView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.tts);
            viewFindViewById3.getClass();
            this.ttsButton = (MaterialButton) viewFindViewById3;
        }

        public static /* synthetic */ void applyDrawableStyle$default(MessageHolder messageHolder, SpannableStringBuilder spannableStringBuilder, String str, int i, Context context, TextView textView, boolean z, int i2, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                z = false;
            }
            if ((i3 & 32) != 0) {
                i2 = 0;
            }
            messageHolder.applyDrawableStyle(spannableStringBuilder, str, i, context, textView, z, i2);
        }

        public static /* synthetic */ void applyStyle$default(MessageHolder messageHolder, SpannableStringBuilder spannableStringBuilder, String str, boolean z, Integer num, Float f, boolean z2, Context context, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            boolean z3 = z;
            Integer num2 = (i & 4) != 0 ? null : num;
            Float f2 = (i & 8) != 0 ? null : f;
            if ((i & 16) != 0) {
                z2 = true;
            }
            messageHolder.applyStyle(spannableStringBuilder, str, z3, num2, f2, z2, context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$0(final MaterialButton materialButton, MessageHolder messageHolder, Message message, View view) {
            if (Intrinsics.areEqual(materialButton.getTag(), "speaking")) {
                materialButton.setTag("");
                materialButton.setIconResource(R.drawable.ic_volume_high);
                TextToSpeech textToSpeech = messageHolder.tts;
                if (textToSpeech == null || !textToSpeech.isSpeaking()) {
                    return;
                }
                messageHolder.tts.stop();
                return;
            }
            TextToSpeech textToSpeech2 = messageHolder.tts;
            if (textToSpeech2 != null && textToSpeech2.isSpeaking()) {
                messageHolder.tts.stop();
            }
            TextToSpeech textToSpeech3 = messageHolder.tts;
            if (textToSpeech3 != null) {
                textToSpeech3.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener() { // from class: com.urbandroid.sleep.ai.AiMessageRecyclerAdapter$MessageHolder$$ExternalSyntheticLambda1
                    @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
                    public final void onUtteranceCompleted(String str) {
                        AiMessageRecyclerAdapter.MessageHolder.bind$lambda$0$0$0(materialButton, str);
                    }
                });
            }
            TextToSpeech textToSpeech4 = messageHolder.tts;
            if (textToSpeech4 != null) {
                textToSpeech4.setLanguage(Locale.getDefault());
            }
            TextToSpeech textToSpeech5 = messageHolder.tts;
            if (textToSpeech5 != null) {
                textToSpeech5.speak(message.getText(), 0, null, "sleep_assistant");
            }
            materialButton.setTag("speaking");
            materialButton.setIconResource(R.drawable.ic_action_pause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$0$0(MaterialButton materialButton, String str) {
            materialButton.setTag("");
            materialButton.setIconResource(R.drawable.ic_volume_high);
        }

        public final void applyDrawableStyle(SpannableStringBuilder spannableStringBuilder, String str, int i, Context context, TextView textView, boolean z, int i2) {
            spannableStringBuilder.getClass();
            str.getClass();
            context.getClass();
            textView.getClass();
            Pattern patternCompile = Pattern.compile(str);
            Matcher matcher = patternCompile.matcher(spannableStringBuilder);
            int i3 = 0;
            while (matcher.find(i3)) {
                int iStart = matcher.start();
                spannableStringBuilder.replace(iStart, matcher.end(), " ");
                Drawable drawable = ContextCompat.getDrawable(context, i);
                if (drawable != null) {
                    if (z) {
                        drawable.setBounds(0, 0, (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight(), (int) (2.0f * context.getResources().getDisplayMetrics().density));
                    } else {
                        int textSize = (int) (textView.getTextSize() * 2.0f);
                        drawable.setBounds(0, 0, textSize, textSize);
                    }
                    spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), iStart, iStart + 1, 0);
                }
                i3 = iStart + 1;
                matcher = patternCompile.matcher(spannableStringBuilder);
            }
        }

        public final void applyStyle(SpannableStringBuilder spannableStringBuilder, String str, boolean z, Integer num, Float f, boolean z2, Context context) {
            String strGroup;
            spannableStringBuilder.getClass();
            str.getClass();
            context.getClass();
            Pattern patternCompile = Pattern.compile(str);
            Matcher matcher = patternCompile.matcher(spannableStringBuilder);
            int i = 0;
            while (matcher.find(i)) {
                int iStart = matcher.start();
                int iEnd = matcher.end();
                String str2 = "";
                if (!z2 || matcher.groupCount() < 1 ? (strGroup = matcher.group(0)) != null : (strGroup = matcher.group(1)) != null) {
                    str2 = strGroup;
                }
                if (z2) {
                    spannableStringBuilder.replace(iStart, iEnd, (CharSequence) str2);
                }
                int length = str2.length() + iStart;
                if (z) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), iStart, length, 0);
                }
                if (num != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, num.intValue())), iStart, length, 0);
                }
                if (f != null) {
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(f.floatValue()), iStart, length, 0);
                }
                if (z2) {
                    matcher = patternCompile.matcher(spannableStringBuilder);
                }
                i = length;
            }
        }

        @Override // com.urbandroid.sleep.ai.AiMessageRecyclerAdapter.NonMessageHolder
        public void bind(Message message) {
            message.getClass();
            setMarkdownText(this.messageText, message.getText());
            MaterialButton materialButton = this.ttsButton;
            materialButton.setOnClickListener(new AiActivity$$ExternalSyntheticLambda8(materialButton, this, message, 1));
        }

        public final void setMarkdownText(TextView view, String text) {
            view.getClass();
            text.getClass();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            Context context = this.context;
            Integer numValueOf = Integer.valueOf(R.color.white);
            applyStyle$default(this, spannableStringBuilder, "(?m)^###\\s*(.*?)$", true, numValueOf, Float.valueOf(1.4f), false, context, 16, null);
            applyStyle$default(this, spannableStringBuilder, "(?m)^\\*\\*(.*?)\\*\\*", true, numValueOf, Float.valueOf(1.25f), false, this.context, 16, null);
            applyStyle$default(this, spannableStringBuilder, "\\*\\*(.*?)\\*\\*", true, Integer.valueOf(R.color.tint2), Float.valueOf(1.0f), false, this.context, 16, null);
            applyStyle(spannableStringBuilder, "(?m)^\\s*[0-9]{1,2}\\.\\s+", true, Integer.valueOf(R.color.tint), Float.valueOf(2.0f), false, this.context);
            applyDrawableStyle$default(this, spannableStringBuilder, "(?m)^\\s*\\*\\s+", R.drawable.ic_achievement_point_span, this.context, view, false, 0, 48, null);
            applyDrawableStyle$default(this, spannableStringBuilder, "(?m)^---\\s*$", R.drawable.line_divider, this.context, view, true, 0, 32, null);
            view.setText(spannableStringBuilder);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$MessageType;", "", "<init>", "(Ljava/lang/String;I)V", "HUMAN", "AI", "PROMTS", "FOLLOW_UP", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class MessageType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MessageType[] $VALUES;
        public static final MessageType HUMAN = new MessageType("HUMAN", 0);
        public static final MessageType AI = new MessageType("AI", 1);
        public static final MessageType PROMTS = new MessageType("PROMTS", 2);
        public static final MessageType FOLLOW_UP = new MessageType("FOLLOW_UP", 3);

        private static final /* synthetic */ MessageType[] $values() {
            return new MessageType[]{HUMAN, AI, PROMTS, FOLLOW_UP};
        }

        static {
            MessageType[] messageTypeArr$values = $values();
            $VALUES = messageTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(messageTypeArr$values);
        }

        private MessageType(String str, int i) {
        }

        public static MessageType valueOf(String str) {
            return (MessageType) Enum.valueOf(MessageType.class, str);
        }

        public static MessageType[] values() {
            return (MessageType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$NonMessageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "message", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter$Message;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static class NonMessageHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NonMessageHolder(View view) {
            super(view);
            view.getClass();
        }

        public void bind(Message message) {
            message.getClass();
        }
    }

    public AiMessageRecyclerAdapter(Context context, RecyclerView recyclerView, View view, View view2) {
        context.getClass();
        recyclerView.getClass();
        view.getClass();
        view2.getClass();
        this.h = new Handler();
        this.context = context;
        this.recycler = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.messages = arrayList;
        this.viewPrompt = view;
        this.viewFollowUp = view2;
        arrayList.add(new Message("", MessageType.FOLLOW_UP));
        arrayList.add(new Message("", MessageType.PROMTS));
        hideFollowUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addMessage$lambda$0(AiMessageRecyclerAdapter aiMessageRecyclerAdapter) {
        aiMessageRecyclerAdapter.recycler.smoothScrollToPosition(aiMessageRecyclerAdapter.messages.size() - 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addMessage$lambda$1(AiMessageRecyclerAdapter aiMessageRecyclerAdapter) {
        aiMessageRecyclerAdapter.recycler.smoothScrollToPosition(aiMessageRecyclerAdapter.messages.size() - 4);
    }

    public final void addMessage(String text, MessageType type) {
        text.getClass();
        type.getClass();
        this.messages.add(getMessagePosition(), new Message(text, type));
        notifyDataSetChanged();
        if (type == MessageType.HUMAN && this.messages.size() > 2) {
            final int i = 0;
            this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.ai.AiMessageRecyclerAdapter$$ExternalSyntheticLambda0
                public final /* synthetic */ AiMessageRecyclerAdapter f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    AiMessageRecyclerAdapter aiMessageRecyclerAdapter = this.f$0;
                    switch (i2) {
                        case 0:
                            AiMessageRecyclerAdapter.addMessage$lambda$0(aiMessageRecyclerAdapter);
                            break;
                        default:
                            AiMessageRecyclerAdapter.addMessage$lambda$1(aiMessageRecyclerAdapter);
                            break;
                    }
                }
            }, 100L);
        } else {
            if (type != MessageType.AI || this.messages.size() <= 3) {
                return;
            }
            final int i2 = 1;
            this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.ai.AiMessageRecyclerAdapter$$ExternalSyntheticLambda0
                public final /* synthetic */ AiMessageRecyclerAdapter f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i22 = i2;
                    AiMessageRecyclerAdapter aiMessageRecyclerAdapter = this.f$0;
                    switch (i22) {
                        case 0:
                            AiMessageRecyclerAdapter.addMessage$lambda$0(aiMessageRecyclerAdapter);
                            break;
                        default:
                            AiMessageRecyclerAdapter.addMessage$lambda$1(aiMessageRecyclerAdapter);
                            break;
                    }
                }
            }, 100L);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.messages.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.messages.get(position).getType().ordinal();
    }

    public final int getMessagePosition() {
        return RangesKt.coerceAtLeast(this.messages.size() - 2, 0);
    }

    public final void hideFollowUp() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.viewFollowUp;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.height = 0;
        }
        View view2 = this.viewFollowUp;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.viewFollowUp;
        if (view3 != null) {
            view3.requestLayout();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.getClass();
        ((NonMessageHolder) holder).bind(this.messages.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parent.getClass();
        if (viewType == MessageType.HUMAN.ordinal()) {
            InflatorUtil.Companion companion = InflatorUtil.INSTANCE;
            Context context = parent.getContext();
            context.getClass();
            View viewInflate = companion.get(context).inflate(R.layout.activity_ai_bubble_me, parent, false);
            viewInflate.getClass();
            return new MessageHolder(this.context, viewInflate, this.tts);
        }
        if (viewType == MessageType.AI.ordinal()) {
            InflatorUtil.Companion companion2 = InflatorUtil.INSTANCE;
            Context context2 = parent.getContext();
            context2.getClass();
            View viewInflate2 = companion2.get(context2).inflate(R.layout.activity_ai_bubble_ai, parent, false);
            viewInflate2.getClass();
            return new MessageHolder(this.context, viewInflate2, this.tts);
        }
        if (viewType == MessageType.PROMTS.ordinal()) {
            View view = this.viewPrompt;
            view.getClass();
            return new NonMessageHolder(view);
        }
        View view2 = this.viewFollowUp;
        view2.getClass();
        return new NonMessageHolder(view2);
    }

    public final void setTts(TextToSpeech textToSpeech) {
        this.tts = textToSpeech;
    }

    public final void showFollowUp() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.viewFollowUp;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.height = -2;
        }
        View view2 = this.viewFollowUp;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.viewFollowUp;
        if (view3 != null) {
            view3.requestLayout();
        }
        notifyDataSetChanged();
    }
}
