package com.operatormanager.user.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.operatormanager.beans.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@TableName(value = 	"order_upload")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpload  extends  SuperEntity<OrderUpload>{

	private static final long serialVersionUID = 4258260043801246060L;

	@TableField("platform")
	private String platform;						//平台
	
	@TableField("store_name")
	private String storeName;					//店铺名
	
	@TableField("account_id")
	private Long accountId;				    //账号id
	
	@TableField("order_no")
	private String orderNo;						//订单编号
	
	@TableField("pay_money")
	private Double payMoney;				//实付金额
	
	@TableField("customer_name")
	private String customerName;			//客服名字
	
	@TableField("commission")
	private Double commission;				//佣金
	
	@TableField("operating_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date operatingTime;				//操作时间
	
	
}
