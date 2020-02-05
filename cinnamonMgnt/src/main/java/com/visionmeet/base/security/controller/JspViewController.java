package com.visionmeet.base.security.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.visionmeet.base.PasswordEncoding;
//import com.visionmeet.Video;
//import com.visionmeet.VideoMapper;
//import com.visionmeet.VideoService;
import com.visionmeet.base.security.Member;
import com.visionmeet.base.security.UserMapper;

import ch.qos.logback.classic.Logger;

@Controller
public class JspViewController {
    
	@Autowired
    UserMapper userMapper;
	
	@Autowired
	VideoService videoService;
	
    @RequestMapping("/")      
    public String home(Model model, Principal principal) {
    	
    	//String id = session.getAttribute("id") == null ? (String) session.getAttribute("id") : "";
		model.addAttribute("id", principal.getName());
		
        return "thymeleaf/openList";
    }
    
    @RequestMapping("/a")      
    public String a() {
        return "hello";          // 실제 호출될 /WEB-INF/jsp/viewtest.jsp        
    }
    
    @RequestMapping("/b")      
    public String b() {
        return "work";          // 실제 호출될 /WEB-INF/jsp/viewtest.jsp        
    }
    
    @RequestMapping("/index")      
    public String index() {
        return "thymeleaf/index";
    }
    
    @RequestMapping("/cards")      
    public String cards() {
        return "thymeleaf/cards";
    }
    
    @RequestMapping("/buttons")      
    public String buttons() {
        return "thymeleaf/buttons";
    }
    
    @RequestMapping("/charts")      
    public String charts() {
        return "thymeleaf/charts";
    }
    
    @RequestMapping("/tables")      
    public String tables() {
        return "thymeleaf/tables";
    }
    
    @RequestMapping("/tabb")      
    public String tabbles() {
        return "thymeleaf/tables";
    }
    
    @RequestMapping("/utilities-color")      
    public String utilitiesColor() {
        return "thymeleaf/utilities-color";
    }
    
    @RequestMapping("/utilities-border")      
    public String utilitiesBorder() {
        return "thymeleaf/utilities-border";
    }
    
    @RequestMapping("/utilities-animation")      
    public String utilitiesAnimation() {
        return "thymeleaf/utilities-animation";
    }
    
    @RequestMapping("/login")      
    public String login() {
        return "thymeleaf/login";
    }

    @RequestMapping("/register")      
    public String register() {
        return "thymeleaf/register";
    }
    
    @RequestMapping("/forgot-password")      
    public String forgotPassword() {
        return "thymeleaf/forgot-password";
    }

    @RequestMapping("/404")      
    public String p404() {
        return "thymeleaf/404";
    }
    
    @RequestMapping("/blank")      
    public String blank() {
        return "thymeleaf/blank";
    }
    
    /**
     * JSP 호출 테스트
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/visionmeet/getVideoList")
//    public Map<String, Object> getVideoList(ModelMap model) throws Exception{
//        
//    	Map<String, Object> resultMap = new HashMap<>();
//    	
//        resultMap.put("DATA1", 1111);
//        resultMap.put("DATA2", 2222);
//        
//        return resultMap;
//    }
    
    @ResponseBody
    @RequestMapping("/pw/{pw}")      
    public String pwEncode(Model model, Principal principal, @PathVariable("pw") String pw) {
    	
    	
    	PasswordEncoding passwordEncoding = new PasswordEncoding();

        String newPassword1 = passwordEncoding.encode(pw);

        System.out.println("newPassword1 : "+newPassword1);

        System.out.println("\nmatches : "+passwordEncoding.matches(pw,newPassword1));
        
        return newPassword1;
    }
    
    
    @RequestMapping("/openList")      
    public String openList(Model model, Principal principal) {
    	
    	model.addAttribute("id", principal.getName());
    	Member member = userMapper.readUser(principal.getName());
    	model.addAttribute("auth", member.getAuthorities());
    	
    	System.out.println("AUTH:" + member.getAuthorities());
    	
    	
    	PasswordEncoding passwordEncoding = new PasswordEncoding();

        String rawPassword1 = "12345678";
        String rawPassword2 = "12345678";
        String rawPassword3 = "1234";
        
        String newPassword1 = passwordEncoding.encode(rawPassword1);
        String newPassword2 = passwordEncoding.encode(rawPassword2);
        String newPassword3 = passwordEncoding.encode(rawPassword3);

        System.out.println("newPassword1 : "+newPassword1);
        System.out.println("newPassword2 : "+newPassword2);
        System.out.println("newPassword3 : "+newPassword3);

        System.out.println("\nmatches : "+passwordEncoding.matches(rawPassword1,newPassword1));
        System.out.println("matches : "+passwordEncoding.matches(rawPassword2,newPassword1));
        System.out.println("matches : "+passwordEncoding.matches(rawPassword3,newPassword3));
    	
    	
    	
    	
    	
    	
    	
    	
        return "thymeleaf/openList";
    }
        
    /**
     * 개설 영상리스트
     * @return
     */
    @ResponseBody
    @RequestMapping("/visionmeet/selectVideo")
    public Map<String, Object> selectVideo(@Param("user_id") String user_id, ModelMap model) throws Exception{    	
    	
    	Map<String, Object> resultMap = new HashMap<>();

    	try {
    		
    		List<Map<String, Object>> List = videoService.selectVideo(user_id);
    		
	    	resultMap.put("list", List);
	    	resultMap.put("result", true);
	    	
    	} catch (Exception e) {
    		System.out.println("## EXCEPTION MESSAGE : " + e.getMessage());
    		System.out.println("## PRINT STACK TRACE : " + e);
        }
    	
        return resultMap;
    	 
    }

