package app.domain.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Size;

@Data
public class ContactForm {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String content;

    // getter
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        public String getContent() {
            return content;
        }
    
    // setter
        public void setContent(String content) {
            this.content = content;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setName(String name) {
            this.name = name;
        }
}

