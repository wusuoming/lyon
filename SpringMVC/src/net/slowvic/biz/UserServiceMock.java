package net.slowvic.biz;

import net.slowvic.model.bo.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserServiceMock implements UserService {

	private static Log log = LogFactory.getLog(UserService.class);

	@Override
	public void saveUser(User user) {
		if (log.isDebugEnabled())
			log.debug("成功保存User");
	}
}
