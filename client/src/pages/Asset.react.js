'use strict';

import React from 'react'
import {
    RaisedButton,
    FontIcon,
    Paper,
    Tabs,Tab
    } from 'material-ui'
import {
    State
    } from 'react-router'

import assetApi from '../services/asset'

var Asset = React.createClass({

    mixins: [State],

    getInitialState() {
        return {
            title: 'User Assets',
            assets: []
        }
    },
    componentDidMount() {
        this._getAssets()
    },
    render() {
        return (
            <Paper zDepth={1} className="page-asset-list">
                <RaisedButton secondary={true} >
                    <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
                    <span className="mui-raised-button-label example-icon-button-label">Get Assets</span>
                </RaisedButton>
                <Tabs>
                    <Tab label="My Assets" onActive={this._getAssets}>
                        <div className="tab-template-container asset-group">
                            {this._renderAssetHeader()}
                            <ul className="asset-list">
                                {this._renderAssets()}
                            </ul>
                        </div>
                    </Tab>
                    <Tab label="Others Assets">
                        <div className="tab-template-container asset-group">
                            {this._renderAssetHeader()}
                            <ul className="asset-list">

                            </ul>
                        </div>
                    </Tab>
                </Tabs>
            </Paper>
        );
    },
    _getAssets(userId) {
        assetApi.getUserAssets(userId).then(this.onAssetsLoad, this.onAssetsLoadFailed)
    },
    onAssetsLoad(result) {
        console.log(result);
        this.setState({
            assets: result.body
        })
    },
    onAssetsLoadFailed(error) {
        //
    },
    _renderAssetHeader() {
        return (
            <ul className="asset-header">
                <li className="asset-attribute">Asset Name</li>
                <li className="asset-attribute">Asset Number</li>
                <li className="asset-attribute">Assigned Date</li>
                <li className="asset-attribute">Asset Type</li>
                <li className="asset-attribute"></li>
            </ul>
        )
    },
    _renderAssets() {
        return this.state.assets.map(function (result) {
            return (
                <li className="asset-item">
                    <ul>
                        <li className="asset-attribute">{result.assetName}</li>
                        <li className="asset-attribute">{result.assetNumber}</li>
                        <li className="asset-attribute">{result.assignedDate}</li>
                        <li className="asset-attribute">{result.assetType}</li>
                        <li className="asset-attribute">
                            <RaisedButton label="view" secondary={true} />
                        </li>
                    </ul>
                </li>
            )
        })
    }
});

export default Asset
