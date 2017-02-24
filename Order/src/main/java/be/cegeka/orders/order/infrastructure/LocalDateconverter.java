package be.cegeka.orders.order.infrastructure;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateconverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        if(date==null)
        return null;
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        if(date==null)
            return null;
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
