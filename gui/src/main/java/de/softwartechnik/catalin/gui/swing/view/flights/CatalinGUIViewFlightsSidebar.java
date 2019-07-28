package de.softwartechnik.catalin.gui.swing.view.flights;

import java.awt.BorderLayout;
import javax.inject.Inject;
import javax.swing.JPanel;

public class CatalinGUIViewFlightsSidebar extends JPanel {


  private final CatalinGUIViewFlightsSidebarButtons sidebarButtons;

  @Inject
  public CatalinGUIViewFlightsSidebar(CatalinGUIViewFlightsSidebarButtons sidebarButtons) {
    this.sidebarButtons = sidebarButtons;

    setLayout(new BorderLayout());
    add(this.sidebarButtons, BorderLayout.NORTH);
  }

  public CatalinGUIViewFlightsSidebarButtons getSidebarButtons() {
    return sidebarButtons;
  }
}
