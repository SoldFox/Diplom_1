import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;
    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunSettsCorrectValue () {
        burger.setBuns(bun);
        Assert.assertEquals("Method setts incorrect value to bun",bun, burger.bun);
    }

    @Test
    public void addIngredientAddsValueCorrectly () {
        burger.addIngredient(ingredient);
        Assert.assertEquals("Method don't added value",1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientRemovesValueCorrectly () {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Method don't removed value", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientCorrectlyMovesValues () {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1,0);
        Assert.assertEquals("Method don't moved values", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceReturnCorrectValue () {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);

        Mockito.doReturn(100F).when(bun).getPrice();
        Mockito.doReturn(100F).when(ingredient).getPrice();
        Mockito.doReturn(300F).when(ingredient2).getPrice();
        float actual = burger.getPrice();
        float expected = 600;

        Assert.assertEquals("Method return incorrect price", expected, actual,0);
    }

    @Test
    public void getReceiptReturnCorrectValue () {
        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        Mockito.doReturn("black bun").when(bun).getName();
        Mockito.doReturn(100F).when(bun).getPrice();
        Mockito.doReturn(IngredientType.SAUCE).when(ingredient).getType();
        Mockito.doReturn("hot sauce").when(ingredient).getName();
        Mockito.doReturn(100F).when(ingredient).getPrice();
        String actual = burger.getReceipt();
        String expected = "(==== black bun ====)" + System.lineSeparator() + "= sauce hot sauce ="+ System.lineSeparator() + "(==== black bun ====)" + System.lineSeparator()+System.lineSeparator() + "Price: 300,000000"+ System.lineSeparator();

        Assert.assertEquals("Method return incorrect receipt", expected,  actual); // Work only with (System.lineSeparator()) in variable - expected;
    }
}