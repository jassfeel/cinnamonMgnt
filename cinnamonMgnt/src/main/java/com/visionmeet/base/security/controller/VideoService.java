package com.visionmeet.base.security.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService  {

	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	VideoMapper videoMapper;
	
    public List<Map<String, Object>> selectVideo(String user_id) {

    	List<Map<String, Object>> resultMap = videoMapper.selectVideo(user_id);
    	logger.info("selectVideo:" + resultMap);
    	
    	return resultMap;
    }

    public List<Map<String, Object>> selectRoomHistory(String user_id) {

    	List<Map<String, Object>> resultMap = videoMapper.selectRoomHistory(user_id);
    	logger.info("selectRoomHistory:" + resultMap);
    	return resultMap;
    }
    
 
}

