package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.core.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatalinGUIViewPersonsDetailsModelTest {

    private final String firstName = "Jane";
    private final String lastName = "Doe";
    private final Date birthday = new Date(1995, Calendar.NOVEMBER,23);

    private final String firstNameChanged = "Anne";
    private final String lastNameChanged = "Kaffeekanne";
    private final Date birthdayChanged = new Date(1985, Calendar.FEBRUARY, 1);

    CatalinGUIViewPersonsDetailsModel details;
    Observer observer;
    boolean isNotified;

    @BeforeEach
    void  init() {
        details = new CatalinGUIViewPersonsDetailsModel(firstName,lastName,birthday);
        isNotified = false;

        observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                isNotified = true;
            }
        };

        details.addObserver(observer);

    }

    @Test
    void getFirstName() {
        assertEquals(details.getFirstName(), firstName);
    }

    @Test
    void noNotificationWhenGet() {
        String name = details.getFirstName();
        assertFalse(isNotified);
    }


    @Test
    void setFirstNameNotify() {
        details.setFirstName(firstNameChanged);
        assertTrue(isNotified);
    }

    @Test
    void setLastNameNotify() {
        details.setLastName(lastNameChanged);
        assertTrue(isNotified);
    }

    @Test
    void setBirthdayNotify() {
        details.setBirthday(birthdayChanged);
        assertTrue(isNotified);
    }
    @Test
    void setFirstName() {
        details.setFirstName(firstNameChanged);
        assertEquals(firstNameChanged,details.getFirstName());
    }

    @Test
    void setLastName() {
        details.setLastName(lastNameChanged);
        assertEquals(lastNameChanged,details.getLastName());
    }

    @Test
    void setBirthday() {
        details.setBirthday(birthdayChanged);
        assertEquals(birthdayChanged,details.getBirthday());
    }
}
