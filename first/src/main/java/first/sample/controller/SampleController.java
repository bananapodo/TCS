package first.sample.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;

import first.sample.service.SampleService;
import first.common.common.CommandMap;
import first.sample.util.*;

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "sampleService")
	private SampleService sampleService;

	@RequestMapping(value = "/sample/openSampleBoardList.do")
	public ModelAndView openSampleBoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/boardList");

		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping(value = "/sample/openBoardDetail.do")
	public ModelAndView openBoardDetail(Map<String, Object> commandMap2, CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/boardDetail");

		List<Map<String, Object>> map = sampleService.selectBoardDetail(commandMap.getMap());
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap2);

		mv.addObject("list", list);
		mv.addObject("map", map);

		return mv;
	}

	@RequestMapping(value = "/sample/sendMailBox.do")
	public ModelAndView sendMail(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail.do");

		sampleService.sendMail(commandMap.getMap());

		String emailMsgTxt = "Gmail SMTP 서버를 사용한 JavaMail 테스트";
		String emailSubjectTxt = "Gmail SMTP 테스트";
		String emailFromAddress = "loboandzorra@gmail.com";
		String[] sendTo = { (String) commandMap.get("email_addr") };

		GmailSMTP.sendSSLMessage(sendTo, emailSubjectTxt, emailMsgTxt, emailFromAddress);

		mv.addObject("project_key", commandMap.get("project_key"));
		return mv;

	}

	@RequestMapping(value = "/sample/buttonClick.do")
	public ModelAndView buttonClick(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:openSampleBoardList.do");

		InfoDAO.insertProjectList();

		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("timer Task Start");
				FileParseJson.getData();
				// FTPUpLoader.FTPUpload();

			}
		};

		//
		Timer timer = new Timer();
		Calendar date = Calendar.getInstance();
		//
		timer.scheduleAtFixedRate(tt, date.getTime(), 5000);

		return mv;
	}

	@RequestMapping(value = "/sample/login.do")
	public ModelAndView loginForm(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/login");

		return mv;
	}
}
