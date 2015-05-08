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


const User = React.createClass({
  mixins: [State],

  getInitialState() {
    return {
      title: ''
    }
  },

  render() {
    return (
      <Paper zDepth={1} className="page-user">
        <div className="create-group">
          <h3>Create a new user</h3>
          <div><TextField ref="username" hintText="User name" floatingLabelText="User name"/></div>
          <div><TextField ref="password" type="password" hintText="Password" floatingLabelText="Password"/></div>
          <h5 className="error-label">{this.state.errorMsg}</h5>
          <RaisedButton secondary={true} onClick={this._createUser}>
            <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
            <span className="mui-raised-button-label example-icon-button-label">Create</span>
          </RaisedButton>
        </div>
      </Paper>
    )
  },

  _createUser() {
    var username = this.refs.username.getValue();
    var password = this.refs.password.getValue();
    if(!username || !password) {
      this.setState({errorMsg: 'User name or password cannot be empty'});
    } else {
      userApi.create({'name': username, 'password': password}).then(function(result){
        console.log(result);
        // TODO: create user successfully
        alert("create user successfully");
        this.setState({errorMsg: ''});
      }, function(error) {
        this.setState({errorMsg: error.response.body.errorMessage})
      });
    }
  }
});

export default User
