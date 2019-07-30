package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1 , spn2;
    Button btnGo;
    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        alCategory = new ArrayList<>();

        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item , alCategory);

        spn2.setAdapter(aaCategory);

        String[] strNumbers = getResources().getStringArray(R.array.subcategory1);
        alCategory.addAll(Arrays.asList(strNumbers));

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alCategory.clear();
                if (position == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.subcategory1);
                    alCategory.addAll(Arrays.asList(strNumbers));

                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.subcategory2);
                    alCategory.addAll(Arrays.asList(strNumbers));

                }
                aaCategory.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }

        });


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Web.class);

                int pos1 = spn1.getSelectedItemPosition();
                int pos = spn2.getSelectedItemPosition();

                String[][] sites ={{"http://www.rp.edu.sg/" , "https://www.rp.edu.sg/student-life"} , {"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47" ,"https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"}};
                alCategory.clear();
                if (pos1 == 0) {
                    if (pos == 0) {
                        intent.putExtra("web", sites[0][0]);
                    } else {
                        intent.putExtra("web", sites[0][1]);
                    }

                } else {
                    if (pos == 0) {
                        intent.putExtra("web", sites[1][0]);
                    } else {
                        intent.putExtra("web", sites[1][1]);
                    }

                }

                startActivity(intent);
                aaCategory.notifyDataSetChanged();
            }
        });

    }
}
