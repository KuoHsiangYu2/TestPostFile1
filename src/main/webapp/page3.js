console.log('test page3.js');

let page3SubmitIdObj = document.getElementById('page3SubmitId');
page3SubmitIdObj.addEventListener('click', function() {
    let formData = new FormData();
    let page3FileObj = document.getElementById('page3File');
    formData.append('page3FileObj', page3FileObj.files[0]);

    /* 使用AJAX技術，由JavaScript把資料輸出並發送POST請求到後端程式更新資料。 */
    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function() {
        if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
            /* 前端發送POST請求，後端回應一個response，成功後會執行此段程式。 */
            console.log('xmlHttpRequest.responseText = ', xmlHttpRequest.responseText);
        }
    }
    xmlHttpRequest.open('POST', 'GetFileServlet', true);
    xmlHttpRequest.setRequestHeader('If-Modified-Since', '0');

    /* https://blog.csdn.net/sanjay_f/article/details/47407063 */
    /* 如果加入Content-type，傳送檔案到後端時會拋出 【java.io.IOException: org.apache.tomcat.util.http.fileupload.FileUploadException: the request was rejected because no multipart boundary was found】 */
    // xmlHttpRequest.setRequestHeader('Content-type', 'multipart/form-data');

    xmlHttpRequest.send(formData);/* 發送post請求，把JSON物件打出去給後端。 */
});

/* https://notfalse.net/29/xmlhttprequest */
/* https://developer.mozilla.org/zh-TW/docs/Web/API/XMLHttpRequest/Using_XMLHttpRequest */
/* https://ithelp.ithome.com.tw/articles/10158950 */