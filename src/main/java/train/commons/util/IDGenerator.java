package train.commons.util;

/**
 * 生成各个字段的ID
 */
public class IDGenerator {

    private static final int LONG_ID_LENGTH = 18;

    public static Long generatorLongId() {
        Long result = 0L;
        int tmp = (int)(Math.random() * 10);
        tmp = tmp > 0 ? tmp : 1;
        for (int i = 1; i < IDGenerator.LONG_ID_LENGTH; i++) {
            result += (int)(Math.random() * 10) * 10;
        }
        return result;
    }

    public static Long generatorUniqueLongId() {
        Long result = System.currentTimeMillis();
        for (int i = 1; i < IDGenerator.LONG_ID_LENGTH - 15; i++) {
            result += (int)(Math.random() * 10) * 10;
        }
        return result;
    }
}
