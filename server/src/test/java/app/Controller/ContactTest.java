package app.Controller;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import app.controller.ContactController;
import app.domain.form.ContactForm;
import app.domain.service.ContactService;


@SpringBootTest(classes = ContactController.class)
@AutoConfigureMockMvc
class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;
    // @Autowired
    // private ObjectMapper objectMapper;
    
    @MockBean
    private ContactService contactsService;

    // @Test
    // @DisplayName("問い合わせ画面に遷移すること")
    // void testGetAdd() throws Exception {
    //     mockMvc.perform(get("/contacts"))
    //         .andExpect(status().isOk())
    //         .andExpect(view().name("Contact/new"));
    // }

    @Test
    @DisplayName("問い合わせ追加で正当な値が入力された場合、確認画面に遷移するること")
    void testPostAdd() throws Exception {
        ContactForm contact_form1 = new ContactForm("teswwt","test@email","content");
        ContactForm contact_form2 = new ContactForm("test3","test@email2","content2");

        mockMvc.perform((post("/contacts/confirm"))
        .flashAttr("contact_form", contact_form2)
        )
        .andExpect(status().isOk())
        .andExpect(model().hasNoErrors())
        .andExpect(model().attribute("contact_form", contact_form1))
        .andExpect(view().name("Contact/confirm"));
    }
    // @Test
    // @DisplayName("問い合わせ追加で正当な値が入力された場合、問い合わせの追加処理が呼び出され、問い合わせ一覧画面に遷移するること")
    // void testPostAdd() throws Exception {
    //     ContactForm contact_form = new ContactForm("test","test@email","content");

    //     mockMvc.perform((post("/contacts/new"))
    //     .flashAttr("contact_form", contact_form)
    //     )
    //     .andExpect(model().hasNoErrors())
    //     .andExpect(model().attribute("contact_form", contact_form))
    //     .andExpect(view().name("contact/master"));
    //     // Mockito.verify(contactsService, Mockito.times(1))
    //     //     .save(contact_form);
    // }
}