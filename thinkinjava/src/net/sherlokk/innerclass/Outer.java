package net.sherlokk.innerclass;

public class Outer {
    private String s = "外围类的私有字段";

    class Inner {
        Inner() {
            System.out.println("Inner被创建了");
        }

        public void printS() {
            System.out.println(s);
        }
    }

    Inner getInner() {
        return new Inner();
    }

    Bird buyABird() {
        class Swallow implements Bird {
            public void fly() {
                System.out.println("燕子三抄水");
            }
        }
        return new Swallow();
    }

    Destination destination(final String s) {
        return new Destination() {
            private String dest = s;

            public String getDest() {
                return dest;
            }
        };
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.printS();
    }
}
