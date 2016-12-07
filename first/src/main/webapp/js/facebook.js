window.fbAsyncInit = function() {
    // init the FB JS SDK
    FB.init({
      appId      : '********',                        // App ID from the app dashboard    : 공유글에 표시되므로 앱의 이름은 의미있게 정한다. 예: 앱이름 : moneual, app_id : **********
      channelUrl : '**********************', // Channel file for x-domain comms    : 외부사이트에서 접근 시
      status     : true,                                 // Check Facebook Login status
      xfbml      : true                                  // Look for social plugins on the page
    });
    // Additional initialization code such as adding Event Listeners goes here
  };
