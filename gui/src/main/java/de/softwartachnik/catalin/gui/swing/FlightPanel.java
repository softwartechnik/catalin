package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;
import java.awt.*;

public class FlightPanel extends JPanel{

    public static final int COLUMNS = 15;
    public static final String SEARCH = "Suche: ";
    public static final String FILTERCRIT1 = "Filterkriterium 1";
    public static final String FILTERCRIT2 = "Filterkriterium 2";
    public static final String ADD = "Hinzufügen";
    public static final String DELETE = "Löschen";
    public static final String CHANGE = "Ändern";

    private JButton add;
    private JButton delete;
    private JButton change;

    public FlightPanel(){
        buildPanel();
    }

    //build Layout and Panels
   public void buildPanel(){

       /**
        * Das muss eigentlich irgendwo aus der Fachlogik/Datenhaltung geladen werden
        * PLATZHALTER
        */
       String[][] items = new String[][]
               { {"1244","02", "...", "..."}, {"1256","07", "...","..."}, {"1278","03", "...","..."}, {"1355","02", "...","..."},
                       {"1356","07", "...", "..."},{"1378","01", "...","..."},{"1456","04", "...","..."},{"1470","01", "...","..."},
                       {"1500","02", "...","..."}
               };
       String[] columns = new String[] {"ID", "Flugzeug ID", "...", "Weitere Spalten"};
       //*************************************************************************************

       this.setLayout(new BorderLayout());
       JLabel lab = new JLabel("Hier könnte Versionsnummer/Copyright stehen");
       JLabel lab2 = new JLabel("...oder ein Logo?");

       JPanel southPanel = new JPanel(new FlowLayout());
       southPanel.add(lab);
       southPanel.add(lab2);

       JPanel optionPanel = new JPanel(new GridLayout(3,1));
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
       this.add(new TablePanel(columns,items), BorderLayout.CENTER);
       this.add(optionPanel, BorderLayout.EAST);
       this.add(southPanel, BorderLayout.SOUTH);
   }

    public JButton getAdd() {
        return add;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getChange() {
        return change;
    }
}
