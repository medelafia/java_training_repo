package com.training;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Localisation {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();

        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayCountry());


        NumberFormat formatter = NumberFormat.getNumberInstance(locale);

        System.out.println(formatter.format(123.45));

        Locale locale2 = new Locale("en", "GB");
        LocalDate date = LocalDate.now();

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(locale2);

        System.out.println(formatter2.format(date));
    }
}

