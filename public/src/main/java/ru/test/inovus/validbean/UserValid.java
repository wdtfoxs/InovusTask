package ru.test.inovus.validbean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserValid {

    @Size(min = 5, max = 20, message = "Имя пользователя должно быть больше 4-х символов")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Имя пользователя должно состоять из букв и цифр латинского языка")
    private String username;

    @Size(min = 8, max = 20, message = "Пароль должен состоять из минимум 8 символов")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$", message = "Пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы")
    private String password;

    @Size(min = 8, max = 20, message = "Пароль должен состоять из минимум 8 символов")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$", message = "Пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы")
    private String repassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
