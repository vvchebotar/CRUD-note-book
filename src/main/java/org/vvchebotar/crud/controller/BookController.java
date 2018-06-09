package org.vvchebotar.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vvchebotar.crud.domain.Book;
import org.vvchebotar.crud.service.GenericService;

import java.time.LocalDate;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private GenericService genericService;

    @RequestMapping("/all")
    public String list(Model model) {
        Book book = new Book();
        book.setAuthor("Author");
        book.setDescription("Description");
        book.setId(1L);
        book.setIsbn("123");
        book.setPrintYear(2000);
        book.setReadAlready(false);
        book.setTitle("Title");
        model.addAttribute("book", book);
        return "books";
    }

    @RequestMapping("/addBook")
    public String addBook(Model model) {
        Book book = new Book();
        book.setAuthor("Author2");
        book.setDescription("Description2");
        book.setId(2L);
        book.setIsbn("124");
        book.setPrintYear(2000);
        book.setReadAlready(false);
        book.setTitle("Title1");
        genericService.create(book);
        return "books";
    }

}
