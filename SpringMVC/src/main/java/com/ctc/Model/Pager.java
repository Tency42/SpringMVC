package com.ctc.Model;

import java.util.List;

/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */
public class Pager<T> {
	private List<T> datas;
	private int offset;
	private int size;
	private long total;
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
