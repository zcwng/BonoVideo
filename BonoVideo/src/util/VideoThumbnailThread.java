/*     */ package util;
/*     */ 
/*     */ import bean.Configure;
/*     */ import bean.Video;
/*     */ import bean.Videostate;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.springframework.web.context.WebApplicationContext;
/*     */ import org.springframework.web.context.support.WebApplicationContextUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VideoThumbnailThread
/*     */   extends Thread
/*     */ {
/*     */   private ServletContext servletContext;
/*     */   
/*  53 */   public ServletContext getServletContext() { return this.servletContext; }
/*     */ 
/*     */ 
/*     */   
/*  57 */   public void setServletContext(ServletContext servletContext) { this.servletContext = servletContext; }
/*     */ 
/*     */ 
/*     */   
/*  61 */   public VideoThumbnailThread(ServletContext servletContext) { this.servletContext = servletContext; }
/*     */   
/*     */   public void run() {
/*     */     try {
/*  65 */       int order = 2;
/*  66 */       WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.servletContext);
/*  67 */       BaseService baseService = (BaseService)ctx.getBean("BaseService");
/*     */       
/*  69 */       Configure thumbnail_ss_cfg = (Configure)baseService.ReadSingle("Configure", "name", "thumbnail_ss");
/*  70 */       Configure folder_thumbnail_cfg = (Configure)baseService.ReadSingle("Configure", "name", "folder_thumbnail");
/*     */       
/*  72 */       String realthumbnailDir = String.valueOf(this.servletContext.getRealPath("/").replace('\\', '/')) + folder_thumbnail_cfg.getVal();
/*     */       
/*  74 */       File realthumbnailDirFile = new File(realthumbnailDir);
/*  75 */       if (!realthumbnailDirFile.exists() && !realthumbnailDirFile.isDirectory()) {
/*  76 */         System.out.println("Directory not exist. Create it.");
/*  77 */         System.out.println(realthumbnailDirFile);
/*  78 */         realthumbnailDirFile.mkdir();
/*     */       } 
/*     */       
/*     */       while (true) {
/*  82 */         List<Video> resultvideo = baseService.ReadByProperty("Video", "videostate.order", Integer.valueOf(order));
/*  83 */         Videostate nextvideostate = (Videostate)baseService.ReadSingle("Videostate", "order", Integer.valueOf(order + 1));
/*     */         
/*  85 */         Videostate nextvideostate2 = (Videostate)baseService.ReadSingle("Videostate", "order", Integer.valueOf(order + 2));
/*  86 */         if (resultvideo != null) {
/*  87 */           for (Video video : resultvideo) {
/*     */             String realfileoriPath;
/*  89 */             if (video.getIslive().intValue() == 0) {
/*  90 */               realfileoriPath = String.valueOf(this.servletContext.getRealPath("/").replace('\\', '/')) + video.getOriurl();
/*     */             } else {
/*     */               
/*  93 */               realfileoriPath = video.getUrl();
/*  94 */               String[] a = realfileoriPath.split(":");
/*     */               
/*  96 */               if (a[0].equals("rtmp") || a[0].equals("rtmpe") || a[0].equals("rtmpte") || a[0].equals("rtmps")) {
/*  97 */                 realfileoriPath = String.valueOf(realfileoriPath) + " live=1";
/*     */               }
/*     */             } 
/* 100 */             String realthumbnailPath = String.valueOf(realthumbnailDir) + "/" + video.getId() + ".jpg";
/*     */             
/* 102 */             String videothumbnailcommand = "cmd /c start ffmpeg -y -i \"" + realfileoriPath + "\"" + 
/* 103 */               " -ss " + thumbnail_ss_cfg.getVal() + " -s 220x110 -f image2 -vframes 1 " + "\"" + realthumbnailPath + "\"";
/* 104 */             System.out.println(videothumbnailcommand);
/* 105 */             Process process = Runtime.getRuntime().exec(videothumbnailcommand);
/*     */             
/* 107 */             BufferedInputStream in = new BufferedInputStream(process.getInputStream());
/* 108 */             BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
/*     */             String lineStr;
/* 110 */             while ((lineStr = inBr.readLine()) != null)
/* 111 */               System.out.println(lineStr); 
/* 112 */             if (process.waitFor() != 0 && 
/* 113 */               process.exitValue() == 1) {
/* 114 */               System.err.println("Failed!");
/*     */             }
/* 116 */             inBr.close();
/* 117 */             in.close();
/*     */             
/* 119 */             video.setThumbnailurl(String.valueOf(folder_thumbnail_cfg.getVal()) + "/" + video.getId() + ".jpg");
/*     */             
/* 121 */             if (video.getIslive().intValue() == 0) {
/* 122 */               video.setVideostate(nextvideostate);
/*     */             } else {
/* 124 */               video.setVideostate(nextvideostate2);
/*     */             } 
/*     */             
/* 127 */             baseService.update(video);
/*     */             
/* 129 */             sleep(10000L);
/*     */           } 
/*     */         }
/* 132 */         sleep(10000L);
/*     */       } 
/* 134 */     } catch (Exception e) {
/*     */       
/* 136 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }

