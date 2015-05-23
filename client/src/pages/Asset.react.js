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
        this._getUserAssets()
    },
    render() {
        return (
            <Paper zDepth={1} className="page-asset-list">

                <Paper zDepth={1} className="tab-group">
                    <Tabs>
                        <Tab label="My Assets" onActive={this._getUserAssets}>
                            <div className="tab-template-container asset-group">
                                {this._renderAssetHeader(false)}
                                <ul className="asset-list">
                                    {this._renderAssets(false)}
                                </ul>
                            </div>
                        </Tab>
                        <Tab label="Others Assets" onActive={this._getOthersAssets}>
                            <div className="tab-template-container asset-group">
                                {this._renderAssetHeader(true)}
                                <ul className="asset-list">
                                    {this._renderAssets(true)}
                                </ul>
                            </div>
                        </Tab>
                    </Tabs>
                </Paper>
            </Paper>
        );
    },
    _getUserAssets(userId) {
        assetApi.getUserAssets(userId).then(this.onAssetsLoad, this.onAssetsLoadFailed)
    },
    _getOthersAssets() {
        assetApi.getOthersAssets().then(this.onAssetsLoad, this.onAssetsLoadFailed);
    },
    onAssetsLoad(result) {
        console.log(result);
        this.setState({
            assets: result
        })
    },
    onAssetsLoadFailed(error) {
        //
    },
    _renderAssetHeader(showOthers) {
        var ownerHeader;
        if(showOthers) {
            ownerHeader = <li className="asset-attribute">Owner</li>;
        }
        return (
            <ul className="asset-header">
                {ownerHeader}
                <li className="asset-attribute">Name</li>
                <li className="asset-attribute">Number</li>
                <li className="asset-attribute">Assigned Date</li>
                <li className="asset-attribute">Type</li>
                <li className="asset-attribute"></li>
            </ul>
        )
    },
    _renderAssets(showOthers) {
        return this.state.assets.map(function (result) {
            var ownerItem;
            if(showOthers) {
                ownerItem = <li className="asset-attribute">{result.ownerName}</li>;
            }
            return (
                <li className="asset-item">
                    <a href="https://github.com/wenhao/fixed-asset">
                        <ul>
                            {ownerItem}
                            <li className="asset-attribute">{result.assetName}</li>
                            <li className="asset-attribute">{result.assetNumber}</li>
                            <li className="asset-attribute">{result.assignedDate}</li>
                            <li className="asset-attribute">{result.assetType}</li>
                            <li className="asset-attribute">
                                <div className="button-view-detail"><a href="https://github.com/wenhao/fixed-asset">Button</a></div>
                            </li>
                        </ul>
                    </a>
                </li>
            )
        })
    }
});

export default Asset
