package com.texteditor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontChooser extends JDialog {
    private TextEditorFrame parentFrame;

    private JTextField sampleText;
    private JComboBox<String> fontComboBox;
    private JComboBox<Integer> sizeComboBox;
    private JButton colorButton;
    private JButton okButton;
    private JButton cancelButton;
    private Color selectedColor;

    public FontChooser(TextEditorFrame parent) {
        super(parent,"Font Chooser",true);
        this.parentFrame = parent;
        setSize(400,400);
        setLayout(new GridLayout(6,2));

        sampleText = new JTextField("Sample Text");
        fontComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        sizeComboBox = new JComboBox<>(new Integer[]{8, 10, 12, 14, 16, 18, 20, 24, 28, 32});
        colorButton = new JButton("Choose Color");
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        add(new JLabel("Font:"));
        add(fontComboBox);
        add(new JLabel("Size:"));
        add(sizeComboBox);
        add(new JLabel("Color:"));
        add(colorButton);
        add(new JLabel("Sample:"));
        add(sampleText);

        FontChooserListener fontChooserListener = new FontChooserListener(parentFrame,this);
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedColor = JColorChooser.showDialog(FontChooser.this, "Choose Text Color", selectedColor);
                if (selectedColor != null) {
                    sampleText.setForeground(selectedColor);
                }
            }
        });

        fontComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sampleText.setFont(getSelectedFont());
            }
        });

        sizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sampleText.setFont(getSelectedFont());
            }
        });

        okButton.addActionListener(fontChooserListener);
        cancelButton.addActionListener(fontChooserListener);
        add(okButton);
        add(cancelButton);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }


    public void setSampleTextFont(Font font) {
        sampleText.setFont(font);
    }

    public int getFontSize() {
        return (int) sizeComboBox.getSelectedItem();
    }

    public Font getSelectedFont() {
        String selectedFontName = (String) fontComboBox.getSelectedItem();
        int selectedFontSize = (int) sizeComboBox.getSelectedItem();
        return new Font(selectedFontName, Font.PLAIN, selectedFontSize);
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

}
