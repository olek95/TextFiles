package textfiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFilesFrame extends JFrame{
    JLabel pathLabel;
    JTextField linesNumberField, wordsNumberField;
    public TextFilesFrame(){
        setLayout(new BorderLayout());
        JPanel pathPanel = new JPanel();
        pathLabel = new JLabel("Wybierz ścieżkę z menu File:");
        pathPanel.add(pathLabel);
        add(pathPanel, BorderLayout.NORTH);
        JPanel resultPanel = new JPanel(); 
        JLabel linesNumberLabel = new JLabel("Liczba wierszy: ");
        JLabel wordsNumberLabel = new JLabel("Liczba słów: ");
        linesNumberField = new JTextField(); 
        wordsNumberField = new JTextField();
        linesNumberField.setEditable(false);
        wordsNumberField.setEditable(false);
        linesNumberField.setBackground(Color.WHITE);
        wordsNumberField.setBackground(Color.WHITE);
        resultPanel.setLayout(new GridLayout(2,2));
        resultPanel.add(linesNumberLabel);
        resultPanel.add(linesNumberField); 
        resultPanel.add(wordsNumberLabel); 
        resultPanel.add(wordsNumberField); 
        add(resultPanel, BorderLayout.CENTER);
        pack();
    }
}
