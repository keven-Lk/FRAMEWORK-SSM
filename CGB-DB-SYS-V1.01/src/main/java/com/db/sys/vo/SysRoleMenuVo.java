package com.db.sys.vo;

import java.io.Serializable;
import java.util.List;
/**
 * 当执行角色修改操作时,需要基于角色id获取角色以及角色与菜单对应的关系数据,
 * 并需要对数据进行封装,所以我们定义了如下这样的一个值对象
 * 思考:
 * 1)为什么不使用map存储查询数据?
 * a)map中值的类型无法进行限定
 * b)map存储数据时,可读性较差
 * 2)为什么不使用SysRole封装数据?
 * a)此对象为PO对象(要求与表中字段有映射关系)
 * b)尽量不要使用大对象(类似于大接口)
 * @author Administrator
 *
 */
public class SysRoleMenuVo implements Serializable{
	private static final long serialVersionUID = 2497733607018956708L;
	/**角色名称*/
	private String name;
	/**角色备注*/
	private String note;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	@Override
	public String toString() {
		return "SysRoleMenuVo [name=" + name + ", note=" + note + ", menuIds=" + menuIds + "]";
	}
	
	

}
