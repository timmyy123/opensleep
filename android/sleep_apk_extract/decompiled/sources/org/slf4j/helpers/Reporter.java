package org.slf4j.helpers;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Reporter {
    private static final String[] SYSOUT_KEYS = {"System.out", "stdout", "sysout"};
    private static final TargetChoice TARGET_CHOICE = getTargetChoice();
    private static final Level INTERNAL_VERBOSITY = initVerbosity();

    public enum Level {
        DEBUG(0),
        INFO(1),
        WARN(2),
        ERROR(3);

        int levelInt;

        Level(int i) {
            this.levelInt = i;
        }
    }

    public enum TargetChoice {
        Stderr,
        Stdout
    }

    public static void debug(String str) {
        if (isEnabledFor(Level.DEBUG)) {
            getTarget().println("SLF4J(D): " + str);
        }
    }

    public static final void error(String str, Throwable th) {
        getTarget().println("SLF4J(E): " + str);
        getTarget().println("SLF4J(E): Reported exception:");
        th.printStackTrace(getTarget());
    }

    private static PrintStream getTarget() {
        return TARGET_CHOICE.ordinal() != 1 ? System.err : System.out;
    }

    private static TargetChoice getTargetChoice() {
        String property = System.getProperty("slf4j.internal.report.stream");
        if (property == null || property.isEmpty()) {
            return TargetChoice.Stderr;
        }
        for (String str : SYSOUT_KEYS) {
            if (str.equalsIgnoreCase(property)) {
                return TargetChoice.Stdout;
            }
        }
        return TargetChoice.Stderr;
    }

    public static void info(String str) {
        if (isEnabledFor(Level.INFO)) {
            getTarget().println("SLF4J(I): " + str);
        }
    }

    private static Level initVerbosity() {
        String property = System.getProperty("slf4j.internal.verbosity");
        return (property == null || property.isEmpty()) ? Level.INFO : property.equalsIgnoreCase("DEBUG") ? Level.DEBUG : property.equalsIgnoreCase("ERROR") ? Level.ERROR : property.equalsIgnoreCase("WARN") ? Level.WARN : Level.INFO;
    }

    public static boolean isEnabledFor(Level level) {
        return level.levelInt >= INTERNAL_VERBOSITY.levelInt;
    }

    public static final void warn(String str) {
        if (isEnabledFor(Level.WARN)) {
            getTarget().println("SLF4J(W): " + str);
        }
    }

    public static final void error(String str) {
        getTarget().println("SLF4J(E): " + str);
    }
}
