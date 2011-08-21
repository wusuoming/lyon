package net.slowvic.lab;

/**
 * ����
 * <p>
 * ��̬���ɣ�������ȷ�������������Ǿ�̬���ɡ�<br>
 * ��̬���ɣ�������ȷ�������������Ƕ�̬���ɡ�<br>
 */
public class Dispatch {
    public static void main(String[] args) {
        Mozi mozi = new Mozi();
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        // ��̬������ȷ��ΪHorse����ˣ����õĶ���ride(Horse horse)
        mozi.ride(wh);
        mozi.ride(bh);
    }
}

/**
 * ī��
 * <p>
 * ģ��ī������
 */
class Mozi {
    public void ride(Horse horse) {
        System.out.print("ī������");
        // ����һ����䷢���˶�̬����
        System.out.printf("%s%n", horse);
    }

    public void ride(WhiteHorse horse) {
        System.out.printf("ī����%s%n", horse);
    }

    public void ride(BlackHorse horse) {
        System.out.printf("ī����%s%n", horse);
    }
}

class Horse {

    @Override
    public String toString() {
        return "��";
    }
}

class WhiteHorse extends Horse {
    @Override
    public String toString() {
        return "����";
    }
}

class BlackHorse extends Horse {
    @Override
    public String toString() {
        return "����";
    }
}