package com.espark.adarsh.spring.web.persentation.view.support;

import com.espark.adarsh.spring.web.persentation.handler.ViewInjectingReturnValueHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 *
 * Modified Spring 4.1.6's internal Return value handlers,
 * and wires up a decorator to add support for @JsonView
 */
@Service
public class JsonViewSupportFactoryBean implements InitializingBean {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonViewSupportFactoryBean.class);

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Override
    public void afterPropertiesSet() throws Exception {
        final List<HandlerMethodReturnValueHandler> apiHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        final List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>(apiHandlers.size());
        handlers.addAll(apiHandlers);
        this.decorateHandlers(handlers);
        requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
    }

    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {

        for (HandlerMethodReturnValueHandler handler : handlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                final ViewInjectingReturnValueHandler decorator = new ViewInjectingReturnValueHandler(handler);
                final int index = handlers.indexOf(handler);
                handlers.set(index, decorator);
                LOGGER.info("JsonView decorator support wired up");
                break;
            }
        }
    }
}