import java.util.ArrayList;

public class Main
{
    public static  ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f) {
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
}