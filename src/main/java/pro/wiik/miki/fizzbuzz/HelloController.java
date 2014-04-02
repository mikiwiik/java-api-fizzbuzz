package pro.wiik.miki.fizzbuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    FizzBuzzer fizzBuzzer;

    @RequestMapping(method = RequestMethod.GET, value = "/{number}")
    @ResponseBody
    public String doFizzBuzz(@PathVariable("number") String number) {
        final BigInteger bigInt = new BigInteger(number);
        return fizzBuzzer.evaluate(bigInt);
    }
}