let client = (function () {

    let _publicFunctions = {};
    let _stream_server = "http://localhost:8080";
    let _tweet_server = "http://localhost:8080"

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
        });
    };

    _publicFunctions.getAllTweets = function () {
        return $.ajax({
            url: `${_stream_server}/secured/stream`,
            type: 'GET',
        });
    };

    return _publicFunctions;
})();