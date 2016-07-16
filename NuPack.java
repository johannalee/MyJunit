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
    public static final double BASE_MARKUP = 1.05;
    public static final double HUMAN_RESOURCE_MARKUP = 0.012;

    public int GetNumOfPeeps() { return numOfPeeps; }
    public BigDecimal GetPrice() { return price; }
    public ProductType GetProductType() { return productType; }

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
            // parse first item, the price
            String s = list.get(0);
            price = new BigDecimal(s.replaceAll("[\\$\\,]",""));

            // second item, the number of people to work on the job
            s = list.get(1).split(" ")[0];
            numOfPeeps = Integer.parseInt(s);

            // thrid item, the product type
            s = list.get(2).toUpperCase().trim();

            // System.console().writer().println(s);

            if (s.equals("FOOD"))
            {
                productType = ProductType.FOOD;
            }
            else if (s.equals("ELECTRONICS"))
            {
                productType = ProductType.ELECTRONICS;
            }
            else if (s.equals("DRUGS"))
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

    public BigDecimal GetBasePrice()
    {
        return price.multiply(BigDecimal.valueOf(BASE_MARKUP));
    }

    public double GetMarkup()
    {
        return 1 + numOfPeeps*HUMAN_RESOURCE_MARKUP + productType.GetValue();
    }
}
