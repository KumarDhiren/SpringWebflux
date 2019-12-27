package org.java.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FluxTest {

    @Test
    public void fluxWithJust() {
        Flux.just(1,2,3)
                .log()
                .subscribe();
    }

    @Test
    public void fluxWithIterable() {
        Flux.fromIterable(Arrays.asList(1,2,3,4))
                .log()
                .subscribe();
    }

    @Test
    public void fluxFromStream() {
        Flux.fromStream(Stream.of(1,2,3,4,5))
                .log()
                .subscribe();
    }

    @Test
    public void fluxFromStreamV2() {
        Flux.fromStream(Arrays.asList(1,2,3,4,5,6).stream())
                .log()
                .subscribe();
    }

    @Test
    public void fluxFromRange() {
        Flux.range(10,8)
                .log()
                .subscribe();

    }

    @Test
    public void fluxFromRangeWithRequest() {
        Flux.range(10,8)
                .log()
                .subscribe(null, null, null ,
                        req -> req.request(3));

    }

    @Test
    public void fluxFromRangeWithLimitRate() {
        Flux.range(10,8)
                .log()
                .limitRate(3)
                .subscribe();

    }

    @Test
    public void fluxFromInterval() throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .log()
                .subscribe();

        Thread.sleep(5000);
    }

    @Test
    public void fluxFromIntervalAndConsume2() throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .log()
                .take(2)
                .subscribe();

        Thread.sleep(5000);
    }

}
