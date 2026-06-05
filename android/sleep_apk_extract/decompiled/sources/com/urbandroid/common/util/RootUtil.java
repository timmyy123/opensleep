package com.urbandroid.common.util;

import android.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class RootUtil {

    public static class ExecShell {

        public enum SHELL_CMD {
            check_su_binary(new String[]{"/system/xbin/which", "su"});

            String[] command;

            SHELL_CMD(String[] strArr) {
                this.command = strArr;
            }
        }

        public ArrayList<String> executeCommand(SHELL_CMD shell_cmd) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Process processExec = Runtime.getRuntime().exec(shell_cmd.command);
                new BufferedWriter(new OutputStreamWriter(processExec.getOutputStream()));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            return arrayList;
                        }
                        arrayList.add(line);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public boolean checkRootMethod1() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public boolean checkRootMethod2() {
        try {
            return new File("/system/app/Superuser.apk").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean checkRootMethod3() {
        return new ExecShell().executeCommand(ExecShell.SHELL_CMD.check_su_binary) != null;
    }

    public boolean isDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }
}
