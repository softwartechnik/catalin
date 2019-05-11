package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {

    private static final String TITLE = "Flughafenverwaltung";

    private MenuBar mymenu;

    MainFrame(){
        init();
        addMenu();
    }

    public void init(){
        setTitle(TITLE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        isResizable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    public void addMenu(){
        mymenu = new MenuBar();
        setLayout(new BorderLayout());
        add(mymenu, BorderLayout.NORTH);
    }


    public MenuBar getMymenu() {
        return mymenu;
    }
}
