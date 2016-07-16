import org.junit.Assume;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class NuPackTest
{
    NuPack nupack;

    double price;
    int numOfPeople;
    ProductType pt;

    @Before
    public void Setup()
    {
        nupack = new NuPack();
    }

    @Test
    public void TestProductTypeConstructor()
    {
        pt = ProductType.DRUGS;
        assertEquals(0.075, pt.GetValue(), 2);
    }

    @Test
    public void TestParseInputString_ValidStringReturnTrue()
    {
        boolean actual = nupack.ParseInputString("$1,299.99, 3 people, food");
        assertEquals(true, actual);
        assertEquals(1299.99, nupack.GetPrice().doubleValue(), 2);
        assertEquals(3, nupack.GetNumOfPeeps());
        assertEquals(ProductType.FOOD, nupack.GetProductType());
    }

    @Test
    public void TestParseInputString_InvlaidStringReturnFalse()
    {
        boolean actual = nupack.ParseInputString("$1,299.99, 3 people, food, gg");
        assertEquals(false, actual);
    }

    @Test
    public void TestGetBasePrice_ValidReturn()
    {
        double expected = 1299.99*0.05;
        double actual = 0;

        if (nupack.ParseInputString("$1,299.99, 3 people, food"))
        {
            actual = nupack.GetBasePrice();
        }

        assertEquals(expected, actual, 2);
    }
}
