package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import potato.service.WriteService;
import potato.vo.WriteReviewImgVO;
import potato.vo.WriteReviewVO;

@Controller
public class WriteController {
	
	@Autowired(required = false)
	private WriteService ws;

	//리뷰작성완료
	@RequestMapping(value = "review_write.do", method={GET,POST})
	public String reviewWrite(HttpServletRequest request) {
		int restarea_idx=Integer.parseInt(request.getParameter("restarea_idx"));
		
		System.out.println("find me: "+request.getParameter("restarea_idx"));
		System.out.println("find me: "+request.getParameter("id"));
		System.out.println("find me: "+request.getParameter("rating"));
		System.out.println("find me: "+request.getParameter("contents"));
		System.out.println("find me: "+request.getParameter("imglen"));
		
		int len=Integer.parseInt(request.getParameter("imglen"));
		
		WriteReviewVO wrVO=new WriteReviewVO();
		wrVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
		wrVO.setId(request.getParameter("id"));
		wrVO.setRating(Integer.parseInt(request.getParameter("rating")));
		wrVO.setContents(request.getParameter("contents"));
		
		ws.setReview(wrVO);
		
		int reviewIdx=ws.searchNewIdx(restarea_idx);
		System.out.println("find me: "+reviewIdx);
		
		
		WriteReviewImgVO wriVO=new WriteReviewImgVO();
		
		if (len!=0) {
			for(int i=0; i<len; i++) {
				System.out.println("find me: "+request.getParameter("img-"+i));
				wriVO.setId(request.getParameter("id"));
				wriVO.setReview_idx(reviewIdx);
				wriVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
				wriVO.setImg_idx(i+1);
				wriVO.setImg(request.getParameter("img-"+i));
				ws.setReviewImg(wriVO);
			}
		}
		
		return "redirect:user_detailed.do?restarea_idx="+restarea_idx;
	}
	
	//이미지 업로드 구현 (비동기)
	@ResponseBody
	@RequestMapping(value = "ajax_img_upload.do", method= {GET,POST})
	public void enterLike(HttpServletRequest request) {
		File saveDir = new File("C:/Users/user/git/potato_mvc/potato_mvc/src/main/webapp/css/images/");
		int maxSize=1024*1024*20;
		try {
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//리뷰 수정 작성완료
	@RequestMapping(value = "re_review_write.do", method={GET,POST})
	public String reReviewWrite(HttpSession session, HttpServletRequest request, WriteReviewVO wrVO) {
		return "detailed/jsp/user_detailed";
	}
	
}
