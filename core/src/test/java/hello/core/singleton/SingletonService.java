package hello.core.singleton;

public class SingletonService {

    // static 영역에 SingletonService 인스턴스를 미리 하나 생성해서 올려둠
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서 인스턴스 생성 X
    private SingletonService() {

    }
    public void logic() {
        System.out.println("싱클톤 객체 로직 호출");
    }
}
