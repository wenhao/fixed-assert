'use strict';

import request from 'superagent';
import apisBuilder from '../../utils/apisBuilder';

let mock;

const endpoint = 'http://localhost:8080';

const userCreateApis = {
    getUserAssets: {
        method: 'post',
        url: '/admin/create'
    }
};

// mock the http request if not production
if (process.env.NODE_ENV == 'development' || process.env.NODE_ENV == 'test') {
    mock = require('./mock-user_creation_data')
}

/**
 * build apis from the config or add mock apis
 */
export default apisBuilder(userCreateApis, endpoint, mock);
