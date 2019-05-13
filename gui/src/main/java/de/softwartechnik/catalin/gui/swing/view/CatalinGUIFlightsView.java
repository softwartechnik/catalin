package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.core.model.Flight;
import de.softwartechnik.catalin.gui.swing.model.FlightsTableModel;
import de.softwartechnik.catalin.gui.swing.view.flights.CatalinGUIViewFlightsPanel;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class CatalinGUIFlightsView extends AbstractCatalinGUIView {

    private final CatalinGUIViewFlightsPanel flightsPanel;

    @Inject
    public CatalinGUIFlightsView(CatalinGUIViewFlightsPanel flightsPanel) {
        this.flightsPanel = flightsPanel;
    }

    @Override
    public JComponent getComponent() {

        return flightsPanel;
    }

    public void setFlightsModel(FlightsTableModel flights) {

        flightsPanel.getTable().setModel(flights);
    }

    public void setDeleteButtonListener(ActionListener actionListener) {

        flightsPanel.getSidebar().getSidebarButtons().getDeleteButton().addActionListener(actionListener);
    }

    public FlightsTableModel getFlightsModel() {

        return (FlightsTableModel) flightsPanel.getTable().getModel();
    }

    public int getSelectedFlight() {

        return flightsPanel.getTable().getSelectedRow();
    }

    public void setSearchButtonListener(ActionListener actionListener) {


    }
}
