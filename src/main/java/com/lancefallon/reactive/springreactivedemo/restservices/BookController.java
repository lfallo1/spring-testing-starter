package com.lancefallon.reactive.springreactivedemo.restservices;

import com.lancefallon.reactive.springreactivedemo.models.Book;
import com.lancefallon.reactive.springreactivedemo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Book>> getById(@PathVariable Integer id) {
        Mono<Book> book = this.bookService.getBookById(id);
        return new ResponseEntity<Mono<Book>>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Flux<Book>> findAll() {
        return new ResponseEntity<Flux<Book>>(this.bookService.getBooks(), HttpStatus.OK);
    }

}
