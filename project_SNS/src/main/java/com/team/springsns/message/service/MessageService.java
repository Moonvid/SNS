package com.team.springsns.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.team.springsns.message.dao.MemberDao;
import com.team.springsns.model.MessageWriteInfo;

public class MessageService {

	@Autowired
	private MemberDao memberDao;

	public int goMessageTo(MessageWriteInfo messageWriteInfo) {
		return memberDao.insertMessage(messageWriteInfo);
	}

	public List<MessageWriteInfo> getMessage(MessageWriteInfo messageWriteInfo) {
		return memberDao.getMessage(messageWriteInfo);
	}

	public MessageWriteInfo getCntMessage(MessageWriteInfo messageWriteInfo) {
		MessageWriteInfo resultInfo = memberDao.getCntMessage(messageWriteInfo);
		if (resultInfo.getRecvId() == null) {
			resultInfo.setRecvId(messageWriteInfo.getRecvId());
			resultInfo.setCount(0);
		}
		return resultInfo;
	}

	public int changeCheckMessage(MessageWriteInfo messageWriteInfo) {
		return memberDao.changeCheckMessage(messageWriteInfo);
	}

	public int MessageDelete(MessageWriteInfo messageWriteInfo) {
		return memberDao.MessageDelete(messageWriteInfo);
	}

}