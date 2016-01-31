package pro.wiik.miki.fizzbuzz;

import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.Immutable;
import java.math.BigInteger;

import static java.util.Objects.requireNonNull;

@Immutable
public class Result {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = FIZZ + BUZZ;

    private final BigInteger number;
    private final String fizzBuzz;

    private Result(@NotNull BigInteger number, @NotNull String fizzBuzz) {
        this.number = requireNonNull(number, "number");
        this.fizzBuzz = requireNonNull(fizzBuzz, "fizzBuzz");
    }

    static Result fizz(@NotNull BigInteger number) {
        return new Result(number, FIZZ);
    }

    static Result buzz(@NotNull BigInteger number) {
        return new Result(number, BUZZ);
    }

    static Result fizzBuzz(@NotNull BigInteger number) {
        return new Result(number, FIZZ_BUZZ);
    }

    static Result number(@NotNull BigInteger number) {
        requireNonNull(number, "number");
        return new Result(number, number.toString());
    }

    public BigInteger getNumber() {
        return number;
    }

    public String getFizzBuzz() {
        return fizzBuzz;
    }
}
