package me.badbones69.crazyauctions.version;

import me.badbones69.crazyauctions.Main;
import org.bukkit.Bukkit;

public class VersionChecker {

    private static Version version = Version.v1_7_R4;

    public static void initialize(){
        version = calculateVersion();
        Main.instace.getLogger().info("Server Minecraft Version " + version.getShortVersion() + " !");
    }

    public enum Version {
        v1_7_R1(171, "v1_7"),
        v1_7_R2(172, "v1_7"),
        v1_7_R3(173, "v1_7"),
        v1_7_R4(174, "v1_7"),
        v1_8_R1(181, "v1_8"),
        v1_8_R2(182, "v1_8"),
        v1_8_R3(183, "v1_8"),
        v1_9_R1(191, "v1_9"),
        v1_9_R2(192, "v1_9"),
        v1_10_R1(1101, "v1_10"),
        v1_11_R1(1111, "v1_11"),
        v1_11_R2(1112, "v1_11"),
        v1_12_R1(1121, "v1_12"),
        v1_12_R2(1122, "v1_12"),
        v1_13_R1(1131, "v1_13"),
        v1_13_R2(1132, "v1_13"),
        v1_14_R1(1141, "v1_14"),
        v1_14_R2(1142, "v1_14"),
        v1_15_R1(1151, "v1_15"),
        v1_15_R2(1152, "v1_15");

        private Integer value;
        private String shortVersion;

        Version(Integer value, String ShortVersion) {
            this.value = value;
            shortVersion = ShortVersion;
        }

        public Integer getValue() {
            return value;
        }

        public String getShortVersion() {
            return shortVersion;
        }

        public static Version getCurrent() {
            String[] v = Bukkit.getServer().getClass().getPackage().getName().split("\\.");
            String vv = v[v.length - 1];
            for (Version one : values()) {
                if (one.name().equalsIgnoreCase(vv))
                    return one;
            }
            return null;
        }

        public boolean isLower(Version version) {
            return getValue() < version.getValue();
        }

        public boolean isHigher(Version version) {
            return getValue() > version.getValue();
        }

        public boolean isEqualOrLower(Version version) {
            return getValue() <= version.getValue();
        }

        public boolean isEqualOrHigher(Version version) {
            return getValue() >= version.getValue();
        }

        public static boolean isCurrentEqualOrHigher(Version v) {
            return version.getValue() >= v.getValue();
        }
    }

    public static Version getCurrent() {
        return version;
    }

    public static Version calculateVersion() {
        String[] v = Bukkit.getServer().getClass().getPackage().getName().split("\\.");
        String vv = v[v.length - 1];
        for (Version one : Version.values()) {
            if (one.name().equalsIgnoreCase(vv)) {
                return one;
            }
        }
        return null;
    }

    public boolean isLower(Version v) {
        return version.getValue() < v.getValue();
    }

    public boolean isLowerEquals(Version v) {
        return version.getValue() <= v.getValue();
    }

    public boolean isHigher(Version v) {
        return version.getValue() > v.getValue();
    }

    public boolean isHigherEquals(Version v) {
        return version.getValue() >= v.getValue();
    }
}
