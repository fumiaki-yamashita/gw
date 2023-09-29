package com.gw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gw.dao.UserInfoMapper;
import com.gw.dto.UserAddRequest;
import com.gw.dto.UserLoginRequest;
import com.gw.entity.UserInfo;

@Service
public class UserInfoService {

	 /**
     * ユーザー情報 サービス
     */
    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * ユーザ情報登録サービス
     * @param userAddRequest リクエストデータ
     */
    public void save(UserAddRequest userAddRequest) {
        userInfoMapper.save(userAddRequest);
    }
    /**
     * ログインサービス
     * @param userAddRequest リクエストデータ
     * @return 
     */
    public List<UserInfo> login(UserLoginRequest userLoginRequest) {
    	
   	
		return userInfoMapper.login(userLoginRequest);
    }
}
