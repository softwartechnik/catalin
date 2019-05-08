package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class Controller {

    public static final int MENU_INDEX_FLIGHT = 2;
    public static final int MENU_INDEX_BOOKINGS = 1;
    WelcomePanel welcomePanel;
    FlightPanel flightPanel;
    JPanel myPanel;

    MainFrame mainFrame;

    public Controller(){
        mainFrame = new MainFrame();
        welcomePanel = new WelcomePanel();
        myPanel = welcomePanel;
        mainFrame.add(welcomePanel, BorderLayout.CENTER);

        initActionListenerMenu();
        mainFrame.setVisible(true);
    }

    public void initActionListenerMenu(){
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
           public void menuCanceled(MenuEvent e) {}
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
