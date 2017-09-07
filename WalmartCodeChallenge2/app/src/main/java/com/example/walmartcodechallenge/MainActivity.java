package com.example.walmartcodechallenge;

import android.app.Activity;
import android.icu.util.TimeZone;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.walmartcodechallenge.model.ForecastCondition;
import com.example.walmartcodechallenge.model.WeatherData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final static String API_KEY="1db5a3782d490009";
    final static String ZIP_CODE="30005";
    public WeatherData weatherData;
    Call<WeatherData> weatherDataCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RestAPI restAPI = BaseURL.getAPI();
        //Toast.makeText(activity, "2", Toast.LENGTH_SHORT).show();
        weatherDataCall = restAPI.getAll(API_KEY,ZIP_CODE);

        new GetData().execute();
    }

    public class GetData extends AsyncTask<Void,Void,WeatherData> {






        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected WeatherData doInBackground(Void... voids) {




            try {
                Response<WeatherData> response= weatherDataCall.execute();

                weatherData = response.body();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return weatherData;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        protected void onPostExecute(WeatherData weatherData) {
            super.onPostExecute(weatherData);

            Date currentTime = Calendar.getInstance().getTime();

            ((TextView) findViewById(R.id.cityState)).setText(weatherData.getCurrentObservation().getDisplayLocation().getFull());
            ((TextView) findViewById(R.id.tempDisplay)).setText(weatherData.getCurrentObservation().getCelcius()+(char) 0x00B0);
            ((TextView) findViewById(R.id.weatherType)).setText(weatherData.getCurrentObservation().getWeather());

            if(Float.parseFloat(weatherData.getCurrentObservation().getCelcius())<25){
                ((ConstraintLayout) findViewById(R.id.mainDisplay)).setBackgroundColor(getResources().getColor(R.color.lightBlue));

            }else{
                ((ConstraintLayout) findViewById(R.id.mainDisplay)).setBackgroundColor(getResources().getColor(R.color.saffron));
            }

            List<ForecastCondition> full = new ArrayList<ForecastCondition>();
            List<ForecastCondition> today = new ArrayList<ForecastCondition>();
            List<ForecastCondition> tomorrow = new ArrayList<ForecastCondition>();
            List<ForecastCondition> dayAfterTomorrow = new ArrayList<ForecastCondition>();

            full = weatherData.getForecastCondition();



                       for(ForecastCondition temp: full){

                if(Integer.parseInt(temp.getFactTime().getMon())==(currentTime.getMonth()+1)){

                    if(Integer.parseInt(temp.getFactTime().getMday())==currentTime.getDate()){

                        today.add(temp);
                    }
                    else if (Integer.parseInt(temp.getFactTime().getMday())==(currentTime.getDate()+1)){
                        tomorrow.add(temp);
                    }else if (Integer.parseInt(temp.getFactTime().getMday())==(currentTime.getDate()+2)){
                        dayAfterTomorrow.add(temp);
                    }
                }
            }



            //CardView cardView = (CardView) findViewById(R.id.card_view_todays_weather);



            //View linearLayout = (View) findViewById(R.id.todayView); //new LinearLayout(getApplicationContext());
            //linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            //ArrayList<View> todays = new ArrayList<>();
            //for(ForecastCondition temp: today){
                //linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout layout2 = new LinearLayout(getApplicationContext());

                layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                layout2.setOrientation(LinearLayout.VERTICAL);



                TextView tv1 = (TextView) findViewById(R.id.time) ;
                ImageView iv = (ImageView) findViewById(R.id.image) ;
                TextView tv2 = (TextView) findViewById(R.id.temp) ;

                tv1.setText(today.get(0).getFactTime().getCivil());
                iv.setImageResource(R.drawable.ic_cloud_24dp);
                tv2.setText(today.get(0).getTemp().getMetric());


            TextView tv1T = (TextView) findViewById(R.id.timeTomorrow) ;
            ImageView ivT = (ImageView) findViewById(R.id.imageTommorow) ;
            TextView tv2T = (TextView) findViewById(R.id.tempTomorrow) ;

            tv1T.setText(tomorrow.get(0).getFactTime().getCivil());
            ivT.setImageResource(R.drawable.ic_wb_sunny_24dp);
            //System.out.println(tomorrow.get(0).getTempCelsius());
            tv2T.setText(tomorrow.get(0).getTemp().getMetric());

                //todays.add(layout2);



            //}





        }
    }


}
