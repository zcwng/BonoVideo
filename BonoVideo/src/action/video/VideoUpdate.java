/*    */ package action.video;
/*    */ 
/*    */ import bean.Video;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Date;
/*    */ import service.BaseService;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VideoUpdate
/*    */   extends ActionSupport
/*    */ {
/*    */   private int videoid;
/*    */   private String name;
/*    */   private String intro;
/*    */   private BaseService baseService;
/*    */   private Video video;
/*    */   
/* 41 */   public String getName() { return this.name; }
/*    */ 
/*    */   
/* 44 */   public void setName(String name) { this.name = name; }
/*    */ 
/*    */   
/* 47 */   public String getIntro() { return this.intro; }
/*    */ 
/*    */   
/* 50 */   public void setIntro(String intro) { this.intro = intro; }
/*    */ 
/*    */   
/* 53 */   public BaseService getBaseService() { return this.baseService; }
/*    */ 
/*    */   
/* 56 */   public void setBaseService(BaseService baseService) { this.baseService = baseService; }
/*    */ 
/*    */   
/* 59 */   public Video getVideo() { return this.video; }
/*    */ 
/*    */   
/* 62 */   public void setVideo(Video video) { this.video = video; }
/*    */ 
/*    */   
/* 65 */   public int getVideoid() { return this.videoid; }
/*    */ 
/*    */   
/* 68 */   public void setVideoid(int videoid) { this.videoid = videoid; }
/*    */   
/*    */   public String Read() {
/*    */     try {
/* 72 */       this.video = (Video)this.baseService.ReadByID("Video", this.videoid);
/* 73 */       return "success";
/*    */     }
/* 75 */     catch (Exception ex) {
/* 76 */       ex.printStackTrace();
/* 77 */       return "error";
/*    */     } 
/*    */   }
/*    */   public String Update() {
/*    */     try {
/* 82 */       this.video.setName(this.name);
/* 83 */       this.video.setIntro(this.intro);
/* 84 */       this.video.setEdittime(new Timestamp((new Date()).getTime()));
/* 85 */       this.baseService.update(this.video);
/* 86 */       return "success";
/*    */     }
/* 88 */     catch (Exception ex) {
/* 89 */       ex.printStackTrace();
/* 90 */       return "error";
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\JUSTOO\Desktop\classes\!\action\video\VideoUpdate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */