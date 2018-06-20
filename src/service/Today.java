package service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component("today")
public class Today {
	protected String getToday() {
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
		Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today=dateFormat.format(date);
		return today;
	}
}
