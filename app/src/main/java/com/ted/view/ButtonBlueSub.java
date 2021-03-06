package com.ted.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

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
 */
public class ButtonBlueSub extends Button implements Subject {

    private List<Observer> mObservers;

    public ButtonBlueSub(Context context) {
        super(context);
        mObservers = new ArrayList<Observer>();
    }

    public ButtonBlueSub(Context context, AttributeSet attrs) {
        super(context, attrs);
        mObservers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : mObservers){
            observer.update();
        }
    }

}
