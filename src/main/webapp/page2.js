console.log('test page2.js');

// async function postData(url = '', data = {}) {
function postData(url, data) {
    const formData = new FormData();
    const fileField = document.getElementById('page2File');
    formData.append('page2File', fileField.files[0]);
    return fetch(url, {
        'body': formData,
        'cache': 'no-cache',
        'credentials': 'same-origin',
        'method': 'POST',
        'mode': 'cors',
    }).then(function(response) {
        console.log('response = ', response);
        return response.text();
    });
}

let submitIdObj = document.getElementById('page2SubmitId');
submitIdObj.addEventListener('click', function() {
    postData('GetFileServlet', '').then(function(result) {
        console.log('result = ', result);
    });
});

/* https://developer.mozilla.org/zh-TW/docs/Web/API/Fetch_API/Using_Fetch */
/* https://wcc723.github.io/javascript/2017/12/28/javascript-fetch/ */
/* https://ithelp.ithome.com.tw/articles/10230303 */
/* https://ithelp.ithome.com.tw/articles/10230214 */