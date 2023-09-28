package com.texteditor;
import javax.swing.*;
import java.awt.*;

public class textEditorFrame extends JFrame {
    private static Text textArea;
    private final JMenuBar menuBar;
    public textEditorFrame() {
        setTitle("Super Text Editor 2000");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        textArea = new Text();

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane,BorderLayout.CENTER);

        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static Text getText() {
        return textArea;
    }

    public static void setTextArea(String newText) {
        textEditorFrame.textArea.setText(newText);
        textArea.repaint();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(textEditorFrame::new);
    }
}
