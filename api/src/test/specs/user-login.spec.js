'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("User Login API tests", function () {
    it("should login successfully when given correct account and password", function (done) {
        request.post(config.host + "/auth/login",{
            json: {"account": "test1", "password": "123456"}
        }).then(function (res) {
            expect(res.statusCode).toBe(httpStatus.OK);
            expect(res.body).toEqual({"account": "test1","password":"123456"});
            done();
        }).catch(utils.printErr);
    });
});