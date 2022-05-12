package app.DB;

import java.util.List;

import javax.transaction.Transactional;

import app.CsvDataSetLoader;
import app.domain.entity.Contact;
import app.domain.service.ContactService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@SpringBootTest
@DatabaseSetup(value = "/testData/") // 初期状態のDB
@Transactional // メソッドの実行のたびにロールバックする
@Import(TestConfiguration.class)
public class DBSelectUnitTest {
    @Autowired
    private ContactService contactService;

    @Test
    @DisplayName("DB読み込み")
    public void contextLoads() throws Exception {
        List<Contact> userList = contactService.getAll();

        // 正常にテーブルからレコードを取得できたか
        assertThat(userList.size(), is(2));
    }
}