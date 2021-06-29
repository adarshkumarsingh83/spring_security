package com.espark.adarsh.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Locale;

/*
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 15/6/20 10:12 AM#$
 */
@Slf4j
@Component
public class MessageUtils {

    public static final String PROCESSING_ERROR="PROCESSING_ERROR";
    public static final String INVALID_INPUT_TYPE="INVALID_INPUT_TYPE";
    public static final String INVALID_VALIDATOR_TYPE="INVALID_VALIDATOR_TYPE";
    public static final String EMPTY_ARGS="EMPTY_ARGS";
    public static final String NULL_ARGS="NULL_ARGS";

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        log.info("label=MessageUtils init()");
        accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
    }

    public String get(String code) {
        log.debug("label=MessageUtils get() code={}", code);
        return accessor.getMessage(code);
    }

    public String get(String code, Object[] param) {
        log.debug("label=MessageUtils get() code={} param{}", code, Arrays.asList(param));
        return accessor.getMessage(code, param);
    }
}
