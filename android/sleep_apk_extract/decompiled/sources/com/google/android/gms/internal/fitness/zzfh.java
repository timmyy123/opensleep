package com.google.android.gms.internal.fitness;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfh {
    private static final String[] zzb = {"in_vehicle", "biking", "on_foot", "still", "unknown", "tilting", "exiting_vehicle", "walking", "running", "aerobics", "badminton", "baseball", "basketball", "biathlon", "biking.hand", "biking.mountain", "biking.road", "biking.spinning", "biking.stationary", "biking.utility", "boxing", "calisthenics", "circuit_training", "cricket", "dancing", "elliptical", "fencing", "football.american", "football.australian", "football.soccer", "frisbee_disc", "gardening", "golf", "gymnastics", "handball", "hiking", "hockey", "horseback_riding", "housework", "jump_rope", "kayaking", "kettlebell_training", "kickboxing", "kitesurfing", "martial_arts", "meditation", "martial_arts.mixed", "p90x", "paragliding", "pilates", "polo", "racquetball", "rock_climbing", "rowing", "rowing.machine", "rugby", "running.jogging", "running.sand", "running.treadmill", "sailing", "scuba_diving", "skateboarding", "skating", "skating.cross", "skating.inline", "skiing", "skiing.back_country", "skiing.cross_country", "skiing.downhill", "skiing.kite", "skiing.roller", "sledding", "sleep", "snowboarding", "snowmobile", "snowshoeing", "squash", "stair_climbing", "stair_climbing.machine", "standup_paddleboarding", "strength_training", "surfing", "swimming", "swimming.pool", "swimming.open_water", "table_tennis", "team_sports", "tennis", "treadmill", "volleyball", "volleyball.beach", "volleyball.indoor", "wakeboarding", "walking.fitness", "walking.nordic", "walking.treadmill", "water_polo", "weightlifting", "wheelchair", "windsurfing", "yoga", "zumba", "diving", "ergometer", "ice_skating", "skating.indoor", "curling", "kick_scooter", "other", "sleep.light", "sleep.deep", "sleep.rem", "sleep.awake", "crossfit", "interval_training.high_intensity", "interval_training", "walking.stroller", "elevator", "escalator", "archery", "softball", "flossing", "guided_breathing", "walking.paced"};

    public static int zza(String str) {
        for (int i = 0; i < 124; i++) {
            if (zzb[i].equals(str)) {
                return i;
            }
        }
        return 4;
    }

    public static String zzb(int i) {
        String str;
        return (i < 0 || i >= 124 || (str = zzb[i]) == null) ? "unknown" : str;
    }
}
