package uk.co.benjiweber.expressions;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface ToString<T> {
    default String autoToString() {
        return "{" +
        props().stream()
            .map(prop -> (Object)prop.apply((T)this))
            .filter(prop -> prop != null)
            .map(Object::toString)
            .collect(Collectors.joining(", ")) +
        "}";
    }

    List<Function<T,?>> props();

}
