package org.java.mono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class MonoTest {

    @Test
    public void monoWithJust() {
        Mono.just(1)
                .log()
                .subscribe();
    }

    @Test
    public void monoWithRequestCancelAndSubscribe() {
        Mono.just(1)
                .log()
                .doOnRequest( i -> System.out.println("Requested "+i))
                .doOnSubscribe(i -> System.out.println("Subscribed "+i))
                .doOnSuccess(i -> System.out.println("Succeeded "+i))
                .subscribe();
    }

    @Test
    public void monoWithJustEmpty() {
        Mono.justOrEmpty(1)
                .log()
                .subscribe();
    }

    @Test
    public void monoWithJustEmptyOptional() {
        Mono.justOrEmpty(Optional.of(1))
                .log()
                .subscribe();
    }

    @Test
    public void monoWithDoOnError() {
        Mono.error(new RuntimeException("Error Occurred .."))
                .doOnError(System.out::println)
                .log()
                .subscribe();
    }

    @Test
    public void monoWithOnErrorReturn() {
        Mono.error(new RuntimeException("Error Occurred .."))
                .onErrorReturn(2)
                .log()
                .subscribe();
    }

    @Test
    public void monoWithOnErrorResume() {
        Mono.error(new Exception("Error Occurred .."))
                .onErrorResume(error -> Mono.just("AB"))
                .log()
                .subscribe();
    }

}
