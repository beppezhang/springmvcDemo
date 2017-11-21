package bz.beppe.test.AOP;

/**
 * Created by zhangshangliang on 2017/10/24.
 */
public class ProductReflect {

    public static void main(String[] args) {
//        反射获取字段
        try {
            Class clazz = Class.forName("bz.beppe.test.AOP.Product");
//            Field[] fields = clazz.getFields();
//            for (int i = 0; i < fields.length; i++) {
//                Field field = fields[i];
//                String name = field.getName();
//                System.out.println(name);
//            }
            Product o = (Product)clazz.newInstance();
            o.getName();


        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
