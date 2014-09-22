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

        //LINK VIEWS
        spinner = (Spinner) findViewById(R.id.spinner);
        firstTitle = (TextView) findViewById(R.id.title_one);
        secondTitle = (TextView) findViewById(R.id.title_two);
        firstValue = (EditText) findViewById(R.id.input_one);
        secondValue = (EditText) findViewById(R.id.input_two);

        //MAKE VIEW WITHOUT EDIT TEXT
        secondValue.setEnabled(false);

        //ADD MODEL TO LIST
        List<ConversionModel> conversionModelList = new ArrayList<ConversionModel>();
        ConversionModel conversionModel = new ConversionModel();
        conversionModel.setValue(40);
        conversionModel.setFromTitle("culos");
        conversionModel.setToTitle("cojidas");
        conversionModel.setFinishTitle("venidas");
        conversionModelList.add(conversionModel);
        conversionModel = new ConversionModel();
        conversionModel.setValue(10);
        conversionModel.setFromTitle("metros");
        conversionModel.setToTitle("cm");
        conversionModel.setFinishTitle("metros por segundo");
        conversionModelList.add(conversionModel);
        conversionModel = new ConversionModel();
        conversionModel.setValue(0.874554);
        conversionModel.setFromTitle("xx");
        conversionModel.setToTitle("aaa");
        conversionModel.setFinishTitle("ccc");
        conversionModelList.add(conversionModel);
        conversionModel = new ConversionModel();
        conversionModel.setValue(1.3335);
        conversionModel.setFromTitle("dasdsada");
        conversionModel.setToTitle("ljlkjljlk");
        conversionModel.setFinishTitle(".i.");
        conversionModelList.add(conversionModel);

        //SETTING ADAPTER
        spinner.setAdapter(new ConversionAdapter(getApplicationContext(), 0, conversionModelList));
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //CHOOSE MODEL AND SET VALUES ON VIEW
                ConversionModel currentModel = (ConversionModel) view.getTag();
                currentReturnValue = currentModel.getFinishTitle();
                currentFactor = currentModel.getValue();
                firstTitle.setText(currentModel.getFromTitle());
                secondTitle.setText(currentModel.getToTitle());

            }
        });


        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GET VALUE FROM INPUT
                currentValue = Float.parseFloat(firstValue.getText().toString());
                //CALL SERVICE TO MAKE CONVERSION
                String data = ConversionService.getInstance().calculateConversionWithData(currentValue, currentFactor, currentReturnValue);
                //SET VALUE ON INPUT
                secondValue.setText(data);
            }
        });

    }



}
