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
          <h3>User Login</h3>
          <div><TextField hintText="User Name" floatingLabelText="User Name"/></div>
          <div><TextField hintText="Password" floatingLabelText="Password"/></div>
          <h5 className="error-label">{this.state.title}</h5>
          <RaisedButton secondary={true} onClick={this._login}>
            <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
            <span className="mui-raised-button-label example-icon-button-label">Login</span>
          </RaisedButton>
        </div>
      </Paper>
    );
  },

  _login() {
    userApi.login({"name": "test", "password": "123452"})
      .then(this.onLogin, this.onLoginFail)
  },
  onLogin(msg) {
    this.setState({title: msg})
  },
  onLoginFail(err) {
    this.setState({title: err.response.body.errorMessage})
  }
});

export default Home
