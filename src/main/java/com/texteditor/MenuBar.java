package com.texteditor;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        setBackground(Color.DARK_GRAY);
        createFileMenu();
    }

    private void createFileMenu() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setForeground(Color.WHITE);
        add(fileMenu);

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        FileMenuListener fileMenuListener = new FileMenuListener();

        newMenuItem.addActionListener(fileMenuListener);
        openMenuItem.addActionListener(fileMenuListener);
        saveMenuItem.addActionListener(fileMenuListener);
        exitMenuItem.addActionListener(fileMenuListener);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
    }

    private void createMainMenu() {

    }

    private void createViewMenu() {

    }
}
