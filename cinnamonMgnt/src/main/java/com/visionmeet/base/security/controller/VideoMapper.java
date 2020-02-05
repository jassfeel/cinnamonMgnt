package com.visionmeet.base.security.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.visionmeet.AbstractDAO;

@Repository("videoMapper")
public class VideoMapper extends AbstractDAO {
	
	private final Log logger = LogFactory.getLog(getClass());
 
	public List<Map<String, Object>> selectVideo(String user_id) {
		
		logger.info("selectVideo");
		
		return (List<Map<String, Object>>)selectList("videoMapper.selectVideo", user_id);
	}
	
	public List<Map<String, Object>> selectRoomHistory(String user_id) {
		
		logger.info("selectRoomHistory");

		return (List<Map<String, Object>>)selectList("videoMapper.selectRoomHistory", user_id);
	}
 
}

