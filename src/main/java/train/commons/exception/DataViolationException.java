package train.commons.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DataViolationException extends DataIntegrityViolationException {

    public DataViolationException(String msg){
        super(msg);
    }

}
