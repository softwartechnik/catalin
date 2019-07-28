package de.softwartechnik.catalin.gui.swing.view.bookings;

import java.awt.BorderLayout;
import javax.inject.Inject;
import javax.swing.JPanel;

public class CatalinGUIViewBookingsSidebar extends JPanel {


  private final CatalinGUIViewBookingsSidebarSearch sidebarSearch;

  @Inject
  public CatalinGUIViewBookingsSidebar(CatalinGUIViewBookingsSidebarSearch sidebarSearch) {
    this.sidebarSearch = sidebarSearch;

    setLayout(new BorderLayout());
    add(sidebarSearch, BorderLayout.NORTH);
  }

  public CatalinGUIViewBookingsSidebarSearch getSidebarSearch() {
    return sidebarSearch;
  }
}
