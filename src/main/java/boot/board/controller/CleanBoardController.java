package boot.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import boot.board.domain.CleanBoardBean;
import boot.board.dto.SearchDto;
import boot.board.service.CleanBoardService;
import boot.board.service.CommentService;

@Controller
@RequestMapping("board")
public class CleanBoardController {
	
	@Autowired
	private CleanBoardService cleanBoardService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("cleanBoardList", cleanBoardService.selectCleanBoardAll());
		return "redirect:/board/index/1";
	}
	
	@RequestMapping(value = "index/{page}", method = RequestMethod.GET)
	public String indexPage(@PathVariable(value="page") int page, Model model) {
		model.addAttribute("cleanBoardList", cleanBoardService.selectCleanBoardPage(page));
		model.addAttribute("pageCount", cleanBoardService.countCleanBoardAll());
		return "index";
	}
	/*
	@RequestMapping(value = "readContent/{id}", method = RequestMethod.GET)
	public String readContent(@Valid @NonNull @PathVariable(value="id") int id, Model model, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "errorForm";
		}else{
			model.addAttribute("bean", cleanBoardService.selectCleanBoardById(id));
			model.addAttribute("commentList", commentService.selectCommentAll(id));
			model.addAttribute("countNum", commentService.lastNum());
			return "readContent";
		}
	}
	*/
	@RequestMapping(value = "readContent/{id}", method = RequestMethod.GET)
	public String readContent(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("bean", cleanBoardService.selectCleanBoardById(id));
		model.addAttribute("commentList", commentService.selectCommentAll(id));
		model.addAttribute("countNum", commentService.lastNum());
		return "readContent";
	}

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write(Model model) {
		return "write";
	}
    
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(CleanBoardBean bean) {
    	cleanBoardService.insertCleanBoard(bean);
        return "redirect:/board/index";
    }

    @RequestMapping(value = "updateForm/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable(value="id") int id, Model model) {
    	model.addAttribute("bean", cleanBoardService.selectCleanBoardById(id));
    	return "updateForm";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(CleanBoardBean bean) {
    	cleanBoardService.updateCleanBoard(bean);
    	return "redirect:/board/index";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value="id") int id, Model model) {
    	cleanBoardService.deleteCleanBoardById(id);
    	return "redirect:/board/index";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(@RequestParam(value="scope") String scope,
    		@RequestParam(value="keyword") String keyword, Model model) {
    	model.addAttribute("cleanBoardList", cleanBoardService.searchCleanBoard(new SearchDto(scope, keyword)));
    	return "index";
    }
}
