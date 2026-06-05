package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTextRangeSelector;
import com.airbnb.lottie.model.animatable.AnimatableTextStyle;
import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnimatableTextPropertiesParser {
    private static final JsonReader.Options PROPERTIES_NAMES = JsonReader.Options.of("s", "a");
    private static final JsonReader.Options ANIMATABLE_RANGE_PROPERTIES_NAMES = JsonReader.Options.of("s", "e", "o", "r");
    private static final JsonReader.Options ANIMATABLE_PROPERTIES_NAMES = JsonReader.Options.of("fc", "sc", "sw", "t", "o");

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        AnimatableTextStyle animatableTextStyle = null;
        AnimatableTextRangeSelector animatableTextRangeSelector = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(PROPERTIES_NAMES);
            if (iSelectName == 0) {
                animatableTextRangeSelector = parseAnimatableTextRangeSelector(jsonReader, lottieComposition);
            } else if (iSelectName != 1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                animatableTextStyle = parseAnimatableTextStyle(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(animatableTextStyle, animatableTextRangeSelector);
    }

    private static AnimatableTextRangeSelector parseAnimatableTextRangeSelector(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableIntegerValue integer = null;
        AnimatableIntegerValue integer2 = null;
        TextRangeUnits textRangeUnits = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(ANIMATABLE_RANGE_PROPERTIES_NAMES);
            if (iSelectName == 0) {
                animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (iSelectName == 1) {
                integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (iSelectName == 2) {
                integer2 = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (iSelectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt == 1 || iNextInt == 2) {
                    textRangeUnits = iNextInt == 1 ? TextRangeUnits.PERCENT : TextRangeUnits.INDEX;
                } else {
                    lottieComposition.addWarning("Unsupported text range units: " + iNextInt);
                    textRangeUnits = TextRangeUnits.INDEX;
                }
            }
        }
        jsonReader.endObject();
        if (animatableIntegerValue == null && integer != null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(0)));
        }
        return new AnimatableTextRangeSelector(animatableIntegerValue, integer, integer2, textRangeUnits);
    }

    private static AnimatableTextStyle parseAnimatableTextStyle(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        AnimatableColorValue color = null;
        AnimatableColorValue color2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableIntegerValue integer = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(ANIMATABLE_PROPERTIES_NAMES);
            if (iSelectName == 0) {
                color = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (iSelectName == 1) {
                color2 = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (iSelectName == 2) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (iSelectName == 3) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (iSelectName != 4) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return new AnimatableTextStyle(color, color2, animatableFloatValue, animatableFloatValue2, integer);
    }
}
