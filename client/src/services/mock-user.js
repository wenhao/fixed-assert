export default [
  {
    pattern: 'http://localhost:8080/auth/(login|logout)',
    // callback that returns the data
    fixtures: function (data) {
      if (data) {
        if (data.account === 'admin') {
          if (data.password === 'pw') {
            //login successful
            return {account: 'admin'}
          } else {
            //password is not correct
            throw new function() {
              this.code = ''
              this.errorMessage = 'The password is not correct, please input again.'
              this.httpStatus = 401
            };
            return
          }
        } else {
          //use is not found
          throw new function() {
            this.code = ''
            this.errorMessage = 'The user is not exist.'
            this.httpStatus = 401
          };
          return
        }
      }
      //throw new Error('Request not found!')
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
    pattern: 'http://localhost:8080/(users)$',
    fixtures: function(data) {
      if(!data.account) {
        throw new function() {
          this.message = 'account should not be empty';
        };
      }
      if(!data.password) {
        throw new function () {
          this.message = 'password should not be empty';
        };
      }
      if(data.account === 'twer') {
        throw new function() {
          this.statusCode = 409
        };
      }
      return {statusCode: 201};
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
