package service;

import java.util.List;
import model.Tborrowed;

public interface TBorrowedService {
		List<Tborrowed> findTBorrowedByClassId(String tno);
		int saveTborrowed(String tno,String cno,String[] time,String text);
		List<Tborrowed> findTBorrowedByTeaId(String tno);
		List<Tborrowed> findTborrowdMoreThanToday(String cno,String tno);
}
