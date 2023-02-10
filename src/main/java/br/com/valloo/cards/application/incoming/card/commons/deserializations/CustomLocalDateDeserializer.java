package br.com.valloo.cards.application.incoming.card.commons.deserializations;

import br.com.valloo.cards.infrastructure.exception.CustomLocalDateDeserializerException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalDate;

public class CustomLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jsonParser,
        DeserializationContext deserializationContext) throws CustomLocalDateDeserializerException, IOException {

        ObjectCodec oc = jsonParser.getCodec();
        String fieldName = jsonParser.currentName();

        JsonNode node = oc.readTree(jsonParser);

        validateParternDate(node.asText(),fieldName);

        String split = node.asText().contains("/") ? "/" : "-";
        String[] monthAndYear = node.asText().split(split);
        int year = Integer.parseInt(monthAndYear[1]);
        int month = Integer.parseInt(monthAndYear[0]);

        return LocalDate.of(year,month,1);
    }

    private void validateParternDate(String dateFormat, String fieldName)  {

        if(!(dateFormat.contains("/") ||  dateFormat.contains("-")))
            throw new CustomLocalDateDeserializerException(fieldName);

        if(!(dateFormat.length() == 7))
            throw new CustomLocalDateDeserializerException(fieldName);

        String split = dateFormat.contains("/") ? "/" : "-";
        String verifyDateFormat = dateFormat.replace(split, "");
        if(!(verifyDateFormat.matches("[0-9]+")))
            throw new CustomLocalDateDeserializerException(fieldName);
    }
}
