package cbedoy.conversor;

/**
 * Created by Carlos on 22/09/2014.
 */
public class ConversionModel
{
    private float value;
    private String fromTitle;
    private String toTitle;
    private String finishTitle;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public ConversionModel(){}

    public String getFinishTitle() {
        return finishTitle;
    }

    public String getFromTitle() {
        return fromTitle;
    }

    public String getToTitle() {
        return toTitle;
    }

    public void setFinishTitle(String finishTitle) {
        this.finishTitle = finishTitle;
    }

    public void setFromTitle(String fromTitle) {
        this.fromTitle = fromTitle;
    }

    public void setToTitle(String toTitle) {
        this.toTitle = toTitle;
    }
}
