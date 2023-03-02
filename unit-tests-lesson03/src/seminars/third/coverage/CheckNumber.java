package seminars.third.coverage;

public class CheckNumber {
    /**
     * Метод для ДЗ.
     * Метод проверяет,является ли целое число записанное в переменную n,
     * чётным (true) либо нечётным (false)
     */
    public static boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
