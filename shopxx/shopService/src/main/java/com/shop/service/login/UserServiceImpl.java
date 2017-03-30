package com.shop.service.login;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Count;
import com.shop.entity.User;
import com.shop.mapper.login.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private @Resource UserMapper userMapper;

	/**
	 * 注册方法
	 */
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	/**
	 * 检查信息是否被注册
	 */
	@Override
	public User queryUser(String userName) {
		User queryUser = userMapper.queryUser(userName);
		return queryUser;
	}
	
	/**
	 * 重置密码
	 */
	@Override
	public void resetUser(User user) {
		userMapper.resetUser(user);
	}

	/**
	 * 查询一周的访问量
	 */
	@Override
	public List<Map<String, Object>> queryCount() {
		return userMapper.queryCount();
	}

	/**
	 * 查询最近一天的访问量
	 */
	@Override
	public Count queryOneDay() {
		return userMapper.queryOneDay();
	}

	/**
	 * 重新统计时新增
	 */
	@Override
	public void addCount(Count count) {
		userMapper.addCount(count);
	}

	/**
	 * 统计访问人数及时刷新
	 */
	@Override
	public void updateNumber(Map<String, Object> number) {
		userMapper.updateNumber(number);
	}
}
