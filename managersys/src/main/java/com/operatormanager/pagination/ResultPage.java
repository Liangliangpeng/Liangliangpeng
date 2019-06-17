package com.operatormanager.pagination;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

import com.operatormanager.utils.ObjectTools;



@Data
@EqualsAndHashCode(callSuper=false) 
public class ResultPage implements Serializable{

	private static final long serialVersionUID = 2930541671078186437L;
	
	protected int code = 0 ;

    private int page = 1;

	private int pageSize = 10;
	
	private long total;//总条数

	private int totalPages;//总页数

	private int prevPage;//上一页
	private int nextPage;//下一页
	
	private List<?> rows ;
	private List<?> data ;

	public static ResultPage getResultPage(YCatPage<?> page,List<?> list){
		ResultPage resultPage = new ResultPage();
		resultPage.setCode( 0 );
		resultPage.setPageSize(ObjectTools.toInt(page.getSize()));
		resultPage.setPage(ObjectTools.toInt(page.getCurrent()));
		resultPage.setTotalPages(ObjectTools.toInt(page.getPages()));
		resultPage.setTotal(page.getTotal() );
		resultPage.setRows(list);
		resultPage.setPrevPage (resultPage.getPage() > 1 ? resultPage.getPage() - 1 : 1) ;
		resultPage.setNextPage (resultPage.getPage() < resultPage.getTotalPages() ? resultPage.getPage() + 1 : resultPage.getTotalPages());
		return resultPage;
	}
	
	
}
