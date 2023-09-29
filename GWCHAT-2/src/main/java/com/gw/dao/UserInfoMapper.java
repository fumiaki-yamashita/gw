package com.gw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.servlet.ModelAndView;

import com.gw.dto.UserAddRequest;
import com.gw.dto.UserLoginRequest;
import com.gw.entity.UserInfo;

@Mapper
public interface UserInfoMapper {
	 /**
     * ユーザー情報登録
     * @param userAddRequest 登録用リクエストデータ
     */
    void save(UserAddRequest userAddRequest);

	public List<UserInfo> login(UserLoginRequest userLoginRequest);
}
