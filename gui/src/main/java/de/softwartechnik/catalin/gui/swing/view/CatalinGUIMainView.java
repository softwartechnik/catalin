package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.gui.swing.view.navigation.CatalinGUIViewNavigation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CatalinGUIMainView extends JFrame {

  private static final String TITLE = "Catalin Flughafenverwaltung";
  private final CatalinGUIViewNavigation navigation;
  private final JPanel contentPane;
  private Logger logger = Logger.getLogger(CatalinGUIMainView.TITLE);

  @Inject
  public CatalinGUIMainView(CatalinGUIViewNavigation navigation) {
    this.navigation = navigation;

    // Setup content
    setTitle(TITLE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    contentPane = new CatalinGUIViewPanel();
    setContentPane(contentPane);

    // Setup components
    setJMenuBar(this.navigation);

    setVisible(true);
    repaint();
  }

  /**
   * Set the view.
   *
   * @param view The view.
   */
  public void setView(CatalinGUIView view) {

    logger.log(Level.INFO, "Showing view: " + view.getClass().getSimpleName());

    setContentView(view.getComponent());
  }

  /**
   * The the current content view.
   *
   * @param contentView The component containing the views.
   */
  private void setContentView(JComponent contentView) {

    contentPane.removeAll();
    contentPane.add(contentView);

    setVisible(true);
    repaint();
  }

  /**
   * Get the navigation element.
   *
   * @return The navigation.
   */
  public CatalinGUIViewNavigation getNavigation() {
    return navigation;
  }
}
