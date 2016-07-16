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
    public void TestParseInputString()
    {
        boolean actual = nupack.ParseInputString("hello");
        assertEquals(false, actual);
    }

}
