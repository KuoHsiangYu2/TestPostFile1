console.log('test page4.js');

jQuery('#page4SubmitId').on('click', function() {
    let formData = new FormData();
    let page3FileObj = jQuery('#page4File')[0];
    formData.append('page4FileObj', page3FileObj.files[0]);
    jQuery.ajax({
        type: 'POST',
        url: 'GetFileServlet',
        processData: false,
        contentType: false,
        dataType: 'text',
        data: formData,
        success: function(response) {
            console.log('response = ', response);
        },
        error: function(thrownError) {
            console.log('thrownError = ', thrownError);
        }
    });
});

// https://www.itread01.com/content/1548568112.html
// https://blog.jquery.com/2016/05/20/jquery-1-12-4-and-2-2-4-released/
// https://pjchender.blogspot.com/2019/01/js-javascript-input-file-upload-file.html
// https://ithelp.ithome.com.tw/articles/10226692
// https://api.jquery.com/jquery.ajax/
