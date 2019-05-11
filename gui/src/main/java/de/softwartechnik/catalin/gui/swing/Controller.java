package de.softwartechnik.catalin.gui.swing;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

class Controller {

    private static final int MENU_INDEX_FLIGHT = 2;
    private static final int MENU_INDEX_BOOKINGS = 1;

    private FlightPanel flightPanel;
    private JPanel myPanel;
    private final MainFrame mainFrame;

    Controller() {
        mainFrame = new MainFrame();
        WelcomePanel welcomePanel = new WelcomePanel();
        myPanel = welcomePanel;
        mainFrame.add(welcomePanel, BorderLayout.CENTER);

        initActionListenerMenu();
        mainFrame.setVisible(true);
    }

    private void initActionListenerMenu() {
        mainFrame.getMymenu().getMenu(MENU_INDEX_FLIGHT).addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                flightPanel = new FlightPanel();
                mainFrame.remove(myPanel);
                mainFrame.add(flightPanel, BorderLayout.CENTER);
                myPanel = flightPanel;
                mainFrame.repaint();
                mainFrame.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        mainFrame.getMymenu().getMenu(MENU_INDEX_BOOKINGS).addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                System.out.println("Buchungen geklickt");
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
    }

}
