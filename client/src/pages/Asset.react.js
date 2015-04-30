'use strict';

import React from 'react'
import {
  RaisedButton,
  FontIcon,
  Paper
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
      <Paper zDepth={1}>
        <RaisedButton secondary={true} onClick={this._getAssets}>
          <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
          <span className="mui-raised-button-label example-icon-button-label">Get Assets</span>
        </RaisedButton>
        <ul>
          <li className="asset__attribute">Name</li>
          <li className="asset__attribute">Number</li>
          <li className="asset__attribute">Assigned Date</li>
          <li className="asset__attribute">Type</li>
        </ul>
        <ul className="asset__list">
          {this._renderAssets()}
        </ul>
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
  _renderAssets() {
    return this.state.assets.map(function(result) {
      return (
        <li className="asset__item">
          <ul>
            <li className="asset__attribute"><a href="/#/asset" >{result.assetName}</a></li>
            <li className="asset__attribute">{result.assetNumber}</li>
            <li className="asset__attribute">{result.assignDate}</li>
            <li className="asset__attribute">{result.assetType}</li>
          </ul>
        </li>
      )
    })
  }
})

export default Asset
