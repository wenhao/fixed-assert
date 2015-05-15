require('chai').should()

import React from 'react/addons'
import Login from '../Login.react.js'
const TestUtils = React.addons.TestUtils

let login
describe('Login Component', function() {
  beforeEach(function() {
    login = TestUtils.renderIntoDocument(<Login />)
  })
  it('should be able to initialized independently', function() {
    TestUtils.isCompositeComponent(login).should.be.equal(true)
    TestUtils.isCompositeComponentWithType(login, Login)
  })
  it('should be able to throw error when username or password is empty',function() {
    var loginButton = TestUtils.findRenderedDOMComponentWithType(login, RaisedButton)
    var username = login.refs.username
    var password = login.refs.password
    TestUtils.Simulate.click(loginButton)
    login.state.should.be.equal('User name or password cannot be empty.')
  })
})
