package com.operatormanager.user.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.operatormanager.pagination.YCatPage;
import com.operatormanager.user.entity.OrderUpload;
import com.operatormanager.user.mapper.OrderUploadMapper;
import com.operatormanager.user.service.OrderUploadService;
import com.operatormanager.utils.BaseService;

@Service
public class OrderUploadServiceImpl extends BaseService< OrderUploadMapper,  OrderUpload>  implements OrderUploadService {
	
	
	@Override
	@Transactional
	public void saveOrUpdateOrder(OrderUpload order) {
		// TODO Auto-generated method stub
		OrderUpload orderUpload1 = new OrderUpload();
		  if(ObjectUtils.isEmpty(order.getId())){
				orderUpload1.setAccountId(order.getAccountId());
				orderUpload1.setCommission(order.getCommission());
				orderUpload1.setCustomerName(order.getCustomerName());
				orderUpload1.setOperatingTime(order.getOperatingTime());
				orderUpload1.setStoreName(order.getStoreName());
				orderUpload1.setPayMoney(order.getPayMoney());
				orderUpload1.setOrderNo(order.getOrderNo());
				orderUpload1.setPlatform(order.getPlatform());
				super.save(orderUpload1);
		  }else{
			  OrderUpload orderUpload2 = baseMapper.selectById(order.getId());
			  orderUpload1.setId(orderUpload2.getId());
			  orderUpload1.setAccountId(orderUpload2.getAccountId());
			  super.updateById(orderUpload1);
		  }
	}

	@Override
	public YCatPage<OrderUpload> listPager(YCatPage<OrderUpload> page, String storeName, String platform,
			Long accountId, Long orderNo, Double payMoney, String customerName, Double commission,
			String startOperatingTime, String endOperatingTime) {
		// TODO Auto-generated method stub
		return baseMapper.listPager(page, storeName, platform, accountId,
				orderNo, payMoney, customerName, commission, startOperatingTime, endOperatingTime);
	}
  
	
	 
}
