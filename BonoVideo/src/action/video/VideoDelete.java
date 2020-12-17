/*    */ package action.video;
/*    */ 
/*    */ import bean.Video;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.io.File;
/*    */ import org.apache.struts2.ServletActionContext;
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
/*    */ 
/*    */ 
/*    */ public class VideoDelete
/*    */   extends ActionSupport
/*    */ {
/*    */   private int videoid;
/*    */   private BaseService baseService;
/*    */   
/* 40 */   public int getVideoid() { return this.videoid; }
/*    */ 
/*    */ 
/*    */   
/* 44 */   public void setVideoid(int videoid) { this.videoid = videoid; }
/*    */ 
/*    */ 
/*    */   
/* 48 */   public BaseService getBaseService() { return this.baseService; }
/*    */ 
/*    */ 
/*    */   
/* 52 */   public void setBaseService(BaseService baseService) { this.baseService = baseService; }
/*    */ 
/*    */   
/*    */   public String execute() {
/*    */     try {
/* 57 */       Video video = (Video)this.baseService.ReadByID("Video", this.videoid);
/*    */       
/* 59 */       String thumbnailPath = video.getThumbnailurl();
/* 60 */       String path = video.getUrl();
/* 61 */       String oripath = video.getOriurl();
/*    */       
/* 63 */       String thumbnailrealpath = String.valueOf(ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')) + 
/* 64 */         thumbnailPath;
/* 65 */       String realpath = String.valueOf(ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')) + 
/* 66 */         path;
/* 67 */       String orirealpath = String.valueOf(ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')) + 
/* 68 */         oripath;
/* 69 */       File thumbnailfile = new File(thumbnailrealpath);
/* 70 */       File videofile = new File(realpath);
/* 71 */       File orivideofile = new File(orirealpath);
/*    */       
/* 73 */       if (thumbnailfile != null) {
/* 74 */         thumbnailfile.delete();
/*    */       }
/* 76 */       if (videofile != null) {
/* 77 */         videofile.delete();
/*    */       }
/* 79 */       if (orivideofile != null) {
/* 80 */         orivideofile.delete();
/*    */       }
/*    */       
/* 83 */       this.baseService.delete(video);
/* 84 */       return "success";
/*    */     }
/* 86 */     catch (Exception ex) {
/* 87 */       ex.printStackTrace();
/* 88 */       return "error";
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\JUSTOO\Desktop\classes\!\action\video\VideoDelete.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */