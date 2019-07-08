package de.softwartechnik.catalin.gui.service;

import java.util.Locale;

public interface LanguageService {

    String translate(String messageKey, Locale locale, String... args);

    String translate(String messageKey, String... args);

    Locale getDefaultLocale();

    void setDefaultLocale(Locale locale);
}
