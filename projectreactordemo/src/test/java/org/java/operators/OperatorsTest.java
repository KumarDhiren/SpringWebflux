package org.java.operators;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

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

    @Test
    public void concat() throws InterruptedException {
        final Flux<Integer> first = Flux.range(1, 6)
                .delayElements(Duration.ofSeconds(1));
        final Flux<Integer> second = Flux.range(6, 5)
                .delayElements(Duration.ofSeconds(1));

        Flux.concat(first,second)
                .subscribe(System.out::println);

        Thread.sleep(12000);

    }

    @Test
    public void concatWith() throws InterruptedException {
        final Flux<Integer> first = Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1));
        final Flux<Integer> second = Flux.range(6, 5)
                .delayElements(Duration.ofSeconds(1));

        first.concatWith(second)
                .subscribe(System.out::println);

        Thread.sleep(12000);

    }

    @Test
    public void merge() throws InterruptedException {
        final Flux<Integer> first = Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1));
        final Flux<Integer> second = Flux.range(6, 5)
                .delayElements(Duration.ofSeconds(1));

        Flux.merge(first,second)
                .subscribe(System.out::println);

        Thread.sleep(6000);

    }

    @Test
    public void mergeWith() throws InterruptedException {
        final Flux<Integer> first = Flux.range(1, 6)
                .delayElements(Duration.ofSeconds(1));
        final Flux<Integer> second = Flux.range(6, 5)
                .delayElements(Duration.ofSeconds(1));

        first.mergeWith(second)
                .subscribe(System.out::println);

        Thread.sleep(6000);

    }

    @Test
    public void zip() throws InterruptedException {
        final Flux<Integer> first = Flux.range(1, 6)
                .delayElements(Duration.ofSeconds(1));
        final Flux<Integer> second = Flux.range(6, 5)
                .delayElements(Duration.ofSeconds(1));

        Flux.zip(first,second)
                .subscribe(System.out::println);

        Thread.sleep(6000);

    }

    @Test
    public void zipWith() throws InterruptedException {
        final Flux<Integer> first = Flux.range(1, 6)
                .delayElements(Duration.ofSeconds(1));
        final Flux<Integer> second = Flux.range(6, 5)
                .delayElements(Duration.ofSeconds(1));

        first.zipWith(second)
                .subscribe(System.out::println);

        Thread.sleep(6000);

    }

}
