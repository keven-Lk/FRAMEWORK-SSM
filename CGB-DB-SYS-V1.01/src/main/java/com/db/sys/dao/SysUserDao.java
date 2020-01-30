package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.SysUserDeptVo;
import com.db.sys.entity.SysUser;

public interface SysUserDao {
	/**
	 * 基于id查询用户以及对应的部门消息
	 * @param id
	 * @return
	 */
	SysUserDeptVo findObjectById(Integer id);
	
	/**
	 * 负责将用户信息更新到数据库
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);
	/**
	 * 负责将用户信息写入到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);

	
	/**
	 * 执行用户禁用或启用操作
	 * @param id用户id
	 * @param valid表示状态(1,0)
	 * @param modifiedUser修改用户
	 * @return
	 */
	int validById(@Param("id")Integer id,
					@Param("valid")Integer valid, 
					@Param("modifiedUser")String modifiedUser);
	
	/**
	 * 依据条件查询当前页记录
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUserDeptVo> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 统计总记录数
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	

}
