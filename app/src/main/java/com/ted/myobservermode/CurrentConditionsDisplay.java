package com.ted.myobservermode;

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
 * 具体的观察者
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    //关心的主题，有变化时会立即发出通知
    private WeatherData mWeatherData;

    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(WeatherData mWeatherData) {
        this.mWeatherData = mWeatherData;
        this.mWeatherData.registerObserver(this);//向主题注册，表明自己关心该主题
    }

    @Override
    public void update() {
        this.temperature = this.mWeatherData.getTemperature();
        this.humidity = this.mWeatherData.getHumidity();
        this.pressure = this.mWeatherData.getPressure();
        display();
    }

    @Override
    public void display() {
        System.out.println("当前温度是：" + this.temperature);
        System.out.println("当前湿度：" + this.humidity);
        System.out.println("当前气压是：" + this.pressure);
    }
}
