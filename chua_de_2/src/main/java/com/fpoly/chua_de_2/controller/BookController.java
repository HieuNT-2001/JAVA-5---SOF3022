package com.fpoly.chua_de_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.chua_de_2.model.Book;
import com.fpoly.chua_de_2.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Hien thi form va danh sach
    @GetMapping
    public String showForm(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        model.addAttribute("title", "Book list");
        model.addAttribute("content", "book/home");
        return "layout/base";
    }

    // Them moi sach
    @PostMapping("/create")
    public String createBook(@ModelAttribute("Book") Book book, Model model) {
        bookService.createBook(book);
        return "redirect:/books";
    }

    // Xoa sach
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}
