package spring.proj.shop.test.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OuterClass {

    private final InnerClass innerClass;

    public OuterClass(InnerClass innerClass) {
        this.innerClass = innerClass;
    }

    public void propDefault() {
        System.out.println("Outer propDefault start");
        try {
            innerClass.propDefault();
        }catch (Exception e){
//            e.printStackTrace();
        }
        System.out.println("Outer propDefault end");
    }

    public void propRequiresNew() {
        System.out.println("Outer propRequiresNew start");
        try {
            innerClass.propRequiresNew();
        }catch (Exception e){
//            e.printStackTrace();
        }
        System.out.println("Outer propRequiresNew end");
    }

}
