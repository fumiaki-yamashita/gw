package com.gw.dto;

import java.io.Serializable;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserAddRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @NotEmpty(message = "ニックネームを入力してください")
    @Size(max = 100, message = "ユーザーIDは20桁以内で入力してください")
	private String nicname;
    @NotEmpty(message = "パスワードを入力してください")
    @Size(max = 100, message = "ユーザーIDは20桁以内で入力してください")
    private String password;
    @NotEmpty(message = "再パスワードを入力してください")
    @Size(max = 100, message = "ユーザーIDは20桁以内で入力してください")
    private String repassword;
    
    @AssertTrue(message = "パスワードと再パスワードは同一にしてください。")
    public boolean isPasswordValid() {
        if (password == null || password.isEmpty()) {
            return true;
        }
        return password.equals(repassword);
    } 
}
