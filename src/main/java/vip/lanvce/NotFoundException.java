package vip.lanvce;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: lanvce$
 * @date: 2020/2/16$ 下午11:37$
 * Description:
 **/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
