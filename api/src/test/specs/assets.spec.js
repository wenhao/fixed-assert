'use strict';

var request = require("request-promised"),
    HttpStatus = require("http-status-codes"),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

  describe("create assets api tests", function () {
    it("should create  assets success", function (done) {
        request.post({
            uri: config.host + "/asset",
            json: {type: "Apple Laptop", name: "17001176"}
        }).then(function (res) {
            expect(res.statusCode).toBe(201)
            done();
        }).catch(utils.printErr);
    });

});
