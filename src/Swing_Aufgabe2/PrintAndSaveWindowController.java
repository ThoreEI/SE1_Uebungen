package Swing_Aufgabe2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PrintAndSaveWindowController extends WindowAdapter implements ActionListener, WindowListener, KeyListener {

    private final PrintAndSaveWindow window;
    private boolean dataSaved = true;
    private boolean hasUndoneChanges = false;
    private String textAreaBeforeUndoingChanges;

    public PrintAndSaveWindowController(PrintAndSaveWindow window) {
        this.window = window;

        window.getTextArea().addKeyListener(this);


        window.getPrintButton().addActionListener(this);

        window.getClearButton().addActionListener(this);

        window.getSaveButton().addActionListener(this);

        window.getUndoButton().addActionListener(this);

        window.getRedoButton().addActionListener(this);

        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == window.getPrintButton())
            System.out.println(window.getTextArea().getText());
        else if (e.getSource() == window.getClearButton()) {
            saveTextArea();
            window.getTextArea().setText("");
            dataSaved = false;
        } else if (e.getSource() == window.getSaveButton())
            saveTextArea();
        else if (e.getSource() == window.getUndoButton() && !dataSaved) {
            textAreaBeforeUndoingChanges = window.getTextArea().getText();
            window.getTextArea().setText("");
            window.loadSavedTextArea();
            window.add(window.getTextArea(), BorderLayout.CENTER);
            hasUndoneChanges = true;
        } else if (e.getSource() == window.getRedoButton() && hasUndoneChanges) {
            window.getTextArea().setText("");
            window.getTextArea().setText(textAreaBeforeUndoingChanges);
            hasUndoneChanges = false;
        }
    }

    private void saveTextArea() {
        try {

            FileWriter fileWriter = new FileWriter(window.getSaveData(), false);
            fileWriter.write(window.getTextArea().getText());
            fileWriter.flush();
            fileWriter.close();
            dataSaved = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void windowClosing (WindowEvent e) {
        if (!dataSaved && JOptionPane.showConfirmDialog(null, "Do you want to save your changes?", "WARNING", YES_NO_OPTION) == YES_OPTION)
            saveTextArea();
        System.exit(0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        dataSaved = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
