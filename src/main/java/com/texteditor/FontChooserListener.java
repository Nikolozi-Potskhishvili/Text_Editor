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
        if("OK".equals(command)) {
            TextEditorFrame.setTextProperties(fontChooser.getSelectedFont(),fontChooser.getSelectedColor());
            fontChooser.dispose();
        } else if ("Cancel".equals(command)) {
            fontChooser.dispose();
        }
    }
}
