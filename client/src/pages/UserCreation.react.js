import React from 'react'
import {
    RaisedButton,
    TextField,
    FontIcon,
    Paper
    } from 'material-ui'
import {
    State
    } from 'react-router'


const UserCreation = React.createClass({
    render() {
        return (
            <Paper zDepth={1}>
               // <TextField hintText="hint">Please display.</TextField>

                <ul>
                    <li className="asset__attribute">Name</li>
                    <li className="asset__attribute">Number</li>
                    <li className="asset__attribute">Assigned Date</li>
                    <li className="asset__attribute">Type</li>
                </ul>
            </Paper>
        )
    }

})

export default UserCreation
