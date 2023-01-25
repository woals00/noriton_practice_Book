package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Member;
import com.example.demo.request.AuthorCreationRequest;
import com.example.demo.request.BookCreationRequest;
import com.example.demo.request.BookLendRequest;
import com.example.demo.request.MemberCreationRequest;
import com.example.demo.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

//    @GetMapping("/book")
//    public ResponseEntity readBooks(@RequestParam(required = false) String isbn){
//        if(isbn == null){
//            return ResponseEntity.ok(libraryService.readBooks());
//        }
//        return ResponseEntity.ok(libraryService.readBookByIsbn(isbn));
//    }


    @GetMapping("/book")
    public ResponseEntity readBooks(){
        System.out.println("###");
        return ResponseEntity.ok(libraryService.readBooks());
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> readBook(@PathVariable Long bookId){
        System.out.println("@@@@");
        return ResponseEntity.ok(libraryService.readBook(bookId));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody BookCreationRequest request){
        return ResponseEntity.ok(libraryService.createBook(request));
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId){
        libraryService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/member")
    public ResponseEntity<Member> createMember(@RequestBody MemberCreationRequest request){
        return ResponseEntity.ok(libraryService.createMember(request));
    }

    @PatchMapping("/member/{memberId}")
    public ResponseEntity<Member> updateMember(@RequestBody MemberCreationRequest request, @PathVariable Long memberId){
        return ResponseEntity.ok(libraryService.updateMember(memberId,request));
    }

//    @PostMapping("/book/lend")
//    public ResponseEntity<List<String>> lendBook(@RequestBody BookLendRequest bookLendRequests){
//        return ResponseEntity.ok(libraryService.lendABook(bookLendRequests));
//    }

    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorCreationRequest request){
        System.out.println("1");
        return ResponseEntity.ok(libraryService.createAuthor(request));
    }

}
