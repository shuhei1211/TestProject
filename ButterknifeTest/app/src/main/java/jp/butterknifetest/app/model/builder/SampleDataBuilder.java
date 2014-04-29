package jp.butterknifetest.app.model.builder;

import jp.butterknifetest.app.model.entity.SampleData;

public class SampleDataBuilder {
    private String mTitle;
    private int mNumber;

    public SampleDataBuilder setTitle(String title) {
        mTitle = title;
        return this;
    }

    public SampleDataBuilder setNumber(int number) {
        mNumber = number;
        return this;
    }

    public SampleData createSampleData() {
        return new SampleData(mTitle, mNumber);
    }
}