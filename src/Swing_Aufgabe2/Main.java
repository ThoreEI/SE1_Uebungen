package Swing_Aufgabe2;


public class Main {
    public static void main(String[] args) {
        PrintAndSaveWindow window = new PrintAndSaveWindow();
        new PrintAndSaveWindowController(window);
        window.setVisible(true);
    }
}
