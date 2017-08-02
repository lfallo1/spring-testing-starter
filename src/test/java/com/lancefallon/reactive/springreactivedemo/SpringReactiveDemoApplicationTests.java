package com.lancefallon.reactive.springreactivedemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringReactiveDemoApplicationTests {

    @Test
    public void testFlux() {

        Flux<String> myStrings = Flux.just("mango", "orange");
        myStrings.subscribe(s -> {
            Assert.assertEquals(String.class, s.getClass());
        });
    }

    @Test
    public void testMono() {
        Mono<String> upperMono = convertToUpperCase();
        upperMono.subscribe(System.out::println);
    }

    private Mono<String> convertToUpperCase() {
        Mono<String> mono = Mono.just("mango");
        return mono.map(String::toUpperCase);
    }

}
