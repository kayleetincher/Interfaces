import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f)
    {
        ArrayList<Object> result = new ArrayList<Object>();

        for (Object x : objects) {
            if (f.accept(x)) {
                result.add(x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();

        list.add(new Rectangle(1, 2));
        list.add(new Rectangle(9, 1));
        list.add(new Rectangle(2, 3));
        list.add(new Rectangle(15, 20));
        list.add(new Rectangle(1, 1));
        list.add(new Rectangle(11, 1));




        ArrayList<Object> filtered = collectAll(list, new BigRectangleFilter());


        System.out.println("Rectangles with perimeters greater than 10:");
        for (Object x : filtered) {
            Rectangle rect = (Rectangle) x;
            System.out.println("Rectangle with perimeter: " + (2 * (rect.width + rect.height)));
        }
    }



}

