package yaddaSpace;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import yaddaSpace.core.entities.Entry;
import yaddaSpace.core.services.EntryService;
import yaddaSpace.rest.mvc.EntryController;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class EntryControllerTest {
    @InjectMocks
    private EntryController controller;

    @Mock
    private EntryService service;// mock will instantiate an object for the mocked object

    private MockMvc mockMvc;

    @Before
    public  void setup(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

//    @Test
//    public void test() throws Exception {
//
//        mockMvc.perform(post("/test")
//                .content("{\"title\":\"Test Blog Title\"}")
//                .contentType(MediaType.APPLICATION_JSON)
//        ).
//
//                andExpect(jsonPath("$.title",is("Test Blog Title"))) // tested expected result
//                .andDo(print()); //method chaining to build a request
//    }
    @Test
    public void getExistingBlogEntry() throws Exception{
        Entry entry = new Entry();
        entry.setId(1L);
        entry.setTitle("Test Title");
        when(service.find(1L)).thenReturn(entry);
        mockMvc.perform(get("/rest/blog-entries/1"))
                .andDo(print())
                .andExpect(jsonPath("$.title",is(entry.getTitle())))
                .andExpect(jsonPath("$.links[*].href",hasItem(endsWith("/blog-entries/1"))))
                .andExpect(status().isOk());

    }
    @Test
    public void getNonExistingBlogEntry() throws Exception{

        when(service.find(1L)).thenReturn(null);
        mockMvc.perform(get("/rest/blog-entries/1"))
                 .andExpect(status().isNotFound());

    }

}
