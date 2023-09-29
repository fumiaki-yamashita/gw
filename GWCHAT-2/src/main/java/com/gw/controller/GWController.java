package com.gw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gw.dto.UserAddRequest;
import com.gw.dto.UserLoginRequest;
import com.gw.entity.UserInfo;
import com.gw.service.UserInfoService;

@Controller
public class GWController {
	
    /**
     * ユーザー情報 Service
     */
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 初期表示(検索)画面に遷移する
     * @return 検索画面へのパス
     */
    @RequestMapping("/")
    public String index(Model model){
    	model.addAttribute("userLoginRequest", new UserLoginRequest());
        return "index";
    }
    
    /**
     * ユーザー新規登録画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
//    @GetMapping(value = "/signUp")
    @RequestMapping(value = "/signUp")
    public String signUpDisp(Model model) {
        model.addAttribute("userAddRequest", new UserAddRequest());
        return "signUp";
    }
    
    /**
     * チャットルーム画面を表示する
     * @return 検索画面へのパス
     */
    @RequestMapping("/chatRoom")
    public String chatRoomDisp(){
        return "chatRoom";
    }
    
    /**
     * ログイン
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Validated @ModelAttribute UserLoginRequest userLoginRequest, BindingResult result,Model model) {
        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "/";
        }
    	List<UserInfo> userInfoList = userInfoService.login(userLoginRequest);
    	model.addAttribute("userInfo", userInfoList);
        return "chatListDisp";
    }

    /**
     * ユーザー新規登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Validated @ModelAttribute UserAddRequest userAddRequest, BindingResult result,Model model) {
        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "signUp";
        }
        
    	userInfoService.save(userAddRequest);

        return "chatListDisp";
    }
    
    /**
     * チャット一覧画面を表示する
     * @return 検索画面へのパス
     */
    @RequestMapping(value = "/chatListDisp",method = RequestMethod.POST)
    public String chatListDis(UserAddRequest userAddRequest,Model model){
    	
    	//TODO チャットグループ表示用　サービス呼び出し
    	
    	model.addAttribute("userInfo", userAddRequest);
        return "chatListDisp";
    }
}
