require('chai').should()

import user from '../user'

describe('User Services', function() {
  it('should be able to login', function(done) {
    user.login()
      .then(function(data) {
        data.should.be.equal('success')
        done()
      })
      .catch(function(err) {
        done(err)
      })
  });
  it('should be able to create user', function(done) {
    user.create({
      name: 'LSQ',
      password: '123456'
    }).then(function(result){
      result.should.be.equal('create user successfully');
      done();
    }).catch(function(error) {
      done(error);
    });
  });

});
