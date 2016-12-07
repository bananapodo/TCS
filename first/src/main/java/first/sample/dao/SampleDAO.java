package first.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
	}

//	@SuppressWarnings("unchecked")
//	public List<Map<String, Object>> selectBoardDetail(Map<String, Object> map) throws Exception{
//		return (List<Map<String, Object>>) selectList("sample.selectBoardDetail", map);
//	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardDetail(Map<String, Object> map) throws Exception{
	    return (List<Map<String, Object>>) selectList("sample.selectBoardDetail", map);
	}

	public void sendMail(Map<String, Object> map) throws Exception{
	    update("sample.sendMail", map);
	}


	
}
