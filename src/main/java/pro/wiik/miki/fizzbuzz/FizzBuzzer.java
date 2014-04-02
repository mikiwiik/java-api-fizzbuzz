package pro.wiik.miki.fizzbuzz;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

@Service
public class FizzBuzzer {

    private final static BigInteger three = BigInteger.valueOf(3L);
    private final static BigInteger five = BigInteger.valueOf(5L);

    private static final String FIZZ_BUZZ = "fizz buzz";
    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    @NotNull
    public String evaluate(@NotNull BigInteger number) {
        if (number.mod(three).equals(ZERO)) {
            if (number.mod(five).equals(ZERO)) {
                return FIZZ_BUZZ;
            } else {
                return FIZZ;
            }
        } else if (number.mod(five).equals(ZERO)) {
            return BUZZ;
        }

        return number.toString();
    }

}
