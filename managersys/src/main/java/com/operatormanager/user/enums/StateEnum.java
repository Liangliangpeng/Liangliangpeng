package com.operatormanager.user.enums;

import javax.persistence.AttributeConverter;

import com.operatormanager.enums.BaseEnum;

public enum StateEnum implements BaseEnum {
	
	YES(1,"启用"),
	
	NO(2,"禁用");
	private int code;

	private String message;

	StateEnum(int code,String message){
		this.code=code;
		this.message=message;
	}

	@Override
	public Integer getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public static class Convert implements AttributeConverter<StateEnum, Integer> {

		@Override
		public Integer convertToDatabaseColumn(StateEnum attribute) {
			// TODO Auto-generated method stub
			return attribute==null ? null : attribute.getCode();
		}

		@Override
		public StateEnum convertToEntityAttribute(Integer dbData) {
			// TODO Auto-generated method stub
			if(null==dbData) {
				return null;
			}
			for(StateEnum pmDynamicTable : StateEnum.values()) {
				if(dbData.equals(pmDynamicTable.getCode())) {
					return pmDynamicTable;
				}
			} 
			return null;
		}
		
	}

	

}
