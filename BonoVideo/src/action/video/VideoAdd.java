/*     */ package action.video;
/*     */ 
/*     */ import bean.Category;
/*     */ import bean.Configure;
/*     */ import bean.Video;
/*     */ import bean.Videostate;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ import org.apache.struts2.ServletActionContext;
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
/*     */ 
/*     */ 
/*     */ public class VideoAdd
/*     */   extends ActionSupport
/*     */ {
/*     */   private static final int FILE_SIZE = 16384;
/*     */   private String name;
/*     */   private String intro;
/*     */   private File videofile;
/*     */   private String videofileFileName;
/*     */   private String videofileContentType;
/*     */   private BaseService baseService;
/*     */   private int islive;
/*     */   private String url;
/*     */   
/*  59 */   public String getName() { return this.name; }
/*     */ 
/*     */   
/*  62 */   public void setName(String name) { this.name = name; }
/*     */ 
/*     */   
/*  65 */   public String getIntro() { return this.intro; }
/*     */ 
/*     */   
/*  68 */   public void setIntro(String intro) { this.intro = intro; }
/*     */ 
/*     */   
/*  71 */   public BaseService getBaseService() { return this.baseService; }
/*     */ 
/*     */   
/*  74 */   public void setBaseService(BaseService baseService) { this.baseService = baseService; }
/*     */ 
/*     */   
/*  77 */   public File getVideofile() { return this.videofile; }
/*     */ 
/*     */   
/*  80 */   public void setVideofile(File videofile) { this.videofile = videofile; }
/*     */ 
/*     */   
/*  83 */   public String getVideofileFileName() { return this.videofileFileName; }
/*     */ 
/*     */   
/*  86 */   public void setVideofileFileName(String videofileFileName) { this.videofileFileName = videofileFileName; }
/*     */ 
/*     */   
/*  89 */   public String getVideofileContentType() { return this.videofileContentType; }
/*     */ 
/*     */   
/*  92 */   public void setVideofileContentType(String videofileContentType) { this.videofileContentType = videofileContentType; }
/*     */ 
/*     */   
/*  95 */   public int getIslive() { return this.islive; }
/*     */ 
/*     */   
/*  98 */   public void setIslive(int islive) { this.islive = islive; }
/*     */ 
/*     */   
/* 101 */   public String getUrl() { return this.url; }
/*     */ 
/*     */   
/* 104 */   public void setUrl(String url) { this.url = url; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void upLoadFile(File source, File target) {
/* 112 */     InputStream in = null;
/* 113 */     OutputStream out = null;
/*     */     try {
/* 115 */       in = new BufferedInputStream(new FileInputStream(source), 16384);
/* 116 */       out = new BufferedOutputStream(new FileOutputStream(target), 16384);
/*     */       
/* 118 */       byte[] buffer = new byte[16384];
/* 119 */       while (in.read(buffer) > 0) {
/* 120 */         out.write(buffer);
/*     */       }
/* 122 */     } catch (IOException ex) {
/* 123 */       ex.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 126 */         in.close();
/* 127 */         out.close();
/* 128 */       } catch (IOException ex) {
/* 129 */         ex.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String execute() {
/*     */     try {
/* 136 */       int order = 1;
/* 137 */       Video video = new Video();
/* 138 */       video.setName(this.name);
/* 139 */       video.setIntro(this.intro);
/* 140 */       video.setEdittime(new Timestamp((new Date()).getTime()));
/* 141 */       Configure folder_videoori_cfg = (Configure)this.baseService.ReadSingle("Configure", "name", "folder_videoori");
/* 142 */       Configure folder_thumbnail_cfg = (Configure)this.baseService.ReadSingle("Configure", "name", "folder_thumbnail");
/* 143 */       if (this.islive == 0) {
/*     */         
/* 145 */         String oriurl = String.valueOf(folder_videoori_cfg.getVal()) + "/" + this.videofileFileName;
/* 146 */         video.setOriurl(oriurl);
/* 147 */         Category category = (Category)this.baseService.ReadSingle("Category", "id", Integer.valueOf(1));
/* 148 */         video.setCategory(category);
/*     */         
/* 150 */         Videostate videostate = (Videostate)this.baseService.ReadSingle("Videostate", "order", Integer.valueOf(order));
/* 151 */         video.setVideostate(videostate);
/* 152 */         video.setIslive(Integer.valueOf(0));
/*     */         
/* 154 */         String defaultthumbnail = String.valueOf(folder_thumbnail_cfg.getVal()) + "/default.jpg";
/* 155 */         video.setThumbnailurl(defaultthumbnail);
/* 156 */         this.baseService.save(video);
/*     */ 
/*     */         
/* 159 */         String realfileoriDir = ServletActionContext.getServletContext().getRealPath(folder_videoori_cfg.getVal()).replace('\\', '/');
/*     */         
/* 161 */         File realfileoriDirFile = new File(realfileoriDir);
/* 162 */         if (!realfileoriDirFile.exists() && !realfileoriDirFile.isDirectory()) {
/* 163 */           System.out.println("Directory not exist. Create it.");
/* 164 */           System.out.println(realfileoriDirFile);
/* 165 */           realfileoriDirFile.mkdir();
/*     */         } 
/* 167 */         String realfileoriPath = String.valueOf(realfileoriDir) + "/" + this.videofileFileName;
/* 168 */         File targetFile = new File(realfileoriPath);
/* 169 */         upLoadFile(this.videofile, targetFile);
/*     */         
/* 171 */         videostate = (Videostate)this.baseService.ReadSingle("Videostate", "order", Integer.valueOf(order + 1));
/* 172 */         video.setVideostate(videostate);
/* 173 */         this.baseService.update(video);
/*     */       } else {
/*     */         
/* 176 */         Category category = (Category)this.baseService.ReadSingle("Category", "id", Integer.valueOf(2));
/* 177 */         video.setCategory(category);
/* 178 */         video.setUrl(this.url);
/* 179 */         video.setIslive(Integer.valueOf(1));
/*     */         
/* 181 */         Videostate videostate = (Videostate)this.baseService.ReadSingle("Videostate", "order", Integer.valueOf(order + 1));
/* 182 */         video.setVideostate(videostate);
/*     */         
/* 184 */         String defaultthumbnail = String.valueOf(folder_thumbnail_cfg.getVal()) + "/default.jpg";
/* 185 */         video.setThumbnailurl(defaultthumbnail);
/*     */         
/* 187 */         this.baseService.save(video);
/*     */       } 
/*     */       
/* 190 */       return "success";
/*     */     }
/* 192 */     catch (Exception ex) {
/* 193 */       ex.printStackTrace();
/* 194 */       return "error";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\JUSTOO\Desktop\classes\!\action\video\VideoAdd.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */