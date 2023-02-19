import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortFilter {
    public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f)
    {
        ArrayList<Object> result = new ArrayList<Object>();
        for (Object x : objects)
        {
            if (f.accept(x))
            {
                result.add(x);
            }
        }
        return result;

    }
    public static void main(String[] args) throws FileNotFoundException
    {
        JFileChooser chooser=new JFileChooser();

        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            File file=chooser.getSelectedFile();
            Scanner scanner= null;
            try
            {
                scanner = new Scanner(file);
            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }

            ArrayList<Object> words=new ArrayList<Object>();
            while(scanner.hasNext())
            {

                words.add(scanner.next());

            }
            scanner.close();

            words=collectAll(words, new ShortWordFilter());

            System.out.println("Filtered words:");

            for(Object str:words){

                System.out.println(str);

            }

        }

    }
}
