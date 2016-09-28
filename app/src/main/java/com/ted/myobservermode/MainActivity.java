package com.ted.myobservermode;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.ted.view.ButtonRedOb;
import com.ted.view.ButtonRedSub;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_red_ob1)
    ButtonRedOb BtnRedOb1;

    @BindView(R.id.btn_red_ob2)
    ButtonRedOb BtnRedOb2;

    @BindView(R.id.btn_red_ob3)
    ButtonRedOb BtnRedOb3;

    @BindView(R.id.btn_subject_red)
    ButtonRedSub BtnRedSubject;

    @OnClick(R.id.btn_subject_red)
    void BtnRedSubjectOnClick(){
        BtnRedSubject.notifyObserver();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observer_pattern_layout);
        ButterKnife.bind(this);

        init();
        //ObserverPatternTest();
    }

    private void init() {
        BtnRedOb1.init(BtnRedSubject);
        BtnRedOb2.init(BtnRedSubject);
        BtnRedOb3.init(BtnRedSubject);
    }

    private void ObserverPatternTest() {
        //定义一个主题，两个观察者
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        List<Float> forecastTemperatures = new ArrayList<Float>();
        forecastTemperatures.add(22f);
        forecastTemperatures.add(22.1f);
        forecastTemperatures.add(22.2f);
        forecastTemperatures.add(22.9f);
        forecastTemperatures.add(22.7f);
        forecastTemperatures.add(22.5f);
        forecastTemperatures.add(22.4f);
        forecastTemperatures.add(22.3f);
        weatherData.setMeasurements(22f,0.8f, 1.2f, forecastTemperatures);

    }
}
