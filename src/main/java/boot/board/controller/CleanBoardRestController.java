package boot.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import boot.board.domain.CleanBoardBean;
import boot.board.dto.SearchDto;
import boot.board.service.CleanBoardService;

@RestController
@RequestMapping("board/api") 
public class CleanBoardRestController {
	
	@Autowired
	private CleanBoardService cleanBoardService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	@ResponseBody public List<CleanBoardBean> index() {
		return cleanBoardService.selectCleanBoardAll();
	}
	
	@RequestMapping(value = "readContent/{id}", method = RequestMethod.GET)
	@ResponseBody public CleanBoardBean readContent(@PathVariable(value="id") int id) {
		return cleanBoardService.selectCleanBoardById(id);
	}
	
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody public List<CleanBoardBean> insert(@RequestBody CleanBoardBean bean) {
    	cleanBoardService.insertCleanBoard(bean);
        return cleanBoardService.selectCleanBoardAll();
    }
    
    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    @ResponseBody public CleanBoardBean update(@PathVariable(value="id") int id, @RequestBody CleanBoardBean bean) {
    	bean.setBoardId(id);
    	cleanBoardService.updateCleanBoard(bean);
    	return cleanBoardService.selectCleanBoardById(id);
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody public List<CleanBoardBean> delete(@PathVariable(value="id") int id) {
    	cleanBoardService.deleteCleanBoardById(id);  	
    	return cleanBoardService.selectCleanBoardAll();
    }
    
    @RequestMapping(value = "search/{scope}/{keyword}", method = RequestMethod.GET)
    @ResponseBody public List<CleanBoardBean> search(@PathVariable(value="scope") String scope,
    		@PathVariable(value="keyword") String keyword) {
    	return cleanBoardService.searchCleanBoard(new SearchDto(scope, keyword));
    }
}
