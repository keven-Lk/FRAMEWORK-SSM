package com.db.sys.vo;

import java.io.Serializable;
import java.util.List;
/**
 * ��ִ�н�ɫ�޸Ĳ���ʱ,��Ҫ���ڽ�ɫid��ȡ��ɫ�Լ���ɫ��˵���Ӧ�Ĺ�ϵ����,
 * ����Ҫ�����ݽ��з�װ,�������Ƕ���������������һ��ֵ����
 * ˼��:
 * 1)Ϊʲô��ʹ��map�洢��ѯ����?
 * a)map��ֵ�������޷������޶�
 * b)map�洢����ʱ,�ɶ��Խϲ�
 * 2)Ϊʲô��ʹ��SysRole��װ����?
 * a)�˶���ΪPO����(Ҫ��������ֶ���ӳ���ϵ)
 * b)������Ҫʹ�ô����(�����ڴ�ӿ�)
 * @author Administrator
 *
 */
public class SysRoleMenuVo implements Serializable{
	private static final long serialVersionUID = 2497733607018956708L;
	/**��ɫ����*/
	private String name;
	/**��ɫ��ע*/
	private String note;
	/**��ɫ��Ӧ�Ĳ˵�id*/
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
