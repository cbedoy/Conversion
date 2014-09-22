package cbedoy.conversor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends ActionBarActivity {

    private Spinner spinner;
    private TextView firstTitle;
    private TextView secondTitle;
    private EditText firstValue;
    private EditText secondValue;
    private Button actionButton;

    private double currentValue;
    private double currentFactor;
    private String currentReturnValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConversionService.getInstance();
        setContentView(R.layout.activity_my);

        spinner = (Spinner) findViewById(R.id.spinner);
        firstTitle = (TextView) findViewById(R.id.title_one);
        secondTitle = (TextView) findViewById(R.id.title_two);
        firstValue = (EditText) findViewById(R.id.input_one);
        secondValue = (EditText) findViewById(R.id.input_two);


        List<ConversionModel> conversionModelList = new ArrayList<ConversionModel>();
        final ConversionModel conversionModel = new ConversionModel();
        conversionModel.setValue(40);
        conversionModel.setFromTitle("culos");
        conversionModel.setToTitle("cojidas");
        conversionModel.setFinishTitle("venidas");
        conversionModelList.add(conversionModel);

        spinner.setAdapter(new ConversionAdapter(getApplicationContext(), 0, conversionModelList));
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ConversionModel conversionModel1 = (ConversionModel) view.getTag();
                currentReturnValue = conversionModel1.getFinishTitle();
                currentFactor = conversionModel1.getValue();

                firstTitle.setText(conversionModel.getFromTitle());
                secondTitle.setText(conversionModel.getToTitle());

            }
        });


        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = Float.parseFloat(firstValue.getText().toString());
                String data = ConversionService.getInstance().calculateConversionWithData(currentValue, currentFactor, currentReturnValue);
                secondValue.setText(data);
            }
        });

    }



}
