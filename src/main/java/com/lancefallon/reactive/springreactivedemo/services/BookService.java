package com.lancefallon.reactive.springreactivedemo.services;

import com.lancefallon.reactive.springreactivedemo.models.Author;
import com.lancefallon.reactive.springreactivedemo.models.Book;
import com.lancefallon.reactive.springreactivedemo.repositories.interfaces.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Date;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Mono<Book> getBookById(Integer id) {
        return this.bookRepository.findById(id);
    }

    public Flux<Book> getBooks() {
        //        return this.bookRepository.findAll();

        //dummy logic to return 15 book objects (creates one every 200ms and adds to reactive object
        Calendar dob = Calendar.getInstance();
        dob.set(1970, 1, 5);
        Author author1 = new Author("John Doe", "America", new Date(dob.getTimeInMillis()));
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> new Book(1, "325l24l4L5JH243", "My First Book", Arrays.asList(author1)))
                .take(15);
    }
}
