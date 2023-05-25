package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {
    static class Library {
        private final Map<Book, Log> books_logs;

        void addBook(Book book) {
            this.books_logs.put(book, new Log());
        }

        void deleteBook(Book book) {
            this.books_logs.remove(book);
        }

        void addRecordToLog(Book book, DatePeriod datePeriod, String personName) {
            this.books_logs.get(book).add_new_record(personName, datePeriod);
        }

        Library() {
            this.books_logs = new HashMap<Book, Log>();
        }
    }

    @Component
    static class Book {
        String bookName;
        String authorName;

        Book(String bookName, String authorName) {
            this.authorName = authorName;
            this.bookName = bookName;
        }
    }

    @Component
    static class Log {
        private final Map<DatePeriod, String> book_history;

        void add_new_record(String person_name, DatePeriod period) {
            this.book_history.put(period, person_name);
        }

        Log() {
            this.book_history = new HashMap<DatePeriod, String>();
        }
    }

    @Component
    static class Date {
        int day;
        int month;
        int year;

        Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    @Component
    static class DatePeriod {
        Date startDate;
        Date endDate;

        DatePeriod(Date start, Date end) {
            this.startDate = start;
            this.endDate = end;
        }
    }


    public void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
