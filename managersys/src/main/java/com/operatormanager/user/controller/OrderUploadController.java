package com.operatormanager.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.operatormanager.api.R;
import com.operatormanager.pagination.ResultPage;
import com.operatormanager.pagination.YCatPage;
import com.operatormanager.user.entity.OrderUpload;
import com.operatormanager.user.service.OrderUploadService;
import com.operatormanager.utils.ObjectTools;

@Controller
@RequestMapping("/api/OrderUpload")
public class OrderUploadController {
	
	 @Autowired
	 private OrderUploadService orderUploadService;
	 
	 @RequestMapping("saveOrUpdateOrder")
	 @ResponseBody
	public  R<?> saveOrUpdateOrder(OrderUpload orderUpload) {
		 orderUploadService.saveOrUpdate(orderUpload);
		 return R.ok("保存成功");
	 }
	 
	 
	 @RequestMapping("listPager")
	 @ResponseBody
	 public ResultPage  listPager(YCatPage<OrderUpload> page, String storeName, String platform,
				Long accountId, Long orderNo, Double payMoney, String customerName, Double commission,
				String startOperatingTime, String endOperatingTime) {
		 
		  orderUploadService.listPager(page, storeName, platform, accountId, orderNo, payMoney, customerName,
				 commission, ObjectTools.toString(startOperatingTime), ObjectTools.toString(endOperatingTime));
		   return R.ok(page);
	 }
	 
	 
}
