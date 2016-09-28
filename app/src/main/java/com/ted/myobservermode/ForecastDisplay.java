package com.ted.myobservermode;

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
 *
 * 另一个具体的观察者
 */
public class ForecastDisplay implements Observer,DisplayElement {

    private WeatherData mWeatherData;

    private List<Float> forestTemperatures;//未来几天的温度

    public ForecastDisplay(WeatherData mWeatherData) {
        this.mWeatherData = mWeatherData;
        this.mWeatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("未来几天的气温");
        int count = forestTemperatures.size();
        for (int i = 0; i < count; i ++){
            System.out.println("第" + i + "天：" + forestTemperatures.get(i) + "C");
        }
    }

    @Override
    public void update() {
        this.forestTemperatures = this.mWeatherData.getForecastTemperatures();
        display();
    }
}
