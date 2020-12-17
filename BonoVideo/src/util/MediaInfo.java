/*     */ package util;
/*     */ 
/*     */ import com.sun.jna.FunctionMapper;
/*     */ import com.sun.jna.Library;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.NativeLibrary;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.WString;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collections;
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
/*     */ public class MediaInfo
/*     */ {
/*     */   private Pointer Handle;
/*     */   
/*     */   static  {
/*     */     try {
/*  50 */       String os = System.getProperty("os.name");
/*  51 */       if (os != null && !os.toLowerCase().startsWith("windows") && !os.toLowerCase().startsWith("mac")) {
/*  52 */         NativeLibrary.getInstance("zen");
/*     */       }
/*  54 */     } catch (LinkageError linkageError) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static interface MediaInfoDLL_Internal
/*     */     extends Library
/*     */   {
/*  64 */     public static final MediaInfoDLL_Internal INSTANCE = (MediaInfoDLL_Internal)Native.loadLibrary("mediainfo", MediaInfoDLL_Internal.class, Collections.singletonMap("function-mapper", new FunctionMapper()
/*     */           {
/*     */ 
/*     */             
/*     */             public String getFunctionName(NativeLibrary lib, Method method)
/*     */             {
/*  70 */               return "MediaInfo_" + method.getName();
/*     */             }
/*     */           }));
/*     */ 
/*     */     
/*     */     Pointer New();
/*     */     
/*     */     void Delete(Pointer param1Pointer);
/*     */     
/*     */     int Open(Pointer param1Pointer, WString param1WString);
/*     */     
/*     */     void Close(Pointer param1Pointer);
/*     */     
/*     */     WString Inform(Pointer param1Pointer, int param1Int);
/*     */     
/*     */     WString Get(Pointer param1Pointer, int param1Int1, int param1Int2, WString param1WString, int param1Int3, int param1Int4);
/*     */     
/*     */     WString GetI(Pointer param1Pointer, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
/*     */     
/*     */     int Count_Get(Pointer param1Pointer, int param1Int1, int param1Int2);
/*     */     
/*     */     WString Option(Pointer param1Pointer, WString param1WString1, WString param1WString2);
/*     */   }
/*     */   
/*     */   public enum StreamKind
/*     */   {
/*  96 */     General,
/*  97 */     Video,
/*  98 */     Audio,
/*  99 */     Text,
/* 100 */     Chapters,
/* 101 */     Image,
/* 102 */     Menu;
/*     */   }
/*     */   
/*     */   public enum InfoKind
/*     */   {
/* 107 */     Name,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     Text,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     Measure,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     Options,
/*     */     
/* 124 */     Name_Text,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     Measure_Text,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 134 */     Info,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     HowTo,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     Domain;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 154 */   public MediaInfo() { this.Handle = MediaInfoDLL_Internal.INSTANCE.New(); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 159 */     if (this.Handle == null) {
/* 160 */       throw new IllegalStateException();
/*     */     }
/* 162 */     MediaInfoDLL_Internal.INSTANCE.Delete(this.Handle);
/* 163 */     this.Handle = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 169 */     if (this.Handle != null) {
/* 170 */       dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 182 */   public int Open(String File_Name) { return MediaInfoDLL_Internal.INSTANCE.Open(this.Handle, new WString(File_Name)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 191 */   public void Close() { MediaInfoDLL_Internal.INSTANCE.Close(this.Handle); }
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
/* 202 */   public String Inform() { return MediaInfoDLL_Internal.INSTANCE.Inform(this.Handle, 0).toString(); }
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
/* 216 */   public String Get(StreamKind StreamKind, int StreamNumber, String parameter) { return Get(StreamKind, StreamNumber, parameter, InfoKind.Text, InfoKind.Name); }
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
/* 233 */   public String Get(StreamKind StreamKind, int StreamNumber, String parameter, InfoKind infoKind) { return Get(StreamKind, StreamNumber, parameter, infoKind, InfoKind.Name); }
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
/* 251 */   public String Get(StreamKind StreamKind, int StreamNumber, String parameter, InfoKind infoKind, InfoKind searchKind) { return MediaInfoDLL_Internal.INSTANCE.Get(this.Handle, StreamKind.ordinal(), StreamNumber, new WString(parameter), infoKind.ordinal(), searchKind.ordinal()).toString(); }
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
/* 267 */   public String get(StreamKind StreamKind, int StreamNumber, int parameterIndex) { return Get(StreamKind, StreamNumber, parameterIndex, InfoKind.Text); }
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
/* 285 */   public String Get(StreamKind StreamKind, int StreamNumber, int parameterIndex, InfoKind infoKind) { return MediaInfoDLL_Internal.INSTANCE.GetI(this.Handle, StreamKind.ordinal(), StreamNumber, parameterIndex, infoKind.ordinal()).toString(); }
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
/* 298 */   public int Count_Get(StreamKind StreamKind) { return MediaInfoDLL_Internal.INSTANCE.Count_Get(this.Handle, StreamKind.ordinal(), -1); }
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
/* 312 */   public int Count_Get(StreamKind StreamKind, int StreamNumber) { return MediaInfoDLL_Internal.INSTANCE.Count_Get(this.Handle, StreamKind.ordinal(), StreamNumber); }
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
/* 326 */   public String Option(String Option) { return MediaInfoDLL_Internal.INSTANCE.Option(this.Handle, new WString(Option), new WString("")).toString(); }
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
/* 338 */   public String Option(String Option, String Value) { return MediaInfoDLL_Internal.INSTANCE.Option(this.Handle, new WString(Option), new WString(Value)).toString(); }
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
/* 349 */   public static String Option_Static(String Option) { return MediaInfoDLL_Internal.INSTANCE.Option(MediaInfoDLL_Internal.INSTANCE.New(), new WString(Option), new WString("")).toString(); }
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
/* 361 */   public static String Option_Static(String Option, String Value) { return MediaInfoDLL_Internal.INSTANCE.Option(MediaInfoDLL_Internal.INSTANCE.New(), new WString(Option), new WString(Value)).toString(); }
/*     */ }


