package com.espark.adarsh.spring.web.persentation.view;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class PojoView implements DataView {

    private Object data;
    private Class<? extends BaseView> view;

    public PojoView(Object result, Class<? extends BaseView> viewClass) {
        this.data = result;
        this.view = viewClass;
    }

    public boolean hasView() {
        return true;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Class<? extends BaseView> getView() {
        return view;
    }

    public void setView(Class<? extends BaseView> view) {
        this.view = view;
    }
}
