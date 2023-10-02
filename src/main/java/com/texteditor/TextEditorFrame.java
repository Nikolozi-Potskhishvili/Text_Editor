package com.texteditor;
import javax.swing.*;
import java.awt.*;

public class TextEditorFrame extends JFrame {
    private static Text textArea;
    public TextEditorFrame() {
        setTitle("Super Text Editor 2000");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        textArea = new Text();

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane,BorderLayout.CENTER);

        JMenuBar menuBar = new MenuBar(this);
        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static Text getText() {
        return textArea;
    }

    public static void setTextArea(String newText) {
        TextEditorFrame.textArea.setText(newText);
        textArea.repaint();
    }
    public static void setTextProperties(Font font,Color color) {
        textArea.setFont(font);
        textArea.setForeground(color);
        System.out.println("12321312");
        textArea.repaint();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextEditorFrame::new);
    }

}
