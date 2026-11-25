package zey.library_managament.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import zey.library_managament.DTO.BookDTO;
import zey.library_managament.Service.IBookService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import zey.library_managament.Exception.ResourceNotFoundException;
class BookControllerTest {

    @Test
    void getBookByIdReturnsOkAndMatchingId() throws Exception {
        BookDTO book = new BookDTO();
        book.setId(5L);

        IBookService bookService = mock(IBookService.class);
        when(bookService.getBookById(5L)).thenReturn(book);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(
                new BookController(bookService)
        ).build();

        mockMvc.perform(get("/api/books/{id}", 5L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5));
    }

    @Test
    void getBookByIdReturnsNotFoundWhenBookDoesNotExist() throws Exception {
        IBookService bookService = mock(IBookService.class);
        when(bookService.getBookById(999999L))
                .thenThrow(new ResourceNotFoundException("Kitap bulunamadı: 999999"));

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(
                new BookController(bookService)
        ).build();

        mockMvc.perform(get("/api/books/{id}", 999999L))
                .andExpect(status().isNotFound());
    }
}