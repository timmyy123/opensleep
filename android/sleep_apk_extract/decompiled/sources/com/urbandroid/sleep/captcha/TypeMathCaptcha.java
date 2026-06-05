package com.urbandroid.sleep.captcha;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.BaseMathCaptcha;
import com.urbandroid.util.EdgeToEdgeUtil;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class TypeMathCaptcha extends BaseMathCaptcha {
    private EditText answer;
    private TextView question;
    private Button submit;

    /* JADX INFO: Access modifiers changed from: private */
    public void answer() {
        int i;
        try {
            i = Integer.parseInt(this.answer.getText().toString());
        } catch (Exception unused) {
            i = -1;
        }
        answerProvided(i);
    }

    private void registerNumberButton(final EditText editText, View view, final int i) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.TypeMathCaptcha.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TypeMathCaptcha.this.userInteraction();
                editText.setText(editText.getText().toString() + i);
                EditText editText2 = editText;
                editText2.setSelection(editText2.getText().toString().length());
            }
        });
    }

    @Override // com.urbandroid.sleep.captcha.BaseMathCaptcha
    public void answerProvided(int i) {
        BaseMathCaptcha.CaptchaStatus captchaStatus = this.status;
        if (i == captchaStatus.correctAnswer && captchaStatus.wrong) {
            captchaStatus.tries++;
        }
        super.answerProvided(i);
        if (i != this.status.correctAnswer) {
            this.answer.setText("");
        }
    }

    @Override // com.urbandroid.sleep.captcha.BaseMathCaptcha
    public void initializeLayoutOnCreate() {
        setContentView(R.layout.captcha_type_math);
        EdgeToEdgeUtil.insetsTop(findViewById(R.id.type_math_captcha));
        this.question = (TextView) findViewById(R.id.math_question);
        EditText editText = (EditText) findViewById(R.id.math_answer);
        this.answer = editText;
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.urbandroid.sleep.captcha.TypeMathCaptcha.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || i != 66) {
                    return false;
                }
                TypeMathCaptcha.this.answer();
                return true;
            }
        });
        Logger.logDebug("Text size " + this.question.getTextSize());
        Button button = (Button) findViewById(R.id.submit_math_answer);
        this.submit = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.TypeMathCaptcha.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TypeMathCaptcha.this.answer();
            }
        });
        registerNumberButton(this.answer, findViewById(R.id.button_0), 0);
        registerNumberButton(this.answer, findViewById(R.id.button_1), 1);
        registerNumberButton(this.answer, findViewById(R.id.button_2), 2);
        registerNumberButton(this.answer, findViewById(R.id.button_3), 3);
        registerNumberButton(this.answer, findViewById(R.id.button_4), 4);
        registerNumberButton(this.answer, findViewById(R.id.button_5), 5);
        registerNumberButton(this.answer, findViewById(R.id.button_6), 6);
        registerNumberButton(this.answer, findViewById(R.id.button_7), 7);
        registerNumberButton(this.answer, findViewById(R.id.button_8), 8);
        registerNumberButton(this.answer, findViewById(R.id.button_9), 9);
        findViewById(R.id.button_d).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.TypeMathCaptcha.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int length = TypeMathCaptcha.this.answer.getText().toString().length();
                TypeMathCaptcha typeMathCaptcha = TypeMathCaptcha.this;
                if (length > 1) {
                    typeMathCaptcha.answer.setText(TypeMathCaptcha.this.answer.getText().toString().substring(0, TypeMathCaptcha.this.answer.getText().toString().length() - 1));
                    TypeMathCaptcha.this.answer.setSelection(TypeMathCaptcha.this.answer.getText().toString().length());
                } else if (typeMathCaptcha.answer.getText().toString().length() == 1) {
                    TypeMathCaptcha.this.answer.setSelection(0);
                    TypeMathCaptcha.this.answer.setText("");
                }
            }
        });
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
        this.answer.setText("");
    }
}
