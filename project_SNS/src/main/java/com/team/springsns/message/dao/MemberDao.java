package com.team.springsns.message.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.team.springsns.model.MessageWriteInfo;

public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String mapperPath = "com.team.springsns.message.mapper.mybatis.MemberMapper";

	public int insertMessage(MessageWriteInfo messageWriteInfo) {
		return sqlSessionTemplate.update(mapperPath + ".insertMessage", messageWriteInfo);
	}

	public List<MessageWriteInfo> getMessage(MessageWriteInfo messageWriteInfo) {
		List<MessageWriteInfo> list = sqlSessionTemplate.selectList(mapperPath + ".recvMessage",
				messageWriteInfo.getRecvId());
		return list;
	}

	public MessageWriteInfo getCntMessage(MessageWriteInfo messageWriteInfo) {
		return sqlSessionTemplate.selectOne(mapperPath + ".cntMessage", messageWriteInfo.getRecvId());
	}

	public int changeCheckMessage(MessageWriteInfo messageWriteInfo) {
		return sqlSessionTemplate.update(mapperPath + ".changeCheckMessage", messageWriteInfo.getMessageNum());
	}

	public int MessageDelete(MessageWriteInfo messageWriteInfo) {
		return sqlSessionTemplate.delete(mapperPath + ".deleteMessage", messageWriteInfo.getMessageNum());
	}
}