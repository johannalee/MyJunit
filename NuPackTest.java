import org.junit.Assume;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NuPackTest
{
    NuPack nupack;

    double price;
    int numOfPeople;
    ProductType pt;
    public static final int DECIMALS = 2;
    @Before
    public void Setup()
    {
        nupack = new NuPack();
    }

    @Test
    public void TestProductTypeConstructor()
    {
        pt = ProductType.DRUGS;
        assertEquals(0.075, pt.GetValue(), DECIMALS);
    }

    @Test
    public void TestParseInputString_ValidStringReturnTrue()
    {
        boolean actual = nupack.ParseInputString("$1,299.99, 3 people, food");
        assertEquals(true, actual);
        assertEquals(1299.99, nupack.GetPrice().doubleValue(), DECIMALS);
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
        BigDecimal expected = BigDecimal.valueOf(1364.99);
        BigDecimal actual = BigDecimal.valueOf(0);

        if (nupack.ParseInputString("$1,299.99, 3 people, food"))
        {
            actual = nupack.GetBasePrice();
        }

        assertEquals(expected.setScale(DECIMALS, RoundingMode.HALF_UP), actual.setScale(DECIMALS, RoundingMode.HALF_UP));
    }

    @Test
    public void TestGetMarkup_ReturnCorrectValue()
    {
        double expected = 1.17;
        double actual = 0;

        if (nupack.ParseInputString("$1,299.99, 3 people, food"))
        {
            actual = nupack.GetMarkup();
        }

        assertEquals(expected, actual, DECIMALS);
    }

    @Test
    public void TestConvertBigDecimalToMoneyFormat()
    {
        String actual = "$13,707,999.70";
        String expected = nupack.ConvertBigDecimalToMoneyFormat(new BigDecimal(13707999.699993));
        assertEquals(expected, actual);
    }

    @Test
    public void TestCalculateMakrupPricing_GivenExample1()
    {
        String expected = "$1,591.58";
        String input = "$1,299.99, 3 people, food";
        String actual = nupack.CalculateMarkupPricing(input);

        assertEquals(expected, actual);
    }

    @Test
    public void TestCalculateMakrupPricing_GivenExample2()
    {
        String expected = "$6,199.81";
        String input = "$5,432.00, 1 person, drugs";
        String actual = nupack.CalculateMarkupPricing(input);

        assertEquals(expected, actual);
    }

    @Test
    public void TestCalculateMakrupPricing_GivenExample3()
    {
        String expected = "$13,707.63";
        String input = "$12,456.95, 4 people, books";
        String actual = nupack.CalculateMarkupPricing(input);

        assertEquals(expected, actual);
    }
}
