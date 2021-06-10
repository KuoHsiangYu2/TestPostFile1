package com.util;

import javax.servlet.http.Part;

/* 這個類別提供公共公開靜態的服務方法 */
public class GlobalService {

    public static String getFileName(Part part) {
        /* 取得使用者上傳檔案名稱 */
        System.out.println("part.getHeader(\"content-disposition\") -> " + part.getHeader("content-disposition"));
        String[] content = part.getHeader("content-disposition").split(";");
        int length = content.length;
        String result = "";
        for (int i = 0; i < length; i++) {
            result = String.format("content[%d] -> [%s]", i, content[i]);
            System.out.println(result);
        }
        for (int i = 0; i < length; i++) {
            if (content[i].trim().startsWith("filename")) {
                return content[i].substring(content[i].indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
