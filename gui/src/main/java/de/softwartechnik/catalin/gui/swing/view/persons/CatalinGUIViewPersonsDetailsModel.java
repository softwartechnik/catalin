package de.softwartechnik.catalin.gui.swing.view.persons;

import java.util.Date;
import java.util.Observable;

public class CatalinGUIViewPersonsDetailsModel extends Observable {

    private String firstName;
    private String lastName;
    private Date birthday;

    public CatalinGUIViewPersonsDetailsModel(String firstName, String lastName, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;

        setChanged();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

        setChanged();
        notifyObservers();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

        setChanged();
        notifyObservers();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;

        setChanged();
        notifyObservers();
    }
}
