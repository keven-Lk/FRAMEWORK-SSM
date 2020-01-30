package com.db.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.db.common.utils.PageUtil;
import com.db.common.vo.PageObject;
import com.db.sys.common.exception.ArgumentException;
import com.db.sys.common.exception.ServiceException;
import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
/**
 * ��־ҵ�����
 * 1)����ҵ��
 * 1.1)����У��
 * 1.2)ִ�����ݲ�ѯ(�ܼ�¼��,��ǰҳ��¼)
 * 1.3)������ҳ��
 * 1.4)�Բ�ѯ������з�װ(Ҳ���Է�װ��map,ֻ����������,�ɶ��Բ�)
 * 
 * 2)��չҵ��
 * 2.1)Ȩ�޿���
 * 2.2)���ݻ���
 * 2.3)�������
 * ......
 *
 */
@Service
public class SysLogServiceImpl implements SysLogService {
	//�����Ե�ֵ�����spring�е�DI���ƽ��и�ֵ
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public PageObject<SysLog> findPageObjects(String username, 
			Integer pageCurrent) {
		//1.�Բ�������У��
		if(pageCurrent == null || pageCurrent<1)
			throw new ServiceException("��ǰҳ��ֵ����ȷ");
		//2.�����û��������ܼ�¼��������У��
		int rowCount = sysLogDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("û���ҵ���Ӧ��¼");
		//3.����������ѯ��ǰҳ��¼List<SysLog>
		int pageSize = 3;
		int startIndex = (pageCurrent-1)*pageSize;
		List<SysLog> records = 
				sysLogDao.findPageObjects(username, startIndex, pageSize);
		//4.�Բ�ѯ������з�װ������
		PageObject<SysLog> po = PageUtil.newPageObeject(pageCurrent, rowCount, pageSize, records);
		return po; 
	}//�˷���д���Ժ�Ҫ���е�Ԫ����

	/**
	 * ָ���˷�����Ҫ������Ȩ����,���û���Ȩ���а�������ַ���"sys:log:delete"����Է��ʴ˷���
	 */
	@RequiresPermissions("sys:log:delete")
	@Transactional()//isolation = Isolation.READ_COMMITTED ��������ĸ��뼶��
	@Override
	public int deleteObjects(Integer... ids) {
		//1.��֤������Ч��
		if(ids == null||ids.length == 0)
			throw new ArgumentException("����ѡ��Ҫɾ���ļ�¼");
		//2.ִ��ɾ������
		int rows = sysLogDao.deleteObjects(ids);
		//3.�ж�ɾ�����������
		if(rows == 0) {
			throw new ServiceException("��¼�����Ѿ�������");
		}
		return rows;
	}



}
