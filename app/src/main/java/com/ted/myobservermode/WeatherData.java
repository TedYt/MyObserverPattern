package com.ted.myobservermode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2008 The Android Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Created by Ted.Yt on 9/28/16.
 *
 *
 * 具体的主题，实现了，主题接口的三个方法 和简单的数据维护
 */
public class WeatherData implements Subject {

    private float temperature;
    private float humidity;
    private float pressure;
    private List<Float> forecastTemperatures;

    private List<Observer> mObservers;

    public WeatherData() {
        this.mObservers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (mObservers.size() > 0){
            mObservers.remove(observer);
        }else {
            //
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : mObservers){
            observer.update();
        }
    }

    /**
     * 有变化时，发出通知
     */
    public void measurementsChanged(){
        notifyObserver();
    }

    /*下面的方法是次要方法，可以根据实际情况而定 */

    public void setMeasurements(float temperature, float humidity,
                                float pressure, List<Float> forecastTemperatures){

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.forecastTemperatures = forecastTemperatures;
        measurementsChanged();
    }

    public float getTemperature(){
        return temperature;
    }

    public float getHumidity(){
        return humidity;
    }

    public float getPressure(){
        return pressure;
    }

    public List<Float> getForecastTemperatures(){
        return forecastTemperatures;
    }
}
