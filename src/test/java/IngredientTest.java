import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} - {1}")
    public static Object[] setUpIngredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceReturnCorrectValue() {
        float actual = ingredient.getPrice();
        float expected = price;
        Assert.assertEquals("Method return wrong value", expected, actual, 0);
    }

    @Test
    public void getNameReturnCorrectValue() {
        String actual = ingredient.getName();
        String expected = name;
        Assert.assertEquals("Method return wrong value", expected, actual);
    }

    @Test
    public void getTypeReturnCorrectValue() {
        IngredientType actual = ingredient.getType();
        IngredientType expected = type;
        Assert.assertEquals("Method return wrong value", expected, actual);
    }
}
