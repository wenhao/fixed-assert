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
      userlist: '用户列表：twer'
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
            <div><TextField ref="account" hintText="User name" floatingLabelText="User name"/></div>
            <div><TextField ref="password" hintText="Initial password" floatingLabelText="Initial password" defaultValue="P@ss123456" disabled={true}/></div>
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
    var account = self.refs.account.getValue();
    var password = self.refs.password.getValue();
    if(!account || !password) {
      self.setState({errorMsg: 'User name or password cannot be empty'});
    } else {
      userApi.create({'account': account, 'password': password}).then(function(result){
        console.log(result);
        // TODO: create user successfully
        self.refs.dialog.dismiss();
        self.setState({errorMsg: ''});
        self.setState({userlist: self.state.userlist + ', '+ account });
        self.refs.account.setValue('');
      }, function(error) {
        self.setState({errorMsg: 'The user name already exist, please use another one.'})
      });
    }
  }
});

export default User
