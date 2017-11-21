package bz.beppe.common;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhangshangliang on 2017/11/21.
 */
public class Receiver {

    private String name;

    @Autowired
    public Receiver(String name) {
        this.name = name;
    }

    public void receiveMessage(String message){
        System.out.println(name+message);
    }


}
