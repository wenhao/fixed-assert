'use strict';
import request from 'superagent'
import apisBuilder from '../../utils/apisBuilder'

let mock;

let endpoint = 'http://localhost:8080';

const userApis = {
  login: {
    method: 'post',
    url: '/auth/login'
  },
  logout: {
    method: 'post',
    url: '/auth/logout'
  },
  create: {
    method: 'post',
    url: '/user'
  }
};

// mock the http request if not production
if (process.env.NODE_ENV == 'development' || process.env.NODE_ENV == 'test') {
  mock = require('./mock-user')
}
if(process.env.NODE_ENV === 'production') {
  endpoint = 'http://54.223.177.169:8081';
}

/**
 * build apis from the config or add mock apis
 */
export default apisBuilder(userApis, endpoint, mock)
