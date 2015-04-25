'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("Helloworld API tests", function() {
    it("should get hello world", function(done) {
        request.get(config.host + "/helloworld", {json: true})
            .then(function(res) {
                expect(res.statusCode).toBe(httpStatus.OK);
                expect(res.body).toEqual({ message : 'Hello World' });
                done();
            }).catch(utils.printErr);
    });
});