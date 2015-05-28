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
                        <Tab key="0" label="My Assets" onActive={this._getUserAssets}>
                            <div className="tab-template-container asset-group">
                                {this._renderAssetHeader(false)}
                                {this._renderAssets(false)}
                            </div>
                        </Tab>
                        <Tab key="1" label="Others Assets" onActive={this._getOthersAssets}>
                            <div className="tab-template-container asset-group">
                                {this._renderAssetHeader(true)}
                                {this._renderAssets(true)}
                            </div>
                        </Tab>
                    </Tabs>
                </Paper>
            </Paper>
        );
    },
    _getUserAssets(account) {
        assetApi.getUserAssets(account).then(this.onAssetsLoad, this.onAssetsLoadFailed)
    },
    _getOthersAssets(account) {
        assetApi.getOthersAssets(account).then(this.onAssetsLoad, this.onAssetsLoadFailed);
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
            ownerHeader = <li key={0} className="asset-attribute">Owner</li>;
        }
        return (
            <ul className="asset-header">
                {ownerHeader}
                <li key={1} className="asset-attribute">Name</li>
                <li key={2} className="asset-attribute">Number</li>
                <li key={3} className="asset-attribute">Assigned Date</li>
                <li key={4} className="asset-attribute">Type</li>
            </ul>
        )
    },
    _onClick() {
        location.href = "https://github.com/wenhao/fixed-asset";
    },
    _renderAssets(showOthers) {
        var assetsList = this.state.assets.map(function (result, i) {
                var ownerItem;
                if(showOthers) {
                    ownerItem = <li key={0} className="asset-attribute">{result.account}</li>;
                }
                return (
                    <li key={i} className="asset-item" onClick={this._onClick}>
                        <ul>
                            {ownerItem}
                            <li key={1} className="asset-attribute">{result.assetName}</li>
                            <li key={2} className="asset-attribute">{result.assetNumber}</li>
                            <li key={3} className="asset-attribute">{result.assignedDate}</li>
                            <li key={4} className="asset-attribute">{result.assetType}</li>
                            <li key={5} className="asset-attribute">
                                <div className="button-view-detail">
                                    <a href="https://github.com/wenhao/fixed-asset">Button</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                )
            }.bind(this));
        return (<ul className="asset-list">
            {assetsList}
            </ul>)
    }
});

export default Asset
