package com.lancefallon.reactive.springreactivedemo;

import com.lancefallon.reactive.springreactivedemo.models.Book;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class ReactiveWebClientTest {

    public static void main(String[] args) {
        WebClient client = WebClient
                .create("http://localhost:8080");

        Flux<Book> response = client.get()
                .uri("/api/books/")
                .exchange()
                .block()
                .bodyToFlux(Book.class);

        response.subscribe(b -> System.out.println(b.toString()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("pause");
    }

}
