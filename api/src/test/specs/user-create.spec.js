'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("create user api tests", function () {
    it("should create user successfully when given name and password", function (done) {
        request.post({
            uri: config.host + "/user",
            json: {name: "jTao", password: "P@ss123456"}
        }).then(function (res) {
            expect(res.statusCode).toBe(201);
            expect(res.body).toEqual({"name": "jTao","password":"P@ss123456"});
            done();
        }).catch(utils.printErr);
    });
});