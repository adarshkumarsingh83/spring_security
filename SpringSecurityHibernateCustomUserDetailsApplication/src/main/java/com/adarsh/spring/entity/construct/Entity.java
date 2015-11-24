package com.adarsh.spring.entity.construct;

import java.io.Serializable;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface Entity<E extends Serializable> extends Serializable,Cloneable,Comparable{

    public E getId();

    public void setId(E id);

}