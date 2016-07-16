import java.math.BigDecimal;

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

    // Properties
    public static final double BASE_MARKUP = 0.05;
    public static final double HUMAN_RESOURCE_MARKUP = 0.012;

    // Methods
    public boolean ParseInputString(String input)
    {
        return false;
    }
}
