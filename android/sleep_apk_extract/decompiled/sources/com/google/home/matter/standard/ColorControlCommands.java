package com.google.home.matter.standard;

import com.google.home.matter.standard.ColorControlTrait;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J8\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/ColorControlCommands;", "", "Lkotlin/UByte;", "hue", "Lcom/google/home/matter/standard/ColorControlTrait$HueDirection;", "direction", "Lkotlin/UShort;", "transitionTime", "optionsMask", "optionsOverride", "", "moveToHue-B-LVVrw", "(BLcom/google/home/matter/standard/ColorControlTrait$HueDirection;SBBLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveToHue", "colorTemperatureMireds", "moveToColorTemperature-ods4cfk", "(SSBBLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveToColorTemperature", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ColorControlCommands {
    /* JADX INFO: renamed from: moveToColorTemperature-ods4cfk, reason: not valid java name */
    Object mo609moveToColorTemperatureods4cfk(short s, short s2, byte b, byte b2, Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: moveToHue-B-LVVrw, reason: not valid java name */
    Object mo610moveToHueBLVVrw(byte b, ColorControlTrait.HueDirection hueDirection, short s, byte b2, byte b3, Continuation<? super Unit> continuation);
}
