package com.ted.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

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
public class ButtonRedOb extends Button implements Observer {

    //private Subject mSubject;

    public ButtonRedOb(Context context) {
        super(context);
    }

    public ButtonRedOb(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 初始化，
     * 向主题注册自己，自己关心改主题
     * @param subject
     */
    public void init(Subject subject){
        //mSubject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        setBackgroundColor(Color.rgb(14,234,156));
    }
}