    @RequestMapping("/roomHistory")      
    public String roomHistory(Model model, Principal principal) {
    	
    	model.addAttribute("id", principal.getName());
    	
        return "thymeleaf/roomHistory";
    }
    
    /**
     * 영상리스트 히스토리
     * @return
     */
    @ResponseBody
    @RequestMapping("/visionmeet/selectRoomHistory")
    public Map<String, Object> selectRoomHistory(@Param("user_id") String user_id, ModelMap model) throws Exception{    	
    	
    	Map<String, Object> resultMap = new HashMap<>();

    	try {
    		
    		List<Map<String, Object>> List = videoService.selectRoomHistory(user_id);
    		
	    	resultMap.put("list", List);
	    	resultMap.put("result", true);
	    	
    	} catch (Exception e) {
    		System.out.println("## EXCEPTION MESSAGE : " + e.getMessage());
    		System.out.println("## PRINT STACK TRACE : " + e);
        }
    	
        return resultMap;
    	 
    }
    
    /**
     * JSP 호출 테스트
     * @return
     */
//    @RequestMapping("/visionmeet/getVideoList")
//    public ModelAndView getVideoList() throws Exception{
//        ModelAndView mav = new ModelAndView("mavSample");
//        
//        mav.addObject("key", "fruits");
//        
//        List<String> fruitList = new ArrayList<String>();
//        
//        fruitList.add("asdasdasd");
//        fruitList.add("orange");
//        fruitList.add("banana");
//         
//        mav.addObject("value", fruitList);
//        
//        return mav;
//    }
    
    /**
     * 회원관리 리스트 출력함.
     * @param request
     * @param userBean
     * @param model
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/adminmgnt/getMemberMgntList")
//    public Map<String, Object> getMemberMgntList(HttpServletRequest request, Video bean, ModelMap model) {
//        
//        Map<String, Object> resultMap = new HashMap<>();
//        try {
//            
//            List<Video> List = VideoMapper
//            
//            resultMap.put("DATA", List);
//            
//            //resultMap.put(AJAX.RESULT, AJAX.OK);
//            
//        } catch (Exception e) {
//        	System.out.println("Exception" + e);
//        //    logger.error("## EXCEPTION MESSAGE : " + e.getMessage());
//        //    logger.error("## PRINT STACK TRACE : ", e);
//        }
//        
//        return resultMap;
//    }	

    	
    /**
     * JSP 호출 테스트
     * @return
     */
//    @RequestMapping("/mav")
//    public ModelAndView mav() throws Exception{
//        ModelAndView mav = new ModelAndView("mavSample");
//        
//        mav.addObject("key", "fruits");
//        
//        List<String> fruitList = new ArrayList<String>();
//        
//        fruitList.add("apple");
//        fruitList.add("orange");
//        fruitList.add("banana");
//         
//        mav.addObject("value", fruitList);
//        
//        return mav;
//    }
    
    /**
     * JSP 호출 테스트
     * @return
     */
    @RequestMapping("/welcome-jsp.do")

    public String welcome() {

    	
    	
        return "work";

    }


    @RequestMapping("/abcd3")
    public String abcd3() throws Exception {
        return "thymeleaf/NewFile";
    }
    
    /**
     * Thymeleaf 호출 테스트
     * @param model
     * @return
     * @throws Exception
     */
//    @RequestMapping("/abcd3")
//
//    public String welcome(Model model) throws Exception {
//
//        model.addAttribute("greeting", "Hello Thymeleaf!");
//
//        return "thymeleaf/welcome";
//
//    }



    	
//    @RequestMapping(value="/test")  // localhost/test
//    public String test() {
//        return "test/test2";        // 실제 호출될 /WEB-INF/jsp/test/viewtest2.jsp        
//    }

}