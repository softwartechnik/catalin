package de.softwartachnik.catalin.gui.swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static String TITLE = "Flughafenverwaltung";

    private MenuBar mymenu;

    public MainFrame(){
        init();
        addMenu();
    }

    public void init(){
        this.setTitle(TITLE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.isResizable();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    public void addMenu(){
        mymenu = new MenuBar();
        this.setLayout(new BorderLayout());
        this.add(mymenu, BorderLayout.NORTH);
    }


    public MenuBar getMymenu() {
        return mymenu;
    }
}
