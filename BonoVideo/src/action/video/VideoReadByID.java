/*     */ package action.video;
/*     */ 
/*     */ import bean.Video;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import service.BaseService;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VideoReadByID
/*     */   extends ActionSupport
/*     */ {
/*     */   private int videoid;
/*     */   private BaseService baseService;
/*     */   private String original_videoinfo;
/*     */   private String convert_videoinfo;
/*     */   private Video video;
/*     */   
/*  39 */   public int getVideoid() { return this.videoid; }
/*     */ 
/*     */   
/*  42 */   public void setVideoid(int videoid) { this.videoid = videoid; }
/*     */ 
/*     */   
/*  45 */   public BaseService getBaseService() { return this.baseService; }
/*     */ 
/*     */   
/*  48 */   public void setBaseService(BaseService baseService) { this.baseService = baseService; }
/*     */ 
/*     */ 
/*     */   
/*  52 */   public Video getVideo() { return this.video; }
/*     */ 
/*     */   
/*  55 */   public void setVideo(Video video) { this.video = video; }
/*     */ 
/*     */ 
/*     */   
/*  59 */   public String getOriginal_videoinfo() { return this.original_videoinfo; }
/*     */ 
/*     */   
/*  62 */   public void setOriginal_videoinfo(String original_videoinfo) { this.original_videoinfo = original_videoinfo; }
/*     */ 
/*     */   
/*  65 */   public String getConvert_videoinfo() { return this.convert_videoinfo; }
/*     */ 
/*     */   
/*  68 */   public void setConvert_videoinfo(String convert_videoinfo) { this.convert_videoinfo = convert_videoinfo; }
/*     */   
/*     */   public String execute() {
/*     */     try {
/*  72 */       this.video = (Video)this.baseService.ReadByID("Video", this.videoid);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 100 */       return "success";
/*     */     }
/* 102 */     catch (Exception ex) {
/* 103 */       ex.printStackTrace();
/* 104 */       return "error";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\JUSTOO\Desktop\classes\!\action\video\VideoReadByID.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */