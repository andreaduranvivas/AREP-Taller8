let app = (function (api) {
    let _author = "YO";

    let _publicFunctions = {};

    _publicFunctions.init = function () {
        _author = localStorage.getItem("user");
    };

    _publicFunctions.login = function (e) {
        e.preventDefault();
        localStorage.setItem("user", $("#user").val());
    };

    _publicFunctions.tweet = function () {
        let content = $("#new-tweet-field").val();
        let author = $("#author-new-tweet").text();
        api.tweet(author, content).then((res) => {
            _publicFunctions.getAllTweets();
        })
    };
    _publicFunctions.newUserName = function () {
        let newName = $("#user").val();
        $("#author-new-tweet").html(newName);

    }
    _publicFunctions.getAllTweets = function () {
        api.getAllTweets().then((res) => {
            let tweetsDiv = $("#stream-list");
            let tweets = "";
            res.forEach(tweet => {
                console.log(tweet);
                let markup = `
                    <div class="tweet">
                        <div class="info-tweet">
                            <p class="author">${tweet.author}</p>
                            <p>${new Date(tweet.creationDate)}</p>
                        </div>
                        <div class="tweet-content">
                            <p>${tweet.content}</p>
                        </div>
                    </div>
                `;
                tweets = tweets.concat(markup);
            });
            console.log(tweets);
            tweetsDiv.html(tweets);
        });
    };

    return _publicFunctions;
})(client);