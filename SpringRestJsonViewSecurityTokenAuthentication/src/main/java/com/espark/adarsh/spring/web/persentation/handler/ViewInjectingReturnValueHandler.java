package com.espark.adarsh.spring.web.persentation.handler;

import com.espark.adarsh.spring.core.annotation.ResponseView;
import com.espark.adarsh.spring.web.persentation.view.BaseView;
import com.espark.adarsh.spring.web.persentation.view.PojoView;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 *
 * Decorator that detects a declared {@link  com.espark.adarsh.spring.core.annotation.ResponseView}
 * , and injects support if required
 */
public class ViewInjectingReturnValueHandler implements
        HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;

    public ViewInjectingReturnValueHandler(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return delegate.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue,
                                  MethodParameter returnType, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {

        Class<? extends BaseView> viewClass = getDeclaredViewClass(returnType);
        if (viewClass != null) {
            returnValue = wrapResult(returnValue, viewClass);
        }

        delegate.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }

    /**
     * Returns the view class declared on the method, if it exists.
     * Otherwise, returns null.
     *
     * @param returnType
     * @return
     */
    private Class<? extends BaseView> getDeclaredViewClass(MethodParameter returnType) {
        ResponseView annotation = returnType.getMethodAnnotation(ResponseView.class);
        if (annotation != null) {
            return annotation.value();
        } else {
            return null;
        }
    }

    private Object wrapResult(Object result, Class<? extends BaseView> viewClass) {
        PojoView response = new PojoView(result, viewClass);
        return response;
    }
}