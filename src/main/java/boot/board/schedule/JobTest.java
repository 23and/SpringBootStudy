package boot.board.schedule;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobTest implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
	    Calendar date = Calendar.getInstance();
	    String stamp = date.get(Calendar.HOUR_OF_DAY)+ ":" + date.get(Calendar.MINUTE)+ ":" + date.get(Calendar.SECOND);
	    System.out.println("[" + stamp + "]");
	    
	    try{
			String url = "http://localhost:8080/board/api/index";
			URL postUrl = new URL(url);
			HttpURLConnection con = (HttpURLConnection)postUrl.openConnection();
			Object obj = JSONValue.parse(new InputStreamReader(con.getInputStream()));		
			JSONArray jsonArray = (JSONArray) obj;
			
			for(int i = 0; i < jsonArray.size(); i++){
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				System.out.println(jsonObject.get("title"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}