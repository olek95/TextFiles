package textfiles;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class TextFiles {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new TextFilesFrame();
                frame.setTitle("Operacje na plikach tekstowych.");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
