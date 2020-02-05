package com.visionmeet;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.visionmeet.base.security.controller.VideoService;

@Controller
public class JspController {
	
	@Autowired
	VideoService videoService;
	 
//	@RequestMapping(value="/sample/openSampleList.do")
//    public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception{
//    	ModelAndView mv = new ModelAndView("");
//    	
//    	return mv;
//    }
	
	
//	@RequestMapping("/tab")      
//    public String tables() {
//        return "thymeleaf/tables";
//    }
	
    /**
     * JSP 호출 테스트
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/visionmeet/getVideoList")
//    public String getVideoList(ModelMap model) throws Exception{
//        
//    	List<Map<String, Object>> resultMap = videoService.getVideoInfo();
//    	
//    	model.addAttribute("list", resultMap);
//    	
////        resultMap.put("DATA1", 1111);
////        resultMap.put("DATA2", 2222);
////        
////        return resultMap;
//    	 
//    	return "thymeleaf/openList";
//    	//return "asdasd";
//    }
    
}