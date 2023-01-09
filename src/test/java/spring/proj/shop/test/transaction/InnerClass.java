package spring.proj.shop.test.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InnerClass {

    /**
     * 부모 트랜잭션 내에서 실행
     * 예외가 발생하면 롤백이 되고 호출한 곳에도 롤백이 전파
     */
    @Transactional
    public void propDefault() {
        System.out.println("inner propDefault start");
        throw new RuntimeException("Default Inner Class");
    }

    /**
     * 매번 새로운 트랜잭션을 시작
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void propRequiresNew() {
        System.out.println("inner propRequiresNew start");
        throw new RuntimeException("Propagation.REQUIRES_NEW Inner Class");
    }

}
