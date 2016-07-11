package boot.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import boot.board.domain.CommentBean;
import boot.board.service.CommentService;

@Controller
@RequestMapping("board/comment") 
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "writeComment", method = RequestMethod.POST)
	public String writeComment(CommentBean bean) {
		commentService.insertComment(bean);
		return "redirect:/board/readContent/"+bean.getBoardId();
	}
	
    @RequestMapping(value = "delete/{commentId}/{boardId}", method = RequestMethod.GET)
    public String delete(@PathVariable(value="commentId") int commentId, @PathVariable(value="boardId") int boardId, Model model) {
    	commentService.deleteCommentById(commentId);
    	return "redirect:/board/readContent/" + boardId;
    }
}
