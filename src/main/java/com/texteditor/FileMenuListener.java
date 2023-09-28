package com.texteditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("New".equals(command)) {
            Text text = new Text();
            textEditorFrame.setTextArea("");
            System.out.println("New menu item clicked");
        } else if ("Open".equals(command)) {
            String newText = openFile();
            textEditorFrame.setTextArea(newText);
            System.out.println("Open menu item clicked");
        } else if ("Save".equals(command)) {
            Text text = textEditorFrame.getText();
            saveFile(text);
            System.out.println("Save menu item clicked");
        } else if ("Exit".equals(command)) {
            exitApplication();
            System.out.println("Exit menu item clicked");
        }
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
                JOptionPane pane = new JOptionPane("File saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane pane = new JOptionPane();
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
                String fileContent = content.toString();

                return fileContent;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "";
    }
}
