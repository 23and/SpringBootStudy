package boot.board.schedule;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import boot.board.dto.ScheduleDto;
import boot.board.service.ScheduleService;

@EnableScheduling
@Component
public class ScheduledTest {
	
	@Autowired
	private ScheduleService scheduleService;
	
	ScheduleDto dto = new ScheduleDto();
	
	public static void main(String[] args) throws ParseException, IOException {
		ScheduledTest test = new ScheduledTest();
		test.ScheduledRun();
	}
	
	public String getTime(){	
	    Calendar date = Calendar.getInstance();
	    String time = date.get(Calendar.HOUR_OF_DAY)+ ":" + date.get(Calendar.MINUTE)+ ":" + date.get(Calendar.SECOND);
	    return "[" + time + "]";
	}
	
	@Scheduled(fixedRate = 600000)
	public void ScheduledRun() throws ParseException, IOException {
		String url = "http://apis.daum.net/search/web?output=json&apikey=3cce2aec6c242520fc731d69d88c29ba&q=클린";

		URL apiUrl = new URL(url);
		HttpURLConnection con = (HttpURLConnection)apiUrl.openConnection();
		Object json = JSONValue.parse(new InputStreamReader(con.getInputStream()));
		
		JSONParser paser = new JSONParser();
		JSONObject obj = (JSONObject) paser.parse(json.toString());
		JSONObject channel = (JSONObject) obj.get("channel");
		JSONArray item = (JSONArray) channel.get("item");

		StringBuilder builder = new StringBuilder();
		builder.append(getTime());
		
		for(int i = 0 ; i < item.size(); i ++){
			JSONObject imsi = (JSONObject) item.get(i);
			builder.append("[" + i + ":" + imsi.get("title") + "]");
		}

		dto.setTitle(builder.toString());
		scheduleService.insertTitle(dto);
	}
}
