require('chai').should()

import React from 'react/addons'
import mockRouter from '../../../utils/mock-react-router'
import Login from '../Login.react'

const TestUtils = React.addons.TestUtils
var MockedLogin = mockRouter(Login)

import {
  RaisedButton,
  FontIcon,
  Paper,
  TextField
} from 'material-ui'

let login

describe('Login Page Component', function() {

  beforeEach(function() {
    login = TestUtils.renderIntoDocument(<MockedLogin />).refs.source
  });
  it('should be able to initialized independently', function() {
    TestUtils.isCompositeComponent(login).should.be.equal(true)
    TestUtils.isCompositeComponentWithType(login, Login)
  })

  describe('Login Button',function() {
    it('should be disabled when username or password is empty',function() {
      login.refs.loginButton.props.disabled.should.be.equal(true)
    })
    it('should be disable when fill in username not password', function(){
      var userName = React.findDOMNode(login.refs.username.refs.input)
      React.addons.TestUtils.Simulate.change(userName,{target:{value: 'test'}})
      login.refs.username.setValue("test")
      login.state.isDisable.should.be.equal(true)
    })
    it('should not be disable when fill in username and password', function(){
      var userName = React.findDOMNode(login.refs.username.refs.input)
      var password = React.findDOMNode(login.refs.password.refs.input)
      login.refs.username.setValue("test")
      login.refs.password.setValue("test")
      React.addons.TestUtils.Simulate.change(userName,{target:{value: 'test'}})
      React.addons.TestUtils.Simulate.change(password,{target:{value: 'test'}})
      login.state.isDisable.should.be.equal(false)

      login.refs.password.setValue(null)
      React.addons.TestUtils.Simulate.change(password,{target:{value: null}})
      login.state.isDisable.should.be.equal(true)
    })

  })
})
