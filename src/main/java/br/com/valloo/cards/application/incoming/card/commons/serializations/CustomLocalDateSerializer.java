package br.com.valloo.cards.application.incoming.card.commons.serializations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;

public class CustomLocalDateSerializer extends JsonSerializer<LocalDate> {
    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        jsonGenerator.writeString(String.format("%02d/%s", month,year));
    }
}
