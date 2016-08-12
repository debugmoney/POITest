package com.king.app.test.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 类名称: TestAction <br>
 * 类描述: <br>
 *
 * @author: hua.jin
 * @since: 16/8/11 下午4:02
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/app/test")
public class TestAction {

    @RequestMapping("/hello")
    public ModelAndView test(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "hello word");
        mav.setViewName("test/hello");
        return mav;
    }
}
