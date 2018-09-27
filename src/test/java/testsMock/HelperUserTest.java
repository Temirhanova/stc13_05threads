package testsMock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.innopolis.stc13._14_JUnit_4.tests.Helper;
import ru.innopolis.stc13._14_JUnit_4.tests.HelperUser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HelperUserTest {
    private HelperUser helperUser;
    private Helper helper = Mockito.mock(Helper.class);

    @BeforeEach
    void beforeEach() {
        helperUser = new HelperUser(helper);
    }

    @Test
    void helperUserMethodTest(){
        when(helper.someHeplper(anyInt(), anyInt())).thenReturn(1);
        Integer res = helperUser.helperUserTethod(1,2);
        verify(helper).someHeplper(9,24);
        assertEquals(new Integer(1), res);
    }
}
