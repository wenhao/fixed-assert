import React from 'react'
import {
    Paper,
    TextField,
    DropDownMenu,
    RaisedButton
} from 'material-ui'
import {
    State
} from 'react-router'

import assetApi from '../services/asset'

var AddAsset = React.createClass({

    mixins: [State],

    getInitialState() {
        return {
            type: 'Apple Laptop',
            isDisable: true
        }
    },

    _addAsset() {
        var number = this.refs.number.getValue();
        var type = this.state.type;
        assetApi.addAsset({"number": number,"type":type});
    },
    onAdd(msg){
        this.context.router.transitionTo('asset');
    },
    onAddFail(err){
        this.setState({errorMsg: err.response.body.errorMessage})
    },

    _handleType(e, selectedIndex, menuItem) {

        this.setState({type:menuItem.text});
    },
    _handleNumber() {
        var number = this.refs.number.getValue();
        if(number.length !=8 )
        {
            this.setState({isDisable: true});
            this.setState({errorMsg: 'The length of number must be 8!'});
        }else{
            this.setState({isDisable: false});
        }
    },
    render() {
        var menuItems = [
            { text: 'Apple Laptop' },
            { text: 'DELL Laptop' },
            { text: 'Services' },
            { text: 'Desktop' },
            { text: 'MAC Mini' },
            { text: 'Monitor' },
            { text: 'Switch' },
            { text: 'Telephone' },
            { text: 'Firewall' },
            { text: 'SSD' },
            { text: 'Mobile Device' },
            { text: 'Signed 3G/4G Network Card' }
        ];

        return (
            <Paper zDepth={1} className="page-create-asset">
                <h2>Add asset</h2>
                <DropDownMenu ref="type" menuItems={menuItems} onChange={this._handleType}/>
                <TextField ref="number" floatingLabelText="Number" onInput={this._handleNumber}/>
                <RaisedButton label="Add" onClick={this._addAsset} disabled={this.state.isDisable} />
            </Paper>
        )
    }
});

export default AddAsset