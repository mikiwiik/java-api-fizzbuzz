package pro.wiik.miki.fizzbuzz;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.concurrent.Immutable;
import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

@Immutable
@Service
public class FizzBuzzer {

    private final static BigInteger three = BigInteger.valueOf(3L);
    private final static BigInteger five = BigInteger.valueOf(5L);

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = FIZZ + BUZZ;

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
