package action.dispatcher;

import bean.Video;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import service.BaseService;

public class Index extends ActionSupport {
	private List<Video> resultvideo;
	private List<Video> resultvideovod;
	private List<Video> resultvideolive;
	private BaseService baseService;

	public List<Video> getResultvideo() { return this.resultvideo; }



	public void setResultvideo(List<Video> resultvideo) { this.resultvideo = resultvideo; }



	public BaseService getBaseService() { return this.baseService; }



	public void setBaseService(BaseService baseService) { this.baseService = baseService; }



	public List<Video> getResultvideovod() { return this.resultvideovod; }



	public void setResultvideovod(List<Video> resultvideovod) { this.resultvideovod = resultvideovod; }



	public List<Video> getResultvideolive() { return this.resultvideolive; }



	public void setResultvideolive(List<Video> resultvideolive) { this.resultvideolive = resultvideolive; }



	public String execute() {
		try {
			int num, count = this.baseService.ReadCountByProperty("Video", "islive", Integer.valueOf(0));
			List<Video> allvideo = this.baseService.ReadByProperty("Video", "islive", Integer.valueOf(0));

			this.resultvideo = new ArrayList<Video>();


			if (count > 6) {
				num = 6;
			} else {
				num = count;
			} 
			for (int i = 0; i < num; i++) {

				int idx = (int)(Math.random() * count);
				if (idx < count) {
					Video video = allvideo.get(idx);
					this.resultvideo.add(video);
				} 
			} 

			this.resultvideolive = this.baseService.ReadByPropertyAndLimitedByOrder("Video", "islive", Integer.valueOf(1), "edittime", 4, "asc");
			this.resultvideovod = this.baseService.ReadByPropertyAndLimitedByOrder("Video", "islive", Integer.valueOf(0), "edittime", 4, "asc");

			return "success";
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		} 
	}
}


