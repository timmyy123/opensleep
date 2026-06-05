package com.google.android.gms.internal.ads;

import android.media.AudioDescriptor;
import android.media.AudioDeviceInfo;
import android.media.AudioProfile;
import android.os.Build;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzub {
    private static final zzgwm zza = zzgwm.zzj(12);

    /* JADX WARN: Removed duplicated region for block: B:117:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzgwm zza(AudioDeviceInfo audioDeviceInfo) {
        int type;
        zzgwm zzgwmVarZzi;
        int speakerLayoutChannelMask;
        if (!zztu.zza(audioDeviceInfo.getType())) {
            if (audioDeviceInfo.getType() == 1) {
                return zzgwm.zzj(4);
            }
            if (audioDeviceInfo.getType() == 2) {
                if (Build.VERSION.SDK_INT >= 36 && (speakerLayoutChannelMask = audioDeviceInfo.getSpeakerLayoutChannelMask()) != 0 && speakerLayoutChannelMask != 1) {
                    return zzgwm.zzj(Integer.valueOf(speakerLayoutChannelMask));
                }
                zzeg.zzc("SpeakerLayoutUtil", "Built-in speaker's getSpeakerLayoutChannelMask not usable, defaulting to stereo.");
                return zza;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 31 && audioDeviceInfo.getType() == 10) {
                zzgwm zzgwmVarZzb = zzb(audioDeviceInfo);
                if (!zzgwmVarZzb.isEmpty()) {
                    return zzgwmVarZzb;
                }
                zzgwm zzgwmVarZza = zzqq.zza(audioDeviceInfo.getAudioDescriptors());
                if (!zzgwmVarZza.isEmpty()) {
                    return zzgwmVarZza;
                }
            } else if (i >= 31) {
                int type2 = audioDeviceInfo.getType();
                if (i >= 31 && type2 == 29) {
                    zzgwm zzgwmVarZzb2 = zzb(audioDeviceInfo);
                    if (!zzgwmVarZzb2.isEmpty()) {
                        return zzgwmVarZzb2;
                    }
                    List<AudioDescriptor> audioDescriptors = audioDeviceInfo.getAudioDescriptors();
                    if (i >= 34) {
                        if (i < 34 || audioDescriptors == null) {
                            zzgwmVarZzi = zzgwm.zzi();
                        } else {
                            ArrayList arrayList = new ArrayList();
                            Iterator<AudioDescriptor> it = audioDescriptors.iterator();
                            while (it.hasNext()) {
                                AudioDescriptor audioDescriptorM364m = zzbuy$$ExternalSyntheticBUOutline0.m364m((Object) it.next());
                                if (audioDescriptorM364m.getStandard() == 2) {
                                    byte[] descriptor = audioDescriptorM364m.getDescriptor();
                                    int length = descriptor.length;
                                    if (length != 3) {
                                        zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(length).length() + 21), "Invalid SADB length: ", length, "AudioDescriptorUtil");
                                    } else {
                                        if (Build.VERSION.SDK_INT >= 34) {
                                            byte b = descriptor[0];
                                            i = 1 == (b & 1) ? 12 : 0;
                                            if ((b & 2) != 0) {
                                                i |= 32;
                                            }
                                            if ((b & 4) != 0) {
                                                i |= 16;
                                            }
                                            if ((b & 8) != 0) {
                                                i |= 192;
                                            }
                                            if ((b & 16) != 0) {
                                                i |= 1024;
                                            }
                                            if ((b & 32) != 0) {
                                                i |= 768;
                                            }
                                            if ((b & 128) != 0) {
                                                i |= 201326592;
                                            }
                                            byte b2 = descriptor[1];
                                            if ((b2 & 1) != 0) {
                                                i |= 81920;
                                            }
                                            if ((b2 & 2) != 0) {
                                                i |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                                            }
                                            if ((b2 & 4) != 0) {
                                                i |= 32768;
                                            }
                                            if ((b2 & 8) != 0) {
                                                i |= 6144;
                                            }
                                            if ((b2 & 16) != 0) {
                                                i |= 33554432;
                                            }
                                            if ((b2 & 32) != 0) {
                                                i |= 262144;
                                            }
                                            if ((b2 & 64) != 0) {
                                                i |= 6144;
                                            }
                                            if ((b2 & 128) != 0) {
                                                i |= 3145728;
                                            }
                                            byte b3 = descriptor[2];
                                            if ((b3 & 1) != 0) {
                                                i |= 655360;
                                            }
                                            if ((b3 & 2) != 0) {
                                                i = 8388608 | i;
                                            }
                                            if ((b3 & 4) != 0) {
                                                i |= 20971520;
                                            }
                                        }
                                        arrayList.add(Integer.valueOf(i));
                                    }
                                }
                            }
                            arrayList.sort(zzqo.zza);
                            zzgwmVarZzi = zzgwm.zzq(arrayList);
                        }
                        if (!zzgwmVarZzi.isEmpty()) {
                            return zzgwmVarZzi;
                        }
                    }
                    zzgwm zzgwmVarZza2 = zzqq.zza(audioDescriptors);
                    if (!zzgwmVarZza2.isEmpty()) {
                        return zzgwmVarZza2;
                    }
                } else if (i >= 31 && ((type = audioDeviceInfo.getType()) == 11 || type == 12 || (i >= 31 && type == 22))) {
                    zzgwm zzgwmVarZzb3 = zzb(audioDeviceInfo);
                    if (!zzgwmVarZzb3.isEmpty()) {
                        return zzgwmVarZzb3;
                    }
                }
            }
        }
        return zza;
    }

    private static zzgwm zzb(AudioDeviceInfo audioDeviceInfo) {
        List<AudioProfile> audioProfiles = audioDeviceInfo.getAudioProfiles();
        TreeSet treeSet = new TreeSet(Comparator.comparing(zzua.zza).reversed());
        Iterator<AudioProfile> it = audioProfiles.iterator();
        while (it.hasNext()) {
            AudioProfile audioProfileM365m = zzbuy$$ExternalSyntheticBUOutline0.m365m((Object) it.next());
            if (audioProfileM365m.getEncapsulationType() != 1 && zzfl.zzD(audioProfileM365m.getFormat())) {
                for (int i : audioProfileM365m.getChannelMasks()) {
                    treeSet.add(Integer.valueOf(i));
                }
            }
        }
        return zzgwm.zzq(treeSet);
    }
}
