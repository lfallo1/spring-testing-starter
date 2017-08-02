package com.lancefallon.reactive.springreactivedemo.repositories.interfaces;

import com.lancefallon.reactive.springreactivedemo.models.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository {

    Mono<Book> findById(Integer id);
    Flux<Book> findAll();

}
