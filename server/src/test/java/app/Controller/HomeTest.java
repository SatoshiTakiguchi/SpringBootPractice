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
import app.controller.HelloController;


@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Hello World画面に遷移すること")
    void testGetAdd() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    // @Test
    // @DisplayName("プロフィールが0件の場合、Modelに0件のProfileFormのリストが設定され、プロフィール一覧画面に遷移するること")
    // void testGetListNoData() throws Exception {
    //     Mockito.when(profileService.getProfileList()).thenReturn(Collections.emptyList());
    //     MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/profile/list"))
    //         .andExpect(MockMvcResultMatchers.status().isOk())
    //         .andExpect(MockMvcResultMatchers.view().name("profile/list"))
    //         .andReturn();
    //     Map<String, Object> model = result.getModelAndView().getModel();
    //     Assertions.assertTrue(model.containsKey("profiles"));
    //     Assertions.assertNotNull(model.get("profiles"));
    //     Assertions.assertTrue(model.get("profiles") instanceof List<?>);
    //     List<ProfileForm> profileList = (List<ProfileForm>) model.get("profiles");
    //     Assertions.assertTrue(profileList.isEmpty());
    // }
    // @Test
    // @DisplayName("プロフィールが1件の場合、Modelに1件のProfileFormのリストが設定され、プロフィール一覧画面に遷移するること")
    // void testGetListOneData() throws Exception {
    //     Mockito.when(profileService.getProfileList())
    //             .thenReturn(Collections.singletonList(new ProfileDto(1L, "matsuki", LocalDate.of(1998, 1, 1))));
    //     try (MockedStatic<LocalDate> mockedLocalDate = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
    //         LocalDate nowDate = LocalDate.of(2020, 7, 31);
    //         mockedLocalDate.when(LocalDate::now).thenReturn(nowDate);
    //         MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/profile/list"))
    //             .andExpect(MockMvcResultMatchers.status().isOk())
    //             .andExpect(MockMvcResultMatchers.view().name("profile/list"))
    //             .andReturn();
    //         Map<String, Object> model = result.getModelAndView().getModel();
    //         Assertions.assertTrue(model.containsKey("profiles"));
    //         Assertions.assertNotNull(model.get("profiles"));
    //         Assertions.assertTrue(model.get("profiles") instanceof List<?>);
    //         List<ProfileForm> profileList = (List<ProfileForm>) model.get("profiles");
    //         Assertions.assertEquals(1, profileList.size());
    //         ProfileForm profileForm = profileList.get(0);
    //         Assertions.assertEquals("matsuki", profileForm.getName());
    //         Assertions.assertEquals(LocalDate.of(1998, 1, 1), profileForm.getBirthday());
    //         Assertions.assertEquals(22, profileForm.getAge());
    //     }
    // }
    
    // @Test
    // @DisplayName("プロフィール追加で正当な値が入力された場合、プロフィールの追加処理が呼び出され、プロフィール一覧画面に遷移するること")
    // void testPostAdd() throws Exception {
    //     mockMvc.perform(MockMvcRequestBuilders.post("/profile/add")
    //         .param("name", "penguin")
    //         .param("birthday", "1998-01-01"))
    //         .andExpect(MockMvcResultMatchers.status().isFound())
    //         .andExpect(MockMvcResultMatchers.view().name("redirect:/profile/list"));
    //     Mockito.verify(profileService, Mockito.times(1))
    //         .addProfile("penguin", LocalDate.of(1998, 1, 1));
    // }
    // @Test
    // @DisplayName("プロフィール追加で生年月日が未入力の場合、生年月日にエラーがバインドされ、プロフィール追加画面に遷移するること")
    // void testPostAddError() throws Exception {
    //     mockMvc.perform(MockMvcRequestBuilders.post("/profile/add")
    //         .param("name", "penguin")
    //         .param("birthday", ""))
    //         .andExpect(MockMvcResultMatchers.status().isOk())
    //         .andExpect(MockMvcResultMatchers.view().name("profile/add"))
    //         .andExpect(MockMvcResultMatchers.model().attributeHasErrors("profileForm"))
    //         .andExpect(MockMvcResultMatchers.model().errorCount(1))
    //         .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("profileForm", "birthday", "NotNull"));
    // }
}