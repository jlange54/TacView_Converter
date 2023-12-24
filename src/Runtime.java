public class Runtime {

    private static long startTime;

    public static long currentTime () {
        return System.currentTimeMillis();
    }

    public static void start () {
       startTime = currentTime();
    }

    public static long end (timeUnit timeUnit) {
        long endTime = currentTime();
        long duration = endTime - startTime;

        switch (timeUnit) {
            case seconds:
                return duration/1000L;
            case minutes:
                return duration/60000L;
            case ms:
            default:
                return duration;
        }
    }

    public enum timeUnit {
        ms, seconds, minutes
    }
}
