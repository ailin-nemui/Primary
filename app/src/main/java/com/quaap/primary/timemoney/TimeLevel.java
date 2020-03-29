package com.quaap.primary.timemoney;

import android.content.Context;

import com.quaap.primary.R;
import com.quaap.primary.base.StdLevel;
import com.quaap.primary.base.component.InputMode;

/**
 * Created by tom on 1/4/17.
 * <p>
 * Copyright (C) 2017  tom
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
public class TimeLevel extends StdLevel {

    public enum MinuteGranularity {
        Hour(R.string.min_gran_hour,  R.string.min_gran_hour_s),
        Half(R.string.min_gran_half, R.string.min_gran_half_s),
        Quarter(R.string.min_gran_quarter, R.string.min_gran_quarter_s),
        Five(R.string.min_gran_five, R.string.min_gran_five_s),
        One(R.string.min_gran_one, R.string.min_gran_one_s);

        private final int mResId;
        private final int mShortResId;
        MinuteGranularity(int resId, int shortResId) {
            mResId = resId;
            mShortResId = shortResId;
        }

        String getString(Context context) {
            return context.getString(mResId);
        }

        String getShortString(Context context) {
            return context.getString(mShortResId);
        }
    }
    //public enum SecondGranularity {Minute, Half, Quarter, Five, One}

    private final MinuteGranularity mMinuteGranularity;

    private final boolean mFuzzy;
    public TimeLevel(int subjectkey, MinuteGranularity minGran, int rounds, InputMode inputMode) {
        this(subjectkey, minGran, rounds, inputMode, false);
    }
    public TimeLevel(int subjectkey, MinuteGranularity minGran, int rounds, InputMode inputMode, boolean useFuzzy) {
        super(subjectkey, rounds, inputMode);
        mMinuteGranularity = minGran;
        mFuzzy = useFuzzy;
    }

    public boolean useFuzzy() {
        return mFuzzy;
    }

    public MinuteGranularity getMinuteGranularity() {
        return mMinuteGranularity;
    }

    @Override
    public String getDescription(Context context) {
        return mMinuteGranularity.getString(context) + ". "  + getInputModeString(context);
    }

    @Override
    public String getShortDescription(Context context) {
        return mMinuteGranularity.getShortString(context);
    }
}
