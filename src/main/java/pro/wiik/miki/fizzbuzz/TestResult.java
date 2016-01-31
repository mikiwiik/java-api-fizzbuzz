package pro.wiik.miki.fizzbuzz;

import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.Immutable;
import java.math.BigInteger;

import static java.util.Objects.requireNonNull;

@Immutable
public class TestResult {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = FIZZ + BUZZ;

    private final BigInteger number;
    private final String fizzBuzz;

    private TestResult(@NotNull BigInteger number, @NotNull String fizzBuzz) {
        this.number = requireNonNull(number, "number");
        this.fizzBuzz = requireNonNull(fizzBuzz, "fizzBuzz");
    }

    static TestResult fizz(@NotNull BigInteger number) {
        return new TestResult(number, FIZZ);
    }

    static TestResult buzz(@NotNull BigInteger number) {
        return new TestResult(number, BUZZ);
    }

    static TestResult fizzBuzz(@NotNull BigInteger number) {
        return new TestResult(number, FIZZ_BUZZ);
    }

    static TestResult number(@NotNull BigInteger number) {
        requireNonNull(number, "number");
        return new TestResult(number, number.toString());
    }

    public BigInteger getNumber() {
        return number;
    }

    public String getFizzBuzz() {
        return fizzBuzz;
    }
}
