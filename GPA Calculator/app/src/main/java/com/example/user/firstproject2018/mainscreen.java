package com.example.user.firstproject2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.app.*;
import android.os.*;
import android.text.InputFilter;
import android.view.*;
import android.widget.*;
import java.util.stream.*;
import java.text.DecimalFormat;
import android.widget.Toast;

import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


public class mainscreen extends AppCompatActivity {
   // private InputStreamReader textView4;
    EditText yourname, ma135, ma137, cs135, ec120, ec, cs136, ma136, calcMa, bu111, bu2, comm;
    TextView textView;
    TextView result, percentresult;
    Button calc;
    String university, name;
    //float resultnum = 0;
    int grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10, grade11;
    double r;
    /*EditText[] et1 = new EditText[] {
            (EditText) findViewById(R.id.ma135),
            (EditText) findViewById(R.id.ma137),
            (EditText) findViewById(R.id.cs135),
            (EditText) findViewById(R.id.ec120),
            (EditText) findViewById(R.id.cs136),
            (EditText) findViewById(R.id.ma136),
            (EditText) findViewById(R.id.bu111),
            (EditText) findViewById(R.id.bu2),
            (EditText) findViewById(R.id.comm),
            (EditText) findViewById(R.id.ec),
            (EditText) findViewById(R.id.calcMa),
    };*/

    // Textbox = (TextView) findViewById(R.id.drawer_layout)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        //MainActivity hahaha = new MainActivity();
        // String name = MainActivity.name;
        //FIX NAME

        // This is to get id sent over
        // university name
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                university= null;
            } else {
                university= extras.getString("key");
            }
        } else {
            university = (String) savedInstanceState.getSerializable("key");
        }

        //get_name
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                name= null;
            } else {
                name= extras.getString("key_name");
            }
        } else {
            name = (String) savedInstanceState.getSerializable("key_name");
        }



        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText("Welcome " + name + "!"); //display WELCOME possibly name

        //yourname.getText().toString() FIX NAME

        //EditText ma135 = (EditText) findViewById(R.id.ma135);

        //ma135.setFilters(new InputFilter[]{new AbstractFilter("1", "12")});



        final EditText[] et1 = new EditText[] {
                (EditText) findViewById(R.id.ma135),
                (EditText) findViewById(R.id.ma137),
                (EditText) findViewById(R.id.cs135),
                (EditText) findViewById(R.id.ec120),
                (EditText) findViewById(R.id.cs136),
                (EditText) findViewById(R.id.ma136),
                (EditText) findViewById(R.id.bu111),
                (EditText) findViewById(R.id.bu2),
                (EditText) findViewById(R.id.comm),
                (EditText) findViewById(R.id.ec),
                (EditText) findViewById(R.id.calcMa), //calling edit text by calling unique id
        };

        final int[] grades = new int[]  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //initializing to set as 0

        calc = (Button) findViewById(R.id.calc);
        result = (TextView) findViewById(R.id.rez);
        percentresult = (TextView) findViewById(R.id.percentrez);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // listener means when it is pressed (hold) not a manual link

                float resultnum = 0;
                float gpacount = 0;
                float indgrade = 0;
                double gpa = 0.0;
                int divisor = 0;


                for (int i = 0; i < 11; i++) {
                    if (et1[i].getText().toString().isEmpty()) {
                        grades[i] = 0;

                    } // for loop go over all the text to check if it is empty, if it is empty it is 0
                    else if (Integer.parseInt(et1[i].getText().toString()) > 100 ||
                            Integer.parseInt(et1[i].getText().toString()) > 100) {
                        grades[i] = -1;
                    } else {
                        grades[i] = Integer.parseInt(et1[i].getText().toString()); // or else it is the grade
                        divisor++; // divisor also increase
                    }
                }

                    /*grade1 = Integer.parseInt(et1[0].getText().toString());
                    grade2 = Integer.parseInt(et1[1].getText().toString());
                    grade3 = Integer.parseInt(et1[2].getText().toString());
                    grade4 = Integer.parseInt(et1[3].getText().toString());
                    grade5 = Integer.parseInt(et1[4].getText().toString());
                    grade6 = Integer.parseInt(et1[5].getText().toString());
                    grade7 = Integer.parseInt(et1[6].getText().toString());
                    grade8 = Integer.parseInt(et1[7].getText().toString());
                    grade9 = Integer.parseInt(et1[8].getText().toString());
                    grade10 = Integer.parseInt(et1[9].getText().toString());
                    grade11 = Integer.parseInt(et1[10].getText().toString());*/


                //resultnum = (grade1 + grade2 + grade3 + grade4 + grade5 + grade6 + grade7 + grade8 + grade9 + grade10 + grade11) / divisor;

                for (int i = 0; i < 11; i++) {
                    resultnum += grades[i];
                }
                // adds up the grades

                resultnum = resultnum / divisor;

                if (university.contains("Waterloo")) {

                    for (int i = 0; i < 11; i++) {

                        indgrade = grades[i];


                        if (indgrade >= 90) {
                            r = 4.0;
                        } else if (indgrade >= 85) {
                            r = 3.9;
                        } else if (indgrade >= 80) {
                            r = 3.7;
                        } else if (indgrade >= 77) {
                            r = 3.3;
                        } else if (indgrade >= 73) {
                            r = 3.0;
                        } else if (indgrade >= 70) {
                            r = 2.7;
                        } else if (indgrade >= 67) {
                            r = 2.3;
                        } else if (indgrade >= 63) {
                            r = 2.0;
                        } else if (indgrade >= 60) {
                            r = 1.7;
                        } else if (indgrade >= 57) {
                            r = 1.3;
                        } else if (indgrade >= 53) {
                            r = 1.0;
                        } else if (indgrade >= 50) {
                            r = 0.7;
                        } else {
                            r = 0;
                        }

                        gpacount += r;
                    }
                }

                //else laurier grade
                else if (university.contains("Laurier")){
                    for (int i = 0; i < 11; i++) {

                        indgrade = grades[i];


                        if (indgrade >= 90) {
                            r = 12.0;
                        } else if (indgrade >= 85) {
                            r = 11;
                        } else if (indgrade >= 80) {
                            r = 10;
                        } else if (indgrade >= 77) {
                            r = 9;
                        } else if (indgrade >= 73) {
                            r = 8;
                        } else if (indgrade >= 70) {
                            r = 7;
                        } else if (indgrade >= 67) {
                            r = 6;
                        } else if (indgrade >= 63) {
                            r = 5;
                        } else if (indgrade >= 60) {
                            r = 4;
                        } else if (indgrade >= 57) {
                            r = 3;
                        } else if (indgrade >= 53) {
                            r = 2;
                        } else if (indgrade >= 50) {
                            r = 1;
                        } else {
                            r = 0;
                        }

                        gpacount += r;
                    }
                }

                gpa = gpacount / divisor;

                boolean valid = true;

                for (int m = 0; m < 11; ++m) {
                    if (grades[m] == -1) {
                        valid = false;
                    }
                } // check if the code is valid

                if (valid == true) {
                    result.setText(String.format("%.2f", gpa));
                    percentresult.setText(String.format("%.2f", resultnum) + "%"); // %.2f limit to two float
                } else {
                    result.setText(String.format("Error"));
                    percentresult.setText(String.format("Error")); // %.2f limit to two float

                }
            }




            });
        }



    }



