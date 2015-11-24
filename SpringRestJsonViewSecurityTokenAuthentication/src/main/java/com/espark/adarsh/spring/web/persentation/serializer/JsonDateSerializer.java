package com.espark.adarsh.spring.web.persentation.serializer;


import java.io.IOException;
import java.util.Date;
import com.espark.adarsh.spring.core.utils.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class JsonDateSerializer extends JsonSerializer<Date>{

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        String formattedDate = DateUtils.formatDate(date);
        gen.writeString(formattedDate);;
    }
}
