package Swing_Aufgabe2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

public class PrintAndSaveWindow extends JFrame {
    //private final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private final JTextArea TEXT_AREA;
    private final JButton PRINT_BUTTON;
    private final JButton CLEAR_BUTTON;
    private final JButton SAVE_BUTTON;
    private final JButton UNDO_BUTTON;
    private final JButton REDO_BUTTON;
    private File saveData;

    public PrintAndSaveWindow() {
        setLayout(new BorderLayout());
        setTitle("Your Text");

        TEXT_AREA = new JTextArea(10, 40);
        choseTextFileForSaveData();
        loadSavedTextArea();
        add(TEXT_AREA, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1, 5));
        add(south, BorderLayout.SOUTH);

        PRINT_BUTTON = new JButton("Print");
        south.add(PRINT_BUTTON);
        CLEAR_BUTTON = new JButton("Clear");
        south.add(CLEAR_BUTTON);
        SAVE_BUTTON = new JButton("Save");
        south.add(SAVE_BUTTON);
        UNDO_BUTTON = new JButton("Undo");
        south.add(UNDO_BUTTON);
        REDO_BUTTON = new JButton("Redo");
        south.add(REDO_BUTTON);

        pack();

        setLocationRelativeTo(null);
    }

    private void  choseTextFileForSaveData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setDialogTitle("Please choose a text file (example.txt) to load your data.");
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("TEXT FILES","txt", "text");
        fileChooser.setFileFilter(extensionFilter);
        fileChooser.showOpenDialog(null);
        saveData = fileChooser.getSelectedFile();
    }

    public void loadSavedTextArea() {
        try {
            FileReader fileReader = new FileReader(saveData);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while  ( (currentLine = bufferedReader.readLine()) != null )
                TEXT_AREA.append(currentLine + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public File getSaveData() {
        return saveData;
    }

    public JTextArea getTextArea() {
        return TEXT_AREA;
    }

    public JButton getPrintButton() {
        return PRINT_BUTTON;
    }

    public JButton getClearButton() {
        return CLEAR_BUTTON;
    }

    public JButton getSaveButton() {
        return SAVE_BUTTON;
    }


    public JButton getUndoButton() {
        return UNDO_BUTTON;
    }

    public JButton getRedoButton() {
        return REDO_BUTTON;
    }


}
