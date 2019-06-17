package com.operatormanager.pagination;

import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class YCatPage<T> extends Page<T> {
	
	private static final long serialVersionUID = 5194933845448697148L;
	
	protected Map<String, Object> params = Maps.newHashMap();
	
	protected long page ;
	
	public void addCondition(String key , Object value) {
		params.put(key, value);
	}

	public YCatPage(long current, long size) {
		super(current, size);
	}

	public YCatPage() {
		super(1, 10);
	}
	
	public void setPage(long page) {
		this.page=page;
		this.setCurrent(page) ;
	}
}