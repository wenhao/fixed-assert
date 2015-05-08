export default [
  {
    pattern: 'http://localhost:8080/auth/(login|logout)',
    // callback that returns the data
    fixtures: function () {
      return 'success'
    },
    // `match`: result of the resolution of the regular expression
    // `data`: data returns by `fixtures` attribute
    callback: function (match, data) {
      if (match[1]) {
        return data
      } else {
        return new Error('Do not match any urls!')
      }
    }
  }, {
    pattern: 'http://localhost:8080/(user)',
    fixtures: function() {
      return 'create user successfully'
    },
    callback: function(match, data) {
      if(match[1]) {
        return data;
      } else {
        return new Error('Do not match any urls!');
      }
    }
  }
];
