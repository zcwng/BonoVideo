/*    */ package action.video;
/*    */ 
/*    */ import bean.Video;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.util.List;
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
/*    */ public class VideoReadAll
/*    */   extends ActionSupport
/*    */ {
/*    */   private List<Video> resultvideo;
/*    */   private BaseService baseService;
/*    */   private int islive;
/*    */   
/* 39 */   public List<Video> getResultvideo() { return this.resultvideo; }
/*    */ 
/*    */ 
/*    */   
/* 43 */   public void setResultvideo(List<Video> resultvideo) { this.resultvideo = resultvideo; }
/*    */ 
/*    */ 
/*    */   
/* 47 */   public BaseService getBaseService() { return this.baseService; }
/*    */ 
/*    */ 
/*    */   
/* 51 */   public void setBaseService(BaseService baseService) { this.baseService = baseService; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 56 */   public int getIslive() { return this.islive; }
/*    */ 
/*    */ 
/*    */   
/* 60 */   public void setIslive(int islive) { this.islive = islive; }
/*    */ 
/*    */ 
/*    */   
/*    */   public String execute() {
/*    */     try {
/* 66 */       if (this.islive == 0) {
/* 67 */         this.resultvideo = this.baseService.ReadByProperty("Video", "islive", Integer.valueOf(0));
/*    */       } else {
/* 69 */         this.resultvideo = this.baseService.ReadByProperty("Video", "islive", Integer.valueOf(1));
/*    */       } 
/* 71 */       return "success";
/*    */     }
/* 73 */     catch (Exception ex) {
/* 74 */       ex.printStackTrace();
/* 75 */       return "error";
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\JUSTOO\Desktop\classes\!\action\video\VideoReadAll.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */