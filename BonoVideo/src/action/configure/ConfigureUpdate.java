package action.configure;

import bean.Configure;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import service.BaseService;
























public class ConfigureUpdate
extends ActionSupport
{
	private String transcoder_vcodec;
	private String transcoder_bv;
	private String transcoder_framerate;
	private String transcoder_acodec;
	private String transcoder_ar;
	private String transcoder_ba;
	private String transcoder_scale_w;
	private String transcoder_scale_h;
	private String transcoder_watermarkuse;
	private String transcoder_watermark_url;
	private String transcoder_watermark_x;
	private String transcoder_watermark_y;
	private String transcoder_keepaspectratio;
	private String transcoder_outfmt;
	private String thumbnail_ss;
	private String folder_videoori;
	private String folder_video;
	private String folder_thumbnail;
	private List<Configure> configurelist;
	private BaseService baseService;

	public String getTranscoder_vcodec() { return this.transcoder_vcodec; }


	public void setTranscoder_vcodec(String transcoder_vcodec) { this.transcoder_vcodec = transcoder_vcodec; }


	public String getTranscoder_bv() { return this.transcoder_bv; }


	public void setTranscoder_bv(String transcoder_bv) { this.transcoder_bv = transcoder_bv; }


	public String getTranscoder_framerate() { return this.transcoder_framerate; }


	public void setTranscoder_framerate(String transcoder_framerate) { this.transcoder_framerate = transcoder_framerate; }


	public String getTranscoder_acodec() { return this.transcoder_acodec; }


	public void setTranscoder_acodec(String transcoder_acodec) { this.transcoder_acodec = transcoder_acodec; }


	public String getTranscoder_ar() { return this.transcoder_ar; }


	public void setTranscoder_ar(String transcoder_ar) { this.transcoder_ar = transcoder_ar; }


	public String getTranscoder_ba() { return this.transcoder_ba; }


	public void setTranscoder_ba(String transcoder_ba) { this.transcoder_ba = transcoder_ba; }


	public String getTranscoder_scale_w() { return this.transcoder_scale_w; }


	public void setTranscoder_scale_w(String transcoder_scale_w) { this.transcoder_scale_w = transcoder_scale_w; }


	public String getTranscoder_scale_h() { return this.transcoder_scale_h; }


	public void setTranscoder_scale_h(String transcoder_scale_h) { this.transcoder_scale_h = transcoder_scale_h; }


	public String getTranscoder_watermarkuse() { return this.transcoder_watermarkuse; }


	public void setTranscoder_watermarkuse(String transcoder_watermarkuse) { this.transcoder_watermarkuse = transcoder_watermarkuse; }


	public String getTranscoder_watermark_url() { return this.transcoder_watermark_url; }


	public void setTranscoder_watermark_url(String transcoder_watermark_url) { this.transcoder_watermark_url = transcoder_watermark_url; }


	public String getTranscoder_watermark_x() { return this.transcoder_watermark_x; }


	public void setTranscoder_watermark_x(String transcoder_watermark_x) { this.transcoder_watermark_x = transcoder_watermark_x; }


	public String getTranscoder_watermark_y() { return this.transcoder_watermark_y; }


	public void setTranscoder_watermark_y(String transcoder_watermark_y) { this.transcoder_watermark_y = transcoder_watermark_y; }


	public String getTranscoder_keepaspectratio() { return this.transcoder_keepaspectratio; }


	public void setTranscoder_keepaspectratio(String transcoder_keepaspectratio) { this.transcoder_keepaspectratio = transcoder_keepaspectratio; }


	public String getTranscoder_outfmt() { return this.transcoder_outfmt; }


	public void setTranscoder_outfmt(String transcoder_outfmt) { this.transcoder_outfmt = transcoder_outfmt; }


	public String getThumbnail_ss() { return this.thumbnail_ss; }


	public void setThumbnail_ss(String thumbnail_ss) { this.thumbnail_ss = thumbnail_ss; }


	public List<Configure> getConfigurelist() { return this.configurelist; }


	public void setConfigurelist(List<Configure> configurelist) { this.configurelist = configurelist; }


	public BaseService getBaseService() { return this.baseService; }


	public void setBaseService(BaseService baseService) { this.baseService = baseService; }


	public String getFolder_videoori() { return this.folder_videoori; }


	public void setFolder_videoori(String folder_videoori) { this.folder_videoori = folder_videoori; }


	public String getFolder_video() { return this.folder_video; }


	public void setFolder_video(String folder_video) { this.folder_video = folder_video; }


	public String getFolder_thumbnail() { return this.folder_thumbnail; }


	public void setFolder_thumbnail(String folder_thumbnail) { this.folder_thumbnail = folder_thumbnail; }

	public String Read() {
		try {
			this.configurelist = this.baseService.ReadAll("Configure");
			for (Configure configure : this.configurelist) {
				if (configure.getName().equals("transcoder_vcodec")) {
					this.transcoder_vcodec = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_bv")) {
					this.transcoder_bv = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_framerate")) {
					this.transcoder_framerate = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_acodec")) {
					this.transcoder_acodec = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_ar")) {
					this.transcoder_ar = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_ba")) {
					this.transcoder_ba = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_scale_w")) {
					this.transcoder_scale_w = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_scale_h")) {
					this.transcoder_scale_h = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_watermarkuse")) {
					this.transcoder_watermarkuse = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_watermark_url")) {
					this.transcoder_watermark_url = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_watermark_x")) {
					this.transcoder_watermark_x = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_watermark_y")) {
					this.transcoder_watermark_y = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_keepaspectratio")) {
					this.transcoder_keepaspectratio = configure.getVal(); continue;
				}  if (configure.getName().equals("transcoder_outfmt")) {
					this.transcoder_outfmt = configure.getVal(); continue;
				}  if (configure.getName().equals("thumbnail_ss")) {
					this.thumbnail_ss = configure.getVal(); continue;
				}  if (configure.getName().equals("folder_videoori")) {
					this.folder_videoori = configure.getVal(); continue;
				}  if (configure.getName().equals("folder_video")) {
					this.folder_video = configure.getVal(); continue;
				}  if (configure.getName().equals("folder_thumbnail")) {
					this.folder_thumbnail = configure.getVal();
				}
			} 
			return "success";
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		} 
	}
	public String Update() {
		try {
			for (Configure configure : this.configurelist) {
				if (configure.getName().equals("transcoder_vcodec")) {
					configure.setVal(this.transcoder_vcodec);
				} else if (configure.getName().equals("transcoder_bv")) {
					configure.setVal(this.transcoder_bv);
				} else if (configure.getName().equals("transcoder_framerate")) {
					configure.setVal(this.transcoder_framerate);
				} else if (configure.getName().equals("transcoder_acodec")) {
					configure.setVal(this.transcoder_acodec);
				} else if (configure.getName().equals("transcoder_ar")) {
					configure.setVal(this.transcoder_ar);
				} else if (configure.getName().equals("transcoder_ba")) {
					configure.setVal(this.transcoder_ba);
				} else if (configure.getName().equals("transcoder_scale_w")) {
					configure.setVal(this.transcoder_scale_w);
				} else if (configure.getName().equals("transcoder_scale_h")) {
					configure.setVal(this.transcoder_scale_h);
				} else if (configure.getName().equals("transcoder_watermarkuse")) {
					configure.setVal(this.transcoder_watermarkuse);
				} else if (configure.getName().equals("transcoder_watermark_url")) {
					configure.setVal(this.transcoder_watermark_url);
				} else if (configure.getName().equals("transcoder_watermark_x")) {
					configure.setVal(this.transcoder_watermark_x);
				} else if (configure.getName().equals("transcoder_watermark_y")) {
					configure.setVal(this.transcoder_watermark_y);
				} else if (configure.getName().equals("transcoder_keepaspectratio")) {
					configure.setVal(this.transcoder_keepaspectratio);
				} else if (configure.getName().equals("transcoder_outfmt")) {
					configure.setVal(this.transcoder_outfmt);
				} else if (configure.getName().equals("thumbnail_ss")) {
					configure.setVal(this.thumbnail_ss);
				} else if (configure.getName().equals("folder_videoori")) {

					String str = this.folder_videoori;
					int strlenth = str.length();

					if (str.charAt(strlenth - 1) == '/') {
						str = str.substring(0, strlenth - 1);
					}

					if (str.charAt(0) == '/') {
						str = str.substring(1);
					}
					configure.setVal(str);
				} else if (configure.getName().equals("folder_video")) {

					String str = this.folder_video;
					int strlenth = str.length();
					if (str.charAt(strlenth - 1) == '/') {
						str = str.substring(0, strlenth - 1);
					}
					if (str.charAt(0) == '/') {
						str = str.substring(1);
					}
					configure.setVal(str);
				} else if (configure.getName().equals("folder_thumbnail")) {

					String str = this.folder_thumbnail;
					int strlenth = str.length();
					if (str.charAt(strlenth - 1) == '/') {
						str = str.substring(0, strlenth - 1);
					}
					if (str.charAt(0) == '/') {
						str = str.substring(1);
					}
					configure.setVal(str);
				} 
				this.baseService.update(configure);
			} 
			return "success";
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		} 
	}
}


