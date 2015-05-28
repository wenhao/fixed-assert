'use strict';

import request from 'superagent';
import apisBuilder from '../../utils/apisBuilder';

let mock;

let endpoint = 'http://localhost:8080';

const assetApis = {
    getUserAssets: {
        method: 'get',
        url: '/users/admin/assets' // TODO: use path param to replace sqlin
    },

    addAsset:{
        dataType: 'json',
        method: 'post',
        url: '/addAsset'
    },
    getOthersAssets: {
        method: 'get',
        url: '/users/admin/others/assets'
    }
};

// mock the http request if not production
if (process.env.NODE_ENV == 'development' || process.env.NODE_ENV == 'test') {
    mock = require('./mock-asset');
}

if(process.env.NODE_ENV === 'production') {
    endpoint = 'http://54.223.177.169:8081';
}

/**
 * build apis from the config or add mock apis
 */
export default apisBuilder(assetApis, endpoint, mock);
