package com.adarsh.spring.services;

/**
 * Created by Adarsh on 4/30/15.
 */

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
/*@Secured("ROLE_ADMIN")*/
public class ProductsService {

    public String getProductsList() {

        return "products:item";
    }

}