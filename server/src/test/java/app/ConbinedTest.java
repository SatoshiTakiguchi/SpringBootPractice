package app;

import java.util.List;

import javax.transaction.Transactional;

import app.domain.entity.Contact;
import app.domain.form.ContactForm;
import app.domain.service.ContactService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@SpringBootTest
@AutoConfigureMockMvc
@DatabaseSetup(value = "/ConbinedTestData/") // 初期状態のDB
@Transactional // メソッドの実行のたびにロールバックする
@Import(TestConfiguration.class)
public class ConbinedTest {
    @Autowired
    private ContactService contactService;

    @Autowired
    private MockMvc mockMvc_controller;

    @Test
    @DisplayName("問い合わせ追加の一連処理")
    void ContactsAdditionFlow() throws Exception {

        // 問い合わせ画面遷移
        mockMvc_controller.perform(get("/contacts"))
            .andExpect(status().isOk())
            .andExpect(view().name("Contact/new"));

        // 問い合わせ情報のポスト
        ContactForm contact_form = new ContactForm(
            "test",
            "test@email",
            "content"
            );
        mockMvc_controller.perform((post("/contacts/confirm"))
            .flashAttr("contact_form", contact_form)
            )
            .andExpect(status().isOk())
            .andExpect(model().hasNoErrors())
            // .andExpect(model().attribute("contact_form", contact_form))
            .andExpect(view().name("Contact/confirm"));
        
        // 保存
        contactService.save(contact_form);

        // 正常にデータが増えているか
        List<Contact> userListAfter = contactService.getAll();
        assertThat(userListAfter.size(), is(3));

        // 問い合わせ一覧に遷移
        mockMvc_controller.perform(get("/contacts/master"))
            .andExpect(status().isOk())
            .andExpect(view().name("Contact/master"));

    }
}