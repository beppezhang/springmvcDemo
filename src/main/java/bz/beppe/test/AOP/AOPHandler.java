package bz.beppe.test.AOP;

/**
 * Created by zhangshangliang on 2017/10/23.
 */
public class AOPHandler {

    public void timeHandler(){
        System.out.println("=== 进行了时间记录处理  ===");
    }


    public void logHandler(){
        System.out.println("=== 进行了日志记录处理  ===");
    }
}
