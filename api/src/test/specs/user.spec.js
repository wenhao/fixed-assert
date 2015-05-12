'use strict';

var request = require("request-promised"),
    HttpStatus = require("http-status-codes"),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("create user api tests", function () {
    it("should create user success when given name and password", function (done) {
        request.post({
            uri: config.host + "/users",
            json: {account: "jTao", password: "P@ss123456"}
        }).then(function (res) {
            expect(res.statusCode).toBe(201);
            done();
        }).catch(utils.printErr);
    });

    it("should get conflict status code when account exist", function(done) {
        request.post({
            uri: config.host + "/users",
            json: {account: "twer", password: "123456"}
        }).then(function (res) {
            expect(res.statusCode).toBe(409);
            done();
        }).catch(utils.printErr);
    });
});