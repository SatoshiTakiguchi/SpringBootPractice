package app.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
// import app.domain.entity.*;

// DB
import javax.transaction.Transactional;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.github.springtestdbunit.annotation.DatabaseSetup;

// @Transactional
// @Import(TestConfiguration.class)

@SpringBootTest(classes = ContactController.class)
@AutoConfigureMockMvc
class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;
    // @Autowired
    // private ObjectMapper objectMapper;
    
    @MockBean
    private ContactService contactService;

    @Test
    @DisplayName("問い合わせ追加画面に遷移すること")
    void testAdd() throws Exception {
        mockMvc.perform(get("/contacts"))
            .andExpect(status().isOk())
            .andExpect(view().name("Contact/new"));
    }

    @Test
    @DisplayName("問い合わせ追加で値が送信された場合、確認画面に遷移するること")
    void testPostAdd() throws Exception {
        ContactForm contact_form = new ContactForm(
            "test",
            "test@email",
            "content"
            );

        mockMvc.perform((post("/contacts/confirm"))
        .flashAttr("contact_form", contact_form)
        )
        .andExpect(status().isOk())
        .andExpect(model().hasNoErrors())
        // .andExpect(model().attribute("contact_form", contact_form))
        .andExpect(view().name("Contact/confirm"));
    }


    @Test
    @DisplayName("問い合わせ一覧画面に遷移すること")
    void testContacts() throws Exception {
        mockMvc.perform(get("/contacts/master"))
            .andExpect(status().isOk())
            .andExpect(view().name("Contact/master"));
    }

    
    @DatabaseSetup(value = "/combinedTestData/")
    @Test
    @ExpectedDatabase(value = "/contacts/new", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @DisplayName("DB保存")
    void testSave() throws Exception {
        ContactForm contact_form = new ContactForm(
            "test",
            "test@email",
            "content"
            );
        contactService.save(contact_form);
    }
    
}