package org.java.operators;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class OperatorsTest {

    @Test
    public void map() {
        Flux.range(1,5)
            .map(i -> i * 10)
            .subscribe(System.out::println);
    }

    @Test
    public void flatMap() {
        Flux.range(1,5)
                .flatMap(i -> Flux.range(i * 10 , 3))
                .subscribe(System.out::println);
    }

}
