package de.softwartechnik.catalin.gui.swing.view.bookings;

import java.awt.BorderLayout;
import javax.inject.Inject;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CatalinGUIViewBookingsPanel extends JPanel {

  private final CatalinGUIViewBookingsTable bookingsTable = new CatalinGUIViewBookingsTable();
  private final CatalinGUIViewBookingsSidebar sidepanel;

  @Inject
  public CatalinGUIViewBookingsPanel(CatalinGUIViewBookingsSidebar sidepanel) {
    this.sidepanel = sidepanel;

    setLayout(new BorderLayout());

    // Add table

    JScrollPane scrollPane = new JScrollPane(bookingsTable);
    add(scrollPane, BorderLayout.CENTER);

    add(this.sidepanel, BorderLayout.EAST);
  }

  public CatalinGUIViewBookingsTable getBookingsTable() {
    return bookingsTable;
  }

  public CatalinGUIViewBookingsSidebar getSidepanel() {
    return sidepanel;
  }
}
