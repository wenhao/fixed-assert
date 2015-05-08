
import React from 'react'
import {
    RaisedButton,
    FontIcon,
    TextField,
    Paper
    } from 'material-ui'
import {
    State
    } from 'react-router'

import assetApi from '../services/asset'

var UserCreation = React.createClass({
    _doClear(){
        this.refs.userName.clearValue();
        this.refs.password.clearValue();

    },
    render() {
        return (

            <Paper zDepth={1} >
                <div>
                    <h1>Creat a new user!</h1>
                </div>
                <div>
                    <TextField ref="userName"
                        hintText="Your Name:Sun"
                        floatingLabelText="User Name"
                    />
                </div>
                <div>
                    <TextField ref="password"
                        hintText="Password:123@de"
                        floatingLabelText="Password"
                    />
                </div>
                <RaisedButton label="Clear" secondary={true} onClick={this._doClear}/>
                <RaisedButton label="Create" secondary={true} />

            </Paper>
        );
    }
})

export default UserCreation