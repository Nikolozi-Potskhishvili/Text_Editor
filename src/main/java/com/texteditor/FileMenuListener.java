package com.texteditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenuListener implements ActionListener {
    private FontChooser fontChooser;
    private TextEditorFrame parentFrame;
    public FileMenuListener(TextEditorFrame parentFrame) {
        //this.fontChooser = fontChooser;
        this.parentFrame = parentFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("New".equals(command)) {
            Text text = new Text();
            TextEditorFrame.setTextArea("");
            System.out.println("New menu item clicked");
        } else if ("Open".equals(command)) {
            String newText = openFile();
            TextEditorFrame.setTextArea(newText);
            System.out.println("Open menu item clicked");
        } else if("Save".equals(command)) {
            System.out.println("Save menu item clicked");
        } else if ("Save as".equals(command)) {
            Text text = TextEditorFrame.getText();
            saveFile(text);
            System.out.println("Save As menu item clicked");
        } else if ("Exit".equals(command)) {
            exitApplication();
            System.out.println("Exit menu item clicked");
        } else if("Font".equals(command)) {
            FontChooser fontChooser = new FontChooser(parentFrame);
            System.out.println("Font menu item clicked");
        }
    }

    private void chooseFont() {

    }

    private void exitApplication() {
        System.exit(0);
    }

    private void saveFile(Text txt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Sonatra\\Desktop\\"));
        int response = fileChooser.showSaveDialog(null);
        if(response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                String text = txt.getText();
                writer.write(text);
                writer.close();
                JOptionPane.showMessageDialog(null,"File saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println(file);
        }
    }

    private String openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Sonatra\\Desktop\\"));
        int response = fileChooser.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                JOptionPane.showMessageDialog(null,"File opened successfully!");
                return content.toString();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"couldn't open file");
            }
        }
        return "";
    }
}
