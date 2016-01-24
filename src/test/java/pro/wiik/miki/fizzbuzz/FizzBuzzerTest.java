package pro.wiik.miki.fizzbuzz;

import org.junit.Ignore;
import org.junit.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzerTest {

    @Test
    public void knownValues() throws Exception {
        assertThat(new FizzBuzzer().evaluate(valueOf(0L)), is("FizzBuzz"));
        assertThat(new FizzBuzzer().evaluate(valueOf(1L)), is("1"));
        assertThat(new FizzBuzzer().evaluate(valueOf(3L)), is("Fizz"));
        assertThat(new FizzBuzzer().evaluate(valueOf(5L)), is("Buzz"));
        assertThat(new FizzBuzzer().evaluate(valueOf(7L)), is("7"));
        assertThat(new FizzBuzzer().evaluate(valueOf(15L)), is("FizzBuzz"));
    }

    @Test
    public void numberLargerThanIntMaxValue() {
        assertThat("Should support numbers larger than int max val",
                new FizzBuzzer().evaluate(valueOf(Integer.MAX_VALUE + 2L)), is("Fizz"));
    }

    @Test
    public void negativeNumbers() {
        assertThat(new FizzBuzzer().evaluate(valueOf(-15L)), is("FizzBuzz"));
        assertThat(new FizzBuzzer().evaluate(valueOf(-17L)), is("-17"));
    }

    @Ignore("For manual performance testing")
    @Test
    public void manualPerformanceTest() throws Exception {
        final FizzBuzzer fizzBuzzer = new FizzBuzzer();
        final long start = System.currentTimeMillis();
        final int numbers = 1000000;
        for (long i = 0; i < numbers; i++) {
            fizzBuzzer.evaluate(valueOf(i));
        }
        final long finish = System.currentTimeMillis();
        System.out.println(String.format("Tested: %d in %d milliseconds", numbers, (finish - start)));
    }

}
