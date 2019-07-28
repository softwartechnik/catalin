package de.softwartechnik.catalin.gui.service;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class LanguageServiceImpl implements LanguageService {

  private static final String RESOURCE_BUNDLE_NAME = "catalin";

  @Inject
  public LanguageServiceImpl(@Named("language") String language) {
    Locale.setDefault(Locale.forLanguageTag(language));
  }

  @Override
  public String translate(String messageKey, Locale locale, String... args) {

    ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
    String messageContent = resourceBundle.getString(messageKey);

    return MessageFormat.format(messageContent, (Object[]) args);
  }

  @Override
  public String translate(String messageKey, String... args) {

    Locale defaultLocale = getDefaultLocale();
    return translate(messageKey, defaultLocale, args);
  }

  @Override
  public Locale getDefaultLocale() {

    return Locale.getDefault();
  }

  @Override
  public void setDefaultLocale(Locale locale) {

    Locale.setDefault(locale);
  }
}
