package com.urbandroid.sleep.captcha;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.Experiments;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleMathCaptcha extends BaseMathCaptcha {
    private Button[] answers = new Button[4];
    private TextView question;

    /* JADX INFO: Access modifiers changed from: private */
    public void answerClicked(int i) {
        userInteraction();
        Logger.logInfo("Math clicked index " + i);
        answerProvided(((Integer) this.answers[i].getTag()).intValue());
    }

    private Integer[] generateAnswerSet(int i, int i2) {
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i));
        while (hashSet.size() < i2) {
            int iNextInt = BaseMathCaptcha.random.nextInt((Math.abs(i) * 3) + 17);
            if (i < 0) {
                iNextInt *= -1;
            }
            Logger.logInfo("Math answer " + iNextInt);
            hashSet.add(Integer.valueOf(iNextInt));
        }
        LinkedList linkedList = new LinkedList(hashSet);
        Collections.shuffle(linkedList, BaseMathCaptcha.random);
        Integer[] numArr = (Integer[]) linkedList.toArray(new Integer[0]);
        for (int i3 = 0; i3 < numArr.length; i3++) {
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i3, "Math index ", " answer ");
            sbM65m.append(numArr[i3]);
            Logger.logInfo(sbM65m.toString());
        }
        return numArr;
    }

    @Override // com.urbandroid.sleep.captcha.BaseMathCaptcha
    public void initializeLayoutOnCreate() {
        setContentView(R.layout.captcha_math);
        EdgeToEdgeUtil.insetsTop(findViewById(R.id.type_math_captcha));
        this.question = (TextView) findViewById(R.id.math_question);
        final int i = 0;
        this.answers[0] = (Button) findViewById(R.id.math_answer_1);
        this.answers[1] = (Button) findViewById(R.id.math_answer_2);
        this.answers[2] = (Button) findViewById(R.id.math_answer_3);
        this.answers[3] = (Button) findViewById(R.id.math_answer_4);
        while (true) {
            Button[] buttonArr = this.answers;
            if (i >= buttonArr.length) {
                return;
            }
            buttonArr[i].setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.SimpleMathCaptcha.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SimpleMathCaptcha.this.answerClicked(i);
                }
            });
            i++;
        }
    }

    @Override // com.urbandroid.sleep.captcha.BaseMathCaptcha
    public Object setupValuesExtension(int i, int i2, int i3, int i4, int i5, int i6) {
        return generateAnswerSet(i6, this.answers.length);
    }

    @Override // com.urbandroid.sleep.captcha.BaseMathCaptcha
    public void showValues(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        StringBuilder sb = new StringBuilder();
        Fragment$$ExternalSyntheticOutline1.m(sb, i5 != 1 ? "(" : "", i, "x", i2);
        sb.append(MqttTopic.SINGLE_LEVEL_WILDCARD);
        sb.append(i3);
        sb.append(i4 != 0 ? FileInsert$$ExternalSyntheticOutline0.m(i4, "-") : "");
        String strM = FileInsert$$ExternalSyntheticOutline0.m(sb, i5 != 1 ? FileInsert$$ExternalSyntheticOutline0.m(i5, ")/") : "", "=?");
        this.question.setText(strM);
        Logger.logInfo("Math text ".concat(strM));
        Integer[] numArr = (Integer[]) obj;
        for (int i7 = 0; i7 < this.answers.length; i7++) {
            if (Experiments.getInstance().isOurExperimentalPhone() && numArr[i7].intValue() == i6) {
                this.answers[i7].setText("--> ".concat(String.valueOf(numArr[i7])));
            } else {
                this.answers[i7].setText(String.valueOf(numArr[i7]));
            }
            this.answers[i7].setTag(numArr[i7]);
        }
    }
}
