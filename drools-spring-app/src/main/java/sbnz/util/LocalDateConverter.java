package sbnz.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

public class LocalDateConverter extends CustomConverter<String, LocalDate> {

	@Override
	public LocalDate convert(String source, Type<? extends LocalDate> destinationType, MappingContext mappingContext) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return LocalDate.parse(source, formatter);           
	}
}