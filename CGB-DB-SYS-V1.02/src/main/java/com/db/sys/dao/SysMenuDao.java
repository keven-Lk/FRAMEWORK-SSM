package com.db.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.Node;
import com.db.sys.entity.SysMenu;

public interface SysMenuDao {
	/**
	 * 基于菜单id获取权限标识
	 * @param menuIds
	 * @return
	 */

	List<String> findPermissions(
			@Param("menuIds")
			Integer[] menuIds);


	/**
	 * 查询所有菜单以及上级菜单(获取上级菜单名)相关信息
	 * 1)一行记录映射1个map
	 * 2)多行记录存储到list集合
	 * @return
	 */
	List<Map<String,Object>> findObjects();

	/**
	 * 统计当前菜单对应的子菜单
	 * @param id 为当前菜单的id
	 * @return
	 */
	int getChileCount(Integer id);

	/**
	 * 删除叶子节点元素
	 * 根据id删除菜单
	 * @param id 表示菜单id
	 * @return
	 */
	int deleteObject(Integer id);

	/**
	 * 查询菜单节点信息,最后要将此信息在客户端以树结构形式呈现
	 * @return
	 */
	List<Node> findZtreeMenuNodes();

	int insertObject(SysMenu entity);

	int updateObject(SysMenu entity);

	int deleteObjectsByRoleId(Integer roleId);
}
