package Swing_Aufgabe1;

public class Main {

        public static void main(String[] args) {

           GameBoardWindow window = new GameBoardWindow();
            new GameBoardWindowController(window);
            window.setVisible(true);
        }
    }


