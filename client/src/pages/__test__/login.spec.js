require('chai').should()

import React from 'react/addons'
import mockRouter from '../../../utils/mock-react-router'
import Login from '../Login.react'

const TestUtils = React.addons.TestUtils
var mockedLogin = mockRouter(Login)

import {
  RaisedButton,
  FontIcon,
  Paper,
  TextField
} from 'material-ui'

let login
describe('Login Page Component', function() {
    beforeEach(function() {
      login = TestUtils.renderIntoDocument(<mockedLogin />)
    });

  it('should be able to initialized independently', function() {
    TestUtils.isCompositeComponent(login).should.be.equal(true)
    TestUtils.isCompositeComponentWithType(login, Login)
  })
  it.skip('should be able to throw error when username or password is empty',function() {
    var loginButton = TestUtils.findRenderedDOMComponentWithType(login, RaisedButton)
    var username = login.refs.username
    var password = login.refs.password
    TestUtils.Simulate.click(loginButton)
    login.state.should.be.equal('User name or password cannot be empty.')
  })
})
