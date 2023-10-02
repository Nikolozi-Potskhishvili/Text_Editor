package com.texteditor;

import javax.swing.*;
import java.awt.*;

public class Text extends JTextArea {
    public Text() {
        setBackground(Color.GRAY);
    }
    public void changeFontColor(Color color) {
        setForeground(color);
    }

    public void changeFont(Font font) {
        setFont(font);
    }
    public void setFontSize(int size) {
        Font currentFont = getFont();
        Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), size);
        setFont(newFont);
    }
}
