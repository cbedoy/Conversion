package cbedoy.conversor;

/**
 * Created by Carlos on 22/09/2014.
 */
public class ConversionService
{
    public static ConversionService instance;

    public static ConversionService getInstance(){
        if(instance == null){
            instance = new ConversionService();
        }
        return instance;
    }

    public String calculateConversionWithData(double value, double factor, String title){
        return (value * factor) + title;
    }

    public enum ConversionKey{
        KM_TO_MILLAS(48.8f),
        A_TO_Y(50.0f),
        B_TO_X(50.0f),
        C_TO_Z(50.0f);

        ConversionKey(double value) {

        }
    }
}
