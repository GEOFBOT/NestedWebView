/*
 * Copyright (C) 2015 takahirom
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geofbot.views.web;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Layout behavior for toolbars located at the bottom of the screen. When this
 * behavior is used, the bottom toolbar will show and hide when scrolling the
 * screen up (rather than when scrolling down which is the default behavior).
 */
public class BottomBarBehavior extends CoordinatorLayout.Behavior<LinearLayout> {

    private int defaultDependencyTop = -1;

    public BottomBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, LinearLayout child, View dependency) {
        return dependency instanceof AppBarLayout;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, LinearLayout child, View dependency) {
        if (defaultDependencyTop == -1) {
            defaultDependencyTop = dependency.getTop();
        }
        child.setTranslationY(-dependency.getTop() + defaultDependencyTop);
        return true;
    }

}