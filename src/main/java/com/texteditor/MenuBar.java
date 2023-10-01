package com.texteditor;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    private TextEditorFrame frame;
    public MenuBar(TextEditorFrame frame) {
        this.frame = frame;
        setBackground(Color.DARK_GRAY);
        createFileMenu();
        createEditMenu();
        createFormatMenu();
    }

    private void createFileMenu() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setForeground(Color.WHITE);
        add(fileMenu);

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save as");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        FileMenuListener fileMenuListener = new FileMenuListener(frame);

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

    private void createEditMenu() {
        JMenu editMenu = new JMenu("Edit");
        editMenu.setForeground(Color.WHITE);
        add(editMenu);

    }

    private void createFormatMenu() {
        JMenu formatMenu = new JMenu("Format");
        formatMenu.setForeground(Color.WHITE);
        add(formatMenu);

        FileMenuListener fileMenuListener = new FileMenuListener(frame);

        JMenuItem font = new JMenuItem("Font");
        font.addActionListener(fileMenuListener);
        formatMenu.add(font);
    }
}
