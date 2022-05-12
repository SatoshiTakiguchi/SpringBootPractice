package app;

import app.domain.entity.Contact;
import app.domain.form.*;
import app.domain.service.ContactService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

// import reactor.core.publisher.Mono;

import static org.hamcrest.MatcherAssert.assertThat;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.web.reactive.function.BodyInserters.*;

import java.util.List;


@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@AutoConfigureMockMvc
@DatabaseSetup(value = "/ConbinedTestData/") // 初期状態のDB
@Transactional // メソッドの実行のたびにロールバックする
@Import(TestConfiguration.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "50000")
public class CombinedTest3<Quote> {

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private ContactService contactService;

    @Test
    void 結合テスト() {
        this.webClient.get().uri("/contacts").exchange().expectStatus().isOk();

        // 入れるデータ
        String name = "test";
        String email = "test@email";
        String content = "content";

        ContactForm contact_form = new ContactForm(
            name,
            email,
            content
        );

        webClient.post()
                .uri("/contacts/confirm")
                .bodyValue(contact_form)
                .exchange()
                .expectStatus()
                .isOk();

        assertThat(contact_form.getName(), is(name));
        assertThat(contact_form.getEmail(), is(email));
        assertThat(contact_form.getContent(), is(content));

        webClient.post()
            .uri("/contacts/new")
            .bodyValue(contact_form)
            .exchange()
            .expectStatus().isOk()
            .expectBody();
        
        // 登録後のDBの取得(件数が当初より1件増加)
        List<Contact> userListAfter = contactService.getAll();
        assertThat(userListAfter.size(), is(3));
    }
}