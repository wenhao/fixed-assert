import React from 'react'
import {
  RaisedButton,
  FontIcon,
  Paper
} from 'material-ui'
import {
  State
} from 'react-router'

import userApi from '../services/user'

var Assets = React.createClass({

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
      <Paper zDepth={1} >
        <ul>
          <li className="asset__attribute">Name</li>
          <li className="asset__attribute">Number</li>
          <li className="asset__attribute">Assign Date</li>
          <li className="asset__attribute">Type</li>
        </ul>
        <ul className="asset__list">
          {this._renderAssets()}
        </ul>
        <RaisedButton secondary={true} onClick={this._getAssets}>
          <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
          <span className="mui-raised-button-label example-icon-button-label">Get Assets</span>
        </RaisedButton>
      </Paper>
    );
  },
  _getAssets(userData) {
    userApi.assets(userData)
      .then(this.onAssetsLoad, this.onAssetsLoadFailed)
  },
  onAssetsLoad(assets) {
    this.setState({
      assets: assets.data
    })
  },
  onAssetsLoadFailed(err) {
    //
    //console.log("assets load failed");
  },
  _renderAssets() {
    return this.state.assets.sort(function(asset1, asset2) {
		var a = asset1.name.toLocaleLowerCase();
		var b = asset2.name.toLocaleLowerCase();
		if (a > b) {
			return 1;
		} else if (a < b) {
			return -1;
		} else {
			return 0;
		}
	}).map(function(asset) {
      return (
          <li className="asset__item">
		  <ul>
		  	<li className="asset__attribute"><a href="/#" >{asset.name}</a></li>
		  	<li className="asset__attribute">{asset.number}</li>
		  	<li className="asset__attribute">{asset.date}</li>
		  	<li className="asset__attribute">{asset.type}</li>
		  </ul>
		  </li>
      )
    })
  }
});

export default Assets
