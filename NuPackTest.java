import org.junit.Assume;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void TestParseInputString_VlaidStringReturnTrue()
    {
        boolean actual = nupack.ParseInputString("$1,299.99, 3 people, food");
        assertEquals(true, actual);
    }

    @Test
    public void TestParseInputString_InvlaidStringReturnFalse()
    {
        boolean actual = nupack.ParseInputString("$1,299.99, 3 people, food, gg");
        assertEquals(false, actual);
    }
}
