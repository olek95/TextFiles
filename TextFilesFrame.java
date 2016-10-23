package textfiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Obiekt klasy <code>TextFilesFrame</code> reprezentuje ramkę pozwalającą na 
 * wybór pliku oraz wyświetlenie jego ścieżki, liczby wierszy oraz liczby wyrazów.
 * @author AleksanderSklorz
 */
public class TextFilesFrame extends JFrame{
    JLabel pathLabel;
    JTextField linesNumberField, wordsNumberField;
    public TextFilesFrame(){
        setSize(500,125);
        setLayout(new BorderLayout());
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar); 
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem openItem = new JMenuItem("Open");
        JFileChooser chooser = new JFileChooser(); 
        chooser.setFileFilter(new FileNameExtensionFilter("Pliki tekstowe", "txt"));
        chooser.setAcceptAllFileFilterUsed(false);
        openItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(chooser.showOpenDialog(TextFilesFrame.this) == JFileChooser.APPROVE_OPTION){
                    File f = chooser.getSelectedFile();
                    String[] fileComponents = f.getName().split("[.]");
                    if(f.isFile() && fileComponents[fileComponents.length - 1].equalsIgnoreCase("txt")){
                        pathLabel.setText("Ścieżka: " + f.getPath());
                        linesNumberField.setText("" + FileManager.countLines(f));
                        wordsNumberField.setText("" + FileManager.countWords(f));
                    }else{
                        pathLabel.setText("Ściezka: Taki plik nie istnieje lub złe rozszerzenie!");
                        linesNumberField.setText("");
                        wordsNumberField.setText("");
                    }
                }
            }
        });
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> {
                System.exit(0);
        });
        fileMenu.add(openItem);
        fileMenu.add(exitItem);
        JPanel pathPanel = new JPanel();
        pathLabel = new JLabel("Ścieżka: Wybierz ścieżkę z menu File.");
        pathPanel.add(pathLabel);
        add(pathPanel, BorderLayout.NORTH);
        JPanel resultPanel = new JPanel(); 
        linesNumberField = new JTextField(); 
        wordsNumberField = new JTextField();
        linesNumberField.setEditable(false);
        wordsNumberField.setEditable(false);
        linesNumberField.setBackground(Color.WHITE);
        wordsNumberField.setBackground(Color.WHITE);
        resultPanel.setLayout(new GridLayout(2,2));
        resultPanel.add(new JLabel("Liczba wierszy: "));
        resultPanel.add(linesNumberField); 
        resultPanel.add(new JLabel("Liczba słów: ")); 
        resultPanel.add(wordsNumberField); 
        add(resultPanel, BorderLayout.CENTER);
    }
}
