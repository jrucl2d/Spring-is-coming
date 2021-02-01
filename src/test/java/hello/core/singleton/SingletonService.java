package hello.core.singleton;

public class SingletonService {

    // 클래스 레벨로 선언하므로 static으로 선언하므로 메모리에 딱 하나 올라간다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){} // private 생성자로 생성을 막아버림

    public void logic(){
        System.out.println("싱글톤 객체 로직을 호출함");
    }
}
