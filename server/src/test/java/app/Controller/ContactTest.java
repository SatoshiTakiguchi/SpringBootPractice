package app.Controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import app.controller.ContactController;
import app.domain.service.ContactService;


@SpringBootTest
@AutoConfigureMockMvc
class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ContactService contactsService;

    @Test
    @DisplayName("問い合わせ画面に遷移すること")
    void testGetAdd() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/contacts"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("Contact/new"));
    }

    // @Test
    // @DisplayName("問い合わせ追加で正当な値が入力された場合、問い合わせの追加処理が呼び出され、問い合わせ一覧画面に遷移するること")
    // void testPostAdd() throws Exception {
    //     mockMvc.perform(MockMvcRequestBuilders.post("/contacts/new")
    //         .param("name", "penguin")
    //         .param("email", "1999@ssss")
    //         .param("content", "testcontent"))
    //         .andExpect(MockMvcResultMatchers.status().isFound())
    //         .andExpect(MockMvcResultMatchers.view().name("redirect:/contacts/list"));
    //     Mockito.verify(contactsService, Mockito.times(1))
    //         .addcontacts("penguin", LocalDate.of(1998, 1, 1));
    // }

    // @Test
    // @DisplayName("問い合わせが0件の場合、Modelに0件のcontactsFormのリストが設定され、問い合わせ一覧画面に遷移するること")
    // void testGetListNoData() throws Exception {
    //     Mockito.when(contactsService.getcontactsList()).thenReturn(Collections.emptyList());
    //     MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/contacts/list"))
    //         .andExpect(MockMvcResultMatchers.status().isOk())
    //         .andExpect(MockMvcResultMatchers.view().name("contacts/list"))
    //         .andReturn();
    //     Map<String, Object> model = result.getModelAndView().getModel();
    //     Assertions.assertTrue(model.containsKey("contactss"));
    //     Assertions.assertNotNull(model.get("contactss"));
    //     Assertions.assertTrue(model.get("contactss") instanceof List<?>);
    //     List<contactsForm> contactsList = (List<contactsForm>) model.get("contactss");
    //     Assertions.assertTrue(contactsList.isEmpty());
    // }
    // @Test
    // @DisplayName("問い合わせが1件の場合、Modelに1件のcontactsFormのリストが設定され、問い合わせ一覧画面に遷移するること")
    // void testGetListOneData() throws Exception {
    //     Mockito.when(contactsService.getcontactsList())
    //             .thenReturn(Collections.singletonList(new contactsDto(1L, "matsuki", LocalDate.of(1998, 1, 1))));
    //     try (MockedStatic<LocalDate> mockedLocalDate = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
    //         LocalDate nowDate = LocalDate.of(2020, 7, 31);
    //         mockedLocalDate.when(LocalDate::now).thenReturn(nowDate);
    //         MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/contacts/list"))
    //             .andExpect(MockMvcResultMatchers.status().isOk())
    //             .andExpect(MockMvcResultMatchers.view().name("contacts/list"))
    //             .andReturn();
    //         Map<String, Object> model = result.getModelAndView().getModel();
    //         Assertions.assertTrue(model.containsKey("contactss"));
    //         Assertions.assertNotNull(model.get("contactss"));
    //         Assertions.assertTrue(model.get("contactss") instanceof List<?>);
    //         List<contactsForm> contactsList = (List<contactsForm>) model.get("contactss");
    //         Assertions.assertEquals(1, contactsList.size());
    //         contactsForm contactsForm = contactsList.get(0);
    //         Assertions.assertEquals("matsuki", contactsForm.getName());
    //         Assertions.assertEquals(LocalDate.of(1998, 1, 1), contactsForm.getBirthday());
    //         Assertions.assertEquals(22, contactsForm.getAge());
    //     }
    // }
    
    
    // @Test
    // @DisplayName("問い合わせ追加で生年月日が未入力の場合、生年月日にエラーがバインドされ、問い合わせ追加画面に遷移するること")
    // void testPostAddError() throws Exception {
    //     mockMvc.perform(MockMvcRequestBuilders.post("/contacts/add")
    //         .param("name", "penguin")
    //         .param("birthday", ""))
    //         .andExpect(MockMvcResultMatchers.status().isOk())
    //         .andExpect(MockMvcResultMatchers.view().name("contacts/add"))
    //         .andExpect(MockMvcResultMatchers.model().attributeHasErrors("contactsForm"))
    //         .andExpect(MockMvcResultMatchers.model().errorCount(1))
    //         .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("contactsForm", "birthday", "NotNull"));
    // }
}