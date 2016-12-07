package first.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.sample.dao.SampleDAO;
import first.sample.util.GmailSMTP;
import first.sample.controller.SampleController;

@Service("sampleService")
public class SampleServiceImpl implements SampleService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectBoardList(map);
		
	}
	@Override
	public List<Map<String, Object>> selectBoardDetail(Map<String, Object> map) throws Exception {

//	    Map<String, Object> resultMap = sampleDAO.selectBoardDetail(map);
//	    return resultMap;
	    return sampleDAO.selectBoardDetail(map);
	}

	@Override
	public void sendMail(Map<String, Object> map) throws Exception {
		

		
	    sampleDAO.sendMail(map);
	    
	}

}
