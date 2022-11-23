import org.testng.annotations.*;
import static org.testng.Assert.*;

public class PersonTest {
boolean IsTeen;
    @BeforeClass
    void beforeClass() {
        System.out.println("Before class");
        assertNotNull(dataProvider());
    }
    @AfterTest
    void afterTest() {
        System.out.println("After Test");
        }
    @DataProvider(name = "isTeen")
    Object[][] dataProvider() {
        return new Object[][] {
                {120, IsTeen},
                {20, IsTeen},
                {19, IsTeen},
                {18, IsTeen},
                {14, IsTeen},
                {13, IsTeen},
                {12, IsTeen},
                {0, IsTeen},
                {-1, IsTeen},
        };
    }
    @Test (dataProvider = "isTeen")
    public void TestTeen(int age, boolean expected) {
        IsTeen = age >= 13 && age <= 19;
        boolean result = Person.isTeenager(age);
//        System.out.println("Person " + result + " " + age);
//        System.out.println("IsTeen " + IsTeen + " " + age);
        assertEquals(result, IsTeen, "is not a teenager");
           }
}
