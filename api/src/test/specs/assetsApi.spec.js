'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("Assets API tests", function() {
    it("should get Json data", function(done) {
        request.get(config.host + "/assets", {json: true})
            .then(function(res) {
                expect(res.statusCode).toBe(httpStatus.OK);
                expect(res.body.name).toEqual('MacBook');
                expect(res.body.number).toEqual(1700160169);
                expect(res.body.assignedDate).toEqual(20150425);
                expect(res.body.type).toEqual('laptop');
                done();
            }).catch(utils.printErr);
    });
});