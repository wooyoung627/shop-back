package spring.proj.shop.test.transaction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MarkedRollbackTest {

    @Autowired OuterClass outerClass;

//    @Rollback(value = false)
//    @Transactional
    @Test
    void propDefault() throws Exception {
        outerClass.propDefault();
//        assertThrowsExactly(UnexpectedRollbackException.class, outerClass::propDefault);
    }

    @Test
    void propRequiresNew() throws Exception {
        outerClass.propRequiresNew();
    }
    
}
