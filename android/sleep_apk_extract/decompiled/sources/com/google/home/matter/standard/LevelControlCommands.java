package com.google.home.matter.standard;

import com.google.home.matter.standard.LevelControlTrait;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J2\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H¦@¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/LevelControlCommands;", "", "Lkotlin/UByte;", "level", "Lkotlin/UShort;", "transitionTime", "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "optionsMask", "optionsOverride", "", "moveToLevel-igwrCe0", "(BLkotlin/UShort;Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveToLevel", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LevelControlCommands {
    /* JADX INFO: renamed from: moveToLevel-igwrCe0, reason: not valid java name */
    Object mo711moveToLeveligwrCe0(byte b, UShort uShort, LevelControlTrait.OptionsBitmap optionsBitmap, LevelControlTrait.OptionsBitmap optionsBitmap2, Continuation<? super Unit> continuation);
}
