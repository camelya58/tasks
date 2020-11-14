package paterns.builder;

import java.awt.*;

/**
 * Класс Button
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Button {
    private int wigth;
    private int height;
    private String text;
    private Color color;

    private Button(Builder builder) {
        this.wigth = builder.wigth;
        this.height = builder.height;
        this.text = builder.text;
        this.color = builder.color;
    }

    public static class Builder {
        private int wigth;
        private int height;
        private String text;
        private Color color;

        public Builder() {
        }

        public Builder width(int value) {
            wigth = value;
            return this;
        }

        public Builder height(int value) {
            height = value;
            return this;
        }

        public Builder text(String value) {
            text = value;
            return this;
        }

        public Builder color(Color value) {
            color = value;
            return this;
        }

        public Button build() {
            return new Button(this);
        }
    }

    @Override
    public String toString() {
        return "Button{" +
                "wigth=" + wigth +
                ", height=" + height +
                ", text='" + text + '\'' +
                ", color=" + color +
                '}';
    }
}
