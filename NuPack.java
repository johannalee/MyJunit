import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

enum ProductType
{
    OTHERS(0), DRUGS(0.075), FOOD(0.13), ELECTRONICS(0.02);
    private double markup;

    private ProductType(double markup)
    {
        this.markup = markup;
    }

    public double GetValue()
    {
        return markup;
    }
}

public class NuPack
{

    // Fields
    private int numOfPeeps;
    private BigDecimal price;
    private ProductType productType;

    // Properties
    public static final double BASE_MARKUP = 0.05;
    public static final double HUMAN_RESOURCE_MARKUP = 0.012;

    // Methods
    public boolean ParseInputString(String input)
    {

        List<String> list = Arrays.asList(input.split(", "));
        if (list.size() != 3)
        {
            return false;
        }

        try
        {
            String s = list.get(0);
            price = new BigDecimal(s.replaceAll("[\\$\\,]",""));

            s = list.get(1).split(" ")[0];
            numOfPeeps = Integer.parseInt(s);

            s = list.get(2).toUpperCase();

            if (s == "FOOD")
            {
                productType = ProductType.FOOD;
            }
            else if (s == "ELECTRONICS")
            {
                productType = ProductType.ELECTRONICS;
            }
            else if (s == "DRUGS")
            {
                productType = ProductType.DRUGS;
            }
            else
            {
                productType = ProductType.OTHERS;
            }
        }
        catch (Exception e)
        {
            System.err.println("Parsing went wrong\n" + e.getMessage());
        }

        return true;
    }
}
