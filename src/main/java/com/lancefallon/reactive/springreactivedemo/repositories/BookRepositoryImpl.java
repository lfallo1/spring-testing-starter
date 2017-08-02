package com.lancefallon.reactive.springreactivedemo.repositories;

import com.lancefallon.reactive.springreactivedemo.models.Author;
import com.lancefallon.reactive.springreactivedemo.models.Book;
import com.lancefallon.reactive.springreactivedemo.repositories.interfaces.BookRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Date;
import java.util.*;

@Component
public class BookRepositoryImpl implements BookRepository {

    List<Book> books = new ArrayList<>();

    {
        Calendar dob = Calendar.getInstance();
        dob.set(1970, 1, 5);
        Author author1 = new Author("John Doe", "America", new Date(dob.getTimeInMillis()));
        dob.set(1978, 7, 15);
        Author author2 = new Author("Mark Smith", "England", new Date(dob.getTimeInMillis()));

        books.add(new Book(1, "325l24l4L5JH243", "My First Book", Arrays.asList(author1)));
        books.add(new Book(2, "42080NVN0808VGN", "My Second Book", Arrays.asList(author1, author2)));
        books.add(new Book(3, "V4N0RFC8RNCNM40", "My Third Book", Arrays.asList(author2)));
        books.add(new Book(4, "4NV0NC0M7NMC05N", "My Fourth Book", Arrays.asList(author2)));
        books.add(new Book(5, "1N9GJHBJD9J79DG", "My Fifth Book", Arrays.asList(author2)));
    }


    @Override
    public Mono<Book> findById(Integer id) {
        Optional<Book> book = this.books.stream().filter(b->b.getId().equals(id)).findFirst();
        return book.isPresent() ? Mono.justOrEmpty(book.get()) : Mono.empty();
    }

    @Override
    public Flux<Book> findAll() {
        return Flux.fromIterable(this.books);
    }
}
