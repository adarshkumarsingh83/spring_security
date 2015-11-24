package com.espark.adarsh.spring.web.persentation.view;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */

public interface DataView {

    boolean hasView();

    Class<? extends BaseView> getView();

    Object getData();
}
