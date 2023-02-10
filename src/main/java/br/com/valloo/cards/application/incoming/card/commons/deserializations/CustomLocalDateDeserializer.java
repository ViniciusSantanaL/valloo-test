package br.com.valloo.cards.application.incoming.card.commons.deserializations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalDate;

public class CustomLocalDateDeserializer extends JsonDeserializer {

    @Override
    public LocalDate deserialize(JsonParser jsonParser,
                                 DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        String split = node.asText().contains("/") ? "/" : "-";
        String[] monthAndYear = node.asText().split(split);
        int year = Integer.parseInt(monthAndYear[1]);
        int month = Integer.parseInt(monthAndYear[0]);

        return LocalDate.of(year,month,1);
    }
}
