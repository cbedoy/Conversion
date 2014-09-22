package cbedoy.conversor;

/**
 * Created by Carlos on 22/09/2014.
 */
public class ConversionService
{
    //SINGLETON CLASS FOR MAKE CONVERCIONS
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


}
