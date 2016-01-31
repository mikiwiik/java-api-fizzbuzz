package pro.wiik.miki.fizzbuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Controller
@RequestMapping("/api")
public class RestApi {

    @Autowired
    FizzBuzzer fizzBuzzer;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{number}",
            produces = TEXT_PLAIN_VALUE
    )
    @ResponseBody
    public String doFizzBuzz(@PathVariable("number") String number) {
        final BigInteger bigInt = new BigInteger(number);
        final TestResult result = fizzBuzzer.evaluate(bigInt);
        messagingTemplate.convertAndSend("/numbers/new", result);
        return result.getFizzBuzz();
    }

    @ExceptionHandler(NumberFormatException.class)
    void handleIllegalArgumentException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}