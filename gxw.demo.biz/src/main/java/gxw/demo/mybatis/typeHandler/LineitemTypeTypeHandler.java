/*
 * Copyright (C), 2014-2014, 联创车盟汽车服务有限公司
 * FileName: LineitemTypeTypeHandler.java
 * Author:   ZGF
 * Date:     2014年6月18日 下午6:39:30
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package gxw.demo.mybatis.typeHandler;

import gxw.demo.domain.LineitemType;
import ocean.data.mybatis.typeHandler.EnumCodeTypeHandler;



import org.apache.ibatis.type.MappedTypes;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ZGF
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@MappedTypes(LineitemType.class)
public class LineitemTypeTypeHandler extends EnumCodeTypeHandler<LineitemType> {

	public LineitemTypeTypeHandler() {
		super(LineitemType.class);
	}
}
