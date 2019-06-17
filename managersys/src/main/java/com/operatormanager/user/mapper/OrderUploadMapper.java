package com.operatormanager.user.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.operatormanager.mappers.SuperMapper;
import com.operatormanager.pagination.YCatPage;
import com.operatormanager.user.entity.OrderUpload;


public interface OrderUploadMapper extends SuperMapper<OrderUpload>{
	
	YCatPage<OrderUpload> listPager (@Param("page") YCatPage<OrderUpload> page,
            @Param("storeName") String storeName,
            @Param("platform") String platform,@Param("accountId") Long  accountId,
            @Param("orderNo") Long  orderNo,@Param("payMoney") Double  payMoney,
            @Param("customerName") String  customerName,@Param("commission") Double  commission,
            @Param("startOperatingTime") String  startOperatingTime,@Param("endOperatingTime") String  endOperatingTime);
	
}
