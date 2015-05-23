'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("User Login API tests", function () {
    xit("should login successfully when given correct account and password", function (done) {
        request.post(config.host + "/auth/login",{
            json: {"account": "test1", "password": "123456"}
        }).then(function (res) {
            expect(res.statusCode).toBe(httpStatus.OK);
            expect(res.body).toEqual({"id":0,"account": "test1","password":"123456","assets":null});
            done();
        }).catch(utils.printErr);
    });
});