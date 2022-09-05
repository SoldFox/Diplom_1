import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp () {
        bun = new Bun("black bun", 200);
    }

    @Test
    public void getNameReturnCorrectValue () {
        String actual = bun.getName();
        String expected = "black bun";
        Assert.assertEquals("Method return wrong value",expected,actual);
    }

    @Test
    public void getPriceReturnCorrectValue () {
        float actual = bun.getPrice();
        float expected = 200;
        Assert.assertEquals("Method return wrong value",expected,actual, 0);
    }
}