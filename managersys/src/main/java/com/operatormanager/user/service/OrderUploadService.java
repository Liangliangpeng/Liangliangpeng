package com.operatormanager.user.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.operatormanager.pagination.YCatPage;
import com.operatormanager.user.entity.OrderUpload;

public interface OrderUploadService extends IService<OrderUpload>{
	
	void saveOrUpdateOrder(OrderUpload order);
	
	YCatPage<OrderUpload> listPager ( YCatPage<OrderUpload> page,
             String storeName,String platform,Long  accountId,Long  orderNo,Double  payMoney,
             String  customerName, Double  commission, String  startOperatingTime, String  endOperatingTime);
}
