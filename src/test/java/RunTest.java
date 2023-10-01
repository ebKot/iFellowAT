import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;

public class RunTest {
    @Before
    public void beforeClass() {
        System.out.println("Before class");
    }

    @After
    public void afterClass() {
        System.out.println("After class");
    }

    @Test
    public void Test1() {
        System.out.println("1");
        int a = 25;
        Assertions.assertEquals(a, 25);
    }

    @Test
    public void Test2() {
        System.out.println("2");
        String firstName = "Bob";
        Assertions.assertNull(firstName);
    }


    public void main(String[] args) {
        open("https://demoqa.com/automation-practice-form");
    }
}
