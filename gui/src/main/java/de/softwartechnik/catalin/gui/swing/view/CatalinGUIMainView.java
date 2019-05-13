package de.softwartechnik.catalin.gui.swing.view;

import de.softwartechnik.catalin.gui.swing.view.navigation.CatalinGUIViewNavigation;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalinGUIMainView extends JFrame {

    private static final String TITLE = "Catalin Flughafenverwaltung";

    private Logger logger = Logger.getLogger(CatalinGUIMainView.TITLE);

    private final CatalinGUIViewNavigation navigation;
    private final JPanel contentPane;

    public CatalinGUIMainView() {

        // Setup content
        setTitle(TITLE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        contentPane = new CatalinGUIViewPanel();
        setContentPane(contentPane);

        // Setup components
        navigation = new CatalinGUIViewNavigation();
        setJMenuBar(navigation);

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
