package pro.wiik.miki.fizzbuzz;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.concurrent.Immutable;
import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static pro.wiik.miki.fizzbuzz.TestResult.*;

@Immutable
@Service
public class FizzBuzzer {

    private final static BigInteger three = BigInteger.valueOf(3L);
    private final static BigInteger five = BigInteger.valueOf(5L);

    @NotNull
    public TestResult evaluate(@NotNull BigInteger number) {
        if (number.mod(three).equals(ZERO)) {
            if (number.mod(five).equals(ZERO)) {
                return fizzBuzz(number);
            } else {
                return fizz(number);
            }
        } else if (number.mod(five).equals(ZERO)) {
            return buzz(number);
        }

        return number(number);
    }

}
