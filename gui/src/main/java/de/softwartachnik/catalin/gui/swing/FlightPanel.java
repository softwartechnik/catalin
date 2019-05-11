package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;
import java.awt.*;

class FlightPanel extends JPanel {

    private static final String COPYRIGHT = "Copyright 2019 SoftWarTechnik";

    private static final int COLUMNS = 15;
    private static final String SEARCH = "Suche: ";
    private static final String FILTERCRIT1 = "Filterkriterium 1";
    private static final String FILTERCRIT2 = "Filterkriterium 2";
    private static final String ADD = "Hinzufügen";
    private static final String DELETE = "Löschen";
    private static final String CHANGE = "Ändern";

    private JButton add;
    private JButton delete;
    private JButton change;

    FlightPanel() {
        buildPanel();
    }

    //build Layout and Panels
    private void buildPanel() {

        /**
         * Das muss eigentlich irgendwo aus der Fachlogik/Datenhaltung geladen werden
         * PLATZHALTER
         */
        String[][] items = new String[][]
                {{"1244", "02", "...", "..."}, {"1256", "07", "...", "..."}, {"1278", "03", "...", "..."}, {"1355", "02", "...", "..."},
                        {"1356", "07", "...", "..."}, {"1378", "01", "...", "..."}, {"1456", "04", "...", "..."}, {"1470", "01", "...", "..."},
                        {"1500", "02", "...", "..."}
                };
        String[] columns = new String[]{"ID", "Flugzeug ID", "...", "Weitere Spalten"};
        //*************************************************************************************

        this.setLayout(new BorderLayout());
        JLabel lab = new JLabel(COPYRIGHT);
        JLabel lab2 = new JLabel("...oder ein Logo?");

        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(lab);
        southPanel.add(lab2);

        JPanel optionPanel = new JPanel(new GridLayout(3, 1));
        add = new JButton(ADD);
        delete = new JButton(DELETE);
        change = new JButton(CHANGE);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttons.add(getAdd());
        buttons.add(getDelete());
        buttons.add(getChange());

        JLabel search = new JLabel(SEARCH);
        JTextField tf = new JTextField();
        tf.setColumns(COLUMNS);
        JPanel filter = new JPanel(new FlowLayout());
        filter.add(search);
        filter.add(tf);

        JCheckBox cb = new JCheckBox(FILTERCRIT1);
        JCheckBox cb2 = new JCheckBox(FILTERCRIT2);
        JPanel check = new JPanel();
        check.setLayout(new BoxLayout(check, BoxLayout.PAGE_AXIS));
        check.add(cb);
        check.add(cb2);

        optionPanel.add(buttons);
        optionPanel.add(filter);
        optionPanel.add(check);
        add(new TablePanel(columns, items), BorderLayout.CENTER);
        add(optionPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
    }

    private JButton getAdd() {
        return add;
    }

    private JButton getDelete() {
        return delete;
    }

    private JButton getChange() {
        return change;
    }
}
