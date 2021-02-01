package hello.core.singleton;

// 싱글톤 서비스는 항상 상태를 무상태로 유지시키자.
public class StatefulService {

//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제가 됨
        return price; // 상태를 유지하지 않고 값을 리턴하면 됨
    }

//    public int getPrice(){
//        return price;
//    }
}
