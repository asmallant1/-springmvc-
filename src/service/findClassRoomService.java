package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class findClassRoomService {
	@Autowired
	ClassRoomService cs;
	public Map<String,List<String>> findAllSelectTage() {
		List<String> listCname= cs.findClassName();
		List<String> listCno= cs.findClassNo();
		List<String> listCtype= cs.findClassType();
		List<String> listCsize= cs.findClassSize();
		List<String> listCaddress= cs.findClassAddress();
		List<String> listCinstitution= cs.findClassInstutition();
		
		Map<String,List<String>> map =new HashMap<>();
		
		map.put("listCname", listCname);
		map.put("listCno", listCno);
		map.put("listCtype", listCtype);
		map.put("listCsize", listCsize);
		map.put("listCaddress", listCaddress);
		map.put("listCinstitution", listCinstitution);
		
//		for( String e:map.get("listCname")) {
//			System.out.println(e);
//		}
		return map;
	}
}
