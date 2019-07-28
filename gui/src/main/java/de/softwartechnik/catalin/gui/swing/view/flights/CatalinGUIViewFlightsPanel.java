package de.softwartechnik.catalin.gui.swing.view.flights;

import java.awt.BorderLayout;
import javax.inject.Inject;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CatalinGUIViewFlightsPanel extends JPanel {

  private final CatalinGUIViewFlightsTable table;
  private final CatalinGUIViewFlightsSidebar sidebar;

  @Inject
  public CatalinGUIViewFlightsPanel(CatalinGUIViewFlightsTable table,
      CatalinGUIViewFlightsSidebar sidebar) {
    this.table = table;
    this.sidebar = sidebar;

    setLayout(new BorderLayout());

    // Add table
    JScrollPane scrollPane = new JScrollPane(this.table);
    add(scrollPane, BorderLayout.CENTER);

    // Add sidebar
    add(this.sidebar, BorderLayout.EAST);
  }

  public CatalinGUIViewFlightsSidebar getSidebar() {
    return sidebar;
  }

  public CatalinGUIViewFlightsTable getTable() {
    return table;
  }
}
