package io.github.zeroone3010.yahueapi.discovery;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
final class MDNSResponseParser {
    private static final int A_RECORD_TYPE = 1;
    private static final int EXPECTED_ANSWER_COUNT = 1;
    private static final int EXPECTED_QUESTION_COUNT = 1;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) MDNSResponseParser.class);

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private byte[] f77data;
    private int expectedAnswerRdLength;
    private List<String> expectedLabels;
    private int bytePointer = 0;
    private int additionalResourceRecordsCount = 0;
    private Map<Integer, List<String>> names = new HashMap();

    public MDNSResponseParser(DatagramPacket datagramPacket, List<String> list) {
        this.f77data = datagramPacket.getData();
        this.expectedLabels = Collections.unmodifiableList(list);
    }

    private void expect(int i, int i2) {
        int i3 = i & PHIpAddressSearchManager.END_IP_SCAN;
        if (i3 != i2) {
            throw new MDNSException(String.format("Expected '%02x', was '%02x' at %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.bytePointer - 1)));
        }
    }

    private String matchAdditionalResourceRecords() {
        for (int i = 0; i < this.additionalResourceRecordsCount; i++) {
            String additionalResourceAndReturnIfARecord = readAdditionalResourceAndReturnIfARecord();
            if (additionalResourceAndReturnIfARecord != null) {
                return additionalResourceAndReturnIfARecord;
            }
        }
        return null;
    }

    private void matchAdditionalResourceRecordsCount() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        int i2 = i + 1;
        this.bytePointer = i2;
        int i3 = bArr[i] << 8;
        this.bytePointer = i + 2;
        int i4 = bArr[i2] | i3;
        this.additionalResourceRecordsCount = i4;
        if (i4 < 1) {
            throw new MDNSException("At least one additional resource record is expected");
        }
    }

    private void matchAnswerClass() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        this.bytePointer = i + 1;
        expect(bArr[i], 0);
        byte[] bArr2 = this.f77data;
        int i2 = this.bytePointer;
        this.bytePointer = i2 + 1;
        expect(bArr2[i2], 1);
    }

    private void matchAnswerCount() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        this.bytePointer = i + 1;
        expect(bArr[i], 0);
        byte[] bArr2 = this.f77data;
        int i2 = this.bytePointer;
        this.bytePointer = i2 + 1;
        expect(bArr2[i2], 1);
    }

    private void matchAnswerName() {
        matchNamesInAnswer(this.expectedLabels);
    }

    private void matchAnswerRData() {
        this.bytePointer += this.expectedAnswerRdLength;
    }

    private void matchAnswerRdLength() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        int i2 = i + 1;
        this.bytePointer = i2;
        int i3 = bArr[i] << 8;
        this.bytePointer = i + 2;
        int i4 = bArr[i2] | i3;
        this.expectedAnswerRdLength = i4;
        if (i4 >= 1) {
            return;
        }
        throw new MDNSException("Answer length is unacceptable, " + this.expectedAnswerRdLength);
    }

    private void matchAnswerTtl() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        int i2 = i + 1;
        this.bytePointer = i2;
        int i3 = bArr[i] << 24;
        int i4 = i + 2;
        this.bytePointer = i4;
        int i5 = (bArr[i2] << 16) | i3;
        int i6 = i + 3;
        this.bytePointer = i6;
        int i7 = i5 | (bArr[i4] << 8);
        this.bytePointer = i + 4;
        if ((bArr[i6] | i7) == 0) {
            throw new MDNSException("TTL found to be 0");
        }
    }

    private void matchAnswerType() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        this.bytePointer = i + 1;
        expect(bArr[i], 0);
        byte[] bArr2 = this.f77data;
        int i2 = this.bytePointer;
        this.bytePointer = i2 + 1;
        expect(bArr2[i2], 12);
    }

    private void matchAuthorityResourceRecords() {
        this.bytePointer += 2;
    }

    private void matchFlags() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        this.bytePointer = i + 1;
        expect(bArr[i] & 128, 128);
        byte[] bArr2 = this.f77data;
        int i2 = this.bytePointer;
        this.bytePointer = i2 + 1;
        expect(bArr2[i2] & 15, 0);
    }

    private void matchId() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        this.bytePointer = i + 1;
        expect(bArr[i], FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        byte[] bArr2 = this.f77data;
        int i2 = this.bytePointer;
        this.bytePointer = i2 + 1;
        expect(bArr2[i2], 239);
    }

    private void matchNames(List<String> list) {
        int i = this.bytePointer;
        while (true) {
            byte[] bArr = this.f77data;
            int i2 = this.bytePointer;
            byte b = bArr[i2];
            this.bytePointer = i2 + 1;
            if (b == 0) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < b; i3++) {
                sb.append(Character.valueOf((char) this.f77data[this.bytePointer]));
                this.bytePointer++;
            }
            List<String> orDefault = this.names.getOrDefault(Integer.valueOf(i), new ArrayList());
            orDefault.add(sb.toString());
            this.names.put(Integer.valueOf(i), orDefault);
        }
        logger.debug("Names: " + this.names);
        List<String> list2 = this.names.get(Integer.valueOf(i));
        if (list == null || Objects.equals(list2, list)) {
            return;
        }
        throw new MDNSException("Expected to see " + list + " as labels, got " + list2 + " instead.");
    }

    private void matchNamesInAnswer(List<String> list) {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        if ((bArr[i] & 192) != 192) {
            matchNames(list);
            return;
        }
        int i2 = i + 1;
        this.bytePointer = i2;
        int i3 = (bArr[i] & 63) << 8;
        this.bytePointer = i + 2;
        int i4 = bArr[i2] | i3;
        Logger logger2 = logger;
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i4, "The answer has a pointer to ", " which means ");
        sbM65m.append(this.names.get(Integer.valueOf(i4)));
        logger2.debug(sbM65m.toString());
    }

    private void matchQuestionClass() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        this.bytePointer = i + 1;
        expect(bArr[i], 0);
        byte[] bArr2 = this.f77data;
        int i2 = this.bytePointer;
        this.bytePointer = i2 + 1;
        expect(bArr2[i2], PHIpAddressSearchManager.END_IP_SCAN);
    }

    private void matchQuestionCount() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        this.bytePointer = i + 1;
        expect(bArr[i], 0);
        byte[] bArr2 = this.f77data;
        int i2 = this.bytePointer;
        this.bytePointer = i2 + 1;
        expect(bArr2[i2], 1);
    }

    private void matchQuestionName() {
        matchNames(this.expectedLabels);
    }

    private void matchQuestionType() {
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        this.bytePointer = i + 1;
        expect(bArr[i], 0);
        byte[] bArr2 = this.f77data;
        int i2 = this.bytePointer;
        this.bytePointer = i2 + 1;
        expect(bArr2[i2], 12);
    }

    private String readAdditionalResourceAndReturnIfARecord() {
        matchNamesInAnswer(null);
        byte[] bArr = this.f77data;
        int i = this.bytePointer;
        int i2 = i + 1;
        this.bytePointer = i2;
        int i3 = bArr[i] << 8;
        this.bytePointer = i + 2;
        if ((bArr[i2] | i3) != 1) {
            int i4 = i + 9;
            this.bytePointer = i4;
            int i5 = bArr[i + 8] << 8;
            int i6 = i + 10;
            this.bytePointer = i6;
            this.bytePointer = i6 + (bArr[i4] | i5);
            return null;
        }
        matchAnswerClass();
        matchAnswerTtl();
        byte[] bArr2 = this.f77data;
        int i7 = this.bytePointer;
        this.bytePointer = i7 + 1;
        expect(bArr2[i7], 0);
        byte[] bArr3 = this.f77data;
        int i8 = this.bytePointer;
        this.bytePointer = i8 + 1;
        expect(bArr3[i8], 4);
        StringBuilder sb = new StringBuilder();
        byte[] bArr4 = this.f77data;
        int i9 = this.bytePointer;
        this.bytePointer = i9 + 1;
        sb.append(bArr4[i9] & 255);
        sb.append(".");
        byte[] bArr5 = this.f77data;
        int i10 = this.bytePointer;
        this.bytePointer = i10 + 1;
        sb.append(bArr5[i10] & 255);
        sb.append(".");
        byte[] bArr6 = this.f77data;
        int i11 = this.bytePointer;
        this.bytePointer = i11 + 1;
        sb.append(bArr6[i11] & 255);
        sb.append(".");
        byte[] bArr7 = this.f77data;
        int i12 = this.bytePointer;
        this.bytePointer = i12 + 1;
        sb.append(bArr7[i12] & 255);
        return sb.toString();
    }

    public String parse() {
        matchId();
        matchFlags();
        matchQuestionCount();
        matchAnswerCount();
        matchAuthorityResourceRecords();
        matchAdditionalResourceRecordsCount();
        matchQuestionName();
        matchQuestionType();
        matchQuestionClass();
        matchAnswerName();
        matchAnswerType();
        matchAnswerClass();
        matchAnswerTtl();
        matchAnswerRdLength();
        matchAnswerRData();
        return matchAdditionalResourceRecords();
    }
}
