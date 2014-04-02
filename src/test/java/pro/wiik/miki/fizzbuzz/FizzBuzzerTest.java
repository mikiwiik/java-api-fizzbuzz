package pro.wiik.miki.fizzbuzz;

import org.junit.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzerTest {

    @Test
    public void simpleSmokeTest() throws Exception {
        final FizzBuzzer fizzBuzzer = new FizzBuzzer();
        assertThat(fizzBuzzer.evaluate(valueOf(1L)), is("1"));

        assertThat(fizzBuzzer.evaluate(valueOf(3L)), is("fizz"));
        assertThat(fizzBuzzer.evaluate(valueOf(5L)), is("buzz"));
        assertThat(fizzBuzzer.evaluate(valueOf(15L)), is("fizz buzz"));

        assertThat("Should support numbers larger than int max val",
                fizzBuzzer.evaluate(valueOf(Integer.MAX_VALUE + 2L)), is("fizz"));
    }

}
