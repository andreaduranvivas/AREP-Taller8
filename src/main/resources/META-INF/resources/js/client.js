let client = (function () {

    let _publicFunctions = {};
    let _stream_server = "https://bvdo3s5ms1.execute-api.us-east-1.amazonaws.com/Beta";
    let _tweet_server = "https://bvdo3s5ms1.execute-api.us-east-1.amazonaws.com/Beta";

    let _getAccessToken = function (){
        const urlCompleta = location.href;
        const urlParts = urlCompleta.split('#');
        if (urlParts.length < 2) {
            throw new Error('Invalid URL format, missing hash fragment');
        }

        const fragmentParams = new URLSearchParams(urlParts[1]);

        const idToken = fragmentParams.get('id_token');

        if (!idToken) {
            throw new Error('id_token not found in URL fragment');
        }
        console.log(idToken);
        return idToken;
    }

    _publicFunctions.tweet = function (author, content) {
        return $.ajax({
            url: `${_tweet_server}/secured/tweet`,
            type: 'POST',
            data: JSON.stringify({
                author: author,
                content: content,
                creationDate: new Date().toJSON()
            }),
            contentType: "application/json",
            headers: {
                'access_token': _getAccessToken()
            }
        });
    };

    _publicFunctions.getAllTweets = function () {
        return $.ajax({
            url: `${_stream_server}/secured/stream`,
            type: 'GET',
            headers: {
                'access_token': _getAccessToken()
            }
        });
    };

    return _publicFunctions;
})();