require('chai').should()

import user from '../user'

describe('User Services', function() {
  it('should be able to login', function(done) {
    user.login({
        account: "admin",
        password: "pw"
    })
    .then(function(data) {
      data.account.should.be.equal('admin')
      done()
    })
    .catch(function(err) {
        done()
      })
  });
  it('should not be able to login when password is incorrect', function(done) {
    user.login({
      account: "admin",
      password: "123"
    })
    .then(null, function(err) {
      err.errorMessage.should.be.equal('The password is not correct, please input again.')
      err.httpStatus.should.be.equal(401)
      done()
    })
  });
  it('should not be able to login when is not exist', function(done) {
    user.login({
      account: "123",
      password: "123"
    })
    .then(null, function(err) {
      err.errorMessage.should.be.equal('The user is not exist.')
      err.httpStatus.should.be.equal(401)
      done()
    })
  });
  it('should be able to create user when user does not exist', function(done) {
    user.create({
      account: 'LSQ',
      password: '123456'
    }).then(function(result){
      result.statusCode.should.be.equal(201);
      done();
    }).catch(function(error) {
      done(error);
    });
  });

  it('should not be able to create user when user exists', function (done) {
    user.create({
      account:'twer',
      password: '123456'
    }).then(null, function (err) {
      err.statusCode.should.be.equal(409);
      done();
    });
  });

  it('should not be able to create user when password is empty', function(done) {
    user.create({
      account: 'test'
    }).then(null, function(err) {
      err.message.should.be.equal("password should not be empty");
      done();
    });
  });

  it('should not be able to create user when account is empty', function(done) {
    user.create({
      password: '12345'
    }).then(null, function(err) {
      err.message.should.be.equal('account should not be empty');
      done();
    });
  });

  it('should check user account empty first when both are empty', function(done) {
    user.create({}).then(null, function(err) {
      err.message.should.be.equal('account should not be empty');
      done();
    });
  });
});
