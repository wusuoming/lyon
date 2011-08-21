package net.slowvic.lab;

/**
 * 分派
 * <p>
 * 静态分派：编译期确定。方法重载是静态分派。<br>
 * 动态分派：运行期确定。方法覆盖是动态分派。<br>
 */
public class Dispatch {
    public static void main(String[] args) {
        Mozi mozi = new Mozi();
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        // 静态类型已确定为Horse，因此，调用的都是ride(Horse horse)
        mozi.ride(wh);
        mozi.ride(bh);
    }
}

/**
 * 墨子
 * <p>
 * 模拟墨子骑马
 */
class Mozi {
    public void ride(Horse horse) {
        System.out.print("墨子骑马，");
        // 下面一条语句发生了动态分派
        System.out.printf("%s%n", horse);
    }

    public void ride(WhiteHorse horse) {
        System.out.printf("墨子骑%s%n", horse);
    }

    public void ride(BlackHorse horse) {
        System.out.printf("墨子骑%s%n", horse);
    }
}

class Horse {

    @Override
    public String toString() {
        return "马";
    }
}

class WhiteHorse extends Horse {
    @Override
    public String toString() {
        return "白马";
    }
}

class BlackHorse extends Horse {
    @Override
    public String toString() {
        return "黑马";
    }
}