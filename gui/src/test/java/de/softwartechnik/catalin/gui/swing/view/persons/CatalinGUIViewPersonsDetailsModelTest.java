package de.softwartechnik.catalin.gui.swing.view.persons;

import de.softwartechnik.catalin.core.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatalinGUIViewPersonsDetailsModelTest {

    private final String firstName = "Jane";
    private final String lastName = "Doe";
    private final Date birthday = new Date(1995, 10,23);

    private final String firstNameChanged = "Anne";
    private final String lastNameChanged = "Kaffeekanne";
    private final Date birthdayChanged = new Date(1985, 1, 1);

    CatalinGUIViewPersonsDetailsModel details;

    @BeforeEach
    void  init() {
        details = new CatalinGUIViewPersonsDetailsModel(firstName,lastName,birthday);

    }

    @Test
    void getFirstName() {
        assertEquals(details.getFirstName(), firstName);
    }

    @Test
    void setFirstName() {
        details.setFirstName(firstNameChanged);
        assertTrue(details.hasChanged());
    }

    @Test
    void getLastName() {
        assertEquals(details.getLastName(), lastName);
    }

    @Test
    void setLastName() {
    }

    @Test
    void getBirthday() {
        assertEquals(details.getBirthday(), birthday);
    }

    @Test
    void setBirthday() {
    }
}