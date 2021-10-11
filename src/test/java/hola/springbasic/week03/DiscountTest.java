package hola.springbasic.week03;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiscountTest {

    /**
     * 1. Reflection을 이용해 Constructor를 이용해 객체 생성 만들기
     */
    @Test
    void Solution01() throws NoSuchMethodException {
        Class discountClass = Discount.class;
        System.out.println("class name === " + discountClass.getName());
        Constructor constructor = discountClass.getConstructor(new Class[]{String.class, String.class});
        Constructor declaredConstructor = discountClass.getDeclaredConstructor();
        System.out.println("Constructor === " + declaredConstructor.getName());

        Constructor constructors[] = discountClass.getDeclaredConstructors();
        for (Constructor cons : constructors) {
            System.out.println("Get Cconstructors in Discount : " + cons);
        }
        try {
            Discount discount = (Discount) constructor.newInstance("RatePolicy", "10"); // newInstance의 반환형이 Object라 캐스팅이 필요함.
            System.out.println("Discount === " + discount.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 2. Reflection을 이용해 Method를 실행하는 예제코드 만들기
     */
    @Test
    void Solution02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class classes = Class.forName("hola.springbasic.week03.Discount");
        Method method = classes.getDeclaredMethod("method1");
        method.setAccessible(true);
        method.invoke(new Discount());
    }

    /**
     * Reflection을 이용해 Field를 변경하는 예제코드 만들기
     */
    @Test
    void Solution03() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class classes = Class.forName("hola.springbasic.week03.Discount");
        Field field = classes.getDeclaredField("policy");
        System.out.println("field == " + field);

        Discount discount = new Discount();
        field.setAccessible(true);
        field.set(discount, "FixFixPolicy");
        System.out.println("field after change === " + discount);
    }
}