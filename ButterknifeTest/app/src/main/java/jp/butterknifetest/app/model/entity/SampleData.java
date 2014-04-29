package jp.butterknifetest.app.model.entity;

public class SampleData {

    private String title;
    private int number;

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public SampleData() {
    }

    public SampleData(String title, int number) {
        this.title = title;
        this.number = number;
    }
}
