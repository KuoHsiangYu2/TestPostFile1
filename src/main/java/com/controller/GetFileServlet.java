package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.util.GlobalService;

@MultipartConfig(location = "C:/testPostFile/",
    fileSizeThreshold = 300 * 1024 * 1024,
    maxFileSize = 300 * 1024 * 1024,
    maxRequestSize = 300 * 1024 * 1024)
@WebServlet("/GetFileServlet")
public class GetFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String filePath = "C:/testPostFile/";

    public GetFileServlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        boolean hasFileData = false;
        Collection<Part> parts = request.getParts();
        System.out.println("parts = " + parts);
        String pictureName = "";
        long sizeInBytes = 0L;
        InputStream inputStream = null;
        if (parts != null) {
            Iterator<Part> iterator = parts.iterator();
            Part part = null;
            while (true == iterator.hasNext()) {
                part = iterator.next();

                /* 1. 讀取使用者輸入資料 */
                if (part.getContentType() != null) {
                    pictureName = GlobalService.getFileName(part);
                    System.out.println("pictureName = [" + pictureName + "]");
                    if (pictureName != null && pictureName.trim().length() > 0) {
                        hasFileData = true;
                        sizeInBytes = part.getSize();
                        inputStream = part.getInputStream();
                    } else {
                        hasFileData = false;
                        System.out.println("#1 error. 必須挑選圖片檔");
                    }
                }
            }
        } else {
            System.out.println("#2 error. 此表單不是上傳檔案的表單");
        }

        if (false == hasFileData) {
            System.out.println("#3 error. 必須挑選圖片檔");
            return;
        }

        if (pictureName.indexOf(":\\") != -1) {
            System.out.println("Internet Explorer 進行檔案名稱處理");
            /* Internet Explorer 跟 舊版Microsoft Edge 上傳檔案時， */
            /* 檔案名稱包含檔案的絕對路徑在內，因此必須預先處理把絕對路徑拿掉。 */
            /* 只保留檔案名稱 */
            int index = pictureName.lastIndexOf("\\");

            /* 進行字串切割，把絕對路徑切掉，只保留檔案名稱。 */
            pictureName = pictureName.substring(index + 1, pictureName.length());
            System.out.println("substring pictureName = " + pictureName);
        }

        /* 創建儲存檔案的資料夾 */
        File imageFolder = new File(filePath);
        if (false == imageFolder.exists()) {
            imageFolder.mkdirs();
        }

        /* Java IO 把二進位資料流寫成檔案儲存至硬碟 */
        FileOutputStream fileOutputStream = null;
        try {
            byte[] byteBuffer = new byte[(int) sizeInBytes];
            inputStream.read(byteBuffer);
            String imageFile = filePath + pictureName;
            fileOutputStream = new FileOutputStream(new File(imageFile));
            fileOutputStream.write(byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
                fileOutputStream = null;
            }
            if (inputStream != null) {
                inputStream.close();
                inputStream = null;
            }
        }

        PrintWriter out = response.getWriter();
        out.print("success send file.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }
}