require('chai').should()

import user from '../user'

describe('User Services', function() {
  it('should be able to login', function(done) {
    user.login({
        username: "admin",
        password: "pw"
    })
    .then(function(data) {
      data.username.should.be.equal('admin')
      done()
    })
    .catch(done)
  });
  it('should not be able to login when password is incorrect', function(done) {
    user.login({
      username: "admin",
      password: "123"
    })
    .then(null, function(err) {
      err.errorMessage.should.be.equal('The password is not correct, please input again.')
      err.httpStatus.should.be.equal(401)
      done()
    })
    .catch(done)
  })
  it('should not be able to login when is not exist', function(done) {
    user.login({
      username: "123",
      password: "123"
    })
    .then(null, function(err) {
      err.errorMessage.should.be.equal('The user is not exist.')
      err.httpStatus.should.be.equal(401)
        done()
    })
    .catch(done)
  })
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
