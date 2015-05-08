import React from 'react'
import {
  RaisedButton,
  FontIcon,
  Paper,
  TextField
} from 'material-ui'
import {
  State
} from 'react-router'

import userApi from '../services/user'

var Home = React.createClass({

  mixins: [State],

  getInitialState() {
    return {
      title: ''
    }
  },

  render() {
    return (
      <Paper zDepth={1} className="page-auth">
        <div className="login-group">
          <h3>Log in</h3>
          <div><TextField ref="username" hintText="User name" floatingLabelText="User name"/></div>
          <div><TextField ref="password" type="password" hintText="Password" floatingLabelText="Password"/></div>
          <h5 className="error-label">{this.state.errorMsg}</h5>
          <div><a href="https://www.google.com">Forgot your password?</a></div>
          <RaisedButton className="login-button" secondary={true} onClick={this._login}>
            <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
            <span className="mui-raised-button-label example-icon-button-label">Log in</span>
          </RaisedButton>
        </div>
      </Paper>
    )
  },

  _login() {
    var username = this.refs.username.getValue();
    var password = this.refs.password.getValue();
    if(!username || !password) {
      this.setState({errorMsg: 'User name or password cannot be empty'});
    } else {
      userApi.login({"name": username, "password": password}).then(this.onLogin, this.onLoginFail);
    }
  },
  onLogin(msg) {
    this.context.router.transitionTo('asset');
  },
  onLoginFail(err) {
    this.setState({errorMsg: err.response.body.errorMessage})
  }
});

export default Home
