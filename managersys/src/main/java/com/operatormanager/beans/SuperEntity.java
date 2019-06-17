package com.operatormanager.beans;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;




@Data
@EqualsAndHashCode(callSuper = false)
public class SuperEntity<T extends Model<?>> extends Model<T> implements Serializable {

	private static final long serialVersionUID = 4022964216327114965L;
	
	@TableId(value = "id",type = IdType.ID_WORKER)//type = IdType.ID_WORKER
	protected Long id;


	@TableField( value = "time" , fill = FieldFill.INSERT)
	protected Date createDate =new Date();
	
		
	
}
