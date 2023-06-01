package com.example.NguyenDoTrungKien3A;

import com.example.NguyenDoTrungKien3A.entity.Book;
import com.example.NguyenDoTrungKien3A.services.BookService;
import com.example.NguyenDoTrungKien3A.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    /** categoryService; cho
     phép đối tượng implement (thực thi) CategoryService được tự động chèn vào thuộc
     tính categoryService của class hiện tại, để đối tượng này có thể được sử dụng
     trong các phương thức của class đó. Điều này giúp cho việc sử dụng
     CategoryService trở nên dễ dàng và tiện lợi hơn trong quá trình lập trình. **/
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "book/list";
    }
    /**Phương thức addBookForm() này trả về một trang HTML cho phép người
     dùng thêm mới một đối tượng Book vào cơ sở dữ liệu. **/
    @GetMapping("/add")
    public String addBookForm(Model model)
    {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }
    /** Phương thức addBook() này được sử dụng để xử lý dữ liệu đăng ký từ trang
     HTML "/add" được trả về bởi phương thức "addBookForm" trong câu hỏi trước đó. **/
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book editBook = bookService.getBookById(id);
        if (editBook != null) {
            model.addAttribute("book", editBook);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/edit";
        } else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book updateBook) {
        bookService.updateBook(updateBook);
        return "redirect:/books";
    }
    @GetMapping("/detele/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}