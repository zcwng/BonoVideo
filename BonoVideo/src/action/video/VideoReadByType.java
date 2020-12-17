/*    */ package action.video;
/*    */ 
/*    */ import bean.Video;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.util.List;
/*    */ import service.BaseService;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VideoReadByType
/*    */   extends ActionSupport
/*    */ {
/*    */   private List<Video> resultvideo;
/*    */   private BaseService baseService;
/*    */   private int islive;
/*    */   
/* 17 */   public List<Video> getResultvideo() { return this.resultvideo; }
/*    */ 
/*    */ 
/*    */   
/* 21 */   public void setResultvideo(List<Video> resultvideo) { this.resultvideo = resultvideo; }
/*    */ 
/*    */ 
/*    */   
/* 25 */   public BaseService getBaseService() { return this.baseService; }
/*    */ 
/*    */ 
/*    */   
/* 29 */   public void setBaseService(BaseService baseService) { this.baseService = baseService; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public int getIslive() { return this.islive; }
/*    */ 
/*    */ 
/*    */   
/* 38 */   public void setIslive(int islive) { this.islive = islive; }
/*    */ 
/*    */ 
/*    */   
/*    */   public String execute() {
/*    */     try {
/* 44 */       this.resultvideo = this.baseService.ReadByProperty("Video", "islive", Integer.valueOf(2));
/* 45 */       return "success";
/*    */     }
/* 47 */     catch (Exception ex) {
/* 48 */       ex.printStackTrace();
/* 49 */       return "error";
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\JUSTOO\Desktop\classes\!\action\video\VideoReadByType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */