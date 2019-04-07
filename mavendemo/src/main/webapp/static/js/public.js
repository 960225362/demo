document.write("<script type='text/javascript' src='../jquery/jquery.min.js'></script>");

/**
 * 获取请求的url参数
 * @param key
 * @returns {*}
 */
function getParamByUrl(key) {
    var url = location.href;
    var index = url.indexOf('?');
    var params = [];
    if (index > 0) {
        var queryString = url.slice(index + 1);
        var hashes = queryString.split('&');
        for (var i = 0; i < hashes.length; i++) {
            var hash = hashes.split("=");
            params.push(hash[0]);
            params[hash[0]] = hash[1];

        }
        return params[key];
    }
}