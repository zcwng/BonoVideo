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
/*    */ public class VideoReadLimitedByOrder
/*    */   extends ActionSupport
/*    */ {
/*    */   private int num;
/*    */   private BaseService baseService;
/*    */   private List<Video> resultvideo;
/*    */   
/* 38 */   public BaseService getBaseService() { return this.baseService; }
/*    */ 
/*    */   
/* 41 */   public void setBaseService(BaseService baseService) { this.baseService = baseService; }
/*    */ 
/*    */ 
/*    */   
/* 45 */   public int getNum() { return this.num; }
/*    */ 
/*    */   
/* 48 */   public void setNum(int num) { this.num = num; }
/*    */ 
/*    */   
/* 51 */   public List<Video> getResultvideo() { return this.resultvideo; }
/*    */ 
/*    */   
/* 54 */   public void setResultvideo(List<Video> resultvideo) { this.resultvideo = resultvideo; }
/*    */   
/*    */   public String execute() {
/*    */     try {
/* 58 */       this.resultvideo = this.baseService.ReadLimitedByOrder("Video", "edittime", this.num, "asc");
/* 59 */       return "success";
/*    */     }
/* 61 */     catch (Exception ex) {
/* 62 */       ex.printStackTrace();
/* 63 */       return "error";
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\JUSTOO\Desktop\classes\!\action\video\VideoReadLimitedByOrder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */