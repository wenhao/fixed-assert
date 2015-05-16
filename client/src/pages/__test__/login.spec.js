require('chai').should()

import React from 'react/addons'
import mockRouter from '../../../utils/mock-react-router'
import Login from '../Login.react'

const TestUtils = React.addons.TestUtils
//var MockedLogin = mockRouter(Login)

import {
  RaisedButton,
  FontIcon,
  Paper,
  TextField
} from 'material-ui'

let login

describe('Login Page Component', function() {

  beforeEach(function() {
    login = TestUtils.renderIntoDocument(<Login />)
  });
  it('should be able to initialized independently', function() {
    TestUtils.isCompositeComponent(login).should.be.equal(true)
    TestUtils.isCompositeComponentWithType(login, Login)
  })

  describe('Login Button',function() {
    it('should be disabled when username or password is empty',function() {
      login.state.isDisable.should.be.equal(true)
    })
    it('should get error message if login with not existing username', function(){

    })
  })
})
