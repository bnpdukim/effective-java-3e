package study.effective.ch02.item02.hierarchy;

import lombok.ToString;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

@ToString
public abstract class Pizza {
    public enum Topping {
        HAM, HUSHROOM, ONION, PEPPER, SAUSAGE
    }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> { // 아이템 30
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // 아이템 50
    }
}
