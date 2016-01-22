package pro.wiik.miki.fizzbuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

@Controller
@RequestMapping("/")
public class RestApi {

    @Autowired
    FizzBuzzer fizzBuzzer;

    @RequestMapping(method = RequestMethod.GET, value = "/{number}")
    @ResponseBody
    public String doFizzBuzz(@PathVariable("number") String number) {
        final BigInteger bigInt = new BigInteger(number);
        return fizzBuzzer.evaluate(bigInt);
    }

    @ExceptionHandler(NumberFormatException.class)
    void handleIllegalArgumentException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}