package com.db.sys.service;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
/**
 * ��־ҵ��ӿ�
 * @author Administrator
 *
 */
public interface SysLogService {
	/**
	 * ����idɾ����־��Ϣ
	 * @param ids
	 * @return
	 */
	int deleteObjects(Integer...ids);
	/**
	 * ����������ѯ���������Ϣ,�����������з�װ
	 * @param username ��ѯ����
	 * @param pageCurrent ��ǰҳ��ֵ
	 * @return ��װ�˵�ǰҳ��¼�Լ���ҳ��Ϣ
	 */
	PageObject<SysLog> findPageObjects(String username,
			Integer pageCurrent);
}
