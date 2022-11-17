package potato.manager.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.manager.domain.LineDomain;
import potato.manager.service.ManagerRestService;
import potato.manager.vo.SearchRestVO;

@Controller
public class ManagerRestareaController {
	@Autowired(required = false)
	private ManagerRestService mrs;
	
	
	@RequestMapping(value="manager_restarea.do",method=GET)
	public String restMain(SearchRestVO srVO, Model model, HttpSession session) {
		String url="manager/rest_management/jsp/manager_rest_management";
		/*
		 * ����ó���ϸ� �ּ�Ǯ��
		if(session.getAttribute("manager_id")==null) {
			url="forward:managerlogin_page.do";
		}
		*/
		
		List<LineDomain> list = mrs.searchLine();
		
		model.addAttribute("lineList", list );
		
		
		return url;
	}
	
	@RequestMapping(value="manager_writePopup.do", method=GET)
	public String openWriteRest(Model model) {
		
		return "manager/rest_management/jsp/manager_rest_write_popup";
	}
	
	@RequestMapping(value="manager_rest_add.do", method=GET)
	public String newRest(HttpServletRequest request) {
		
		return "manager/rest_management/jsp/manager_rest_write_popup";
	}
	
	@RequestMapping(value="manager_restdetailPopup.do",method=GET)
	public String restDetailPopup() {//�Ű������� int �ް��� �ε����� model�߰�
		
		return "manager/rest_management/jsp/rest_popup";
	}
	
	@RequestMapping(value="manager_rest_modifyPopup.do",method=GET)
	public String restModifyPopup() {//�Ű������� int �ް��� �ε����� model�߰�
		
		return "manager/rest_management/jsp/manager_rest_modify_popup";
	}
	
	@RequestMapping(value="manager_rest_modify.do")
	public String restModify(HttpServletRequest request) {
		
		return "manager/rest_management/jsp/manager_rest_modify_popup";
	}
	
	@RequestMapping(value="manager_removeRest.do",method=GET)
	public String delRest(int restarea_idx) {
		
		return "manager/rest_management/jsp/rest_popup";
	}

}
