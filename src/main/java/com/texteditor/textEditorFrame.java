package com.texteditor;
import javax.swing.*;
import java.awt.*;

public class textEditorFrame extends JFrame {
    private JTextArea textArea;
    private JMenuBar menuBar;
    public textEditorFrame() {
        setTitle("Super Text Editor 2000");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        textArea = new JTextArea();
        textArea.setBackground(Color.GRAY);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane,BorderLayout.CENTER);

        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(textEditorFrame::new);
    }
}
