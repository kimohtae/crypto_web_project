package com.ohtae.crypto.api;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ohtae.crypto.data.MemberInfoVO;
import com.ohtae.crypto.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginAPIContorller {
    @Autowired MemberService mService;

    @PostMapping("/login")
    public Map<String, Object> getLogin(@RequestBody MemberInfoVO data, HttpSession session)throws Exception{
        return mService.selectLoginInfo(data,session);
    }
}
