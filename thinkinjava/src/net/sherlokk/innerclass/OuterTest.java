package net.sherlokk.innerclass;

public class OuterTest {
    public void test() {
        Outer.Inner inner = new Outer().new Inner();
        inner.printS();
    }

    public void test1() {
        Bird bird = new Outer().buyABird();
        bird.fly();
    }

    public void test2() {
        Destination dest = new Outer().destination("北京");
        System.out.println(dest.getDest());
    }

    public static void main(String[] args) {
        OuterTest test = new OuterTest();
        test.test();
        test.test1();
        test.test2();
    }
}
