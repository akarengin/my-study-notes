package generics;

import java.util.List;

class A {
    class B extends A { }
    class C extends B { }

//    <B extends A> B method3(List<B> list) {
//        return  new B(); // DOES NOT COMPILE
//    }

//    <T> T method1(List<? extends T> list) {
//        return list.get(0);
//    }

//    <T> <? extends T> method2(List<? extends T> list) { // DOES NOT COMPILE
//        return list.get(0);
//    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void main(String[] args) {

    }
}
