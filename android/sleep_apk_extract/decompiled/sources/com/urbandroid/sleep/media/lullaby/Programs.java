package com.urbandroid.sleep.media.lullaby;

import com.urbandroid.common.logging.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class Programs {
    private static Map<Integer, ProgramDefinition> programs;

    static {
        HashMap map = new HashMap();
        programs = map;
        map.put(0, new ProgramDefinition(new P[]{P.f(20, 41, 5), P.f(42, 30), P.f(30, 1), P.f(20, 43, 1), P.f(42, 30), P.f(35, 1), P.f(25, 43, 1), P.f(42, 30), P.f(35, 1), P.f(30, 43, 1), P.f(42, 1)}));
        programs.put(1, new ProgramDefinition(new P[]{P.f(20, 9, 7), P.f(8, 30), P.f(14, 1), P.f(18, 6, 1), P.f(8, 30), P.f(12, 1), P.f(16, 6, 1), P.f(8, 30), P.f(10, 1), P.f(14, 6, 1), P.f(8, 30), P.f(9, 1), P.f(12, 6, 1), P.f(8, 1)}));
        programs.put(2, new ProgramDefinition(new P[]{P.f(20, 5, 5), P.f(4, 30), P.f(10, 1), P.f(15, 3, 1), P.f(4, 30), P.f(7, 1), P.f(10, 3, 1), P.f(4, 30), P.f(6, 1), P.f(8, 3, 1), P.f(4, 30), P.f(6, 1), P.f(8, 3, 1), P.f(4, 1)}));
        programs.put(3, new ProgramDefinition(new P[]{P.f(20, 3, 5), P.f(2, 26), P.f(4, 1), P.f(6, 1, 1), P.f(2, 26), P.f(3, 1), P.f(5, 1, 1), P.f(2, 26), P.f(3, 1), P.f(4, 1, 1), P.f(2, 1)}));
        programs.put(4, new ProgramDefinition(new P[]{P.f(20, 13, 10), P.f(12, 30), P.f(15, 1), P.f(18, 10, 3), P.f(12, 30), P.f(14, 1), P.f(16, 10, 3), P.f(12, 30), P.f(13, 1), P.f(14, 10, 3), P.f(12, 30), P.f(12, 10, 1), P.f(10, 14, 1), P.f(14, 12, 1), P.f(12, 1)}));
        programs.put(5, new ProgramDefinition(new P[]{P.f(4, 19, 5), P.f(20, 30), P.f(12, 1), P.f(6, 22, 1), P.f(20, 30), P.f(14, 1), P.f(8, 22, 1), P.f(20, 30), P.f(16, 1), P.f(10, 22, 1), P.f(20, 30), P.f(18, 1), P.f(12, 22, 1), P.f(20, 1)}));
        programs.put(9, new ProgramDefinition(new P[]{P.f(20, 25, 2), P.f(25, 10, 2), P.f(10, 25, 2), P.f(25, 10, 2), P.f(10, 25, 2), P.f(25, 10, 1), P.f(10, 25, 1), P.f(25, 10, 1), P.f(10, 25, 1), P.f(25, 10, 1), P.f(10, 25, 1), P.f(25, 10, 1), P.f(10, 25, 1), P.f(25, 20, 1)}));
        programs.put(10, new ProgramDefinition(new P[]{P.f(8, 8, 100)}));
    }

    public static ProgramDefinition getProgram(int i) {
        ProgramDefinition programDefinition = programs.get(Integer.valueOf(i));
        Logger.logInfo("Program " + programDefinition + " index " + i);
        return programDefinition;
    }
}
