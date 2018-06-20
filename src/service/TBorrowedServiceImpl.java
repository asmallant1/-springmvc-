package service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Tborrowed;
import repository.TBorrowedRepository;

@Service
public class TBorrowedServiceImpl implements TBorrowedService{
	@Autowired
	TBorrowedRepository tbr;
	@Override
	public List<Tborrowed> findTBorrowedByTeaId(String tno) {
		// TODO Auto-generated method stub
		return tbr.findTborrowedByTeaId( tno);
	}
	@Override
	public int saveTborrowed(String tno, String cno, String[] time, String text) {
		// TODO Auto-generated method stub
		try {
			return tbr.saveTborrowed(tno, cno, time, text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Tborrowed> findTBorrowedByClassId(String cno) {
		// TODO Auto-generated method stub
		return tbr.findTborrowedByClassId(cno);
	}
	@Override
	public List<Tborrowed> findTborrowdMoreThanToday(String cno,String tno) {
		// TODO Auto-generated method stub
		return tbr.findTborrowdMoreThanToday(cno,tno);
	}
	
}
