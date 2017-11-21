package bz.beppe.test.AOP;

/**
 * Created by zhangshangliang on 2017/10/24.
 */
public class Product {

    public String id="1111";

    public String phoneNum="2222";

    public Product() {

    }

    public Product(String id, String phoneNum) {
        this.id = id;
        this.phoneNum = phoneNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void getName(){
        System.out.println("this is the product name!!");
    }

}
