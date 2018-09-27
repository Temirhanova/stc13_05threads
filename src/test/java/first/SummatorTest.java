package first;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.innopolis.stc13._14_JUnit_4.first.Summator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SummatorTest {
    private Summator summator;

    @BeforeAll
    static void beforeAll(){
        System.out.println("This is @BeforeAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("This is @BeforeEach");
        summator = new Summator();
    }

    @Test
    void sumTest(){
        int sum = this.summator.summ(2,3);
        assertEquals(5, sum);
    }

    @Test
    void doSomeTest(){
        assertThrows(RuntimeException.class,()->this.summator.doSome(5));
    }

    @Test
    void doSomeTestNoException(){
        assertDoesNotThrow(()->this.summator.doSome(4));
    }
}
