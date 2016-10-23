package textfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Obiekt klasy <code>FileManager</code> reprezentuje zarządcę plików. 
 * Posiada metody liczące wiersze oraz wyrazy w pliku tekstowym. 
 * @author AleksanderSklorz
 */
public class FileManager {
    public FileManager(){}
    /**
     * Liczy wiersze w pliku tekstowym. 
     * @param f przeszukiwany plik. 
     * @return liczba wierszy 
     */
    public static int countLines(File f){
        int rowsNumber = 1, previousChar = -1;
        try(FileReader file = new FileReader(f)){
            int character;
            while((character = file.read()) != -1){
                if(character == 10 && previousChar == 13)
                    rowsNumber++;
                previousChar = character;
            }
        }catch(IOException e){
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, e);
        }
        if(previousChar == -1) return 0;
        return rowsNumber;
    }
    /**
     * Liczy wyrazy w pliku tekstowym, oddzielone białymi znakami. 
     * @param f przeszukiwany plik. 
     * @return liczba wyrazów w pliku. 
     */
    public static int countWords(File f){
        int wordsNumber = 0;
        try(BufferedReader file = new BufferedReader(new FileReader(f))){
            String line = file.readLine();
            while(line != null){
                wordsNumber++;
                for(int i = 0; i < line.length() - 1; i++){
                    if((line.charAt(i) == ' ' || line.charAt(i) == '\t') && !Character.isWhitespace(line.charAt(i + 1))){
                        wordsNumber++;
                    }
                }
                line = file.readLine();
            }
        }catch(IOException e){
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return wordsNumber;
    }
}
