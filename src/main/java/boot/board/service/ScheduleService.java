package boot.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boot.board.dao.ScheduleDao;
import boot.board.dto.ScheduleDto;

@Service
@Transactional
public class ScheduleService {
	
	@Autowired
	private ScheduleDao scheduleDao;

	public boolean insertTitle(ScheduleDto dto){
		return scheduleDao.insertTitle(dto);
	}
}
