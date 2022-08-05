package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.Employee;
import com.javastudio.tutorial.mapping.model.Person;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.LocalDateAssert;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class MapperTest {

    GeneralMapper mapper = Mappers.getMapper(GeneralMapper.class);

    @Test
    void mapEmployeeToPerson() {
        Employee employee = new Employee();
        employee.setName("Albert");

        Person person = mapper.toPerson(employee);
        assertThat(person.getName()).isEqualTo("Albert");
    }

    @Test
    void mapPersonToEmployee() throws ParseException {

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final Date startDate = sdf.parse("2012-01-12");

        Person person = new Person();
        person.setName("Albert");
        Employee employee = mapper.toEmployee(person, startDate);

        Optional.of(employee).map(Employee::getEmploymentDate).map(sdf::format).ifPresent(System.out::println);

        assertThat(employee.getName()).isEqualTo("Albert");
        assertThat(employee.getEmploymentDate()).isEqualTo(startDate);
    }

    @Test
    void convertLocalDateToDate() {

        LocalDate arrivalLocalDate = LocalDate.of(2022, 7, 6);
        Date arrivalDate = Date.from(arrivalLocalDate.atTime(4, 0)
                .atZone(ZoneId.of("Asia/Tehran")).toInstant());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Optional.of(df.format(arrivalDate)).ifPresent(System.out::println);
    }

    @Test
    void convertLocalDateTimeToDate() {
        LocalDateTime arrivalLocalDate = LocalDateTime.of(2022, 7, 6, 4, 0, 0);
        Date arrivalDate = Date.from(arrivalLocalDate
                .atZone(ZoneId.of("Asia/Tehran")).toInstant());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Optional.of(df.format(arrivalDate)).ifPresent(System.out::println);
    }

    @Test
    void displayAllZones() {
        LocalDateTime localDateTime = LocalDateTime.now();

        for (String zoneId : ZoneId.getAvailableZoneIds()) {

            ZoneId id = ZoneId.of(zoneId);

            // LocalDateTime -> ZonedDateTime
            ZonedDateTime zonedDateTime = localDateTime.atZone(id);

            // ZonedDateTime -> ZoneOffset
            ZoneOffset zoneOffset = zonedDateTime.getOffset();

            //replace Z to +00:00
            String offset = zoneOffset.getId().replaceAll("Z", "+00:00");

            System.out.printf("%s, %s%n", id.toString(), offset);

        }
    }

    @Test
    void getZoneIdOfTehran() {
        Instant instant = Instant.now(); //can be LocalDateTime

        ZoneId zoneId = ZoneId.of("Asia/Tehran");
        ZoneId systemZone = ZoneId.systemDefault(); // my timezone

        ZoneOffset currentOffset = systemZone.getRules().getOffset(instant);
        ZoneOffset offset = zoneId.getRules().getOffset(instant);

        System.out.println(offset);
    }

    @Test
    void localDateTimeAtDifferentZones() {
        Instant now = Instant.now();

        ZoneId systemZone = ZoneId.systemDefault();
        ZoneOffset zoneOffset = systemZone.getRules().getOffset(now);
        System.out.println(zoneOffset);
    }
}
