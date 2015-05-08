import React from 'react'
import {
    RaisedButton,
    FontIcon,
    Paper,
    TextField,
    Dialog
    } from 'material-ui'
import {
    State
    } from 'react-router'

import userApi from '../services/user'


const User = React.createClass({
  mixins: [State],

  getInitialState() {
    return {
      errorMsg: '',
      userlist: '用户列表：yzhou, '
    }
  },

  render() {
    return (

      <Paper zDepth={1}>
        <Dialog className="page-user"
          ref="dialog"
          title="Create a new user"
          actions={[
            { text: 'Cancel' },
            { text: 'Create', onClick: this._createUser, ref: 'ok' }
          ]}
          actionFocus="ok"
          modal={this.state.modal}
          dismissOnClickAway={this.state.dismissOnClickAway}>
          <div className="create-group">
            <div><TextField ref="username" hintText="User name" floatingLabelText="User name"/></div>
            <div><TextField ref="password" hintText="Password" floatingLabelText="Password"/></div>
            <h5 className="error-label">{this.state.errorMsg}</h5>
          </div>
        </Dialog>
        <h2>{this.state.userlist}</h2>
        <RaisedButton secondary={true} onClick={this._popupCreateUser}>
          <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
          <span className="mui-raised-button-label example-icon-button-label">New User</span>
        </RaisedButton>

      </Paper>
    )
  },

  _popupCreateUser() {
    this.refs.dialog.show();
  },

  _createUser() {
    var self = this;
    var username = this.refs.username.getValue();
    var password = this.refs.password.getValue();
    if(!username || !password) {
      self.setState({errorMsg: 'User name or password cannot be empty'});
    } else {
      userApi.create({'name': username, 'password': password}).then(function(result){
        console.log(result);
        // TODO: create user successfully
        self.refs.dialog.dismiss();
        self.setState({errorMsg: ''});
        self.refs.username.setValue('');
        self.refs.password.setValue('');
        self.setState({userlist: self.state.userlist + result.body.name + ', '});
      }, function(error) {
        self.setState({errorMsg: 'The user name already exist, please use another one.'})
      });
    }
  }
});

export default User
