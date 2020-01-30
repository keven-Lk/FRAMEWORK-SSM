package com.db.common.vo;

import java.io.Serializable;
import java.util.List;
/**
 * ͨ���˶����ҵ������ݷ�װ
 * @author Administrator
 *
 * @param <T>
 */
public class PageObject<T> implements Serializable{
	private static final long serialVersionUID = -6684637996265462804L;
	/*��ǰҳ��ҳ��ֵ*/
	private Integer pageCurrent = 1;
	/*ҳ���С*/
	private Integer pageSize = 3;
	/*������(ͨ����ѯ���)*/
	private Integer rowCount = 0;
	/*��ҳ��(ͨ�������n��)*/
	private Integer pageCount = 0;
	/*��ǰҳ��¼*/
	private List<T> records;
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> recorfs) {
		this.records = recorfs;
	}
	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", rowCount=" + rowCount
				+ ", pageCount=" + pageCount + ", records=" + records + "]";
	}
	
}
