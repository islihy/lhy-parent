package defaultmethods;

/**
 * @author biezhi
 * @date 2018/2/11
 */
public class CalculatorFactory {

    public static Calculator getInstance(){
        return new BasicCalculator();
    }

}
