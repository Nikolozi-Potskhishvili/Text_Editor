package com.texteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontChooserListener implements ActionListener {
    private final TextEditorFrame parentFrame;

    private final FontChooser fontChooser;
    FontChooserListener(TextEditorFrame parentFrame,FontChooser fontChooser) {
        this.parentFrame = parentFrame;
        this.fontChooser = fontChooser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if("Ok".equals(command)) {
            Text text = TextEditorFrame.getText();
            text.setFont(fontChooser.getFont());
            text.setForeground(fontChooser.getForeground());
            TextEditorFrame.setTextArea(text);
            
            fontChooser.dispose();
        } else if ("Cancel".equals(command)) {
            fontChooser.dispose();
        }
    }
}
