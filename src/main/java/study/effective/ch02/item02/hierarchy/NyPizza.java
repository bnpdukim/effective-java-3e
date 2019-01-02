package study.effective.ch02.item02.hierarchy;

import lombok.ToString;

import java.util.Objects;

@ToString(callSuper = true)
public class NyPizza extends Pizza {
    public enum Size {
        SMALL, MEDIUM, LARGE
    }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
