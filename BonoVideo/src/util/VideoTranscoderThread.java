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
/*     */ public class VideoTranscoderThread
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
/*     */   
/*  62 */   public VideoTranscoderThread(ServletContext servletContext) { this.servletContext = servletContext; }
/*     */   
/*     */   public void run() {
/*     */     try {
/*  66 */       int order = 3;
/*  67 */       WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.servletContext);
/*  68 */       BaseService baseService = (BaseService)ctx.getBean("BaseService");
/*     */       
/*  70 */       Configure transcoder_vcodec_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_vcodec");
/*  71 */       Configure transcoder_bv_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_bv");
/*  72 */       Configure transcoder_framerate_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_framerate");
/*  73 */       Configure transcoder_acodec_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_acodec");
/*  74 */       Configure transcoder_ar_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_ar");
/*  75 */       Configure transcoder_ba_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_ba");
/*  76 */       Configure transcoder_scale_w_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_scale_w");
/*  77 */       Configure transcoder_scale_h_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_scale_h");
/*  78 */       Configure transcoder_watermarkuse_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_watermarkuse");
/*  79 */       Configure transcoder_watermark_url_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_watermark_url");
/*  80 */       Configure transcoder_watermark_x_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_watermark_x");
/*  81 */       Configure transcoder_watermark_y_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_watermark_y");
/*  82 */       Configure transcoder_keepaspectratio_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_keepaspectratio");
/*  83 */       Configure transcoder_outfmt_cfg = (Configure)baseService.ReadSingle("Configure", "name", "transcoder_outfmt");
/*  84 */       Configure folder_video_cfg = (Configure)baseService.ReadSingle("Configure", "name", "folder_video");
/*     */       
/*  86 */       String[] watermarkstrlist = transcoder_watermark_url_cfg.getVal().split("/");
/*  87 */       String watermarkDir = "";
/*  88 */       String watermarkFile = watermarkstrlist[watermarkstrlist.length - 1];
/*  89 */       for (int i = 0; i < watermarkstrlist.length - 1; i++) {
/*  90 */         watermarkDir = String.valueOf(watermarkDir) + watermarkstrlist[i] + "/";
/*     */       }
/*  92 */       String realwatermarkDir = String.valueOf(this.servletContext.getRealPath("/").replace('\\', '/')) + watermarkDir;
/*  93 */       File realwatermarkDirFile = new File(realwatermarkDir);
/*     */       
/*  95 */       if (!realwatermarkDirFile.exists() && !realwatermarkDirFile.isDirectory()) {
/*  96 */         System.out.println("Directory not exist. Create it.");
/*  97 */         System.out.println(realwatermarkDirFile);
/*  98 */         realwatermarkDirFile.mkdir();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 103 */       String realfileDir = String.valueOf(this.servletContext.getRealPath("/").replace('\\', '/')) + folder_video_cfg.getVal();
/*     */       
/* 105 */       File realfileDirFile = new File(realfileDir);
/* 106 */       if (!realfileDirFile.exists() && !realfileDirFile.isDirectory()) {
/* 107 */         System.out.println("Directory not exist. Create it.");
/* 108 */         System.out.println(realfileDirFile);
/* 109 */         realfileDirFile.mkdir();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/* 115 */         List<Video> resultvideo = baseService.ReadByProperty("Video", "videostate.order", Integer.valueOf(order));
/* 116 */         Videostate nextvideostate = (Videostate)baseService.ReadSingle("Videostate", "order", Integer.valueOf(order + 1));
/* 117 */         if (resultvideo != null) {
/* 118 */           for (Video video : resultvideo) {
/*     */             
/* 120 */             String filePath = String.valueOf(folder_video_cfg.getVal()) + "/" + video.getId() + "." + transcoder_outfmt_cfg.getVal();
/*     */             
/* 122 */             video.setUrl(filePath);
/* 123 */             String realfilePath = String.valueOf(this.servletContext.getRealPath("/").replace('\\', '/')) + video.getUrl();
/*     */             
/* 125 */             String realfileoriginalPath = String.valueOf(this.servletContext.getRealPath("/").replace('\\', '/')) + video.getOriurl();
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
/* 140 */             String videotranscodecommand = "cmd ";
/* 141 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "/c start ";
/*     */             
/* 143 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "ffmpeg -y ";
/* 144 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "-i ";
/* 145 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "\"" + realfileoriginalPath + "\" ";
/* 146 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "-vcodec " + transcoder_vcodec_cfg.getVal() + " ";
/* 147 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "-b:v " + transcoder_bv_cfg.getVal() + " ";
/* 148 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "-r " + transcoder_framerate_cfg.getVal() + " ";
/* 149 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "-acodec " + transcoder_acodec_cfg.getVal() + " ";
/* 150 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "-b:a " + transcoder_ba_cfg.getVal() + " ";
/* 151 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "-ar " + transcoder_ar_cfg.getVal() + " ";
/* 152 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "-vf ";
/* 153 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "scale=w=" + transcoder_scale_w_cfg.getVal() + ":h=" + transcoder_scale_h_cfg.getVal();
/* 154 */             if (transcoder_keepaspectratio_cfg.getVal().equals("true")) {
/* 155 */               videotranscodecommand = String.valueOf(videotranscodecommand) + ":force_original_aspect_ratio=decrease,pad=w=" + 
/* 156 */                 transcoder_scale_w_cfg.getVal() + ":h=" + transcoder_scale_h_cfg.getVal() + ":x=(ow-iw)/2:y=(oh-ih)/2";
/*     */             }
/* 158 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "[aa]";
/* 159 */             if (transcoder_watermarkuse_cfg.getVal().equals("true")) {
/* 160 */               videotranscodecommand = String.valueOf(videotranscodecommand) + ";movie=";
/* 161 */               videotranscodecommand = String.valueOf(videotranscodecommand) + watermarkFile;
/* 162 */               videotranscodecommand = String.valueOf(videotranscodecommand) + "[bb];";
/* 163 */               videotranscodecommand = String.valueOf(videotranscodecommand) + "[aa][bb]";
/* 164 */               videotranscodecommand = String.valueOf(videotranscodecommand) + "overlay=x=" + transcoder_watermark_x_cfg.getVal() + ":y=" + transcoder_watermark_y_cfg.getVal() + " ";
/*     */             } else {
/* 166 */               videotranscodecommand = String.valueOf(videotranscodecommand) + " ";
/*     */             } 
/* 168 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "\"";
/* 169 */             videotranscodecommand = String.valueOf(videotranscodecommand) + realfilePath;
/* 170 */             videotranscodecommand = String.valueOf(videotranscodecommand) + "\"";
/*     */ 
/*     */             
/* 173 */             System.out.println(videotranscodecommand);
/* 174 */             Process process = Runtime.getRuntime().exec(videotranscodecommand, null, realwatermarkDirFile);
/*     */             
/* 176 */             BufferedInputStream in = new BufferedInputStream(process.getInputStream());
/* 177 */             BufferedInputStream err = new BufferedInputStream(process.getErrorStream());
/* 178 */             BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
/* 179 */             BufferedReader errBr = new BufferedReader(new InputStreamReader(err));
/*     */             String lineStr;
/* 181 */             while ((lineStr = inBr.readLine()) != null) {
/* 182 */               System.out.println(lineStr);
/*     */             }
/* 184 */             while ((lineStr = errBr.readLine()) != null) {
/* 185 */               System.out.println(lineStr);
/*     */             }
/*     */             
/* 188 */             if (process.waitFor() != 0 && 
/* 189 */               process.exitValue() == 1) {
/* 190 */               System.err.println("Failed!");
/*     */             }
/* 192 */             inBr.close();
/* 193 */             in.close();
/*     */             
/* 195 */             video.setVideostate(nextvideostate);
/* 196 */             baseService.update(video);
/*     */             
/* 198 */             sleep(10000L);
/*     */           } 
/*     */         }
/* 201 */         sleep(10000L);
/*     */       } 
/* 203 */     } catch (Exception e) {
/*     */       
/* 205 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }
