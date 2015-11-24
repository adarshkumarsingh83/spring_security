package com.espark.adarsh.spring.web.persentation.mapper;

import com.espark.adarsh.spring.web.persentation.serializer.JsonDateSerializer;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.Date;
import java.util.Map;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class ApiObjectMapper extends ObjectMapper {

    public ApiObjectMapper(){
        SimpleModule module = new SimpleModule("JSONModule", new Version(2, 3, 3, null, null, null));
        module.addSerializer(Date.class,new JsonDateSerializer());
        this.registerModule(module);
    }
}
