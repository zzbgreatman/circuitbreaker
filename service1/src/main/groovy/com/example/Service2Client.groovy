package com.example

import com.example.domain.Book
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Flowable

@Client(id = "service2")
@CircuitBreaker(delay = "5s", attempts = "3", multiplier = "3", reset = "300s")
interface Service2Client {
    @Get("/books")
    Flowable<ArrayList<Book>> findBooks();
}

@Fallback
class NoService2 implements Service2Client{

    @Override
    Flowable<ArrayList<Book>> findBooks() {
        System.out.print("Fallback!")
        return null;
    }
}