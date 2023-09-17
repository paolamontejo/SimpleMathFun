import java.math.BigDecimal;

public class Division {

    public static double divide(double num1, double num2){
        double quotient = num1 / num2;
        BigDecimal bg = new BigDecimal(quotient);
        bg = bg.setScale(2, BigDecimal.ROUND_HALF_UP);
        quotient = bg.doubleValue();
        return quotient;
    }

}
