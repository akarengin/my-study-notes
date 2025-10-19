package generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumber extends NaturalNumber {
    public int i;
    public EvenNumber(int i) { super(i); }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private static <T> void fooHelper(List<T> l) {
        l.set(2, l.get(0));
    }

    public static void main(String[] args) {
        List<EvenNumber> le = new ArrayList<>();
        le.add(new EvenNumber(5));
        le.add(new EvenNumber(1));
        le.add(new EvenNumber(2));
        List<? extends NaturalNumber> ln = le;
        //ln.add(new NaturalNumber(35));  // compile-time error
        fooHelper(ln);
        int i = 0;
        for (NaturalNumber naturalNumber: ln) {
            System.out.println(ln.get(i).toString());
            i++;
        }
            
    }
}