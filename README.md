# TestPostFile1

這隻簡單小專案只是單純練習由前端把檔案傳送到後端去的好幾種不同寫法，  
包括最傳統的 &lt;form&gt; 表單、透過 XMLHttpRequest物件、  
透過 jQuery函式庫、透過 fetch物件 來完成相同功能。
畫面全都是使用 JSP 在後端 Server render出來，  
至於 JavaScript程式 則放置在 "src/main/webapp/js/" 資料夾裡面。  

```no-highlight
預前準備

1.
在 Windows電腦 C槽根目錄 新增資料夾testPostFile
路徑為 "C:/testPostFile/"

假設沒調 Tomcat Server 的設定，預設 port 就是 8080 ，
下述4種網址分別代表4種頁面上不同方法把檔案從前端傳送到後端去。

(1)
最傳統的 <form> 表單，直接發送POST請求把檔案丟過去。
http://localhost:8080/TestPostFile1/index.jsp

(2)
執行 JavaScript程式，以 fetch 把檔案從前端送到後端。
【Internet Explorer瀏覽器不支援】
http://localhost:8080/TestPostFile1/page2.jsp

(3)
執行 JavaScript程式，以 XMLHttpRequest物件 把檔案從前端送到後端。
http://localhost:8080/TestPostFile1/page3.jsp

(4)
執行 JavaScript程式，以 jQuery.ajax物件 把檔案從前端送到後端。
http://localhost:8080/TestPostFile1/page4.jsp
```