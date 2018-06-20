package service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component("today")
public class Today {
	protected String getToday() {
		//�õ�long���͵�ǰʱ��
		long l = System.currentTimeMillis();
		//new���ڶ���
		Date date = new Date(l);
		//ת�������������ʽ
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today=dateFormat.format(date);
		return today;
	}
}
